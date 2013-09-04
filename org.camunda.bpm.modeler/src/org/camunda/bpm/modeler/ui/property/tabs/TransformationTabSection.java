package org.camunda.bpm.modeler.ui.property.tabs;

import org.camunda.bpm.modeler.core.property.AbstractTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.builder.TransformationPropertiesBuilder;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * Tab section for the transformation of a {@link DataAssociation}.
 * 
 * @see DataAssociation#getTransformation()
 */
public class TransformationTabSection extends AbstractTabSection {

	@Override
	protected Composite createCompositeForObject(Composite parent,
			EObject businessObject) {
		new Factory(this, parent).createCompositeForBusinessObject((DataAssociation) businessObject);
		return parent;
	}
	
	public static class Factory extends AbstractTabCompositeFactory<DataAssociation> {

    public Factory(GFPropertySection section, Composite parent) {
      super(section, parent);
    }

    @Override
    public Composite createCompositeForBusinessObject(DataAssociation businessObject) {
      new TransformationPropertiesBuilder(parent, section, businessObject).create();
      
      return parent;
    }
	  
	}

}
