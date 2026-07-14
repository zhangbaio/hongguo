// 轻量检测: MediaCodec 是否在被调用? 列出所有活跃 codec 实例名
'use strict';

Java.perform(function() {
  // 1. hook createDecoderByType 看有什么 codec 被创建
  var MC = Java.use('android.media.MediaCodec');
  MC.createDecoderByType.implementation = function(mime) {
    var r = this.createDecoderByType(mime);
    try { send({t:'createDecoder', mime:mime, name:r.getName()}); } catch(e){}
    return r;
  };

  // 2. hook queueInputBuffer 仅记录计数(不写文件)
  var cnt = {hevc:0, aac:0, other:0};
  MC.queueInputBuffer.implementation = function(idx, off, size, pts, flags) {
    try {
      var name = this.getName().toLowerCase();
      if (name.indexOf('hevc')>=0||name.indexOf('h265')>=0||name.indexOf('bytevc')>=0) {
        cnt.hevc++;
        if (cnt.hevc<=3) send({t:'hevc_frame', n:cnt.hevc, size:size, pts:''+pts, name:name});
      } else if (name.indexOf('aac')>=0||name.indexOf('mp4a')>=0||name.indexOf('audio')>=0) {
        cnt.aac++;
      } else {
        cnt.other++;
        if(cnt.other<=3) send({t:'other_codec', name:name, size:size});
      }
    } catch(e){}
    return this.queueInputBuffer(idx, off, size, pts, flags);
  };

  // 3. Java.choose 找所有活跃 codec 实例
  Java.choose('android.media.MediaCodec', {
    onMatch: function(inst) {
      try { send({t:'active_codec', name: inst.getName()}); } catch(e){}
    },
    onComplete: function() {}
  });

  send({t:'info', msg:'hooks ready, counts will appear in 5s'});
  setTimeout(function(){ send({t:'counts', c:cnt}); }, 5000);
  setTimeout(function(){ send({t:'counts', c:cnt}); }, 15000);
});
