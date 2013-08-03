/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt.impl;

import java.util.Collection;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition;

import org.eclipse.bpmn2.ItemDefinition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Content Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageContentDefinitionImpl#getPayloadRef <em>Payload Ref</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageContentDefinitionImpl#getCorrelationIdentifierLinks <em>Correlation Identifier Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageContentDefinitionImpl extends EObjectImpl implements MessageContentDefinition {
  /**
   * The cached value of the '{@link #getPayloadRef() <em>Payload Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPayloadRef()
   * @generated
   * @ordered
   */
  protected ItemDefinition payloadRef;

  /**
   * The cached value of the '{@link #getCorrelationIdentifierLinks() <em>Correlation Identifier Links</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorrelationIdentifierLinks()
   * @generated
   * @ordered
   */
  protected EList<ItemDefinitionLink> correlationIdentifierLinks;

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
    if (payloadRef != null && payloadRef.eIsProxy()) {
      InternalEObject oldPayloadRef = (InternalEObject)payloadRef;
      payloadRef = (ItemDefinition)eResolveProxy(oldPayloadRef);
      if (payloadRef != oldPayloadRef) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF, oldPayloadRef, payloadRef));
      }
    }
    return payloadRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ItemDefinition basicGetPayloadRef() {
    return payloadRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPayloadRef(ItemDefinition newPayloadRef) {
    ItemDefinition oldPayloadRef = payloadRef;
    payloadRef = newPayloadRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF, oldPayloadRef, payloadRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ItemDefinitionLink> getCorrelationIdentifierLinks() {
    if (correlationIdentifierLinks == null) {
      correlationIdentifierLinks = new EObjectContainmentEList<ItemDefinitionLink>(ItemDefinitionLink.class, this, BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_LINKS);
    }
    return correlationIdentifierLinks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_LINKS:
        return ((InternalEList<?>)getCorrelationIdentifierLinks()).basicRemove(otherEnd, msgs);
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
        if (resolve) return getPayloadRef();
        return basicGetPayloadRef();
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_LINKS:
        return getCorrelationIdentifierLinks();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case BptPackage.MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF:
        setPayloadRef((ItemDefinition)newValue);
        return;
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_LINKS:
        getCorrelationIdentifierLinks().clear();
        getCorrelationIdentifierLinks().addAll((Collection<? extends ItemDefinitionLink>)newValue);
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
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_LINKS:
        getCorrelationIdentifierLinks().clear();
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
      case BptPackage.MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_LINKS:
        return correlationIdentifierLinks != null && !correlationIdentifierLinks.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MessageContentDefinitionImpl
