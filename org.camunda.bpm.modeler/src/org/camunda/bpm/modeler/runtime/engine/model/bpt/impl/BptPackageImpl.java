/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt.impl;

import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ForeignKey;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyTypes;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.RelationalKey;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ScopeInformation;
import org.camunda.bpm.modeler.runtime.engine.model.fox.FoxPackage;

import org.camunda.bpm.modeler.runtime.engine.model.fox.impl.FoxPackageImpl;

import org.camunda.bpm.modeler.runtime.engine.model.impl.ModelPackageImpl;

import org.eclipse.bpmn2.Bpmn2Package;

import org.eclipse.bpmn2.di.BpmnDiPackage;

import org.eclipse.dd.dc.DcPackage;

import org.eclipse.dd.di.DiPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BptPackageImpl extends EPackageImpl implements BptPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primaryKeyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass relationalKeyEClass = null;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass foreignKeyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass conditionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cardinalityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scopeInformationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum primaryKeyTypesEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private BptPackageImpl() {
        super(eNS_URI, BptFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link BptPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static BptPackage init() {
        if (isInited) return (BptPackage)EPackage.Registry.INSTANCE.getEPackage(BptPackage.eNS_URI);

        // Obtain or create and register package
        BptPackageImpl theBptPackage = (BptPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BptPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BptPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        Bpmn2Package.eINSTANCE.eClass();
        BpmnDiPackage.eINSTANCE.eClass();
        DiPackage.eINSTANCE.eClass();
        DcPackage.eINSTANCE.eClass();
        XMLTypePackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
        FoxPackageImpl theFoxPackage = (FoxPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FoxPackage.eNS_URI) instanceof FoxPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FoxPackage.eNS_URI) : FoxPackage.eINSTANCE);

        // Create package meta-data objects
        theBptPackage.createPackageContents();
        theModelPackage.createPackageContents();
        theFoxPackage.createPackageContents();

        // Initialize created meta-data
        theBptPackage.initializePackageContents();
        theModelPackage.initializePackageContents();
        theFoxPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theBptPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(BptPackage.eNS_URI, theBptPackage);
        return theBptPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPrimaryKey() {
        return primaryKeyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPrimaryKey_Type() {
        return (EAttribute)primaryKeyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRelationalKey() {
        return relationalKeyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRelationalKey_Id() {
        return (EAttribute)relationalKeyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRelationalKey_Value() {
        return (EAttribute)relationalKeyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getForeignKey() {
        return foreignKeyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCondition() {
        return conditionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCondition_Id() {
        return (EAttribute)conditionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCondition_Value() {
        return (EAttribute)conditionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCardinality() {
        return cardinalityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCardinality_Id() {
        return (EAttribute)cardinalityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCardinality_Value() {
        return (EAttribute)cardinalityEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScopeInformation() {
        return scopeInformationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScopeInformation_Id() {
        return (EAttribute)scopeInformationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScopeInformation_CaseObject() {
        return (EAttribute)scopeInformationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPrimaryKeyTypes() {
        return primaryKeyTypesEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BptFactory getBptFactory() {
        return (BptFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        primaryKeyEClass = createEClass(PRIMARY_KEY);
        createEAttribute(primaryKeyEClass, PRIMARY_KEY__TYPE);

        relationalKeyEClass = createEClass(RELATIONAL_KEY);
        createEAttribute(relationalKeyEClass, RELATIONAL_KEY__ID);
        createEAttribute(relationalKeyEClass, RELATIONAL_KEY__VALUE);

        foreignKeyEClass = createEClass(FOREIGN_KEY);

        conditionEClass = createEClass(CONDITION);
        createEAttribute(conditionEClass, CONDITION__ID);
        createEAttribute(conditionEClass, CONDITION__VALUE);

        cardinalityEClass = createEClass(CARDINALITY);
        createEAttribute(cardinalityEClass, CARDINALITY__ID);
        createEAttribute(cardinalityEClass, CARDINALITY__VALUE);

        scopeInformationEClass = createEClass(SCOPE_INFORMATION);
        createEAttribute(scopeInformationEClass, SCOPE_INFORMATION__ID);
        createEAttribute(scopeInformationEClass, SCOPE_INFORMATION__CASE_OBJECT);

        // Create enums
        primaryKeyTypesEEnum = createEEnum(PRIMARY_KEY_TYPES);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        primaryKeyEClass.getESuperTypes().add(this.getRelationalKey());
        foreignKeyEClass.getESuperTypes().add(this.getRelationalKey());

        // Initialize classes and features; add operations and parameters
        initEClass(primaryKeyEClass, PrimaryKey.class, "PrimaryKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPrimaryKey_Type(), this.getPrimaryKeyTypes(), "type", "", 0, 1, PrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(relationalKeyEClass, RelationalKey.class, "RelationalKey", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRelationalKey_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, RelationalKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRelationalKey_Value(), theXMLTypePackage.getString(), "value", "", 0, 1, RelationalKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(foreignKeyEClass, ForeignKey.class, "ForeignKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(conditionEClass, Condition.class, "Condition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCondition_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCondition_Value(), theXMLTypePackage.getString(), "value", "", 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(cardinalityEClass, Cardinality.class, "Cardinality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCardinality_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, Cardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCardinality_Value(), theXMLTypePackage.getString(), "value", "", 0, 1, Cardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(scopeInformationEClass, ScopeInformation.class, "ScopeInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getScopeInformation_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, ScopeInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScopeInformation_CaseObject(), theXMLTypePackage.getString(), "caseObject", "", 0, 1, ScopeInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(primaryKeyTypesEEnum, PrimaryKeyTypes.class, "PrimaryKeyTypes");
        addEEnumLiteral(primaryKeyTypesEEnum, PrimaryKeyTypes.DEFAULT);
        addEEnumLiteral(primaryKeyTypesEEnum, PrimaryKeyTypes.NEW);
        addEEnumLiteral(primaryKeyTypesEEnum, PrimaryKeyTypes.DELETE);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations() {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
        addAnnotation
          (primaryKeyEClass, 
           source, 
           new String[] {
             "name", "tPrimaryKey",
             "kind", "simple"
           });				
        addAnnotation
          (getPrimaryKey_Type(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "type"
           });		
        addAnnotation
          (relationalKeyEClass, 
           source, 
           new String[] {
             "name", "tRelationalKey",
             "kind", "simple"
           });				
        addAnnotation
          (getRelationalKey_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });			
        addAnnotation
          (getRelationalKey_Value(), 
           source, 
           new String[] {
             "kind", "simple",
             "name", ":0"
           });		
        addAnnotation
          (foreignKeyEClass, 
           source, 
           new String[] {
             "name", "tForeignKey",
             "kind", "simple"
           });			
        addAnnotation
          (primaryKeyTypesEEnum, 
           source, 
           new String[] {
             "name", "tPrimaryKeyTypes"
           });		
        addAnnotation
          (conditionEClass, 
           source, 
           new String[] {
             "name", "tCondition",
             "kind", "simple"
           });				
        addAnnotation
          (getCondition_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });			
        addAnnotation
          (getCondition_Value(), 
           source, 
           new String[] {
             "kind", "simple",
             "name", ":0"
           });		
        addAnnotation
          (cardinalityEClass, 
           source, 
           new String[] {
             "name", "tCondition",
             "kind", "simple"
           });				
        addAnnotation
          (getCardinality_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });			
        addAnnotation
          (getCardinality_Value(), 
           source, 
           new String[] {
             "kind", "simple",
             "name", ":0"
           });		
        addAnnotation
          (scopeInformationEClass, 
           source, 
           new String[] {
             "name", "tScopeInformation",
             "kind", "element"
           });				
        addAnnotation
          (getScopeInformation_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });			
        addAnnotation
          (getScopeInformation_CaseObject(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "caseObject"
           });
    }

} //BptPackageImpl
