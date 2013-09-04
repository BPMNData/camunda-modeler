package org.camunda.bpm.modeler.core.importer.handlers;

import org.camunda.bpm.modeler.core.importer.ModelImport;
import org.eclipse.bpmn2.Process;

/**
 * This class handles the import of {@link Process} objects.
 */
public class ProcessHandler extends AbstractShapeHandler<Process> {

	public ProcessHandler(ModelImport bpmn2ModelImport) {
		super(bpmn2ModelImport);
	}

}
