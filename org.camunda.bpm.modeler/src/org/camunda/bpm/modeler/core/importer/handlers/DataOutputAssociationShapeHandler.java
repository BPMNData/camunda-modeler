/******************************************************************************* 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * camunda services GmbH - initial API and implementation 
 *
 ******************************************************************************/

package org.camunda.bpm.modeler.core.importer.handlers;

import java.util.List;

import org.camunda.bpm.modeler.core.importer.ModelImport;
import org.camunda.bpm.modeler.core.importer.UnmappedElementException;
import org.camunda.bpm.modeler.core.importer.UnsupportedFeatureException;
import org.eclipse.bpmn2.DataOutputAssociation;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.di.BPMNEdge;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * 
 * @author Nico Rehwaldt
 */
public class DataOutputAssociationShapeHandler extends DataAssociationShapeHandler<DataOutputAssociation> {

	public DataOutputAssociationShapeHandler(ModelImport bpmn2ModelImport) {
		super(bpmn2ModelImport);
	}
	
	@Override
	protected PictogramElement handleEdge(DataOutputAssociation bpmnElement, BPMNEdge edge, ContainerShape container) {

		List<ItemAwareElement> sourceRefs = bpmnElement.getSourceRef();

		// we do not employ targetRef as it opens a whole host of new issues
		// refer to spec 
		// * Figure 10.50 - ItemAware class diagram
		// * Figure 10.57 - InputOutputSpecification class diagram
		
		ItemAwareElement targetRef = bpmnElement.getTargetRef();

		if (targetRef == null || targetRef.eIsProxy()) {
			modelImport.logAndThrow(new UnsupportedFeatureException("Target reference not specified", bpmnElement));
		}

		// we use the bpmn elements container (task, event...) as the source
		PictogramElement sourcePictogram = getPictogramElement(bpmnElement.eContainer());
		PictogramElement targetPictogram = resolvePictogramElement((EObject) targetRef);
		
		if (targetPictogram == null) {
			// some modelers like Visual Paradigm are doing it wrong, so the target might be in bpmn model
			// but cant be drawn, we are just warning in this case
			modelImport.log(new UnmappedElementException("Target of Data Output Association is not drawn, it might be invalid.", targetRef));
			return null;
		}
		
		Connection connection = createConnectionAndSetBendpoints(edge, sourcePictogram, targetPictogram);
		return connection;
	}
}
