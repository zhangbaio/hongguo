// 双 hook: 1) libEncryptor .mytext 入口捕获密钥寄存器  2) MediaCodec 抓明文
'use strict';

// === Part 1: libEncryptor hook ===
function findEncryptorBase() {
  var base = null;
  ['r--','r-x'].forEach(function(perm) {
    if (base) return;
    Process.enumerateRanges(perm).forEach(function(r){
      if (base) return;
      if (r.file && r.file.path && r.file.path.indexOf('libEncryptor.so')>=0 && !r.file.offset)
        base = r.base;
    });
  });
  return base;
}

var encBase = findEncryptorBase();
send({t:'enc_base', v: encBase ? encBase.toString() : 'null'});

if (encBase) {
  var entry = encBase.add(0x7d8c);
  try {
    Interceptor.attach(entry, {
      onEnter: function(a) {
        // x0=this/context, x1=输入buf(spade_a?), x2=输入长度, x3=输出buf
        var info = {x0:a[0].toString(),x1:a[1].toString(),x2:a[2].toString(),x3:a[3].toString()};
        // 读各参数指向的数据
        [0,1,2,3].forEach(function(i){
          try {
            var mem = a[i].readByteArray(48);
            if(mem) info['x'+i+'_data']=Array.from(new Uint8Array(mem)).map(function(v){return(v<16?'0':'')+v.toString(16)}).join('');
          }catch(e){}
        });
        send({t:'ENC_ENTER', info:info});
        this._args=[a[0],a[1],a[2],a[3]];
      },
      onLeave: function(r) {
        // 返回后检查 x0..x3 和之前的缓冲变化
        var info={ret:r.toString()};
        if (this._args) {
          [0,1,2,3].forEach(function(i){
            try {
              var mem=this._args[i].readByteArray(48);
              if(mem) info['x'+i+'_after']=Array.from(new Uint8Array(mem)).map(function(v){return(v<16?'0':'')+v.toString(16)}).join('');
            }catch(e){}
          }.bind(this));
        }
        send({t:'ENC_LEAVE', info:info});
      }
    });
    send({t:'enc_hooked', addr:entry.toString()});
  } catch(e) { send({t:'enc_hook_err', e:''+e}); }
}

// === Part 2: MediaCodec hook ===
var fv = null; var vBytes=0;
Java.perform(function(){
  try {
    var FileOutputStream=Java.use('java.io.FileOutputStream');
    fv=FileOutputStream.$new('/data/local/tmp/mc_video.h265',false);
  }catch(e){}

  var MC=Java.use('android.media.MediaCodec');
  MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){
    if(size>4){
      try{
        var name=this.getName().toLowerCase();
        if(name.indexOf('hevc')>=0||name.indexOf('bytevc')>=0){
          var bb=this.getInputBuffer(idx); bb.position(off);
          var a=Java.array('byte',new Array(size).fill(0)); bb.get(a);
          if(fv){fv.write(a,0,size); vBytes+=size;}
          if(vBytes<=512) send({t:'MC_first',size:size,flags:flags,vBytes:vBytes});
        }
      }catch(e){}
    }
    return this.queueInputBuffer(idx,off,size,pts,flags);
  };
  send({t:'mc_hooked'});
});

// 每8秒汇报
setInterval(function(){
  send({t:'tick', vBytes:vBytes, enc_hooked:!!encBase});
}, 8000);
