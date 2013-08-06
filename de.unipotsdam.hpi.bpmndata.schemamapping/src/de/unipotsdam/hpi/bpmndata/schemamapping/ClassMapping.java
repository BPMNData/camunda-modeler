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
 * A representation of the model object '<em><b>Class Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping#getLocalClass <em>Local Class</em>}</li>
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping#getGlobalClass <em>Global Class</em>}</li>
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping#getAttributeMappings <em>Attribute Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage#getClassMapping()
 * @model extendedMetaData="name='tClassMapping' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface ClassMapping extends EObject {
  /**
   * Returns the value of the '<em><b>Local Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Local Class</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Local Class</em>' attribute.
   * @see #setLocalClass(String)
   * @see de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage#getClassMapping_LocalClass()
   * @model required="true" derived="true"
   *        extendedMetaData="name='localClass' kind='attribute'"
   * @generated
   */
  String getLocalClass();

  /**
   * Sets the value of the '{@link de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping#getLocalClass <em>Local Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Local Class</em>' attribute.
   * @see #getLocalClass()
   * @generated
   */
  void setLocalClass(String value);

  /**
   * Returns the value of the '<em><b>Global Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global Class</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global Class</em>' attribute.
   * @see #setGlobalClass(String)
   * @see de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage#getClassMapping_GlobalClass()
   * @model required="true" derived="true"
   *        extendedMetaData="name='globalClass' kind='attribute'"
   * @generated
   */
  String getGlobalClass();

  /**
   * Sets the value of the '{@link de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping#getGlobalClass <em>Global Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global Class</em>' attribute.
   * @see #getGlobalClass()
   * @generated
   */
  void setGlobalClass(String value);

  /**
   * Returns the value of the '<em><b>Attribute Mappings</b></em>' containment reference list.
   * The list contents are of type {@link de.unipotsdam.hpi.bpmndata.schemamapping.AttributeMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Mappings</em>' containment reference list.
   * @see de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage#getClassMapping_AttributeMappings()
   * @model type="de.unipotsdam.hpi.bpmndata.schemamapping.AttributeMapping" containment="true" derived="true" ordered="false"
   *        extendedMetaData="name='attributeMapping' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  EList getAttributeMappings();

} // ClassMapping
