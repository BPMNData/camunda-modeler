package org.camunda.bpm.modeler.ui.property.tabs;

import java.util.List;

import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.ui.property.tabs.builder.BoundaryEventDefinitionComposite;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ErrorDefinitionPropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.MessageDefinitionPropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.SignalDefinitionPropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.TimerEventDefinitionPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.ErrorEventDefinition;
import org.eclipse.bpmn2.Event;
import org.eclipse.bpmn2.EventDefinition;
import org.eclipse.bpmn2.MessageEventDefinition;
import org.eclipse.bpmn2.SignalEventDefinition;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.TimerEventDefinition;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * Event tab composite factory
 * 
 * @author nico.rehwaldt
 */
public class EventTabCompositeFactory extends AbstractTabCompositeFactory<Event> {
	
	public EventTabCompositeFactory(GFPropertySection section, Composite parent) {
		super(section, parent);
	}
	
	@Override
	public Composite createCompositeForBusinessObject(Event event) {
		
		List<EventDefinition> eventDefinitions = ModelUtil.getEventDefinitions(event);

		ErrorEventDefinition errorDef = getEventDefinition(ErrorEventDefinition.class, eventDefinitions);
		MessageEventDefinition messageDef = getEventDefinition(MessageEventDefinition.class, eventDefinitions);
		TimerEventDefinition timerDef = getEventDefinition(TimerEventDefinition.class, eventDefinitions);
		SignalEventDefinition signalDef = getEventDefinition(SignalEventDefinition.class, eventDefinitions);
		
		if (errorDef == null && event instanceof StartEvent) {
			PropertyUtil.createText(section, parent, "Initiator", ModelPackage.eINSTANCE.getDocumentRoot_Initiator(), event);
		}
		
		if (timerDef != null) {
			createTimerDefinitionComposite(timerDef);
		}
		
		if (messageDef != null) {
			createMessageDefinitionComposite(messageDef);
		}

		if (errorDef != null) {
			createErrorDefinitionComposite(errorDef);
		}
		
		if (signalDef != null) {
			createSignalDefinitionComposite(signalDef);
		}
		
		if (event instanceof BoundaryEvent) {
			createBoundaryEventComposite((BoundaryEvent) event);
		}
		return parent;
	}

	private void createBoundaryEventComposite(BoundaryEvent event) {
		new BoundaryEventDefinitionComposite(parent, section, event).create();
	}

	private <T extends EventDefinition> T getEventDefinition(Class<T> cls, List<EventDefinition> eventDefinitions) {
		for (EventDefinition eventDefinition : eventDefinitions) {
			if (cls.isInstance(eventDefinition)) {
				return cls.cast(eventDefinition);
			}
		}
		
		return null;
	}

	private void createSignalDefinitionComposite(SignalEventDefinition signalDef) {
		new SignalDefinitionPropertyBuilder(parent, section, signalDef).create();
	}
	
	private void createErrorDefinitionComposite(ErrorEventDefinition errorDef) {
		new ErrorDefinitionPropertyBuilder(parent, section, errorDef).create();
	}
	
	private void createTimerDefinitionComposite(TimerEventDefinition eventDefinition) {
		new TimerEventDefinitionPropertiesBuilder(parent, section, eventDefinition).create();
	}
	
	private void createMessageDefinitionComposite(MessageEventDefinition messageDef) {
		new MessageDefinitionPropertyBuilder(parent, section, messageDef).create();
	}
}
