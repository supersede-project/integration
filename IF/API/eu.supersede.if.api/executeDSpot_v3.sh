date=`date '+%Y-%m-%d_%H:%M:%S'`
filename=./dspot_results/dspot_if_$date.txt

echo "Started DSpot: `date`" > $filename

DSPOT_JAR=/home/yosu/Projects/STAMP/Git/dspot/dspot/target/dspot-1.0.0-jar-with-dependencies.jar

dspot_opts="-i 1 -t eu.supersede.integration.api.replan.controller.proxies.test.ReplanControllerProxyTest -a MethodAdd -s JacocoCoverageSelector"
dspot_properties="./dspot2.properties"
echo "DSpot CMI configuration: " $dspot_opts >> $filename
echo "DSpot properties file: " $dspot_properties >> $filename

nohup java -jar $DSPOT_JAR -p $dspot_properties $dspot_opts | tee -a $filename &

read -p "Waiting to capture process pid" -t 5
pid=`ps -ef | awk '$NF~"dspot" {print $2}'`
echo $pid > dspot.pid
echo "Process pid captured"
echo "Capturing statistics"
stats=./dspot_results/dspot_if_stats_$date.txt
nohup ./record_dspot_stats.sh >> $stats &

echo "Ended DSpot: `date`" >> $filename
