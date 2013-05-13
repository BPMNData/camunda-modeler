package org.camunda.bpm.modeler.ui.property.tabs;

import org.eclipse.bpmn2.DataObject;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;

public class RelationalKeysTabCompositeFactory extends
        AbstractTabCompositeFactory<DataObject> {

    public RelationalKeysTabCompositeFactory(GFPropertySection section,
            Composite parent) {
        super(section, parent);
    }

    @Override
    public Composite createCompositeForBusinessObject(DataObject businessObject) {
        new RelationalKeysPropertiesBuilder(parent, section, businessObject).create();
        return parent;
    }

}
