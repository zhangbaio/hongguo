// 极轻量: 只枚举类名并过滤(不Java.use), 找加密相关类名
'use strict';
Java.perform(function(){
  try{
    var names=Java.enumerateLoadedClassesSync();
    send({t:'total',n:names.length});
    var hits=[];
    for(var i=0;i<names.length;i++){
      var n=names[i];
      if(/^(android|java|javax|kotlin|androidx|sun|com\.android|org\.|dalvik|libcore)/.test(n)) continue;
      var l=n.toLowerCase();
      if(l.indexOf('ncryptor')>=0||l.indexOf('ttcrypt')>=0||l.indexOf('mediakit')>=0||
         l.indexOf('ttmcrypt')>=0||l.indexOf('ttvideo')>=0&&l.indexOf('crypt')>=0||
         /\.crypto?$/.test(l)||l.indexOf('avmdl')>=0||l.indexOf('vcn')>=0&&l.indexOf('crypt')>=0)
        hits.push(n);
    }
    send({t:'hits',list:hits.slice(0,80)});
  }catch(e){send({t:'err',e:''+e});}
});
