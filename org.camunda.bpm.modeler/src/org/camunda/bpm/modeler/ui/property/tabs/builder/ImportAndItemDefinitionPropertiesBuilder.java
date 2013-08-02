package org.camunda.bpm.modeler.ui.property.tabs.builder;

import java.util.List;

import org.camunda.bpm.modeler.core.utils.ImportUtil;
import org.camunda.bpm.modeler.core.utils.ImportUtil.ImportException;
import org.camunda.bpm.modeler.core.utils.ModelUtil;
import org.camunda.bpm.modeler.ui.change.filter.FeatureChangeFilter;
import org.camunda.bpm.modeler.ui.change.filter.NestedFeatureChangeFilter;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.ContentProvider;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.DeletedRowHandler;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EObjectTableBuilder.TransactionalDeletedRowHandler;
import org.camunda.bpm.modeler.ui.property.tabs.builder.table.EditableEObjectTableBuilder;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EditableTableDescriptor.CustomMenuItemDescriptor;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EditableTableDescriptor.ElementFactory;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EditableTableDescriptor.TransactionalElementFactory;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.Import;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.ItemKind;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;

/**
 * Builds the property panel that gives access to the primary key etc. of a data
 * object.
 */
public class ImportAndItemDefinitionPropertiesBuilder extends AbstractPropertiesBuilder<Definitions> {

  private static final EStructuralFeature IMPORTS_FEATURE = Bpmn2Package.eINSTANCE.getDefinitions_Imports();
  private static final String[] IMPORT_TABLE_HEADERS = { "Location", "Type", "Namespace" };
  private static final EStructuralFeature[] IMPORT_FEATURES = { Bpmn2Package.eINSTANCE.getImport_Location(), Bpmn2Package.eINSTANCE.getImport_ImportType(),
      Bpmn2Package.eINSTANCE.getImport_Namespace() };

  private static final EStructuralFeature ITEM_DEFINITONS_FEATURE = Bpmn2Package.eINSTANCE.getDefinitions_RootElements();
  private static final String[] ITEM_DEFINITONS_TABLE_HEADERS = { "structure reference", "is collection", "kind" };
  private static final EStructuralFeature[] ITEM_DEFINITONS_FEATURES = { Bpmn2Package.eINSTANCE.getItemDefinition_StructureRef(),
      Bpmn2Package.eINSTANCE.getItemDefinition_IsCollection(), Bpmn2Package.eINSTANCE.getItemDefinition_ItemKind() };

  public ImportAndItemDefinitionPropertiesBuilder(Composite parent, GFPropertySection section, Definitions bo) {
    super(parent, section, bo);
  }

  @Override
  public void create() {
    createImportsTable();
    createItemDefinitionsTable();
  }

  private void createImportsTable() {
    ElementFactory<Import> factory = new TransactionalElementFactory<Import>(bo) {

      @Override
      protected Import doCreate() {
        Import newImport = Bpmn2Factory.eINSTANCE.createImport();
        newImport.setImportType(ImportUtil.XSD_NAMESPACE);
        return newImport;
      }

      @Override
      protected void postCreate(Import object) {
        bo.getImports().add(object);
        try {
          ImportUtil.loadItemDefinitions(object);
        } catch (ImportException e) {
          e.printStackTrace();
        }
      }
    };

    ContentProvider<Import> contentProvider = new ContentProvider<Import>() {

      @Override
      public List<Import> getContents() {
        return bo.getImports();
      }
    };

    DeletedRowHandler<Import> deleteHandler = new TransactionalDeletedRowHandler<Import>(bo) {
      @Override
      protected void transactionalRowDeleted(Import element) {
        List<Import> imports = bo.getImports();
        imports.remove(element);
      }
    };

    CustomMenuItemDescriptor executeMenuItemDescriptor = new CustomMenuItemDescriptor() {

      @Override
      public String getText() {
        return "Import Item Definitions";
      }

      public Listener getSelectionListener(final Table table, final TableViewer viewer) {
        return new Listener() {

          @Override
          public void handleEvent(Event event) {
            IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
            if (!selection.isEmpty()) {
              Object element = selection.getFirstElement();
              if (element != null && element instanceof Import) {
                Import imp = (Import) element;
                ImportUtil.importItemDefinitions(imp, bo);
              }
            }
          }

        };
      }
    };

    createMappingsTable(section, parent, Import.class, "Imports", IMPORTS_FEATURE, IMPORT_FEATURES, IMPORT_TABLE_HEADERS, factory, contentProvider,
        deleteHandler, executeMenuItemDescriptor);
  }

  private void createItemDefinitionsTable() {
    ElementFactory<ItemDefinition> factory = new TransactionalElementFactory<ItemDefinition>(bo) {

      @Override
      protected ItemDefinition doCreate() {
        ItemDefinition itemDefinition = Bpmn2Factory.eINSTANCE.createItemDefinition();
        itemDefinition.setIsCollection(false);
        itemDefinition.setItemKind(ItemKind.INFORMATION);
        ModelUtil.setID(itemDefinition);
        return itemDefinition;
      }

      @Override
      protected void postCreate(ItemDefinition object) {
        bo.getRootElements().add(object);
      }
    };

    ContentProvider<ItemDefinition> contentProvider = new ContentProvider<ItemDefinition>() {

      @Override
      public List<ItemDefinition> getContents() {
        return ModelUtil.getAllRootElements(bo, ItemDefinition.class);
      }
    };

    DeletedRowHandler<ItemDefinition> deleteHandler = new TransactionalDeletedRowHandler<ItemDefinition>(bo) {
      @Override
      protected void transactionalRowDeleted(ItemDefinition element) {
        List<RootElement> rootElements = bo.getRootElements();
        rootElements.remove(element);
      }
    };

    createMappingsTable(section, parent, ItemDefinition.class, "Item Definitions", ITEM_DEFINITONS_FEATURE, ITEM_DEFINITONS_FEATURES,
        ITEM_DEFINITONS_TABLE_HEADERS, factory, contentProvider, deleteHandler);
  }

  protected <T extends EObject> void createMappingsTable(GFPropertySection section, Composite parent, final Class<T> typeCls, String label,
      final EStructuralFeature feature, EStructuralFeature[] columnFeatures, String[] columnLabels, ElementFactory<T> elementFactory,
      ContentProvider<T> contentProvider, DeletedRowHandler<T> deleteHandler, CustomMenuItemDescriptor... customMenuItemDescriptors) {

    Composite composite = PropertyUtil.createStandardComposite(section, parent);

    EditableEObjectTableBuilder<T> builder = new EditableEObjectTableBuilder<T>(section, composite, typeCls);
    builder.elementFactory(elementFactory).contentProvider(contentProvider).columnFeatures(columnFeatures).columnLabels(columnLabels)
        .deletedRowHandler(deleteHandler).model(bo).changeFilter(new NestedFeatureChangeFilter(bo, feature).or(new FeatureChangeFilter(bo, feature)))
        .withCustomMenuItems(customMenuItemDescriptors);
    final TableViewer viewer = builder.build();

    final Composite tableComposite = viewer.getTable().getParent();
    PropertyUtil.createLabel(section, composite, label, tableComposite);
  }

  protected void transactionalRemoveMapping(final EObject element, final EStructuralFeature feature) {
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
    editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

      @Override
      protected void doExecute() {
        @SuppressWarnings("unchecked")
        EList<EObject> list = (EList<EObject>) bo.eGet(feature);

        list.remove(element);
      }
    });
  }

}
