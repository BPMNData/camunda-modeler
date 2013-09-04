package org.camunda.bpm.modeler.core.features.flow;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.modeler.core.utils.StyleUtil;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.services.GraphitiUi;

/**
 * This is a builder class that creates labels for {@link Connection} objects.
 *
 */
public class ConnectionTextDecoratorBuilder {

	private Connection connection;
	private String content;
	private Map<String, String> properties;
	private BaseElement businessObject;
	private int x;
	private int y;
	
	private ConnectionTextDecoratorBuilder() {
	}
	
	public ConnectionTextDecoratorBuilder content(String content) {
		this.content = content;
		return this;
	}
	
	/**
	 * Collects properties that will later on be set for the created label.
	 * 
	 * @see IPeService#setPropertyValue(org.eclipse.graphiti.mm.PropertyContainer, String, String)
	 */
	public ConnectionTextDecoratorBuilder textProperty(String key, String value) {
		properties.put(key, value);
		return this;
	}
	
	public ConnectionTextDecoratorBuilder businessObject(BaseElement businessObject) {
		this.businessObject = businessObject;
		return this;
	}
	
	public ConnectionTextDecoratorBuilder location(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public ConnectionDecorator build() {
		ConnectionDecorator decorator = Graphiti.getPeService().createConnectionDecorator(connection, false, 0.0, true);
		
		IGaService gaService = Graphiti.getGaService();
		Text conditionText = gaService.createText(decorator, content);
		conditionText.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		conditionText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		
		StyleUtil.applyStyle(conditionText, businessObject);
		decorator.setVisible(true);
		
		if (content != null) {
			IDimension textDimensions = GraphitiUi.getUiLayoutService().calculateTextSize(content, conditionText.getFont());
			gaService.setLocationAndSize(conditionText, x, y, textDimensions.getWidth(), textDimensions.getHeight());
		} else {
			gaService.setLocation(conditionText, x, y);
		}
		
		
		for (Map.Entry<String, String> propertyPair : properties.entrySet()) {
			Graphiti.getPeService().setPropertyValue(decorator, propertyPair.getKey(), propertyPair.getValue());
		}
		
		return decorator;
	}
	
	/** Creates a new instance that builds a decorator for the given connection. */
	public static ConnectionTextDecoratorBuilder newBuilder(Connection connectionToDecorate) {
		ConnectionTextDecoratorBuilder builder = new ConnectionTextDecoratorBuilder();
		builder.connection = connectionToDecorate;
		builder.properties = new HashMap<String, String>();
		builder.x = 0;
		builder.y = 0;
		return builder;
	}
	
}
