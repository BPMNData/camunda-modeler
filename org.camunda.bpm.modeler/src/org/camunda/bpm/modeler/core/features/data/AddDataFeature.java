/******************************************************************************* 
 * Copyright (c) 2011 Red Hat, Inc. 
 *  All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 *
 * @author Ivar Meikas
 ******************************************************************************/
package org.camunda.bpm.modeler.core.features.data;

import org.camunda.bpm.modeler.core.features.AbstractAddBpmnShapeFeature;
import org.camunda.bpm.modeler.core.utils.FeatureSupport;
import org.camunda.bpm.modeler.core.utils.GraphicsUtil;
import org.camunda.bpm.modeler.core.utils.StyleUtil;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.datatypes.IRectangle;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;

public abstract class AddDataFeature<T extends ItemAwareElement> extends AbstractAddBpmnShapeFeature<T> {

	public AddDataFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		boolean intoDiagram = context.getTargetContainer().equals(getDiagram());
		boolean intoLane = FeatureSupport.isTargetLane(context) && FeatureSupport.isTargetLaneOnTop(context);
		boolean intoParticipant = FeatureSupport.isTargetParticipant(context);
		boolean intoSubProcess = FeatureSupport.isTargetSubProcess(context);
		return intoDiagram || intoLane || intoParticipant || intoSubProcess;
	}

	@Override
	protected ContainerShape createPictogramElement(IAddContext context, IRectangle bounds) {
		IGaService gaService = Graphiti.getGaService();
		IPeService peService = Graphiti.getPeService();
		
		@SuppressWarnings("unchecked")
		T t = getBusinessObject(context);

		int width = bounds.getWidth();
		int height = bounds.getHeight();
		int e = 10;
		
		ContainerShape newShape = peService.createContainerShape(context.getTargetContainer(), true);
		Rectangle invisibleRect = gaService.createInvisibleRectangle(newShape);
		gaService.setLocationAndSize(invisibleRect, context.getX(), context.getY(), width, height);

		Shape rectShape = peService.createShape(newShape, false);
		Polygon rect = gaService.createPolygon(rectShape, new int[] { 0, 0, width - e, 0, width, e, width, height, 0,
				height });
		rect.setLineWidth(1);
		StyleUtil.applyStyle(rect,t);
		decorate(rect);

		int p = width - e - 1;
		Polyline edge = gaService.createPolyline(rect, new int[] { p, 0, p, e + 1, width, e + 1 });
		edge.setForeground(manageColor(StyleUtil.CLASS_FOREGROUND));
		edge.setLineWidth(1);
		
		// create (empty) data state shape
		Shape textShape = createTextShape(newShape, t, 0, getDefaultHeight() * 5 / 8, getDefaultWidth(), 20);
		peService.setPropertyValue(textShape, Properties.IS_DATA_STATE_SHAPE, Boolean.toString(true));
		
		// create primary key shape
		Shape primaryKeyShape = createTextShape(newShape, t, 0, getDefaultHeight() / 2, getDefaultWidth(), 20);
		peService.setPropertyValue(primaryKeyShape, Properties.IS_PRIMARY_KEY_SHAPE, Boolean.toString(true));
		
		
		if (isSupportCollectionMarkers()) {
			int markerHeight = getDefaultHeight() / 6;
			int singleMarkerOffset = getDefaultWidth()  / 18;
			
			int whalf = width / 2;
			createCollectionShape(newShape, new int[] { whalf - singleMarkerOffset, height - markerHeight, whalf - singleMarkerOffset, height });
			createCollectionShape(newShape, new int[] { whalf, height - markerHeight, whalf, height });
			createCollectionShape(newShape, new int[] { whalf + singleMarkerOffset, height - markerHeight, whalf + singleMarkerOffset, height });

			String value = "false";
			EStructuralFeature feature = ((EObject)t).eClass().getEStructuralFeature("isCollection");
			if (feature!=null && t.eGet(feature)!=null)
				value = ((Boolean)t.eGet(feature)).toString();

			peService.setPropertyValue(newShape, Properties.COLLECTION_PROPERTY, value);
		}
		
		return newShape;
	}
	
	private Shape createTextShape(ContainerShape container, T businessObject, int x, int y, int width, int height) {
		IGaService gaService = Graphiti.getGaService();
		IPeService peService = Graphiti.getPeService();
		
		Shape shape = peService.createShape(container, false);
		Text text = gaService.createText(shape);
		StyleUtil.applyStyle(text, businessObject);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		shape.setVisible(true);
		gaService.setLocationAndSize(text, x, y, width, height);
		
		return shape;
	}
	
	
	private Shape createCollectionShape(ContainerShape container, int[] xy) {
		int lineWidth = getDefaultWidth()  / 36;
		
		IPeService peService = Graphiti.getPeService();
		IGaService gaService = Graphiti.getGaService();
		Shape collectionShape = peService.createShape(container, false);
		Polyline line = gaService.createPolyline(collectionShape, xy);
		line.setForeground(manageColor(StyleUtil.CLASS_FOREGROUND));
		line.setLineWidth(lineWidth);
		line.setLineVisible(false);
		peService.setPropertyValue(collectionShape, Properties.HIDEABLE_PROPERTY, Boolean.toString(true));
		return collectionShape;
	}

	@Override
	public int getDefaultHeight() {
		return GraphicsUtil.DATA_HEIGHT;
	}

	@Override
	public int getDefaultWidth() {
		return GraphicsUtil.DATA_WIDTH;
	}

	@Override
	protected boolean isCreateExternalLabel() {
		return true;
	}
	
	protected void decorate(Polygon p) {
	}

	protected boolean isSupportCollectionMarkers() {
		return true;
	}
	
	public abstract String getName(T t);
}