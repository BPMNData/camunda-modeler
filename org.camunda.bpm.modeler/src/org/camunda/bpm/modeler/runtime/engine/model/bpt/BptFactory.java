/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage
 * @generated
 */
public interface BptFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BptFactory eINSTANCE = org.camunda.bpm.modeler.runtime.engine.model.bpt.impl.BptFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Primary Key</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primary Key</em>'.
     * @generated
     */
    PrimaryKey createPrimaryKey();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    BptPackage getBptPackage();

} //BptFactory
