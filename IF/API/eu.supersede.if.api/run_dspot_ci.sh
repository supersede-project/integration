#!/bin/bash -xe
#NOTE: Copy /var/jenkins_home/settings.xml into /roo/.m2 folder of Jenkins container
cd IF/API/eu.supersede.if.api
mvn clean package -DskipTests

#Time out:
TIMEOUT=30000

#Selectors: PitMutantScoreSelector,JacocoCoverageSelector,TakeAllSelector,ChangeDetectorSelector
DSPOT_SELECTOR=JacocoCoverageSelector

#Amplifiers: MethodAdd,MethodRemove,TestDataMutator,MethodGeneratorAmplifier,ReturnValueAmplifier,StringLiteralAmplifier,NumberLiteralAmplifier,BooleanLiteralAmplifier,CharLiteralAmplifier,AllLiteralAmplifiers,NullifierAmplifier,None
#AllLiteralAmplifiers,MethodGeneratorAmplifier,ReturnValueAmplifier,NullifierAmplifier
DSPOT_AMPLIFIERS=AllLiteralAmplifiers,MethodGeneratorAmplifier,ReturnValueAmplifier,NullifierAmplifier

#Iterations (default=3):
DSPOT_ITERACTIONS=3

#Target Test:
TARGET_TEST=eu.supersede.integration.api.adaptation.dashboard.proxies.test.AdaptationDashboardProxyTest

#Number of amplified tests (default=200)
MAX_TEST_AMPLIFIED=300

#Budgetizer (NoBudgetizer|SimpleBudgetizer)
BUGETIZER=NoBudgetizer

DSPOT_OPTS="-Diteration=$DSPOT_ITERACTIONS -Dtest=$TARGET_TEST -Damplifiers=$DSPOT_AMPLIFIERS -Dtest-criterion=$DSPOT_SELECTOR -DtimeOut=$TIMEOUT -Dmax-test-amplified=$MAX_TEST_AMPLIFIED -Dbudgetizer=$BUGETIZER -Dclean -Dverbose"

echo "DSpot configuration: " $DSPOT_OPTS
DSPOT_PROPERTIES="./dspot.properties"

#mvn help:evaluate -Dexpression=settings.localRepository | grep -v '\[INFO\]'
DSPOT_OUT=./target/dspot/output/
DSPOT_AMPLIFIERS_PATH=${DSPOT_AMPLIFIERS//,/-}
RESULTS_DIR=/var/jenkins_home/workspace/dspot-usecases-output/atos/supersede/IF/DSpot
RESULTS_DIR=$RESULTS_DIR/$DSPOT_SELECTOR/$DSPOT_AMPLIFIERS_PATH/`date '+%Y%m%d%H%M'`
mkdir -p $RESULTS_DIR
filename=$RESULTS_DIR/dspot.cmd

echo "Starting DSpot: reporting in file" + $filename
echo "Started DSpot: `date`" > $filename
echo "DSpot CLI configuration: " $DSPOT_OPTS >> $filename
echo "DSpot properties file: " $DSPOT_PROPERTIES >> $filename


#NOTE: Copy /var/jenkins_home/settings.xml into /root/.m2 folder of Jenkins container
mvn -f pom_dspot.xml eu.stamp-project:dspot-maven:amplify-unit-tests -Dpath-to-properties=$DSPOT_PROPERTIES $DSPOT_OPTS

#Storing DSpot execution in dspot-usecases-output
cp -r $DSPOT_OUT $RESULTS_DIR
cp $DSPOT_PROPERTIES $RESULTS_DIR

cd $RESULTS_DIR
git checkout master
git add *
git commit -m "DSpot execution results for amplification of test class(es): $TARGET_TEST"

