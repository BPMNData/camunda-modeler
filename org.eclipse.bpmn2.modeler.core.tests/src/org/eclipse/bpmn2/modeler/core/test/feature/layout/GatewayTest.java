package org.eclipse.bpmn2.modeler.core.test.feature.layout;

import static org.eclipse.bpmn2.modeler.core.layout.util.ConversionUtil.point;
import static org.eclipse.bpmn2.modeler.core.test.util.assertions.Bpmn2ModelAssertions.assertThat;
import static org.eclipse.bpmn2.modeler.core.test.util.operations.MoveFlowElementOperation.move;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.modeler.core.layout.util.LayoutUtil;
import org.eclipse.bpmn2.modeler.core.test.feature.AbstractFeatureTest;
import org.eclipse.bpmn2.modeler.core.test.util.DiagramResource;
import org.eclipse.bpmn2.modeler.core.test.util.Util;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.fest.assertions.api.Fail;
import org.junit.Test;

/**
 * 
 * @author Nico Rehwaldt
 */
public class GatewayTest extends AbstractFeatureTest {
	
	@Test
	@DiagramResource("org/eclipse/bpmn2/modeler/core/test/feature/layout/GatewayTest.testVerticalLayouting.bpmn")
	public void testVerticalLayoutingTopTwoBendpoints() {

		Shape task = Util.findShapeByBusinessObjectId(diagram, "Task_1");
		Shape gateway = Util.findShapeByBusinessObjectId(diagram, "ExclusiveGateway_1");
		FreeFormConnection flow = (FreeFormConnection) Util.findConnectionByBusinessObjectId(diagram, "SequenceFlow_1");
		
		// gateway is vertically centered above task
		
		// when moved by 30 px to the right
		move(gateway, getDiagramTypeProvider())
			.by(30, 0)
			.execute();
		
		// then two bendpoint strategy should kick in
		assertThat(flow)
			.hasNoDiagonalEdges()
			
			.hasBendpointCount(2)
			
			.anchorPointOn(task)
				.isAboveShape();
	}
	
	@Test
	@DiagramResource("org/eclipse/bpmn2/modeler/core/test/feature/layout/GatewayTest.testVerticalLayouting.bpmn")
	public void testVerticalLayoutingTopTwoBendpointsTolerance() {

		Shape task = Util.findShapeByBusinessObjectId(diagram, "Task_1");
		Shape gateway = Util.findShapeByBusinessObjectId(diagram, "ExclusiveGateway_1");
		FreeFormConnection flow = (FreeFormConnection) Util.findConnectionByBusinessObjectId(diagram, "SequenceFlow_1");
		
		// gateway is vertically centered above task
		
		// when moved by 55 px to the right
		move(gateway, getDiagramTypeProvider())
			// shape width is 100 -> mid + 55 is outside shape but still in tolerance box
			.by(55, 0)
			.execute();
		
		// then two bendpoint strategy should kick in
		assertThat(flow)
			.hasNoDiagonalEdges()
			
			.hasBendpointCount(2)
			
			.anchorPointOn(task)
				.isAboveShape();
	}
	
	@Test
	@DiagramResource("org/eclipse/bpmn2/modeler/core/test/feature/layout/GatewayTest.testVerticalLayouting.bpmn")
	public void testVerticalLayoutingTopSingleBendpoint() {

		Shape task = Util.findShapeByBusinessObjectId(diagram, "Task_1");
		Shape gateway = Util.findShapeByBusinessObjectId(diagram, "ExclusiveGateway_1");
		FreeFormConnection flow = (FreeFormConnection) Util.findConnectionByBusinessObjectId(diagram, "SequenceFlow_1");
		
		// gateway is vertically centered above task
		
		// when moved by 80 px to the right
		move(gateway, getDiagramTypeProvider())
			.by(80, 0)
			.execute();
		
		// then one point bendpoint strategy should kick in
		assertThat(flow)
			.hasNoDiagonalEdges()
			
			.hasBendpointCount(1)
			
			.anchorPointOn(task)
				.isRightOfShape();
	}
	
	@Test
	@DiagramResource("org/eclipse/bpmn2/modeler/core/test/feature/layout/GatewayTest.testVerticalLayouting.bpmn")
	public void testVerticalLayoutingBottomTwoBendpoints() {

		Shape task = Util.findShapeByBusinessObjectId(diagram, "Task_1");
		Shape gateway = Util.findShapeByBusinessObjectId(diagram, "ExclusiveGateway_2");
		FreeFormConnection flow = (FreeFormConnection) Util.findConnectionByBusinessObjectId(diagram, "SequenceFlow_2");
		
		// gateway is vertically centered above task
		
		// when moved by 30 px to the left
		move(gateway, getDiagramTypeProvider())
			.by(-30, 0)
			.execute();
		
		// then two bendpoint strategy should kick in
		assertThat(flow)
			.hasNoDiagonalEdges()
			
			.hasBendpointCount(2)
			
			.anchorPointOn(task)
				.isBeneathShape();
	}
	
	@Test
	@DiagramResource("org/eclipse/bpmn2/modeler/core/test/feature/layout/GatewayTest.testVerticalLayouting.bpmn")
	public void testVerticalLayoutingBottomTwoBendpointsTolerance() {

		Shape task = Util.findShapeByBusinessObjectId(diagram, "Task_1");
		Shape gateway = Util.findShapeByBusinessObjectId(diagram, "ExclusiveGateway_2");
		FreeFormConnection flow = (FreeFormConnection) Util.findConnectionByBusinessObjectId(diagram, "SequenceFlow_2");
		
		// gateway is vertically centered above task
		
		// when moved by 55 px to the left
		move(gateway, getDiagramTypeProvider())
			// shape width is 100 -> mid + 55 is outside shape but still in tolerance box
			.by(-55, 0)
			.execute();
		
		// then two bendpoint strategy should kick in
		assertThat(flow)
			.hasNoDiagonalEdges()
			
			.hasBendpointCount(2)
			
			.anchorPointOn(task)
				.isBeneathShape();
	}
	
	@Test
	@DiagramResource("org/eclipse/bpmn2/modeler/core/test/feature/layout/GatewayTest.testVerticalLayouting.bpmn")
	public void testVerticalLayoutingBottomSingleBendpoint() {

		Shape task = Util.findShapeByBusinessObjectId(diagram, "Task_1");
		Shape gateway = Util.findShapeByBusinessObjectId(diagram, "ExclusiveGateway_2");
		FreeFormConnection flow = (FreeFormConnection) Util.findConnectionByBusinessObjectId(diagram, "SequenceFlow_2");
		
		// gateway is vertically centered above task
		
		// when moved by 80 px to the left
		move(gateway, getDiagramTypeProvider())
			.by(-80, 0)
			.execute();
		
		// then one point bendpoint strategy should kick in
		assertThat(flow)
			.hasNoDiagonalEdges()
			
			.hasBendpointCount(1)
			
			.anchorPointOn(task)
				.isLeftOfShape();
	}
}
