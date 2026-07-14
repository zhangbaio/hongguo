// 抓 device_register / activate 请求的 method+url+headers+body(判明文/加密)。
'use strict';
var KW = ["device_register", "/activate", "/device/register", "register/v"];
function hit(u){ if(!u) return false; u=(""+u).toLowerCase(); for(var i=0;i<KW.length;i++) if(u.indexOf(KW[i])>=0) return true; return false; }
function bodyInfo(arr){
  try{
    var n=arr.length, head=[];
    for(var i=0;i<Math.min(n,24);i++){var b=arr[i]&0xff; head.push((b<16?"0":"")+b.toString(16));}
    var txt=""; try{ txt=Java.use("java.lang.String").$new(arr,"UTF-8").toString();}catch(e){}
    var isText = txt.indexOf("{")>=0 && /[\x20-\x7e]/.test(txt);
    return "len="+n+" head="+head.join(" ")+(isText?("\n  PLAINTEXT BODY: "+txt.slice(0,1200)):"  (二进制/加密 body)");
  }catch(e){return "<body err "+e+">";}
}
Java.perform(function(){
  var BAOS=Java.use("java.io.ByteArrayOutputStream");
  try{
    var Req=Java.use("com.bytedance.retrofit2.client.Request");
    Req.$init.overloads.forEach(function(ov){
      ov.implementation=function(){
        var r=ov.apply(this,arguments);
        try{ var u=this.getUrl(); if(hit(u)){
          var hs=""; try{ var L=this.getHeaders(); if(L){var it=L.iterator(); while(it.hasNext()){var h=it.next(); hs+="\n    "+h.getName()+": "+h.getValue();}}}catch(e){hs="<hdr "+e+">";}
          var body=null; try{var b=this.getBody(); if(b){var os=BAOS.$new(); b.writeTo(os); body=bodyInfo(os.toByteArray());}}catch(e){body="<"+e+">";}
          send("===REGISTER REQ===\n"+this.getMethod()+" "+u+"\n  HEADERS:"+hs+"\n  BODY "+body+"\n===END===");
        }}catch(e){}
        return r;
      };
    });
    send("retrofit hook ok");
  }catch(e){ send("retrofit X "+e); }
});
