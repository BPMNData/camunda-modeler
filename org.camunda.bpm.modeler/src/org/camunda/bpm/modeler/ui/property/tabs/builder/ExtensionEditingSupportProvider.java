package org.camunda.bpm.modeler.ui.property.tabs.builder;

import org.camunda.bpm.modeler.ui.property.tabs.tables.EObjectAttributeEditingSupport;
import org.camunda.bpm.modeler.ui.property.tabs.tables.ExtensionEditingSupport;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

public class ExtensionEditingSupportProvider extends
		DefaultEditingSupportProvider {
	
	private EObject bo;
	
	public ExtensionEditingSupportProvider(EObject model) {
		this.bo = model;
	}

	@Override
	public EditingSupport getEditingSupport(final TableViewer viewer, EStructuralFeature feature) {

		final EClassifier eType = feature.getEType();

		String uri = feature.eResource().getURI().toString();
		
		final EFactory factory = EPackage.Registry.INSTANCE.getEFactory(uri);
		
		if (eType instanceof EEnum) {
			
			final EEnum enumeration = (EEnum) eType;
			final EList<EEnumLiteral> literals = enumeration.getELiterals();
			
			return new EObjectAttributeEditingSupport<EObject>(viewer, feature) {

				@Override
				protected CellEditor getCellEditor(Object element) {
					DropDownListCellEditor<?> cellEditor = new DropDownListCellEditor<EEnumLiteral>(viewer.getTable(), literals);
					return cellEditor;
				}

				@Override
				protected Object toEValue(Object value) {
					if (value instanceof String) {
						return factory.createFromString((EEnum) eType, (String) value);
					} else {
						return value;
					}
				}
			};
		} else
		
		if (eType instanceof EDataType) {
			if (!"String".equals(eType.getName())) {
				return new EObjectAttributeEditingSupport<EObject>(viewer, feature) {
					@Override
					protected Object toEValue(Object value) {
						if (value instanceof String) {
							if ((((String) value).trim()).isEmpty()) {
								return null;
							}
							
							return factory.createFromString((EDataType) eType, (String) value);
						} else {
							return value;
						}
					}
				};
			}
		}
		
		return new ExtensionEditingSupport(viewer, feature, bo);
	}
}
