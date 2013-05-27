package org.camunda.bpm.modeler.core.features.process;

import org.camunda.bpm.modeler.core.features.AbstractAddBpmnElementFeature;
import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.StyleUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.eclipse.bpmn2.Process;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.services.GraphitiUi;

public class AddProcessFeature extends AbstractAddBpmnElementFeature<Process, ContainerShape> {

	private static final EStructuralFeature SCOPE_INFORMATION_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_ScopeInformation();
	private static final String CASE_OBJECT_ATTRIBUTE = "caseObject";
	
	private static final int CASE_OBJECT_OFFSET = 5;
	
	public AddProcessFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return true;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		IGaService gaService = Graphiti.getGaService();
		IPeService peService = Graphiti.getPeService();
		
		Process process = getBusinessObject(context);
		ContainerShape newShape = peService.createContainerShape(context.getTargetContainer(), true);
		Rectangle invisibleRect = gaService.createInvisibleRectangle(newShape);
		gaService.setLocationAndSize(invisibleRect, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		String caseObject = (String) ExtensionUtil.getExtension(process, SCOPE_INFORMATION_FEATURE, CASE_OBJECT_ATTRIBUTE);
		
		Shape shape = peService.createShape(newShape, false);
	    Text text = gaService.createText(shape);
	    StyleUtil.applyStyle(text, process);
	    text.setVerticalAlignment(Orientation.ALIGNMENT_LEFT);
	    text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
	    
	    if (caseObject != null) {
	    	caseObject = Properties.CASE_OBJECT_PREFIX + caseObject;
	    } else {
	    	caseObject = "";
	    }
	    
	    IDimension textDimensions = GraphitiUi.getUiLayoutService().calculateTextSize(caseObject, text.getFont());
	    text.setHeight(textDimensions.getHeight());
	    text.setWidth(textDimensions.getWidth());
	    text.setValue(caseObject);
	    shape.setVisible(true);
	    gaService.setLocation(text, CASE_OBJECT_OFFSET, 5);
	    
	    peService.setPropertyValue(shape, Properties.IS_CASE_OBJECT_SHAPE, Boolean.toString(true));
		
	    link(newShape, process);
	    
		return newShape;
	}


}
