package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition;
import org.camunda.bpm.modeler.ui.change.filter.ExtensionChangeFilter;
import org.camunda.bpm.modeler.ui.change.filter.FeatureChangeFilter;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.change.EAttributeChangeSupport;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.DataOutputAssociation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Properties builder for the BPMN Data data association extensions:
 * <ul>
 * <li>{@link Cardinality}</li>
 * <li>{@link Condition}</li>
 * </ul>
 *
 */
public class DataAssociationPropertiesBuilder extends AbstractPropertiesBuilder<DataAssociation> {

  private static final EStructuralFeature CARDINALITY_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_Cardinality();

  private static final EStructuralFeature CONDITION_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_Condition();

  public DataAssociationPropertiesBuilder(Composite parent, GFPropertySection section, DataAssociation bo) {
    super(parent, section, bo);
  }

  @Override
    public void create() {
        if (bo instanceof DataOutputAssociation)
            createCardinalityCondition();
        createConditionControl();
    }

  private void createCardinalityCondition() {
    final Text cardinalityText = PropertyUtil.createUnboundText(section, parent, "Cardinality");
    ExtensionAdapter<Cardinality> cardinalityFactory = new ExtensionAdapter<Cardinality>() {
      @Override
      public Cardinality create() {
        return BptFactory.eINSTANCE.createCardinality();
      }

      @Override
      public void setValue(Cardinality extension, String value) {
        extension.setValue(value);
      }
    };
    new ExtensionTextBinding<Cardinality>(bo, CARDINALITY_FEATURE, cardinalityText, "value", cardinalityFactory).establish();
  }

  private void createConditionControl() {
    final Text conditionText = PropertyUtil.createUnboundText(section, parent, "Condition");
    ExtensionAdapter<Condition> conditionFactory = new ExtensionAdapter<Condition>() {
      @Override
      public Condition create() {
        return BptFactory.eINSTANCE.createCondition();
      }

      @Override
      public void setValue(Condition extension, String value) {
        extension.setValue(value);
      }
    };
    new ExtensionTextBinding<Condition>(bo, CONDITION_FEATURE, conditionText, "value", conditionFactory).establish();
  }

  /**
   * Generic binding for simple extension.
   */
  private class ExtensionTextBinding<T extends EObject> extends ModelTextBinding<String> {

    private String attributeName;
    private ExtensionAdapter<T> extensionAdapter;

    public ExtensionTextBinding(EObject model, EStructuralFeature feature, Text control, String attributeName, ExtensionAdapter<T> extensionFactory) {
      super(model, feature, control);
      this.attributeName = attributeName;
      this.extensionAdapter = extensionFactory;
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
        return value.trim();
      }
    }

    @Override
    public String getModelValue() {
      return (String) ExtensionUtil.getExtension(bo, feature, attributeName);
    }

    @Override
    public void setModelValue(String value) {
      transactionalUpdate(value);
    }

    @Override
    protected void ensureChangeSupportAdded() {
      EAttributeChangeSupport changeSupport = new EAttributeChangeSupport(model, feature, control);
      changeSupport.setFilter(new ExtensionChangeFilter(model, feature).or(new FeatureChangeFilter(model, feature)));
      EAttributeChangeSupport.ensureAdded(changeSupport, control);
    }

    protected void transactionalUpdate(String newValue) {
      TransactionalEditingDomain domain = getTransactionalEditingDomain();
      domain.getCommandStack().execute(new UpdateCommand(domain, newValue));
    }

    protected TransactionalEditingDomain getTransactionalEditingDomain() {
      return TransactionUtil.getEditingDomain(bo);
    }

    protected void updateExtension(String updateValue) {
      T extension = ExtensionUtil.getExtension(bo, feature);
      if (extension == null) {
        extension = extensionAdapter.create();
        ModelUtil.setID(extension);
      }
      extensionAdapter.setValue(extension, updateValue);
      ExtensionUtil.updateExtension(bo, feature, extension);
    }

    protected void removeExtension() {
      ExtensionUtil.removeExtensionByFeature(bo, feature);
    }

    /**
     * Command that updates a simple extension.
     */
    private class UpdateCommand extends RecordingCommand {

      private String newValue;

      public UpdateCommand(TransactionalEditingDomain domain, String newValue) {
        super(domain);
        this.newValue = newValue;
      }

      @Override
      protected void doExecute() {
        if (newValue == null || newValue.isEmpty()) {
          removeExtension();
        } else {
          updateExtension(newValue);
        }
      }
    }
  }

  private static interface ExtensionAdapter<T extends EObject> {
    T create();

    void setValue(T extension, String value);
  }

}
