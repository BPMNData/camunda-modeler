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
package org.camunda.bpm.modeler.ui.features.activity.subprocess;

import org.camunda.bpm.modeler.core.features.AbstractUpdateBaseElementFeature;
import org.camunda.bpm.modeler.core.features.MultiUpdateFeature;
import org.camunda.bpm.modeler.core.features.activity.task.DirectEditActivityFeature;
import org.camunda.bpm.modeler.core.utils.FeatureSupport;
import org.camunda.bpm.modeler.ui.features.activity.AbstractActivityFeatureContainer;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.CallActivity;
import org.eclipse.bpmn2.CallChoreography;
import org.eclipse.bpmn2.FlowElementsContainer;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;

public abstract class AbstractExpandableActivityFeatureContainer extends
        AbstractActivityFeatureContainer {

    public static final String IS_TITLE_SHAPE_PROPERTY_KEY = "isTitleShape";

    @Override
    public IDirectEditingFeature getDirectEditingFeature(IFeatureProvider fp) {
        return new DirectEditActivityFeature(fp);
    }

    @Override
    public ILayoutFeature getLayoutFeature(IFeatureProvider fp) {
        return new LayoutExpandableActivityFeature(fp);
    }

    @Override
    public MultiUpdateFeature getUpdateFeature(IFeatureProvider fp) {
        MultiUpdateFeature multiUpdate = super.getUpdateFeature(fp);
        AbstractUpdateBaseElementFeature nameUpdateFeature = new AbstractUpdateBaseElementFeature(
                fp) {
            @Override
            public boolean canUpdate(IUpdateContext context) {
                Object bo = getBusinessObjectForPictogramElement(context
                        .getPictogramElement());
                return bo != null && bo instanceof BaseElement
                        && canApplyTo((BaseElement) bo);
            }

            @Override
            public boolean update(IUpdateContext context) {
                PictogramElement pe = context.getPictogramElement();
                IPeService peService = Graphiti.getPeService();
                if (pe instanceof ContainerShape) {
                    ContainerShape cs = (ContainerShape) pe;
                    for (Shape shape : cs.getChildren()) {
                        if (Boolean.parseBoolean(peService.getPropertyValue(shape,
                                IS_TITLE_SHAPE_PROPERTY_KEY))
                                && shape.getGraphicsAlgorithm() instanceof AbstractText) {
                            AbstractText text = (AbstractText) shape
                                    .getGraphicsAlgorithm();
                            String value = FeatureSupport
                                    .getBusinessValue(context);
                            if (value == null) {
                                value = "";
                            }
                            text.setValue(value);
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        multiUpdate.addUpdateFeature(nameUpdateFeature);
        return multiUpdate;
    }

    @Override
    public IResizeShapeFeature getResizeFeature(IFeatureProvider fp) {
        return new ResizeExpandableActivityFeature(fp);
    }

    @Override
    public ICustomFeature[] getCustomFeatures(IFeatureProvider fp) {
        ICustomFeature[] superFeatures = super.getCustomFeatures(fp);
        ICustomFeature[] thisFeatures = new ICustomFeature[4 + superFeatures.length];
        thisFeatures[0] = new ExpandFlowNodeFeature(fp);
        thisFeatures[1] = new CollapseFlowNodeFeature(fp);
        thisFeatures[2] = new PushdownFeature(fp);
        thisFeatures[3] = new PullupFeature(fp);
        for (int i = 0; i < superFeatures.length; ++i)
            thisFeatures[4 + i] = superFeatures[i];
        return thisFeatures;
    }

    public static boolean isExpandableElement(Object be) {
        return be instanceof FlowElementsContainer
                || be instanceof CallActivity || be instanceof CallChoreography;
    }
}