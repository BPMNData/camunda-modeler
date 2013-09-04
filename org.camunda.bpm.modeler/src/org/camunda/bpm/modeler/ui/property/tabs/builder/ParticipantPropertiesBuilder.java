package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.EndPointAddress;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.ui.change.filter.ExtensionChangeFilter;
import org.camunda.bpm.modeler.ui.change.filter.FeatureChangeFilter;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelButtonBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelTextBinding;
import org.camunda.bpm.modeler.ui.property.tabs.binding.change.EAttributeChangeSupport;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.ParticipantMultiplicity;
import org.eclipse.bpmn2.Process;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Builder for the id property
 * 
 * @author nico.rehwaldt
 */
public class ParticipantPropertiesBuilder extends AbstractPropertiesBuilder<Participant> {

  public ParticipantPropertiesBuilder(Composite parent, GFPropertySection section, Participant bo) {
    super(parent, section, bo);
  }

  @Override
  public void create() {
    Process process = bo.getProcessRef();

    if (process != null) { // empty participant must not have a process
      new ProcessIdPropertyBuilder(parent, section, process).create();
      new NamePropertyBuilder(parent, section, process, "Process Name").create();
      new ProcessPropertiesBuilder(parent, section, process).create();
    }

    // BPMN Data: Make the participant multiplicity property accessible.
    Button multiplicityCheckbox = PropertyUtil.createUnboundCheckbox(section, parent, "Is Multi-Instance");
    ModelButtonBinding<ParticipantMultiplicity> multiplicityBinding = new ModelButtonBinding<ParticipantMultiplicity>(bo,
        Bpmn2Package.eINSTANCE.getParticipant_ParticipantMultiplicity(), multiplicityCheckbox) {

      private ParticipantMultiplicity participantMultiplicity = getOrCreateParticipantMultiplicity(bo);

      private ParticipantMultiplicity getOrCreateParticipantMultiplicity(Participant bo) {
        ParticipantMultiplicity multiplicity = bo.getParticipantMultiplicity();
        if (multiplicity == null) {
          multiplicity = ModelHandler.create(bo.eResource(), ParticipantMultiplicity.class);
          multiplicity.setMinimum(2);
          multiplicity.setMaximum(2);
        }
        return multiplicity;
      }

      @Override
      public void setViewValue(ParticipantMultiplicity value) {
        control.setSelection(value != null);
      }

      @Override
      public void setModelValue(final ParticipantMultiplicity value) {
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
        editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

          @Override
          protected void doExecute() {
            bo.setParticipantMultiplicity(value);
          }
        });
      }

      @Override
      public ParticipantMultiplicity getViewValue() {
        return control.getSelection() ? participantMultiplicity : null;
      }

      @Override
      public ParticipantMultiplicity getModelValue() {
        return bo.getParticipantMultiplicity();
      }

    };

    multiplicityBinding.establish();

    // BPMN Data: Make endpoint available (via an extension)
    Text endPointAddressText = PropertyUtil.createUnboundText(section, parent, "End-Point Address");
    ModelTextBinding<String> endPointAddressBinding = new ModelTextBinding<String>(bo, ModelPackage.eINSTANCE.getDocumentRoot_Address(), endPointAddressText) {

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
        return (String) ExtensionUtil.getExtension(model, feature, ModelPackage.eINSTANCE.getEndPointAddress_Value().getName());
      }

      @Override
      public void setModelValue(String value) {
        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);
        domain.getCommandStack().execute(new UpdateAddressCommand(domain, value));
      }

      protected void updateUrl(String url) {
        EndPointAddress address = ExtensionUtil.getExtension(bo, feature);
        if (address == null) {
          address = (EndPointAddress) ModelHandler.create(model.eResource(), ModelPackage.eINSTANCE.getEndPointAddress());
        }
        address.setValue(url);
        ExtensionUtil.updateExtension(model, feature, address);
      }

      protected void removeExtension() {
        ExtensionUtil.removeExtensionByFeature(model, feature);
      }

      /** Command that updates the address extension in the bound bo. */
      class UpdateAddressCommand extends RecordingCommand {

        private String newValue;

        public UpdateAddressCommand(TransactionalEditingDomain domain, String newValue) {
          super(domain);
          this.newValue = newValue;
        }

        @Override
        protected void doExecute() {
          if (newValue == null || newValue.trim().isEmpty()) {
            removeExtension();
          } else {
            updateUrl(newValue.trim());
          }
        }
      }

      @Override
      protected void ensureChangeSupportAdded() {
        EAttributeChangeSupport changeSupport = new EAttributeChangeSupport(model, feature, control);
        changeSupport.setFilter(new ExtensionChangeFilter(model, feature).or(new FeatureChangeFilter(model, feature)));

        EAttributeChangeSupport.ensureAdded(changeSupport, control);
      }
    };
    endPointAddressBinding.establish();
  }
}
