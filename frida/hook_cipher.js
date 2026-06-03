'use strict';
function hex(b){if(!b)return'';var u=new Uint8Array(b);var s='';for(var i=0;i<u.length;i++)s+=(u[i]<16?'0':'')+u[i].toString(16);return s;}
Java.perform(function(){
  var Cipher=Java.use('javax.crypto.Cipher');
  var SKS=Java.use('javax.crypto.spec.SecretKeySpec');
  var IPS=Java.use('javax.crypto.spec.IvParameterSpec');
  var B64=Java.use('android.util.Base64');
  // init: 记录算法+key+iv
  Cipher.init.overload('int','java.security.Key','java.security.spec.AlgorithmParameterSpec').implementation=function(m,k,p){
    try{var ka=Java.cast(k,SKS); var kb=ka.getEncoded(); var alg=this.getAlgorithm();
      var iv='';try{var ip=Java.cast(p,IPS); iv=hex(ip.getIV());}catch(e){}
      send({t:'CINIT', alg:alg, mode:m, key:hex(kb), iv:iv});}catch(e){}
    return this.init(m,k,p);
  };
  Cipher.init.overload('int','java.security.Key').implementation=function(m,k){
    try{var ka=Java.cast(k,SKS); send({t:'CINIT', alg:this.getAlgorithm(), mode:m, key:hex(ka.getEncoded()), iv:''});}catch(e){}
    return this.init(m,k);
  };
  // doFinal(byte[]): 记录输入/输出
  Cipher.doFinal.overload('[B').implementation=function(inp){
    var out=this.doFinal(inp);
    try{var ih=hex(inp), oh=hex(out);
      // 只报短数据(密钥级, <=64字节), 过滤大块视频/网络数据
      if(inp&&inp.length<=64) send({t:'DOFINAL', alg:this.getAlgorithm(), inlen:inp.length, in:ih, outlen:out.length, out:oh});
    }catch(e){}
    return out;
  };
  send({t:'ready', msg:'Cipher hook 已挂; 打开全新视频'});
});
