#!/bin/sh
DSPOT_JAR=/home/yosu/Projects/STAMP/Git/dspot/dspot/target/dspot-1.0.0-jar-with-dependencies.jar
java -jar $DSPOT_JAR -p ./dspot2.properties \
-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest \
-a MethodAdd -s JacocoCoverageSelector
