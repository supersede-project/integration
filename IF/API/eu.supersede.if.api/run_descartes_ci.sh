#!/bin/bash -xe
#Configure Maven
export MAVEN_HOME=/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/Maven_3.6.0
export PATH=$PATH:$MAVEN_HOME/bin


cd IF/API/eu.supersede.if.api
#Configure MAVEN_HOME and PATH in Manage Jenkins/Configure Jenkins/Global Properties
#Only point at a Maven installation within the /var/jenkings.home/tools folder
#Copy IF account file
cp /var/jenkins_home/ifaccount.properties src/test/resources/
mvn -s/var/jenkins_home/settings.xml -f pom_descartes.xml clean package -DskipTests
DATE=`date '+%Y%m%d%H%M'`
DESCARTES_OUT=./target/pit-reports/$DATE
mvn -s/var/jenkins_home/settings.xml -f pom_descartes.xml org.pitest:pitest-maven:mutationCoverage -DmutationEngine=descartes

#Storing Descartes execution in descartes-usecases-output
RESULTS_DIR=/var/jenkins_home/workspace/descartes-usecases-output/atos/supersede/if/mutation-score/baseline/descartes/$DATE/
cp -r $DESCARTES_OUT $RESULTS_DIR

cd $RESULTS_DIR
git checkout master
git add *
git commit -m "Descartes execution results for Supersede IF"

