#mvn org.apache.maven.plugins:maven-dependency-plugin:copy-dependencies
mvn install:install-file -Dfile=dependency/org.wso2.carbon.um.ws.api.stub-4.2.2.jar -DgroupId=org.wso2.carbon -DartifactId=org.wso2.carbon.um.ws.api.stub -Dversion=4.2.2 -Dpackaging=jar

mvn install:install-file -Dfile=dependency/org.wso2.carbon.tenant.mgt.stub-4.2.0.jar -DgroupId=org.wso2.carbon -DartifactId=org.wso2.carbon.tenant.mgt.stub -Dversion=4.2.0 -Dpackaging=jar

mvn install:install-file -Dfile=dependency/org.wso2.carbon.um.ws.api-4.2.2.jar -DgroupId=org.wso2.carbon -DartifactId=org.wso2.carbon.um.ws.api -Dversion=4.2.2 -Dpackaging=jar

mvn install:install-file -Dfile=dependency/org.wso2.carbon.user.api-4.2.0.jar -DgroupId=org.wso2.carbon -DartifactId=org.wso2.carbon.user.api -Dversion=4.2.0 -Dpackaging=jar

mvn install:install-file -Dfile=dependency/org.wso2.carbon.user.core-4.2.0.jar -DgroupId=org.wso2.carbon -DartifactId=org.wso2.carbon.user.core -Dversion=4.2.0 -Dpackaging=jar

mvn install:install-file -Dfile=dependency/org.wso2.carbon.utils-4.2.0.jar -DgroupId=org.wso2.carbon -DartifactId=org.wso2.carbon.utils -Dversion=4.2.0 -Dpackaging=jar

mvn install:install-file -Dfile=dependency/opensaml2-2.4.1.wso2v1.jar -DgroupId=opensaml.wso2 -DartifactId=opensaml2 -Dversion=2.4.1.wso2v1 -Dpackaging=jar

mvn install:install-file -Dfile=dependency/feedback_library-0.0.1-SNAPSHOT.jar -DgroupId=eu.supersede.feedback_gathering -DartifactId=feedback_library -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar

mvn install:install-file -Dfile=dependency/geronimo-jms_1.1_spec-1.1.0.wso2v1.jar -DgroupId=org.apache.geronimo.specs.wso2 -DartifactId=geronimo-jms_1.1_spec -Dversion=1.1.0.wso2v1 -Dpackaging=jar

mvn install:install-file -Dfile=dependency/org.wso2.carbon.logging-4.4.1.jar -DgroupId=org.wso2.carbon -DartifactId=org.wso2.carbon.logging -Dversion=4.4.1 -Dpackaging=jar

mvn install:install-file -Dfile=dependency/org.wso2.securevault-1.0.0-wso2v2.jar -DgroupId=org.wso2.securevault -DartifactId=org.wso2.securevault -Dversion=1.0.0-wso2v2 -Dpackaging=jar

mvn clean package -DskipTests
echo -n "./target/classes:./target/test-classes:" > results/classpath.txt
for i in ./dependency/*.jar; do echo -n $i":"; done >> results/classpath.txt
