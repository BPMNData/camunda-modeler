/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema Mapping Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.SchemaMappingImport#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getSchemaMappingImport()
 * @model extendedMetaData="name='tSchemaMappingImport' kind='empty' namespace='##targetNamespace'"
 * @generated
 */
public interface SchemaMappingImport extends EObject {
  /**
   * Returns the value of the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Location</em>' attribute.
   * @see #setLocation(String)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getSchemaMappingImport_Location()
   * @model required="true" derived="true" ordered="false"
   *        extendedMetaData="kind='attribute' name='location'"
   * @generated
   */
  String getLocation();

  /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.SchemaMappingImport#getLocation <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Location</em>' attribute.
   * @see #getLocation()
   * @generated
   */
  void setLocation(String value);

} // SchemaMappingImport
