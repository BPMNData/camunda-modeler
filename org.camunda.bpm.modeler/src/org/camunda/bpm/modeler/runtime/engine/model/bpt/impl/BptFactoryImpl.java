/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt.impl;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BptFactoryImpl extends EFactoryImpl implements BptFactory {
    /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public static BptFactory init() {
    try {
      BptFactory theBptFactory = (BptFactory)EPackage.Registry.INSTANCE.getEFactory("http://bpt.hpi.uni-potsdam.de"); 
      if (theBptFactory != null) {
        return theBptFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BptFactoryImpl();
  }

    /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public BptFactoryImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case BptPackage.PRIMARY_KEY: return createPrimaryKey();
      case BptPackage.FOREIGN_KEY: return createForeignKey();
      case BptPackage.CONDITION: return createCondition();
      case BptPackage.CARDINALITY: return createCardinality();
      case BptPackage.SCOPE_INFORMATION: return createScopeInformation();
      case BptPackage.DOCUMENT_ROOT: return createDocumentRoot();
      case BptPackage.MESSAGE_CONTENT_DEFINITION: return createMessageContentDefinition();
      case BptPackage.MESSAGE_OBJECT: return createMessageObject();
      case BptPackage.CORRELATION_INFORMATION: return createCorrelationInformation();
      case BptPackage.STRUCTURE_DEFINITION: return createStructureDefinition();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case BptPackage.PRIMARY_KEY_TYPE:
        return createPrimaryKeyTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case BptPackage.PRIMARY_KEY_TYPE:
        return convertPrimaryKeyTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public PrimaryKey createPrimaryKey() {
    PrimaryKeyImpl primaryKey = new PrimaryKeyImpl();
    return primaryKey;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ForeignKey createForeignKey() {
    ForeignKeyImpl foreignKey = new ForeignKeyImpl();
    return foreignKey;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public Condition createCondition() {
    ConditionImpl condition = new ConditionImpl();
    return condition;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public Cardinality createCardinality() {
    CardinalityImpl cardinality = new CardinalityImpl();
    return cardinality;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ScopeInformation createScopeInformation() {
    ScopeInformationImpl scopeInformation = new ScopeInformationImpl();
    return scopeInformation;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public DocumentRoot createDocumentRoot() {
    DocumentRootImpl documentRoot = new DocumentRootImpl();
    return documentRoot;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageContentDefinition createMessageContentDefinition() {
    MessageContentDefinitionImpl messageContentDefinition = new MessageContentDefinitionImpl();
    return messageContentDefinition;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageObject createMessageObject() {
    MessageObjectImpl messageObject = new MessageObjectImpl();
    return messageObject;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CorrelationInformation createCorrelationInformation() {
    CorrelationInformationImpl correlationInformation = new CorrelationInformationImpl();
    return correlationInformation;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructureDefinition createStructureDefinition() {
    StructureDefinitionImpl structureDefinition = new StructureDefinitionImpl();
    return structureDefinition;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public PrimaryKeyType createPrimaryKeyTypeFromString(EDataType eDataType, String initialValue) {
    PrimaryKeyType result = PrimaryKeyType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public String convertPrimaryKeyTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public BptPackage getBptPackage() {
    return (BptPackage)getEPackage();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
    @Deprecated
    public static BptPackage getPackage() {
    return BptPackage.eINSTANCE;
  }

} //BptFactoryImpl
