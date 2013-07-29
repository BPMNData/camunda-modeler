package org.camunda.bpm.modeler.core.handler;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.CatchEvent;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.DataInputAssociation;
import org.eclipse.bpmn2.DataOutput;
import org.eclipse.bpmn2.DataOutputAssociation;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.ThrowEvent;

/**
 * Utility class for operations on {@link DataAssociation} objects.
 * @author Sebastian
 *
 */
public class DataAssociationHandler {

  /**
   * Creates a data association between source and target. Those may be a
   * {@link ItemAwareElement} and an {@link Activity}.<br>
   * Accordingly, a {@link DataInputAssociation} or a
   * {@link DataOutputAssociation} is created.
   */
  public static DataAssociation createDataAssociation(BaseElement source, BaseElement target, ModelHandler modelHandler) {
    if (source instanceof ItemAwareElement) {
      DataInputAssociation dataAssocation = null;
      dataAssocation = modelHandler.create(DataInputAssociation.class);
      connectSource(dataAssocation, (ItemAwareElement) source);
      if (target instanceof Activity) {
        connectTarget(dataAssocation, (Activity) target, modelHandler);
      } else if (target instanceof ThrowEvent) {
        ThrowEvent throwEvent = (ThrowEvent) target;
        throwEvent.getDataInputAssociation().add((DataInputAssociation) dataAssocation);
      }
      return dataAssocation;
    }
    
    if (target instanceof ItemAwareElement) {
      DataOutputAssociation dataAssocation = modelHandler.create(DataOutputAssociation.class);
      connectTarget(dataAssocation, (ItemAwareElement) target);
      if (source instanceof Activity) {
        Activity activity = (Activity) source;
        connectSource(dataAssocation, activity, modelHandler);
      } else if (source instanceof CatchEvent) {
        CatchEvent throwEvent = (CatchEvent) source;
        throwEvent.getDataOutputAssociation().add((DataOutputAssociation) dataAssocation);
      }
      return dataAssocation;
    }
    
    throw new IllegalArgumentException("Could not create a data association from the given elements.");
  }

  /** Reconnects the association to the new target. */
  public static void connectTarget(DataAssociation association, ItemAwareElement newTarget) {
    association.setTargetRef(newTarget);
  }

  /** Reconnects the association to the new source. */
  public static void connectSource(DataAssociation association, ItemAwareElement newSource) {
    association.getSourceRef().clear();
    association.getSourceRef().add(newSource);
  }

  /**
   * Moves the association to the new activity and reconnects it to the
   * activity's input.
   */
  public static void connectTarget(DataInputAssociation association, Activity target, ModelHandler modelHandler) {
    DataInput newDataInput = ActivityHandler.getOrCreateDataInput(target, modelHandler);
    association.setTargetRef(newDataInput);

    // I think, that EMF automatically removes the old containment relation of
    // the association, so we do not need to take care of this.
    target.getDataInputAssociations().add(association);
  }

  /**
   * Moves the association to the new activity and reconnects it to the
   * activity's output.
   */
  public static void connectSource(DataOutputAssociation association, Activity source, ModelHandler modelHandler) {
    DataOutput newDataOutput = ActivityHandler.getOrCreateDataOutput(source, modelHandler);
    connectSource(association, newDataOutput);

    // I think, that EMF automatically removes the old containment relation of
    // the association, so we do not need to take care of this.
    source.getDataOutputAssociations().add(association);
  }
}
