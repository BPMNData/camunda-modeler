/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.unipotsdam.hpi.bpt.schemamapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.unipotsdam.hpi.bpt.schemamapping.SchemamappingPackage
 * @generated
 */
public interface SchemamappingFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SchemamappingFactory eINSTANCE = de.unipotsdam.hpi.bpt.schemamapping.impl.SchemamappingFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Document Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Document Root</em>'.
   * @generated
   */
  DocumentRoot createDocumentRoot();

  /**
   * Returns a new object of class '<em>Schema Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Schema Mapping</em>'.
   * @generated
   */
  SchemaMapping createSchemaMapping();

  /**
   * Returns a new object of class '<em>Class Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Mapping</em>'.
   * @generated
   */
  ClassMapping createClassMapping();

  /**
   * Returns a new object of class '<em>Attribute Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Mapping</em>'.
   * @generated
   */
  AttributeMapping createAttributeMapping();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SchemamappingPackage getSchemamappingPackage();

} //SchemamappingFactory
