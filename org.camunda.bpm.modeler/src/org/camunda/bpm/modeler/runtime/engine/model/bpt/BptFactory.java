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
   * Returns a new object of class '<em>Foreign Key</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Foreign Key</em>'.
   * @generated
   */
    ForeignKey createForeignKey();

    /**
   * Returns a new object of class '<em>Condition</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Condition</em>'.
   * @generated
   */
    Condition createCondition();

    /**
   * Returns a new object of class '<em>Cardinality</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Cardinality</em>'.
   * @generated
   */
    Cardinality createCardinality();

    /**
   * Returns a new object of class '<em>Scope Information</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Scope Information</em>'.
   * @generated
   */
    ScopeInformation createScopeInformation();

    /**
   * Returns a new object of class '<em>Document Root</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Document Root</em>'.
   * @generated
   */
    DocumentRoot createDocumentRoot();

    /**
   * Returns a new object of class '<em>Message Content Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Content Definition</em>'.
   * @generated
   */
  MessageContentDefinition createMessageContentDefinition();

    /**
   * Returns a new object of class '<em>Item Definition Link</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Item Definition Link</em>'.
   * @generated
   */
  ItemDefinitionLink createItemDefinitionLink();

    /**
   * Returns a new object of class '<em>Message Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Object</em>'.
   * @generated
   */
  MessageObject createMessageObject();

    /**
   * Returns a new object of class '<em>Correlation Information</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Correlation Information</em>'.
   * @generated
   */
  CorrelationInformation createCorrelationInformation();

    /**
   * Returns a new object of class '<em>Structure Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Structure Definition</em>'.
   * @generated
   */
  StructureDefinition createStructureDefinition();

    /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
    BptPackage getBptPackage();

} //BptFactory
