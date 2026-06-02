#!/system/bin/sh
PID=2616
while read s c;do dd if=/proc/$PID/mem bs=4096 skip=$s count=$c conv=noerror,sync 2>/dev/null;done</data/local/tmp/e3_dl.txt|gzip -1>/data/local/tmp/e3.gz
echo DONE
