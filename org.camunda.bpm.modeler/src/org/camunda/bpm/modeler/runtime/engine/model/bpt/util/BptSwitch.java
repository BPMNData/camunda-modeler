/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt.util;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.*;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage
 * @generated
 */
public class BptSwitch<T> extends Switch<T> {
    /**
   * The cached model package
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected static BptPackage modelPackage;

    /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public BptSwitch() {
    if (modelPackage == null) {
      modelPackage = BptPackage.eINSTANCE;
    }
  }

    /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

    /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case BptPackage.PRIMARY_KEY: {
        PrimaryKey primaryKey = (PrimaryKey)theEObject;
        T result = casePrimaryKey(primaryKey);
        if (result == null) result = caseRelationalKey(primaryKey);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.RELATIONAL_KEY: {
        RelationalKey relationalKey = (RelationalKey)theEObject;
        T result = caseRelationalKey(relationalKey);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.FOREIGN_KEY: {
        ForeignKey foreignKey = (ForeignKey)theEObject;
        T result = caseForeignKey(foreignKey);
        if (result == null) result = caseRelationalKey(foreignKey);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.CONDITION: {
        Condition condition = (Condition)theEObject;
        T result = caseCondition(condition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.CARDINALITY: {
        Cardinality cardinality = (Cardinality)theEObject;
        T result = caseCardinality(cardinality);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.SCOPE_INFORMATION: {
        ScopeInformation scopeInformation = (ScopeInformation)theEObject;
        T result = caseScopeInformation(scopeInformation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.DOCUMENT_ROOT: {
        DocumentRoot documentRoot = (DocumentRoot)theEObject;
        T result = caseDocumentRoot(documentRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.MESSAGE_CONTENT_DEFINITION: {
        MessageContentDefinition messageContentDefinition = (MessageContentDefinition)theEObject;
        T result = caseMessageContentDefinition(messageContentDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.ITEM_DEFINITION_LINK: {
        ItemDefinitionLink itemDefinitionLink = (ItemDefinitionLink)theEObject;
        T result = caseItemDefinitionLink(itemDefinitionLink);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.MESSAGE_OBJECT: {
        MessageObject messageObject = (MessageObject)theEObject;
        T result = caseMessageObject(messageObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.CORRELATION_INFORMATION: {
        CorrelationInformation correlationInformation = (CorrelationInformation)theEObject;
        T result = caseCorrelationInformation(correlationInformation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.STRUCTURE_DEFINITION: {
        StructureDefinition structureDefinition = (StructureDefinition)theEObject;
        T result = caseStructureDefinition(structureDefinition);
        if (result == null) result = caseBaseElement(structureDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BptPackage.SCHEMA_MAPPING_IMPORT: {
        SchemaMappingImport schemaMappingImport = (SchemaMappingImport)theEObject;
        T result = caseSchemaMappingImport(schemaMappingImport);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Key</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Key</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T casePrimaryKey(PrimaryKey object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Key</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Key</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseRelationalKey(RelationalKey object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Foreign Key</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Foreign Key</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseForeignKey(ForeignKey object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseCondition(Condition object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Cardinality</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cardinality</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseCardinality(Cardinality object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Scope Information</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scope Information</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseScopeInformation(ScopeInformation object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseDocumentRoot(DocumentRoot object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Message Content Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message Content Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessageContentDefinition(MessageContentDefinition object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Item Definition Link</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Item Definition Link</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseItemDefinitionLink(ItemDefinitionLink object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Message Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessageObject(MessageObject object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Correlation Information</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Correlation Information</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCorrelationInformation(CorrelationInformation object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Structure Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structure Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructureDefinition(StructureDefinition object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Schema Mapping Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Schema Mapping Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSchemaMappingImport(SchemaMappingImport object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Base Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Base Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBaseElement(BaseElement object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
    @Override
    public T defaultCase(EObject object) {
    return null;
  }

} //BptSwitch
