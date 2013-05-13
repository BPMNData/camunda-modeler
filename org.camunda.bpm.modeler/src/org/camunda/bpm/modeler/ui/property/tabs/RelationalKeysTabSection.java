package org.camunda.bpm.modeler.ui.property.tabs;

import org.camunda.bpm.modeler.core.property.AbstractTabSection;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

public class RelationalKeysTabSection extends AbstractTabSection {

    @Override
    protected Composite createCompositeForObject(Composite parent,
            EObject businessObject) {
        if (businessObject instanceof DataObject) {
            return new RelationalKeysTabCompositeFactory(this, parent).createCompositeForBusinessObject((DataObject) businessObject);
        }
        return parent;
    }

}
