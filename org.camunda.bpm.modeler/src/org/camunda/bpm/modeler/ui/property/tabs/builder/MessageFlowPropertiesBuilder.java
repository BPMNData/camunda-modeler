package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.MessageFlow;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Builds the {@link MessageFlow} specific part of the property panel.<br>
 * Only displays the ID of the linked {@link Message}.
 */
public class MessageFlowPropertiesBuilder extends AbstractPropertiesBuilder<MessageFlow> {

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
