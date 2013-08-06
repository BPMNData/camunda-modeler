/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpmndata.schemamapping.impl;

import de.unipotsdam.hpi.bpmndata.schemamapping.AttributeMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
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
 * An implementation of the model object '<em><b>Class Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.impl.ClassMappingImpl#getLocalClass <em>Local Class</em>}</li>
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.impl.ClassMappingImpl#getGlobalClass <em>Global Class</em>}</li>
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.impl.ClassMappingImpl#getAttributeMappings <em>Attribute Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassMappingImpl extends EObjectImpl implements ClassMapping {
  /**
   * The default value of the '{@link #getLocalClass() <em>Local Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalClass()
   * @generated
   * @ordered
   */
  protected static final String LOCAL_CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLocalClass() <em>Local Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalClass()
   * @generated
   * @ordered
   */
  protected String localClass = LOCAL_CLASS_EDEFAULT;

  /**
   * The default value of the '{@link #getGlobalClass() <em>Global Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalClass()
   * @generated
   * @ordered
   */
  protected static final String GLOBAL_CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGlobalClass() <em>Global Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalClass()
   * @generated
   * @ordered
   */
  protected String globalClass = GLOBAL_CLASS_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttributeMappings() <em>Attribute Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeMappings()
   * @generated
   * @ordered
   */
  protected EList attributeMappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassMappingImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass() {
    return SchemamappingPackage.Literals.CLASS_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLocalClass() {
    return localClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocalClass(String newLocalClass) {
    String oldLocalClass = localClass;
    localClass = newLocalClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SchemamappingPackage.CLASS_MAPPING__LOCAL_CLASS, oldLocalClass, localClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGlobalClass() {
    return globalClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlobalClass(String newGlobalClass) {
    String oldGlobalClass = globalClass;
    globalClass = newGlobalClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SchemamappingPackage.CLASS_MAPPING__GLOBAL_CLASS, oldGlobalClass, globalClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getAttributeMappings() {
    if (attributeMappings == null) {
      attributeMappings = new EObjectContainmentEList(AttributeMapping.class, this, SchemamappingPackage.CLASS_MAPPING__ATTRIBUTE_MAPPINGS);
    }
    return attributeMappings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case SchemamappingPackage.CLASS_MAPPING__ATTRIBUTE_MAPPINGS:
        return ((InternalEList)getAttributeMappings()).basicRemove(otherEnd, msgs);
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
      case SchemamappingPackage.CLASS_MAPPING__LOCAL_CLASS:
        return getLocalClass();
      case SchemamappingPackage.CLASS_MAPPING__GLOBAL_CLASS:
        return getGlobalClass();
      case SchemamappingPackage.CLASS_MAPPING__ATTRIBUTE_MAPPINGS:
        return getAttributeMappings();
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
      case SchemamappingPackage.CLASS_MAPPING__LOCAL_CLASS:
        setLocalClass((String)newValue);
        return;
      case SchemamappingPackage.CLASS_MAPPING__GLOBAL_CLASS:
        setGlobalClass((String)newValue);
        return;
      case SchemamappingPackage.CLASS_MAPPING__ATTRIBUTE_MAPPINGS:
        getAttributeMappings().clear();
        getAttributeMappings().addAll((Collection)newValue);
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
      case SchemamappingPackage.CLASS_MAPPING__LOCAL_CLASS:
        setLocalClass(LOCAL_CLASS_EDEFAULT);
        return;
      case SchemamappingPackage.CLASS_MAPPING__GLOBAL_CLASS:
        setGlobalClass(GLOBAL_CLASS_EDEFAULT);
        return;
      case SchemamappingPackage.CLASS_MAPPING__ATTRIBUTE_MAPPINGS:
        getAttributeMappings().clear();
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
      case SchemamappingPackage.CLASS_MAPPING__LOCAL_CLASS:
        return LOCAL_CLASS_EDEFAULT == null ? localClass != null : !LOCAL_CLASS_EDEFAULT.equals(localClass);
      case SchemamappingPackage.CLASS_MAPPING__GLOBAL_CLASS:
        return GLOBAL_CLASS_EDEFAULT == null ? globalClass != null : !GLOBAL_CLASS_EDEFAULT.equals(globalClass);
      case SchemamappingPackage.CLASS_MAPPING__ATTRIBUTE_MAPPINGS:
        return attributeMappings != null && !attributeMappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (localClass: ");
    result.append(localClass);
    result.append(", globalClass: ");
    result.append(globalClass);
    result.append(')');
    return result.toString();
  }

} //ClassMappingImpl
