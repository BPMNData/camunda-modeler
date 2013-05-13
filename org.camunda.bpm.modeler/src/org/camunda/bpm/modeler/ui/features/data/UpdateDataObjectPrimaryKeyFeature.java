package org.camunda.bpm.modeler.ui.features.data;

import org.camunda.bpm.modeler.core.features.data.Properties;
import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.FeatureSupport;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.bpmn2.DataState;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class UpdateDataObjectPrimaryKeyFeature extends AbstractUpdateFeature {

	private static final EStructuralFeature PRIMARY_KEY_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_PrimaryKey();
	
	public UpdateDataObjectPrimaryKeyFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object o = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return o != null && o instanceof DataObject;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		ContainerShape container = (ContainerShape) context.getPictogramElement();
		DataObject dataObject = (DataObject) getBusinessObjectForPictogramElement(container);
		
		String currentPrimaryKey = (String) ExtensionUtil.getExtension(dataObject, PRIMARY_KEY_FEATURE, "value");
		String previouslyDisplayedState = null;
		
		Shape primaryKeyShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_PRIMARY_KEY_SHAPE, Boolean.toString(true));
		if (primaryKeyShape != null) {
			Text dataStateShapeText = (Text) primaryKeyShape.getGraphicsAlgorithm();
			previouslyDisplayedState = dataStateShapeText.getValue();
		}
		
		if (currentPrimaryKey == null) {
			return previouslyDisplayedState != null ? Reason.createTrueReason() : Reason.createFalseReason();
		} else if (previouslyDisplayedState == null) {
			return Reason.createTrueReason();
		}
		
		if (previouslyDisplayedState.equals(currentPrimaryKey)) {
			return Reason.createFalseReason();
		} else {
			return Reason.createTrueReason();
		}
	}

	@Override
	public boolean update(IUpdateContext context) {
		ContainerShape container = (ContainerShape) context.getPictogramElement();
		DataObject dataObject = (DataObject) getBusinessObjectForPictogramElement(container);

		String currentPrimaryKey = (String) ExtensionUtil.getExtension(dataObject, PRIMARY_KEY_FEATURE, "value");
		if (currentPrimaryKey == null) {
			setPrimaryKeyText(context, "");
		} else {
			setPrimaryKeyText(context, currentPrimaryKey);
		}

		return true;
	}
	
	private void setPrimaryKeyText(IUpdateContext context, String value) {
		Shape dataStateTextShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_PRIMARY_KEY_SHAPE, Boolean.toString(true));
		
		if (dataStateTextShape != null) {
			Text textGa = (Text) dataStateTextShape.getGraphicsAlgorithm();
			textGa.setValue(value);
		}
	}

}
