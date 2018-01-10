pids=`cat dspot.pid`
pidstat -h -r -u -v -p $pids 5  
