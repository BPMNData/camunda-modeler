package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.SubProcess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Builds the property panel part that gives access to the following BPMN Data
 * extensions of a {@link Process}:
 * <ul>
 * <li>{@link ScopeInformation} (i.e. the case object)</li> </ol>
 */
public class ScopeInformationPropertiesBuilder extends AbstractPropertiesBuilder<BaseElement> {

  private static final EStructuralFeature SCOPE_INFORMATION_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_ScopeInformation();

  protected BaseElement process;

  public ScopeInformationPropertiesBuilder(Composite parent, GFPropertySection section, BaseElement bo) {
    super(parent, section, bo);
    this.process = getProcess(bo);
  }

  @Override
  public void create() {
    Text caseObjectText = PropertyUtil.createUnboundText(section, parent, "Case Object");
    CaseObjectNameTextBinding primaryKeyFieldBinding = new CaseObjectNameTextBinding(process, SCOPE_INFORMATION_FEATURE, caseObjectText);
    primaryKeyFieldBinding.establish();
  }

  /**
   * We use this PropertyBuilder in the context for different business objects.
   * If this BO is pool, we need to find the appropriate process for the pool
   * here.<br>
   * <i>Note: As {@link SubProcess} and {@link Process} are not in a direct
   * hierarchy, we need to return a {@link BaseElement} as the most specific
   * common ancestor.</i>
   */
  private BaseElement getProcess(BaseElement bo) {
    if (bo instanceof Process)
      return bo;
    if (bo instanceof SubProcess)
      return bo;
    if (bo instanceof Participant) {
      Participant participant = (Participant) bo;
      return participant.getProcessRef();
    }
    throw new IllegalArgumentException("Unexpected business object type: " + bo.getClass());
  }

  private class CaseObjectNameTextBinding extends ModelTextBinding<String> {

    public CaseObjectNameTextBinding(EObject model, EStructuralFeature feature, Text control) {
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
      List<ScopeInformation> scopeInformationCollection = ExtensionUtil.getExtensions(process, ScopeInformation.class);
      if (scopeInformationCollection.size() == 0) {
        return null;
      } else {
        return scopeInformationCollection.get(0).getCaseObject();
      }
      // return (String) ExtensionUtil.getExtension(bo,
      // SCOPE_INFORMATION_FEATURE);
      // "caseObject");
    }

    @Override
    public void setModelValue(String value) {
      TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(process);
      domain.getCommandStack().execute(new UpdateScopeInformationCommand(domain, value));
    }
  }

  protected void updateCaseObject(String caseObjectName) {
    List<ScopeInformation> scopeInformationCollection = ExtensionUtil.getExtensions(process, ScopeInformation.class);
    if (scopeInformationCollection.size() > 1)
      Logger.getAnonymousLogger().warning("There is more than one scope information element defined for " + process);

    ScopeInformation scopeInformation = scopeInformationCollection.isEmpty() ? BptFactory.eINSTANCE.createScopeInformation() : scopeInformationCollection
        .get(0);
    if (scopeInformation.getId() == null || scopeInformation.getId().isEmpty()) {
      scopeInformation.setId("si-" + UUID.randomUUID());
    }

    scopeInformation.setCaseObject(caseObjectName);
    ExtensionUtil.updateExtension(process, SCOPE_INFORMATION_FEATURE, scopeInformation);
  }

  protected void removeScopeInformation() {
    ExtensionUtil.removeExtensionByFeature(process, SCOPE_INFORMATION_FEATURE);
  }

  /**
   * Command which takes care of updating the primary key.
   */
  private class UpdateScopeInformationCommand extends RecordingCommand {

    private String newValue;

    public UpdateScopeInformationCommand(TransactionalEditingDomain domain, String newValue) {
      super(domain);
      this.newValue = newValue;
    }

    @Override
    protected void doExecute() {
      if (newValue == null || newValue.trim().isEmpty()) {
        removeScopeInformation();
      } else {
        updateCaseObject(newValue);
      }
    }
  }

}
