package org.camunda.bpm.modeler.ui.property.tabs.builder.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.camunda.bpm.modeler.ui.property.tabs.binding.change.EObjectChangeSupport;
import org.camunda.bpm.modeler.ui.property.tabs.binding.change.EObjectChangeSupport.ModelChangedEvent;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EObjectAttributeTableColumnDescriptor;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EObjectAttributeTableColumnDescriptor.EditingSupportProvider;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EditableTableDescriptor;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EditableTableDescriptor.CustomMenuItemDescriptor;
import org.camunda.bpm.modeler.ui.property.tabs.tables.EditableTableDescriptor.ElementFactory;
import org.camunda.bpm.modeler.ui.property.tabs.tables.TableColumnDescriptor;
import org.camunda.bpm.modeler.ui.property.tabs.util.Events;
import org.camunda.bpm.modeler.ui.property.tabs.util.Events.RowDeleted;
import org.camunda.bpm.modeler.ui.property.tabs.util.HelpText;
import org.camunda.bpm.modeler.ui.property.tabs.util.PropertyUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;

public class EObjectTableBuilder<T extends EObject> {

  protected GFPropertySection section;
  protected Composite parent;

  private ElementFactory<T> elementFactory;

  private AddedRowHandler<T> addHandler;

  private DeletedRowHandler<T> deleteHandler;
  private SelectedRowHandler<T> selectHandler;

  protected EStructuralFeature[] columnFeatures;
  private String[] columnLabels;
  private NotificationFilter changeFilter;

  private ContentProvider<T> contentProvider;
  private EditingSupportProvider editingSupportProvider;

  protected EObject model;

  protected Class<T> genericTypeCls;
  private List<CustomMenuItemDescriptor> customMenuItemDescriptors = new ArrayList<CustomMenuItemDescriptor>();

  public EObjectTableBuilder(GFPropertySection section, Composite parent, Class<T> genericTypeCls) {
    this.section = section;
    this.parent = parent;

    this.genericTypeCls = genericTypeCls;
  }

  public EObjectTableBuilder<T> deletedRowHandler(DeletedRowHandler<T> deleteHandler) {
    this.deleteHandler = deleteHandler;

    return this;
  }

  public EObjectTableBuilder<T> selectedRowHandler(SelectedRowHandler<T> selectHandler) {
    this.selectHandler = selectHandler;

    return this;
  }

  public EObjectTableBuilder<T> addedRowHandler(AddedRowHandler<T> addHandler) {
    this.addHandler = addHandler;

    return this;
  }

  public EObjectTableBuilder<T> elementFactory(ElementFactory<T> elementFactory) {
    this.elementFactory = elementFactory;
    return this;
  }

  public EObjectTableBuilder<T> columnFeatures(EStructuralFeature... columnFeatures) {
    this.columnFeatures = columnFeatures;

    return this;
  }

  public EObjectTableBuilder<T> withCustomMenuItems(CustomMenuItemDescriptor... descriptors) {
    this.customMenuItemDescriptors.addAll(Arrays.asList(descriptors));
    return this;
  }

  public EObjectTableBuilder<T> columnLabels(String... columnLabels) {
    this.columnLabels = columnLabels;

    return this;
  }

  public EObjectTableBuilder<T> model(EObject model) {
    this.model = model;

    return this;
  }

  public EObjectTableBuilder<T> editingSupportProvider(EditingSupportProvider editingSupportProvider) {
    this.editingSupportProvider = editingSupportProvider;

    return this;
  }

  protected EditableTableDescriptor<T> createTableDescriptor() {
    EditableTableDescriptor<T> tableDescriptor = new EditableTableDescriptor<T>();
    tableDescriptor.setElementFactory(elementFactory);

    return tableDescriptor;
  }

  protected EObjectAttributeTableColumnDescriptor<T> createAttributeTableColumnDescriptor(EStructuralFeature columnFeature, String columnLabel, int weight) {
    EObjectAttributeTableColumnDescriptor<T> columnDescriptor = new EObjectAttributeTableColumnDescriptor<T>(columnFeature, columnLabel, 30);
    columnDescriptor.setEditingSupportProvider(editingSupportProvider);

    return columnDescriptor;
  }

  public TableViewer build() {

    if (model == null) {
      throw new IllegalArgumentException("Model is null");
    }

    if (columnFeatures == null) {
      throw new IllegalArgumentException("Column features are null");
    }

    if (columnLabels == null) {
      throw new IllegalArgumentException("ColumnLabels are null");
    }

    // table descriptor
    EditableTableDescriptor<T> tableDescriptor = createTableDescriptor();

    List<TableColumnDescriptor> columns = new ArrayList<TableColumnDescriptor>();

    for (int i = 0; i < columnFeatures.length; i++) {
      EStructuralFeature columnFeature = columnFeatures[i];
      String columnLabel = columnLabels[i];

      EObjectAttributeTableColumnDescriptor<T> descriptor = createAttributeTableColumnDescriptor(columnFeature, columnLabel, 30);

      columns.add(descriptor);
    }

    tableDescriptor.setColumns(columns);
    
    for (CustomMenuItemDescriptor descriptor : customMenuItemDescriptors) {
      tableDescriptor.addCustomMenuItem(descriptor);
    }

    // create composite
    Composite tableComposite = createTableComposite();

    // create viewer
    TableViewer tableViewer = tableDescriptor.createTableViewer(tableComposite);

    // configure viewer
    configureViewer(tableViewer);

    // establish the binding between model and view
    establishModelViewBinding(model, tableViewer);

    // update viewer contents
    updateViewerContents(tableViewer);

    return tableViewer;
  }

  private void establishModelViewBinding(EObject model, final TableViewer tableViewer) {

    Table table = tableViewer.getTable();

    EObjectChangeSupport changeSupport = new EObjectChangeSupport(model, table);
    changeSupport.setFilter(changeFilter);
    changeSupport.register();

    table.addListener(Events.ROW_DELETED, new Listener() {

      @Override
      public void handleEvent(Event e) {
        Events.RowDeleted<T> event = (RowDeleted<T>) e;

        T removedElement = event.getRemovedElement();

        if (deleteHandler != null) {
          deleteHandler.rowDeleted(removedElement);
        }
      }
    });

    tableViewer.addPostSelectionChangedListener(new ISelectionChangedListener() {
      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        T element = (T) selection.getFirstElement();

        if (selectHandler != null) {
          selectHandler.rowSelected(element);
        }
      }
    });

    table.addListener(Events.MODEL_CHANGED, new Listener() {

      @Override
      public void handleEvent(Event e) {
        ModelChangedEvent event = (ModelChangedEvent) e;
        updateViewerContents(tableViewer);
      }
    });
  }

  protected void updateViewerContents(TableViewer viewer) {
    List<T> contents = contentProvider.getContents();

    viewer.setInput(contents);
  }

  /**
   * Can be overridden by subclasses to perform a post construct configuration
   * of the selected viewer.
   * 
   * @param tableViewer
   */
  protected void configureViewer(TableViewer tableViewer) {

  }

  public EObjectTableBuilder<T> changeFilter(NotificationFilter changeFilter) {
    this.changeFilter = changeFilter;

    return this;
  }

  public EObjectTableBuilder<T> contentProvider(ContentProvider<T> contentProvider) {
    this.contentProvider = contentProvider;
    return this;
  }

  protected Composite createTableComposite() {

    Composite tableComposite = new Composite(parent, SWT.NONE);
    FormData tableCompositeFormData = PropertyUtil.getStandardLayout();
    tableCompositeFormData.height = 100;

    tableComposite.setLayoutData(tableCompositeFormData);

    PropertyUtil.attachNote(tableComposite, HelpText.TABLE_HELP);

    return tableComposite;
  }

  /**
   * Deletion handler
   * 
   * @author nico.rehwaldt
   * 
   * @param <T>
   */
  public static interface DeletedRowHandler<T> {

    public void rowDeleted(T element);
  }

  /**
   * A {@link DeletedRowHandler} that performs the deletion within an EMF
   * transaction.
   * 
   * @author Sebastian
   * 
   * @param <T>
   */
  public static abstract class TransactionalDeletedRowHandler<T> implements DeletedRowHandler<T> {

    private EObject domainObject;

    /**
     * @param domainObject
     *          representative object for the transaction domain
     */
    public TransactionalDeletedRowHandler(EObject domainObject) {
      this.domainObject = domainObject;
    }

    @Override
    public void rowDeleted(final T element) {
      TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(domainObject);
      domain.getCommandStack().execute(new RecordingCommand(domain) {

        @Override
        protected void doExecute() {
          transactionalRowDeleted(element);
        }
      });
    }

    /** Handles the deletion of a row within a transaction. */
    protected abstract void transactionalRowDeleted(T element);

  }

  /**
   * Selection handler
   * 
   * @author nico.rehwaldt
   * 
   * @param <T>
   */
  public static interface SelectedRowHandler<T> {

    public void rowSelected(T element);
  }

  /**
   * Addition handler
   * 
   * @author nico.rehwaldt
   * 
   * @param <T>
   */
  public static interface AddedRowHandler<T> {

    public void rowAdded(T element);
  }

  public static interface ContentProvider<T> {

    /**
     * Returns the table contents
     * 
     * @return
     */
    public List<T> getContents();
  }
}
