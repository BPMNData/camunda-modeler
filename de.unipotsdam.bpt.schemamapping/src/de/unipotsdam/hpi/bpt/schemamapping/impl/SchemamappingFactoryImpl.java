/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpt.schemamapping.impl;

import de.unipotsdam.hpi.bpt.schemamapping.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchemamappingFactoryImpl extends EFactoryImpl implements SchemamappingFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SchemamappingFactory init() {
    try {
      SchemamappingFactory theSchemamappingFactory = (SchemamappingFactory)EPackage.Registry.INSTANCE.getEFactory("http://bpt.hpi.uni-potsdam.de/schema-mapping"); 
      if (theSchemamappingFactory != null) {
        return theSchemamappingFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SchemamappingFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SchemamappingFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case SchemamappingPackage.DOCUMENT_ROOT: return createDocumentRoot();
      case SchemamappingPackage.SCHEMA_MAPPING: return createSchemaMapping();
      case SchemamappingPackage.CLASS_MAPPING: return createClassMapping();
      case SchemamappingPackage.ATTRIBUTE_MAPPING: return createAttributeMapping();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DocumentRoot createDocumentRoot() {
    DocumentRootImpl documentRoot = new DocumentRootImpl();
    return documentRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SchemaMapping createSchemaMapping() {
    SchemaMappingImpl schemaMapping = new SchemaMappingImpl();
    return schemaMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassMapping createClassMapping() {
    ClassMappingImpl classMapping = new ClassMappingImpl();
    return classMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeMapping createAttributeMapping() {
    AttributeMappingImpl attributeMapping = new AttributeMappingImpl();
    return attributeMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SchemamappingPackage getSchemamappingPackage() {
    return (SchemamappingPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static SchemamappingPackage getPackage() {
    return SchemamappingPackage.eINSTANCE;
  }

} //SchemamappingFactoryImpl
