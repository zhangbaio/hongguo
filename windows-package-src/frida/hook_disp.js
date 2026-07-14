'use strict';
// hook libmetasec+0x26e684 (native 分发器 a), 抓 op + jstring 参数(url) + 返回
Java.perform(function(){
  var m=Process.findModuleByName("libmetasec_ml.so");
  if(!m){ send("libmetasec未加载"); return; }
  var addr=m.base.add(0x26e684);
  send("hook 分发器 @ "+addr+" (base="+m.base+")");
  var env=Java.vm.getEnv();
  var tab=env.handle.readPointer();
  var GetStringUTFChars=new NativeFunction(tab.add(169*Process.pointerSize).readPointer(),'pointer',['pointer','pointer','pointer']);
  var seen={};
  Interceptor.attach(addr,{
    onEnter:function(a){
      try{
        var op=a[2].toInt32();
        var sArg=a[5];  // jstring
        var s="";
        if(!sArg.isNull()){ try{ var c=GetStringUTFChars(a[0],sArg,ptr(0)); if(!c.isNull()){ s=c.readCString(); } }catch(e){} }
        var key=op+"_"+(s?(s.length>20):0);
        if(!seen[key] || (s && s.indexOf("http")>=0)){ seen[key]=1;
          send("DISP op="+op+" (0x"+op.toString(16)+") str="+(s?("「"+s.slice(0,90)+"」"):"null"));
        }
      }catch(e){}
    }
  });
  send("分发器 hook ready");
});
