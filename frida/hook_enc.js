// Hook libEncryptor.so: 1) RegisterNatives; 2) memcpy 16B from libEncryptor; 3) 扫函数入口
'use strict';

var encMod = Process.findModuleByName('libEncryptor.so');
var avmdlMod = Process.findModuleByName('libavmdlv2.so');
send({t:'mods', enc: encMod ? encMod.base + ' sz=' + encMod.size : 'NOT LOADED',
               avmdl: avmdlMod ? avmdlMod.base + ' sz=' + avmdlMod.size : 'NOT LOADED'});

// 扫 libEncryptor.so .text 区间的 ARM64 函数入口 (STP X29, X30, [SP, #-n]! = F4 pattern)
if (encMod) {
  var base = encMod.base;
  var code = base.add(0xb00);  // .text offset
  var codeSize = 0x71ec;       // .text size
  var found = [];
  // ARM64 prologue: STP X29, X30, [SP, #-n]! = 0xFD7BnnA9 or 0xFD7BnnA8 family
  // pattern: bytes 2-3 = 0x7B FD (little-endian: bytes[0]=??, bytes[1]=??, bytes[2]=0x7B, bytes[3]=0xA9 or 0xA8)
  try {
    var textBytes = Memory.readByteArray(code, codeSize);
    var u8 = new Uint8Array(textBytes);
    for (var i = 0; i + 3 < codeSize; i += 4) {
      // STP X29, X30, [SP, ...]!: last two bytes = A9 or A8 (stores pair), bytes[1]=7B, bytes[0] has SP offset
      if (u8[2+i] === 0x7B && (u8[3+i] === 0xA9 || u8[3+i] === 0xA8)) {
        var fnAddr = code.add(i);
        found.push(fnAddr);
      }
    }
    send({t:'fn_scan', count: found.length, addrs: found.slice(0,30).map(a=>a.toString())});
    // Hook first 40 functions: log first 3 args (x0..x2) on enter + return value on leave
    found.slice(0, 40).forEach(function(fn, idx) {
      Interceptor.attach(fn, {
        onEnter: function(a) {
          this.fn = fn; this.idx = idx;
          var args = []; for (var i=0;i<4;i++) try{args.push(a[i].toString());}catch(e){args.push('?');}
          this.args = args;
        },
        onLeave: function(r) {
          // 尝试读 a[0] 指针处的16字节(可能是输出缓冲)
          try {
            var out = Memory.readByteArray(this.args[0] !== '?' ? ptr(this.args[0]) : this.fn, 16);
            var h = Array.from(new Uint8Array(out)).map(x=>(x<16?'0':'')+x.toString(16)).join('');
            if (h !== '00000000000000000000000000000000')
              send({t:'fn_call', fn: this.fn.toString(), idx: this.idx, args: this.args, out: h, ret: r.toString()});
          } catch(e){}
        }
      });
    });
  } catch(e) { send({t:'err', e:''+e}); }
}

// Hook JNI RegisterNatives - Java.perform + setTimeout 确保 JNI env 可用
Java.perform(function() {
  setTimeout(function() {
    try {
      var envHandle = Java.vm.getEnv().handle;
      var fnTable = envHandle.readPointer();
      var regNat = fnTable.add(215 * Process.pointerSize).readPointer();
      Interceptor.attach(regNat, {
        onEnter: function(a) {
          try {
            var n = parseInt(a[3]);
            var methods = a[2];
            var env = Java.vm.getEnv();
            var cls = env.getClassName(a[1]);
            for (var i = 0; i < n && i < 20; i++) {
              var nm = methods.add(i*24).readPointer().readCString();
              var sig = methods.add(i*24+8).readPointer().readCString();
              var fn = methods.add(i*24+16).readPointer();
              var inE = encMod && fn.compare(encMod.base)>=0 && fn.compare(encMod.base.add(encMod.size))<0;
              if (inE) send({t:'native_method', cls:cls, name:nm, sig:sig, fn:fn.toString()});
            }
          } catch(e) {}
        }
      });
    } catch(e) { send({t:'err2', e:''+e}); }
    send({t:'info', msg:'hooks installed'});

    // Hook memcpy 过滤 dst 的写入为16字节且 src 在 enc 范围内
    var mc = Module.findExportByName('libc.so','memcpy');
    if (mc && encMod) {
      Interceptor.attach(mc, {
        onEnter: function(a) {
          this.dst=a[0]; this.src=a[1]; this.sz=parseInt(a[2]);
        },
        onLeave: function() {
          var inE = encMod && this.src.compare(encMod.base)>=0 && this.src.compare(encMod.base.add(encMod.size))<0;
          if (inE && this.sz >= 12 && this.sz <= 48) {
            try {
              var b = Array.from(new Uint8Array(this.dst.readByteArray(this.sz)));
              var h = b.map(x=>(x<16?'0':'')+x.toString(16)).join('');
              send({t:'memcpy_enc', sz:this.sz, bytes:h, src: this.src.toString()});
            } catch(e) {}
          }
        }
      });
    }
  }, 300);
});
