// 抓 spade 解包 KEK + 内容密钥: hook libavmdl 解密分发器 + AES init。
// 分发器 FUN_00501b8c/00501c8c: param_1=ctx(key@+8, iv@+0x18), param_2->method(*param_2: 2=AES)
// AES init FUN_0053d890(ctx,key,iv): x1=key x2=iv ; CBC解密=FUN_0053e31c
'use strict';
var OFF = { disp1:0x501b8c, disp2:0x501c8c, ctrinit:0x53d890, cbc:0x53e31c, keyexp:0x53d77c };
function findBase(name){var b=null;['r-x','r--'].forEach(function(p){if(b)return;Process.enumerateRanges(p).forEach(function(r){
  if(b)return;if(r.file&&r.file.path&&r.file.path.indexOf(name)>=0&&!r.file.offset)b=r.base;});});
  var m=Process.findModuleByName(name);return b||(m?m.base:null);}
var base=findBase('libavmdlv2.so');
send({t:'base',v:base?base.toString():'null'});
function hx(p,n){try{return Array.from(new Uint8Array(p.readByteArray(n))).map(function(x){return(x<16?'0':'')+x.toString(16)}).join('');}catch(e){return'?';}}
var seen={};
function logkeyiv(tag, key, iv, method){
  var k=tag+key+iv; if(seen[k])return; seen[k]=1;
  send({t:'KEYIV', src:tag, method:method, key:key, iv:iv});
}
if(base){
  // 分发器: param_1=ctx; key=ctx+8, iv=ctx+0x18, method=*param_2
  [['disp1',OFF.disp1],['disp2',OFF.disp2]].forEach(function(d){
    try{Interceptor.attach(base.add(d[1]),{onEnter:function(a){
      var ctx=a[0]; var method=-1; try{method=a[1].readU8();}catch(e){}
      logkeyiv(d[0], hx(ctx.add(8),16), hx(ctx.add(0x18),16), method);
    }});}catch(e){send({t:'hookfail',f:d[0],e:''+e});}
  });
  // AES-CTR init: x1=key x2=iv
  try{Interceptor.attach(base.add(OFF.ctrinit),{onEnter:function(a){
    logkeyiv('ctrinit', hx(a[1],16), hx(a[2],16), -1);
  }});}catch(e){send({t:'hookfail',f:'ctrinit',e:''+e});}
  // CBC解密入口: param_1=ctx(轮密钥+iv@0xb0), param_2=data, param_3=len -> 记录data前16B(密文)+iv@0xb0
  try{Interceptor.attach(base.add(OFF.cbc),{onEnter:function(a){
    send({t:'CBC', ivchain:hx(a[0].add(0xb0),16), ct:hx(a[1],16), len:a[2].toInt32()});
  }});}catch(e){send({t:'hookfail',f:'cbc',e:''+e});}
  // AES解密块 FUN_0053dc84(param_1=块in/out, param_2=轮密钥表): in=密文块, sched前16B≈原始KEK
  try{Interceptor.attach(base.add(0x53dc84),{onEnter:function(a){
    this.blk=a[0]; this.cin=hx(a[0],16);
    send({t:'DECBLK', ct:this.cin, sched0:hx(a[1],16), sched_full:hx(a[1],176)});
  },onLeave:function(){ send({t:'DECBLK_OUT', pt:hx(this.blk,16)}); }});}catch(e){send({t:'hookfail',f:'decblk',e:''+e});}
  // 逐块 CTR 流解密 FUN_0053e1a0(ctx,data,len): 视频解码热路径; 若触发=libavmdl确在解密
  try{Interceptor.attach(base.add(0x53e1a0),{onEnter:function(a){
    if(!seen['ctr_run']){seen['ctr_run']=1; send({t:'CTR_RUN', len:a[2].toInt32(), data0:hx(a[1],16)});}
  }});}catch(e){send({t:'hookfail',f:'ctrrun',e:''+e});}
  send({t:'ready',msg:'hook on(分发器+CTRinit+CTRrun+CBC+AESdec); 打开全新视频'});
  setInterval(function(){send({t:'tick'});},15000);
}
