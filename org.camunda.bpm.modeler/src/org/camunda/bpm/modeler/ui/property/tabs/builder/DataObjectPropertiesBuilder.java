package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * Builder for the property UI of {@link DataObject} objects. Features:
 * <ul>
 * <li>{@link DataObject#isIsCollection}</li>
 * </ul>
 */
public class DataObjectPropertiesBuilder extends
		AbstractPropertiesBuilder<DataObject> {

	private static final EStructuralFeature IS_COLLECTION_FEATURE = Bpmn2Package.eINSTANCE
			.getDataObject_IsCollection();

	public DataObjectPropertiesBuilder(Composite parent,
			GFPropertySection section, DataObject bo) {
		super(parent, section, bo);
	}

	@Override
	public void create() {
		PropertyUtil.createCheckbox(section, parent, "is Collection", IS_COLLECTION_FEATURE, bo);
	}

}
