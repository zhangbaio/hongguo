// hook libavmdlv2 全部15个引用AES S-box的函数, 记录触发次数+前几个16字节参数。
'use strict';
var OFFS=[0x53c0a0,0x54039c,0x546028,0x54ad30,0x53d77c,0x548d48,0x54c7ec,0x53d8b8,
          0x548854,0x542e60,0x4061a0,0x5489d0,0x53cff4,0x549330,0x549494];
function findBase(name){var b=null;['r-x','r--'].forEach(function(p){if(b)return;Process.enumerateRanges(p).forEach(function(r){
  if(b)return;if(r.file&&r.file.path&&r.file.path.indexOf(name)>=0&&!r.file.offset)b=r.base;});});
  var m=Process.findModuleByName(name);return b||(m?m.base:null);}
var base=findBase('libavmdlv2.so');
send({t:'base',v:base?base.toString():'null'});
if(base){
function hx(p,n){try{return Array.from(new Uint8Array(p.readByteArray(n))).map(function(x){return(x<16?'0':'')+x.toString(16)}).join('');}catch(e){return'?';}}
var calls={}; var argseen={};
OFFS.forEach(function(off){
  var name='0x'+off.toString(16); calls[name]=0;
  try{
    Interceptor.attach(base.add(off),{onEnter:function(a){
      calls[name]=(calls[name]||0)+1;
      if(calls[name]<=4){ // 前4次记录参数
        for(var i=0;i<3;i++){var h=hx(a[i],16);var k=name+'|'+i+'|'+h;
          if(h!=='?'&&!argseen[k]){argseen[k]=1;send({t:'ARG',fn:name,argi:i,hex:h});}}
      }
    }});
  }catch(e){send({t:'hookfail',fn:name,e:''+e});}
});
send({t:'ready',msg:'15 hooks; 播放在线视频'});
setInterval(function(){
  var fired={};for(var k in calls)if(calls[k]>0)fired[k]=calls[k];
  send({t:'stats',fired:fired});
},10000);
}
