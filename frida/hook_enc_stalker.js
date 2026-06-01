// 用 Stalker 跟踪 libEncryptor.so .mytext 函数执行,
// 在 BLR 指令处捕获 X0-X3 寄存器(可能含密钥指针/密钥)
'use strict';

function findEncryptorBase() {
  var base = null;
  ['r--','r-x'].forEach(function(perm) {
    if (base) return;
    Process.enumerateRanges(perm).forEach(function(r){
      if (base) return;
      if (r.file && r.file.path && r.file.path.indexOf('libEncryptor.so')>=0) {
        if (!r.file.offset) base = r.base;
      }
    });
  });
  return base;
}

var encBase = findEncryptorBase();
send({t:'base', v: encBase ? encBase.toString() : 'null'});
if (!encBase) { send({t:'err',e:'not found'}); }
else {
  var mytext_entry = encBase.add(0x7d8c);
  send({t:'entry', v: mytext_entry.toString()});

  // 尝试 hook 函数入口
  try {
    Interceptor.attach(mytext_entry, {
      onEnter: function(a) {
        this.tid = Process.getCurrentThreadId();
        send({t:'enter', x0:a[0].toString(), x1:a[1].toString(), x2:a[2].toString()});
        // 用 Stalker 跟踪这个线程
        var self = this;
        Stalker.follow(self.tid, {
          events: { call:true, ret:false, exec:false },
          onReceive: function(events) {
            // events 是 ArrayBuffer
          },
          transform: function(iterator) {
            var instr; var count=0;
            while ((instr=iterator.next())!==null) {
              // 在 .mytext 范围内的 BLR 指令
              var addr=instr.address;
              var inEnc = encBase && addr.compare(encBase)>=0 && addr.compare(encBase.add(0x15000))<0;
              if (inEnc && instr.mnemonic === 'blr') {
                // 在 BLR 前插入 callout
                iterator.putCallout(function(ctx) {
                  var x0=ctx.x0,x1=ctx.x1,x2=ctx.x2,x3=ctx.x3,x8=ctx.x8;
                  var keys={};
                  [['x0',x0],['x1',x1],['x2',x2],['x3',x3]].forEach(function(p){
                    try { keys[p[0]+'_mem']=p[1].readByteArray(32)?Array.from(new Uint8Array(p[1].readByteArray(32))).map(function(v){return(v<16?'0':'')+v.toString(16)}).join(''):'?'; }catch(e){}
                  });
                  send({t:'BLR_REG', addr:addr.toString(), x8:x8.toString(), keys:keys});
                });
              }
              iterator.keep();
              count++;
            }
          }
        });
      },
      onLeave: function(r) {
        Stalker.unfollow(this.tid);
        Stalker.flush();
      }
    });
    send({t:'hooked', msg:'mytext entry hooked, play video'});
  } catch(e) {
    send({t:'hook_entry_err', e:''+e});
    // 备用: hook callers of mytext from .text
    // .text 在 file 0xb00..0x7cec, 找 BL 到 0x7d8c 偏移
    send({t:'scanning_callers'});
    var textStart = encBase.add(0xb00); var textSize = 0x71ec;
    var textData = Memory.readByteArray(textStart, textSize);
    var u8 = new Uint8Array(textData);
    // ARM64 BL: imm26 relative, encoding 0x97/0x94 for backward branch
    for (var i=0; i+3<textSize; i+=4) {
      var w = u8[i]|(u8[i+1]<<8)|(u8[i+2]<<16)|(u8[i+3]<<24);
      if ((w & 0xFC000000) === 0x94000000) {  // BL
        var imm26 = w & 0x3FFFFFF; if (imm26>>25) imm26|=-0x4000000;
        var target = textStart.add(i).add(imm26*4);
        if (target.equals(mytext_entry)) {
          send({t:'caller', pc:'0x'+(textStart.add(i)).toString(), target:target.toString()});
        }
      }
    }
  }
}
