/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Superclass for primary and foreign keys.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey#getId <em>Id</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getRelationalKey()
 * @model abstract="true"
 *        extendedMetaData="name='tRelationalKey' kind='simple'"
 * @generated
 */
public interface RelationalKey extends EObject {
    /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Defines the id of this object.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getRelationalKey_Id()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='id'"
   * @generated
   */
    String getId();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
    void setId(String value);

    /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Defines the value of this object.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getRelationalKey_Value()
   * @model default="" dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='simple' name=':0'"
   * @generated
   */
    String getValue();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
    void setValue(String value);

} // RelationalKey
