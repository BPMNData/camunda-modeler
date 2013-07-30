package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelButtonBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;

/**
 * Builds the property panel that gives access to the primary key etc. of a data
 * object.
 */
public class TransformationPropertiesBuilder extends AbstractPropertiesBuilder<DataAssociation> implements SelectionListener {

  private static final EStructuralFeature TRANSFORMATION_FEATURE = Bpmn2Package.eINSTANCE.getDataAssociation_Transformation();
  private Button checkbox;
  private Text expressionText;
  private Text languageText;
  private FormalExpression cachedFormalExpression;

  public TransformationPropertiesBuilder(Composite parent, GFPropertySection section, DataAssociation bo) {
    super(parent, section, bo);

    this.cachedFormalExpression = bo.getTransformation();
    if (this.cachedFormalExpression == null) {
      this.cachedFormalExpression = Bpmn2Factory.eINSTANCE.createFormalExpression();
      ModelUtil.setID(cachedFormalExpression);
    }
  }

  @Override
  public void create() {
    createControls();
    establishBindings();
  }

  private void createControls() {
    checkbox = PropertyUtil.createUnboundCheckbox(section, parent, "Enabled", "");
    checkbox.addSelectionListener(this);
    languageText = PropertyUtil.createUnboundText(section, parent, "Language");
    expressionText = PropertyUtil.createUnboundMultiText(section, parent, "Transformation");
  }

  private void establishBindings() {
    establishCheckboxBinding();
    establishLanguageTextBinding();
    establishExpressionTextBinding();
  }

  private void establishCheckboxBinding() {
    ModelButtonBinding<Boolean> binding = new ModelButtonBinding<Boolean>(bo, TRANSFORMATION_FEATURE, checkbox) {

      @Override
      public void setViewValue(Boolean value) {
        control.setSelection(value != null && value.booleanValue());
        control.notifyListeners(SWT.Selection, new Event());
      }

      @Override
      public Boolean getViewValue() throws IllegalArgumentException {
        return control.getSelection();
      }

      @Override
      public Boolean getModelValue() {
        return bo.eGet(feature) != null;
      }

      @Override
      public void setModelValue(Boolean newValue) {
        boolean modelValue = getModelValue();
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
        EditTransformationCommand cmd = new EditTransformationCommand(editingDomain, modelValue, newValue);
        editingDomain.getCommandStack().execute(cmd);
      }

      class EditTransformationCommand extends RecordingCommand {

        private boolean modelValue, newValue;

        public EditTransformationCommand(TransactionalEditingDomain domain, boolean modelValue, boolean newValue) {
          super(domain);
          this.modelValue = modelValue;
          this.newValue = newValue;
        }

        @Override
        protected void doExecute() {
          if (newValue) {
            if (modelValue) {
              bo.eSet(feature, cachedFormalExpression);
            }
          } else {
            bo.eSet(feature, null);
          }
        }

      }
    };

    binding.establish();
  }

  private void establishLanguageTextBinding() {
    ModelTextBinding<String> binding = new ModelTextBinding<String>(cachedFormalExpression, Bpmn2Package.eINSTANCE.getFormalExpression_Language(), languageText) {

      @Override
      protected String toString(String value) {
        if (value == null)
          value = "";
        return value.trim();
      }

      @Override
      protected String fromString(String str) {
        if (str == null || str.trim().isEmpty())
          return null;
        return str.trim();
      }

      @Override
      public String getModelValue() {
        return (String) model.eGet(feature);
      }

      @Override
      public void setModelValue(String value) {
        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);
        if (domain == null) {
          setLanguage(value);
        } else {
          domain.getCommandStack().execute(new UpdateLanguageCommand(domain, value));
        }
      }

      public void setLanguage(String language) {
        model.eSet(feature, language);
      }
      
      class UpdateLanguageCommand extends RecordingCommand {

        private String newLanguage;
        
        public UpdateLanguageCommand(TransactionalEditingDomain domain, String newLanguage) {
          super(domain);
          this.newLanguage = newLanguage;
        }

        @Override
        protected void doExecute() {
          setLanguage(newLanguage);
        }
      }

    };

    binding.establish();
  }

  private void establishExpressionTextBinding() {
    ModelTextBinding<String> binding = new ModelTextBinding<String>(cachedFormalExpression, Bpmn2Package.eINSTANCE.getFormalExpression_Body(), expressionText) {
      
      @Override
      protected String toString(String value) {
        if (value == null)
          value = "";
        return value.trim();
      }
      
      @Override
      protected String fromString(String str) {
        if (str == null || str.trim().isEmpty())
          return null;
        return str.trim();
      }
      
      @Override
      public String getModelValue() {
        return (String) model.eGet(feature);
      }
      
      @Override
      public void setModelValue(String value) {
        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);
        if (domain == null) {
          setLanguage(value);
        } else {
          domain.getCommandStack().execute(new UpdateExpressionCommand(domain, value));
        }
      }
      
      public void setLanguage(String language) {
        model.eSet(feature, language);
      }
      
      class UpdateExpressionCommand extends RecordingCommand {
        
        private String newExpression;
        
        public UpdateExpressionCommand(TransactionalEditingDomain domain, String newExpression) {
          super(domain);
          this.newExpression = newExpression;
        }
        
        @Override
        protected void doExecute() {
          setLanguage(newExpression);
        }
      }
      
    };
    
    binding.establish();
  }

  @Override
  public void widgetSelected(SelectionEvent e) {
    boolean isSelected = ((Button) e.widget).getSelection();
    languageText.setEnabled(isSelected);
    expressionText.setEnabled(isSelected);
  }

  @Override
  public void widgetDefaultSelected(SelectionEvent e) {
    widgetSelected(e);
  }

}
