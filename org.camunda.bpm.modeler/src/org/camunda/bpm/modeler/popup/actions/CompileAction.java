package org.camunda.bpm.modeler.popup.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.modeler.core.Activator;
import org.camunda.bpm.modeler.core.ModelHandler;
import org.camunda.bpm.modeler.core.ProxyURIConverterImplExtension;
import org.camunda.bpm.modeler.core.handler.ItemDefinitionHandler;
import org.camunda.bpm.modeler.core.handler.MessageHandler;
import org.camunda.bpm.modeler.core.model.Bpmn2ModelerResourceImpl;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition;
import org.camunda.bpm.modeler.runtime.engine.model.util.ModelResourceFactoryImpl;
import org.eclipse.bpmn2.Collaboration;
import org.eclipse.bpmn2.ConversationNode;
import org.eclipse.bpmn2.CorrelationKey;
import org.eclipse.bpmn2.CorrelationProperty;
import org.eclipse.bpmn2.CorrelationPropertyRetrievalExpression;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.DocumentRoot;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.util.Bpmn2ResourceImpl;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class CompileAction implements IObjectActionDelegate {

  private Shell shell;

  private IFile file;

  /**
   * Constructor for Action1.
   */
  public CompileAction() {
    super();
  }

  /**
   * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
   */
  public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    shell = targetPart.getSite().getShell();
  }

  /**
   * @see IActionDelegate#run(IAction)
   */
  public void run(IAction action) {
    if (file == null) {
      MessageDialog.openInformation(shell, "camunda modeler", "Select a .bpmn file first.");
      return;
    }

    Bpmn2ResourceImpl bpmnResource = loadBpmnResource();
    createCorrelationKeys(bpmnResource);
    saveBpmnResource(bpmnResource);
  }

  private void saveBpmnResource(Bpmn2ResourceImpl bpmnResource) {
    IPath path = file.getFullPath();
    String fileExtension = path.getFileExtension();
    path = path.removeFileExtension();
    String lastSegment = path.lastSegment();
    path = path.removeLastSegments(1).append(lastSegment + ".compiled").addFileExtension(fileExtension);
    URI fileUri = URI.createPlatformResourceURI(path.toString(), false);
    bpmnResource.setURI(fileUri);
    try {
      bpmnResource.save(null);
    } catch (IOException e) {
      throw new RuntimeException("Could not save the compiled resource: " + fileUri, e);
    }
  }

  private Bpmn2ResourceImpl loadBpmnResource() {
    URI fileUri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
    ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put(Bpmn2ModelerResourceImpl.BPMN2_CONTENT_TYPE_ID, new ModelResourceFactoryImpl());
    Bpmn2ResourceImpl bpmnResource = (Bpmn2ResourceImpl) resourceSet.createResource(fileUri, Bpmn2ModelerResourceImpl.BPMN2_CONTENT_TYPE_ID);

    resourceSet.setURIConverter(new ProxyURIConverterImplExtension());
    try {
      bpmnResource.load(null);
    } catch (IOException e) {
      throw new RuntimeException("Could not load file: " + fileUri, e);
    }

    // Resolve structure definition proxies.
    DocumentRoot documentRoot = (DocumentRoot) bpmnResource.getContents().get(0);
    Definitions definitions = documentRoot.getDefinitions();
    if (definitions != null) {
      List<ItemDefinition> itemDefinitions = ModelUtil.getAllRootElements(definitions, ItemDefinition.class);
      for (ItemDefinition itemDefinition : itemDefinitions) {
        ItemDefinitionHandler.resolveStructureDefinitionProxy(itemDefinition, false);
      }
    }

    return bpmnResource;
  }

  private void createCorrelationKeys(Bpmn2ResourceImpl bpmnResource) {
    CorrelationKeyCreator correlationKeyCreator = new CorrelationKeyCreator(bpmnResource);
    correlationKeyCreator.run();
  }

  /**
   * @see IActionDelegate#selectionChanged(IAction, ISelection)
   */
  public void selectionChanged(IAction action, ISelection selection) {
    this.file = null;
    if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
      IStructuredSelection structuredSelection = (IStructuredSelection) selection;
      Object firstElement = structuredSelection.getFirstElement();
      if (firstElement instanceof IFile)
        this.file = (IFile) firstElement;
    }
  }

  private class CorrelationKeyCreator {

    private Resource resource;
    private DocumentRoot documentRoot;
    Map<String, CorrelationKey> itemDef2CorrelationKey;
    private ModelHandler modelHandler;

    public CorrelationKeyCreator(Resource resource) {
      this.resource = resource;
      this.documentRoot = (DocumentRoot) resource.getContents().get(0);
      this.itemDef2CorrelationKey = new HashMap<String, CorrelationKey>();
      this.modelHandler = ModelHandler.getInstance((Bpmn2ResourceImpl) resource);
    }

    public void run() {
      Definitions definitions = documentRoot.getDefinitions();

      ConversationNode conversation = getConversation(definitions);
      if (conversation == null)
        return;

      createCorrelationKeys(definitions, conversation);
      applyCorrelationKeys(definitions);
    }

    private ConversationNode getConversation(Definitions definitions) {
      // We assume that there is exactly one collaboration with a conversation
      List<Collaboration> collaborations = ModelUtil.getAllRootElements(definitions, Collaboration.class);
      if (collaborations.isEmpty()) {
        Activator.logStatus(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "No collaboration found for " + resource.getURI()));
        return null;
      }
      Collaboration collaboration = collaborations.get(0);
      List<ConversationNode> conversations = collaboration.getConversations();
      if (conversations.isEmpty()) {
        Activator.logStatus(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "No conversation found for " + resource.getURI()));
        return null;
      }
      ConversationNode conversation = conversations.get(0);
      return conversation;
    }

    private void createCorrelationKeys(Definitions definitions, ConversationNode conversation) {
      // Go through all the item definitions and create a correlation key where
      // applicable.
      List<ItemDefinition> itemDefinitions = ModelUtil.getAllRootElements(definitions, ItemDefinition.class);
      for (ItemDefinition itemDefinition : itemDefinitions) {
        List<String> correlationAttributes = ItemDefinitionHandler.getCorrelationAttributes(itemDefinition);
        if (!correlationAttributes.isEmpty()) {
          CorrelationKey correlationKey = createCorrelationKey(definitions, itemDefinition, correlationAttributes);
          conversation.getCorrelationKeys().add(correlationKey);
          itemDef2CorrelationKey.put(itemDefinition.getId(), correlationKey);
        }
      }
    }

    private CorrelationKey createCorrelationKey(Definitions definitions, ItemDefinition itemDefinition, List<String> correlationAttributes) {
      CorrelationKey correlationKey = modelHandler.create(CorrelationKey.class);
      String name = ItemDefinitionHandler.getCorrelationKeyName(itemDefinition);
      correlationKey.setName(name);

      List<CorrelationProperty> correlationPropertyRef = correlationKey.getCorrelationPropertyRef();
      for (String correlationAttribute : correlationAttributes) {
        CorrelationProperty correlationProperty = modelHandler.create(CorrelationProperty.class);
        correlationProperty.setName(correlationAttribute);
        definitions.getRootElements().add(correlationProperty);
        correlationPropertyRef.add(correlationProperty);
      }
      return correlationKey;
    }

    private void applyCorrelationKeys(Definitions definitions) {
      // Go through all messages and add correlation keys where applicable.
      List<Message> messages = ModelUtil.getAllRootElements(definitions, Message.class);
      for (Message message : messages) {
        MessageContentDefinition messageContentDefinition = MessageHandler.getMessageContentDefinition(message);
        if (messageContentDefinition != null) {
          List<ItemDefinition> correlationObjects = MessageHandler.getCorrelationObjects(messageContentDefinition);
          for (ItemDefinition correlationObject : correlationObjects) {
            String itemDefintionId = correlationObject.getId();
            CorrelationKey correlationKey = itemDef2CorrelationKey.get(itemDefintionId);
            for (CorrelationProperty correlationProperty : correlationKey.getCorrelationPropertyRef()) {
              applyCorrelationProperty(message, correlationKey, correlationProperty);
            }
          }

        }
      }
    }

    private void applyCorrelationProperty(Message message, CorrelationKey correlationKey, CorrelationProperty correlationProperty) {
      CorrelationPropertyRetrievalExpression retrievalExpression = modelHandler.create(CorrelationPropertyRetrievalExpression.class);
      retrievalExpression.setMessageRef(message);
      FormalExpression formalExpression = modelHandler.create(FormalExpression.class);
      formalExpression.setLanguage("XPath");
      formalExpression.setBody(createXPathRetrievalCode(correlationKey, correlationProperty));
      retrievalExpression.setMessagePath(formalExpression);
      correlationProperty.getCorrelationPropertyRetrievalExpression().add(retrievalExpression);
    }

    private String createXPathRetrievalCode(CorrelationKey correlationKey, CorrelationProperty correlationProperty) {
      final String CODE_TEMPLATE = "/message/correlation/key[name=\"%s\"]/property[name=\"%s\"]";

      String keyName = correlationKey.getName();
      String propertyName = correlationProperty.getName();
      return String.format(CODE_TEMPLATE, keyName, propertyName);
    }

  }

}
