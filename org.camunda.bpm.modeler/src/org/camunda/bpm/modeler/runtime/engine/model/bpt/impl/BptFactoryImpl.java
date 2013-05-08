/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt.impl;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.*;

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
public class BptFactoryImpl extends EFactoryImpl implements BptFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static BptFactory init() {
        try {
            BptFactory theBptFactory = (BptFactory)EPackage.Registry.INSTANCE.getEFactory("http://bpt.hpi.uni-potsdam.de"); 
            if (theBptFactory != null) {
                return theBptFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BptFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BptFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case BptPackage.PRIMARY_KEY: return createPrimaryKey();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimaryKey createPrimaryKey() {
        PrimaryKeyImpl primaryKey = new PrimaryKeyImpl();
        return primaryKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BptPackage getBptPackage() {
        return (BptPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static BptPackage getPackage() {
        return BptPackage.eINSTANCE;
    }

} //BptFactoryImpl
