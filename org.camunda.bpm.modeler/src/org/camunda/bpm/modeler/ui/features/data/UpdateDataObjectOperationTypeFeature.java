package org.camunda.bpm.modeler.ui.features.data;

import org.camunda.bpm.modeler.core.features.data.Properties;
import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.FeatureSupport;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class UpdateDataObjectOperationTypeFeature extends AbstractUpdateFeature {

	private static final String TYPE_ATTRIBUTE_NAME = "type";
    private static final EStructuralFeature PRIMARY_KEY_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_PrimaryKey();
	
	public UpdateDataObjectOperationTypeFeature(IFeatureProvider fp) {
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
		
		PrimaryKeyType pkType = (PrimaryKeyType) ExtensionUtil.getExtension(dataObject, PRIMARY_KEY_FEATURE, TYPE_ATTRIBUTE_NAME);
		String newValue = toDisplayValue(pkType);
		String previouslyDisplayedValue = null;
		
		Shape primaryKeyShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_OPERATION_TYPE_SHAPE, Boolean.toString(true));
		if (primaryKeyShape != null) {
		    AbstractText dataStateShapeText = (AbstractText) primaryKeyShape.getGraphicsAlgorithm();
			previouslyDisplayedValue = dataStateShapeText.getValue();
		}
		
		if (newValue == null) {
			return previouslyDisplayedValue != null ? Reason.createTrueReason() : Reason.createFalseReason();
		} else if (previouslyDisplayedValue == null) {
			return Reason.createTrueReason();
		}
		
		if (previouslyDisplayedValue.equals(newValue)) {
			return Reason.createFalseReason();
		} else {
			return Reason.createTrueReason();
		}
	}

	private String toDisplayValue(PrimaryKeyType pkType) {
        if (pkType == null) {
            return "";
        }
        String literal = pkType.getLiteral();
        return literal.isEmpty() ? literal : String.format("[%s]",pkType.getLiteral());
    }

    @Override
	public boolean update(IUpdateContext context) {
		ContainerShape container = (ContainerShape) context.getPictogramElement();
		DataObject dataObject = (DataObject) getBusinessObjectForPictogramElement(container);

		PrimaryKeyType currentPkType = (PrimaryKeyType) ExtensionUtil.getExtension(dataObject, PRIMARY_KEY_FEATURE, TYPE_ATTRIBUTE_NAME);
		if (currentPkType == null) {
			setPrimaryKeyType(context, PrimaryKeyType.DEFAULT);
		} else {
			setPrimaryKeyType(context, currentPkType);
		}

		return true;
	}
	
	private void setPrimaryKeyType(IUpdateContext context, PrimaryKeyType pkType) {
		Shape dataStateTextShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_OPERATION_TYPE_SHAPE, Boolean.toString(true));
		
		if (dataStateTextShape != null) {
			Text textGa = (Text) dataStateTextShape.getGraphicsAlgorithm();
			textGa.setValue(toDisplayValue(pkType));
		}
	}

}
