// hook libEncryptor.so 的 ttEncrypt(明文,len)→ dump device_register 明文 JSON。
// frida17: 不用 Module.findExportByName 全局形式; 用 setInterval 轮询模块加载。
'use strict';
var hooked=false;
function tryHook(){
  if(hooked) return true;
  var m=Process.findModuleByName("libEncryptor.so");
  if(!m) return false;
  var exps=m.enumerateExports().filter(function(e){ return /ncrypt/i.test(e.name); });
  send("libEncryptor exports: "+exps.map(function(e){return e.name;}).join(", "));
  exps.forEach(function(e){
    try{ Interceptor.attach(e.address,{
      onEnter:function(a){
        try{ var len=a[1].toInt32();
          if(len>0&&len<20000){
            var u8=new Uint8Array(a[0].readByteArray(len)); var s="";
            for(var i=0;i<u8.length;i++){var c=u8[i]; s+=(c>=0x20&&c<0x7f)?String.fromCharCode(c):".";}
            if(s.indexOf("{")>=0&&(s.indexOf("header")>=0||s.indexOf("magic")>=0||s.indexOf("device_model")>=0))
              send("###PLAINTEXT### fn="+e.name+" len="+len+"\n"+s.slice(0,1900)+"\n###END###");
          }
        }catch(err){}
      }
    }); }catch(err){ send("attach X "+e.name+" "+err); }
  });
  hooked=true; send("ttEncrypt hooked ("+exps.length+" exports)");
  return true;
}
if(!tryHook()){
  send("等待 libEncryptor 加载...");
  var t=setInterval(function(){ if(tryHook()) clearInterval(t); }, 150);
}
