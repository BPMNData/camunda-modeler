BPMN Data Extensions
====================

_If you are interested in contributing or simply building the sources yourself, please check the updated [contribution guide](https://github.com/BPMNData/camunda-modeler/blob/bpmn_data/CONTRIBUTING.md)._

This document describes how to use the BPMN Data extensions in the modeler.
For this purpose, three artifacts are considered:

* the data models,
* the schema mapping,
* and the process model.

An eclipse update site can be found [here](https://www.dropbox.com/sh/1zn3en8hje92xrk/Rf8hE0XeF-). Please install the camunda Modeler and the Schema Mapping Modeler.

You can also find a demo video of the modeler there, but please consider, that this demo does not show all the points covered in this document.

Data Models
-----------

![Data model](https://raw.github.com/BPMNData/camunda-modeler/bpmn_data/documentation/images/data-model.png)

The modeler does not ship with an editor for data model. However, we designated XML Schema as description language for the data models and there is already an XSD editor in eclipe. Follow this workflow to create your data models:

1. For the local and global data model, create an .xsd file each.
2. Build complex types in your schema that represent the classes of your data models (nested classes are not supported).
3. In the global data model, you can add the following ```appinfo``` annotations to your classes (see the example):
 * declare the bpmndata namespace at first: ```xmlns:bpmndata="http://bpt.hpi.uni-potsdam.de/bpmn-data/"```
 * ```<bpmndata:message />``` to tell that a class can be payload of a message
 * ```<bpmndata:correlationIdentifier attributeName=... />``` to designate a correlation identifier attribute in a global class; use this annotations multiple times within one class for complex correlation identifiers

Example for a global model:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<schema xmlns="http://www.w3.org/2001/XMLSchema" xmlns:tns="http://bpt.hpi.uni-potsdam.de/data"
	elementFormDefault="qualified" targetNamespace="http://bpt.hpi.uni-potsdam.de/data"
	xmlns:bpmndata="http://bpt.hpi.uni-potsdam.de/bpmn-data/">

	<complexType name="Global_Request">
		<annotation>
			<appinfo>
				<bpmndata:correlationIdentifier
					attributeName="request_id" />
				<bpmndata:message />
			</appinfo>
		</annotation>
		<sequence>
			<element name="request_id" type="string" />
			<element name="departure" type="string" />
			<element name="destination" type="string" />
			<element name="start_date" type="string" />
			<element name="return_date" type="string" />
		</sequence>
	</complexType>

	<complexType name="Global_Offer">
		<annotation>
			<appinfo>
				<bpmndata:message />
			</appinfo>
		</annotation>
		<sequence>
			<element name="offer_id" type="string" />
			<element name="airline" type="string" />
			<element name="inboundFlightNumber" type="string" />
			<element name="outboundFlightNumber" type="string" />
			<element name="price" type="double" />
		</sequence>
	</complexType>

</schema>
```

Schema Mapping
--------------

![Schema mapping](https://raw.github.com/BPMNData/camunda-modeler/bpmn_data/documentation/images/schema-mapping.png)


The modeler ships with a very simple schema mapping editor. In a valid schema mapping of this kind, all the attributes of a global class must correspond to attributes from exactly one local class. To create a schema mapping, do the following steps:

1. Open the _File_ menu > _New_ > _Other_ > the _New_ wizard appears.
2. In the filter textbox, type "schemamapping", select _Schemamapping Model_, and press _Next_.
3. Choose a destination folder and a file name for the schema mapping and press _Finish_, the editor opens for the new file.
4. Right-click on the _Schema Mapping_ entry in the editor > _New child_ > _Class mapping_, a new class mapping is created.
5. In the _Properties_ view, type in the name of a global class and the name of the local class, which shall correspond to this global class. Do not use the XML namespaces.
6. Right-click on the _Class Mapping_ entry > _New child_ > _Attribute mapping_, a new attribute mapping is created.
7. In the _Properties_ view, type in the name of an attribute of the global class and the name of the attribute of the local class, which shall correspond to this global attribute.
8. Repeat 6. for every attribute in the global class.
9. Repeat 4.-8. for every class in the global model.

Process Model
-------------

![Process model](https://raw.github.com/BPMNData/camunda-modeler/bpmn_data/documentation/images/bpmndata-shot.png)

Creating the process model is the most complex part. This document does not describe the whole functionality of the camunda Modeler, but only points out the import aspects with respect to the BPMN Data extensions.

_Note that the properties of the currently selected element in the Modeler are found in the Properties view._

### Preparation

1. Create a _BPMN 2.0 Diagaram_.
2. Click on the empty diagram pane, select the _Definitions_ tab in the _Properties_ view.
3. In the _Imports_ table, right-click, select _Add_, and type the path of one of your data models, e.g. _/my_project/data/local.xsd_, then right-click the entry, select _Import_, item definitions according to your data model will be created. Repeat this for every data model.
4. In the same tab, specify the _Schema Mapping Location_, e.g. _/my_project/data/local-global.schemamapping_.

### BPMN Data

1. Each process and subprocess must provide a case object, which can be set in the _BPMN Data Scope_ tab.
2. Cardinalities and conditions for data associations are editable in the _General_ tab.
3. Primary key, foreign keys, and operation type of data objects can be set in the _BPMN Data Keys_ tab.
4. Furthermore, we added controls for the data state and multiplicty of data objects in the _General_ tab.

### Send and Receive Tasks

1. When the task has a message flow that is associated with a message, then the corresponding data objects (according to schema mapping) have to be provided to this task. For send tasks, use data input associations, for receive tasks, use data output associations.
2. If not done yet, you can specify the endpoint of addressed participant in terms of a URL by selecting this participant and providing the _End-Point Address_ in the _General_ tab. This way, messages will be sent to the correct address when executing this model.
3. If a receive task shall instantiate its surrounding process, make sure to check its _Instantiate_ property in the _General_ tab.

### Message Definition

1. When creating a message flow, a new message is created, that is associated to this message flow. When a different message should be associated to it, it can be drag-and-dropped onto the message flow. You can see the currently associated message for a message flow in its _General_ tab.
2. The global ID (according to BPMN Data) of the message corresponds to the message name, which can be edited in the _General_ tab.
3. In the _BPMN Data Message_ tab, the payload object and correlation identifiers of messages can be established. This only works if a valid global data model has been imported beforehand, as possible payload objects and correlation identifiers are automatically derived from the imported item definitions. Moreover, if the payload class contains a correlation identifier, it is automatically added to the message. An arbitrary second correlation identifier can be added. In principle, more correlation identifiers could be added, but this interface should be sufficient and comfortable.

### Compiling the Process Model

1. Before compiling the process model, ensure:
 * The diagram is a collaboration diagram.
 * There is exactly one process that is executable.
 * The other participant pools are empty (they represent black box pools).
 * The above mentioned steps have been taken correctly.
 * The process model is saved.
2. In the package explorer, right-click on the diagram file > _BPMNData_ > _Compile_. If your model is correct, a new diagram file, named like <my-diagram>.compiled.bpmn, should appear in the same folder. This file is enriched with technical data and the BPMN extensions are, as far as possible, mapped to standard BPMN elements, e.g. correlation keys and data transformation. If this step did not work, check the _Error Log_ view, it might help to reveal modeling errors.
