Java.perform(function(){
  var Modifier = Java.use("java.lang.reflect.Modifier");
  var out=[];
  Java.enumerateLoadedClassesSync().forEach(function(n){
    if(/^(ms\.bd\.|com\.bytedance\.mobsec\.metasec)/.test(n) && n.indexOf("$")<0){
      try{
        var C=Java.use(n); var ms=C.class.getDeclaredMethods();
        for(var i=0;i<ms.length;i++){
          if(Modifier.isNative(ms[i].getModifiers())){
            var ps=ms[i].getParameterTypes(),pn=[];
            for(var j=0;j<ps.length;j++)pn.push(ps[j].getName());
            out.push(n+" :: "+ms[i].getReturnType().getName()+" "+ms[i].getName()+"("+pn.join(",")+")");
          }
        }
      }catch(e){}
    }
  });
  send("=== metasec native 方法 "+out.length+" 个 ===");
  out.slice(0,60).forEach(function(s){send(s);});
});
