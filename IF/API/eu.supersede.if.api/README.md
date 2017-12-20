<link rel="shortcut icon" type="../../../images/png" href="../../../images/favicon.png">
# Integration Framework (IF) Client API
This library provides a number of proxies for dispatching messages to backend components of the SUPERSEDE platform instance deployed in the [Supersede Integration Server](http://supersede.es.atos.net:8080/).

See deliverable D5.5 in [Supersede Portal](https://www.supersede.eu/) for more details about this framework, including its functional description, its architecture and its components.

## IF Client API Usage
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
Next, declare the IF Client dependencies in the dependencies block, adding the following line:
```sh
    compile("eu.supersede.if:eu.supersede.if.api:0.3.0-SNAPSHOT"){changing = true} 
    compile (group: 'eu.supersede.feedback_gathering', name: 'feedback_library', version: '0.0.1-SNAPSHOT')
    compile(group: 'org.wso2.andes.wso2', name: 'andes-client', version: '3.1.1')
    compile(group: 'org.apache.geronimo.specs.wso2', name: 'geronimo-jms_1.1_spec', version: '1.1.0.wso2v1')
    compile(group: 'org.wso2.carbon', name: 'org.wso2.carbon.logging', version: '4.4.1')
    compile(group: 'org.wso2.securevault', name: 'org.wso2.securevault', version: '1.0.0-wso2v2')
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
During the building of your component, invoke Gradle with --refresh-dependencies, so the latest snapshot of IF library is retrieved from the SUPERSEDE Artifactory repository:
```sh
gradle build --refresh-dependencies 
```

Finally, create a gradle.properties file in the project root, with this content that configures the access to SUPERSEDE Artifactory:
```sh
artifactory_user=supersede
artifactory_password=[[supersede_password]]
artifactory_contextUrl=http://supersede.es.atos.net:10080/artifactory
```
Ask SUPERSEDE Contact Point for [[supersede_password]] 

### Maven Configuration
Add to your pom.xml file the Supersede Artifactory repositories in repositories and pluginRepositories configuration

```sh
  <repositories>
    <repository>
        <id>central</id>
        <url>http://supersede.es.atos.net:10080/artifactory/libs-release</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
    <repository>
        <id>snapshots</id>
        <url>http://supersede.es.atos.net:10080/artifactory/libs-snapshot</url>
        <releases>
            <enabled>false</enabled>
        </releases>
    </repository>
  </repositories>
  <pluginRepositories>
    <pluginRepository>
        <id>central</id>
        <url>http://supersede.es.atos.net:10080/artifactory/plugins-release</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </pluginRepository>
    <pluginRepository>
        <id>snapshots</id>
        <url>http://supersede.es.atos.net:10080/artifactory/plugins-snapshot</url>
        <releases>
            <enabled>false</enabled>
        </releases>
    </pluginRepository>
</pluginRepositories>
```

Then, add to pom.xml the IF dependencies
```sh
  <dependencies>
     <dependency>
    	<groupId>eu.supersede.if</groupId>
    	<artifactId>eu.supersede.if.api</artifactId>
    	<version>0.3.0-SNAPSHOT</version>
	<exclusions>
              <exclusion>
                <groupId>org.slf4j</groupId>
                <artifactId>slf4j-log4j12</artifactId>
              </exclusion>
        </exclusions>
     </dependency>
     <dependency>
    	<groupId>junit</groupId>
    	<artifactId>junit</artifactId>
    	<version>4.12</version>
     </dependency>
     <dependency>
    	<groupId>javax.jms</groupId>
    	<artifactId>jms</artifactId>
    	<version>1.1</version>
     </dependency>
     <dependency>
    	<groupId>eu.supersede.feedback_gathering</groupId>
    	<artifactId>feedback_library</artifactId>
    	<version>0.0.1-SNAPSHOT</version>
     </dependency>
     <dependency>
    	<groupId>eu.supersede.feedback_gathering</groupId>
    	<artifactId>feedback_library</artifactId>
    	<version>0.0.1-SNAPSHOT</version>
     </dependency>
     <dependency>
    	<groupId>org.apache.geronimo.specs.wso2</groupId>
    	<artifactId>geronimo-jms_1.1_spec</artifactId>
    	<version>1.1.0.wso2v1</version>
     </dependency>
     <dependency>
    	<groupId>org.wso2.andes.wso2</groupId>
    	<artifactId>andes-client</artifactId>
    	<version>3.1.1</version>
     </dependency>
     <dependency>
    	<groupId>org.wso2.carbon</groupId>
    	<artifactId>org.wso2.carbon.logging</artifactId>
   		<version>4.4.1</version>
     </dependency>
     <dependency>
    	<groupId>org.wso2.securevault</groupId>
    	<artifactId>org.wso2.securevault</artifactId>
    	<version>1.0.0-wso2v2</version>
     </dependency>
  </dependencies>
```

### IF Client Usage

To send messages to another SUPERSEDE component, select the associated IF Client Proxy. All supported proxies are located in packages like eu.supersede.integration.api.[[component_alias]].proxies, for instance:
```sh
eu.supersede.integration.replan.proxies or eu.supersede.integration.feedback.proxies.
```

Then, instantiate this proxy and use a concrete API method to send a specific message. If the method requires parameters, they can be created using the POJOs defined in the associate eu.supersede.integration.api.<component_alias>.types package. Object returned by the API method may be also an instance of a type defined within this package.

Next listing shows a code snippet for FeedbackOrchestratorProxyTest, showing how to instantiate this proxy and how to send a message to the Feedback Orchestrator Service, requesting it to insert a new feedback mechanism into a configuration identified by id. FeedbackMechanism type, defined within the proxy types package simplifies the creation of message payloads.

```sh
public class FeedbackOrchestratorProxyTest {
	private FeedbackOrchestratorProxy<?, ?> proxy;
	private String token;
	
    @Before
    public void setup() throws Exception {
     	String password = "password";
    	token = proxy.authenticate(user, password);
    }

    @Test
    public void testCreateFeedbackMechanismInConfigurationInApplication() throws Exception{
    	FeedbackMechanism fm = createFeedbackMechanism();
    	FeedbackMechanism result = proxy.createFeedbackMechanismInConfigurationInApplication(fm, configurationId, applicationId, token);
    	Assert.notNull(result);
    }
```

Next table collects the SUPERSEDE Platform backend components supported by the IF Client API and their associated proxies:

SUPERSEDE Component | Proxy
------------------- | -----
Dynamic Adaptation Adapter | eu.supersede.integration.api.adaptation.proxies.AdapterProxy.java
Analysis DataProvider | eu.supersede.integration.api.analysis.proxies.DataProviderProxy.java
Frontend DataStorage | eu.supersede.integration.api.datastore.proxies.FEDataStoreProxy.java
Dynamic Adaptation DM Optimizer | eu.supersede.integration.api.dm.proxies.DMOptimizerProxy.java
Decision Making System | eu.supersede.integration.api.dm.proxies.DecisionMakingSystemProxy.java
Feedback Gathering Orchestrator | eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy.java
Feedback Gathering Repository | eu.supersede.integration.api.feedback.proxies.FeedbackRepositoryProxy.java
Metadata Management System | eu.supersede.integration.api.mdm.proxies.MetadataManagementProxy.java
Monitoring Orchestrator | eu.supersede.integration.api.monitoring.orchestrator.proxies.MonitoringOrchestratorProxy.java
Replan Controller | eu.supersede.integration.api.replan.controller.proxies.ReplanControllerProxy.java
Replan Optimizer | eu.supersede.integration.api.replan.optimizer.proxies.ReplanOptimizerProxy.java

### IF Logging
IF uses SLF4J for logging. It is configured to log to:
- a file, located at ${catalina.base}/logs/supersede.log
- a syslog file, placed at /var/log/supersede/supersede.log. Only Supersede components (and third party components) logging using SLF4J or Log4j 1.2.X forward these logs to syslog, in current configuration (pending to configure syslog for Apache logging and Log4J2)

Log level is set to INFO, excepting for eu.supersede loggers, which is set to DEBUG by default.
logback.xml and log4j.properties are included in IF jar, together with Apache Logging (logging.properties) configurations, set to INFO level. SUPERSEDE Components not using SLF4J or Log4j, but Apache Logging or other similar frameworks, store logging messages into the Tomcat logs.

Development server logs (including Tomcat logs for Front-End and Backend components) are browsable at http://supersede.es.atos.net/logs/

Supersede components can log execution information, by adopting SLF4J or Log4J 1.2.X:
- Add log4j.jar dependency to your component
- Create a logger for Log4J:
```sh
import org.apache.log4j.Logger;
...
private final Logger log = Logger.getLogger(this.getClass());
```
- Create a logger for SLF4J:
```sh
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
...
private final Logger log = LoggerFactory.getLogger(this.getClass());
```
- Log a message within the execution:
```sh
log.debug("your message")
```
- Log exceptions using the logger as well:
```sh
catch (Exception e) {
   log.error(e.getMessage(), e);
   return null;
}
```

### SUPERSEDE Platform Federation
IF API provides support for the Federation of SUPERSEDE Platforms. Several SUPERSEDE platforms can coexist with the unique SUPERSEDE Big Data platform.
When components within each SUPERSEDE platform register data format releases into the Metadata Management System of the Big Data platform, the must provide a unique platform identifier.
Similarly, when the Data Analysis component of the Big Data platform send alerts to a SUPERSEDE platform, it must communicate that identifier of the target platform the alert will be sent to.
From release 0.4.0, IF API client manages internally first communication scenarios, feeding them with the SUPERSEDE platform identifier.

<<<<<<< HEAD
To use this utility, the Java VM where the using component is executed must be launched with the following system properties:
```
-Dsupersede.if.properties=if.development.properties #Use the IF configuration for your SUPERSEDE environment: development|platform|senercon
-Dis.admin.user=<user> #Ask SUPERSEDE administrator for this IS account
-Dis.admin.passwd=<password>
```

=======
>>>>>>> e709db7cb8b23fc575cba61c9c2ef5fea690939c
Other usage scenarios:
- Retrieve the list of federated SUPERSEDE platforms:
Any component, in particular, SUPERSEDE Big Data Analysis component, can retrieve the current list of federated platforms using the following IF API code:

```
import eu.supersede.integration.api.datastore.integration.types.SupersedePlatform;
import eu.supersede.integration.federation.SupersedeFederation;
...
SupersedeFederation federation = new SupersedeFederation();
List<SupersedePlatform> platforms = federation.getFederatedSupersedePlatforms();
```

- Sent alerts to a concrete federated platform:
Any component, in particular, SUPERSEDE Big Data Analysis component, can send an alert to a concrete federated platform using the following IF API code:

```
import eu.supersede.integration.api.pubsub.adaptation.AdaptationPublisher;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationSubscriber;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationPublisher;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationSubscriber;
import eu.supersede.integration.federation.SupersedeFederation;

private static  SupersedeFederation federation = new SupersedeFederation();
//Get list of federated platforms
List<SupersedePlatform> platforms = federation.getFederatedSupersedePlatforms();

//Select a concrete platform to sent message to
SupersedePlatform platform = platforms.get(0);

//Instantiate Publisher (iAdaptationPublisher or iEvolutionPublisher) for a that target platform
iAdaptationPublisher publisher = new AdaptationPublisher(true, platform.getPlatform());

//Subscribers can be instantiated by default, therefore listening alerts sent to local platform 
// or to specific target 

iAdaptationSubscriber subscriber = new AdaptationSubscriber();

//or

iAdaptationSubscriber subscriber = new AdaptationSubscriber(platform.getPlatform());

```

- Get local federated platform (e.g. the one current component belongs to):
A component that is not using IF API client to register a data format releases into the Metadata Management System of the Big Data platform needs to retrieve its platform identifier and supply it as part of the new release registration API. Using the IF API client following code, it can get its identifier:

```
import eu.supersede.integration.api.datastore.integration.types.SupersedePlatform;
import eu.supersede.integration.federation.SupersedeFederation;
...
SupersedeFederation federation = new SupersedeFederation();
SupersedePlatform localPlatform = federation.getLocalFederatedSupersedePlatform();
String identifier = localPlatform.getPlatform();
```

SUPERSEDE Integration Framework is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

Main contact: Jesús Gorroñogoitia <jesus.gorronogoitia@atos.net>


