// 在已知 spade_a 命中地址附近扫更大范围找完整 video_model(含 main_url)
'use strict';
var PAT='73 70 61 64 65 5f 61';
var found=0;
Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
  if(found>0)return;
  Memory.scan(r.base,r.size,PAT,{
    onMatch:function(addr){
      if(found>0)return 'stop';
      try{
        // 宽窗口: 前后 64KB
        var ctx=addr.sub(32768).readByteArray(131072);
        var s=String.fromCharCode.apply(null,new Uint8Array(ctx));
        if(s.indexOf('6960e8eb')>=0&&s.indexOf('main_url')>=0){
          found++;
          // 找所有 https:// URL
          var idx=0;
          while(idx<s.length){
            var hi=s.indexOf('https://',idx);
            if(hi<0)break;
            var end=s.indexOf('"',hi);
            if(end>0&&end-hi<800){
              var url=s.substr(hi,end-hi);
              if(/qznovelvod|bytedance|toutiao/.test(url))
                send({t:'url',url:url});
            }
            idx=hi+8;
          }
        }
      }catch(e){}
    },
    onError:function(){},onComplete:function(){}
  });
});
send({t:'done',found:found});
