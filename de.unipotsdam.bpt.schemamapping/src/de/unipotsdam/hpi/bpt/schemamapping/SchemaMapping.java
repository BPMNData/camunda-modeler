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
 * A representation of the model object '<em><b>Schema Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.unipotsdam.hpi.bpt.schemamapping.SchemaMapping#getClassMappings <em>Class Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.unipotsdam.hpi.bpt.schemamapping.SchemamappingPackage#getSchemaMapping()
 * @model extendedMetaData="name='tSchemaMapping' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface SchemaMapping extends EObject {
  /**
   * Returns the value of the '<em><b>Class Mappings</b></em>' containment reference list.
   * The list contents are of type {@link de.unipotsdam.hpi.bpt.schemamapping.ClassMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Mappings</em>' containment reference list.
   * @see de.unipotsdam.hpi.bpt.schemamapping.SchemamappingPackage#getSchemaMapping_ClassMappings()
   * @model type="de.unipotsdam.hpi.bpt.schemamapping.ClassMapping" containment="true" derived="true" ordered="false"
   *        extendedMetaData="name='classMapping' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  EList getClassMappings();

} // SchemaMapping
