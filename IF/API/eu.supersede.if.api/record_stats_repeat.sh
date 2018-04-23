echo 'capturing statistics for pid: ' $1 every $2 seconds 'in file ' $3 
while true 
do
echo 'Collecting statistics for pid: ' $1 every $2 seconds >> $3
./record_stats.sh $1 $3 &
pid=$!
sleep $2
kill $pid
done

