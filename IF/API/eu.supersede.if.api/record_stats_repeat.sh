echo 'record_stats_repeat.sh: capturing statistics for pid: ' $1 every $3 seconds 'in file ' $4 renewing statistics every $2 seconds
while true 
do
echo 'record_stats_repeat.sh:Collecting statistics for pid: ' $1 every $3 seconds >> $4
./record_stats.sh $1 $3 $4 &
pid=$!
sleep $2
kill -- $pid
done

