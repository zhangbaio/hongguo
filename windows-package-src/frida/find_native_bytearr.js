// 枚举所有已加载类里 涉及 byte[] 的 native 方法(混淆类也能抓). 这些是底层加解密原语。
'use strict';
Java.perform(function(){
  var Modifier=Java.use('java.lang.reflect.Modifier');
  var all=Java.enumerateLoadedClassesSync();
  send({t:'total',n:all.length});
  var out=[]; var scanned=0;
  for(var ci=0;ci<all.length;ci++){
    var cn=all[ci];
    // 跳过明显无关的系统包
    if(/^(android\.|java\.|javax\.|sun\.|com\.android\.|androidx\.|kotlin|org\.|dalvik|libcore)/.test(cn)) continue;
    scanned++;
    try{
      var C=Java.use(cn);
      var meths=C.class.getDeclaredMethods();
      for(var i=0;i<meths.length;i++){
        var m=meths[i];
        if(!Modifier.isNative.call(Modifier,m.getModifiers())) continue;
        var sig=m.toString();
        if(sig.indexOf('byte[]')<0) continue; // 只要涉及 byte[]
        out.push(sig);
        if(out.length>=200) break;
      }
      C.$dispose&&C.$dispose();
    }catch(e){}
    if(out.length>=200) break;
  }
  send({t:'scanned',n:scanned,native_bytearr:out.length});
  out.forEach(function(s){ send({t:'m',sig:s}); });
  send({t:'done'});
});
