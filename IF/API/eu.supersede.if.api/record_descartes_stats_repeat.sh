echo 'capturing statistics for pid: ' $1 every $2 seconds 'in file ' $3
while true 
do
echo 'Collecting Descartes statistics'
./record_descartes_stats.sh $1 $3 &
pid=$!
sleep $2
kill $pid
done

