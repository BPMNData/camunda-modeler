How to contribute
=================

* Fork the project
* [Setup the development environment](#development-setup)
* [Inspect the project structure](#project-structure)
* Write some code
* Submit a pull request

Development Setup
-----------------

* Checkout the `bpmndata` branch
* Make sure you have the `m2eclipse` plugin installed in your Eclipse
* Import sources into Eclipse Indigo or Juno via `Import -> Existing maven projects`
* Resolve the [project dependencies](#development-dependencies)
* Examine the sources
    * `org.camunda.bpm.modeler` contains the modeler
    * `org.camunda.bpm.modeler.tests` contains the modeler test suite
    * for the BPMN Data changes, check commits since d3a915d0861f68553f9a7bd36e373c0be8ce7422
* Run / Test
    * Start the Modeler from `org.camunda.bpm.modeler` via `Run As -> Eclipse Application`
    * Run the test suite in `org.camunda.bpm.modeler.tests` via `Run As -> JUnit Plugin-Tests`
* Build the project
       * run `mvn clean install` on `org.camunda.bpm.modeler.parent`
       * find the eclipse update site in `org.camunda.bpm.modeler.updatesite.feature/target/site_assembly.zip`

### Project Dependencies

The following shows a screenshot of an Eclipse Indigo installation with the required plugins installed.
Highlighted are plugins which need to be installed in order to resolve add dependencies. 

![Development Requirements](https://raw.github.com/camunda/camunda-modeler/develop/documentation/images/development-requirements.png)

To avoid any problems install the plugins in the following order:
1. EMF plugins
2. Graphiti plugin
3. BPMN2 plugin
4. Eclipse plugins
5. Maven plugin

The Tycho plugin will be installed automatically.

### Versions and Update Sites

* __Graphiti__ 0.9.0 http://archive.eclipse.org/graphiti/updates/0.9.0
* __BPMN 2.0 Meta-Model__ 0.7.x http://download.eclipse.org/modeling/mdt/bpmn2/updates/milestones/S20130423/
    * Sources [via git](git://git.eclipse.org/gitroot/bpmn2) + workspace import

Project Structure
-----------------------

    + org.camunda.bpm.modeler -> modeler runtime including BPMN Data extensions
    + org.camunda.bpm.modeler.tests -> modeler runtime tests
    + org.camunda.bpm.modeler.tests.functional -> functional GUI tests (jubula)
    + de.unipotsdam.hpi.bpmndata.schemamapping.* -> schema mapping meta-model and editor
    



[1]: https://github.com/camunda/camunda-modeler
