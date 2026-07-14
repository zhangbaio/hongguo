// 查看 EncryptorUtil 方法, hook 其 native (byte[],int)->byte[] 捕获输入输出
'use strict';
Java.perform(function(){
  var CN='com.bytedance.frameworks.encryptor.EncryptorUtil';
  var C;
  try{C=Java.use(CN);}catch(e){send({t:'err',e:'no class:'+e});return;}
  var ms=C.class.getDeclaredMethods();
  ms.forEach(function(m){ send({t:'method',sig:m.toString()}); });
  // hook 所有 (byte[], int)->byte[] 或 native 方法, 捕获输入输出
  function hxb(arr){try{var b=Java.array('byte',arr);return '';}catch(e){return '';}}
  function b2h(jarr){var s='';var n=Math.min(jarr.length,64);for(var i=0;i<n;i++){var v=jarr[i]&0xff;s+=(v<16?'0':'')+v.toString(16);}return s+(jarr.length>64?'..(+'+(jarr.length-64)+')':'');}
  ms.forEach(function(m){
    var nm=m.getName(); var sig=m.toString();
    if(sig.indexOf('byte[]')<0) return;
    try{
      // 重载可能多个, hook 名字
      var ov=C[nm].overloads;
      ov.forEach(function(o){
        o.implementation=function(){
          var args=arguments;
          var info={m:nm,nargs:args.length};
          for(var i=0;i<args.length;i++){
            try{ if(args[i]&&args[i].length!==undefined&&typeof args[i][0]==='number') info['a'+i]='bytes['+args[i].length+']:'+b2h(args[i]);
                 else info['a'+i]=''+args[i]; }catch(e){info['a'+i]='?';}
          }
          var r=o.apply(this,args);
          try{ if(r&&r.length!==undefined) info['ret']='bytes['+r.length+']:'+b2h(r); else info['ret']=''+r; }catch(e){}
          send({t:'CALL',info:info});
          return r;
        };
      });
      send({t:'hooked',m:nm});
    }catch(e){send({t:'hookerr',m:nm,e:''+e});}
  });
  send({t:'ready'});
});
