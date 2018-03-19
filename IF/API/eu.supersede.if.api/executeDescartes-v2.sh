#Configuration
DESCARTES_RESULTS_DIRECTORY=/home/yosu/Projects/STAMP/Git/descartes-usecases-output/atos/supersede
POM_FILE=pom_for_descartes.xml

date=`date '+%Y-%m-%d_%H:%M:%S'`
RESULTS_DIR=$DESCARTES_RESULTS_DIRECTORY/`date '+%Y-%m-%d_%H:%M:%S'`
mkdir -p $RESULTS_DIR
filename=$RESULTS_DIR/descartes_if_$date.txt

echo "Starting Descartes: reporting in file" + $filename
echo "Started Descartes: `date`" > $filename
echo "Descartes pom file: " $POM_FILE >> $filename

#clean and build project. 
mvn clean package -DskipTests

#Execute Descartes
mvn -f $POM_FILE test org.pitest:pitest-maven:mutationCoverage | tee -a $filename &
pid_descartes=$!

echo "Capturing statistics for descartes process with pid " $pid_descartes
stats=$RESULTS_DIR/descartes_if_stats_$date.txt
echo "Storing statistics in " $stats
#nohup ./record_descartes_stats.sh >> $stats &

./record_descartes_stats_repeat.sh $pid_descartes 180 $stats &
pid_stats=$!

wait $pid_descartes
kill $pid_stats

echo "Ended Descartes: `date`" >> $filename

#Move results to RESULTS_DIR
report_date=`date '+%Y%m%d%H'`
echo mv $DESCARTES_RESULTS_DIRECTORY/$report_date* $RESULTS_DIR
mv $DESCARTES_RESULTS_DIRECTORY/$report_date* $RESULTS_DIR
