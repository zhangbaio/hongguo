// 抓红果设备身份: 对带 device_id 的请求, 把 {url, headers} 以 base64(JSON) 发出(单行, 解析稳)。
'use strict';
Java.perform(function(){
  var n=0, tries=0;
  var B64=null;
  function b64(s){ try{ if(!B64) B64=Java.use("android.util.Base64"); var S=Java.use("java.lang.String"); return B64.encodeToString(S.$new(s).getBytes("UTF-8"),2); }catch(e){ return ""; } }
  function hook(){
    tries++;
    var Req; try{ Req=Java.use("com.bytedance.retrofit2.client.Request"); }catch(e){ return false; }
    Req.$init.overloads.forEach(function(ov){
      ov.implementation=function(){
        var r=ov.apply(this,arguments);
        try{
          var u=""+this.getUrl();
          if(n<8 && u.indexOf("device_id=")>=0){
            n++;
            var H={}; try{ var L=this.getHeaders(); if(L){var it=L.iterator(); while(it.hasNext()){var h=it.next(); H[""+h.getName()]=""+h.getValue();}} }catch(e){}
            send("###REQ###"+b64(JSON.stringify({url:u,headers:H}))+"###END###");
          }
        }catch(e){}
        return r;
      };
    });
    send("grab hooked");
    return true;
  }
  if(!hook()){ var t=setInterval(function(){ if(hook()||tries>120) clearInterval(t); },400); }
});
