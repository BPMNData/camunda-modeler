package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.ImportUtil;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelAttributeComboBinding;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.Message;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Builds the property panel that allows to modify the BPMN Data extension
 * {@link MessageContentDefinition} for a message.
 * 
 * @author Sebastian
 */
public class MessageContentDefinitionBuilder extends AbstractPropertiesBuilder<Message> implements SelectionListener {

  private static final EReference MESSAGE_CONTENT_DEFINTION_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_MessageContentDefinition();

  private Button useCheckbox;

  private MessageContentDefinition cachedContentDef;

  private CCombo payloadDropDown;
  private ItemDefinitionComboBinding payloadBinding;

  private CCombo ciDropDown;
  private ItemDefinitionComboBinding ciBinding;

  public MessageContentDefinitionBuilder(Composite parent, GFPropertySection section, Message businessObject) {
    super(parent, section, businessObject);
  }

  @Override
  public void create() {
    // Always cache the content definition, so its state is not lost, in case
    // the user
    // unintentionally detaches it from the message.
    cachedContentDef = getOrMessageContentDefinition(bo);

    // ...controls
    useCheckbox = PropertyUtil.createUnboundCheckbox(section, parent, "Enabled");
    useCheckbox.addSelectionListener(this);

    payloadDropDown = PropertyUtil.createDropDown(section, parent, "Payload");
    payloadBinding = new PayloadComboBinding();
    payloadBinding.establish();

    ciDropDown = PropertyUtil.createDropDown(section, parent, "Correlation Identifier");
    ciBinding = new CorrelationIdentifierComboBinding();
    ciBinding.establish();

    boolean isContentDefDetached = getMessageContentDefinitions(bo).isEmpty();
    useCheckbox.setSelection(!isContentDefDetached);
    setControlsEnabled(!isContentDefDetached);
  }

  private abstract class ItemDefinitionComboBinding extends ModelAttributeComboBinding<ItemDefinition> {

    public static final String NO_CONTENT_DEF_NAME = "(none)";

    protected Map<ItemDefinition, String> itemDefinitionNames;

    protected ItemDefinition selectedItemDefinition;

    public ItemDefinitionComboBinding(EStructuralFeature feature, CCombo dropDown) {
      super(cachedContentDef, feature, dropDown);

      itemDefinitionNames = new HashMap<ItemDefinition, String>();
      Definitions definitions = (Definitions) bo.eContainer();
      List<ItemDefinition> itemDefinitions = ModelUtil.getAllRootElements(definitions, ItemDefinition.class);
      for (ItemDefinition itemDefinition : itemDefinitions) {
        if (isSelected(itemDefinition)) {
          ImportUtil.resolveStructureDefinitionProxy(itemDefinition);
          Object structureRef = itemDefinition.getStructureRef();
          String name = itemDefinition.getId();
          if (structureRef != null && structureRef instanceof StructureDefinition) {
            name = createName(itemDefinition, structureRef);
          }
          itemDefinitionNames.put(itemDefinition, name);
        }
      }

      selectedItemDefinition = getModelValue();
      String selectedItemDefName = toString(selectedItemDefinition);
      control.add(NO_CONTENT_DEF_NAME);
      int index = 1;
      for (String itemDefName : itemDefinitionNames.values()) {
        control.add(itemDefName);
        if (itemDefName.equals(selectedItemDefName))
          control.select(index);
        index++;
      }
    }

    protected abstract String createName(ItemDefinition itemDefinition, Object structureRef);

    protected abstract boolean isSelected(ItemDefinition itemDefinition);

    @Override
    protected String toString(ItemDefinition itemDefinition) {
      if (itemDefinition == null)
        return NO_CONTENT_DEF_NAME;
      String name = itemDefinitionNames.get(itemDefinition);
      if (name == null) {
        return "(unknown item definition: " + itemDefinition + ")";
      }
      return name;
    }

    @Override
    protected ItemDefinition fromString(String string) {
      for (Map.Entry<ItemDefinition, String> entry : itemDefinitionNames.entrySet()) {
        if (entry.getValue().equals(string))
          return entry.getKey();
      }
      return null;
    }

    @Override
    public void setModelValue(final ItemDefinition value) {
      selectedItemDefinition = value;

      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
      if (editingDomain == null)
        doSetModelValue(value);
      else {
        editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

          @Override
          protected void doExecute() {
            doSetModelValue(value);
            setCorrelationIdentifiers();
          }
        });
      }

    }

    protected abstract void doSetModelValue(ItemDefinition value);

    @Override
    protected void establishModelViewBinding() {
      // We cannot establish a model-view binding, since there is no stable
      // editing domain for this MessageContentDefintion.
    }

  }

  private void setCorrelationIdentifiers() {
    cachedContentDef.getCorrelationIdentifierLinks().clear();
    addCorrelationIdentifierLink(payloadBinding.selectedItemDefinition);
    addCorrelationIdentifierLink(ciBinding.selectedItemDefinition);
  }

  private void addCorrelationIdentifierLink(ItemDefinition itemDefinition) {
    if (itemDefinition == null)
      return;

    List<Object> correlationInfo = ExtensionUtil.getExtensions(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_CorrelationInformation());
    if (!correlationInfo.isEmpty()) {
      ItemDefinitionLink link = BptFactory.eINSTANCE.createItemDefinitionLink();
      link.setRef(itemDefinition);
      cachedContentDef.getCorrelationIdentifierLinks().add(link);
    }
  }

  private class PayloadComboBinding extends ItemDefinitionComboBinding {

    public PayloadComboBinding() {
      super(BptPackage.eINSTANCE.getMessageContentDefinition_PayloadRef(), payloadDropDown);
    }

    @Override
    protected String createName(ItemDefinition itemDefinition, Object structureRef) {
      return ((StructureDefinition) structureRef).getQname();
    }

    @Override
    public ItemDefinition getModelValue() {
      return ((MessageContentDefinition) model).getPayloadRef();
    }

    @Override
    protected void doSetModelValue(ItemDefinition value) {
      MessageContentDefinition messageContentDefinition = (MessageContentDefinition) model;
      messageContentDefinition.setPayloadRef(value);
    }

    @Override
    protected boolean isSelected(ItemDefinition itemDefinition) {
      Object msgObjectExtension = ExtensionUtil.getExtension(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_MessageObject());
      return msgObjectExtension != null;
    }

  }

  private class CorrelationIdentifierComboBinding extends ItemDefinitionComboBinding {

    public CorrelationIdentifierComboBinding() {
      super(BptPackage.eINSTANCE.getMessageContentDefinition_PayloadRef(), ciDropDown);
    }

    @Override
    protected String createName(ItemDefinition itemDefinition, Object structureRef) {
      String name = ((StructureDefinition) structureRef).getQname() + " (";
      String separator = "";
      List<Object> correlationInfos = ExtensionUtil.getExtensions(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_CorrelationInformation());
      for (Object o : correlationInfos) {
        CorrelationInformation correlationInfo = (CorrelationInformation) o;
        name += separator + correlationInfo.getAttributeName();
        separator = ", ";
      }
      name += ")";
      return name;
    }

    @Override
    public ItemDefinition getModelValue() {
      MessageContentDefinition contentDefinition = (MessageContentDefinition) model;
      ItemDefinition payloadDef = contentDefinition.getPayloadRef();
      EList<ItemDefinitionLink> ciLinks = contentDefinition.getCorrelationIdentifierLinks();
      for (ItemDefinitionLink ciLink : ciLinks) {
        ItemDefinition ciDef = ciLink.getRef();
        if (ciDef != payloadDef) // We should be allowed to assume identity
                                 // here.
          return ciDef;
      }
      return null;
    }

    @Override
    protected boolean isSelected(ItemDefinition itemDefinition) {
      Object extension = ExtensionUtil.getExtension(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_CorrelationInformation());
      return extension != null;
    }

    @Override
    protected void doSetModelValue(ItemDefinition value) {
    }

  }

  /**
   * Return any existing {@link MessageContentDefinition} object associated to
   * the <code>message</code>. If there is none, create a new one.
   */
  private MessageContentDefinition getOrMessageContentDefinition(Message message) {
    List<MessageContentDefinition> contentDefs = getMessageContentDefinitions(message);
    MessageContentDefinition contentDef;
    if (contentDefs.isEmpty())
      contentDef = BptFactory.eINSTANCE.createMessageContentDefinition();
    else
      contentDef = contentDefs.get(0);
    return contentDef;
  }

  /**
   * Return all the {@link MessageContentDefinition} objects associated to the
   * <code>message</code>.<br>
   * There should be at most one such object.
   */
  private List<MessageContentDefinition> getMessageContentDefinitions(Message message) {
    List<MessageContentDefinition> contentDefs = ExtensionUtil.getExtensions(message, MessageContentDefinition.class);
    if (contentDefs.size() > 1)
      Logger.getAnonymousLogger().warning("There is more than one primary key for " + message);
    return contentDefs;
  }

  @Override
  public void widgetSelected(SelectionEvent e) {
    boolean isSelected = ((Button) e.widget).getSelection();
    if (isSelected) {
      this.attachMessageContentDefinition();
    } else {
      this.detachMessageContentDefintion();
    }

    setControlsEnabled(isSelected);
  }

  private void setControlsEnabled(boolean enable) {
    payloadDropDown.setEnabled(enable);
    ciDropDown.setEnabled(enable);
  }

  @Override
  public void widgetDefaultSelected(SelectionEvent e) {
    this.widgetSelected(e);
  }

  /**
   * Attaches the cachedContentDef to the message.
   */
  private void attachMessageContentDefinition() {
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
    editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

      @Override
      protected void doExecute() {
        // Remove any content definition at first to ensure consistency.
        ExtensionUtil.removeExtensionByFeature(bo, MESSAGE_CONTENT_DEFINTION_FEATURE);

        // Now attach it.
        ExtensionUtil.addExtension(bo, MESSAGE_CONTENT_DEFINTION_FEATURE, cachedContentDef);
      }
    });
  }

  /**
   * Attaches the cachedContentDef to the message.
   */
  private void detachMessageContentDefintion() {
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
    editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

      @Override
      protected void doExecute() {
        ExtensionUtil.removeExtensionByFeature(bo, MESSAGE_CONTENT_DEFINTION_FEATURE);
      }
    });
  }
}
