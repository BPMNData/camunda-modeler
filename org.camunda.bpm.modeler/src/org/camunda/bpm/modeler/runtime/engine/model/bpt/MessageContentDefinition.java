/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.bpmn2.ItemDefinition;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Content Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getPayloadRef <em>Payload Ref</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getCorrelationIdentifierRef <em>Correlation Identifier Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getMessageContentDefinition()
 * @model extendedMetaData="name='tMessageContent' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface MessageContentDefinition extends EObject {
  /**
   * Returns the value of the '<em><b>Payload Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Payload Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Payload Ref</em>' containment reference.
   * @see #setPayloadRef(ItemDefinition)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getMessageContentDefinition_PayloadRef()
   * @model containment="true" derived="true"
   *        extendedMetaData="kind='element' name='payloadRef' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
  ItemDefinition getPayloadRef();

  /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getPayloadRef <em>Payload Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Payload Ref</em>' containment reference.
   * @see #getPayloadRef()
   * @generated
   */
  void setPayloadRef(ItemDefinition value);

  /**
   * Returns the value of the '<em><b>Correlation Identifier Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Correlation Identifier Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Correlation Identifier Ref</em>' containment reference.
   * @see #setCorrelationIdentifierRef(ItemDefinition)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getMessageContentDefinition_CorrelationIdentifierRef()
   * @model containment="true" upper="-2" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='correlationIdentifierRef' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
  ItemDefinition getCorrelationIdentifierRef();

  /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getCorrelationIdentifierRef <em>Correlation Identifier Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Correlation Identifier Ref</em>' containment reference.
   * @see #getCorrelationIdentifierRef()
   * @generated
   */
  void setCorrelationIdentifierRef(ItemDefinition value);

} // MessageContentDefinition
