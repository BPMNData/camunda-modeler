/******************************************************************************* 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * camunda services GmbH - initial API and implementation 
 *
 ******************************************************************************/
package org.eclipse.bpmn2.modeler.core.test.importer.collaboration;

import static org.eclipse.bpmn2.modeler.core.test.assertions.Bpmn2ModelAssertions.assertThat;
import static org.eclipse.bpmn2.modeler.core.test.assertions.Bpmn2ModelAssertions.elementOfType;
import static org.fest.assertions.api.Assertions.assertThat;

import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.modeler.core.importer.ModelImport;
import org.eclipse.bpmn2.modeler.core.test.importer.AbstractImportBpmn2ModelTest;
import org.eclipse.bpmn2.modeler.core.test.util.DiagramResource;
import org.eclipse.bpmn2.modeler.core.test.util.TestUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Nico Rehwaldt
 */
public class ImportCollaborationTest extends AbstractImportBpmn2ModelTest {
	
	@Test
	@DiagramResource
	public void testImportNoLanes() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();

		System.out.println(TestUtil.toDetailsString(diagram));
		
		EList<Shape> children = diagram.getChildren();
		assertThat(children).hasSize(2);
		
		Shape pool1 = children.get(0);
		Shape pool2 = children.get(1);

		assertThat(pool1)
			.isContainerShape()
			.isLinkedTo(elementOfType(Participant.class));
		
		assertThat(pool2)
			.isContainerShape()
			.isLinkedTo(elementOfType(Participant.class));
	}

	@Test
	@DiagramResource
	public void testImportNoLanesFlowNodes() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();

		EList<Shape> children = diagram.getChildren();
		assertThat(children).hasSize(2);
		
		Shape pool1 = children.get(0);
		Shape pool2 = children.get(1);

		assertThat(pool1)
			.isContainerShape()
			.isLinkedTo(elementOfType(Participant.class));
		
		assertThat(pool2)
			.isContainerShape()
			.isLinkedTo(elementOfType(Participant.class));
	}
	
	@Test
	@DiagramResource
	public void testImportNestedLanes() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();

		EList<Shape> children = diagram.getChildren();
		assertThat(children).hasSize(2);
	}

	@Test
	@DiagramResource
	public void testImportCollapsedPool() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();

		EList<Shape> children = diagram.getChildren();
		assertThat(children).hasSize(2);
	}

	@Test
	@DiagramResource
	public void testImportCollapsedPoolProcess() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();

		EList<Shape> children = diagram.getChildren();
		assertThat(children).hasSize(2);
		
		Shape pool1 = children.get(0);
		Shape pool2 = children.get(1);
	}
	
	@Test
	@DiagramResource
	public void testImportNestedLanesFlowNodes() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();

		EList<Shape> children = diagram.getChildren();
		assertThat(children).hasSize(2);

		Shape pool1 = children.get(0);
		Shape pool2 = children.get(1);
	}

	@Test
	@DiagramResource
	public void testImportNestedLanesUnreferencedFlowNodes() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();
		
		EList<Shape> children = diagram.getChildren();
		
		// Unreferenced nodes are supposed to be drawn on the participant
		assertThat(children).hasSize(2);

		// Assert that unreferenced flow nodes are in the diagram
		assertThat(TestUtil.toDetailsString(diagram))
			.contains("UserTask_2")
			.contains("EndEvent_1");
	}
	
	@Test
	@DiagramResource
	public void testImportLanes() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();

		EList<Shape> children = diagram.getChildren();
		assertThat(children).hasSize(2);
	}
	
	@Test
	@DiagramResource
	public void testImportLanesFlowNodes() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();
		
		EList<Shape> children = diagram.getChildren();
		assertThat(children).hasSize(2);
	}

	@Test
	@DiagramResource
	public void testImportLanesUnreferencedFlowNodes() {
		ModelImport importer = new ModelImport(diagramTypeProvider, resource);
		importer.execute();

		EList<Shape> children = diagram.getChildren();
		
		// Unreferenced nodes are supposed to be drawn on the participant
		assertThat(children).hasSize(2);
		
		// Assert that unreferenced flow nodes are in the diagram
		assertThat(TestUtil.toDetailsString(diagram))
			.contains("EndEvent_1");
	}
}
