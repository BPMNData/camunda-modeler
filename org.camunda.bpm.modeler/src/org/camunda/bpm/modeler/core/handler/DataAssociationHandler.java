package org.camunda.bpm.modeler.core.handler;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.CatchEvent;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.DataInputAssociation;
import org.eclipse.bpmn2.DataOutputAssociation;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.ThrowEvent;

public class DataAssociationHandler {

  /**
   * Creates a data association between source and target. Those may be a
   * {@link ItemAwareElement} and an {@link Activity}.<br>
   * Accordingly, a {@link DataInputAssociation} or a
   * {@link DataOutputAssociation} is created.
   */
  public static DataAssociation createDataAssociation(BaseElement source, BaseElement target, ModelHandler modelHandler) {
    DataAssociation dataAssocation = null;
    if (source instanceof ItemAwareElement) {
      dataAssocation = modelHandler.create(DataInputAssociation.class);
      dataAssocation.getSourceRef().add((ItemAwareElement) source);
      if (target instanceof Activity) {
        Activity activity = (Activity) target;
        activity.getDataInputAssociations().add((DataInputAssociation) dataAssocation);
        dataAssocation.setTargetRef(ActivityHandler.getOrCreateDataInput(activity, modelHandler));
      } else if (target instanceof ThrowEvent) {
        ThrowEvent throwEvent = (ThrowEvent) target;
        throwEvent.getDataInputAssociation().add((DataInputAssociation) dataAssocation);
      }
    } else if (target instanceof ItemAwareElement) {
      dataAssocation = modelHandler.create(DataOutputAssociation.class);
      dataAssocation.setTargetRef((ItemAwareElement) target);
      if (source instanceof Activity) {

        Activity activity = (Activity) source;
        activity.getDataOutputAssociations().add((DataOutputAssociation) dataAssocation);
      } else if (source instanceof CatchEvent) {
        CatchEvent throwEvent = (CatchEvent) source;
        throwEvent.getDataOutputAssociation().add((DataOutputAssociation) dataAssocation);
      }
    }
    return dataAssocation;
  }

  public static void reconnectSource(DataAssociation association, ItemAwareElement newSource) {
    association.getSourceRef().clear();
    association.getSourceRef().add(newSource);
  }

  public static void reconnectTarget(DataInputAssociation association, Activity target, ModelHandler modelHandler) {
    DataInput newDataInput = ActivityHandler.getOrCreateDataInput(target, modelHandler);
    association.setTargetRef(newDataInput);
    // I think, that EMF automatically removes the old containment relation of
    // the association, so we do not need to take care of this.
    target.getDataInputAssociations().add(association);
  }
}
