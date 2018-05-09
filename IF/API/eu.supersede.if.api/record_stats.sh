echo 'capturing statistics for pid: ' $1 ' in file ' $2
pids=`pgrep -P $1`
echo 'subprocesses: ' $pids >> $2

pids_array=()
while IFS= read -r line; do
    pids_array+=( "$line" )
done < <( pgrep -P $1 )

new_pids=$1

for pid in "${pids_array[@]}"
do
new_pids=$new_pids','$pid
done

pidstat -h -r -u -p $new_pids 10 >> $2
