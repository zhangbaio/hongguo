// 全路径 MediaCodec 明文抓取: Java + Native 双层 hook
// 文件路径已预创建为 777 权限
'use strict';

var VPATH = '/data/local/tmp/live_video.h265';
var APATH = '/data/local/tmp/live_audio.aac';
var vBytes = 0, aBytes = 0;
var fv = null, fa = null;

// Java 层 (如果用 Java MediaCodec)
Java.perform(function() {
  try {
    var FileOutputStream = Java.use('java.io.FileOutputStream');
    fv = FileOutputStream.$new(VPATH, false); // overwrite
    fa = FileOutputStream.$new(APATH, false);
    send({t:'files_ok'});
  } catch(e) { send({t:'file_err', e:''+e}); }

  var MC = Java.use('android.media.MediaCodec');
  MC.queueInputBuffer.implementation = function(idx, off, size, pts, flags) {
    if (size > 4) {
      try {
        var name = this.getName().toLowerCase();
        var bb = this.getInputBuffer(idx); bb.position(off);
        var a = Java.array('byte', new Array(size).fill(0)); bb.get(a);
        if (fv && (name.indexOf('hevc')>=0||name.indexOf('bytevc')>=0||name.indexOf('h265')>=0)) {
          fv.write(a,0,size); vBytes+=size;
          if(vBytes<=4096) send({t:'v_frame',n:vBytes,sz:size});
        } else if (fa && (name.indexOf('aac')>=0||name.indexOf('mp4a')>=0||name.indexOf('audio')>=0)) {
          fa.write(a,0,size); aBytes+=size;
        }
      } catch(e){}
    }
    return this.queueInputBuffer(idx,off,size,pts,flags);
  };
  send({t:'java_hook','msg':'queueInputBuffer hooked'});
});

// Native 层 (如果用 AMediaCodec)
var nfn = Module.findExportByName('libmediandk.so','AMediaCodec_queueInputBuffer');
var getbuf = Module.findExportByName('libmediandk.so','AMediaCodec_getInputBuffer');
var getbufFn = getbuf ? new NativeFunction(getbuf,'pointer',['pointer','size_t','pointer']) : null;

if (nfn) {
  Interceptor.attach(nfn, {
    onEnter: function(a) {
      this.codec=a[0]; this.idx=parseInt(a[1]); this.off=parseInt(a[2]);
      this.sz=parseInt(a[3]); this.pts=a[4]; this.flags=parseInt(a[5]);
    },
    onLeave: function(r) {
      if (this.sz<4 || !getbufFn) return;
      try {
        var sp=Memory.alloc(8);
        var bp=getbufFn(this.codec,this.idx,sp);
        if(bp.isNull()) return;
        var data=bp.add(this.off).readByteArray(this.sz);
        var u8=new Uint8Array(data);
        // 写文件: 用 Java FileOutputStream 不好, 直接用 libc write
        var writeFn=new NativeFunction(Module.findExportByName('libc.so','write'),'int',['int','pointer','size_t']);
        // 先开文件
        if (!this._vfd) {
          var openFn=new NativeFunction(Module.findExportByName('libc.so','open'),'int',['pointer','int','int']);
          var pathMem=Memory.allocUtf8String('/data/local/tmp/live_video_n.h265');
          this._vfd=openFn(pathMem,577,0o666); // O_WRONLY|O_CREAT|O_APPEND=577
        }
        writeFn(this._vfd,bp.add(this.off),this.sz);
        vBytes+=this.sz;
        if(vBytes<=4096) send({t:'n_frame',sz:this.sz,flags:this.flags});
      } catch(e){ send({t:'n_err',e:''+e}); }
    }
  });
  send({t:'native_hook',msg:'AMediaCodec_queueInputBuffer hooked'});
}

// 每3秒汇报
var tick=0;
var timer=setInterval(function(){
  tick++;
  send({t:'tick',tick:tick,vBytes:vBytes,aBytes:aBytes});
  if(tick>=20){
    clearInterval(timer);
    if(fv) try{fv.flush();fv.close();}catch(e){}
    if(fa) try{fa.flush();fa.close();}catch(e){}
    send({t:'done',vBytes:vBytes,aBytes:aBytes});
  }
},3000);
