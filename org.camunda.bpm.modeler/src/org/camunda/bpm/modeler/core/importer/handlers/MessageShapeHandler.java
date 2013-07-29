package org.camunda.bpm.modeler.core.importer.handlers;

import org.camunda.bpm.modeler.core.importer.ModelImport;
import org.eclipse.bpmn2.Message;

public class MessageShapeHandler extends AbstractShapeHandler<Message> {

  public MessageShapeHandler(ModelImport bpmn2ModelImport) {
    super(bpmn2ModelImport);
  }

}
