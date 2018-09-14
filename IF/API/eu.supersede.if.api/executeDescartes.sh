#Configuration
DESCARTES_RESULTS_DIRECTORY=/home/stamp/Git/descartes-usecases-output/atos/supersede
POM_FILE=pom_for_descartes.xml

date=`date '+%Y-%m-%d_%H-%M-%S'`
report_date=`date '+%Y%m%d%H'`
RESULTS_DIR=$DESCARTES_RESULTS_DIRECTORY/`date '+%Y-%m-%d_%H-%M-%S'`
mkdir -p $RESULTS_DIR
#copy Descartes configuration
cp $POM_FILE $RESULTS_DIR
filename=$RESULTS_DIR/descartes_if_$date.txt

echo "Starting Descartes: reporting in file" + $filename
echo "Started Descartes: `date`" > $filename
echo "Descartes pom file: " $POM_FILE >> $filename

#clean and build project. 
mvn clean package -DskipTests

#Execute Descartes
mvn -f $POM_FILE test org.pitest:pitest-maven:mutationCoverage |& tee -a $filename &
pid_descartes=$!
((pid_descartes--)) #Decremented to capture mvn command pid, otherwise it captures tee command pid

echo "Capturing statistics for descartes process with pid " $pid_descartes
stats=$RESULTS_DIR/descartes_if_stats_$date.txt
echo "Storing statistics in " $stats

./record_stats_repeat.sh $pid_descartes 180 30 $stats &
pid_stats=$!

wait $pid_descartes
kill -- $pid_stats

echo "Ended Descartes: `date`" >> $filename

#Move results to RESULTS_DIR

echo mv $DESCARTES_RESULTS_DIRECTORY/$report_date* $RESULTS_DIR
mv $DESCARTES_RESULTS_DIRECTORY/$report_date* $RESULTS_DIR
