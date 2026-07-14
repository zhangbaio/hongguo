#!/system/bin/sh
PID=$(pidof com.phoenix.read)
echo "dumping pid=$PID"
while read s c; do
  dd if=/proc/$PID/mem bs=4096 skip=$s count=$c conv=noerror,sync 2>/dev/null
done < /data/local/tmp/dumplist.txt | gzip -1 > /data/local/tmp/dump_live.gz
ls -la /data/local/tmp/dump_live.gz
