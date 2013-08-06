/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpmndata.schemamapping;

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
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.SchemaMapping#getClassMappings <em>Class Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage#getSchemaMapping()
 * @model extendedMetaData="name='tSchemaMapping' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface SchemaMapping extends EObject {
  /**
   * Returns the value of the '<em><b>Class Mappings</b></em>' containment reference list.
   * The list contents are of type {@link de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Mappings</em>' containment reference list.
   * @see de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage#getSchemaMapping_ClassMappings()
   * @model containment="true" derived="true" ordered="false"
   *        extendedMetaData="name='classMapping' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  EList<ClassMapping> getClassMappings();

} // SchemaMapping
