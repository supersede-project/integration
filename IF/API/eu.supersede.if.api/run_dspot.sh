#!/bin/bash
set -e # Any subsequent(*) commands which fail will cause the shell script to exit immediately
mvn clean package -DskipTests

#Configuration
RESULTS_DIR=/home/stamp/Git/dspot-usecases-output/atos/supersede/IF/DSpot
DSPOT_JAR_NAME=dspot-1.1.1-SNAPSHOT-jar-with-dependencies.jar
DSPOT_JAR=/home/stamp/Git/dspot/dspot/target/$DSPOT_JAR_NAME
DSPOT_OUT=./dspot-out
mkdir -p $DSPOT_OUT

#Time out:
TIMEOUT=30000

#Selectors: PitMutantScoreSelector | ExecutedMutantSelector | CloverCoverageSelector | JacocoCoverageSelector | TakeAllSelector | ChangeDetectorSelector
DSPOT_SELECTOR=CloverCoverageSelector

#Amplifiers: StringLiteralAmplifier,NumberLiteralAmplifier,CharLiteralAmplifier,BooleanLiteralAmplifier,AllLiteralAmplifiers,MethodAdd,MethodRemove,TestDataMutator (deprecated),MethodGeneratorAmplifier,ReturnValueAmplifier,ReplacementAmplifier,NullifierAmplifier
DSPOT_AMPLIFIERS=AllLiteralAmplifiers:MethodGeneratorAmplifier:ReturnValueAmplifier:NullifierAmplifier

#Iterations:
DSPOT_ITERACTIONS=1

#Target Test:
TARGET_TEST=eu.supersede.integration.api.adaptation.dashboard.proxies.test.AdaptationDashboardProxyTest

#JVM parameters
JAVA_OPTS="-Dsupersede.if.properties=if.development.properties -Dis.admin.user=admin -Dis.admin.passwd='\$2pRSid#'"


DSPOT_OPTS="-i $DSPOT_ITERACTIONS -t $TARGET_TEST -a $DSPOT_AMPLIFIERS -s $DSPOT_SELECTOR --timeOut $TIMEOUT --verbose"

echo "DSpot configuration: " $DSPOT_OPTS
DSPOT_PROPERTIES="./dspot.properties"

RESULTS_DIR=$RESULTS_DIR/$DSPOT_SELECTOR/$DSPOT_AMPLIFIERS/`date '+%Y%m%d%H%M'`
mkdir -p $RESULTS_DIR
filename=$RESULTS_DIR/dspot.log

echo "Starting DSpot: reporting in file" + $filename
echo "Started DSpot: `date`" > $filename
echo "DSpot CLI configuration: " $DSPOT_OPTS >> $filename
echo "DSpot properties file: " $DSPOT_PROPERTIES >> $filename

nohup time java $JAVA_OPTS -jar $DSPOT_JAR -p $DSPOT_PROPERTIES $DSPOT_OPTS | tee -a $filename &
pid_dpot=$!
((pid_dpot--)) #Decremented to capture mvn command pid, otherwise it captures tee command pid

wait $pid_dpot

#copy DSpot results
cp -r $DSPOT_OUT $RESULTS_DIR

echo "Ended DSpot: `date`" >> $filename
