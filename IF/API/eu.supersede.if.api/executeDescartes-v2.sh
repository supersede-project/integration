date=`date '+%Y-%m-%d_%H:%M:%S'`
filename=./descartes_results/descartes_if_$date.txt

echo "Started Descartes: `date`" > $filename

mvn -f pom_for_descartes.xml test org.pitest:pitest-maven:mutationCoverage | tee -a $filename

echo "Ended Descartes: `date`" >> $filename
