// 多层截获内容密钥:
// 1. Hook JNI_OnLoad 看注册了哪些 native 方法
// 2. Hook libc memcpy, 过滤来自 libEncryptor.so 的16字节拷贝(=内容密钥交付)
// 3. 扫内存里 spade_a 当前位置, 在其附近监测写入(模拟 MemoryAccessMonitor)
'use strict';

var encMod = null, encBase = 0, encSize = 0;
var dragMod = null, dragBase = 0, dragSize = 0;
var CIPHERS = {};  // tag -> {cipher, sz, mo, kid}

// 从宿主 Python 预置密文信息
function setCipher(tag, cipherHex, sz, mo, kidHex) {
  CIPHERS[tag] = {c: hexToBytes(cipherHex), sz: sz, mo: mo, k: hexToBytes(kidHex)};
}

function hexToBytes(h) { var b=[]; for(var i=0;i<h.length;i+=2) b.push(parseInt(h.substr(i,2),16)); return b; }
function bytesHex(b) { return Array.from(b).map(x=>(x<16?'0':'')+x.toString(16)).join(''); }

// 用候选密钥 + 尝试验证是否为视频内容密钥
function tryContentKey(keyBytes) {
  if (keyBytes.length !== 16) return null;
  var K = keyBytes;
  for (var tag in CIPHERS) {
    var info = CIPHERS[tag];
    var mo = info.mo, sz = info.sz, kid = info.k, cipher = info.c;
    var r = mo % 16;
    if (r > 11) continue;
    // 尝试 IV=0, IV=kid_be
    for (var ivIdx = 0; ivIdx < 2; ivIdx++) {
      var iv = ivIdx === 0 ? new Array(16).fill(0) : kid.slice();
      var blk0 = mo >> 4;
      // 计算首块 keystream: AES-ECB(K, iv_counter)
      try {
        var ivInt = iv.reduce(function(a,b,i){return a + BigInt(b)*BigInt(256)**(BigInt(15)-BigInt(i));}, BigInt(0));
        var ctrBlk = (ivInt + BigInt(blk0)) & ((BigInt(1)<<BigInt(128))-BigInt(1));
        var ctrBytes = [];
        var tmp = ctrBlk;
        for (var i=15; i>=0; i--) { ctrBytes[i] = Number(tmp & BigInt(0xff)); tmp >>= BigInt(8); }
        // 用 Java javax.crypto 计算 AES-ECB(K, ctrBlk)
        var sKey = Java.use('javax.crypto.spec.SecretKeySpec').$new(K, 'AES');
        var cipher2 = Java.use('javax.crypto.Cipher').getInstance('AES/ECB/NoPadding');
        var enc = Java.use('javax.crypto.Cipher');
        cipher2.init(2, sKey);  // DECRYPT_MODE=2, ENCRYPT_MODE=1
        // 用ENCRYPT模式对counter做AES
        cipher2.init(1, sKey);
        var ctrArr = Java.array('byte', ctrBytes.map(x => x>127?x-256:x));
        var ks = cipher2.doFinal(ctrArr);
        // 解密 cipher[0:5]
        var pt = [];
        for (var i=0; i<5 && i+r<16; i++) {
          pt.push((cipher[i] ^ (ks[r+i]<0?ks[r+i]+256:ks[r+i])) & 0xff);
        }
        if (pt.length >= 5) {
          var L = (pt[0]<<24)|(pt[1]<<16)|(pt[2]<<8)|pt[3];
          var nh = pt[4]; var fzb=(nh>>7)&1; var nt=(nh>>1)&0x3f;
          if (L>0 && L<=sz-4 && fzb===0 && nt<=40 && L>8) {
            return {tag:tag, iv:ivIdx===0?'zero':'kid_be', L:L, nt:nt};
          }
        }
      } catch(e) { /* ignore */ }
    }
  }
  return null;
}

Java.perform(function() {
  // 等模块加载
  setTimeout(function() {
    encMod = Process.findModuleByName('libEncryptor.so');
    dragMod = Process.findModuleByName('libdragon_crypt.so');
    if (encMod) { encBase = encMod.base.toUInt32? parseInt(encMod.base): encMod.base; encSize = encMod.size; }
    if (dragMod) { dragBase = parseInt(dragMod.base); dragSize = dragMod.size; }
    send({t:'mods', enc: encMod?encMod.base:'null', drag: dragMod?dragMod.base:'null'});

    // Hook memcpy: 过滤 src 在 libEncryptor/libdragon 范围, size=16
    var memcpy = Module.findExportByName('libc.so','memcpy') || Module.findExportByName('libc.so','__memcpy_chk');
    if (memcpy) {
      Interceptor.attach(memcpy, {
        onEnter: function(a) {
          this.dst=a[0]; this.src=a[1]; this.sz=a[2].toUInt32? a[2].toUInt32(): parseInt(a[2]);
        },
        onLeave: function(r) {
          var inEnc = encMod && this.src.compare(encMod.base)>=0 && this.src.compare(encMod.base.add(encMod.size))<0;
          var inDrag = dragMod && this.src.compare(dragMod.base)>=0 && this.src.compare(dragMod.base.add(dragMod.size))<0;
          if ((inEnc||inDrag) && this.sz>=12 && this.sz<=32) {
            try {
              var bytes=Array.from(this.dst.readByteArray(this.sz));
              var hit=tryContentKey(bytes.slice(0,16));
              if(hit) {
                send({t:'CONTENT_KEY_VIA_MEMCPY',key:bytesHex(bytes.slice(0,16)),src:inEnc?'libEncryptor':'libdragon',sz:this.sz,hit:hit});
              } else {
                send({t:'memcpy16',from:inEnc?'libEncryptor':'libdragon',key:bytesHex(bytes.slice(0,16)),sz:this.sz});
              }
            } catch(e){}
          }
        }
      });
      send({t:'info',msg:'memcpy hooked @'+memcpy});
    }

    // Hook JNI_OnLoad to find registered native methods
    var jniLoad = Module.findExportByName('libEncryptor.so','JNI_OnLoad');
    if (jniLoad) {
      Interceptor.attach(jniLoad, {
        onEnter: function(a){ send({t:'jni_onload',mod:'libEncryptor'}); }
      });
    }
    jniLoad = Module.findExportByName('libdragon_crypt.so','JNI_OnLoad');
    if (jniLoad) {
      Interceptor.attach(jniLoad, {
        onEnter: function(a){ send({t:'jni_onload',mod:'libdragon_crypt'}); }
      });
    }

    // Hook JNIEnv->RegisterNatives to discover all native method bindings
    var Env = Java.vm.getEnv();
    try {
      var regNat = Env.handle.readPointer().add(215*Process.pointerSize).readPointer();
      Interceptor.attach(regNat, {
        onEnter: function(a) {
          try {
            var clsRef=a[1]; var methods=a[2]; var n=a[3].toUInt32?a[3].toUInt32():parseInt(a[3]);
            var cls=Java.vm.getEnv().getClassName(clsRef);
            for(var i=0;i<n;i++){
              var nm=methods.add(i*24).readPointer().readCString();
              var sig=methods.add(i*24+8).readPointer().readCString();
              var fn=methods.add(i*24+16).readPointer();
              var inEnc2=encMod&&fn.compare(encMod.base)>=0&&fn.compare(encMod.base.add(encMod.size))<0;
              var inDrag2=dragMod&&fn.compare(dragMod.base)>=0&&fn.compare(dragMod.base.add(dragMod.size))<0;
              if(inEnc2||inDrag2){
                send({t:'native_method',cls:cls,name:nm,sig:sig,fn:fn.toString(),lib:inEnc2?'Encryptor':'dragon'});
              }
            }
          } catch(e){ send({t:'regnat_err',e:''+e}); }
        }
      });
      send({t:'info',msg:'RegisterNatives hooked'});
    } catch(e){ send({t:'info',msg:'RegisterNatives hook failed: '+e}); }

  }, 500);
});
