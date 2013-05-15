package org.camunda.bpm.modeler.ui.features.flow;

import org.camunda.bpm.modeler.core.features.container.BaseElementConnectionFeatureContainer;
import org.camunda.bpm.modeler.core.features.flow.AbstractAddFlowFeature;
import org.camunda.bpm.modeler.core.features.flow.AbstractReconnectFlowFeature;
import org.camunda.bpm.modeler.core.utils.AnchorUtil;
import org.camunda.bpm.modeler.core.utils.BusinessObjectUtil;
import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.core.utils.FeatureSupport;
import org.camunda.bpm.modeler.core.utils.StyleUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.ui.features.CreateDataAssociationFeature;
import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.CatchEvent;
import org.eclipse.bpmn2.DataAssociation;
import org.eclipse.bpmn2.DataInputAssociation;
import org.eclipse.bpmn2.DataOutputAssociation;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.ThrowEvent;
import org.eclipse.bpmn2.di.BPMNEdge;
import org.eclipse.dd.di.DiagramElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.services.GraphitiUi;


public class DataAssociationFeatureContainer extends BaseElementConnectionFeatureContainer {

  private static final String IS_CONDITION_MARKER_PROPERTY = "isConditionMarker";
  private static final EStructuralFeature DATA_ASSOCIATION_CONDITION_FEATURE = BptPackage.eINSTANCE.getDocumentRoot_Condition();
  
  private static final String CONDITION_TEXT_PREFIX = "Condition: ";
	
  @Override
  public boolean canApplyTo(Object o) {
    return super.canApplyTo(o) && o instanceof DataAssociation;
  }
  
  public class AddDataAssocationFeature extends AbstractAddFlowFeature<DataAssociation> {

    public AddDataAssocationFeature(IFeatureProvider fp) {
      super(fp);
    }

    @Override
    protected Polyline createConnectionLine(Connection connection) {
      IPeService peService = Graphiti.getPeService();
      IGaService gaService = Graphiti.getGaService();
      BaseElement be = BusinessObjectUtil.getFirstBaseElement(connection);

      Polyline connectionLine = super.createConnectionLine(connection);
      connectionLine.setLineStyle(LineStyle.DOT);

      ConnectionDecorator endDecorator = peService.createConnectionDecorator(connection, false, 1.0, true);

      int w = 5;
      int l = 10;

      Polyline arrowhead = gaService.createPolyline(endDecorator, new int[] { -l, w, 0, 0, -l, -w });
      StyleUtil.applyStyle(arrowhead, be);
      
      return connectionLine;
    }
    
    @Override
    protected Class< ? extends BaseElement> getBusinessObjectClass() {
      return DataAssociation.class;
    }
    
    @Override
    protected void postAddHook(IAddContext context,
    		FreeFormConnection newConnection) {
    	super.postAddHook(context, newConnection);
    	addConditionElement(newConnection);
    }

	private void addConditionElement(FreeFormConnection connection) {
		DataAssociation association = BusinessObjectUtil.getFirstElementOfType(connection, DataAssociation.class);
		String currentCondition = (String) ExtensionUtil.getExtension(association, DATA_ASSOCIATION_CONDITION_FEATURE, "value");

		createConditionDecorator(connection, currentCondition);
	}
	
	private ConnectionDecorator createConditionDecorator(Connection connection, String condition) {
		if (condition != null) {
			condition = CONDITION_TEXT_PREFIX + condition;
		}
		
		ConnectionDecorator decorator = Graphiti.getPeService().createConnectionDecorator(connection, false, 0.0, true);
		DataAssociation association = BusinessObjectUtil.getFirstElementOfType(connection, DataAssociation.class);
		
		IGaService gaService = Graphiti.getGaService();
		Text conditionText = gaService.createText(decorator, condition);
		conditionText.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		conditionText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		
		StyleUtil.applyStyle(conditionText, association);
		decorator.setVisible(true);
		
		IDimension textDimensions = GraphitiUi.getUiLayoutService().calculateTextSize(condition, conditionText.getFont());
		gaService.setLocationAndSize(conditionText, 0, 0, textDimensions.getWidth(), textDimensions.getHeight());
		Graphiti.getPeService().setPropertyValue(decorator, IS_CONDITION_MARKER_PROPERTY, Boolean.toString(true));
		return decorator;
	}
  }
  
  public static class UpdateConditionFeature extends AbstractUpdateFeature {

	public UpdateConditionFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		return true;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		Connection connection = (Connection) context.getPictogramElement();
		DataAssociation association = BusinessObjectUtil.getFirstElementOfType(connection, DataAssociation.class);
		
		String currentCondition = (String) ExtensionUtil.getExtension(association, DATA_ASSOCIATION_CONDITION_FEATURE, "value");
		String previouslyDisplayedCondition = null;
		
		ConnectionDecorator decorator = FeatureSupport.getConnectionDecoratorFulfillingProperty(context, IS_CONDITION_MARKER_PROPERTY, Boolean.toString(true));
		if (decorator != null) {
			Text conditionText = (Text) decorator.getGraphicsAlgorithm();
			previouslyDisplayedCondition = conditionText.getValue();
			String regex = CONDITION_TEXT_PREFIX + "(.*)";
			previouslyDisplayedCondition = previouslyDisplayedCondition.replaceAll(regex, "$1");
		}
		
		if (currentCondition == null) {
			return previouslyDisplayedCondition != null ? Reason.createTrueReason() : Reason.createFalseReason();
		} else if (previouslyDisplayedCondition == null) {
			return Reason.createTrueReason();
		}
		
		if (previouslyDisplayedCondition.equals(currentCondition)) {
			return Reason.createFalseReason();
		} else {
			return Reason.createTrueReason();
		}
	}

	@Override
	public boolean update(IUpdateContext context) {
		Connection connection = (Connection) context.getPictogramElement();
		DataAssociation association = BusinessObjectUtil.getFirstElementOfType(connection, DataAssociation.class);

		String currentCondition = (String) ExtensionUtil.getExtension(association, DATA_ASSOCIATION_CONDITION_FEATURE, "value");
		String newText = "";
		if (currentCondition != null) {
			newText = CONDITION_TEXT_PREFIX + currentCondition;
		}
		
		setConditionText(context, newText);

		return true;
	}
	
	private void setConditionText(IUpdateContext context, String value) {
		ConnectionDecorator decorator = FeatureSupport.getConnectionDecoratorFulfillingProperty(context, IS_CONDITION_MARKER_PROPERTY, Boolean.toString(true));
		
		if (decorator != null) {
			Text textGa = (Text) decorator.getGraphicsAlgorithm();
			IDimension textDimensions = GraphitiUi.getUiLayoutService().calculateTextSize(value, textGa.getFont());
			textGa.setHeight(textDimensions.getHeight());
			textGa.setWidth(textDimensions.getWidth());
			textGa.setValue(value);
		}
	}
	  
  }
 
  
  public static class ReconnectDataAssociationFeature extends AbstractReconnectFlowFeature {
    
    public ReconnectDataAssociationFeature(IFeatureProvider fp) {
      super(fp);
    }

    @Override
    public boolean canReconnect(IReconnectionContext context) {
      DataAssociation dataAssociation = BusinessObjectUtil.getFirstElementOfType(context.getConnection(), DataAssociation.class);
      BaseElement targetElement = BusinessObjectUtil.getFirstElementOfType(context.getTargetPictogramElement(), BaseElement.class);
      if (dataAssociation instanceof DataInputAssociation) {
        if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
          if (targetElement instanceof ItemAwareElement) {
            return true;
          }
        }
        if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_TARGET)) {
          if (targetElement instanceof Activity || targetElement instanceof ThrowEvent) {
            return true;
          }
        }
        return false;
      }
      if (dataAssociation instanceof DataOutputAssociation) {
        if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
          if (targetElement instanceof Activity || targetElement instanceof CatchEvent) {
            return true;
          }
        }
        if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_TARGET)) {
          if (targetElement instanceof ItemAwareElement) {
            return true;
          }
        }
      }
      return false;
    }

    @Override
    protected Class<? extends EObject> getTargetClass() {
      return BaseElement.class;
    }

    @Override
    protected Class<? extends EObject> getSourceClass() {
      return BaseElement.class;
    }

    @Override
    public void postReconnect(IReconnectionContext context) {
      Anchor oldAnchor = context.getOldAnchor();
      AnchorContainer oldAnchorContainer = oldAnchor.getParent();
      AnchorUtil.deleteConnectionPointIfPossible(getFeatureProvider(), (Shape) oldAnchorContainer);
      
      BPMNEdge edge = BusinessObjectUtil.getFirstElementOfType(context.getConnection(), BPMNEdge.class);
      DiagramElement de = BusinessObjectUtil.getFirstElementOfType(context.getTargetPictogramElement(), DiagramElement.class);
      if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_TARGET)) {
        edge.setTargetElement(de);
      }
      else {
        edge.setSourceElement(de);
      }
      
      DataAssociation dataAssociation = BusinessObjectUtil.getFirstElementOfType(context.getConnection(), DataAssociation.class);
      BaseElement targetElement = BusinessObjectUtil.getFirstElementOfType(context.getTargetPictogramElement(), BaseElement.class);
      if (dataAssociation instanceof DataInputAssociation) {
        if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
          if (targetElement instanceof ItemAwareElement) {
            dataAssociation.getSourceRef().clear();
            dataAssociation.getSourceRef().add((ItemAwareElement) targetElement);
          }
          return;
        }
        if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_TARGET)) {
          if (targetElement instanceof Activity) {
            Activity activity = (Activity) targetElement;
            activity.getDataInputAssociations().add((DataInputAssociation) dataAssociation);
          } else if (targetElement instanceof ThrowEvent) {
            ThrowEvent throwEvent = (ThrowEvent) targetElement;
            throwEvent.getDataInputAssociation().add((DataInputAssociation) dataAssociation);
          }
          return;
        }
      }
      if (dataAssociation instanceof DataOutputAssociation) {
        if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
          if (targetElement instanceof Activity) {
            Activity activity = (Activity) targetElement;
            activity.getDataOutputAssociations().add((DataOutputAssociation) dataAssociation);
          } else if (targetElement instanceof CatchEvent) {
            CatchEvent throwEvent = (CatchEvent) targetElement;
            throwEvent.getDataOutputAssociation().add((DataOutputAssociation) dataAssociation);
          }
          return;
        }
        if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_TARGET)) {
          if (targetElement instanceof ItemAwareElement) {
            dataAssociation.setTargetRef((ItemAwareElement) targetElement);
          }
        }
      }
    }
  } 

  @Override
  public IAddFeature getAddFeature(IFeatureProvider fp) {
    return new AddDataAssocationFeature(fp);
  }

  @Override
  public ICreateConnectionFeature getCreateConnectionFeature(IFeatureProvider fp) {
    return new CreateDataAssociationFeature(fp);
  }
  
  @Override
  public IReconnectionFeature getReconnectionFeature(IFeatureProvider fp) {
    return new ReconnectDataAssociationFeature(fp);
  }
  
  @Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
	  // TODO multi update feature
	  return new UpdateConditionFeature(fp);
	}

}
