/**
 */
package org.camunda.bpm.modeler.runtime.engine.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines a (potential) value for the form property. Especially useful when using 'enum' as type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.PrimaryKey#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.ModelPackage#getPrimaryKey()
 * @model extendedMetaData="name='value_._type' kind='empty'"
 * @generated
 */
public interface PrimaryKey extends EObject {
	/**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Defines the internal value for the form property value.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.camunda.bpm.modeler.runtime.engine.model.ModelPackage#getPrimaryKey_Id()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
	String getId();

	/**
     * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.PrimaryKey#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
	void setId(String value);

} // PrimaryKey
