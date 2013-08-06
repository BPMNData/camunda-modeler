/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory
 * @model kind="package"
 * @generated
 */
public interface BptPackage extends EPackage {
    /**
   * The package name.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    String eNAME = "bpt";

    /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    String eNS_URI = "http://bpt.hpi.uni-potsdam.de";

    /**
   * The package namespace name.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    String eNS_PREFIX = "bpt";

    /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    BptPackage eINSTANCE = org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl.init();

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.RelationalKeyImpl <em>Relational Key</em>}' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.RelationalKeyImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getRelationalKey()
   * @generated
   */
    int RELATIONAL_KEY = 1;

    /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int RELATIONAL_KEY__ID = 0;

    /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int RELATIONAL_KEY__VALUE = 1;

    /**
   * The number of structural features of the '<em>Relational Key</em>' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int RELATIONAL_KEY_FEATURE_COUNT = 2;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.PrimaryKeyImpl <em>Primary Key</em>}' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.PrimaryKeyImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getPrimaryKey()
   * @generated
   */
    int PRIMARY_KEY = 0;

    /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int PRIMARY_KEY__ID = RELATIONAL_KEY__ID;

    /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int PRIMARY_KEY__VALUE = RELATIONAL_KEY__VALUE;

    /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int PRIMARY_KEY__TYPE = RELATIONAL_KEY_FEATURE_COUNT + 0;

    /**
   * The number of structural features of the '<em>Primary Key</em>' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int PRIMARY_KEY_FEATURE_COUNT = RELATIONAL_KEY_FEATURE_COUNT + 1;


    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ForeignKeyImpl <em>Foreign Key</em>}' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ForeignKeyImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getForeignKey()
   * @generated
   */
    int FOREIGN_KEY = 2;

    /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int FOREIGN_KEY__ID = RELATIONAL_KEY__ID;

    /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int FOREIGN_KEY__VALUE = RELATIONAL_KEY__VALUE;

    /**
   * The number of structural features of the '<em>Foreign Key</em>' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int FOREIGN_KEY_FEATURE_COUNT = RELATIONAL_KEY_FEATURE_COUNT + 0;


    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ConditionImpl <em>Condition</em>}' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ConditionImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getCondition()
   * @generated
   */
    int CONDITION = 3;

    /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int CONDITION__ID = 0;

    /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int CONDITION__VALUE = 1;

    /**
   * The number of structural features of the '<em>Condition</em>' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int CONDITION_FEATURE_COUNT = 2;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.CardinalityImpl <em>Cardinality</em>}' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.CardinalityImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getCardinality()
   * @generated
   */
    int CARDINALITY = 4;

    /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int CARDINALITY__ID = 0;

    /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int CARDINALITY__VALUE = 1;

    /**
   * The number of structural features of the '<em>Cardinality</em>' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int CARDINALITY_FEATURE_COUNT = 2;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ScopeInformationImpl <em>Scope Information</em>}' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ScopeInformationImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getScopeInformation()
   * @generated
   */
    int SCOPE_INFORMATION = 5;

    /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int SCOPE_INFORMATION__ID = 0;

    /**
   * The feature id for the '<em><b>Case Object</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int SCOPE_INFORMATION__CASE_OBJECT = 1;

    /**
   * The number of structural features of the '<em>Scope Information</em>' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int SCOPE_INFORMATION_FEATURE_COUNT = 2;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.DocumentRootImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getDocumentRoot()
   * @generated
   */
    int DOCUMENT_ROOT = 6;

    /**
   * The feature id for the '<em><b>Primary Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int DOCUMENT_ROOT__PRIMARY_KEY = 0;

    /**
   * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int DOCUMENT_ROOT__CARDINALITY = 1;

    /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int DOCUMENT_ROOT__CONDITION = 2;

    /**
   * The feature id for the '<em><b>Scope Information</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int DOCUMENT_ROOT__SCOPE_INFORMATION = 3;

    /**
   * The feature id for the '<em><b>Foreign Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int DOCUMENT_ROOT__FOREIGN_KEY = 4;

    /**
   * The feature id for the '<em><b>Message Content Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__MESSAGE_CONTENT_DEFINITION = 5;

    /**
   * The feature id for the '<em><b>Message Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__MESSAGE_OBJECT = 6;

    /**
   * The feature id for the '<em><b>Correlation Information</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__CORRELATION_INFORMATION = 7;

    /**
   * The feature id for the '<em><b>Structure Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__STRUCTURE_DEFINITION = 8;

    /**
   * The feature id for the '<em><b>Schema Mapping Imports</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__SCHEMA_MAPPING_IMPORTS = 9;

    /**
   * The number of structural features of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int DOCUMENT_ROOT_FEATURE_COUNT = 10;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageContentDefinitionImpl <em>Message Content Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageContentDefinitionImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getMessageContentDefinition()
   * @generated
   */
  int MESSAGE_CONTENT_DEFINITION = 7;

    /**
   * The feature id for the '<em><b>Payload Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF = 0;

    /**
   * The feature id for the '<em><b>Correlation Identifier Links</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_LINKS = 1;

    /**
   * The number of structural features of the '<em>Message Content Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_CONTENT_DEFINITION_FEATURE_COUNT = 2;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ItemDefinitionLinkImpl <em>Item Definition Link</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ItemDefinitionLinkImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getItemDefinitionLink()
   * @generated
   */
  int ITEM_DEFINITION_LINK = 8;

    /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_DEFINITION_LINK__REF = 0;

    /**
   * The number of structural features of the '<em>Item Definition Link</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_DEFINITION_LINK_FEATURE_COUNT = 1;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageObjectImpl <em>Message Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageObjectImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getMessageObject()
   * @generated
   */
  int MESSAGE_OBJECT = 9;

    /**
   * The number of structural features of the '<em>Message Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_OBJECT_FEATURE_COUNT = 0;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.CorrelationInformationImpl <em>Correlation Information</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.CorrelationInformationImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getCorrelationInformation()
   * @generated
   */
  int CORRELATION_INFORMATION = 10;

    /**
   * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORRELATION_INFORMATION__ATTRIBUTE_NAME = 0;

    /**
   * The number of structural features of the '<em>Correlation Information</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORRELATION_INFORMATION_FEATURE_COUNT = 1;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.StructureDefinitionImpl <em>Structure Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.StructureDefinitionImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getStructureDefinition()
   * @generated
   */
  int STRUCTURE_DEFINITION = 11;

    /**
   * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_DEFINITION__EXTENSION_VALUES = Bpmn2Package.BASE_ELEMENT__EXTENSION_VALUES;

    /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_DEFINITION__DOCUMENTATION = Bpmn2Package.BASE_ELEMENT__DOCUMENTATION;

    /**
   * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_DEFINITION__EXTENSION_DEFINITIONS = Bpmn2Package.BASE_ELEMENT__EXTENSION_DEFINITIONS;

    /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_DEFINITION__ID = Bpmn2Package.BASE_ELEMENT__ID;

    /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_DEFINITION__ANY_ATTRIBUTE = Bpmn2Package.BASE_ELEMENT__ANY_ATTRIBUTE;

    /**
   * The feature id for the '<em><b>Qname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_DEFINITION__QNAME = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 0;

    /**
   * The number of structural features of the '<em>Structure Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_DEFINITION_FEATURE_COUNT = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 1;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.SchemaMappingImportImpl <em>Schema Mapping Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.SchemaMappingImportImpl
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getSchemaMappingImport()
   * @generated
   */
  int SCHEMA_MAPPING_IMPORT = 12;

    /**
   * The feature id for the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA_MAPPING_IMPORT__LOCATION = 0;

    /**
   * The number of structural features of the '<em>Schema Mapping Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA_MAPPING_IMPORT_FEATURE_COUNT = 1;

    /**
   * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType <em>Primary Key Type</em>}' enum.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getPrimaryKeyType()
   * @generated
   */
    int PRIMARY_KEY_TYPE = 13;

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey <em>Primary Key</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Key</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey
   * @generated
   */
    EClass getPrimaryKey();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey#getType()
   * @see #getPrimaryKey()
   * @generated
   */
    EAttribute getPrimaryKey_Type();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey <em>Relational Key</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Key</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey
   * @generated
   */
    EClass getRelationalKey();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey#getId()
   * @see #getRelationalKey()
   * @generated
   */
    EAttribute getRelationalKey_Id();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey#getValue()
   * @see #getRelationalKey()
   * @generated
   */
    EAttribute getRelationalKey_Value();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ForeignKey <em>Foreign Key</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foreign Key</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.ForeignKey
   * @generated
   */
    EClass getForeignKey();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition
   * @generated
   */
    EClass getCondition();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition#getId()
   * @see #getCondition()
   * @generated
   */
    EAttribute getCondition_Id();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition#getValue()
   * @see #getCondition()
   * @generated
   */
    EAttribute getCondition_Value();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cardinality</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality
   * @generated
   */
    EClass getCardinality();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality#getId()
   * @see #getCardinality()
   * @generated
   */
    EAttribute getCardinality_Id();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality#getValue()
   * @see #getCardinality()
   * @generated
   */
    EAttribute getCardinality_Value();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation <em>Scope Information</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scope Information</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation
   * @generated
   */
    EClass getScopeInformation();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation#getId()
   * @see #getScopeInformation()
   * @generated
   */
    EAttribute getScopeInformation_Id();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation#getCaseObject <em>Case Object</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Case Object</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation#getCaseObject()
   * @see #getScopeInformation()
   * @generated
   */
    EAttribute getScopeInformation_CaseObject();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document Root</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot
   * @generated
   */
    EClass getDocumentRoot();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getPrimaryKey <em>Primary Key</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Primary Key</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getPrimaryKey()
   * @see #getDocumentRoot()
   * @generated
   */
    EReference getDocumentRoot_PrimaryKey();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cardinality</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCardinality()
   * @see #getDocumentRoot()
   * @generated
   */
    EReference getDocumentRoot_Cardinality();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCondition()
   * @see #getDocumentRoot()
   * @generated
   */
    EReference getDocumentRoot_Condition();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getScopeInformation <em>Scope Information</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope Information</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getScopeInformation()
   * @see #getDocumentRoot()
   * @generated
   */
    EReference getDocumentRoot_ScopeInformation();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getForeignKey <em>Foreign Key</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Foreign Key</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getForeignKey()
   * @see #getDocumentRoot()
   * @generated
   */
    EReference getDocumentRoot_ForeignKey();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getMessageContentDefinition <em>Message Content Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Message Content Definition</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getMessageContentDefinition()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_MessageContentDefinition();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getMessageObject <em>Message Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Message Object</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getMessageObject()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_MessageObject();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCorrelationInformation <em>Correlation Information</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Correlation Information</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCorrelationInformation()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_CorrelationInformation();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getStructureDefinition <em>Structure Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Structure Definition</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getStructureDefinition()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_StructureDefinition();

    /**
   * Returns the meta object for the containment reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getSchemaMappingImports <em>Schema Mapping Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Schema Mapping Imports</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getSchemaMappingImports()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_SchemaMappingImports();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition <em>Message Content Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message Content Definition</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition
   * @generated
   */
  EClass getMessageContentDefinition();

    /**
   * Returns the meta object for the reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getPayloadRef <em>Payload Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Payload Ref</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getPayloadRef()
   * @see #getMessageContentDefinition()
   * @generated
   */
  EReference getMessageContentDefinition_PayloadRef();

    /**
   * Returns the meta object for the containment reference list '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getCorrelationIdentifierLinks <em>Correlation Identifier Links</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Correlation Identifier Links</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageContentDefinition#getCorrelationIdentifierLinks()
   * @see #getMessageContentDefinition()
   * @generated
   */
  EReference getMessageContentDefinition_CorrelationIdentifierLinks();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink <em>Item Definition Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Item Definition Link</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink
   * @generated
   */
  EClass getItemDefinitionLink();

    /**
   * Returns the meta object for the reference '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink#getRef()
   * @see #getItemDefinitionLink()
   * @generated
   */
  EReference getItemDefinitionLink_Ref();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageObject <em>Message Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message Object</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageObject
   * @generated
   */
  EClass getMessageObject();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation <em>Correlation Information</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Correlation Information</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation
   * @generated
   */
  EClass getCorrelationInformation();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation#getAttributeName <em>Attribute Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attribute Name</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation#getAttributeName()
   * @see #getCorrelationInformation()
   * @generated
   */
  EAttribute getCorrelationInformation_AttributeName();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition <em>Structure Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Structure Definition</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition
   * @generated
   */
  EClass getStructureDefinition();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition#getQname <em>Qname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Qname</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition#getQname()
   * @see #getStructureDefinition()
   * @generated
   */
  EAttribute getStructureDefinition_Qname();

    /**
   * Returns the meta object for class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.SchemaMappingImport <em>Schema Mapping Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Schema Mapping Import</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.SchemaMappingImport
   * @generated
   */
  EClass getSchemaMappingImport();

    /**
   * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.SchemaMappingImport#getLocation <em>Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Location</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.SchemaMappingImport#getLocation()
   * @see #getSchemaMappingImport()
   * @generated
   */
  EAttribute getSchemaMappingImport_Location();

    /**
   * Returns the meta object for enum '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType <em>Primary Key Type</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Primary Key Type</em>'.
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType
   * @generated
   */
    EEnum getPrimaryKeyType();

    /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
    BptFactory getBptFactory();

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
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.PrimaryKeyImpl <em>Primary Key</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.PrimaryKeyImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getPrimaryKey()
     * @generated
     */
        EClass PRIMARY_KEY = eINSTANCE.getPrimaryKey();

        /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute PRIMARY_KEY__TYPE = eINSTANCE.getPrimaryKey_Type();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.RelationalKeyImpl <em>Relational Key</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.RelationalKeyImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getRelationalKey()
     * @generated
     */
        EClass RELATIONAL_KEY = eINSTANCE.getRelationalKey();

        /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute RELATIONAL_KEY__ID = eINSTANCE.getRelationalKey_Id();

        /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute RELATIONAL_KEY__VALUE = eINSTANCE.getRelationalKey_Value();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ForeignKeyImpl <em>Foreign Key</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ForeignKeyImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getForeignKey()
     * @generated
     */
        EClass FOREIGN_KEY = eINSTANCE.getForeignKey();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ConditionImpl <em>Condition</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ConditionImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getCondition()
     * @generated
     */
        EClass CONDITION = eINSTANCE.getCondition();

        /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute CONDITION__ID = eINSTANCE.getCondition_Id();

        /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute CONDITION__VALUE = eINSTANCE.getCondition_Value();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.CardinalityImpl <em>Cardinality</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.CardinalityImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getCardinality()
     * @generated
     */
        EClass CARDINALITY = eINSTANCE.getCardinality();

        /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute CARDINALITY__ID = eINSTANCE.getCardinality_Id();

        /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute CARDINALITY__VALUE = eINSTANCE.getCardinality_Value();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ScopeInformationImpl <em>Scope Information</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ScopeInformationImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getScopeInformation()
     * @generated
     */
        EClass SCOPE_INFORMATION = eINSTANCE.getScopeInformation();

        /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute SCOPE_INFORMATION__ID = eINSTANCE.getScopeInformation_Id();

        /**
     * The meta object literal for the '<em><b>Case Object</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute SCOPE_INFORMATION__CASE_OBJECT = eINSTANCE.getScopeInformation_CaseObject();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.DocumentRootImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getDocumentRoot()
     * @generated
     */
        EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

        /**
     * The meta object literal for the '<em><b>Primary Key</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EReference DOCUMENT_ROOT__PRIMARY_KEY = eINSTANCE.getDocumentRoot_PrimaryKey();

        /**
     * The meta object literal for the '<em><b>Cardinality</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EReference DOCUMENT_ROOT__CARDINALITY = eINSTANCE.getDocumentRoot_Cardinality();

        /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EReference DOCUMENT_ROOT__CONDITION = eINSTANCE.getDocumentRoot_Condition();

        /**
     * The meta object literal for the '<em><b>Scope Information</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EReference DOCUMENT_ROOT__SCOPE_INFORMATION = eINSTANCE.getDocumentRoot_ScopeInformation();

        /**
     * The meta object literal for the '<em><b>Foreign Key</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EReference DOCUMENT_ROOT__FOREIGN_KEY = eINSTANCE.getDocumentRoot_ForeignKey();

        /**
     * The meta object literal for the '<em><b>Message Content Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__MESSAGE_CONTENT_DEFINITION = eINSTANCE.getDocumentRoot_MessageContentDefinition();

        /**
     * The meta object literal for the '<em><b>Message Object</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__MESSAGE_OBJECT = eINSTANCE.getDocumentRoot_MessageObject();

        /**
     * The meta object literal for the '<em><b>Correlation Information</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__CORRELATION_INFORMATION = eINSTANCE.getDocumentRoot_CorrelationInformation();

        /**
     * The meta object literal for the '<em><b>Structure Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__STRUCTURE_DEFINITION = eINSTANCE.getDocumentRoot_StructureDefinition();

        /**
     * The meta object literal for the '<em><b>Schema Mapping Imports</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__SCHEMA_MAPPING_IMPORTS = eINSTANCE.getDocumentRoot_SchemaMappingImports();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageContentDefinitionImpl <em>Message Content Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageContentDefinitionImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getMessageContentDefinition()
     * @generated
     */
    EClass MESSAGE_CONTENT_DEFINITION = eINSTANCE.getMessageContentDefinition();

        /**
     * The meta object literal for the '<em><b>Payload Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE_CONTENT_DEFINITION__PAYLOAD_REF = eINSTANCE.getMessageContentDefinition_PayloadRef();

        /**
     * The meta object literal for the '<em><b>Correlation Identifier Links</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE_CONTENT_DEFINITION__CORRELATION_IDENTIFIER_LINKS = eINSTANCE.getMessageContentDefinition_CorrelationIdentifierLinks();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ItemDefinitionLinkImpl <em>Item Definition Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.ItemDefinitionLinkImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getItemDefinitionLink()
     * @generated
     */
    EClass ITEM_DEFINITION_LINK = eINSTANCE.getItemDefinitionLink();

        /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITEM_DEFINITION_LINK__REF = eINSTANCE.getItemDefinitionLink_Ref();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageObjectImpl <em>Message Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.MessageObjectImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getMessageObject()
     * @generated
     */
    EClass MESSAGE_OBJECT = eINSTANCE.getMessageObject();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.CorrelationInformationImpl <em>Correlation Information</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.CorrelationInformationImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getCorrelationInformation()
     * @generated
     */
    EClass CORRELATION_INFORMATION = eINSTANCE.getCorrelationInformation();

        /**
     * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CORRELATION_INFORMATION__ATTRIBUTE_NAME = eINSTANCE.getCorrelationInformation_AttributeName();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.StructureDefinitionImpl <em>Structure Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.StructureDefinitionImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getStructureDefinition()
     * @generated
     */
    EClass STRUCTURE_DEFINITION = eINSTANCE.getStructureDefinition();

        /**
     * The meta object literal for the '<em><b>Qname</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCTURE_DEFINITION__QNAME = eINSTANCE.getStructureDefinition_Qname();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.SchemaMappingImportImpl <em>Schema Mapping Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.SchemaMappingImportImpl
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getSchemaMappingImport()
     * @generated
     */
    EClass SCHEMA_MAPPING_IMPORT = eINSTANCE.getSchemaMappingImport();

        /**
     * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCHEMA_MAPPING_IMPORT__LOCATION = eINSTANCE.getSchemaMappingImport_Location();

        /**
     * The meta object literal for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType <em>Primary Key Type</em>}' enum.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getPrimaryKeyType()
     * @generated
     */
        EEnum PRIMARY_KEY_TYPE = eINSTANCE.getPrimaryKeyType();

    }

} //BptPackage
