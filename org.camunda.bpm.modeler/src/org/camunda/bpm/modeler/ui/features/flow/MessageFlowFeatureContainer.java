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
package org.camunda.bpm.modeler.ui.features.flow;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.camunda.bpm.modeler.core.features.DirectEditNamedConnectionFeature;
import org.camunda.bpm.modeler.core.features.UpdateBaseElementNameFeature;
import org.camunda.bpm.modeler.core.features.container.BaseElementConnectionFeatureContainer;
import org.camunda.bpm.modeler.core.features.flow.AbstractAddFlowFeature;
import org.camunda.bpm.modeler.core.features.flow.AbstractCreateFlowFeature;
import org.camunda.bpm.modeler.core.features.flow.AbstractReconnectFlowFeature;
import org.camunda.bpm.modeler.core.handler.ConversationHandler;
import org.camunda.bpm.modeler.core.utils.BusinessObjectUtil;
import org.camunda.bpm.modeler.core.utils.ConnectionLabelUtil;
import org.camunda.bpm.modeler.core.utils.StyleUtil;
import org.camunda.bpm.modeler.ui.ImageProvider;
import org.camunda.bpm.modeler.ui.diagram.BPMN2FeatureProvider;
import org.camunda.bpm.modeler.ui.features.choreography.ChoreographyUtil;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Collaboration;
import org.eclipse.bpmn2.ConversationNode;
import org.eclipse.bpmn2.FlowNode;
import org.eclipse.bpmn2.InteractionNode;
import org.eclipse.bpmn2.Message;
import org.eclipse.bpmn2.MessageFlow;
import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.Process;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.util.IColorConstant;

public class MessageFlowFeatureContainer extends BaseElementConnectionFeatureContainer {

  @Override
  public boolean canApplyTo(Object o) {
    return super.canApplyTo(o) && o instanceof MessageFlow;
  }

  @Override
  public IAddFeature getAddFeature(IFeatureProvider fp) {
    return new AddMessageFlowFeature(fp);
  }

  @Override
  public ICreateConnectionFeature getCreateConnectionFeature(IFeatureProvider fp) {
    return new CreateMessageFlowFeature(fp);
  }

  @Override
  public IDirectEditingFeature getDirectEditingFeature(IFeatureProvider fp) {
    return new DirectEditNamedConnectionFeature(fp);
  }

  @Override
  public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
    return new UpdateBaseElementNameFeature(fp);
  }

  @Override
  public IReconnectionFeature getReconnectionFeature(IFeatureProvider fp) {
    return new ReconnectMessageFlowFeature(fp);
  }

  public static class AddMessageFlowFeature extends AbstractAddFlowFeature<MessageFlow> {

    public AddMessageFlowFeature(IFeatureProvider fp) {
      super(fp);
    }

    @Override
    protected Polyline createConnectionLine(Connection connection) {
      IPeService peService = Graphiti.getPeService();
      IGaService gaService = Graphiti.getGaService();
      BaseElement be = BusinessObjectUtil.getFirstBaseElement(connection);

      Polyline connectionLine = super.createConnectionLine(connection);
      connectionLine.setLineStyle(LineStyle.DASH);
      connectionLine.setLineWidth(2);

      ConnectionDecorator endDecorator = peService.createConnectionDecorator(connection, false, 1.0, true);
      ConnectionDecorator startDecorator = peService.createConnectionDecorator(connection, false, 0, true);

      int w = 5;
      int l = 10;

      Polyline arrowhead = gaService.createPolygon(endDecorator, new int[] { -l, w, 0, 0, -l, -w, -l, w });
      StyleUtil.applyStyle(arrowhead, be);
      arrowhead.setBackground(manageColor(IColorConstant.WHITE));

      Ellipse circle = gaService.createEllipse(startDecorator);
      gaService.setSize(circle, 10, 10);
      StyleUtil.applyStyle(circle, be);
      circle.setBackground(manageColor(IColorConstant.WHITE));

      return connectionLine;
    }

    @Override
    protected void postAddHook(IAddContext context, FreeFormConnection connection) {
      if (!isImport(context)) {
        createMessage(context, connection);
      }
    }

    @Override
    protected Class<? extends BaseElement> getBusinessObjectClass() {
      return MessageFlow.class;
    }

    @Override
    protected boolean isCreateExternalLabel() {
      return true;
    }

    /**
     * Creates a label for the newly created shape if any.
     * 
     * May be overridden by subclasses to perform actual actions.
     * 
     * @param context
     * @param newShape
     */
    protected void createMessage(IAddContext context, Connection connection) {

      MessageFlow messageFlow = getBusinessObject(context);

      BPMN2FeatureProvider featureProvider = (BPMN2FeatureProvider) getFeatureProvider();
      ICreateFeature createMessageFeature = (ICreateFeature) featureProvider.getCreateFeatureForBusinessObject(Message.class);
      CreateContext createContext = new CreateContext();
      createContext.setTargetContainer(getDiagram());
      Point defaultLabelPosition = ConnectionLabelUtil.getDefaultLabelPosition(connection);
      createContext.setLocation(defaultLabelPosition.getX(), defaultLabelPosition.getY());
      
      if (!createMessageFeature.canCreate(createContext)) {
        throw new RuntimeException("Cannot create message!");
      }
      Object[] createdObjects = createMessageFeature.create(createContext);
      Message message = (Message) createdObjects[0];
      messageFlow.setMessageRef(message);

    }
    
  }

  public static class CreateMessageFlowFeature extends AbstractCreateFlowFeature<MessageFlow, InteractionNode, InteractionNode> {

    public CreateMessageFlowFeature(IFeatureProvider fp) {
      super(fp, "Message Flow", "Represents message between two participants");
    }

    @Override
    public boolean canStartConnection(ICreateConnectionContext context) {
      PictogramElement sourceElement = context.getSourcePictogramElement();
      if (ChoreographyUtil.isChoreographyParticipantBand(sourceElement)) {
        return false;
      }

      Diagram diagram = getDiagram();

      if (diagram.equals(sourceElement)) {
        return false;
      }

      return true;
    }

    @Override
    public boolean canCreate(ICreateConnectionContext context) {
      if (ChoreographyUtil.isChoreographyParticipantBand(context.getSourcePictogramElement()))
        return false;

      if (context.getTargetPictogramElement() != null) {
        if (ChoreographyUtil.isChoreographyParticipantBand(context.getTargetPictogramElement()))
          return false;
      }
      InteractionNode source = getSourceBo(context);
      InteractionNode target = getTargetBo(context);
      return super.canCreate(context) && isDifferentParticipants(source, target);
    }

    @Override
    protected String getStencilImageId() {
      return ImageProvider.IMG_16_MESSAGE_FLOW;
    }

    @Override
    public MessageFlow createBusinessObject(ICreateConnectionContext context) {
      ModelHandler mh = ModelHandler.getInstance(getDiagram());
      InteractionNode source = getSourceBo(context);
      InteractionNode target = getTargetBo(context);
      MessageFlow bo = mh.createMessageFlow(source, target);
      bo.setName("");
      putBusinessObject(context, bo);

      return bo;
    }

    @Override
    protected Class<InteractionNode> getSourceClass() {
      return InteractionNode.class;
    }

    @Override
    protected Class<InteractionNode> getTargetClass() {
      return InteractionNode.class;
    }

    private boolean isDifferentParticipants(InteractionNode source, InteractionNode target) {
      if (source == null || target == null) {
        return true;
      }

      boolean different = false;

      ModelHandler handler = ModelHandler.getInstance(getDiagram());
      Participant sourceParticipant = handler.getParticipant(source);
      Participant targetParticipant = handler.getParticipant(target);
      if (sourceParticipant == null) {
        if (targetParticipant == null)
          return true;
        return false;
      }

      different = !sourceParticipant.equals(targetParticipant);
      return different;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.camunda.bpm.modeler.features.AbstractBpmn2CreateConnectionFeature
     * #getBusinessObjectClass()
     */
    @Override
    public EClass getBusinessObjectClass() {
      return Bpmn2Package.eINSTANCE.getMessageFlow();
    }
    
    @Override
    protected void postCreateHook(ICreateConnectionContext context, MessageFlow bo) {
      super.postCreateHook(context, bo);

      // Ensure some BPMN conformance.
      // Add the message flow to a conversation.
      EObject diagramBo = BusinessObjectUtil.getBusinessObjectForPictogramElement(getDiagram());
      if (diagramBo == null || !(diagramBo instanceof Collaboration)) {
        System.err.println("Warning: expected diagram to be a collaboration");
        return;
      }
      Collaboration collaboration = (Collaboration) diagramBo;
      ModelHandler modelHandler = ModelHandler.getInstance(getDiagram());
      ConversationNode conversation = ConversationHandler.getOrCreateConversation(collaboration, modelHandler);
      conversation.getMessageFlowRefs().add(bo);
    }
  }

  public static class ReconnectMessageFlowFeature extends AbstractReconnectFlowFeature {

    public ReconnectMessageFlowFeature(IFeatureProvider fp) {
      super(fp);
    }

    @Override
    public boolean canReconnect(IReconnectionContext context) {
      if (super.canReconnect(context)) {
        boolean reconnectSource = ReconnectionContext.RECONNECT_SOURCE.equals(context.getReconnectType());

        Anchor sourceAnchor = reconnectSource ? context.getNewAnchor() : context.getConnection().getStart();
        Anchor targetAnchor = reconnectSource ? context.getConnection().getEnd() : context.getNewAnchor();

        AnchorContainer sourceContainer = sourceAnchor.getParent();
        AnchorContainer targetContainer = targetAnchor.getParent();

        InteractionNode sourceElement = (InteractionNode) BusinessObjectUtil.getFirstBaseElement(sourceContainer);
        InteractionNode targetElement = (InteractionNode) BusinessObjectUtil.getFirstBaseElement(targetContainer);

        FlowNode nonParticipant;
        Participant participant;

        if (sourceElement instanceof Participant && targetElement instanceof Participant) {
          if (sourceElement.equals(targetElement)) {
            return false;
          }

          Participant sourceParticipant = (Participant) sourceElement;
          Participant targetParticipant = (Participant) targetElement;

          return sourceParticipant.getProcessRef() == null && targetParticipant.getProcessRef() == null;
        } else if (sourceElement instanceof Participant) {
          participant = (Participant) sourceElement;
          nonParticipant = (FlowNode) targetElement;

          return !getProcess(nonParticipant).equals(participant.getProcessRef());
        } else if (targetElement instanceof Participant) {
          participant = (Participant) targetElement;
          nonParticipant = (FlowNode) sourceElement;

          return !getProcess(nonParticipant).equals(participant.getProcessRef());
        } else {
          Process sourceProcess = getProcess((FlowNode) sourceElement);
          Process targetProcess = getProcess((FlowNode) targetElement);

          return sourceProcess != null && !sourceProcess.equals(targetProcess);
        }
      } else {
        return false;
      }
    }

    protected Process getProcess(FlowNode node) {
      EObject parent = node.eContainer();
      if (parent instanceof Process) {
        return (Process) parent;
      } else {
        return null;
      }
    }

    @Override
    protected Class<? extends EObject> getTargetClass() {
      return InteractionNode.class;
    }

    @Override
    protected Class<? extends EObject> getSourceClass() {
      return InteractionNode.class;
    }
  }
}