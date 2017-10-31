#!/bin/sh
cd /home/yosu/Projects/STAMP/Git/dspot
java -Dis.admin.user=admin -Dis.admin.passwd=$2pRSid# \
-jar target/dspot-1.0.0-jar-with-dependencies.jar --verbose \
-p ../../../Supersede/Git/integration/IF/API/eu.supersede.if.api/dspot.properties \
-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest \
-a MethodAdd \
-s JacocoCoverageSelector
