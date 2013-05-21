package org.camunda.bpm.modeler.ui.features.data;

import org.camunda.bpm.modeler.core.features.data.Properties;
import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.FeatureSupport;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.eclipse.bpmn2.DataObject;
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
	private static final String PRIMARY_KEY_PREFIX = "pk: ";
	
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
		String previouslyDisplayedKey = null;
		
		Shape primaryKeyShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_PRIMARY_KEY_SHAPE, Boolean.toString(true));
		if (primaryKeyShape != null) {
			Text primaryKeyShapeText = (Text) primaryKeyShape.getGraphicsAlgorithm();
			previouslyDisplayedKey = primaryKeyShapeText.getValue();
			String regex = PRIMARY_KEY_PREFIX + "(.*)";
			previouslyDisplayedKey = previouslyDisplayedKey.replaceAll(regex, "$1");
		}
		
		if (currentPrimaryKey == null) {
			return previouslyDisplayedKey != null ? Reason.createTrueReason() : Reason.createFalseReason();
		} else if (previouslyDisplayedKey == null) {
			return Reason.createTrueReason();
		}
		
		if (previouslyDisplayedKey.equals(currentPrimaryKey)) {
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
			setPrimaryKeyText(context, PRIMARY_KEY_PREFIX + currentPrimaryKey);
		}

		return true;
	}
	
	private void setPrimaryKeyText(IUpdateContext context, String value) {
		Shape primaryKeyTextShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_PRIMARY_KEY_SHAPE, Boolean.toString(true));
		
		if (primaryKeyTextShape != null) {
			Text textGa = (Text) primaryKeyTextShape.getGraphicsAlgorithm();
			textGa.setValue(value);
		}
	}

}
