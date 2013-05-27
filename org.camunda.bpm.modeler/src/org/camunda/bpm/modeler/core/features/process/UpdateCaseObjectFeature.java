package org.camunda.bpm.modeler.core.features.process;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.FeatureSupport;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.SubProcess;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.services.GraphitiUi;

public class UpdateCaseObjectFeature extends AbstractUpdateFeature {

	private static final EStructuralFeature SCOPE_INFORMATION_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_ScopeInformation();
	private static final String CASE_OBJECT_ATTRIBUTE = "caseObject";
	
	public UpdateCaseObjectFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object o = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return o != null && (o instanceof Process || o instanceof SubProcess);
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		Shape container = (Shape) context.getPictogramElement();
		BaseElement process = (BaseElement) getBusinessObjectForPictogramElement(container);

		String caseObject = (String) ExtensionUtil.getExtension(process, SCOPE_INFORMATION_FEATURE, CASE_OBJECT_ATTRIBUTE);
		String previouslyDisplayedCaseObject = null;
		
		Shape caseObjectShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_CASE_OBJECT_SHAPE, Boolean.toString(true));
		
		if (caseObjectShape == null) {
		    return Reason.createFalseReason();
			if (previouslyDisplayedCaseObject != null) {
				String regex = Properties.CASE_OBJECT_PREFIX + "(.*)";
				previouslyDisplayedCaseObject = previouslyDisplayedCaseObject.replaceAll(regex, "$1");
			}
		}
		Text caseObjectShapeText = (Text) caseObjectShape.getGraphicsAlgorithm();
		previouslyDisplayedCaseObject = caseObjectShapeText.getValue();
		
		if (caseObject == null) {
			return previouslyDisplayedCaseObject != null && !previouslyDisplayedCaseObject.isEmpty() ? Reason.createTrueReason() : Reason.createFalseReason();
		} else if (previouslyDisplayedCaseObject == null || previouslyDisplayedCaseObject.isEmpty()) {
			return Reason.createTrueReason();
		}
		
		if (previouslyDisplayedCaseObject.equals(caseObject)) {
			return Reason.createFalseReason();
		} else {
			return Reason.createTrueReason();
		}
	}

	@Override
	public boolean update(IUpdateContext context) {
		PictogramElement pe = context.getPictogramElement();
		BaseElement process = (BaseElement) getBusinessObjectForPictogramElement(pe);

		String currentCaseObject = (String) ExtensionUtil.getExtension(process, SCOPE_INFORMATION_FEATURE, CASE_OBJECT_ATTRIBUTE);
		if (currentCaseObject == null) {
			setCaseObjectText(context, "");
		} else {
			setCaseObjectText(context, Properties.CASE_OBJECT_PREFIX + currentCaseObject);
		}

		return true;
	}
	
	private void setCaseObjectText(IUpdateContext context, String value) {
		Shape caseObjectTextShape = FeatureSupport.getChildShapeFulfillingProperty(context, Properties.IS_CASE_OBJECT_SHAPE, Boolean.toString(true));
		if (caseObjectTextShape != null) {
			Text textGa = (Text) caseObjectTextShape.getGraphicsAlgorithm();
			IDimension textDimensions = GraphitiUi.getUiLayoutService().calculateTextSize(value, textGa.getFont());
			textGa.setHeight(textDimensions.getHeight());
			textGa.setWidth(textDimensions.getWidth());
			textGa.setValue(value);
		}
	}

}
