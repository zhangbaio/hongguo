// 扫内存找"北派"相关的 video_model, 拿 main_url + spade_a + kid
// 重点找大 IDR 尺寸 (1080p: sample0约50KB)
'use strict';

var PAT = '73 70 61 64 65 5f 61';  // "spade_a"
var hits = []; var maxHits = 10;

Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
  if (hits.length >= maxHits) return;
  Memory.scan(r.base, r.size, PAT, {
    onMatch: function(addr) {
      if (hits.length >= maxHits) return 'stop';
      try {
        // 取大窗口找 main_url
        var ctx = addr.sub(4096).readByteArray(16384);
        var s = String.fromCharCode.apply(null, new Uint8Array(ctx));
        if (s.indexOf('main_url') >= 0) {
          // 找 main_url value
          var mi = s.indexOf('main_url');
          var urlSnip = s.substr(mi, 300).replace(/[^\x20-\x7e]/g,'.');
          // 找 kid
          var ki = s.indexOf('kid');
          var kidSnip = ki>=0 ? s.substr(ki, 50).replace(/[^\x20-\x7e]/g,'.') : '?';
          // 找 spade_a value
          var si2 = s.indexOf('spade_a');
          var spSnip = si2>=0 ? s.substr(si2, 80).replace(/[^\x20-\x7e]/g,'.') : '?';
          hits.push(1);
          send({t:'vm', addr:addr.toString(), url:urlSnip, kid:kidSnip, spade:spSnip});
        }
      } catch(e) {}
    },
    onError: function(){}, onComplete: function(){}
  });
});
send({t:'done', hits: hits.length});
