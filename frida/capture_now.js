// 视频正在播放时调用: 捕获代理URL + 当前视频model + 尝试copyFile
'use strict';

Java.perform(function() {
  setTimeout(function() {
    var AVMDL = Java.use('com.ss.mediakit.medialoader.AVMDLDataLoader');
    var inst = AVMDL.getInstance();

    // 1. 当前代理地址
    send({t:'addr', v: ''+inst.getLocalAddr()});

    // 2. getStringValue 全扫 (0..30)
    for (var i=0; i<30; i++) {
      try { var v=inst.getStringValue(i); if(v && v!='null') send({t:'gsv',i:i,v:''+v}); } catch(e){}
    }

    // 3. 内存里找当前播放的 video_model (spade_a)
    var PAT = '73 70 61 64 65 5f 61'; // "spade_a"
    var hits=[];
    Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
      if(hits.length>=3) return;
      Memory.scan(r.base, r.size, PAT, {
        onMatch: function(addr) {
          try {
            var ctx = addr.sub(100).readByteArray(400);
            var s = String.fromCharCode.apply(null, new Uint8Array(ctx));
            if (s.indexOf('cenc')>=0 || s.indexOf('encrypt')>=0) {
              hits.push({addr: addr.toString(), ctx: s.replace(/[^\x20-\x7e]/g,'.')});
              send({t:'spade_hit', addr:addr.toString(), ctx: s.replace(/[^\x20-\x7e]/g,'.')});
            }
          } catch(e){}
        },
        onError: function(){}, onComplete: function(){}
      });
    });

    // 4. TTVideoEngine 当前播放URL
    try {
      var insts=[];
      Java.choose('com.ss.ttvideoengine.TTVideoEngine', {
        onMatch: function(i){ insts.push(i); },
        onComplete: function(){}
      });
      insts.forEach(function(ttv, idx){
        try{ send({t:'playUrl', idx:idx, v:''+ttv.getCurrentPlayUrl()}); }catch(e){}
        try{
          var vm=ttv.getVideoModel ? ttv.getVideoModel() : null;
          if(vm) send({t:'videoModel', idx:idx, v:vm.toString().substr(0,300)});
        }catch(e){}
      });
    } catch(e){ send({t:'ttv_err',e:''+e}); }

  }, 200);
});
