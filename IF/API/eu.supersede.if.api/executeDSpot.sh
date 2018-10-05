#Configuration
RESULTS_DIR=/home/stamp/Git/dspot-usecases-output/atos/supersede
DSPOT_JAR_NAME=dspot-1.1.1-SNAPSHOT-jar-with-dependencies.jar
DSPOT_JAR=/home/stamp/Git/dspot/dspot/target/$DSPOT_JAR_NAME
DSPOT_OUT=./dspot-out
mkdir -p $DSPOT_OUT
rm -rf $DSPOT_OUT/*

#Selectors: JacocoCoverageSelector, CloverCoverageSelector
DSPOT_SELECTOR=JacocoCoverageSelector
DSPOT_AMPLIFIERS=MethodAdd:StatementAdd:TestDataMutator
DSPOT_ITERACTIONS=3
DSPOT_TIMEOUT=120000
TARGET_TEST=eu.supersede.integration.api.security.test.*

#DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s JacocoCoverageSelector"
#DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s CloverCoverageSelector --verbose"
#DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s PitMutantScoreSelector --verbose"

DSPOT_OPTS="-i $DSPOT_ITERACTIONS -t $TARGET_TEST -a $DSPOT_AMPLIFIERS -s $DSPOT_SELECTOR --timeOut $DSPOT_TIMEOUT --verbose"

echo "executeDSpot.sh: DSpot configuration: " $DSPOT_OPTS

DSPOT_PROPERTIES="./dspot.properties"

date=`date '+%Y-%m-%d_%H-%M-%S'`
RESULTS_DIR=$RESULTS_DIR/$DSPOT_SELECTOR/$DSPOT_AMPLIFIERS/`date '+%Y-%m-%d_%H-%M-%S'`
mkdir -p $RESULTS_DIR
#copy dspot.properties configuration
cp $DSPOT_PROPERTIES $RESULTS_DIR
filename=$RESULTS_DIR/dspot_if_$date.txt

echo "executeDSpot.sh: Starting DSpot: reporting in file" + $filename
echo "executeDSpot.sh: Started DSpot: `date`" > $filename
echo "executeDSpot.sh: DSpot CMI configuration: " $DSPOT_OPTS >> $filename
echo "executeDSpot.sh: DSpot properties file: " $DSPOT_PROPERTIES >> $filename

#clean and build project. 
mvn clean package -DskipTests

#Execute DSpot

nohup java -jar $DSPOT_JAR -p $DSPOT_PROPERTIES $DSPOT_OPTS |& tee -a $filename &
pid_dpot=$!
((pid_dpot--)) #Decremented to capture mvn command pid, otherwise it captures tee command pid

#echo "executeDSpot.sh: Capturing statistics for Dspot process with pid " $pid_dpot
#stats=$RESULTS_DIR/dspot_if_stats_$date.txt
#echo "executeDSpot.sh: Storing statistics in " $stats

#echo "executeDSpot.sh: ./record_stats_repeat.sh" $pid_dpot "180 30" $stats "&"
#./record_stats_repeat.sh $pid_dpot 180 30 $stats &
#pid_stats=$!

wait $pid_dpot
#kill -- $pid_stats

#copy DSpot results
cp -r $DSPOT_OUT $RESULTS_DIR

echo "executeDSpot.sh: Ended DSpot: `date`" >> $filename
