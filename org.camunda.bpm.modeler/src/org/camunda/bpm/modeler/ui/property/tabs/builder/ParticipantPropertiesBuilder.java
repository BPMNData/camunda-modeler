package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.camunda.bpm.modeler.ui.property.tabs.binding.ModelButtonBinding;
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
		ModelButtonBinding<ParticipantMultiplicity> multiplicityBinding = new ModelButtonBinding<ParticipantMultiplicity>(bo, Bpmn2Package.eINSTANCE.getParticipant_ParticipantMultiplicity(), multiplicityCheckbox) {
		  
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
	}
}
