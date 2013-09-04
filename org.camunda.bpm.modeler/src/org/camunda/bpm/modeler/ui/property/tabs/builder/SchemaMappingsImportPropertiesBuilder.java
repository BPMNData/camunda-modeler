package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.List;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.SchemaMappingImport;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Builds the property panel part that gives access to the following BPMN Data extensions of a {@link Definitions} root:
 * <ul>
 * <li>{@link SchemaMappingImport}</li>
 * </ol>
 */
public class SchemaMappingsImportPropertiesBuilder extends AbstractPropertiesBuilder<Definitions> {

  private static final EStructuralFeature SCHEMA_MAPPING_IMPORT_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_SchemaMappingImports();

  private SchemaMappingImport schemaMappingImport;

  public SchemaMappingsImportPropertiesBuilder(Composite parent, GFPropertySection section, Definitions bo) {
    super(parent, section, bo);
  }

  @Override
  public void create() {
    schemaMappingImport = getOrCreateSchemaMappingImport();
    Text text = PropertyUtil.createUnboundText(section, parent, "Schema Mapping Location");
    new Binding(bo, SCHEMA_MAPPING_IMPORT_FEATURE, text).establish();
  }

  /**
   * Retrieves the existing schema mapping import or creates a new one.
   */
  private SchemaMappingImport getOrCreateSchemaMappingImport() {
    Object extension = ExtensionUtil.getExtension(bo, SCHEMA_MAPPING_IMPORT_FEATURE);
    if (extension == null) {
      return BptFactory.eINSTANCE.createSchemaMappingImport();
    } else {
      return (SchemaMappingImport) extension;
    }
  }

  /** Checks whether the Definitions object has a SchemaMappingImport extension. */
  private boolean isSchemaMappingImportAttached() {
    List<Object> extensions = ExtensionUtil.getExtensions(bo, SCHEMA_MAPPING_IMPORT_FEATURE);
    return extensions.contains(schemaMappingImport);
  }

  private class Binding extends ModelTextBinding<String> {

    public Binding(EObject model, EStructuralFeature feature, Text control) {
      super(model, feature, control);
    }

    @Override
    protected String toString(String modelValue) {
      // Transform the model value to a string
      if (modelValue == null || modelValue.trim().isEmpty()) {
        return "";
      } else {
        return modelValue;
      }
    }

    @Override
    protected String fromString(String inputValue) {
      // Transform an input to a model value
      if (inputValue == null || inputValue.trim().isEmpty()) {
        return null;
      } else {
        return inputValue;
      }
    }

    @Override
    public String getModelValue() {
      SchemaMappingImport smi = ExtensionUtil.getExtension(bo, SCHEMA_MAPPING_IMPORT_FEATURE);
      if (smi == null)
        return null;
      return smi.getLocation();
    }

    @Override
    public void setModelValue(final String value) {
      TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(bo);
      domain.getCommandStack().execute(new RecordingCommand(domain) {

        @Override
        protected void doExecute() {
          if (value == null) {
            ExtensionUtil.removeExtensionByFeature(bo, SCHEMA_MAPPING_IMPORT_FEATURE);
          } else {
            if (!isSchemaMappingImportAttached()) {
              ExtensionUtil.addExtension(bo, SCHEMA_MAPPING_IMPORT_FEATURE, schemaMappingImport);
            }
            schemaMappingImport.setLocation(value);
          }
        }
      });
    }
  }

}
