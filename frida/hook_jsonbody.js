// 在加密前抓明文: hook org.json.JSONObject.toString(), 过滤 device_register/applog 标记。
'use strict';
Java.perform(function(){
  function tag(s){ return s.indexOf("magic_tag")>=0||s.indexOf("ss_app_log")>=0||(s.indexOf("\"header\"")>=0&&s.indexOf("device_model")>=0)||s.indexOf("display_name")>=0; }
  try{
    var JO=Java.use("org.json.JSONObject");
    JO.toString.overload().implementation=function(){
      var s=this.toString.apply(this,arguments);
      try{ if(s&&s.length>200&&tag(s)) send("###JSON###\n"+s.slice(0,3000)+"\n###END###"); }catch(e){}
      return s;
    };
    JO.toString.overload('int').implementation=function(i){
      var s=this.toString.apply(this,arguments);
      try{ if(s&&s.length>200&&tag(s)) send("###JSON###\n"+s.slice(0,3000)+"\n###END###"); }catch(e){}
      return s;
    };
    send("org.json.JSONObject.toString hooked");
  }catch(e){ send("JSONObject X "+e); }
  // 兜底: HashMap-> applog 也可能用 GSON/手拼; 再 hook String(byte[]) 看明文
  try{
    var S=Java.use("java.lang.String");
    S.$init.overload('[B').implementation=function(b){
      var r=this.$init.apply(this,arguments);
      try{ if(b&&b.length>300){ var s=this.toString(); if(s.indexOf("magic_tag")>=0||s.indexOf("display_name")>=0) send("###JSON(str)###\n"+s.slice(0,3000)+"\n###END###"); } }catch(e){}
      return r;
    };
    send("String([B) hooked");
  }catch(e){ send("String X "+e); }
  send("jsonbody ready");
});
