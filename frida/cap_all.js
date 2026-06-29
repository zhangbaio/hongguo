// 广捕: 所有出站 URL(path)+ 对 register/activate/service2 dump 全量 url+headers+body
'use strict';
function deep(u){ u=(""+u).toLowerCase(); return u.indexOf("register")>=0||u.indexOf("/activate")>=0||u.indexOf("/service/2/")>=0; }
function bodyInfo(arr){ try{
  var n=arr.length,h=[]; for(var i=0;i<Math.min(n,24);i++){var b=arr[i]&0xff;h.push((b<16?"0":"")+b.toString(16));}
  var t=""; try{t=Java.use("java.lang.String").$new(arr,"UTF-8").toString();}catch(e){}
  var txt=(t.indexOf("{")>=0&&/[\x20-\x7e]/.test(t));
  return "len="+n+" head="+h.join(" ")+(txt?("\n  PLAINTEXT: "+t.slice(0,1500)):"  (加密)");
}catch(e){return "<"+e+">";} }
Java.perform(function(){
  var BAOS=Java.use("java.io.ByteArrayOutputStream");
  function dumpReq(method,url,hdrs,body){
    send("###REQ### "+method+" "+url+"\n  HDR:"+(hdrs||"")+"\n  BODY "+(body||"<none>")+"\n###END###");
  }
  // retrofit2
  try{ var Req=Java.use("com.bytedance.retrofit2.client.Request");
    Req.$init.overloads.forEach(function(ov){ ov.implementation=function(){ var r=ov.apply(this,arguments);
      try{ var u=this.getUrl(); send("URL "+(""+u).split("?")[0]);
        if(deep(u)){ var hs=""; try{var L=this.getHeaders(); if(L){var it=L.iterator(); while(it.hasNext()){var hh=it.next(); hs+="\n    "+hh.getName()+": "+hh.getValue();}}}catch(e){}
          var bd=null; try{var b=this.getBody(); if(b){var os=BAOS.$new(); b.writeTo(os); bd=bodyInfo(os.toByteArray());}}catch(e){bd="<"+e+">";}
          dumpReq(this.getMethod(),u,hs,bd);
        }
      }catch(e){} return r; };});
    send("retrofit ok"); }catch(e){ send("retrofit X "+e); }
  // okhttp3
  try{ var Ch=Java.use("okhttp3.internal.http.RealInterceptorChain");
    Ch.proceed.overload('okhttp3.Request').implementation=function(req){ try{ var u=req.url().toString(); send("URL "+u.split("?")[0]);
      if(deep(u)){ var hs=""; try{var H=req.headers(); for(var i=0;i<H.size();i++) hs+="\n    "+H.name(i)+": "+H.value(i);}catch(e){}
        var bd=null; try{var bb=req.body(); if(bb){var Buf=Java.use("okio.Buffer").$new(); bb.writeTo(Buf); bd=bodyInfo(Buf.readByteArray());}}catch(e){bd="<"+e+">";}
        dumpReq(req.method(),u,hs,bd);
      }}catch(e){} return this.proceed(req); };
    send("okhttp ok"); }catch(e){ send("okhttp X "+e); }
  send("cap_all ready");
});
