package org.camunda.bpm.modeler.core.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.camunda.bpm.modeler.core.ModelHandler;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptFactory;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.Import;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDResourceImpl;

/**
 * This class is in charge of loading {@link Import} files and create
 * appropriate {@link ItemDefinition} objects.
 * 
 * @author Sebastian
 * 
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
   * Reomves existing {@link ItemDefinition} objects that reference the same
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
    if (itemDefinition.getStructureRef() instanceof StructureDefinition) {
      return (StructureDefinition) itemDefinition.getStructureRef();
    }
    return null;
  }

  /**
   * An import exception describes that it was not possible to do an import as
   * specified by an {@link Import} object.
   * 
   * @author Sebastian
   * 
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
   * @author Sebastian
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
   * 
   * @author Sebastian
   */
  public static class XsdLoader extends AbstractLoader {

    @Override
    public List<ItemDefinition> loadItemDefinitions(Import specification) {
      List<ItemDefinition> itemDefinitions = new ArrayList<ItemDefinition>();

      try {
        String location = specification.getLocation();
        URI uri = URI.createPlatformResourceURI(location, false);
        XSDResourceImpl resource = new XSDResourceImpl(uri);
        resource.load(Collections.emptyMap());

        XSDSchema schema = resource.getSchema();
        EList<XSDTypeDefinition> typeDefinitions = schema.getTypeDefinitions();
        for (XSDTypeDefinition typeDefinition : typeDefinitions) {
          ItemDefinition itemDefinition = createItemDefinition(specification, schema, typeDefinition);
          itemDefinitions.add(itemDefinition);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

      return itemDefinitions;
    }

    private ItemDefinition createItemDefinition(Import specification, XSDSchema schema, XSDTypeDefinition typeDefinition) {
      ItemDefinition itemDefinition = ModelHandler.create(specification.eResource(), ItemDefinition.class);

      // set structure ref
      String locationAsString = schema.getTargetNamespace() + "#" + typeDefinition.getName();
      StructureDefinition structDef = BptFactory.eINSTANCE.createStructureDefinition();
      structDef.setQname(locationAsString);
      ExtensionUtil.addExtension(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_StructureDefinition(), structDef);
      itemDefinition.setStructureRef(structDef);

      // extract extensions
      EList<XSDAnnotation> annotations = typeDefinition.getAnnotations();
      for (XSDAnnotation annotation : annotations) {
        System.out.println(annotation);
      }
      return itemDefinition;
    }

  }

}
