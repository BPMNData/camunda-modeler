package org.camunda.bpm.modeler.core.handler;

import java.util.List;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.eclipse.bpmn2.Collaboration;
import org.eclipse.bpmn2.Conversation;
import org.eclipse.bpmn2.ConversationNode;

/**
 * This class offers some utility functions related to {@link Conversation}
 * objects.
 */
public class ConversationHandler {

  /**
   * Returns any existing {@link ConversationNode} that belongs to the
   * {@link Collaboration}. If none exists, a new one is created, added, and
   * returned.
   */
  public static ConversationNode getOrCreateConversation(Collaboration collaboration, ModelHandler modelHandler) {
    List<ConversationNode> conversations = collaboration.getConversations();
    if (conversations.isEmpty()) {
      conversations.add(modelHandler.create(Conversation.class));
    }
    return conversations.get(0);
  }

}
