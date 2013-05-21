package org.camunda.bpm.modeler.ui.features.data;

import org.camunda.bpm.modeler.core.features.data.Properties;
import org.camunda.bpm.modeler.core.utils.FeatureSupport;
import org.eclipse.bpmn2.DataState;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

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
		ContainerShape container = (ContainerShape) context.getPictogramElement();
		ItemAwareElement itemAwareElement = (ItemAwareElement) getBusinessObjectForPictogramElement(container);
		
		DataState dataState = itemAwareElement.getDataState();
		String previouslyDisplayedState = null;
		
		Shape dataStateShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_DATA_STATE_SHAPE, Boolean.toString(true));
		if (dataStateShape != null) {
			Text dataStateShapeText = (Text) dataStateShape.getGraphicsAlgorithm();
			previouslyDisplayedState = dataStateShapeText.getValue();
		}
		
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
			setDataStateText(context, "");
		} else {
			setDataStateText(context, dataState.getName());
		}

		return true;
	}
	
	/**
	 * Set the value for the first child shape that has {@link Properties}.IS_DATA_STATE_TEXT set.
	 * @param container
	 * @param value
	 */
	private void setDataStateText(IUpdateContext context, String value) {
		Shape dataStateTextShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_DATA_STATE_SHAPE, Boolean.toString(true));
		
		if (dataStateTextShape != null) {
			Text textGa = (Text) dataStateTextShape.getGraphicsAlgorithm();
			textGa.setValue(value);
		}
	}

}
