package org.camunda.bpm.modeler.ui.property.tabs.tables;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.TableViewer;

/** Editing support for BPMN extensions in table editors. Needed to enforce EMF notifications, when editing. */
public class ExtensionEditingSupport extends
		EObjectAttributeEditingSupport<EObject> {

	private EObject model;
	
	public ExtensionEditingSupport(TableViewer viewer,
			EStructuralFeature feature, EObject model) {
		super(viewer, feature);
		this.model = model;
	}

	protected void setValue(EObject element, Object value) {
		super.setValue(element, value);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(model);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				ExtensionUtil.enforceNotification(model);
			}
			
		});
	}
}
