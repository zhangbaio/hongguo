'use strict';
Java.perform(function(){
  function dump(cn){
    try{ var C=Java.use(cn); var M=C.class.getDeclaredMethods();
      var nat=[],all=[];
      for(var i=0;i<M.length;i++){ var m=M[i]; var mod=java.lang.reflect.Modifier; var sig=m.getName()+"("+m.getParameterTypes().length+")";
        if(mod.isNative(m.getModifiers())) nat.push(sig); all.push(sig); }
      send(cn+" native方法: ["+nat.join(", ")+"]");
      send(cn+" 全部方法: ["+all.slice(0,25).join(", ")+"]");
    }catch(e){ send(cn+" X "+e); }
  }
  // 找 ms.bd.c.* 里有 native 方法的类
  var hits=[];
  try{ Java.enumerateLoadedClassesSync().forEach(function(n){
    if(/^ms\.bd\.c\./.test(n) && n.split(".").length<=5){
      try{ var C=Java.use(n); var M=C.class.getDeclaredMethods();
        for(var i=0;i<M.length;i++){ if(java.lang.reflect.Modifier.isNative(M[i].getModifiers())){ hits.push(n+"."+M[i].getName()); } }
      }catch(e){}
    }
  }); }catch(e){}
  send("ms.bd.c.* native方法: "+hits.slice(0,20).join(" | "));
  dump("ms.bd.c.m");
  dump("com.bytedance.mobsec.metasec.ml.MS");
});
