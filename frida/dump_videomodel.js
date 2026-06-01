// 异步扫描 rw 内存找 "spade_a" 字符串(正在播视频的 video_model JSON), dump 周围文本上下文。
// 安全: 用 Memory.scan(异步回调,会让出), 不做重型同步循环, 不碰签名线程。
'use strict';

var PAT = '73 70 61 64 65 5f 61'; // "spade_a"
var BEFORE = 8192, AFTER = 32768;
var MAX_HITS = 4;
var seen = {};   // 去重(按 spade_a 值的前缀)
var hits = 0;
var done = false;

function bytesToText(ptr, len) {
  var out = [];
  var buf = ptr.readByteArray(len);
  var u8 = new Uint8Array(buf);
  for (var i = 0; i < u8.length; i++) {
    var c = u8[i];
    out.push((c >= 32 && c < 127) ? String.fromCharCode(c) : '.');
  }
  return out.join('');
}

function ranges() {
  return Process.enumerateRanges('rw-').filter(function (r) {
    return r.size > 0 && r.size < 64 * 1024 * 1024; // 跳过超大保留段
  });
}

function scanRange(r) {
  return new Promise(function (resolve) {
    if (done) { resolve(); return; }
    Memory.scan(r.base, r.size, PAT, {
      onMatch: function (addr, size) {
        if (done) return 'stop';
        try {
          var start = addr.sub(BEFORE);
          var text = bytesToText(start, BEFORE + AFTER);
          // 用命中点附近的 spade_a 值去重
          var idx = text.indexOf('spade_a');
          var key = text.substr(idx, 60);
          if (!seen[key]) {
            seen[key] = 1;
            hits++;
            send({ t: 'hit', n: hits, addr: addr.toString(), text: text });
            if (hits >= MAX_HITS) { done = true; return 'stop'; }
          }
        } catch (e) { send({ t: 'err', e: '' + e }); }
      },
      onError: function (e) { /* 段不可读, 跳过 */ },
      onComplete: function () { resolve(); }
    });
  });
}

(async function () {
  var rs = ranges();
  send({ t: 'info', msg: 'rw ranges(<64M): ' + rs.length });
  for (var i = 0; i < rs.length && !done; i++) {
    await scanRange(rs[i]);
  }
  send({ t: 'fin', hits: hits });
})();
