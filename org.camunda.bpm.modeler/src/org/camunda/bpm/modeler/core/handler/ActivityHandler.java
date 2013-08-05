package org.camunda.bpm.modeler.core.handler;

import java.util.List;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.DataOutput;
import org.eclipse.bpmn2.InputOutputSpecification;
import org.eclipse.bpmn2.InputSet;
import org.eclipse.bpmn2.OutputSet;

/**
 * Implements some utility methods for {@link Activity} objects.
 */
public class ActivityHandler {

  /**
   * Returns the first data input for the given activity. If none exists, a new
   * one will be created and added.
   */
  public static DataInput getOrCreateDataInput(Activity activity, ModelHandler modelHandler) {
    InputOutputSpecification ioSpecification = getOrCreateIoSpecification(activity, modelHandler);
    List<DataInput> dataInputs = ioSpecification.getDataInputs();
    if (dataInputs.isEmpty()) {
      dataInputs.add(modelHandler.create(DataInput.class));
    }
    return dataInputs.get(0);
  }

  /**
   * Returns the first data output for the given activity. If none exists, a new
   * one will be created and added.
   */
  public static DataOutput getOrCreateDataOutput(Activity activity, ModelHandler modelHandler) {
    InputOutputSpecification ioSpecification = getOrCreateIoSpecification(activity, modelHandler);
    List<DataOutput> dataOutputs = ioSpecification.getDataOutputs();
    if (dataOutputs.isEmpty()) {
      dataOutputs.add(modelHandler.create(DataOutput.class));
    }
    return dataOutputs.get(0);
  }

  /**
   * Gets or creates the {@link InputOutputSpecification} of the given activity.
   */
  private static InputOutputSpecification getOrCreateIoSpecification(Activity activity, ModelHandler modelHandler) {
    InputOutputSpecification ioSpecification = activity.getIoSpecification();
    if (ioSpecification == null) {
      ioSpecification = modelHandler.create(InputOutputSpecification.class);
      InputSet inputSet = modelHandler.create(InputSet.class);
      ioSpecification.getInputSets().add(inputSet);
      OutputSet outputSet = modelHandler.create(OutputSet.class);
      ioSpecification.getOutputSets().add(outputSet);
      activity.setIoSpecification(ioSpecification);
    }
    return ioSpecification;
  }

}
