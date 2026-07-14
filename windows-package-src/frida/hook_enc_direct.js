// 用 Process.enumerateRanges 找 libEncryptor.so, 然后 hook .mytext 的 BLR 点
// 不需要 findModuleByName (绕过 linker namespace)
'use strict';

function findEncryptorBase() {
  var base = null;
  // Frida enumerateRanges 接受 3 位权限字符串
  ['r--','r-x'].forEach(function(perm) {
    if (base) return;
    Process.enumerateRanges(perm).forEach(function(r){
      if (base) return;
      if (r.file && r.file.path && r.file.path.indexOf('libEncryptor.so')>=0) {
        var foff = r.file ? r.file.offset : 0;
        if (foff === 0) base = r.base;
      }
    });
  });
  return base;
}

var encBase = findEncryptorBase();
send({t:'enc_base', v: encBase ? encBase.toString() : 'NOT FOUND'});

if (!encBase) {
  // 备用: 从所有 range 找
  Process.enumerateRanges('r--').forEach(function(r){
    if(r.file && r.file.path && r.file.path.indexOf('Encryptor')>=0)
      send({t:'range', path:r.file.path, off:r.file.offset, base:r.base.toString(), perm:r.protection});
  });
  send({t:'give_up'});
} else {
  // .mytext 偏移 = 0x7d8c (from .so file)
  var mytext = encBase.add(0x7d8c);
  send({t:'mytext_addr', v: mytext.toString()});

  // 验证首4字节 (应为 SUB SP,SP,#0x60 = 0xD10183FF)
  try {
    var check = mytext.readU32();
    send({t:'check', instr:check.toString(16), expected:'d10183ff', ok: (check===0xd10183ff)});
  } catch(e) { send({t:'read_err', e:''+e}); }

  // BLR X8 = 0xD63F0100, hook 各偏移点
  var OFFSETS = [0x54, 0xA4, 0xC8, 0xEC, 0xF0];
  OFFSETS.forEach(function(off) {
    var addr = mytext.add(off);
    try {
      var instr = addr.readU32();
      var isBLR = (instr === 0xD63F0100);
      send({t:'scan', off:'0x'+off.toString(16), instr:'0x'+instr.toString(16), isBLR:isBLR});
      if (isBLR) {
        Interceptor.attach(addr, {
          onEnter: function(a) {
            // 读 x0~x3 指向的前16字节(可能是密钥缓冲)
            var keys={};
            for (var ri=0; ri<4; ri++) {
              try {
                var rval = this.context['x'+ri];
                var mem = rval.readByteArray(32);
                if(mem) keys['x'+ri+'_mem']=Array.from(new Uint8Array(mem)).map(function(x){return(x<16?'0':'')+x.toString(16)}).join('');
              } catch(e){}
            }
            send({t:'BLR_call', off:'0x'+off.toString(16), x8:this.context.x8.toString(), keys:keys});
          }
        });
        send({t:'hooked', off:'0x'+off.toString(16), addr:addr.toString()});
      }
    } catch(e){ send({t:'hook_err', e:''+e}); }
  });
  send({t:'ready', msg:'hooks installed, play a video to trigger'});
}
