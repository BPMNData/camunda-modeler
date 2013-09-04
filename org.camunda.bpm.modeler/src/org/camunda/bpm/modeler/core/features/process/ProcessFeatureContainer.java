package org.camunda.bpm.modeler.core.features.process;

import org.camunda.bpm.modeler.core.features.container.BaseElementFeatureContainer;
import org.eclipse.bpmn2.Process;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;

/**
 * The feature container for {@link Process} objects.
 */
public class ProcessFeatureContainer extends BaseElementFeatureContainer {

	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return null;
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddProcessFeature(fp);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		return new UpdateCaseObjectFeature(fp);
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(IFeatureProvider fp) {
		return null;
	}

	@Override
	public IMoveShapeFeature getMoveFeature(IFeatureProvider fp) {
	  // We do not allow moving.
		return new NullFeature();
	}

	@Override
	public IResizeShapeFeature getResizeFeature(IFeatureProvider fp) {
		return null;
	}

	@Override
	public IDeleteFeature getDeleteFeature(IFeatureProvider fp) {
	  // We do not allow deletion.
		return new NullFeature();
	}
	
	@Override
	public IRemoveFeature getRemoveFeature(IFeatureProvider fp) {
	  // We do not allow deletion.
		return new NullFeature();
	}

}
