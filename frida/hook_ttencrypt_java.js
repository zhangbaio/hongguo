// hook Java 层 ttEncrypt(byte[])→ 入参即明文。加密类懒加载, 用 setInterval 重试直到命中。
'use strict';
function dump(tag, arr){
  try{ var u8=new Uint8Array(arr); var s="";
    for(var i=0;i<u8.length;i++){var c=u8[i]; s+=(c>=0x20&&c<0x7f)?String.fromCharCode(c):".";}
    if(s.indexOf("{")>=0) send("###PLAIN### "+tag+" len="+u8.length+"\n"+s.slice(0,1900)+"\n###END###");
  }catch(e){}
}
Java.perform(function(){
  var done=false, tries=0;
  var cands=["com.bytedance.frameworks.encryptor.EncryptorUtil",
             "com.bytedance.frameworks.core.encrypt.TTEncryptUtils",
             "com.ss.android.common.applog.TeaThread"];
  function hookClass(cn){
    var C; try{ C=Java.use(cn); }catch(e){ return 0; }
    var n=0;
    Object.getOwnPropertyNames(C.__proto__).forEach(function(m){
      if(m==="ttEncrypt"||m.toLowerCase()==="ttencrypt"||(m==="encrypt"&&cn.indexOf("ncrypt")>=0)){
        try{ C[m].overloads.forEach(function(ov){ ov.implementation=function(){
          try{ for(var i=0;i<arguments.length;i++){var a=arguments[i]; if(a&&a.length&&a.length>16) dump(cn+"."+m,a);} }catch(e){}
          return ov.apply(this,arguments);
        };}); n++; send("hooked "+cn+"."+m); }catch(e){}
      }
    });
    return n;
  }
  function attempt(){
    if(done) return;
    tries++;
    var got=0;
    cands.forEach(function(cn){ got+=hookClass(cn); });
    if(got===0 && tries%6===0){  // 每3秒做一次广扫(找含 ttEncrypt 方法的类)
      try{ Java.enumerateLoadedClassesSync().forEach(function(nm){
        if(!/encrypt|Encrypt/.test(nm)) return;
        if(/^(android|java|kotlin|androidx)/.test(nm)) return;
        got+=hookClass(nm);
      }); }catch(e){}
    }
    if(got>0){ done=true; send("ttEncrypt hooked, 停止重试 (tries="+tries+")"); }
    if(tries>120) { send("放弃重试"); clearInterval(t); }
  }
  var t=setInterval(attempt, 500);
  send("ttEncrypt(java) 重试 hook 启动");
});
