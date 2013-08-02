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
 * A representation of the model object '<em><b>Correlation Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation#getAttributeName <em>Attribute Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getCorrelationInformation()
 * @model extendedMetaData="name='tCorrelationInformation' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface CorrelationInformation extends EObject {
  /**
   * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A correlation information describes an attribute which can be used for correlation.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attribute Name</em>' attribute.
   * @see #setAttributeName(String)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getCorrelationInformation_AttributeName()
   * @model default="" dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='attributeName'"
   * @generated
   */
  String getAttributeName();

  /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation#getAttributeName <em>Attribute Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Name</em>' attribute.
   * @see #getAttributeName()
   * @generated
   */
  void setAttributeName(String value);

} // CorrelationInformation
