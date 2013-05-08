/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
    int PRIMARY_KEY__ID = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMARY_KEY__VALUE = 1;

    /**
     * The number of structural features of the '<em>Primary Key</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMARY_KEY_FEATURE_COUNT = 2;


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
     * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey#getId()
     * @see #getPrimaryKey()
     * @generated
     */
    EAttribute getPrimaryKey_Id();

    /**
     * Returns the meta object for the attribute '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey#getValue()
     * @see #getPrimaryKey()
     * @generated
     */
    EAttribute getPrimaryKey_Value();

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
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRIMARY_KEY__ID = eINSTANCE.getPrimaryKey_Id();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRIMARY_KEY__VALUE = eINSTANCE.getPrimaryKey_Value();

    }

} //BptPackage
