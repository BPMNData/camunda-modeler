/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines a primary key as extension to data objects.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getPrimaryKey()
 * @model extendedMetaData="name='tPrimaryKey' kind='simple'"
 * @generated
 */
public interface PrimaryKey extends RelationalKey {

    /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The default value is <code>""</code>.
   * The literals are from the enumeration {@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType}.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Defines what kind of operation is required on the associated data object.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType
   * @see #setType(PrimaryKeyType)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getPrimaryKey_Type()
   * @model default=""
   *        extendedMetaData="kind='attribute' name='type'"
   * @generated
   */
    PrimaryKeyType getType();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType
   * @see #getType()
   * @generated
   */
    void setType(PrimaryKeyType value);

} // PrimaryKey
