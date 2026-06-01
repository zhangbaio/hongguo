// 搜指定 kid 的完整 main_url
'use strict';
var KID = '6960e8ebf8818bad6286db200002ebeb';
Java.perform(function(){
  setTimeout(function(){
    var PAT = '36 39 36 30 65 38 65 62 66 38'; // "6960e8ebf8"
    Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
      Memory.scan(r.base, r.size, PAT, {
        onMatch: function(addr){
          try{
            var ctx=addr.sub(4096).readByteArray(16384);
            var s=String.fromCharCode.apply(null,new Uint8Array(ctx));
            var mi=s.indexOf('main_url');
            if(mi>=0){
              var urlSnip=s.substr(mi,500).replace(/[^\x20-\x7e]/g,'.');
              // 找 URL 的结束引号
              var urlStart=urlSnip.indexOf('https://');
              if(urlStart>=0){
                var urlEnd=urlSnip.indexOf('"',urlStart);
                var url=urlSnip.substr(urlStart,urlEnd>0?urlEnd-urlStart:400);
                send({t:'url',kid:KID,url:url,len:url.length});
              }
            }
          }catch(e){}
        },
        onError:function(){},onComplete:function(){}
      });
    });
    send({t:'done'});
  },200);
});
