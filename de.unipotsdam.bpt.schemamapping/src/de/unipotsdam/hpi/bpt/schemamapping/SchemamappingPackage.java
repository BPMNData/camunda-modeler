/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpt.schemamapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.unipotsdam.hpi.bpt.schemamapping.SchemamappingFactory
 * @model kind="package"
 * @generated
 */
public interface SchemamappingPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "schemamapping";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://bpt.hpi.uni-potsdam.de/schema-mapping";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "schemamapping";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SchemamappingPackage eINSTANCE = de.unipotsdam.hpi.bpt.schemamapping.impl.SchemamappingPackageImpl.init();

  /**
   * The meta object id for the '{@link de.unipotsdam.hpi.bpt.schemamapping.impl.SchemaMappingImpl <em>Schema Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.unipotsdam.hpi.bpt.schemamapping.impl.SchemaMappingImpl
   * @see de.unipotsdam.hpi.bpt.schemamapping.impl.SchemamappingPackageImpl#getSchemaMapping()
   * @generated
   */
  int SCHEMA_MAPPING = 0;

  /**
   * The feature id for the '<em><b>Class Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA_MAPPING__CLASS_MAPPINGS = 0;

  /**
   * The number of structural features of the '<em>Schema Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA_MAPPING_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.unipotsdam.hpi.bpt.schemamapping.impl.ClassMappingImpl <em>Class Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.unipotsdam.hpi.bpt.schemamapping.impl.ClassMappingImpl
   * @see de.unipotsdam.hpi.bpt.schemamapping.impl.SchemamappingPackageImpl#getClassMapping()
   * @generated
   */
  int CLASS_MAPPING = 1;

  /**
   * The feature id for the '<em><b>Local Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MAPPING__LOCAL_CLASS = 0;

  /**
   * The feature id for the '<em><b>Global Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MAPPING__GLOBAL_CLASS = 1;

  /**
   * The feature id for the '<em><b>Attribute Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MAPPING__ATTRIBUTE_MAPPINGS = 2;

  /**
   * The number of structural features of the '<em>Class Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MAPPING_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.unipotsdam.hpi.bpt.schemamapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.unipotsdam.hpi.bpt.schemamapping.impl.AttributeMappingImpl
   * @see de.unipotsdam.hpi.bpt.schemamapping.impl.SchemamappingPackageImpl#getAttributeMapping()
   * @generated
   */
  int ATTRIBUTE_MAPPING = 2;

  /**
   * The feature id for the '<em><b>Local Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_MAPPING__LOCAL_ATTRIBUTE = 0;

  /**
   * The feature id for the '<em><b>Global Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_MAPPING__GLOBAL_ATTRIBUTE = 1;

  /**
   * The number of structural features of the '<em>Attribute Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_MAPPING_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link de.unipotsdam.hpi.bpt.schemamapping.SchemaMapping <em>Schema Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Schema Mapping</em>'.
   * @see de.unipotsdam.hpi.bpt.schemamapping.SchemaMapping
   * @generated
   */
  EClass getSchemaMapping();

  /**
   * Returns the meta object for the containment reference list '{@link de.unipotsdam.hpi.bpt.schemamapping.SchemaMapping#getClassMappings <em>Class Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Class Mappings</em>'.
   * @see de.unipotsdam.hpi.bpt.schemamapping.SchemaMapping#getClassMappings()
   * @see #getSchemaMapping()
   * @generated
   */
  EReference getSchemaMapping_ClassMappings();

  /**
   * Returns the meta object for class '{@link de.unipotsdam.hpi.bpt.schemamapping.ClassMapping <em>Class Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Mapping</em>'.
   * @see de.unipotsdam.hpi.bpt.schemamapping.ClassMapping
   * @generated
   */
  EClass getClassMapping();

  /**
   * Returns the meta object for the attribute '{@link de.unipotsdam.hpi.bpt.schemamapping.ClassMapping#getLocalClass <em>Local Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Local Class</em>'.
   * @see de.unipotsdam.hpi.bpt.schemamapping.ClassMapping#getLocalClass()
   * @see #getClassMapping()
   * @generated
   */
  EAttribute getClassMapping_LocalClass();

  /**
   * Returns the meta object for the attribute '{@link de.unipotsdam.hpi.bpt.schemamapping.ClassMapping#getGlobalClass <em>Global Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Global Class</em>'.
   * @see de.unipotsdam.hpi.bpt.schemamapping.ClassMapping#getGlobalClass()
   * @see #getClassMapping()
   * @generated
   */
  EAttribute getClassMapping_GlobalClass();

  /**
   * Returns the meta object for the containment reference list '{@link de.unipotsdam.hpi.bpt.schemamapping.ClassMapping#getAttributeMappings <em>Attribute Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute Mappings</em>'.
   * @see de.unipotsdam.hpi.bpt.schemamapping.ClassMapping#getAttributeMappings()
   * @see #getClassMapping()
   * @generated
   */
  EReference getClassMapping_AttributeMappings();

  /**
   * Returns the meta object for class '{@link de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping <em>Attribute Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Mapping</em>'.
   * @see de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping
   * @generated
   */
  EClass getAttributeMapping();

  /**
   * Returns the meta object for the attribute '{@link de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping#getLocalAttribute <em>Local Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Local Attribute</em>'.
   * @see de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping#getLocalAttribute()
   * @see #getAttributeMapping()
   * @generated
   */
  EAttribute getAttributeMapping_LocalAttribute();

  /**
   * Returns the meta object for the attribute '{@link de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping#getGlobalAttribute <em>Global Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Global Attribute</em>'.
   * @see de.unipotsdam.hpi.bpt.schemamapping.AttributeMapping#getGlobalAttribute()
   * @see #getAttributeMapping()
   * @generated
   */
  EAttribute getAttributeMapping_GlobalAttribute();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SchemamappingFactory getSchemamappingFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link de.unipotsdam.hpi.bpt.schemamapping.impl.SchemaMappingImpl <em>Schema Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.unipotsdam.hpi.bpt.schemamapping.impl.SchemaMappingImpl
     * @see de.unipotsdam.hpi.bpt.schemamapping.impl.SchemamappingPackageImpl#getSchemaMapping()
     * @generated
     */
    EClass SCHEMA_MAPPING = eINSTANCE.getSchemaMapping();

    /**
     * The meta object literal for the '<em><b>Class Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCHEMA_MAPPING__CLASS_MAPPINGS = eINSTANCE.getSchemaMapping_ClassMappings();

    /**
     * The meta object literal for the '{@link de.unipotsdam.hpi.bpt.schemamapping.impl.ClassMappingImpl <em>Class Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.unipotsdam.hpi.bpt.schemamapping.impl.ClassMappingImpl
     * @see de.unipotsdam.hpi.bpt.schemamapping.impl.SchemamappingPackageImpl#getClassMapping()
     * @generated
     */
    EClass CLASS_MAPPING = eINSTANCE.getClassMapping();

    /**
     * The meta object literal for the '<em><b>Local Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_MAPPING__LOCAL_CLASS = eINSTANCE.getClassMapping_LocalClass();

    /**
     * The meta object literal for the '<em><b>Global Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_MAPPING__GLOBAL_CLASS = eINSTANCE.getClassMapping_GlobalClass();

    /**
     * The meta object literal for the '<em><b>Attribute Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_MAPPING__ATTRIBUTE_MAPPINGS = eINSTANCE.getClassMapping_AttributeMappings();

    /**
     * The meta object literal for the '{@link de.unipotsdam.hpi.bpt.schemamapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.unipotsdam.hpi.bpt.schemamapping.impl.AttributeMappingImpl
     * @see de.unipotsdam.hpi.bpt.schemamapping.impl.SchemamappingPackageImpl#getAttributeMapping()
     * @generated
     */
    EClass ATTRIBUTE_MAPPING = eINSTANCE.getAttributeMapping();

    /**
     * The meta object literal for the '<em><b>Local Attribute</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_MAPPING__LOCAL_ATTRIBUTE = eINSTANCE.getAttributeMapping_LocalAttribute();

    /**
     * The meta object literal for the '<em><b>Global Attribute</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_MAPPING__GLOBAL_ATTRIBUTE = eINSTANCE.getAttributeMapping_GlobalAttribute();

  }

} //SchemamappingPackage
