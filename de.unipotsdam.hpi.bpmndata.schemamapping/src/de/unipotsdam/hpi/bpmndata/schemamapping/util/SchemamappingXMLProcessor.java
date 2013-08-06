/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpmndata.schemamapping.util;

import de.unipotsdam.hpi.bpmndata.schemamapping.SchemamappingPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SchemamappingXMLProcessor extends XMLProcessor {

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SchemamappingXMLProcessor() {
    super((EPackage.Registry.INSTANCE));
    SchemamappingPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the SchemamappingResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Map getRegistrations() {
    if (registrations == null) {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new SchemamappingResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new SchemamappingResourceFactoryImpl());
    }
    return registrations;
  }

} //SchemamappingXMLProcessor
