// 找 bt=983 (1080p) 对应的完整 URL
'use strict';
Java.perform(function() {
  setTimeout(function() {
    var PAT = '62 74 3d 39 38 33'; // "bt=983"
    Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
      Memory.scan(r.base, r.size, PAT, {
        onMatch: function(addr) {
          try {
            // 往前找 https://
            var start = addr.sub(512);
            var buf = start.readByteArray(1024);
            var s = String.fromCharCode.apply(null, new Uint8Array(buf));
            var hi = s.indexOf('https://');
            var qi = s.indexOf('"', hi > 0 ? hi : 0);
            if (hi >= 0 && qi > hi) {
              var url = s.substr(hi, qi-hi);
              send({t:'url983', url: url});
            }
          } catch(e){}
        },
        onError: function(){}, onComplete: function(){}
      });
    });
    send({t:'done'});
  }, 200);
});
