package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelAttributeTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataState;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Builds the property panel that gives access to the following properties of {@link ItemAwareElement}:
 * <ul>
 * <li>{@link ItemAwareElement#getDataState()}</link>
 * </ul>
 */
public class ItemAwareElementPropertiesBuilder extends
        AbstractPropertiesBuilder<ItemAwareElement> {

    private static final EStructuralFeature DATA_STATE_FEATURE = Bpmn2Package.eINSTANCE
            .getItemAwareElement_DataState();

    public ItemAwareElementPropertiesBuilder(Composite parent,
            GFPropertySection section, ItemAwareElement bo) {
        super(parent, section, bo);
    }

    @Override
    public void create() {
        Text dataStateText = PropertyUtil.createUnboundText(section, parent,
                "State");
        DataStateFieldBinding dataStateFieldBinding = new DataStateFieldBinding(
                bo, DATA_STATE_FEATURE, dataStateText);
        dataStateFieldBinding.establish();
    }

    private static class DataStateFieldBinding extends
            ModelAttributeTextBinding<DataState> {

        public DataStateFieldBinding(EObject model, EStructuralFeature feature,
                Text control) {
            super(model, feature, control);
        }

        @Override
        protected String toString(DataState value) {
            if (value != null) {
                return value.getName();
            }
            return "";
        }

        @Override
        protected DataState fromString(String str) {
            if (str != null && !str.isEmpty()) {
                DataState state = Bpmn2Factory.eINSTANCE.createDataState();
                state.setName(str);
                return state;
            } else {
                return null;
            }
        }
    }
}
