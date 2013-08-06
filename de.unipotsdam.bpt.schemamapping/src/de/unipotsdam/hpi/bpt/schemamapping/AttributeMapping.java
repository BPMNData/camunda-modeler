/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpt.schemamapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping#getLocalAttribute <em>Local Attribute</em>}</li>
 *   <li>{@link de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping#getGlobalAttribute <em>Global Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.unipotsdam.hpi.bpt.schemamapping.SchemamappingPackage#getAttributeMapping()
 * @model
 * @generated
 */
public interface AttributeMapping extends EObject {
  /**
   * Returns the value of the '<em><b>Local Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Local Attribute</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Local Attribute</em>' attribute.
   * @see #setLocalAttribute(String)
   * @see de.unipotsdam.hpi.bpt.schemamapping.SchemamappingPackage#getAttributeMapping_LocalAttribute()
   * @model required="true" derived="true"
   *        extendedMetaData="name='localAttribute' kind='attribute'"
   * @generated
   */
  String getLocalAttribute();

  /**
   * Sets the value of the '{@link de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping#getLocalAttribute <em>Local Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Local Attribute</em>' attribute.
   * @see #getLocalAttribute()
   * @generated
   */
  void setLocalAttribute(String value);

  /**
   * Returns the value of the '<em><b>Global Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global Attribute</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global Attribute</em>' attribute.
   * @see #setGlobalAttribute(String)
   * @see de.unipotsdam.hpi.bpt.schemamapping.SchemamappingPackage#getAttributeMapping_GlobalAttribute()
   * @model required="true" derived="true"
   *        extendedMetaData="name='globalAttribute' kind='attribute'"
   * @generated
   */
  String getGlobalAttribute();

  /**
   * Sets the value of the '{@link de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping#getGlobalAttribute <em>Global Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global Attribute</em>' attribute.
   * @see #getGlobalAttribute()
   * @generated
   */
  void setGlobalAttribute(String value);

} // AttributeMapping
