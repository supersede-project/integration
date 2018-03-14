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

#nohup mvn -f $POM_FILE test org.pitest:pitest-maven:mutationCoverage | tee -a $filename &
mvn -f $POM_FILE test org.pitest:pitest-maven:mutationCoverage | tee -a $filename &
pid_descartes=$!

#pid1=`ps -ef | awk '$NF~"maven" {print $2}'`
#pid2=`ps -ef | awk '$NF~"surefire" {print $2}'`
#echo $pid1","$pid2 > descartes.pid
#echo "Process pid captured"
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
#Kill Descartes process once finish to proceed (BUG: Descartes process does not exit after finished)
report_date=`date '+%Y%m%d%H'`
echo mv $DESCARTES_RESULTS_DIRECTORY/$report_date* $RESULTS_DIR
mv $DESCARTES_RESULTS_DIRECTORY/$report_date* $RESULTS_DIR
