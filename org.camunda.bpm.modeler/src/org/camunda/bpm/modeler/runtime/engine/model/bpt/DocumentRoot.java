/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getScopeInformation <em>Scope Information</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getForeignKey <em>Foreign Key</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getMessageContentDefinition <em>Message Content Definition</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getMessageObject <em>Message Object</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCorrelationInformation <em>Correlation Information</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getStructureDefinition <em>Structure Definition</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getSchemaMappingImports <em>Schema Mapping Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface DocumentRoot extends EObject {
    /**
   * Returns the value of the '<em><b>Primary Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primary Key</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Primary Key</em>' containment reference.
   * @see #setPrimaryKey(PrimaryKey)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_PrimaryKey()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='primaryKey' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
    PrimaryKey getPrimaryKey();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getPrimaryKey <em>Primary Key</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Key</em>' containment reference.
   * @see #getPrimaryKey()
   * @generated
   */
    void setPrimaryKey(PrimaryKey value);

    /**
   * Returns the value of the '<em><b>Cardinality</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cardinality</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Cardinality</em>' containment reference.
   * @see #setCardinality(Cardinality)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_Cardinality()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='cardinality' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
    Cardinality getCardinality();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCardinality <em>Cardinality</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cardinality</em>' containment reference.
   * @see #getCardinality()
   * @generated
   */
    void setCardinality(Cardinality value);

    /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Condition)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_Condition()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='condition' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
    Condition getCondition();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
    void setCondition(Condition value);

    /**
   * Returns the value of the '<em><b>Scope Information</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scope Information</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Scope Information</em>' containment reference.
   * @see #setScopeInformation(ScopeInformation)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_ScopeInformation()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='scopeInformation' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
    ScopeInformation getScopeInformation();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getScopeInformation <em>Scope Information</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scope Information</em>' containment reference.
   * @see #getScopeInformation()
   * @generated
   */
    void setScopeInformation(ScopeInformation value);

    /**
   * Returns the value of the '<em><b>Foreign Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreign Key</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Foreign Key</em>' containment reference.
   * @see #setForeignKey(ForeignKey)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_ForeignKey()
   * @model containment="true" upper="-2" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='foreignKey' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
    ForeignKey getForeignKey();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getForeignKey <em>Foreign Key</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Foreign Key</em>' containment reference.
   * @see #getForeignKey()
   * @generated
   */
    void setForeignKey(ForeignKey value);

    /**
   * Returns the value of the '<em><b>Message Content Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message Content Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message Content Definition</em>' containment reference.
   * @see #setMessageContentDefinition(MessageContentDefinition)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_MessageContentDefinition()
   * @model containment="true" upper="-2" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='contentDefinition' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
  MessageContentDefinition getMessageContentDefinition();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getMessageContentDefinition <em>Message Content Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Content Definition</em>' containment reference.
   * @see #getMessageContentDefinition()
   * @generated
   */
  void setMessageContentDefinition(MessageContentDefinition value);

    /**
   * Returns the value of the '<em><b>Message Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message Object</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message Object</em>' containment reference.
   * @see #setMessageObject(MessageObject)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_MessageObject()
   * @model containment="true" upper="-2" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='messageObject' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
  MessageObject getMessageObject();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getMessageObject <em>Message Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Object</em>' containment reference.
   * @see #getMessageObject()
   * @generated
   */
  void setMessageObject(MessageObject value);

    /**
   * Returns the value of the '<em><b>Correlation Information</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Correlation Information</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Correlation Information</em>' containment reference.
   * @see #setCorrelationInformation(CorrelationInformation)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_CorrelationInformation()
   * @model containment="true" upper="-2" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='correlationInformation' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
  CorrelationInformation getCorrelationInformation();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getCorrelationInformation <em>Correlation Information</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Correlation Information</em>' containment reference.
   * @see #getCorrelationInformation()
   * @generated
   */
  void setCorrelationInformation(CorrelationInformation value);

    /**
   * Returns the value of the '<em><b>Structure Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Structure Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Structure Definition</em>' containment reference.
   * @see #setStructureDefinition(StructureDefinition)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_StructureDefinition()
   * @model containment="true" upper="-2" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='structureDefinition' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
  StructureDefinition getStructureDefinition();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getStructureDefinition <em>Structure Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Structure Definition</em>' containment reference.
   * @see #getStructureDefinition()
   * @generated
   */
  void setStructureDefinition(StructureDefinition value);

    /**
   * Returns the value of the '<em><b>Schema Mapping Imports</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Schema Mapping Imports</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Schema Mapping Imports</em>' containment reference.
   * @see #setSchemaMappingImports(SchemaMappingImport)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getDocumentRoot_SchemaMappingImports()
   * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='schemaMappingImport' namespace='http://bpt.hpi.uni-potsdam.de'"
   * @generated
   */
  SchemaMappingImport getSchemaMappingImports();

    /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot#getSchemaMappingImports <em>Schema Mapping Imports</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Schema Mapping Imports</em>' containment reference.
   * @see #getSchemaMappingImports()
   * @generated
   */
  void setSchemaMappingImports(SchemaMappingImport value);

} // DocumentRoot
