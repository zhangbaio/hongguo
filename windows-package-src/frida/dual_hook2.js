// 改进版双 hook:
// 1. Hook MediaCodec.flush() → flush后重置文件并开始抓帧(捕获IDR)
// 2. Hook libEncryptor.so 所有函数入口 + .mytext
'use strict';

var fv = null, vBytes=0, captureActive=false, flushCount=0;
var encBase = null;

// === libEncryptor base ===
function findEncBase() {
  var b=null;
  Process.enumerateRanges('r--').forEach(function(r){
    if(b)return;
    if(r.file&&r.file.path&&r.file.path.indexOf('libEncryptor.so')>=0&&!r.file.offset) b=r.base;
  });
  return b;
}
encBase=findEncBase();
send({t:'enc_base',v:encBase?encBase.toString():'null'});

// Hook libEncryptor .text 所有函数入口 (ARM64 prologue: STP X29,X30 / SUB SP)
if(encBase){
  var textOff=0xb00; var textSz=0x71ec;  // .text
  var myOff=0x7d8c;  var mySz=344;  // .mytext
  [[textOff,textSz],[myOff,mySz]].forEach(function(seg){
    var start=encBase.add(seg[0]); var sz=seg[1];
    try{
      var code=new Uint8Array(Memory.readByteArray(start,sz));
      for(var i=0;i+3<sz;i+=4){
        var w=code[i]|(code[i+1]<<8)|(code[i+2]<<16)|(code[i+3]<<24);
        // SUB SP,SP,#n = 0xD10__3FF or STP prologue = 0xA90..FD
        var isSUB=(w&0xFFC003FF)===0xD10003FF;
        if(isSUB){
          var addr=start.add(i);
          (function(a,off){
            try{
              Interceptor.attach(a,{
                onEnter:function(args){
                  var info={fn_off:'0x'+(seg[0]+off).toString(16)};
                  [0,1,2,3].forEach(function(ri){
                    try{
                      var mem=args[ri].readByteArray(48);
                      if(mem)info['x'+ri]=Array.from(new Uint8Array(mem)).map(function(v){return(v<16?'0':'')+v.toString(16)}).join('');
                    }catch(e){}
                  });
                  send({t:'ENC_FN',info:info});
                }
              });
            }catch(e){}
          })(addr,i);
        }
      }
    }catch(e){send({t:'enc_scan_err',e:''+e});}
  });
  send({t:'enc_fns_hooked'});
}

// === MediaCodec hook ===
Java.perform(function(){
  var FileOutputStream=Java.use('java.io.FileOutputStream');

  function openFile(){
    try{if(fv){fv.flush();fv.close();}fv=FileOutputStream.$new('/data/local/tmp/mc_video.h265',false);}catch(e){}
    vBytes=0; captureActive=true;
    send({t:'file_reset',flushCount:flushCount});
  }
  openFile();

  var MC=Java.use('android.media.MediaCodec');

  // Hook flush: 新视频开始信号
  MC.flush.implementation=function(){
    flushCount++;
    openFile();
    send({t:'flush',n:flushCount,name:this.getName()});
    return this.flush();
  };

  // Hook queueInputBuffer
  MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){
    if(captureActive&&size>4){
      try{
        var name=this.getName().toLowerCase();
        if(name.indexOf('hevc')>=0||name.indexOf('bytevc')>=0||name.indexOf('h265')>=0){
          var bb=this.getInputBuffer(idx); bb.position(off);
          var a=Java.array('byte',new Array(size).fill(0)); bb.get(a);
          if(fv){fv.write(a,0,size); vBytes+=size;}
          if(vBytes<=2048) send({t:'first_frame',size:size,flags:flags,vBytes:vBytes,name:name});
        }
      }catch(e){}
    }
    return this.queueInputBuffer(idx,off,size,pts,flags);
  };

  send({t:'mc_hooked'});
});

setInterval(function(){
  send({t:'tick',vBytes:vBytes,flushCount:flushCount});
},8000);
