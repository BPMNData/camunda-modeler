/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt.impl;

import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.Cardinality;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.Condition;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.DocumentRoot;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.ForeignKey;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKeyType;
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

import org.eclipse.emf.ecore.EReference;
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
    private EClass documentRootEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum primaryKeyTypeEEnum = null;

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
    public EClass getDocumentRoot() {
        return documentRootEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_PrimaryKey() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Cardinality() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Condition() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_ScopeInformation() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_ForeignKey() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPrimaryKeyType() {
        return primaryKeyTypeEEnum;
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

        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PRIMARY_KEY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CARDINALITY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CONDITION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__SCOPE_INFORMATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FOREIGN_KEY);

        // Create enums
        primaryKeyTypeEEnum = createEEnum(PRIMARY_KEY_TYPE);
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
        initEAttribute(getPrimaryKey_Type(), this.getPrimaryKeyType(), "type", "", 0, 1, PrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDocumentRoot_PrimaryKey(), this.getPrimaryKey(), null, "primaryKey", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Cardinality(), this.getCardinality(), null, "cardinality", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Condition(), this.getCondition(), null, "condition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ScopeInformation(), this.getScopeInformation(), null, "scopeInformation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ForeignKey(), this.getForeignKey(), null, "foreignKey", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(primaryKeyTypeEEnum, PrimaryKeyType.class, "PrimaryKeyType");
        addEEnumLiteral(primaryKeyTypeEEnum, PrimaryKeyType.DEFAULT);
        addEEnumLiteral(primaryKeyTypeEEnum, PrimaryKeyType.NEW);
        addEEnumLiteral(primaryKeyTypeEEnum, PrimaryKeyType.DELETE);

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
          (primaryKeyTypeEEnum, 
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
        addAnnotation
          (documentRootEClass, 
           source, 
           new String[] {
             "name", "",
             "kind", "mixed",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (getDocumentRoot_PrimaryKey(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "primaryKey",
             "namespace", "http://bpt.hpi.uni-potsdam.de"
           });		
        addAnnotation
          (getDocumentRoot_Cardinality(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "cardinality",
             "namespace", "https://bpt.hpi.uni-potsdam.de"
           });		
        addAnnotation
          (getDocumentRoot_Condition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "condition",
             "namespace", "https://bpt.hpi.uni-potsdam.de"
           });		
        addAnnotation
          (getDocumentRoot_ScopeInformation(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "scopeInformation",
             "namespace", "https://bpt.hpi.uni-potsdam.de"
           });		
        addAnnotation
          (getDocumentRoot_ForeignKey(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "foreignKey",
             "namespace", "http://bpt.hpi.uni-potsdam.de"
           });
    }

} //BptPackageImpl
