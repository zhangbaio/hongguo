// 扫所有 qznovelvod CDN URL，不过滤 kid
'use strict';
var SEEN={};
var PAT='71 7a 6e 6f 76 65 6c 76 6f 64'; // "qznovelvod"
Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
  Memory.scan(r.base,r.size,PAT,{
    onMatch:function(addr){
      try{
        // 往前找 https://
        var start=addr.sub(256);
        var buf=start.readByteArray(1024);
        var s=String.fromCharCode.apply(null,new Uint8Array(buf));
        var hi=s.lastIndexOf('https://',256);
        if(hi>=0){
          var end=s.indexOf('"',hi+8);
          if(end<0)end=s.indexOf('\\',hi+8);
          if(end<0)end=hi+600;
          var url=s.substr(hi,end-hi).replace(/\\/g,'');
          if(url.length>30&&!SEEN[url.substr(0,60)]){
            SEEN[url.substr(0,60)]=1;
            var bt=url.match(/bt=(\d+)/); var ds=url.match(/ds=(\d+)/);
            var kid_m=s.match(/"kid"\s*:\s*"([0-9a-f]{32})"/);
            send({t:'url',bt:bt?bt[1]:'?',ds:ds?ds[1]:'?',
                  kid:kid_m?kid_m[1]:'?',url:url});
          }
        }
      }catch(e){}
    },
    onError:function(){},onComplete:function(){}
  });
});
send({t:'done',total:Object.keys(SEEN).length});
