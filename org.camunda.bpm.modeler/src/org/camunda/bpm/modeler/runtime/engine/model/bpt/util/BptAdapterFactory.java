/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt.util;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage
 * @generated
 */
public class BptAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static BptPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BptAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = BptPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BptSwitch<Adapter> modelSwitch =
        new BptSwitch<Adapter>() {
            @Override
            public Adapter casePrimaryKey(PrimaryKey object) {
                return createPrimaryKeyAdapter();
            }
            @Override
            public Adapter caseRelationalKey(RelationalKey object) {
                return createRelationalKeyAdapter();
            }
            @Override
            public Adapter caseForeignKey(ForeignKey object) {
                return createForeignKeyAdapter();
            }
            @Override
            public Adapter caseCondition(Condition object) {
                return createConditionAdapter();
            }
            @Override
            public Adapter caseCardinality(Cardinality object) {
                return createCardinalityAdapter();
            }
            @Override
            public Adapter caseScopeInformation(ScopeInformation object) {
                return createScopeInformationAdapter();
            }
            @Override
            public Adapter caseDocumentRoot(DocumentRoot object) {
                return createDocumentRootAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey <em>Primary Key</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey
     * @generated
     */
    public Adapter createPrimaryKeyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey <em>Relational Key</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey
     * @generated
     */
    public Adapter createRelationalKeyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ForeignKey <em>Foreign Key</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.ForeignKey
     * @generated
     */
    public Adapter createForeignKeyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition
     * @generated
     */
    public Adapter createConditionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality <em>Cardinality</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality
     * @generated
     */
    public Adapter createCardinalityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation <em>Scope Information</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation
     * @generated
     */
    public Adapter createScopeInformationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot
     * @generated
     */
    public Adapter createDocumentRootAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //BptAdapterFactory
