// 枚举解密相关的类+方法(可主动调用的). 不需要视频在播。
'use strict';
Java.perform(function(){
  var KW=['spade','decrypt','crypto','dragon','contentkey','drmkey','cipher','aes',
          'encryptor','getkey','vmpkey','playauth','token2key','keyseed','des'];
  var hitClasses={};
  function consider(name){
    var l=name.toLowerCase();
    for(var i=0;i<KW.length;i++) if(l.indexOf(KW[i])>=0) return true;
    return false;
  }
  // 枚举所有 classloader 的已加载类
  var loaders=[];
  try{ Java.enumerateClassLoadersSync().forEach(function(cl){loaders.push(cl);}); }catch(e){}
  send({t:'info',msg:'classloaders='+loaders.length});

  var classes=[];
  try{ Java.enumerateLoadedClassesSync().forEach(function(n){ if(consider(n)) classes.push(n); }); }catch(e){send({t:'err',e:''+e});}
  send({t:'classes',count:classes.length});

  // 对每个命中类, 列出方法签名(尤其 native / 吃String或byte[]/返回byte[]或String)
  var shown=0;
  classes.forEach(function(cn){
    if(shown>60) return;
    try{
      var C=Java.use(cn);
      var meths=C.class.getDeclaredMethods();
      var interesting=[];
      for(var i=0;i<meths.length;i++){
        var m=meths[i]; var sig=m.toString();
        var isNative=sig.indexOf('native')>=0;
        var l=sig.toLowerCase();
        var takesData=l.indexOf('byte[]')>=0||l.indexOf('java.lang.string')>=0;
        var keyish=/decrypt|spade|key|crypt|cipher|process|transform|sign|auth/.test(l);
        if((isNative||takesData)&&keyish) interesting.push(sig);
      }
      if(interesting.length){
        shown++;
        send({t:'cls',name:cn,meths:interesting.slice(0,12)});
      }
    }catch(e){}
  });
  send({t:'done',shown:shown});
});
