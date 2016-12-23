<link rel="shortcut icon" type="../../../images/png" href="../../../images/favicon.png">
# [![SUPERSEDE](images/SUPERSEDE-logo.png)](https://www.supersede.eu/) project: Integration Framework (IF) Client API
This library provides a number of proxies for dispatching messages to backend components of the SUPERSEDE platform instance deployed in the [Supersede Integration Server](http://supersede.es.atos.net/).

See deliverable D5.5 in [Supersede Portal](https://www.supersede.eu/) for more details about this framework, including its functional description, its architecture and its components.

##IF Client API Usage
In order to use IF client dependency, configure your IDE project using Gradle to use IF Client and other SUPERSEDE component dependencies, which are resolved through the SUPERSEDE Artifactory Repository

### Gradle Configuration
Add to your IDE project build.gradle file the Supersede Artifactory Repository, declared within the buildscript block

```sh
buildscript {
    repositories {
        mavenCentral()
	maven {
            url "${artifactory_contextUrl}/libs-snapshot"
            name = 'maven-supersede-snapshot'
	    credentials {
                username = "${artifactory_user}"
                password = "${artifactory_password}"
	    }
        }
	maven {
            url "${artifactory_contextUrl}/libs-release"
            name = 'maven-supersede-release'
	    credentials {
                username = "${artifactory_user}"
                password = "${artifactory_password}"
	    }
        }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.4.2.RELEASE")
	//Check for the latest version here: http://plugins.gradle.org/plugin/com.jfrog.artifactory
        classpath "org.jfrog.buildinfo:build-info-extractor-gradle:4+"
    }
}
```
And add them within the repositories block:

```sh
    add buildscript.repositories.getByName ("maven-supersede-snapshot")
    add buildscript.repositories.getByName ("maven-supersede-release")
```
Next, declare the IF Client dependency in the dependencies block, adding the following line:
```sh
    compile("eu.supersede.if:eu.supersede.if.api:0.3.0-SNAPSHOT"){changing = true} 
```
Then, 
Add as well the following to your build.gradle:

```sh
configurations.all {
        //Avoids conflict: SL4J Multiple bindings were found on the class path
        exclude group: "org.slf4j", module: "slf4j-log4j12"
        // check for updates every build
        resolutionStrategy.cacheChangingModulesFor 0, 'seconds'
        resolutionStrategy.cacheDynamicVersionsFor 0, 'seconds'
}
```
During building, invoke Gradle with:
```sh
gradle build --refresh-dependencies 
```

Finally, create a gradle.properties file in the project root, with this content:
```sh
artifactory_user=supersede
artifactory_password=<supersede_password>
artifactory_contextUrl=http://supersede.es.atos.net:10080/artifactory
```
Ask SUPERSEDE Contact Point for <supersede_password> 

### IF Client Usage

To send messages to another SUPERSEDE component, select the associated IF Client Proxy. All supported proxies are located in packages like eu.supersede.integration.api.<component_alias>.proxies, for instance:
eu.supersede.integration.replan.proxies or eu.supersede.integration.feedback.proxies.

Then, instantiate this proxy and use a concrete API method to send a specific message. If the method requires parameters, they can be created using the POJOs defined in the associate eu.supersede.integration.api.<component_alias>.types package. Object returned by the API method may be also an instance of a type defined within this package.


SUPERSEDE Integration Framework is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

Main contact: Jesús Gorroñogoitia <jesus.gorronogoitia@atos.net>

<center>![Project funded by the European Union](../../../images/european.union.logo.png)</center>
