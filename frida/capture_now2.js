// 从当前播放视频的 spade_a 内存命中点展开, 拿完整 video_model(含 main_url)
'use strict';

Java.perform(function() {
  setTimeout(function() {
    var PAT = '73 70 61 64 65 5f 61';
    Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
      Memory.scan(r.base, r.size, PAT, {
        onMatch: function(addr) {
          try {
            // 往前后各 4KB 找完整 JSON
            var ctx = addr.sub(2048).readByteArray(8192);
            var s = String.fromCharCode.apply(null, new Uint8Array(ctx));
            if (s.indexOf('main_url')>=0 && s.indexOf('cenc')>=0) {
              // 找 main_url
              var mi = s.indexOf('main_url');
              var snippet = s.substr(mi, 400).replace(/[^\x20-\x7e]/g,'.');
              send({t:'main_url_ctx', addr:addr.toString(), snippet:snippet});
            }
          } catch(e){}
        },
        onError:function(){}, onComplete:function(){}
      });
    });
  }, 200);
});
