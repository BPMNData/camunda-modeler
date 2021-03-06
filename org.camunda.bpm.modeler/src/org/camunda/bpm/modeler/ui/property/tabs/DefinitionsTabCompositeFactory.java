package org.camunda.bpm.modeler.ui.property.tabs;

import org.camunda.bpm.modeler.ui.property.tabs.builder.DefinitionsPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.ImportAndItemDefinitionPropertiesBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.builder.SchemaMappingsImportPropertiesBuilder;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * Definitions tab composite factory
 * 
 * @author nico.rehwaldt
 */
public class DefinitionsTabCompositeFactory extends AbstractTabCompositeFactory<Definitions> {
	
	public DefinitionsTabCompositeFactory(GFPropertySection section, Composite parent) {
		super(section, parent);
	}
	
	@Override
	public Composite createCompositeForBusinessObject(Definitions definitions) {
		new DefinitionsPropertiesBuilder(parent, section, definitions).create();
		
		// BPMN Data addition and extension: item definitions, imports, and schema mapping should be editable, too 
		new ImportAndItemDefinitionPropertiesBuilder(parent, section, definitions).create();
		new SchemaMappingsImportPropertiesBuilder(parent, section, definitions).create();
		return parent;
	}
}
