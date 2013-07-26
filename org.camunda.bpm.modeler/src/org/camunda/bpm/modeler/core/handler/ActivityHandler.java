package org.camunda.bpm.modeler.core.handler;

import java.util.List;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.InputOutputSpecification;

public class ActivityHandler {

  /**
   * Returns the first data input for the given activty. If none exists, a new
   * one will be created and added.
   * 
   * @param modelHandler
   */
  public static DataInput getOrCreateDataInput(Activity activity, ModelHandler modelHandler) {
    InputOutputSpecification ioSpecification = getOrCreateIoSpecification(activity, modelHandler);
    List<DataInput> dataInputs = ioSpecification.getDataInputs();
    if (dataInputs.isEmpty()) {
      dataInputs.add(modelHandler.create(DataInput.class));
    }
    return dataInputs.get(0);
  }

  private static InputOutputSpecification getOrCreateIoSpecification(Activity activity, ModelHandler modelHandler) {
    InputOutputSpecification ioSpecification = activity.getIoSpecification();
    if (ioSpecification == null) {
      ioSpecification = modelHandler.create(InputOutputSpecification.class);
      activity.setIoSpecification(ioSpecification);
    }
    return ioSpecification;
  }

}
