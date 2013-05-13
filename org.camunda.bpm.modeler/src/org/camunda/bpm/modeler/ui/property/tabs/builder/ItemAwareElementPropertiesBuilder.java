package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelAttributeComboBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelAttributeTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.util.Events;
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
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class ItemAwareElementPropertiesBuilder extends
        AbstractPropertiesBuilder<ItemAwareElement> {

    private static final EStructuralFeature DATA_STATE_FEATURE = Bpmn2Package.eINSTANCE
            .getItemAwareElement_DataState();
    private static final EStructuralFeature PRIMARY_KEY_FEATURE = BptPackage.eINSTANCE
            .getDocumentRoot_PrimaryKey();
    private static final EStructuralFeature PK_TYPE_FEATURE = BptPackage.eINSTANCE
            .getPrimaryKey_Type();

    private static final String PRIMARY_KEY_NAME_ATTR = "value";

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

        PrimaryKey pk = getOrCreatePrimaryKey(bo);
        Text primaryKeyText = PropertyUtil.createUnboundText(section, parent,
                "Primary Key");
        PrimaryKeyNameTextBinding primaryKeyFieldBinding = new PrimaryKeyNameTextBinding(
                bo, PRIMARY_KEY_FEATURE, primaryKeyText, pk);
        primaryKeyFieldBinding.establish();

        CCombo pkTypeCombo = PropertyUtil.createDropDown(section, parent,
                "Type");
        for (PrimaryKeyType pkType : PrimaryKeyType.VALUES) {
            pkTypeCombo.add(pkType.getName());
        }
        PrimaryKeyTypeComboBinding pkTypeBinding = new PrimaryKeyTypeComboBinding(
                pk, PK_TYPE_FEATURE, pkTypeCombo);
        pkTypeBinding.establish();
    }

    protected PrimaryKey getOrCreatePrimaryKey(ItemAwareElement bo) {
        List<PrimaryKey> pks = ExtensionUtil
                .getExtensions(bo, PrimaryKey.class);
        if (pks.size() > 1)
            Logger.getAnonymousLogger().warning(
                    "There is more than one primary key for " + bo);
        PrimaryKey pk;
        if (pks.isEmpty()) {
            pk = BptFactory.eINSTANCE.createPrimaryKey();
            pk.setId("pk_uuid-" + UUID.randomUUID());
        } else
            pk = pks.get(0);
        return pk;
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

    /**
     * Binding which binds the PrimaryKey's id of an ItemAwareElement to the
     * given text field.
     */
    private static class PrimaryKeyNameTextBinding extends
            ModelTextBinding<String> {

        private PrimaryKey pk;

        public PrimaryKeyNameTextBinding(EObject model,
                EStructuralFeature feature, Text control, PrimaryKey pk) {
            super(model, feature, control);
            this.pk = pk;
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
            return (String) ExtensionUtil.getExtension(model,
                    PRIMARY_KEY_FEATURE, PRIMARY_KEY_NAME_ATTR);
        }

        @Override
        public void setModelValue(String value) {
            TransactionalEditingDomain domain = TransactionUtil
                    .getEditingDomain(model);
            domain.getCommandStack().execute(
                    new UpdatePrimaryKeyCommand(domain, value));
        }

        protected void updateName(String name) {
            pk.setValue(name);
            ExtensionUtil.updateExtension(model, PRIMARY_KEY_FEATURE, pk);
        }

        protected void removePrimaryKey() {
            ExtensionUtil.removeExtensionByFeature(model, PRIMARY_KEY_FEATURE);
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
                    updateName(newValue.trim());
                }
            }
        }
    }

    private class PrimaryKeyTypeComboBinding extends
            ModelAttributeComboBinding<PrimaryKeyType> {

        public PrimaryKeyTypeComboBinding(EObject model,
                EStructuralFeature feature, CCombo control) {
            super(model, feature, control);
        }

        @Override
        protected String toString(PrimaryKeyType value) {
            return value.toString();
        }

        @Override
        protected PrimaryKeyType fromString(String string) {
            return PrimaryKeyType.get(string);
        }

        @Override
        public PrimaryKeyType getModelValue() {
            return ((PrimaryKey) model).getType();
        }

        @Override
        public void setModelValue(PrimaryKeyType value) {
            TransactionalEditingDomain domain = TransactionUtil
                    .getEditingDomain(model);
            UpdatePrimaryKeyTypeCommand cmd = new UpdatePrimaryKeyTypeCommand(domain, value);
            if (domain == null)
                cmd.doExecute();
            else
                domain.getCommandStack().execute(cmd);
        }

        private void setPrimaryKeyType(PrimaryKeyType value) {
            ((PrimaryKey) model).setType(value);
        }
        
        @Override
        protected void establishModelViewBinding() {
//            EAttributeChangeSupport.ensureAdded(model, feature, control);

            control.addListener(Events.MODEL_CHANGED, new Listener() {
                
                @Override
                public void handleEvent(Event event) {
                    final PrimaryKeyType modelValue = getModelValue();
                    PrimaryKeyType viewValue = null;
                    
                    try {
                        viewValue = getViewValue();
                    } catch (IllegalArgumentException e) {
                        ; // expected
                    }
                    
                    if (isChangeWithNullChecks(modelValue, viewValue)) {
                        setViewValue(modelValue);
                    }
                }
            });
        }
        
        /**
         * Command which takes care of updating the primary key.
         */
        private class UpdatePrimaryKeyTypeCommand extends RecordingCommand {
        
            private PrimaryKeyType newValue;
        
            public UpdatePrimaryKeyTypeCommand(TransactionalEditingDomain domain,
                    PrimaryKeyType newValue) {
                super(domain);
                this.newValue = newValue;
            }
        
            @Override
            protected void doExecute() {
                setPrimaryKeyType(newValue);
            }
        }

    }
}
