package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelAttributeButtonBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelAttributeTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataState;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.LoopCharacteristics;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class ItemAwareElementPropertiesBuilder extends AbstractPropertiesBuilder<ItemAwareElement> {

	private static final EStructuralFeature DATA_STATE_FEATURE = Bpmn2Package.eINSTANCE.getItemAwareElement_DataState();

	public ItemAwareElementPropertiesBuilder(Composite parent,
			GFPropertySection section, ItemAwareElement bo) {
		super(parent, section, bo);
	}

	@Override
	public void create() {
		Text textField = PropertyUtil.createUnboundText(section, parent, "State");
		
		DataStateFieldBinding binding = new DataStateFieldBinding(bo, DATA_STATE_FEATURE, textField);
		binding.establish();
		
//		PropertyUtil.createText(section, parent, "State", DATA_STATE_FEATURE, state); // bo oder state?
	}
	
	private class DataStateFieldBinding extends ModelAttributeTextBinding<DataState> {

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
