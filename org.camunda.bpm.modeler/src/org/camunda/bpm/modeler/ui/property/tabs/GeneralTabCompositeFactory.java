package org.camunda.bpm.modeler.ui.property.tabs;

import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ActivityPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.CallActivityPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.DataAssociationPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.DataObjectPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.DecisionGatewayPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.IdPropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ItemAwareElementPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.LanePropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.MessageFlowPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.NamePropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ParticipantPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ProcessIdPropertyBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ProcessPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.RetryEnabledPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ScriptTaskPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.SequenceFlowPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ServiceTaskPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ServiceTypeControlsPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.StartEventPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.SubProcessPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.TextAnnotationPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.UserTaskPropertiesBuilder;
import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.AdHocSubProcess;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.BusinessRuleTask;
import org.eclipse.bpmn2.CallActivity;
import org.eclipse.bpmn2.CatchEvent;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.bpmn2.Event;
import org.eclipse.bpmn2.EventDefinition;
import org.eclipse.bpmn2.ExclusiveGateway;
import org.eclipse.bpmn2.Gateway;
import org.eclipse.bpmn2.InclusiveGateway;
import org.eclipse.bpmn2.IntermediateCatchEvent;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.Lane;
import org.eclipse.bpmn2.ManualTask;
import org.eclipse.bpmn2.MessageFlow;
import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.ScriptTask;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.SubProcess;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.TextAnnotation;
import org.eclipse.bpmn2.TimerEventDefinition;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * General tab composite factory
 * 
 * @author nico.rehwaldt
 */
public class GeneralTabCompositeFactory extends AbstractTabCompositeFactory<BaseElement> {

  public GeneralTabCompositeFactory(GFPropertySection section, Composite parent) {
    super(section, parent);
  }

  @Override
  public Composite createCompositeForBusinessObject(BaseElement businessObject) {
    createIdField((BaseElement) businessObject);
    createNameField((BaseElement) businessObject);

    if (businessObject instanceof Participant) {
      Participant participant = (Participant) businessObject;
      createParticipantComposite(participant);
    }

    if (businessObject instanceof Task) {
      createTaskComposite((Task) businessObject);
    }

    if (businessObject instanceof Activity) {
      createActivityComposite((Activity) businessObject);
    }

    if (businessObject instanceof Event) {
      createEventComposite((Event) businessObject);
    }

    if (businessObject instanceof SequenceFlow) {
      createSequenceFlowComposite((SequenceFlow) businessObject);
    }

    if (businessObject instanceof TextAnnotation) {
      createTextAnnotationComposite((TextAnnotation) businessObject);
    }

    if (businessObject instanceof Lane) {
      createLaneComposite((Lane) businessObject);
    }

    if (businessObject instanceof Process) {
      createProcessComposite((Process) businessObject);
    }

    if (businessObject instanceof Gateway) {
      createGatewayComposite((Gateway) businessObject);
    }

    if (businessObject instanceof ItemAwareElement) {
      createItemAwareElementComposite((ItemAwareElement) businessObject);
    }

    if (businessObject instanceof DataObject) {
      createDataObjectComposite((DataObject) businessObject);
    }

    if (businessObject instanceof DataAssociation) {
      createDataAssociationComposite((DataAssociation) businessObject);
    }

    if (businessObject instanceof MessageFlow) {
      createMessageFlowComposite((MessageFlow) businessObject);
    }

    return parent;
  }

  private void createDataObjectComposite(DataObject dataObject) {
    new DataObjectPropertiesBuilder(parent, section, dataObject).create();
  }

  private void createItemAwareElementComposite(ItemAwareElement itemAwareElement) {
    new ItemAwareElementPropertiesBuilder(parent, section, itemAwareElement).create();
  }

  private void createParticipantComposite(Participant participant) {
    new ParticipantPropertiesBuilder(parent, section, participant).create();
  }

  private void createLaneComposite(Lane lane) {
    new LanePropertiesBuilder(parent, section, lane).create();
  }

  private void createTimerCatchEventComposite(CatchEvent bo) {
    new RetryEnabledPropertiesBuilder(parent, section, bo).create();
  }

  private void createGatewayComposite(Gateway gateway) {
    if (gateway instanceof ExclusiveGateway) {
      new DecisionGatewayPropertiesBuilder(parent, section, gateway).create();
    }

    if (gateway instanceof InclusiveGateway) {
      new DecisionGatewayPropertiesBuilder(parent, section, gateway).create();
    }
  }

  private void createSequenceFlowComposite(SequenceFlow sequenceFlow) {
    new SequenceFlowPropertiesBuilder(parent, section, sequenceFlow).create();
  }

  private void createTextAnnotationComposite(TextAnnotation annotation) {
    new TextAnnotationPropertiesBuilder(parent, section, annotation).create();
  }

  private void createProcessComposite(Process process) {
    new ProcessPropertiesBuilder(parent, section, process).create();
  }

  private void createActivityComposite(Activity activity) {
    if (!(activity instanceof ManualTask) && !(activity instanceof AdHocSubProcess)) {
      new ActivityPropertiesBuilder(parent, section, activity).create();
    }

    if (activity instanceof CallActivity) {
      new CallActivityPropertiesBuilder(parent, section, (CallActivity) activity).create();
    }

    if (activity instanceof SubProcess) {
      new SubProcessPropertiesBuilder(parent, section, (SubProcess) activity).create();
    }
  }

  private boolean isTimerEvent(CatchEvent e) {
    EventDefinition timerEventDefinition = ModelUtil.getEventDefinition(e, TimerEventDefinition.class);
    return timerEventDefinition != null;
  }

  private void createTaskComposite(Task task) {

    if (task instanceof ServiceTask || task instanceof BusinessRuleTask) {
      new ServiceTypeControlsPropertiesBuilder(parent, section, task).create();
    }

    if (task instanceof UserTask) {
      new UserTaskPropertiesBuilder(parent, section, (UserTask) task).create();
    } else

    if (task instanceof ScriptTask) {
      new ScriptTaskPropertiesBuilder(parent, section, (ScriptTask) task).create();
    } else

    if (task instanceof ServiceTask || task instanceof BusinessRuleTask) {
      new ServiceTaskPropertiesBuilder(parent, section, task).create();
    }
  }

  private void createEventComposite(Event event) {
    if (event instanceof StartEvent) {
      new StartEventPropertiesBuilder(parent, section, (StartEvent) event).create();
    }

    if (event instanceof IntermediateCatchEvent || event instanceof BoundaryEvent) {
      CatchEvent catchEvent = (CatchEvent) event;
      if (isTimerEvent(catchEvent)) {
        createTimerCatchEventComposite(catchEvent);
      }
    }
  }

  // default fields (ID / Name) ///////////////////////////////////

  private void createNameField(BaseElement baseElement) {
    new NamePropertyBuilder(parent, section, baseElement).create();
  }

  private void createIdField(BaseElement baseElement) {
    if (baseElement instanceof Process) {
      new ProcessIdPropertyBuilder(parent, section, (Process) baseElement).create();
    } else {
      new IdPropertyBuilder(parent, section, baseElement).create();
    }
  }

  // BPMN Data extension: make extensions editable
  private void createDataAssociationComposite(DataAssociation businessObject) {
    new DataAssociationPropertiesBuilder(parent, section, businessObject).create();
  }

  // BPMN Data addition
  private void createMessageFlowComposite(MessageFlow businessObject) {
    new MessageFlowPropertiesBuilder(parent, section, businessObject).create();
  }
}
