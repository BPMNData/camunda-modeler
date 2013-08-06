/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpt.schemamapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.unipotsdam.hpi.bpt.schemamapping.DocumentRoot#getSchemaMapping <em>Schema Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.unipotsdam.hpi.bpt.schemamapping.SchemamappingPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
  /**
   * Returns the value of the '<em><b>Schema Mapping</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Schema Mapping</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Schema Mapping</em>' containment reference.
   * @see #setSchemaMapping(SchemaMapping)
   * @see de.unipotsdam.hpi.bpt.schemamapping.SchemamappingPackage#getDocumentRoot_SchemaMapping()
   * @model containment="true" required="true" derived="true" ordered="false"
   *        extendedMetaData="name='schemaMapping' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  SchemaMapping getSchemaMapping();

  /**
   * Sets the value of the '{@link de.unipotsdam.hpi.bpt.schemamapping.DocumentRoot#getSchemaMapping <em>Schema Mapping</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Schema Mapping</em>' containment reference.
   * @see #getSchemaMapping()
   * @generated
   */
  void setSchemaMapping(SchemaMapping value);

} // DocumentRoot
