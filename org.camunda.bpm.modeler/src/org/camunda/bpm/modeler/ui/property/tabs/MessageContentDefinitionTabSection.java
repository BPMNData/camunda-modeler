package org.camunda.bpm.modeler.ui.property.tabs;

import org.camunda.bpm.modeler.core.property.AbstractTabSection;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageObject;
import org.camunda.bpm.modeler.ui.property.tabs.builder.MessageContentDefinitionBuilder;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.Message;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * Tab section for selecting payload and correlation item definitions for a
 * message. These are BPMNData extensions.
 * 
 * @see MessageObject
 * @see CorrelationInformation
 * @see MessageContentDefinition
 */
public class MessageContentDefinitionTabSection extends AbstractTabSection {

  @Override
  protected Composite createCompositeForObject(Composite parent, EObject businessObject) {
    new Factory(this, parent).createCompositeForBusinessObject((Message) businessObject);
    return parent;
  }

  public static class Factory extends AbstractTabCompositeFactory<Message> {

    public Factory(GFPropertySection section, Composite parent) {
      super(section, parent);
    }

    @Override
    public Composite createCompositeForBusinessObject(Message businessObject) {
      new MessageContentDefinitionBuilder(parent, section, businessObject).create();

      return parent;
    }

  }

}
