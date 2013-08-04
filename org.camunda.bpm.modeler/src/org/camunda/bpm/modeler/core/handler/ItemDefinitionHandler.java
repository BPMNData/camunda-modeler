package org.camunda.bpm.modeler.core.handler;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.modeler.core.utils.ExtensionUtil;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.BptPackage;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.CorrelationInformation;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.MessageObject;
import org.camunda.bpm.modeler.runtime.engine.model.bpt.StructureDefinition;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

/**
 * Implements some utility methods for {@link ItemDefinition} objects.
 */
public class ItemDefinitionHandler {

  /**
   * Tells whether the object holds a {@link MessageObject} extension.
   */
  public static boolean isMessageObject(ItemDefinition itemDefinition) {
    return ExtensionUtil.getExtension(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_MessageObject()) != null;
  }

  /**
   * Returns a list of correlation attributes for this item definition as
   * defined by the {@link CorrelationInformation} extension.
   */
  public static List<String> getCorrelationAttributes(ItemDefinition itemDefinition) {
    List<String> attributes = new ArrayList<String>(2);
    List<Object> correlationInfos = ExtensionUtil.getExtensions(itemDefinition, BptPackage.eINSTANCE.getDocumentRoot_CorrelationInformation());
    for (Object o : correlationInfos) {
      CorrelationInformation correlationInfo = (CorrelationInformation) o;
      attributes.add(correlationInfo.getAttributeName());
    }
    return attributes;
  }

  /**
   * Returns a string that shall aid a user to identify this item definition.
   */
  public static String getInterpretableName(ItemDefinition itemDefinition) {
    if (itemDefinition == null)
      return "(none)";
    resolveStructureDefinitionProxy(itemDefinition, true);
    StructureDefinition structureRef = getExtensionStructureRef(itemDefinition);
    if (structureRef != null)
      return structureRef.getQname();
    return itemDefinition.getId();
  }

  /**
   * Returns a string that shall aid a user to identify this item definition and
   * recognize its correlation attributes.
   */
  public static String getCorrelationIdentifierName(ItemDefinition itemDefinition) {
    if (itemDefinition == null)
      return "(none)";
    String name = getInterpretableName(itemDefinition);
    List<String> correlationAttributes = getCorrelationAttributes(itemDefinition);
    StringBuilder sb = new StringBuilder();
    sb.append(name).append(".");
    if (correlationAttributes.size() > 1)
      sb.append("{");

    String separator = "";
    for (String attribute : correlationAttributes) {
      sb.append(separator).append(attribute);
      separator = ",";
    }

    if (correlationAttributes.size() > 1)
      sb.append("}");

    return sb.toString();
  }

  /**
   * It usually happens that the XML loader places a proxy for
   * {@link ItemDefinition#getStructureRef()} if this is the
   * {@link StructureDefinition} extension. So this method resolves this proxy
   * and sets the real object instead.
   */
  public static void resolveStructureDefinitionProxy(final ItemDefinition itemDefinition, boolean useTransaction) {
    Object structureRef = itemDefinition.getStructureRef();
    if (structureRef != null && structureRef instanceof InternalEObject) {
      final Resource eResource = itemDefinition.eResource();
      final URI proxyURI = ((InternalEObject) structureRef).eProxyURI();
      if (proxyURI != null) {
        if (useTransaction) {
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(itemDefinition);
          editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

            @Override
            protected void doExecute() {
              itemDefinition.setStructureRef((StructureDefinition) eResource.getEObject(proxyURI.toString()));
            }
          });
        } else {
          itemDefinition.setStructureRef((StructureDefinition) eResource.getEObject(proxyURI.toString()));
        }
      }
    }
  }

  /**
   * Returns the {@link ItemDefinition#getStructureRef()} if it is a
   * {@link StructureDefinition} object, or <code>null</code> otherwise.
   */
  public static StructureDefinition getExtensionStructureRef(ItemDefinition itemDefinition) {
    Object structureRef = itemDefinition.getStructureRef();
    if (structureRef instanceof StructureDefinition)
      return (StructureDefinition) structureRef;
    return null;
  }
}
