// hook libavmdlv2 FUN_0053d890(ctx,key,iv) = AES-CTR init -> x1=内容密钥(16B), x2=IV(16B)
'use strict';
var CTRINIT=0x53d890, KEYEXP=0x53d77c;
function findBase(name){var b=null;['r-x','r--'].forEach(function(p){if(b)return;Process.enumerateRanges(p).forEach(function(r){
  if(b)return;if(r.file&&r.file.path&&r.file.path.indexOf(name)>=0&&!r.file.offset)b=r.base;});});
  var m=Process.findModuleByName(name);return b||(m?m.base:null);}
var base=findBase('libavmdlv2.so');
send({t:'base',v:base?base.toString():'null'});
if(base){
function hx(p,n){try{return Array.from(new Uint8Array(p.readByteArray(n))).map(function(x){return(x<16?'0':'')+x.toString(16)}).join('');}catch(e){return'?';}}
var seen={};
try{Interceptor.attach(base.add(CTRINIT),{onEnter:function(a){
  var key=hx(a[1],16),iv=hx(a[2],16);
  var k=key+iv; if(!seen[k]){seen[k]=1; send({t:'KEYIV',key:key,iv:iv,ctx:a[0].toString()});}
}});send({t:'hooked',f:'CTRinit@0x53d890'});}catch(e){send({t:'hookfail',e:''+e});}
// 备份: 也hook key扩展(x1=key)防 0053d890 内联/不命中
try{Interceptor.attach(base.add(KEYEXP),{onEnter:function(a){
  var key=hx(a[1],16); if(key&&!seen['ke'+key]){seen['ke'+key]=1; send({t:'KEYEXP',key:key});}
}});}catch(e){}
send({t:'ready',msg:'hook on; 播全新在线短剧'});
setInterval(function(){send({t:'tick'});},10000);
}
