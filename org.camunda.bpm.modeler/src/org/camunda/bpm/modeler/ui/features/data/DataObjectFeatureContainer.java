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
 * @author Innar Made
 ******************************************************************************/
package org.camunda.bpm.modeler.ui.features.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.camunda.bpm.modeler.core.features.AbstractCreateFlowElementFeature;
import org.camunda.bpm.modeler.core.features.MultiUpdateFeature;
import org.camunda.bpm.modeler.core.features.UpdateBaseElementNameFeature;
import org.camunda.bpm.modeler.core.features.data.AddDataFeature;
import org.camunda.bpm.modeler.core.features.data.Properties;
import org.camunda.bpm.modeler.core.model.Bpmn2ModelerFactory;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.bpmn2.DataObjectReference;
import org.eclipse.bpmn2.FlowElement;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.internal.util.ui.PopupMenu;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class DataObjectFeatureContainer extends AbstractDataFeatureContainer {

	@Override
	public boolean canApplyTo(Object o) {
		return super.canApplyTo(o) && o instanceof DataObject;
	}

	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateDataObjectFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddDataObjectFeature(fp);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		MultiUpdateFeature multiUpdate = new MultiUpdateFeature(fp);

		multiUpdate.addUpdateFeature(new UpdateMarkersFeature(fp));
		multiUpdate.addUpdateFeature(new UpdateBaseElementNameFeature(fp));
		multiUpdate.addUpdateFeature(new UpdateDataStateFeature(fp));
		// BPMN Data: Add update features for the BPMN Data extensions.
		multiUpdate.addUpdateFeature(new UpdateDataObjectPrimaryKeyFeature(fp));
		multiUpdate.addUpdateFeature(new UpdateDataObjectForeignKeyFeature(fp));
		multiUpdate.addUpdateFeature(new UpdateDataObjectOperationTypeFeature(fp));
		
		return multiUpdate;
	}

	private static class AddDataObjectFeature extends AddDataFeature<DataObject> {
		private AddDataObjectFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		public String getName(DataObject t) {
			return t.getName();
		}
	}

	private class UpdateMarkersFeature extends AbstractUpdateFeature {

		public UpdateMarkersFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		public boolean canUpdate(IUpdateContext context) {
			Object o = getBusinessObjectForPictogramElement(context.getPictogramElement());
			return o != null && o instanceof BaseElement && canApplyTo(o);
		}

		@Override
		public IReason updateNeeded(IUpdateContext context) {
			IPeService peService = Graphiti.getPeService();
			ContainerShape container = (ContainerShape) context.getPictogramElement();
			DataObject data = (DataObject) getBusinessObjectForPictogramElement(container);
			boolean isCollection = Boolean.parseBoolean(peService.getPropertyValue(container,
					Properties.COLLECTION_PROPERTY));
			return data.isIsCollection() != isCollection ? Reason.createTrueReason() : Reason.createFalseReason();
		}

		@Override
		public boolean update(IUpdateContext context) {
			IPeService peService = Graphiti.getPeService();
			ContainerShape container = (ContainerShape) context.getPictogramElement();
			DataObject data = (DataObject) getBusinessObjectForPictogramElement(container);

			boolean drawCollectionMarker = data.isIsCollection();

			Iterator<Shape> iterator = peService.getAllContainedShapes(container).iterator();
			while (iterator.hasNext()) {
				Shape shape = iterator.next();
				String prop = peService.getPropertyValue(shape, Properties.HIDEABLE_PROPERTY);
				if (prop != null && new Boolean(prop)) {
					Polyline line = (Polyline) shape.getGraphicsAlgorithm();
					line.setLineVisible(drawCollectionMarker);
				}
			}

			peService.setPropertyValue(container, Properties.COLLECTION_PROPERTY,
					Boolean.toString(data.isIsCollection()));
			return true;
		}
	}

	public static class CreateDataObjectFeature extends AbstractCreateFlowElementFeature<FlowElement> {

		private static ILabelProvider labelProvider = new ILabelProvider() {

			public void removeListener(ILabelProviderListener listener) {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void dispose() {

			}

			public void addListener(ILabelProviderListener listener) {

			}

			public String getText(Object element) {
				if (((DataObject) element).getId() == null)
					return ((DataObject) element).getName();
				return "Reference existing \"" + ((DataObject) element).getName() + "\"";
			}

			public Image getImage(Object element) {
				return null;
			}

		};

		public CreateDataObjectFeature(IFeatureProvider fp) {
			super(fp, "Data Object",
					"Provides information about what activities require to be performed or what they produce");
		}

		@Override
		public String getStencilImageId() {
			return ImageProvider.IMG_16_DATA_OBJECT;
		}

		/* (non-Javadoc)
		 * @see org.camunda.bpm.modeler.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getDataObject();
		}

		@Override
		public FlowElement createBusinessObject(ICreateContext context) {
			FlowElement bo = null;

			DataObjectReference dataObjectReference = null;
			DataObject dataObject = null;
			ModelHandler mh = ModelHandler.getInstance(getDiagram());
			dataObjectReference = Bpmn2ModelerFactory.create(DataObjectReference.class);
			dataObject = Bpmn2ModelerFactory.create(DataObject.class);
			dataObject.setName("Create a new Data Object");
			Object container = getBusinessObjectForPictogramElement(context.getTargetContainer());

			List<DataObject> dataObjectList = new ArrayList<DataObject>();
			dataObjectList.add(dataObject);
			TreeIterator<EObject> iter = mh.getDefinitions().eAllContents();
			while (iter.hasNext()) {
				EObject obj = iter.next();
				if (obj instanceof DataObject)
					dataObjectList.add((DataObject) obj);
			}

			DataObject result = dataObject;
			if (dataObjectList.size() > 1) {
				PopupMenu popupMenu = new PopupMenu(dataObjectList, labelProvider);
				boolean b = popupMenu.show(Display.getCurrent().getActiveShell());
				if (b) {
					result = (DataObject) popupMenu.getResult();
				}
			}
			
			if (result == dataObject) { // the new one
				mh.addFlowElement(container, dataObject);
				ModelUtil.setID(dataObject);
				dataObject.setIsCollection(false);
				dataObject.setName(ModelUtil.toDisplayName(dataObject.getId()));
				dataObjectReference.setName(dataObject.getName());
				bo = dataObject;
			} else {
				mh.addFlowElement(container,dataObjectReference);
				ModelUtil.setID(dataObjectReference);
				dataObjectReference.setName(result.getName() + " Ref");
				dataObjectReference.setDataObjectRef(result);
				dataObject = result;
				bo = dataObjectReference;
			}
			putBusinessObject(context, bo);
			return bo;
		}
	}
}