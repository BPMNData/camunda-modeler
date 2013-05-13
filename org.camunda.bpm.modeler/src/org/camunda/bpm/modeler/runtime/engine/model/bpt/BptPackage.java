/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

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
     * The number of structural features of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType <em>Primary Key Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptPackageImpl#getPrimaryKeyType()
     * @generated
     */
    int PRIMARY_KEY_TYPE = 7;

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
