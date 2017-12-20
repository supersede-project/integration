pids=`cat descartes.pid`
pidstat -h -r -u -v -p $pids 5  
