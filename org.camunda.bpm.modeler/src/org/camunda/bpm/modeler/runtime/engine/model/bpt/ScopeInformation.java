/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines the case object for a process.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation#getId <em>Id</em>}</li>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation#getCaseObject <em>Case Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getScopeInformation()
 * @model extendedMetaData="name='tScopeInformation' kind='element'"
 * @generated
 */
public interface ScopeInformation extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Defines the id of this object.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getScopeInformation_Id()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Case Object</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The case object for this scope.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case Object</em>' attribute.
     * @see #setCaseObject(String)
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getScopeInformation_CaseObject()
     * @model default="" dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='caseObject'"
     * @generated
     */
    String getCaseObject();

    /**
     * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation#getCaseObject <em>Case Object</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case Object</em>' attribute.
     * @see #getCaseObject()
     * @generated
     */
    void setCaseObject(String value);

} // ScopeInformation
