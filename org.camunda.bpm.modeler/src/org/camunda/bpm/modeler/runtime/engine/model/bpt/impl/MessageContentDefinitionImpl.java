/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt.impl;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition;

import org.eclipse.bpmn2.ItemDefinition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Content Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageContentDefinitionImpl#getPayloadRef <em>Payload Ref</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageContentDefinitionImpl#getCorrelationIdentifierRef <em>Correlation Identifier Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageContentDefinitionImpl extends EObjectImpl implements MessageContentDefinition {
  /**
   * The cached value of the '{@link #getPayloadRef() <em>Payload Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPayloadRef()
   * @generated
   * @ordered
   */
  protected ItemDefinition payloadRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MessageContentDefinitionImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return BptPackage.Literals.MESSAGE_CONTENT_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ItemDefinition getPayloadRef() {
    return payloadRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPayloadRef(ItemDefinition newPayloadRef, NotificationChain msgs) {
    ItemDefinition oldPayloadRef = payloadRef;
    payloadRef = newPayloadRef;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF, oldPayloadRef, newPayloadRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPayloadRef(ItemDefinition newPayloadRef) {
    if (newPayloadRef != payloadRef) {
      NotificationChain msgs = null;
      if (payloadRef != null)
        msgs = ((InternalEObject)payloadRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF, null, msgs);
      if (newPayloadRef != null)
        msgs = ((InternalEObject)newPayloadRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF, null, msgs);
      msgs = basicSetPayloadRef(newPayloadRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF, newPayloadRef, newPayloadRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ItemDefinition getCorrelationIdentifierRef() {
    // TODO: implement this method to return the 'Correlation Identifier Ref' containment reference
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCorrelationIdentifierRef(ItemDefinition newCorrelationIdentifierRef, NotificationChain msgs) {
    // TODO: implement this method to set the contained 'Correlation Identifier Ref' containment reference
    // -> this method is automatically invoked to keep the containment relationship in synch
    // -> do not modify other features
    // -> return msgs, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCorrelationIdentifierRef(ItemDefinition newCorrelationIdentifierRef) {
    // TODO: implement this method to set the 'Correlation Identifier Ref' containment reference
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF:
        return basicSetPayloadRef(null, msgs);
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_REF:
        return basicSetCorrelationIdentifierRef(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF:
        return getPayloadRef();
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_REF:
        return getCorrelationIdentifierRef();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF:
        setPayloadRef((ItemDefinition)newValue);
        return;
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_REF:
        setCorrelationIdentifierRef((ItemDefinition)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF:
        setPayloadRef((ItemDefinition)null);
        return;
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_REF:
        setCorrelationIdentifierRef((ItemDefinition)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF:
        return payloadRef != null;
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_REF:
        return getCorrelationIdentifierRef() != null;
    }
    return super.eIsSet(featureID);
  }

} //MessageContentDefinitionImpl
