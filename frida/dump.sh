#!/system/bin/sh
# 读 dumplist.txt(每行: 起始页 页数), 从 /proc/PID/mem dump 各段, gzip 成单文件。
cd /data/local/tmp
PID=313
while read s c; do
  dd if=/proc/$PID/mem bs=4096 skip=$s count=$c conv=noerror,sync 2>/dev/null
done < dumplist.txt | gzip -1 > dump.gz
echo "DUMP_DONE bytes_gz=$(stat -c %s dump.gz 2>/dev/null || echo ?)"
