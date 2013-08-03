/*******************************************************************************
 * Copyright (c) 2011 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 ******************************************************************************/
package org.camunda.bpm.modeler.ui.property;

import static org.camunda.bpm.modeler.core.utils.SelectionUtil.getSelectedBusinessObject;
import static org.camunda.bpm.modeler.core.utils.SelectionUtil.getSelectedModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.camunda.bpm.modeler.core.property.AbstractTabSection;
import org.camunda.bpm.modeler.core.property.SectionDescriptor;
import org.camunda.bpm.modeler.core.property.TabDescriptor;
import org.camunda.bpm.modeler.ui.property.tabs.DefinitionsTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.EventTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.GeneralTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.ListenerTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.MessageContentDefinitionTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.MultiInstanceTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.RelationalKeysTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.ScopeInformationTabSection;
import org.camunda.bpm.modeler.ui.property.tabs.TransformationTabSection;
import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.bpmn2.Event;
import org.eclipse.bpmn2.Gateway;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.bpmn2.SubProcess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;

public class PropertiesTabDescriptorProvider implements ITabDescriptorProvider {

    @Override
    public ITabDescriptor[] getTabDescriptors(IWorkbenchPart part,
            ISelection selection) {
        List<ITabDescriptor> tabs = new ArrayList<ITabDescriptor>();

        Object model = getSelectedModel(selection);
        EObject businessObject = getSelectedBusinessObject(model);

        if (businessObject != null) {
            tabs.add(createGeneralTabDescriptor());

            if (businessObject instanceof Event) {
                tabs.add(createEventTabDescriptor());
            }

            // add definitions tab for errors, messages and signals
            if (model instanceof Diagram) {
                tabs.add(createDefinitionsTabDescriptor());
            }

            // add multi instance tabs to activities
            if (businessObject instanceof Activity) {
                tabs.add(createMultiInstanceTabDescriptor());
            }

            if (businessObject instanceof DataAssociation) {
              tabs.add(createTransformationTabDescriptor());
            }
            
            // add execution listener tabs
            if (businessObject instanceof Activity
                    || businessObject instanceof Gateway
                    || businessObject instanceof SequenceFlow
                    || businessObject instanceof Event
                    || businessObject instanceof Process) {

                tabs.add(createListenerTabDescriptor());
            }
            
            // for participant, too
            if (businessObject instanceof Participant) {
                Participant participant = (Participant) businessObject;

                if (participant.getProcessRef() != null) {
                    tabs.add(createListenerTabDescriptor());

                    // BPMNData ScopeInformation property
                    tabs.add(createScopeInformationTabDescriptor());
                }
            }

            // BPMNData ScopeInformation property
            if (businessObject instanceof Process
                    || businessObject instanceof SubProcess) {
                tabs.add(createScopeInformationTabDescriptor());
            }

            // BPMNData Primary and foreign keys
            if (businessObject instanceof DataObject) {
                tabs.add(createRelationKeysTabDescriptor());
            }
            
            // BPMNData Message Definition
            if (businessObject instanceof Message) {
              tabs.add(createMessageContentDefinitionTabDescriptor());
            }
        }

        return tabs.toArray(new ITabDescriptor[] {});
    }

    private ITabDescriptor createTabDescriptor(String id, String name,
            AbstractTabSection tabSection) {

        TabDescriptor tabDescriptor = new TabDescriptor(id, name, name);
        ISectionDescriptor sectionDescriptor = new SectionDescriptor(id
                + ".section", tabSection);
        tabDescriptor.setSectionDescriptors(Arrays
                .asList(new ISectionDescriptor[] { sectionDescriptor }));

        return tabDescriptor;
    }

    private ITabDescriptor createMultiInstanceTabDescriptor() {
        return createTabDescriptor("multiInstanceTab", "Multi Instance",
                new MultiInstanceTabSection());
    }

    private ITabDescriptor createEventTabDescriptor() {
        return createTabDescriptor("eventTab", "Event", new EventTabSection());
    }

    private ITabDescriptor createListenerTabDescriptor() {
        return createTabDescriptor("listenerTab", "Listener",
                new ListenerTabSection());
    }

    private ITabDescriptor createGeneralTabDescriptor() {
        return createTabDescriptor("generalTab", "General",
                new GeneralTabSection());
    }

    private ITabDescriptor createDefinitionsTabDescriptor() {
        return createTabDescriptor("definitionsTab", "Definitions",
                new DefinitionsTabSection());
    }

    private ITabDescriptor createScopeInformationTabDescriptor() {
        return createTabDescriptor("scopeInformationTab", "BPMN Data Scope",
                new ScopeInformationTabSection());
    }
    
    private ITabDescriptor createTransformationTabDescriptor() {
      return createTabDescriptor("transformationTab", "Transformation",
          new TransformationTabSection());
    }

    private ITabDescriptor createRelationKeysTabDescriptor() {
        return createTabDescriptor("relationalKeysTab", "BPMN Data Keys",
                new RelationalKeysTabSection());
    }
    
    private ITabDescriptor createMessageContentDefinitionTabDescriptor() {
      return createTabDescriptor("messageContentDefinitionTab", "BPMN Data Message",
          new MessageContentDefinitionTabSection());
    }

}
