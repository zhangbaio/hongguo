// 找 kid=682165f6 视频的 video_id 和 series_id
'use strict';
Java.perform(function(){
  setTimeout(function(){
    var PAT = '36 38 32 31 36 35 66 36 66 38'; // "682165f6f8"
    Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
      Memory.scan(r.base, r.size, PAT, {
        onMatch: function(addr){
          try {
            var ctx = addr.sub(2048).readByteArray(6144);
            var s = String.fromCharCode.apply(null, new Uint8Array(ctx));
            // 找 video_id
            var vi = s.indexOf('video_id');
            var si2 = s.indexOf('series_id');
            if (vi>=0 || si2>=0) {
              var snippet = s.substr(Math.max(0,vi>0?vi:si2)-20, 200).replace(/[^\x20-\x7e]/g,'.');
              send({t:'vid', addr:addr.toString(), s:snippet});
            }
          } catch(e){}
        },
        onError:function(){}, onComplete:function(){}
      });
    });
    send({t:'done'});
  },200);
});
