/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpmndata.schemamapping.impl;

import de.unipotsdam.hpi.bpmndata.schemamapping.AttributeMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.ClassMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.SchemaMapping;
import de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingFactory;
import de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchemamappingPackageImpl extends EPackageImpl implements SchemamappingPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass schemaMappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classMappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeMappingEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SchemamappingPackageImpl() {
    super(eNS_URI, SchemamappingFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link SchemamappingPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SchemamappingPackage init() {
    if (isInited) return (SchemamappingPackage)EPackage.Registry.INSTANCE.getEPackage(SchemamappingPackage.eNS_URI);

    // Obtain or create and register package
    SchemamappingPackageImpl theSchemamappingPackage = (SchemamappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SchemamappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SchemamappingPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theSchemamappingPackage.createPackageContents();

    // Initialize created meta-data
    theSchemamappingPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSchemamappingPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SchemamappingPackage.eNS_URI, theSchemamappingPackage);
    return theSchemamappingPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSchemaMapping() {
    return schemaMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSchemaMapping_ClassMappings() {
    return (EReference)schemaMappingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassMapping() {
    return classMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassMapping_LocalClass() {
    return (EAttribute)classMappingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassMapping_GlobalClass() {
    return (EAttribute)classMappingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassMapping_AttributeMappings() {
    return (EReference)classMappingEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeMapping() {
    return attributeMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttributeMapping_LocalAttribute() {
    return (EAttribute)attributeMappingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttributeMapping_GlobalAttribute() {
    return (EAttribute)attributeMappingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SchemamappingFactory getSchemamappingFactory() {
    return (SchemamappingFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    schemaMappingEClass = createEClass(SCHEMA_MAPPING);
    createEReference(schemaMappingEClass, SCHEMA_MAPPING__CLASS_MAPPINGS);

    classMappingEClass = createEClass(CLASS_MAPPING);
    createEAttribute(classMappingEClass, CLASS_MAPPING__LOCAL_CLASS);
    createEAttribute(classMappingEClass, CLASS_MAPPING__GLOBAL_CLASS);
    createEReference(classMappingEClass, CLASS_MAPPING__ATTRIBUTE_MAPPINGS);

    attributeMappingEClass = createEClass(ATTRIBUTE_MAPPING);
    createEAttribute(attributeMappingEClass, ATTRIBUTE_MAPPING__LOCAL_ATTRIBUTE);
    createEAttribute(attributeMappingEClass, ATTRIBUTE_MAPPING__GLOBAL_ATTRIBUTE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(schemaMappingEClass, SchemaMapping.class, "SchemaMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSchemaMapping_ClassMappings(), this.getClassMapping(), null, "classMappings", null, 0, -1, SchemaMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

    initEClass(classMappingEClass, ClassMapping.class, "ClassMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClassMapping_LocalClass(), ecorePackage.getEString(), "localClass", null, 1, 1, ClassMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassMapping_GlobalClass(), ecorePackage.getEString(), "globalClass", null, 1, 1, ClassMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getClassMapping_AttributeMappings(), this.getAttributeMapping(), null, "attributeMappings", null, 0, -1, ClassMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

    initEClass(attributeMappingEClass, AttributeMapping.class, "AttributeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttributeMapping_LocalAttribute(), ecorePackage.getEString(), "localAttribute", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttributeMapping_GlobalAttribute(), ecorePackage.getEString(), "globalAttribute", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations() {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
    addAnnotation
      (schemaMappingEClass, 
       source, 
       new String[] {
       "name", "tSchemaMapping",
       "kind", "mixed",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getSchemaMapping_ClassMappings(), 
       source, 
       new String[] {
       "name", "classMapping",
       "kind", "element",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (classMappingEClass, 
       source, 
       new String[] {
       "name", "tClassMapping",
       "kind", "mixed",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getClassMapping_LocalClass(), 
       source, 
       new String[] {
       "name", "localClass",
       "kind", "attribute"
       });		
    addAnnotation
      (getClassMapping_GlobalClass(), 
       source, 
       new String[] {
       "name", "globalClass",
       "kind", "attribute"
       });		
    addAnnotation
      (getClassMapping_AttributeMappings(), 
       source, 
       new String[] {
       "name", "attributeMapping",
       "kind", "element",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getAttributeMapping_LocalAttribute(), 
       source, 
       new String[] {
       "name", "localAttribute",
       "kind", "attribute"
       });		
    addAnnotation
      (getAttributeMapping_GlobalAttribute(), 
       source, 
       new String[] {
       "name", "globalAttribute",
       "kind", "attribute"
       });
  }

} //SchemamappingPackageImpl
