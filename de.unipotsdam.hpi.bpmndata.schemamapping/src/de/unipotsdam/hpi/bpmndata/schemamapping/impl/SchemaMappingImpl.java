/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpmndata.schemamapping.impl;

import de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.SchemaMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schema Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.unipotsdam.hpi.bpmndata.schemamapping.impl.SchemaMappingImpl#getClassMappings <em>Class Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchemaMappingImpl extends EObjectImpl implements SchemaMapping {
  /**
   * The cached value of the '{@link #getClassMappings() <em>Class Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassMappings()
   * @generated
   * @ordered
   */
  protected EList<ClassMapping> classMappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SchemaMappingImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return SchemamappingPackage.Literals.SCHEMA_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClassMapping> getClassMappings() {
    if (classMappings == null) {
      classMappings = new EObjectContainmentEList<ClassMapping>(ClassMapping.class, this, SchemamappingPackage.SCHEMA_MAPPING__CLASS_MAPPINGS);
    }
    return classMappings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case SchemamappingPackage.SCHEMA_MAPPING__CLASS_MAPPINGS:
        return ((InternalEList<?>)getClassMappings()).basicRemove(otherEnd, msgs);
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
      case SchemamappingPackage.SCHEMA_MAPPING__CLASS_MAPPINGS:
        return getClassMappings();
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
      case SchemamappingPackage.SCHEMA_MAPPING__CLASS_MAPPINGS:
        getClassMappings().clear();
        getClassMappings().addAll((Collection<? extends ClassMapping>)newValue);
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
      case SchemamappingPackage.SCHEMA_MAPPING__CLASS_MAPPINGS:
        getClassMappings().clear();
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
      case SchemamappingPackage.SCHEMA_MAPPING__CLASS_MAPPINGS:
        return classMappings != null && !classMappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SchemaMappingImpl
