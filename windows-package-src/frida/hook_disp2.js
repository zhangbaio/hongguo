'use strict';
Java.perform(function(){
  var m=Process.findModuleByName("libmetasec_ml.so"); if(!m){send("metasec未加载");return;}
  var env=Java.vm.getEnv(), tab=env.handle.readPointer();
  var GetStrUTF=new NativeFunction(tab.add(169*Process.pointerSize).readPointer(),'pointer',['pointer','pointer','pointer']);
  var GetObjClass=new NativeFunction(tab.add(31*Process.pointerSize).readPointer(),'pointer',['pointer','pointer']);
  // jclass->name via reflection 复杂, 改用: 对 jobject 调 toString 太重; 简单读其 class 名
  var seen={};
  Interceptor.attach(m.base.add(0x26e684),{
    onEnter:function(a){ try{
      var op=a[2].toInt32();
      var s=""; if(!a[5].isNull()){ try{var c=GetStrUTF(a[0],a[5],ptr(0)); if(!c.isNull()) s=c.readCString();}catch(e){} }
      // arg6 jobject: 读它的 class 名
      var ocls="null";
      if(!a[6].isNull()){ try{ var jc=GetObjClass(a[0],a[6]);
        // class.getName: 用 Java 侧 cast 太重; 这里只标记非空
        ocls="obj@"+a[6]; }catch(e){ ocls="obj?"; } }
      var k=op+"|"+(s.length>0)+"|"+(a[6].isNull()?0:1);
      if(!seen[k]){ seen[k]=1; send("D op=0x"+op.toString(16)+" int1="+a[3].toInt32()+" long="+a[4]+" str="+(s?("「"+s.slice(0,60)+"」"):"-")+" obj="+(a[6].isNull()?"null":"非空")); }
    }catch(e){} }
  });
  send("disp2 ready");
});
