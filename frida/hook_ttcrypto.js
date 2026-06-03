// hook libttcrypto(BoringSSL) AES/EVP 密钥初始化, base+offset(绕过namespace隔离), 直接读 key+iv。
'use strict';
var OFF={
  "AES_set_encrypt_key":0xf59e0,"AES_set_decrypt_key":0xf5a54,"AES_ctr128_encrypt":0xf6124,
  "EVP_DecryptInit_ex":0x1000e8,"EVP_CipherInit_ex":0xffeb4,"EVP_DecryptInit":0x1006d4,
  "EVP_CipherInit":0x100688,"AES_unwrap_key":0xf5cd8
};
function findBase(name){
  var b=null;['r-x','r--'].forEach(function(p){if(b)return;Process.enumerateRanges(p).forEach(function(r){
    if(b)return;if(r.file&&r.file.path&&r.file.path.indexOf(name)>=0&&!r.file.offset)b=r.base;});});
  var m=Process.findModuleByName(name); return b||(m?m.base:null);
}
var base=findBase('libttcrypto.so');
send({t:'base',v:base?base.toString():'null'});
if(!base){send({t:'err',e:'libttcrypto not found'});}
else{
function hx(p,n){try{return Array.from(new Uint8Array(p.readByteArray(n))).map(function(x){return(x<16?'0':'')+x.toString(16)}).join('');}catch(e){return'?';}}
var seen={};
function rep(o){var k=o.src+(o.key||'')+(o.iv||'');if(seen[k])return;seen[k]=1;send(o);}
function H(name,off,fn){try{Interceptor.attach(base.add(off),{onEnter:fn});send({t:'hooked',f:name});}catch(e){send({t:'hookfail',f:name,e:''+e});}}

H('AES_set_encrypt_key',OFF.AES_set_encrypt_key,function(a){
  var bits=a[1].toInt32(); rep({t:'KEY',src:'AES_set_encrypt_key',bits:bits,key:hx(a[0],bits>0&&bits<=256?bits/8:16)});});
H('AES_set_decrypt_key',OFF.AES_set_decrypt_key,function(a){
  var bits=a[1].toInt32(); rep({t:'KEY',src:'AES_set_decrypt_key',bits:bits,key:hx(a[0],bits>0&&bits<=256?bits/8:16)});});
H('EVP_DecryptInit_ex',OFF.EVP_DecryptInit_ex,function(a){
  var key=a[3].isNull()?'':hx(a[3],16),iv=a[4].isNull()?'':hx(a[4],16); if(key)rep({t:'KEY',src:'EVP_DecryptInit_ex',bits:128,key:key,iv:iv});});
H('EVP_CipherInit_ex',OFF.EVP_CipherInit_ex,function(a){
  var key=a[3].isNull()?'':hx(a[3],16),iv=a[4].isNull()?'':hx(a[4],16); if(key)rep({t:'KEY',src:'EVP_CipherInit_ex',bits:128,key:key,iv:iv});});
H('AES_ctr128_encrypt',OFF.AES_ctr128_encrypt,function(a){ rep({t:'CTR',iv:hx(a[4],16),len:a[2].toInt32()});});
H('AES_unwrap_key',OFF.AES_unwrap_key,function(a){ send({t:'UNWRAP',inhex:hx(a[3],40)});});
send({t:'ready',msg:'hooks installed (各独立), play/decode online video now'});
}
