date=`date '+%Y-%m-%d_%H:%M:%S'`
filename=./descartes_results/descartes_if_$date.txt

echo "Started Descartes: `date`" > $filename

nohup mvn -f pom_for_descartes.xml test org.pitest:pitest-maven:mutationCoverage | tee -a $filename &

read -p "Waiting to capture process pid" -t 5
pid1=`ps -ef | awk '$NF~"maven" {print $2}'`
pid2=`ps -ef | awk '$NF~"surefire" {print $2}'`
echo $pid1","$pid2 > descartes.pid
echo "Process pid captured"
echo "Capturing statistics"
stats=./descartes_results/descartes_if_stats_$date.txt
nohup ./record_descartes_stats.sh >> $stats &

echo "Ended Descartes: `date`" >> $filename
