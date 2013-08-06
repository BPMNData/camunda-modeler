/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpt.schemamapping.impl;

import de.unipotsdam.hpi.bpt.schemamapping.ClassMapping;
import de.unipotsdam.hpi.bpt.schemamapping.DocumentRoot;
import de.unipotsdam.hpi.bpt.schemamapping.SchemaMapping;
import de.unipotsdam.hpi.bpt.schemamapping.SchemamappingPackage;

import org.eclipse.emf.common.notify.Notification;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.unipotsdam.hpi.bpt.schemamapping.impl.DocumentRootImpl#getSchemaMapping <em>Schema Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
  /**
   * The cached value of the '{@link #getSchemaMapping() <em>Schema Mapping</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSchemaMapping()
   * @generated
   * @ordered
   */
  protected SchemaMapping schemaMapping;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DocumentRootImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass() {
    return SchemamappingPackage.Literals.DOCUMENT_ROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SchemaMapping getSchemaMapping() {
    return schemaMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSchemaMapping(SchemaMapping newSchemaMapping, NotificationChain msgs) {
    SchemaMapping oldSchemaMapping = schemaMapping;
    schemaMapping = newSchemaMapping;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchemamappingPackage.DOCUMENT_ROOT__SCHEMA_MAPPING, oldSchemaMapping, newSchemaMapping);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSchemaMapping(SchemaMapping newSchemaMapping) {
    if (newSchemaMapping != schemaMapping) {
      NotificationChain msgs = null;
      if (schemaMapping != null)
        msgs = ((InternalEObject)schemaMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchemamappingPackage.DOCUMENT_ROOT__SCHEMA_MAPPING, null, msgs);
      if (newSchemaMapping != null)
        msgs = ((InternalEObject)newSchemaMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchemamappingPackage.DOCUMENT_ROOT__SCHEMA_MAPPING, null, msgs);
      msgs = basicSetSchemaMapping(newSchemaMapping, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SchemamappingPackage.DOCUMENT_ROOT__SCHEMA_MAPPING, newSchemaMapping, newSchemaMapping));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case SchemamappingPackage.DOCUMENT_ROOT__SCHEMA_MAPPING:
        return basicSetSchemaMapping(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case SchemamappingPackage.DOCUMENT_ROOT__SCHEMA_MAPPING:
        return getSchemaMapping();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case SchemamappingPackage.DOCUMENT_ROOT__SCHEMA_MAPPING:
        setSchemaMapping((SchemaMapping)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID) {
    switch (featureID) {
      case SchemamappingPackage.DOCUMENT_ROOT__SCHEMA_MAPPING:
        setSchemaMapping((SchemaMapping)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case SchemamappingPackage.DOCUMENT_ROOT__SCHEMA_MAPPING:
        return schemaMapping != null;
    }
    return super.eIsSet(featureID);
  }

} //DocumentRootImpl
