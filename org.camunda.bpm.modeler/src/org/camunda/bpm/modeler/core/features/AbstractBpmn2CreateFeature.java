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

package org.camunda.bpm.modeler.core.features;

import java.util.List;

import org.camunda.bpm.modeler.core.adapters.AdapterUtil;
import org.camunda.bpm.modeler.core.adapters.ExtendedPropertiesAdapter;
import org.camunda.bpm.modeler.core.runtime.ModelEnablementDescriptor;
import org.camunda.bpm.modeler.core.runtime.TargetRuntime;
import org.camunda.bpm.modeler.core.utils.BusinessObjectUtil;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.IExecutionInfo;
import org.eclipse.graphiti.features.IFeatureAndContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * @author Bob Brodt
 *
 */
public abstract class AbstractBpmn2CreateFeature<T extends BaseElement>
		extends AbstractCreateFeature
		implements IBpmn2CreateFeature<T, ICreateContext> {
	
	public static final String SKIP_ADD_GRAPHICS = "DONT_ADD";
	
	/**
	 * @param fp
	 * @param name
	 * @param description
	 */
	public AbstractBpmn2CreateFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.func.ICreate#canCreate(org.eclipse.graphiti.features.context.ICreateContext)
	 */
	@Override
	public boolean canCreate(ICreateContext context) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.func.ICreate#create(org.eclipse.graphiti.features.context.ICreateContext)
	 */
	@Override
	public Object[] create(ICreateContext context) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.features.impl.AbstractFeature#isAvailable(org.eclipse.graphiti.features.context.IContext)
	 */
	@Override
	public boolean isAvailable(IContext context) {
		List<ModelEnablementDescriptor> enablements = TargetRuntime.getCurrentRuntime().getModelEnablements();
		for (ModelEnablementDescriptor e : enablements) {
			if (e.isEnabled(getBusinessObjectClass()))
				return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.features.impl.AbstractCreateFeature#getCreateDescription()
	 */
	@Override
	public String getCreateDescription() {
		return "Create " + ModelUtil.toDisplayName( getBusinessObjectClass().getName());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T createBusinessObject(ICreateContext context) {
		Shape shape = context.getTargetContainer();
		EObject container = BusinessObjectUtil.getBusinessObjectForPictogramElement(shape);
		Resource resource = container.eResource();
		EClass eclass = getBusinessObjectClass();
		ExtendedPropertiesAdapter adapter = (ExtendedPropertiesAdapter) AdapterUtil.adapt(eclass, ExtendedPropertiesAdapter.class);
		T businessObject = (T)adapter.getObjectDescriptor().createObject(resource,eclass);
		putBusinessObject(context, businessObject);
		return businessObject;
	}
	
	@SuppressWarnings("unchecked")
	public T getBusinessObject(ICreateContext context) {
		return (T) context.getProperty(PropertyNames.BUSINESS_OBJECT);
	}
	
	public void putBusinessObject(ICreateContext context, T businessObject) {
		context.putProperty(PropertyNames.BUSINESS_OBJECT, businessObject);
	}

	public void postExecute(IExecutionInfo executionInfo) {
		for (IFeatureAndContext fc : executionInfo.getExecutionList()) {
			IContext context = fc.getContext();
			if (context instanceof ICreateContext) {
				ICreateContext cc = (ICreateContext)context;
				T businessObject = getBusinessObject(cc);
				
				// FIXME Cleanup
				
//				Bpmn2Preferences prefs = (Bpmn2Preferences) ((DiagramEditor) getDiagramEditor()).getAdapter(Bpmn2Preferences.class);
//				if (prefs!=null && prefs.getShowPopupConfigDialog(businessObject)) {
//					ObjectEditingDialog dialog =
//							new ObjectEditingDialog((DiagramEditor)getDiagramEditor(), businessObject);
//					dialog.open();
//				}
			}
		}
	}
}
