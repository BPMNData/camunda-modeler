package org.camunda.bpm.modeler.core.handler;

import java.util.List;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.eclipse.bpmn2.Collaboration;
import org.eclipse.bpmn2.Conversation;
import org.eclipse.bpmn2.ConversationNode;

public class ConversationHandler {
  
  public static ConversationNode getOrCreateConversation(Collaboration collaboration, ModelHandler modelHandler) {
    List<ConversationNode> conversations = collaboration.getConversations();
    if (conversations.isEmpty()) {
      conversations.add(modelHandler.create(Conversation.class));
    }
    return conversations.get(0);
  }

}
