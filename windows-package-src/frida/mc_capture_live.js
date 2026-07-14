// MediaCodec 明文抓取 + 写设备文件 (§7 已验证方案)
// 抓 HEVC 明文 ES + AAC 明文 ES, 写到 /data/local/tmp/
'use strict';

var fv = null, fa = null;
var vbytes = 0, abytes = 0;

Java.perform(function() {
  var MC = Java.use('android.media.MediaCodec');
  var FileOutputStream = Java.use('java.io.FileOutputStream');

  try { fv = FileOutputStream.$new('/data/local/tmp/live_video.h265'); } catch(e){ send({t:'err',e:'video file:'+e}); }
  try { fa = FileOutputStream.$new('/data/local/tmp/live_audio.aac'); } catch(e){ send({t:'err',e:'audio file:'+e}); }

  MC.queueInputBuffer.implementation = function(idx, off, size, pts, flags) {
    if (size > 4) {
      try {
        var name = this.getName().toLowerCase();
        var bb = this.getInputBuffer(idx);
        bb.position(off);
        var a = Java.array('byte', new Array(size).fill(0));
        bb.get(a);

        if (name.indexOf('hevc') >= 0 || name.indexOf('h265') >= 0) {
          if (fv) { fv.write(a, 0, size); vbytes += size; }
        } else if (name.indexOf('aac') >= 0 || name.indexOf('mp4a') >= 0 || name.indexOf('audio') >= 0) {
          if (fa) { fa.write(a, 0, size); abytes += size; }
        }
      } catch(e) {}
    }
    return this.queueInputBuffer(idx, off, size, pts, flags);
  };

  send({t:'info', msg:'MediaCodec hook installed, capturing...'});

  // 每5秒汇报进度
  var tick = 0;
  var timer = setInterval(function() {
    tick++;
    send({t:'progress', tick:tick, vbytes:vbytes, abytes:abytes});
    if (tick >= 12) { // 60秒后停
      clearInterval(timer);
      if (fv) try{ fv.flush(); fv.close(); }catch(e){}
      if (fa) try{ fa.flush(); fa.close(); }catch(e){}
      send({t:'done', vbytes:vbytes, abytes:abytes});
    }
  }, 5000);
});
