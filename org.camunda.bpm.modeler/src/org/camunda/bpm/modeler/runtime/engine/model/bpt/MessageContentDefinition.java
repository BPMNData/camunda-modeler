/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.bpmn2.ItemDefinition;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getCorrelationIdentifierLinks <em>Correlation Identifier Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getMessageContentDefinition()
 * @model extendedMetaData="name='tMessageContent' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface MessageContentDefinition extends EObject {
  /**
   * Returns the value of the '<em><b>Payload Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Payload Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Payload Ref</em>' reference.
   * @see #setPayloadRef(ItemDefinition)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getMessageContentDefinition_PayloadRef()
   * @model ordered="false"
   *        extendedMetaData="kind='attribute' name='payloadRef'"
   * @generated
   */
  ItemDefinition getPayloadRef();

  /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getPayloadRef <em>Payload Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Payload Ref</em>' reference.
   * @see #getPayloadRef()
   * @generated
   */
  void setPayloadRef(ItemDefinition value);

  /**
   * Returns the value of the '<em><b>Correlation Identifier Links</b></em>' containment reference list.
   * The list contents are of type {@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Correlation Identifier Links</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Correlation Identifier Links</em>' containment reference list.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getMessageContentDefinition_CorrelationIdentifierLinks()
   * @model containment="true" ordered="false"
   *        extendedMetaData="kind='element' name='correlationIdentifierLink' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
  EList<ItemDefinitionLink> getCorrelationIdentifierLinks();

} // MessageContentDefinition
