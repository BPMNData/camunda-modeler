/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition#getQname <em>Qname</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getStructureDefinition()
 * @model extendedMetaData="name='tStructureDefinition' kind='mixed' namespace='##targetNamespace'"
 * @generated
 */
public interface StructureDefinition extends BaseElement {
  /**
   * Returns the value of the '<em><b>Qname</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qname</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qname</em>' attribute.
   * @see #setQname(String)
   * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#getStructureDefinition_Qname()
   * @model default="" dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='qname'"
   * @generated
   */
  String getQname();

  /**
   * Sets the value of the '{@link org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition#getQname <em>Qname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qname</em>' attribute.
   * @see #getQname()
   * @generated
   */
  void setQname(String value);

} // StructureDefinition
