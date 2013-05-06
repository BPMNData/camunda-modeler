package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.ModelFactory;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.runtime.engine.model.PrimaryKey;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelAttributeTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataState;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class ItemAwareElementPropertiesBuilder extends
        AbstractPropertiesBuilder<ItemAwareElement> {

    private static final EStructuralFeature DATA_STATE_FEATURE = Bpmn2Package.eINSTANCE
            .getItemAwareElement_DataState();
    private static final EStructuralFeature PRIMARY_KEY_FEATURE = ModelPackage.eINSTANCE
            .getDocumentRoot_PrimaryKey();

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

        Text primaryKeyText = PropertyUtil.createUnboundText(section, parent,
                "Primary Key");
        PrimaryKeyFieldBinding primaryKeyFieldBinding = new PrimaryKeyFieldBinding(
                bo, PRIMARY_KEY_FEATURE, primaryKeyText);
        primaryKeyFieldBinding.establish();
    }

    private class DataStateFieldBinding extends
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

    /**
     * Binding which binds the PrimaryKey's id of an ItemAwareElement to the
     * given text field.
     */
    private class PrimaryKeyFieldBinding extends ModelTextBinding<String> {

        public PrimaryKeyFieldBinding(EObject model,
                EStructuralFeature feature, Text control) {
            super(model, feature, control);
        }

        @Override
        protected String toString(String value) {
            if (value == null) {
                return "";
            } else {
                return value;
            }
        }

        @Override
        protected String fromString(String value) {
            if (value == null || value.trim().isEmpty()) {
                return null;
            } else {
                return value;
            }
        }

        @Override
        public String getModelValue() {
            return (String) ExtensionUtil.getExtension(bo, PRIMARY_KEY_FEATURE,
                    "id");
        }

        @Override
        public void setModelValue(String value) {
            TransactionalEditingDomain domain = TransactionUtil
                    .getEditingDomain(bo);
            ;
            domain.getCommandStack().execute(
                    new UpdatePrimaryKeyCommand(domain, value));
        }
    }

    protected void updatePrimaryKey(String id) {
        PrimaryKey pk = ModelFactory.eINSTANCE.createPrimaryKey();
        pk.setId(id.trim());
        ExtensionUtil.updateExtension(bo, PRIMARY_KEY_FEATURE, pk);
    }

    protected void removePrimaryKey() {
        ExtensionUtil.removeExtensionByFeature(bo, PRIMARY_KEY_FEATURE);
    }

    /**
     * Command which takes care of updating the primary key.
     */
    private class UpdatePrimaryKeyCommand extends RecordingCommand {

        private String newValue;

        public UpdatePrimaryKeyCommand(TransactionalEditingDomain domain,
                String newValue) {
            super(domain);
            this.newValue = newValue;
        }

        @Override
        protected void doExecute() {
            if (newValue == null || newValue.trim().isEmpty()) {
                removePrimaryKey();
            } else {
                updatePrimaryKey(newValue);
            }
        }
    }
}
