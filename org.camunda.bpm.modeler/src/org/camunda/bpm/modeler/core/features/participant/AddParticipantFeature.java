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
 * @author Ivar Meikas
 ******************************************************************************/
package org.camunda.bpm.modeler.core.features.participant;

import org.camunda.bpm.modeler.core.features.AbstractAddBpmnShapeFeature;
import org.camunda.bpm.modeler.core.utils.BusinessObjectUtil;
import org.camunda.bpm.modeler.core.utils.GraphicsUtil;
import org.camunda.bpm.modeler.core.utils.StyleUtil;
import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.di.BPMNShape;
import org.eclipse.graphiti.datatypes.IRectangle;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;

public class AddParticipantFeature extends AbstractAddBpmnShapeFeature<Participant> {

  public static final String MULTIPLICITY = "multiplicity";

  public AddParticipantFeature(IFeatureProvider fp) {
    super(fp);
  }

  @Override
  public boolean canAdd(IAddContext context) {
    boolean isParticipant = getBusinessObject(context) instanceof Participant;
    boolean addToDiagram = context.getTargetContainer() instanceof Diagram;
    return isParticipant && addToDiagram;
  }

  @Override
  protected ContainerShape createPictogramElement(IAddContext context, IRectangle bounds) {
    // adding a participant is a two step process
    // we add the basic shape here and will
    // add the text + flow elements later in #postAddHook
    Participant participant = getBusinessObject(context);

    IGaService gaService = Graphiti.getGaService();
    IPeService peService = Graphiti.getPeService();

    int x = bounds.getX();
    int y = bounds.getY();
    int width = bounds.getWidth();
    int height = bounds.getHeight();

    ContainerShape newShape = peService.createContainerShape(context.getTargetContainer(), true);

    Rectangle rect = gaService.createRectangle(newShape);
    StyleUtil.applyStyle(rect, participant);
    gaService.setLocationAndSize(rect, x, y, width, height);

    return newShape;
  }

  @Override
  protected void postAddHook(IAddContext context, ContainerShape newShape, IRectangle newShapeBounds) {
    super.postAddHook(context, newShape, newShapeBounds);

    Participant participant = getBusinessObject(context);

    IGaService gaService = Graphiti.getGaService();
    IPeService peService = Graphiti.getPeService();

    int width = newShapeBounds.getWidth();
    int height = newShapeBounds.getHeight();

    BPMNShape bpmnShape = BusinessObjectUtil.getFirstElementOfType(newShape, BPMNShape.class);

    drawParticipantLine(participant, newShape, width, height);

    Shape textShape = peService.createShape(newShape, false);
    Text text = gaService.createText(textShape, participant.getName());
    StyleUtil.applyStyle(text, participant);
    text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
    text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);

    link(textShape, new Object[] { participant });

    // BPMN Data Fix: We must set the multiplicity property to false, as the
    // current shape state dispays a single-instance participant. The update
    // feature can correct this the.
    peService.setPropertyValue(newShape, MULTIPLICITY, Boolean.toString(false));
  }

  @Override
  protected void adjustLocation(IAddContext context, int width, int height) {
    // do nothing
  }

  private void drawParticipantLine(Participant participant, ContainerShape participantShape, int width, int height) {

    IPeService peService = Graphiti.getPeService();
    IGaService gaService = Graphiti.getGaService();

    boolean hasLanes = false;
    if (participant.getProcessRef() != null) {
      hasLanes = participant.getProcessRef().getLaneSets().isEmpty() ? false : !participant.getProcessRef().getLaneSets().get(0).getLanes().isEmpty();
    }

    if (!hasLanes) {
      Shape lineShape = peService.createShape(participantShape, false);
      Polyline line = gaService
          .createPolyline(lineShape, new int[] { GraphicsUtil.PARTICIPANT_LABEL_OFFSET, 0, GraphicsUtil.PARTICIPANT_LABEL_OFFSET, height });
      StyleUtil.applyStyle(line, participant);
    }
  }

  @Override
  public int getDefaultHeight() {
    return 100;
  }

  @Override
  public int getDefaultWidth() {
    return 600;
  }

  @Override
  protected boolean isCreateExternalLabel() {
    return false;
  }
}
