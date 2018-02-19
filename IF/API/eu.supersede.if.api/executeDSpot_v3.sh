#Configuration
RESULTS_DIR=/home/yosu/Projects/STAMP/Git/dspot-usecases-output/atos/supersede
DSPOT_JAR_NAME=dspot-1.0.6-SNAPSHOT-jar-with-dependencies.jar
DSPOT_JAR=/home/yosu/Projects/STAMP/Git/dspot/dspot/target/$DSPOT_JAR_NAME
#DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s JacocoCoverageSelector"
#DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s CloverCoverageSelector --verbose"
#DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s PitMutantScoreSelector --verbose"
DSPOT_OPTS="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd --verbose"
DSPOT_PROPERTIES="./dspot2.properties"

date=`date '+%Y-%m-%d_%H:%M:%S'`
RESULTS_DIR=$RESULTS_DIR/`date '+%Y-%m-%d_%H:%M:%S'`
mkdir -p $RESULTS_DIR
filename=$RESULTS_DIR/dspot_if_$date.txt

echo "Starting DSpot: reporting in file" + $filename
echo "Started DSpot: `date`" > $filename
echo "DSpot CMI configuration: " $DSPOT_OPTS >> $filename
echo "DSpot properties file: " $DSPOT_PROPERTIES >> $filename

nohup java -jar $DSPOT_JAR -p $DSPOT_PROPERTIES $DSPOT_OPTS | tee -a $filename &

read -p "Waiting to capture process pid" -t 5
pid=`ps -ef | grep -v grep | grep $DSPOT_JAR_NAME | awk  '{print $2}'`
echo $pid > dspot.pid
echo "Process pid captured"
echo "Capturing statistics"
stats=$RESULTS_DIR/dspot_if_stats_$date.txt
nohup ./record_dspot_stats.sh >> $stats &
wait
cp -r ./dspot-out $RESULTS_DIR/
echo "Ended DSpot: `date`" >> $filename
