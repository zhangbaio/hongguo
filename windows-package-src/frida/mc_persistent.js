// 常驻 MediaCodec hook: 持续抓取, 每个 IDR 帧时重置文件(=新 GOP / 新场景)
// 文件: /data/local/tmp/mc_video.h265, mc_audio.aac
// 当捕获到 IDR 帧时, 关闭并重开文件(保持最新一个完整 GOP)
'use strict';

var VPATH = '/data/local/tmp/mc_video.h265';
var APATH = '/data/local/tmp/mc_audio.aac';
var fv = null, fa = null;
var vBytes = 0, aBytes = 0;
var idrCount = 0;

Java.perform(function() {
  var FileOutputStream = Java.use('java.io.FileOutputStream');

  function openFiles(append) {
    try { if(fv){fv.flush();fv.close();}fv=FileOutputStream.$new(VPATH,append); } catch(e){}
    try { if(fa){fa.flush();fa.close();}fa=FileOutputStream.$new(APATH,append); } catch(e){}
  }
  openFiles(false);

  var MC = Java.use('android.media.MediaCodec');
  MC.queueInputBuffer.implementation = function(idx, off, size, pts, flags) {
    if (size > 4) {
      try {
        var name = this.getName().toLowerCase();
        var bb = this.getInputBuffer(idx); bb.position(off);
        var a = Java.array('byte', new Array(size).fill(0)); bb.get(a);

        if (name.indexOf('hevc')>=0||name.indexOf('bytevc')>=0||name.indexOf('h265')>=0) {
          // 检查是否是 IDR 帧(起点): flags=1 表示 BUFFER_FLAG_KEY_FRAME
          if (flags === 1 && vBytes > 0) {
            // 新 IDR -> 重置文件
            idrCount++;
            send({t:'idr', n:idrCount, vBytes:vBytes});
            openFiles(false); vBytes=0; aBytes=0;
          }
          if (fv) { fv.write(a,0,size); vBytes+=size; }
          if (vBytes <= 256) send({t:'v_start', flags:flags, size:size, vBytes:vBytes});
        } else if (name.indexOf('aac')>=0||name.indexOf('mp4a')>=0||name.indexOf('audio')>=0) {
          if (fa) { fa.write(a,0,size); aBytes+=size; }
        }
      } catch(e){}
    }
    return this.queueInputBuffer(idx, off, size, pts, flags);
  };

  send({t:'ready', msg:'persistent MC hook active - play a video from the start to capture'});

  // 每10秒汇报
  setInterval(function(){
    send({t:'status', vBytes:vBytes, aBytes:aBytes, idrCount:idrCount});
  }, 10000);
});
