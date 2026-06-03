// hook libavmdlv2 的 AES-128 密钥扩展 FUN_0053d77c(out, key) -> x1=原始16字节内容密钥。
// base+offset 绕 namespace。同时 hook 周边AES函数找 counter(IV)。
'use strict';
var KEYEXP=0x53d77c;  // Ghidra定位: AES-128 key expansion, param_2=raw key
function findBase(name){
  var b=null;['r-x','r--'].forEach(function(p){if(b)return;Process.enumerateRanges(p).forEach(function(r){
    if(b)return;if(r.file&&r.file.path&&r.file.path.indexOf(name)>=0&&!r.file.offset)b=r.base;});});
  var m=Process.findModuleByName(name);return b||(m?m.base:null);
}
var base=findBase('libavmdlv2.so');
send({t:'base',v:base?base.toString():'null'});
if(base){
function hx(p,n){try{return Array.from(new Uint8Array(p.readByteArray(n))).map(function(x){return(x<16?'0':'')+x.toString(16)}).join('');}catch(e){return'?';}}
var seen={};
try{
  Interceptor.attach(base.add(KEYEXP),{onEnter:function(a){
    var key=hx(a[1],16);          // param_2 = raw key
    if(key&&key!=='?'&&!seen[key]){seen[key]=1;
      send({t:'KEY',key:key,out:a[0].toString()});}
  }});
  send({t:'hooked',f:'AES_keyexp@0x53d77c'});
}catch(e){send({t:'hookfail',e:''+e});}
send({t:'ready',msg:'hook on; 播放在线视频解码 -> 抓内容密钥'});
}
