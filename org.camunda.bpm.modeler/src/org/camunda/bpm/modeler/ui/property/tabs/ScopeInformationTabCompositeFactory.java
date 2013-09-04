package org.camunda.bpm.modeler.ui.property.tabs;

import org.camunda.bpm.modeler.ui.property.tabs.builder.ScopeInformationPropertiesBuilder;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * This tab shall allow to set the case object of a process. This is a
 * BPMN Data extension.
 */
public class ScopeInformationTabCompositeFactory extends AbstractTabCompositeFactory<BaseElement>{

	
	public ScopeInformationTabCompositeFactory(GFPropertySection section,
			Composite parent) {
		super(section, parent);
	}

	@Override
	public Composite createCompositeForBusinessObject(BaseElement businessObject) {
		new ScopeInformationPropertiesBuilder(parent, section, businessObject).create();

		return parent;
	}

	
}
