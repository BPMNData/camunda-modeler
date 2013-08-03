/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.bpmn2.ItemDefinition;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Definition Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getItemDefinitionLink()
 * @model extendedMetaData="name='tItemDefinitionLink' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface ItemDefinitionLink extends EObject {
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(ItemDefinition)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getItemDefinitionLink_Ref()
   * @model extendedMetaData="kind='attribute' name='ref'"
   * @generated
   */
  ItemDefinition getRef();

  /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.ItemDefinitionLink#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(ItemDefinition value);

} // ItemDefinitionLink
