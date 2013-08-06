package org.camunda.bpm.modeler.core.handler;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition;
import org.eclipse.bpmn2.InteractionNode;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.MessageFlow;
import org.eclipse.bpmn2.ReceiveTask;
import org.eclipse.bpmn2.SendTask;

/**
 * Implements some utility methods for {@link Message} objects.
 */
public class MessageHandler {

  /**
   * Retrieve the BPMNData extension: {@link MessageContentDefinition}.
   */
  public static MessageContentDefinition getMessageContentDefinition(Message message) {
    return ExtensionUtil.getExtension(message, BptPackage.eINSTANCE.getDocumentRoot_MessageContentDefinition());
  }

  /**
   * Gather the correlation object from a {@link MessageContentDefinition}
   * object.
   */
  public static List<ItemDefinition> getCorrelationObjects(MessageContentDefinition contentDefinition) {
    List<ItemDefinition> itemDefinitions = new ArrayList<ItemDefinition>(2);
    for (ItemDefinitionLink link : contentDefinition.getCorrelationIdentifierLinks()) {
      itemDefinitions.add(link.getRef());
    }
    return itemDefinitions;
  }
  
  /**
   * Applies the message to a message flow and its connected tasks.
   */
  public static void applyTo(Message message, MessageFlow messageFlow) {
    messageFlow.setMessageRef(message);
    ensureTaskMessageRefs(messageFlow);
  }

  /**
   * Ensures that the tasks connected by this message flow have the message ref
   * property correctly set.<br>
   * <i>Notice: For the sake of ease, we do not care about tasks that are not
   * associated with a message flow. They still might have a message ref set,
   * which, thus, is not valid anymore. On the other hand, such unconnected
   * tasks are already incorrectly modeled.
   */
  public static void ensureTaskMessageRefs(MessageFlow messageFlow) {
    Message messageRef = messageFlow.getMessageRef();
    InteractionNode sourceRef = messageFlow.getSourceRef();
    ensureTaskMessageRef(sourceRef, messageRef);
    InteractionNode targetRef = messageFlow.getTargetRef();
    ensureTaskMessageRef(targetRef, messageRef);
  }
  
  private static void ensureTaskMessageRef(InteractionNode interactionNode, Message messageRef) {
    if (interactionNode != null) {
      if (interactionNode instanceof SendTask) {
        ((SendTask) interactionNode).setMessageRef(messageRef);
      } else if (interactionNode instanceof ReceiveTask) {
        ((ReceiveTask) interactionNode).setMessageRef(messageRef);
      }
    }
  }

}
