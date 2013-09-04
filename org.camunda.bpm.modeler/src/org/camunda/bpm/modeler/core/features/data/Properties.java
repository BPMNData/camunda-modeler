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
package org.camunda.bpm.modeler.core.features.data;

import org.eclipse.bpmn2.ItemAwareElement;

/** This interface holds property-related constants for the {@link ItemAwareElement} visualization. */
public interface Properties {
	
	public static final String COLLECTION_PROPERTY = "isCollection";

	public static final String HIDEABLE_PROPERTY = "hideable";
	
	public static final String IS_DATA_STATE_SHAPE = "isDataStateText";
	
	/** Property key, that marks a shape as the label for the primary key BPMN Data extension. */
	public static final String IS_PRIMARY_KEY_SHAPE = "isPrimaryKey";
	
	/** Property key, that marks a shape as the label for the foreign key BPMN Data extension. */
	public static final String IS_FOREIGN_KEY_SHAPE = "isForeignKeys";
	
	/** Property key, that marks a shape as the label for the operation type BPMN Data extension. */
	public static final String IS_OPERATION_TYPE_SHAPE = "isOperationType";
	
}
