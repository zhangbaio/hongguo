// Hook native AMediaCodec_queueInputBuffer (libmediandk.so)
// 文件写到 app 可写的目录
'use strict';

var vFile = null, aFile = null;
var vBytes = 0, aBytes = 0;

// 也尝试 hook libavmdlv2.so 的 read 调用(读取解密后数据)
var mediandk = Process.findModuleByName('libmediandk.so');
if (mediandk) {
  send({t:'mod', name:'libmediandk.so', base:mediandk.base.toString(), size:mediandk.size});
} else {
  send({t:'err', e:'libmediandk.so not found'});
}

// 找 AMediaCodec_queueInputBuffer
var fn = Module.findExportByName('libmediandk.so', 'AMediaCodec_queueInputBuffer');
send({t:'fn', name:'AMediaCodec_queueInputBuffer', addr: fn ? fn.toString() : 'null'});

if (fn) {
  // AMediaCodec_queueInputBuffer(AMediaCodec *codec, size_t idx, ssize_t offset, size_t size, uint64_t presentationTimeUs, uint32_t flags)
  Interceptor.attach(fn, {
    onEnter: function(a) {
      this.codec = a[0]; this.idx = parseInt(a[1]); this.off = parseInt(a[2]);
      this.size = parseInt(a[3]); this.pts = a[4];
      this.flags = parseInt(a[5]);
    },
    onLeave: function(r) {
      if (this.size < 4) return;
      try {
        // AMediaCodec_getInputBuffer(codec, idx, &size) → 返回缓冲区指针
        var getbuf = Module.findExportByName('libmediandk.so','AMediaCodec_getInputBuffer');
        if (!getbuf) return;
        var sizePtr = Memory.alloc(8);
        var bufPtr = new NativeFunction(getbuf, 'pointer', ['pointer','size_t','pointer'])(this.codec, this.idx, sizePtr);
        if (bufPtr.isNull()) return;
        var data = bufPtr.add(this.off).readByteArray(Math.min(this.size, 256));
        var u8 = new Uint8Array(data);
        var h = Array.from(u8.slice(0,8)).map(x=>(x<16?'0':'')+x.toString(16)).join('');
        send({t:'native_qib', codec:this.codec.toString(), sz:this.size, flags:this.flags, head8:h});
      } catch(e) { send({t:'native_qib_err', e:''+e, sz:this.size}); }
    }
  });
  send({t:'info', msg:'AMediaCodec_queueInputBuffer hooked'});
}

// 也 hook AMediaCodec_start 看有哪些 codec
var startFn = Module.findExportByName('libmediandk.so', 'AMediaCodec_start');
if (startFn) {
  Interceptor.attach(startFn, {
    onEnter: function(a) { send({t:'codec_start', codec:a[0].toString()}); }
  });
}

// 列出 libmediandk.so 所有导出函数含 "queue"
var exports = Module.enumerateExports('libmediandk.so');
exports.forEach(function(e) {
  if (e.name.toLowerCase().indexOf('queue')>=0 || e.name.toLowerCase().indexOf('input')>=0) {
    send({t:'export', name:e.name, addr:e.address.toString()});
  }
});
