// AVMDL 手动CTR: AES_set_encrypt_key(key,bits,ctx) + AES_encrypt(counter,out,ctx)。
// 用 ctx 指针关联 -> 直接拿 内容密钥 + counter(IV)。base+offset 绕 namespace。
'use strict';
var OFF={set_enc:0xf59e0, set_dec:0xf5a54, aes_enc:0xf5950, aes_dec:0xf5998};
function findBase(name){
  var b=null;['r-x','r--'].forEach(function(p){if(b)return;Process.enumerateRanges(p).forEach(function(r){
    if(b)return;if(r.file&&r.file.path&&r.file.path.indexOf(name)>=0&&!r.file.offset)b=r.base;});});
  var m=Process.findModuleByName(name); return b||(m?m.base:null);
}
var base=findBase('libttcrypto.so');
send({t:'base',v:base?base.toString():'null'});
if(base){
function hx(p,n){try{return Array.from(new Uint8Array(p.readByteArray(n))).map(function(x){return(x<16?'0':'')+x.toString(16)}).join('');}catch(e){return'?';}}
var ctx2key={};        // AES_KEY* -> key hex
var ctxFirstCtr={};    // AES_KEY* -> 是否已报首个counter
var seenKey={};
function H(name,off,fn){try{Interceptor.attach(base.add(off),{onEnter:fn});send({t:'hooked',f:name});}catch(e){send({t:'hookfail',f:name,e:''+e});}}

H('AES_set_encrypt_key',OFF.set_enc,function(a){
  var bits=a[1].toInt32(); if(bits<=0||bits>256)bits=128;
  var key=hx(a[0],bits/8); var ctx=a[2].toString();
  ctx2key[ctx]=key;
  if(!seenKey[key]){seenKey[key]=1; send({t:'KEY',src:'set_encrypt',bits:bits,key:key,ctx:ctx});}
});
H('AES_set_decrypt_key',OFF.set_dec,function(a){
  var bits=a[1].toInt32(); if(bits<=0||bits>256)bits=128;
  var key=hx(a[0],bits/8); var ctx=a[2].toString(); ctx2key[ctx]=key;
  if(!seenKey['d'+key]){seenKey['d'+key]=1; send({t:'KEY',src:'set_decrypt',bits:bits,key:key,ctx:ctx});}
});
// AES_encrypt(in, out, AES_KEY*) : in=counter块. 报每个ctx的前2个counter(=IV基准)
H('AES_encrypt',OFF.aes_enc,function(a){
  var ctx=a[2].toString();
  var c=(ctxFirstCtr[ctx]||0);
  if(c<2){ctxFirstCtr[ctx]=c+1;
    send({t:'CTR',ctx:ctx,counter:hx(a[0],16),key:ctx2key[ctx]||'?'});}
});
send({t:'ready',msg:'hooks on; 播放在线视频解码'});
}
