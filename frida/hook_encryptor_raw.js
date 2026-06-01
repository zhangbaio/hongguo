// 绕过 linker namespace 限制: 从 /proc/self/maps 手动读 libEncryptor.so 基址,
// 然后 hook .mytext 里的 BLR 调用点, 捕获寄存器值(可能含内容密钥)。
// .mytext 在文件 offset 0x7d8c, 共 4 个 BLR X8:
//   +0x54 (0x7de0): BLR X8 @ vtable[+1472] - 第一次调用
//   +0xA4 (0x7e30): BLR X8 @ vtable[+1408]
//   +0xC8 (0x7e54): BLR X8 @ vtable[+1664]
//   +0xF0 (0x7e7c): BLR X8 @ vtable[+1536] (×2)
'use strict';

function readMaps() {
  try {
    var f = new java.io.BufferedReader(new java.io.FileReader('/proc/self/maps'));
    var lines=[]; var l;
    while ((l=f.readLine())!==null) {
      if (l.indexOf('libEncryptor.so')>=0) lines.push(l);
    }
    f.close();
    return lines;
  } catch(e) { return []; }
}

Java.perform(function() {
  setTimeout(function() {
    var lines = readMaps();
    send({t:'maps', lines:lines.slice(0,4)});
    if (!lines.length) { send({t:'err', e:'libEncryptor.so not in maps'}); return; }
    // 第一行: executable (.text) 段 base
    var firstLine = lines.find(function(l){ return l.indexOf('r-xp')>=0||l.indexOf('r--p')>=0; }) || lines[0];
    var base = parseInt(firstLine.split('-')[0], 16);
    send({t:'base', v: base.toString(16)});

    // .mytext 在文件 offset 0x7d8c; 但在内存中的偏移取决于 LOAD segment
    // 通常 .text 和 .mytext 都在 rx segment (offset 0) → 内存偏移 = 文件偏移
    // base + 0x7d8c = .mytext 起始虚拟地址
    var mytext_base = ptr(base).add(0x7d8c);
    send({t:'mytext', v: mytext_base.toString()});

    // BLR X8 偏移 (相对 .mytext 起点)
    var BLR_OFFSETS = [0x54, 0xA4, 0xC8, 0xF0, 0x104]; // 几个 BLR 点
    BLR_OFFSETS.forEach(function(boff) {
      var addr = mytext_base.add(boff);
      // 验证是否是 BLR X8 (0x00013FD6 little-endian)
      try {
        var check = addr.readU32();
        send({t:'check', off:boff.toString(16), addr:addr.toString(), instr:check.toString(16)});
        if (check === 0xD63F0100) {  // BLR X8 = 0xD63F0100
          Interceptor.attach(addr, {
            onEnter: function(a) {
              // X0-X7: 参数寄存器, X8: 被调函数指针
              var regs={};
              ['x0','x1','x2','x3','x4','x5','x8'].forEach(function(r,i){
                try { regs[r]=this.context[r].toString(); } catch(e){}
              }.bind(this));
              // 尝试读 x0..x2 指向的数据(可能是 key buffer)
              var dat={};
              ['x0','x1','x2'].forEach(function(r){
                try {
                  var p=ptr(regs[r]);
                  dat[r+'_mem']=p.readByteArray(16)?Array.from(new Uint8Array(p.readByteArray(16))).map(function(x){return(x<16?'0':'')+x.toString(16)}).join(''):'?';
                } catch(e){}
              });
              send({t:'BLR', off:boff.toString(16), regs:regs, dat:dat});
            }
          });
          send({t:'hooked', off:boff.toString(16), addr:addr.toString()});
        }
      } catch(e) { send({t:'check_err', off:boff.toString(16), e:''+e}); }
    });
    send({t:'done_setup'});
  }, 300);
});
