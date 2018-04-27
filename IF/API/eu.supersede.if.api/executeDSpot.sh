#Configuration
RESULTS_DIR=/home/stamp/Git/dspot-usecases-output/atos/supersede
DSPOT_JAR_NAME=dspot-1.1.1-SNAPSHOT-jar-with-dependencies.jar
DSPOT_JAR=/home/stamp/Git/dspot/dspot/target/$DSPOT_JAR_NAME
DSPOT_OUT=./dspot-out

#Selectors: JacocoCoverageSelector, CloverCoverageSelector
DSPOT_SELECTOR=JacocoCoverageSelector
DSPOT_AMPLIFIERS=MethodAdd:StatementAdd:TestDataMutator
DSPOT_ITERACTIONS=3
TARGET_TEST=eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest

#DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s JacocoCoverageSelector"
#DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s CloverCoverageSelector --verbose"
#DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s PitMutantScoreSelector --verbose"

DSPOT_OPTS="-i $DSPOT_ITERACTIONS -t $TARGET_TEST -a $DSPOT_AMPLIFIERS -s $DSPOT_SELECTOR --verbose"

echo "DSpot configuration: " $DSPOT_OPTS

DSPOT_PROPERTIES="./dspot2.properties"

date=`date '+%Y-%m-%d_%H:%M:%S'`
RESULTS_DIR=$RESULTS_DIR/$DSPOT_SELECTOR/$DSPOT_AMPLIFIERS/`date '+%Y-%m-%d_%H:%M:%S'`
mkdir -p $RESULTS_DIR
filename=$RESULTS_DIR/dspot_if_$date.txt

echo "Starting DSpot: reporting in file" + $filename
echo "Started DSpot: `date`" > $filename
echo "DSpot CMI configuration: " $DSPOT_OPTS >> $filename
echo "DSpot properties file: " $DSPOT_PROPERTIES >> $filename

nohup java -jar $DSPOT_JAR -p $DSPOT_PROPERTIES $DSPOT_OPTS |& tee -a $filename &
pid_dpot=$!
((pid_dpot--)) #Decremented to capture mvn command pid, otherwise it captures tee command pid

echo "Capturing statistics for Dspot process with pid " $pid_dpot
stats=$RESULTS_DIR/dspot_if_stats_$date.txt
echo "Storing statistics in " $stats

./record_stats_repeat.sh $pid_dpot 180 $stats &
pid_stats=$!

wait $pid_dpot
kill $pid_stats

#copy DSpot results
cp -r $DSPOT_OUT $RESULTS_DIR

echo "Ended DSpot: `date`" >> $filename
