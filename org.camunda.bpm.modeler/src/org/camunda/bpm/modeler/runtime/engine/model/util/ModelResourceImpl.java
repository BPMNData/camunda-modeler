/*******************************************************************************
 * Copyright (c) 2011 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.camunda.bpm.modeler.runtime.engine.model.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.modeler.core.Activator;
import org.camunda.bpm.modeler.core.model.Bpmn2ModelerResourceImpl;
import org.camunda.bpm.modeler.core.preferences.Bpmn2Preferences;
import org.camunda.bpm.modeler.runtime.engine.ActivitiRuntimeExtension;
import org.camunda.bpm.modeler.runtime.engine.model.ModelPackage;
import org.camunda.bpm.modeler.runtime.engine.model.fox.FailedJobRetryTimeCycleType;
import org.camunda.bpm.modeler.runtime.engine.model.fox.FoxPackage;
import org.camunda.bpm.modeler.runtime.engine.util.DiagramExport;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.DocumentRoot;
import org.eclipse.bpmn2.Documentation;
import org.eclipse.bpmn2.Error;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.dd.dc.Bounds;
import org.eclipse.dd.dc.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLString;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.camunda.bpm.modeler.runtime.jboss.jbpm5.model.util.ModelResourceFactoryImpl
 * @generated NOT
 */
public class ModelResourceImpl extends Bpmn2ModelerResourceImpl {
	
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated NOT
	 */
	public ModelResourceImpl(URI uri) {
		super(uri);
	}

    /**
     * Override this method to hook in our own XmlHandler
     */
    @Override
    protected XMLLoad createXMLLoad() {
	  		
        return new XMLLoadImpl(createXMLHelper()) {
            @Override
            protected DefaultHandler makeDefaultHandler() {
                return new ModelXmlHandler(resource, helper, options);
            }
            
            
        };
    }

    @Override
	protected XMLSave createXMLSave() {
    	try {
    		if (isGenerateDiagramImage()) {
    			new DiagramExport(null).execute(null);
    		}
    	} catch (Exception e) {
    		Activator.logStatus(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Failed to generate diagram", e));
    	}
    	
		return new Bpmn2ModelerXMLSave(createXMLHelper()) {
			
			private boolean needTargetNamespace = true;
			
			@Override
			protected void saveTypeAttribute(EClass eClass) {
				// we skip this xsi:type attributes for activiti namespace,
				// because the schema is not know to activiti -> parser errors
				if (!eClass.getEPackage().getNsPrefix().equals("activiti")){
					super.saveTypeAttribute(eClass);
				}
			}
			
			@Override
			protected boolean shouldSaveFeature(EObject o, EStructuralFeature f) {
			  String featureName = f.getName();
			  if (featureName.contains("Set"))
			    System.out.print("> ");
        System.out.print("Saving " + " ("+ o.eClass().getName()+") -> "+featureName+"? ");
				if (f == ModelPackage.eINSTANCE.getExecutionListenerType_Event() ||
					f == ModelPackage.eINSTANCE.getTaskListenerType_Event()) {
					return true;
				}
				
				if (o instanceof Point) {
					return true;
				}
				
				if (o instanceof Bounds) {
					return true;
				}
				
//				if (o instanceof FormalExpression && f.getName().equals(Bpmn2Package.eINSTANCE.getFormalExpression_Body().getName())){
////				  System.out.println("false");
//					return false;
//				}
				
				if (o instanceof Documentation && featureName.equals(Bpmn2Package.eINSTANCE.getDocumentation_Text().getName())) {
//				  System.out.println("false");
					return false;
				}
				if (o instanceof FailedJobRetryTimeCycleType && featureName.equals(FoxPackage.eINSTANCE.getFailedJobRetryTimeCycleType_Text().getName())) {
//				  System.out.println("false");
					return false;
				}
				
				boolean shouldSaveFeature = super.shouldSaveFeature(o, f);
				System.out.println(shouldSaveFeature);
        return shouldSaveFeature;
			}
			
			
			@Override
			protected void init(XMLResource resource, Map<?, ?> options) {
				super.init(resource, options);
		        doc = new XMLString(Integer.MAX_VALUE, publicId, systemId, null) {
		        	@Override
		        	public void addAttribute(String name, String value) {
		        		if ("targetNamespace".equals(name))
		        			needTargetNamespace = false;
		        		else if (XSI_SCHEMA_LOCATION.equals(name)) {
		        			value = "http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd";
		        		}
		        		super.addAttribute(name, value);
		        	}
		        };
			}
			  
			@Override
			protected void addNamespaceDeclarations() {
				if (needTargetNamespace)
					doc.addAttribute("targetNamespace", ModelPackage.eNS_URI);
				super.addNamespaceDeclarations();
			}
		};
	}

	private boolean isGenerateDiagramImage() {
		return Bpmn2Preferences.getInstance().getBoolean(ActivitiRuntimeExtension.PREF_TOGGLE_DIAGRAM_GENERATION, true);
	}

	/**
     * We need extend the standard SAXXMLHandler to hook into the handling of attribute references
     * which may be either simple ID Strings or QNames. We'll search through all of the objects'
     * IDs first to find the one we're looking for. If not, we'll try a QName search.
     */
    protected static class ModelXmlHandler extends Bpmn2ModelerXmlHandler {
        Logger log = Logger.getLogger(getClass().getSimpleName());
        
        public ModelXmlHandler(XMLResource xmiResource, XMLHelper helper, Map<?, ?> options) {
            super(xmiResource, helper, options);
        }

        @Override
        protected void handleForwardReferences(boolean isEndDocument) {
          try {
            if (isEndDocument) {
              
              for (Iterator<InternalEObject> i = sameDocumentProxies.iterator(); i.hasNext(); ) {
                InternalEObject proxy = i.next();
                if (!documentRoot.eIsProxy()) {
                  Definitions def = (Definitions) documentRoot.eContents().get(0);
    
                  EObject resolved = EcoreUtil.resolve(proxy, def.eResource());
    
                  if (!resolved.eIsProxy()) {
                    continue;
                  }
                }
                
                if (proxy instanceof Error) {
                  
                  final Error newError = Bpmn2Factory.eINSTANCE.createError();
                  String id = proxy.eProxyURI().fragment();
                  newError.setId(id);
                  newError.setName(id);
                  newError.setErrorCode(id);
                  
                  TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(xmlResource);
                  
                  final DocumentRoot root = (DocumentRoot) xmlResource.getContents().get(0);
                  
                  domain.getCommandStack().execute(new RecordingCommand(domain) {
                    @Override
                    protected void doExecute() {
                      root.getDefinitions().getRootElements().add(0, newError);
                    }
                  });
                  
                }
                i.remove();
                EcoreUtil.delete(proxy, true);
              }
            }
          }catch (Exception e) {
            log.fine(e.getMessage());
          }

          super.handleForwardReferences(isEndDocument);
        }
        
        @Override
        protected void handleProxy(InternalEObject proxy, String uriLiteral) {
        	super.handleProxy(proxy, uriLiteral);
        }
        
		@SuppressWarnings("unchecked")
		@Override
		protected void processElement(String name, String prefix, String localName) {
			super.processElement(name, prefix, localName);
		}
		
		@Override
		protected EStructuralFeature getFeature(EObject object, String prefix,
				String name, boolean isElement) {
			return super.getFeature(object, prefix, name, isElement);
		}

		@Override
		protected String getXSIType() {
			if (isNamespaceAware)
				return attribs.getValue(ExtendedMetaData.XSI_URI,
						XMLResource.TYPE);
			String element = elements.peek();
			// If an parameter specifies multiple xsi:type data types, the last one wins.
			// NOTE: we must check for "type" in any namespace with the URI
			// "http://www.w3.org/2001/XMLSchema-instance"
			String value = null;
			int length = attribs.getLength();
			for (int i = 0; i < length; ++i) {
				attribs.getQName(i);
				String localpart= attribs.getLocalName(i);
				String prefix = null;
				int ci = localpart.lastIndexOf(':');
				if (ci>0) {
					prefix = localpart.substring(0, ci); 
					localpart = localpart.substring(ci+1);
				}
				if (TYPE.equals(localpart)) {
					String uri = helper.getNamespaceURI(prefix);
					if (XSI_URI.equals(uri)) {
						value = attribs.getValue(i);
					}
				}
			}
			
			if (element.contains("timeDuration")
					|| element.contains("timeDate")
					|| element.contains("timeCycle")) {
				String prefix = "";
				if (element.indexOf(":") != -1) {
					prefix = element.split(":")[0] + ":";
				}
				return prefix + "tFormalExpression";
			}
			
			return value;
		}
    }
} //ModelResourceImpl
