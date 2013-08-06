/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpmndata.schemamapping.impl;

import de.unipotsdam.hpi.bpmndata.schemamapping.AttributeMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.impl.AttributeMappingImpl#getLocalAttribute <em>Local Attribute</em>}</li>
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.impl.AttributeMappingImpl#getGlobalAttribute <em>Global Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeMappingImpl extends EObjectImpl implements AttributeMapping {
  /**
   * The default value of the '{@link #getLocalAttribute() <em>Local Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalAttribute()
   * @generated
   * @ordered
   */
  protected static final String LOCAL_ATTRIBUTE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLocalAttribute() <em>Local Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalAttribute()
   * @generated
   * @ordered
   */
  protected String localAttribute = LOCAL_ATTRIBUTE_EDEFAULT;

  /**
   * The default value of the '{@link #getGlobalAttribute() <em>Global Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalAttribute()
   * @generated
   * @ordered
   */
  protected static final String GLOBAL_ATTRIBUTE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGlobalAttribute() <em>Global Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalAttribute()
   * @generated
   * @ordered
   */
  protected String globalAttribute = GLOBAL_ATTRIBUTE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeMappingImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return SchemamappingPackage.Literals.ATTRIBUTE_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLocalAttribute() {
    return localAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocalAttribute(String newLocalAttribute) {
    String oldLocalAttribute = localAttribute;
    localAttribute = newLocalAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SchemamappingPackage.ATTRIBUTE_MAPPING__LOCAL_ATTRIBUTE, oldLocalAttribute, localAttribute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGlobalAttribute() {
    return globalAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlobalAttribute(String newGlobalAttribute) {
    String oldGlobalAttribute = globalAttribute;
    globalAttribute = newGlobalAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SchemamappingPackage.ATTRIBUTE_MAPPING__GLOBAL_ATTRIBUTE, oldGlobalAttribute, globalAttribute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case SchemamappingPackage.ATTRIBUTE_MAPPING__LOCAL_ATTRIBUTE:
        return getLocalAttribute();
      case SchemamappingPackage.ATTRIBUTE_MAPPING__GLOBAL_ATTRIBUTE:
        return getGlobalAttribute();
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
      case SchemamappingPackage.ATTRIBUTE_MAPPING__LOCAL_ATTRIBUTE:
        setLocalAttribute((String)newValue);
        return;
      case SchemamappingPackage.ATTRIBUTE_MAPPING__GLOBAL_ATTRIBUTE:
        setGlobalAttribute((String)newValue);
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
      case SchemamappingPackage.ATTRIBUTE_MAPPING__LOCAL_ATTRIBUTE:
        setLocalAttribute(LOCAL_ATTRIBUTE_EDEFAULT);
        return;
      case SchemamappingPackage.ATTRIBUTE_MAPPING__GLOBAL_ATTRIBUTE:
        setGlobalAttribute(GLOBAL_ATTRIBUTE_EDEFAULT);
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
      case SchemamappingPackage.ATTRIBUTE_MAPPING__LOCAL_ATTRIBUTE:
        return LOCAL_ATTRIBUTE_EDEFAULT == null ? localAttribute != null : !LOCAL_ATTRIBUTE_EDEFAULT.equals(localAttribute);
      case SchemamappingPackage.ATTRIBUTE_MAPPING__GLOBAL_ATTRIBUTE:
        return GLOBAL_ATTRIBUTE_EDEFAULT == null ? globalAttribute != null : !GLOBAL_ATTRIBUTE_EDEFAULT.equals(globalAttribute);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (localAttribute: ");
    result.append(localAttribute);
    result.append(", globalAttribute: ");
    result.append(globalAttribute);
    result.append(')');
    return result.toString();
  }

} //AttributeMappingImpl
