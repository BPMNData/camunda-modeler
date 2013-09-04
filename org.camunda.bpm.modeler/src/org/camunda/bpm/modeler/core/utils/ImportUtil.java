package org.camunda.bpm.modeler.core.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageObject;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.DocumentRoot;
import org.eclipse.bpmn2.Import;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * This class is in charge of loading {@link Import} files and create
 * appropriate {@link ItemDefinition} objects.
 */
public class ImportUtil {

  public static final String XSD_NAMESPACE = "http://www.w3.org/2001/XMLSchema";

  private static Map<String, Loader> loaders = new ConcurrentHashMap<String, Loader>();

  static {
    registerLoader(XSD_NAMESPACE, new XsdLoader());
  }

  /**
   * Registers a loader for the specified importType. It can then be used at
   * {@link #loadItemDefinitions(Import)}.
   */
  public synchronized static void registerLoader(String importType, Loader loader) {
    loaders.put(importType, loader);
  }

  /**
   * Loads the specified Import
   * 
   * @param specification
   * @return
   */
  public static List<ItemDefinition> loadItemDefinitions(Import specification) throws ImportException {
    String importType = specification.getImportType();
    if (importType == null || importType.trim().isEmpty()) {
      Definitions definitions = (Definitions) specification.eContainer();
      importType = definitions.getTypeLanguage();
    }
    if (importType == null || importType.trim().isEmpty())
      throw new ImportException("No import type specified!");

    Loader loader = loaders.get(importType);
    if (loader == null)
      throw new ImportException("No loader found for " + importType);

    return loader.loadItemDefinitions(specification);
  }

  /**
   * Loads {@link ItemDefinition} objects from the given {@link Import} and adds
   * it to the given {@link Definitions}.
   */
  public static void importItemDefinitions(Import imp, final Definitions definitions) {
    final List<ItemDefinition> itemDefinitions = loadItemDefinitions(imp);
    if (!itemDefinitions.isEmpty()) {

      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(imp);
      editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

        @Override
        protected void doExecute() {
          insertItemDefinitions(itemDefinitions, definitions);
        }

      });
    }
  }

  /**
   * Inserts or updates the new {@link ItemDefinition} objects into the given
   * {@link Definitions} object.
   */
  private static void insertItemDefinitions(final List<ItemDefinition> newItemDefinitions, final Definitions definitions) {
    List<ItemDefinition> oldItemDefinitions = ModelUtil.getAllRootElements(definitions, ItemDefinition.class);
    for (ItemDefinition newItemDefinition : newItemDefinitions) {
      removeExistingItemDefinition(newItemDefinition, oldItemDefinitions, definitions);
      definitions.getRootElements().add(newItemDefinition);
    }
  }

  /**
   * Removes existing {@link ItemDefinition} objects that reference the same
   * structure.
   */
  private static void removeExistingItemDefinition(ItemDefinition newItemDefinition, List<ItemDefinition> oldItemDefinitions, Definitions definitions) {
    StructureDefinition newStructureDef = getStructureDefinition(newItemDefinition);
    if (newStructureDef == null)
      return;

    for (ItemDefinition oldItemDefinition : oldItemDefinitions) {
      StructureDefinition oldStructureDef = getStructureDefinition(oldItemDefinition);
      if (oldStructureDef != null && newStructureDef.getQname().equals(oldStructureDef.getQname())) {
        definitions.getRootElements().remove(oldItemDefinition);
      }
    }
  }

  private static StructureDefinition getStructureDefinition(ItemDefinition itemDefinition) {
    Object structureRef = itemDefinition.getStructureRef();
    if (structureRef instanceof StructureDefinition) {
      return (StructureDefinition) structureRef;
    } else if (structureRef instanceof InternalEObject) {
      Resource eResource = itemDefinition.eResource();
      String uri = ((InternalEObject) structureRef).eProxyURI().toString();
      return (StructureDefinition) eResource.getEObject(uri);
    }
    return null;
  }
  
  /**
   *  Gets or creates a XML namespace declaration in the document root for the given uri.
   */
  private static String getOrCreateNamespacePrefix(String namespaceUri, Import importElement) {
    Resource resource = importElement.eResource();
    DocumentRoot docRoot = (DocumentRoot) resource.getContents().get(0);
    Map<String, String> prefixMap = docRoot.getXMLNSPrefixMap();
    int i = 1;
    while (true) {
      String prefix = "import" + i;
      String uri= prefixMap.get(prefix);
      if (uri == null) {
        prefixMap.put(prefix, namespaceUri);
        return prefix;
      } else if (uri.equals(namespaceUri)) {
        return prefix;
      }
      i++;
    }
  }

  /**
   * An import exception describes that it was not possible to do an import as
   * specified by an {@link Import} object.
   */
  public static class ImportException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ImportException(String message, Throwable cause) {
      super(message, cause);
    }

    public ImportException(String message) {
      super(message);
    }

    public ImportException(Throwable cause) {
      super(cause);
    }

  }

  /**
   * A specific loader can handle a specific import type.
   * 
   * @see Import#getImportType()
   */
  public static interface Loader {

    /** Loads item definitions. */
    List<ItemDefinition> loadItemDefinitions(Import specification);

  }

  public static abstract class AbstractLoader implements Loader {

  }

  /**
   * Loader for XML Schema files.
   */
  public static class XsdLoader extends AbstractLoader {

    public static final String CI_ATTRIBUTE_NAME_ATTRIBUTE = "attributeName";
    public static final String BPMN_DATA_NS = "http://bpt.hpi.uni-potsdam.de/bpmn-data/";
    public static final String CORRELATION_IDENTIFIER_ELEMENT = "correlationIdentifier";
    public static final String MESSAGE_OBJECT_ELEMENT = "message";

    @Override
    public List<ItemDefinition> loadItemDefinitions(Import specification) {
      List<ItemDefinition> itemDefinitions = new ArrayList<ItemDefinition>();

      try {
        String location = specification.getLocation();
        URI uri = URI.createPlatformResourceURI(location, false);
        XSDResourceImpl resource = new XSDResourceImpl(uri);
        resource.load(Collections.emptyMap());

        XSDSchema schema = resource.getSchema();
        String targetNamespace = schema.getTargetNamespace();
        String prefix = getOrCreateNamespacePrefix(targetNamespace, specification);
        EList<XSDTypeDefinition> typeDefinitions = schema.getTypeDefinitions();
        for (XSDTypeDefinition typeDefinition : typeDefinitions) {
          ItemDefinition itemDefinition = createItemDefinition(specification, prefix, typeDefinition);
          itemDefinitions.add(itemDefinition);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

      return itemDefinitions;
    }

    private ItemDefinition createItemDefinition(Import specification, String prefix, XSDTypeDefinition typeDefinition) {
      ItemDefinition itemDefinition = ModelHandler.create(specification.eResource(), ItemDefinition.class);

      // set structure ref
      String locationAsString = prefix + ":" + typeDefinition.getName();
      StructureDefinition structDef = BptFactory.eINSTANCE.createStructureDefinition();
      structDef.setQname(locationAsString);
      ModelUtil.setID(structDef);
      ExtensionUtil.addExtension(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_StructureDefinition(), structDef);
      itemDefinition.setStructureRef(structDef);

      // extract extensions
      EList<XSDAnnotation> annotations = typeDefinition.getAnnotations();
      List<String> ciAttributes = new ArrayList<String>();
      boolean isMessageObject = false;
      for (XSDAnnotation annotation : annotations) {
        for (Element appInfo : annotation.getApplicationInformation()) {
          Node child = appInfo.getFirstChild();
          while (child != null) {
            if (BPMN_DATA_NS.equals(child.getNamespaceURI())) {
              if (MESSAGE_OBJECT_ELEMENT.equals(child.getLocalName())) {
                isMessageObject = true;
              } else if (CORRELATION_IDENTIFIER_ELEMENT.equals(child.getLocalName())) {
                ciAttributes.add(child.getAttributes().getNamedItem(CI_ATTRIBUTE_NAME_ATTRIBUTE).getNodeValue());
              }
            }
            child = child.getNextSibling();
          }
        }
      }

      if (isMessageObject) {
        MessageObject messageObject = BptFactory.eINSTANCE.createMessageObject();
        ExtensionUtil.addExtension(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_MessageObject(), messageObject);
      }

      for (String ciAttribute : ciAttributes) {
        CorrelationInformation ciInfo = BptFactory.eINSTANCE.createCorrelationInformation();
        ciInfo.setAttributeName(ciAttribute);
        ExtensionUtil.addExtension(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_CorrelationInformation(), ciInfo);
      }

      return itemDefinition;
    }

  }

}
