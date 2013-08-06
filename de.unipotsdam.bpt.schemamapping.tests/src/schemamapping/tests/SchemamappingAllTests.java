/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package schemamapping.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Schema-mapping</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchemamappingAllTests extends TestSuite {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(suite());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Test suite() {
    TestSuite suite = new SchemamappingAllTests("Schema-mapping Tests");
    suite.addTest(SchemamappingTests.suite());
    return suite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SchemamappingAllTests(String name) {
    super(name);
  }

} //SchemamappingAllTests
