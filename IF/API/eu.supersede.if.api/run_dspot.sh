
#!/bin/bash
set -e # Any subsequent(*) commands which fail will cause the shell script to exit immediately
mvn clean package -DskipTests

#Configuration
RESULTS_DIR=/home/yosu/Projects/STAMP/Git/dspot-usecases-output/atos/supersede/IF/DSpot
DSPOT_JAR_NAME=dspot-1.2.2-SNAPSHOT-jar-with-dependencies.jar
DSPOT_JAR=/home/yosu/Projects/STAMP/Git/dspot/dspot/target/$DSPOT_JAR_NAME
DSPOT_OUT=./dspot-out
rm -rf $DSPOT_OUT
mkdir -p $DSPOT_OUT

#Time out:
TIMEOUT=30000

#Selectors: PitMutantScoreSelector | ExecutedMutantSelector | CloverCoverageSelector | JacocoCoverageSelector | TakeAllSelector | ChangeDetectorSelector
DSPOT_SELECTOR=JacocoCoverageSelector

#Amplifiers: StringLiteralAmplifier,NumberLiteralAmplifier,CharLiteralAmplifier,BooleanLiteralAmplifier,AllLiteralAmplifiers,MethodAdd,MethodRemove,TestDataMutator (deprecated),MethodGeneratorAmplifier,ReturnValueAmplifier,ReplacementAmplifier,NullifierAmplifier
DSPOT_AMPLIFIERS=AllLiteralAmplifiers:MethodGeneratorAmplifier:ReturnValueAmplifier:NullifierAmplifier

#Iterations:
DSPOT_ITERACTIONS=3

#Target Test:
TARGET_TEST=eu.supersede.integration.api.adaptation.dashboard.proxies.test.AdaptationDashboardProxyTest

#Number of amplified tests (default=200)
MAX_TEST_AMPLIFIED=200

#Budgetizer (NoBudgetizer|SimpleBudgetizer)
BUGETIZER=NoBudgetizer

DSPOT_OPTS="-i $DSPOT_ITERACTIONS -t $TARGET_TEST -a $DSPOT_AMPLIFIERS -s $DSPOT_SELECTOR --timeOut $TIMEOUT --max-test-amplified $MAX_TEST_AMPLIFIED --budgetizer $BUGETIZER --verbose"

echo "DSpot configuration: " $DSPOT_OPTS
DSPOT_PROPERTIES="./dspot.properties"

DSPOT_AMPLIFIERS_PATH=${DSPOT_AMPLIFIERS//:/-}

RESULTS_DIR=$RESULTS_DIR/$DSPOT_SELECTOR/$DSPOT_AMPLIFIERS_PATH/`date '+%Y%m%d%H%M'`
mkdir -p $RESULTS_DIR
filename=$RESULTS_DIR/dspot.log

echo "Starting DSpot: reporting in file" + $filename
echo "Started DSpot: `date`" > $filename
echo "DSpot CLI configuration: " $DSPOT_OPTS >> $filename
echo "DSpot properties file: " $DSPOT_PROPERTIES >> $filename

nohup time java -jar $DSPOT_JAR -p $DSPOT_PROPERTIES $DSPOT_OPTS | tee -a $filename &
pid_dpot=$!
((pid_dpot--)) #Decremented to capture mvn command pid, otherwise it captures tee command pid

wait $pid_dpot

#copy DSpot results
mv $DSPOT_OUT $RESULTS_DIR
cp $DSPOT_PROPERTIES $RESULTS_DIR

echo "Ended DSpot: `date`" >> $filename
