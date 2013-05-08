package org.camunda.bpm.modeler.ui.features.data;

import org.camunda.bpm.modeler.core.features.data.Properties;
import org.eclipse.bpmn2.DataState;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;

public class UpdateDataStateFeature extends AbstractUpdateFeature {

	public UpdateDataStateFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object o = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return o != null && o instanceof ItemAwareElement;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		IPeService peService = Graphiti.getPeService();
		ContainerShape container = (ContainerShape) context.getPictogramElement();
		ItemAwareElement itemAwareElement = (ItemAwareElement) getBusinessObjectForPictogramElement(container);
		String previouslyDisplayedState = peService.getPropertyValue(container,	Properties.DATA_STATE);
		
		DataState dataState = itemAwareElement.getDataState();
		
		if (dataState == null) {
			return previouslyDisplayedState != null ? Reason.createTrueReason() : Reason.createFalseReason();
		} else if (previouslyDisplayedState == null) {
			return Reason.createTrueReason();
		}
		
		if (previouslyDisplayedState.equals(dataState.getName())) {
			return Reason.createFalseReason();
		} else {
			return Reason.createTrueReason();
		}
	}

	@Override
	public boolean update(IUpdateContext context) {
		
		ContainerShape container = (ContainerShape) context.getPictogramElement();
		ItemAwareElement itemAwareElement = (ItemAwareElement) getBusinessObjectForPictogramElement(container);

		DataState dataState = itemAwareElement.getDataState();
		if (dataState == null) {
			setDataStateText(container, "");
		} else {
			setDataStateText(container, dataState.getName());
		}

		return true;
	}
	
	/**
	 * Set the value for any child shape that has {@link Properties}.IS_DATA_STATE_TEXT set.
	 * @param container
	 * @param value
	 */
	private void setDataStateText(ContainerShape container, String value) {
		IPeService peService = Graphiti.getPeService();
		for (Shape shape : peService.getAllContainedShapes(container)) {
			GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
			String isDataStateText = peService.getPropertyValue(ga, Properties.IS_DATA_STATE_TEXT);
			if (isDataStateText != null && new Boolean(isDataStateText)) {
				Text textGa = (Text) ga;
				textGa.setValue(value);
			}
		}
	}

}
