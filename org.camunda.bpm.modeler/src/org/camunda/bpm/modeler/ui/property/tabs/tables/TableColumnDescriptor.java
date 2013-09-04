package org.camunda.bpm.modeler.ui.property.tabs.tables;

import org.eclipse.jface.layout.fix.TableColumnLayout2;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.TableColumn;

public class TableColumnDescriptor {

  private String title;
  private int weight;
  private ColumnLabelProvider labelProvider;

  public TableColumnDescriptor(String title, int weight, ColumnLabelProvider labelProvider) {
    this.title = title;
    this.weight = weight;
    this.labelProvider = labelProvider;
  }

  public TableColumnDescriptor() {
    this.title = null;
    this.weight = 33;
  }

  public EditingSupport getEditingSupport(TableViewer viewer) {
    return null;
  }

  /**
   * Return the previously set column provider or a {@link SimpleLabelProvider} as default.
   */
  public ColumnLabelProvider getColumnLabelProvider() {
    // BPMN Data addition
    if (this.labelProvider == null)
      return getDefaultColumnLabelProvider();
    return this.labelProvider;
  }

  protected ColumnLabelProvider getDefaultColumnLabelProvider() {
    return new SimpleLabelProvider();
  }

  /**
   * Configure the specified viewer
   * 
   * @param viewerColumn
   * @param layout
   * @param columnIndex
   */
  public void configureViewer(TableViewer tableViewer, TableViewerColumn viewerColumn, TableColumnLayout2 layout) {
    viewerColumn.setLabelProvider(getColumnLabelProvider());
    viewerColumn.setEditingSupport(getEditingSupport(tableViewer));
    viewerColumn.setLabelProvider(getColumnLabelProvider());

    configure(viewerColumn.getColumn(), layout);
  }

  /**
   * Configures the underlaying column
   * 
   * @param column
   * @param layout
   */
  public void configure(TableColumn column, TableColumnLayout2 layout) {
    if (title != null) {
      column.setText(title);
    }

    layout.setColumnData(column, new ColumnWeightData(weight, true));
  }
}