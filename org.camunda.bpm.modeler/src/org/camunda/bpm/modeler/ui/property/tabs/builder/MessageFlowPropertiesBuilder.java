package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.MessageFlow;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class MessageFlowPropertiesBuilder extends AbstractPropertiesBuilder<MessageFlow> {

  private static final EStructuralFeature CONDITION_EXPRESSION_FEATURE = Bpmn2Package.eINSTANCE.getSequenceFlow_ConditionExpression();

  public MessageFlowPropertiesBuilder(Composite parent, GFPropertySection section, MessageFlow bo) {
    super(parent, section, bo);
  }

  @Override
  public void create() {
    String messageText = "none";
    Message messageRef = bo.getMessageRef();
    if (messageRef != null) {
      messageText = String.format("\"%s\" (ID: %s)", messageRef.getName(), messageRef.getId());
    }
    Text text = PropertyUtil.createUnboundText(section, parent, "Message");
    text.setEnabled(false);
    text.setText(messageText);
  }
}
