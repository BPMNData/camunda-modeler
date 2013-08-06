package org.camunda.bpm.modeler.popup.actions;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.modeler.core.Activator;
import org.camunda.bpm.modeler.core.ModelHandler;
import org.camunda.bpm.modeler.core.ProxyURIConverterImplExtension;
import org.camunda.bpm.modeler.core.handler.ItemDefinitionHandler;
import org.camunda.bpm.modeler.core.handler.MessageHandler;
import org.camunda.bpm.modeler.core.model.Bpmn2ModelerResourceImpl;
import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.SchemaMappingImport;
import org.camunda.bpm.modeler.runtime.engine.model.util.ModelResourceFactoryImpl;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Collaboration;
import org.eclipse.bpmn2.ConversationNode;
import org.eclipse.bpmn2.CorrelationKey;
import org.eclipse.bpmn2.CorrelationProperty;
import org.eclipse.bpmn2.CorrelationPropertyRetrievalExpression;
import org.eclipse.bpmn2.DataInputAssociation;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.bpmn2.DataOutputAssociation;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.DocumentRoot;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.ReceiveTask;
import org.eclipse.bpmn2.SendTask;
import org.eclipse.bpmn2.util.Bpmn2ResourceImpl;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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

import de.unipotsdam.hpi.bpmndata.schemamapping.AttributeMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.SchemaMapping;

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
    createTransformations(bpmnResource);
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

  private void createTransformations(Bpmn2ResourceImpl bpmnResource) {
    TransformationCreator transformationCreator = new TransformationCreator(bpmnResource);
    transformationCreator.run();
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
      final String CODE_TEMPLATE = "/message/correlation/key[@name='%s']/property[@name='%s']/text()";

      String keyName = correlationKey.getName();
      String propertyName = correlationProperty.getName();
      return String.format(CODE_TEMPLATE, keyName, propertyName);
    }

  }

  private static class TransformationCreator {

    private Resource resource;
    private DocumentRoot documentRoot;
    private ModelHandler modelHandler;
    private SchemaMapping schemaMapping;

    private TransformationCreator(Resource resource) {
      this.resource = resource;
      this.documentRoot = (DocumentRoot) resource.getContents().get(0);
      this.modelHandler = ModelHandler.getInstance((Bpmn2ResourceImpl) resource);
    }

    public void run() {
      Definitions definitions = documentRoot.getDefinitions();
      if (definitions == null) {
        Activator.logWarning("No definitions found.");
      }

      SchemaMappingImport schemaMappingImport = ExtensionUtil.getExtension(definitions, BptPackage.eINSTANCE.getDocumentRoot_SchemaMappingImports());
      if (schemaMappingImport == null) {
        Activator.logWarning("No schema mapping import found.");
      }

      schemaMapping = loadSchemaMapping(schemaMappingImport);
      if (schemaMapping == null) {
        Activator.logWarning("Could not load a schema mapping");
        return;
      }

      createSendTaskTransformations(definitions);
      createReceiveTaskTransformations(definitions);
    }

    private void createSendTaskTransformations(Definitions definitions) {
      List<EObject> allReachableObjects = ModelUtil.getAllReachableObjects(definitions, Bpmn2Package.eINSTANCE.getSendTask());
      for (EObject reachableObject : allReachableObjects) {
        SendTask sendTask = (SendTask) reachableObject;
        List<DataInputAssociation> inputAssociations = sendTask.getDataInputAssociations();
        Message message = sendTask.getMessageRef();
        MessageContentDefinition contentDefinition = MessageHandler.getMessageContentDefinition(message);
        if (contentDefinition == null) {
          Activator.logWarning("No content definition found for message " + message.getId());
        }

        StringBuilder sb = new StringBuilder();
        // XXX: Validation is possible at this point...
        Map<ItemDefinition, ClassMapping> globalClass2ClassMapping = collectMappings(contentDefinition);
        for (ClassMapping classMapping : globalClass2ClassMapping.values()) {
          sb.append("let $").append(classMapping.getLocalClass()).append(" := ./DataObjects/").append(classMapping.getLocalClass()).append("\n");
        }

        sb.append("return <message name=\"").append(message.getId()).append("\">");

        createCorrelationPart(contentDefinition, sb, globalClass2ClassMapping);

        createPayloadPart(contentDefinition, sb, globalClass2ClassMapping);

        sb.append("</message>");
        System.out.println(sb.toString());
        for (DataInputAssociation inputAssociation : inputAssociations) {
          FormalExpression formalExpression = modelHandler.create(FormalExpression.class);
          formalExpression.setLanguage("XQuery");
          formalExpression.setBody(sb.toString());
          inputAssociation.setTransformation(formalExpression);
        }
      }

    }

    private void createCorrelationPart(MessageContentDefinition contentDefinition, StringBuilder sb, Map<ItemDefinition, ClassMapping> globalClass2ClassMapping) {
      sb.append("<correlation>");
      for (ItemDefinition correlationItemDefinition : MessageHandler.getCorrelationObjects(contentDefinition)) {
        List<String> correlationAttributes = ItemDefinitionHandler.getCorrelationAttributes(correlationItemDefinition);
        ClassMapping classMapping = globalClass2ClassMapping.get(correlationItemDefinition);
        sb.append("<key name=\"").append(classMapping.getGlobalClass()).append(">");
        for (AttributeMapping attributeMapping : classMapping.getAttributeMappings()) {
          if (!correlationAttributes.contains(attributeMapping.getGlobalAttribute()))
            continue;
          sb.append("<property name=\"").append(attributeMapping.getGlobalAttribute()).append("\">{$").append(classMapping.getLocalClass()).append("/")
              .append(attributeMapping.getLocalAttribute()).append("/text()}</property>");
        }
        sb.append("</key>");
      }
      sb.append("</correlation>");
    }

    private void createPayloadPart(MessageContentDefinition contentDefinition, StringBuilder sb, Map<ItemDefinition, ClassMapping> globalClass2ClassMapping) {
      ClassMapping payloadMapping = globalClass2ClassMapping.get(contentDefinition.getPayloadRef());
      sb.append("<payload><").append(payloadMapping.getGlobalClass()).append(">");
      for (AttributeMapping attributeMapping : payloadMapping.getAttributeMappings()) {
        sb.append("<").append(attributeMapping.getGlobalAttribute()).append(">{$").append(payloadMapping.getLocalClass()).append("/")
            .append(attributeMapping.getLocalAttribute()).append("/text()</").append(attributeMapping.getGlobalAttribute()).append(">");
      }
      sb.append("</payload>");
    }

    private Map<ItemDefinition, ClassMapping> collectMappings(MessageContentDefinition contentDefinition) {
      Map<ItemDefinition, ClassMapping> classMappings = new HashMap<ItemDefinition, ClassMapping>();
      for (ItemDefinition itemDefinition : MessageHandler.getCorrelationObjects(contentDefinition)) {
        ClassMapping mapping = findClassMappingByGlobalClass(itemDefinition);
        classMappings.put(itemDefinition, mapping);
      }
      return classMappings;
    }

    private ClassMapping findClassMappingByGlobalClass(ItemDefinition itemDefinition) {
      String name = ItemDefinitionHandler.getShortInterpretableName(itemDefinition);
      for (ClassMapping classMapping : schemaMapping.getClassMappings()) {
        if (classMapping.getGlobalClass().equals(name)) {
          return classMapping;
        }
      }
      return null;
    }

    private void createReceiveTaskTransformations(Definitions definitions) {
      List<EObject> allReachableObjects = ModelUtil.getAllReachableObjects(definitions, Bpmn2Package.eINSTANCE.getReceiveTask());
      for (EObject reachableObject : allReachableObjects) {
        ReceiveTask receiveTask = (ReceiveTask) reachableObject;
        List<DataOutputAssociation> outputAssociations = receiveTask.getDataOutputAssociations();
        for (DataOutputAssociation outputAssociation : outputAssociations) {
          ItemAwareElement targetRef = outputAssociation.getTargetRef();
          if (targetRef == null || !(targetRef instanceof DataObject)) {
            Activator.logWarning("Expected a data object as target for data association " + outputAssociation.getId());
            continue;
          }
          // XXX: Since we did not (yet) apply item definitions, we assume, that
          // the data object's name corresponds to the item definition name.
          // This assumption should hold for valid models.
          String localClassName = ((DataObject) targetRef).getName();
          ClassMapping classMapping = findClassMappingByLocalClass(localClassName);
    
          StringBuilder sb = new StringBuilder();
          sb.append("let $msg := ./message/payload/").append(classMapping.getGlobalClass()).append("\n");
          sb.append("return <").append(classMapping.getLocalClass()).append(">");
          for (AttributeMapping attributeMapping : classMapping.getAttributeMappings()) {
            sb.append("<").append(attributeMapping.getLocalAttribute()).append(">{$msg/").append(attributeMapping.getGlobalAttribute()).append("/text()}</")
                .append(attributeMapping.getLocalAttribute()).append(">");
          }
          sb.append("</").append(classMapping.getLocalClass()).append(">");
          System.out.println(sb.toString());
          FormalExpression formalExpression = modelHandler.create(FormalExpression.class);
          formalExpression.setLanguage("XQuery");
          formalExpression.setBody(sb.toString());
          outputAssociation.setTransformation(formalExpression);
        }
      }
    }

    private ClassMapping findClassMappingByLocalClass(String localClassName) {
      for (ClassMapping classMapping : schemaMapping.getClassMappings()) {
        if (classMapping.getLocalClass().equals(localClassName)) {
          return classMapping;
        }
      }
      return null;
    }

    private SchemaMapping loadSchemaMapping(SchemaMappingImport schemaMappingImport) {
      try {
        ResourceSet resourceSet = resource.getResourceSet();
        Resource schemaMappingResource = resourceSet.createResource(URI.createPlatformResourceURI(schemaMappingImport.getLocation(), true));
        schemaMappingResource.load(Collections.emptyMap());
        EList<EObject> contents = schemaMappingResource.getContents();
        SchemaMapping schemaMapping = (SchemaMapping) contents.get(0);
        return schemaMapping;
      } catch (Exception e) {
        Activator.logError(e);
        return null;
      }
    }
  }
}
