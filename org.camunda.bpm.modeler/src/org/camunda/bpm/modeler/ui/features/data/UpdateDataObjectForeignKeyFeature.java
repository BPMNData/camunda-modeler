package org.camunda.bpm.modeler.ui.features.data;

import java.util.List;

import org.camunda.bpm.modeler.core.features.data.Properties;
import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.FeatureSupport;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ForeignKey;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class UpdateDataObjectForeignKeyFeature extends AbstractUpdateFeature {

	private static final String FOREIGN_KEY_PREFIX = "fk: ";
	
	public UpdateDataObjectForeignKeyFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object o = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return o != null && o instanceof DataObject;
	}
	
	private String foreignKeysToString(List<ForeignKey> list) {
		StringBuilder builder = new StringBuilder();
		int i = 0;
		for (ForeignKey fk : list) {
			builder.append(fk.getValue());
			if (i + 1 != list.size()) {
				builder.append(", ");
			}
			
			i++;
		}
		return builder.toString();
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		ContainerShape container = (ContainerShape) context.getPictogramElement();
		DataObject dataObject = (DataObject) getBusinessObjectForPictogramElement(container);
		
		List<ForeignKey> currentForeignKeys = ExtensionUtil.getExtensions(dataObject, ForeignKey.class);
		String currentForeignKeysAsString = foreignKeysToString(currentForeignKeys);
		String previouslyDisplayedKeys = null;
		
		Shape foreignKeyShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_FOREIGN_KEY_SHAPE, Boolean.toString(true));
		if (foreignKeyShape != null) {
		    AbstractText foreignKeysShapeText = (AbstractText) foreignKeyShape.getGraphicsAlgorithm();
			String regex = FOREIGN_KEY_PREFIX + "(.*)";
			previouslyDisplayedKeys = foreignKeysShapeText.getValue().replaceAll(regex, "$1");
		}
		
		if (currentForeignKeys.isEmpty()) {
			return previouslyDisplayedKeys != null ? Reason.createTrueReason() : Reason.createFalseReason();
		} else if (previouslyDisplayedKeys == null) {
			return Reason.createTrueReason();
		}
		
		if (previouslyDisplayedKeys.equals(currentForeignKeysAsString)) {
			return Reason.createFalseReason();
		} else {
			return Reason.createTrueReason();
		}
	}

	@Override
	public boolean update(IUpdateContext context) {
		ContainerShape container = (ContainerShape) context.getPictogramElement();
		DataObject dataObject = (DataObject) getBusinessObjectForPictogramElement(container);

		List<ForeignKey> currentForeignKeys = ExtensionUtil.getExtensions(dataObject, ForeignKey.class);
		if (currentForeignKeys.isEmpty()) {
			setPrimaryKeyText(context, "");
		} else {
			setPrimaryKeyText(context, FOREIGN_KEY_PREFIX + foreignKeysToString(currentForeignKeys));
		}

		return true;
	}
	
	private void setPrimaryKeyText(IUpdateContext context, String value) {
		Shape foreignKeysTextShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_FOREIGN_KEY_SHAPE, Boolean.toString(true));
		
		if (foreignKeysTextShape != null) {
		    AbstractText textGa = (AbstractText) foreignKeysTextShape.getGraphicsAlgorithm();
			textGa.setValue(value);
		}
	}

}
