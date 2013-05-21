package org.camunda.bpm.modeler.ui.property.tabs.builder;

import static org.camunda.bpm.modeler.core.utils.ExtensionUtil.addExtension;
import static org.camunda.bpm.modeler.core.utils.ExtensionUtil.removeExtensionByValue;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ForeignKey;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType;
import org.camunda.bpm.modeler.ui.change.filter.ExtensionChangeFilter;
import org.camunda.bpm.modeler.ui.change.filter.FeatureChangeFilter;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelAttributeComboBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.change.EAttributeChangeSupport;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.ContentProvider;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.DeletedRowHandler;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EditableEObjectTableBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EObjectAttributeTableColumnDescriptor.EditingSupportProvider;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EditableTableDescriptor.ElementFactory;
import org.camunda.bpm.modeler.ui.property.tabs.util.Events;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * Builds the property panel that gives access to the primary key etc. of a data
 * object.
 */
public class RelationalKeysPropertiesBuilder extends
        AbstractPropertiesBuilder<DataObject> {

    private static final EStructuralFeature PRIMARY_KEY_FEATURE = BptPackage.eINSTANCE
            .getDocumentRoot_PrimaryKey();

    private static final EStructuralFeature PRIMARY_KEY_TYPE_FEATURE = BptPackage.eINSTANCE
            .getPrimaryKey_Type();

    private static final String PRIMARY_KEY_NAME_ATTR = "value";

    protected static final EStructuralFeature FOREIGN_KEY_FEATURE = BptPackage.eINSTANCE
            .getDocumentRoot_ForeignKey();

    private static final EClass FOREIGN_KEY_TYPE = BptPackage.eINSTANCE
            .getForeignKey();

    private static final String[] FOREIGN_KEY_FEATURE_NAMES = { "Name" };

    private static final EStructuralFeature[] FOREIGN_KEY_TYPE_FEATURES = { BptPackage.eINSTANCE
            .getRelationalKey_Value() };

    public RelationalKeysPropertiesBuilder(Composite parent,
            GFPropertySection section, DataObject bo) {
        super(parent, section, bo);
    }

    @Override
    public void create() {
        // Primary key name and type...
        PrimaryKey pk = getOrCreatePrimaryKey(bo);

        // ...controls
        Text primaryKeyText = PropertyUtil.createUnboundText(section, parent,
                "Primary Key");
        CCombo pkTypeCombo = PropertyUtil.createDropDown(section, parent,
                "Operation Type");
        if (getPrimaryKeys(bo).isEmpty()) {
            pkTypeCombo.setEnabled(false);
        }

        // ...bindings
        PrimaryKeyNameTextBinding primaryKeyFieldBinding = new PrimaryKeyNameTextBinding(
                bo, PRIMARY_KEY_FEATURE, primaryKeyText, pk, pkTypeCombo);
        primaryKeyFieldBinding.establish();
        for (PrimaryKeyType pkType : PrimaryKeyType.VALUES) {
            pkTypeCombo.add(pkType.getName());
        }
        PrimaryKeyTypeComboBinding pkTypeBinding = new PrimaryKeyTypeComboBinding(
                pk, PRIMARY_KEY_TYPE_FEATURE, pkTypeCombo);
        pkTypeBinding.establish();

        // Foreign Keys
        createForeignKeyTable(section, parent, "Foreign Keys",
                FOREIGN_KEY_TYPE, FOREIGN_KEY_FEATURE,
                FOREIGN_KEY_TYPE_FEATURES, FOREIGN_KEY_FEATURE_NAMES);
    }

    /**
     * Read the existing or create a new primary key, so that it can be bound to
     * the UI.
     */
    private PrimaryKey getOrCreatePrimaryKey(DataObject bo) {
        List<PrimaryKey> pks = getPrimaryKeys(bo);
        PrimaryKey pk;
        if (pks.isEmpty()) {
            pk = BptFactory.eINSTANCE.createPrimaryKey();
            pk.setId("pk_uuid-" + UUID.randomUUID());
            pk.setType(PrimaryKeyType.DEFAULT);
        } else
            pk = pks.get(0);
        return pk;
    }

    /**
     * Return all the primary keys of the data object. There should maximally be
     * one.
     */
    private List<PrimaryKey> getPrimaryKeys(DataObject bo) {
        List<PrimaryKey> pks = ExtensionUtil
                .getExtensions(bo, PrimaryKey.class);
        if (pks.size() > 1)
            Logger.getAnonymousLogger().warning(
                    "There is more than one primary key for " + bo);
        return pks;
    }

    /**
     * Binding which binds the PrimaryKey's id of an ItemAwareElement to the
     * given text field.
     */
    private class PrimaryKeyNameTextBinding extends ModelTextBinding<String> {

        private PrimaryKey pk;
        private CCombo typeCombo;

        public PrimaryKeyNameTextBinding(EObject model,
                EStructuralFeature feature, Text control, PrimaryKey pk,
                CCombo pkTypeCombo) {
            super(model, feature, control);
            this.pk = pk;
            this.typeCombo = pkTypeCombo;
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
            typeCombo.setEnabled(true);
        }

        protected void removePrimaryKey() {
            ExtensionUtil.removeExtensionByFeature(model, PRIMARY_KEY_FEATURE);
            typeCombo.setEnabled(false);
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

        @Override
        protected void ensureChangeSupportAdded() {
            EAttributeChangeSupport changeSupport = new EAttributeChangeSupport(
                    model, feature, control);
            changeSupport.setFilter(new ExtensionChangeFilter(model, feature)
                    .or(new FeatureChangeFilter(model, feature)));

            EAttributeChangeSupport.ensureAdded(changeSupport, control);
        }
    }

    /** Binds the combo box to the primary key. */
    private class PrimaryKeyTypeComboBinding extends
            ModelAttributeComboBinding<PrimaryKeyType> {

        public PrimaryKeyTypeComboBinding(EObject model,
                EStructuralFeature feature, CCombo control) {
            super(model, feature, control);
        }

        @Override
        protected String toString(PrimaryKeyType value) {
            return value.getName();
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
            UpdatePrimaryKeyTypeCommand cmd = new UpdatePrimaryKeyTypeCommand(
                    domain, value);
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
            // EAttributeChangeSupport.ensureAdded(model, feature, control);

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

            public UpdatePrimaryKeyTypeCommand(
                    TransactionalEditingDomain domain, PrimaryKeyType newValue) {
                super(domain);
                this.newValue = newValue;
            }

            @Override
            protected void doExecute() {
                setPrimaryKeyType(newValue);
            }
        }

    }

    /** Creates the tables for the foreign keys. */
    private void createForeignKeyTable(GFPropertySection section,
            Composite parent, String label, final EClass typeECls,
            final EStructuralFeature feature,
            EStructuralFeature[] columnFeatures, String[] columnLabels) {

        // composite for mappings table
        Composite composite = PropertyUtil.createStandardComposite(section,
                parent);

        ElementFactory<ForeignKey> foreignKeyFactory = new ElementFactory<ForeignKey>() {
            @Override
            public ForeignKey create() {
                ForeignKey instance = (ForeignKey) transactionalAddNewForeignKey();
                return instance;
            }
        };

        ContentProvider<ForeignKey> contentProvider = new ContentProvider<ForeignKey>() {

            @Override
            public List<ForeignKey> getContents() {
                return ExtensionUtil.getExtensions(bo, ForeignKey.class);
            }
        };

        DeletedRowHandler<ForeignKey> deleteHandler = new DeletedRowHandler<ForeignKey>() {
            @Override
            public void rowDeleted(ForeignKey fk) {
                transactionalRemoveForeignKey(fk);
            }
        };

        final EditingSupportProvider editingSupportProvider = new DefaultEditingSupportProvider();

        EditableEObjectTableBuilder<ForeignKey> builder = new EditableEObjectTableBuilder<ForeignKey>(
                section, composite, ForeignKey.class);

        builder.columnFeatures(columnFeatures)
                .columnLabels(columnLabels)
                .elementFactory(foreignKeyFactory)
                .contentProvider(contentProvider)
                .editingSupportProvider(editingSupportProvider)
                .deletedRowHandler(deleteHandler)
                .model(bo)
                .changeFilter(
                        new ExtensionChangeFilter(bo, FOREIGN_KEY_FEATURE));

        final TableViewer viewer = builder.build();
        final Composite tableComposite = viewer.getTable().getParent();
        PropertyUtil.createLabel(section, composite, label, tableComposite);
    }

    /** Removes the given foreign key from the business object in a transaction. */
    private void transactionalRemoveForeignKey(final ForeignKey fk) {
        TransactionalEditingDomain editingDomain = TransactionUtil
                .getEditingDomain(bo);
        editingDomain.getCommandStack().execute(
                new RecordingCommand(editingDomain) {

                    @Override
                    protected void doExecute() {
                        removeExtensionByValue(bo, fk);
                    }
                });
    }

    /** Adds a new foreign key to the business object in a transaction. */
    private ForeignKey transactionalAddNewForeignKey() {
        final ForeignKey fk = BptFactory.eINSTANCE.createForeignKey();
        fk.setId("fk_uuid-" + UUID.randomUUID());

        TransactionalEditingDomain editingDomain = TransactionUtil
                .getEditingDomain(bo);
        editingDomain.getCommandStack().execute(
                new RecordingCommand(editingDomain) {

                    @Override
                    protected void doExecute() {
                        addExtension(bo, FOREIGN_KEY_FEATURE, fk);
                    }
                });

        return fk;
    }
}
