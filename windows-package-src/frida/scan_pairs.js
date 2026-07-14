// 扫内存里 video_model, 提取 (main_url, kid) 配对 (同一 JSON 对象内)
'use strict';
var SEEN={};
var PAT='73 70 61 64 65 5f 61'; // "spade_a"
Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
  try{
  Memory.scan(r.base,r.size,PAT,{
    onMatch:function(addr){
      try{
        // 取较大窗口, 找该 video 对象内的 kid + 各清晰度 main_url
        var s=String.fromCharCode.apply(null,new Uint8Array(addr.sub(8192).readByteArray(24576)));
        // 该命中点附近的 kid
        var ki=s.lastIndexOf('"kid"',8192+200);
        var kid=null;
        if(ki>=0){
          var km=s.substr(ki,60).match(/"kid"\s*:\s*"([0-9a-f]{32})"/);
          if(km) kid=km[1];
        }
        if(!kid){
          var km2=s.match(/"kid"\s*:\s*"([0-9a-f]{32})"/);
          if(km2) kid=km2[1];
        }
        if(!kid) return;
        // 找该窗口内所有 main_url
        var re=/"main_url"\s*:\s*"(https:\/\/[^"]+)"/g; var m;
        while((m=re.exec(s))!==null){
          var url=m[1];
          var key=kid+'|'+url.substr(0,60);
          if(!SEEN[key]){SEEN[key]=1; send({t:'pair',kid:kid,url:url});}
        }
      }catch(e){}
    },onError:function(){},onComplete:function(){}
  });}catch(e){}
});
send({t:'done',n:Object.keys(SEEN).length});
