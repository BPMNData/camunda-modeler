package org.camunda.bpm.modeler.core.handler;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.Message;

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
   * Gather the correlation object from a {@link MessageContentDefinition} object.
   */
  public static List<ItemDefinition> getCorrelationObjects(MessageContentDefinition contentDefinition) {
    List<ItemDefinition> itemDefinitions = new ArrayList<ItemDefinition>(2);
    for (ItemDefinitionLink link : contentDefinition.getCorrelationIdentifierLinks()) {
      itemDefinitions.add(link.getRef());
    }
    return itemDefinitions;
  }

}
