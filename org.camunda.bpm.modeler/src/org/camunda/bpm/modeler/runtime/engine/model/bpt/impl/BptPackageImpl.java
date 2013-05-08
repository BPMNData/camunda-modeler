/**
 */
package org.camunda.bpm.modeler.runtime.engine.model.bpt.impl;

import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;

import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.PrimaryKey;

import org.camunda.bpm.modeler.runtime.engine.model.fox.FoxPackage;

import org.camunda.bpm.modeler.runtime.engine.model.fox.impl.FoxPackageImpl;

import org.camunda.bpm.modeler.runtime.engine.model.impl.ModelPackageImpl;

import org.eclipse.bpmn2.Bpmn2Package;

import org.eclipse.bpmn2.di.BpmnDiPackage;

import org.eclipse.dd.dc.DcPackage;

import org.eclipse.dd.di.DiPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
    public EAttribute getPrimaryKey_Id() {
        return (EAttribute)primaryKeyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPrimaryKey_Value() {
        return (EAttribute)primaryKeyEClass.getEStructuralFeatures().get(1);
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
        createEAttribute(primaryKeyEClass, PRIMARY_KEY__ID);
        createEAttribute(primaryKeyEClass, PRIMARY_KEY__VALUE);
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

        // Initialize classes and features; add operations and parameters
        initEClass(primaryKeyEClass, PrimaryKey.class, "PrimaryKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPrimaryKey_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, PrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPrimaryKey_Value(), theXMLTypePackage.getString(), "value", "", 0, 1, PrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
          (getPrimaryKey_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });			
        addAnnotation
          (getPrimaryKey_Value(), 
           source, 
           new String[] {
             "kind", "simple",
             "name", ":0"
           });
    }

} //BptPackageImpl
