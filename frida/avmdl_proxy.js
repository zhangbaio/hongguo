// 用 AVMDL 本地代理路线:
// 1. 取 offline 视频的 video_model (从 DB 或内存)
// 2. 调 TTVideoEngine.proxyUrl() 生成本地代理 URL
// 3. 发送代理 URL 供宿主机 HTTP GET
'use strict';

Java.perform(function() {
  setTimeout(function() {
    var AVMDL = Java.use('com.ss.mediakit.medialoader.AVMDLDataLoader');
    var inst = AVMDL.getInstance();
    var addr = inst.getLocalAddr();
    send({t:'local_addr', addr: ''+addr});

    // TTVideoEngine.proxyUrl 静态方法
    try {
      var TTV = Java.use('com.ss.ttvideoengine.TTVideoEngine');
      // 列出 proxyUrl 重载
      var meths = TTV.class.getMethods();
      for (var i=0; i<meths.length; i++) {
        var m = meths[i];
        if (m.getName() === 'proxyUrl' || m.getName() === 'setVideoModel' || m.getName() === 'playVideo') {
          send({t:'ttv_method', sig: m.toString()});
        }
      }
    } catch(e) { send({t:'ttv_err', e:''+e}); }

    // 试 addDataSource 第一种重载
    try {
      var AVMDL2 = Java.use('com.ss.mediakit.medialoader.AVMDLDataLoader');
      // getStringValueByStr
      var keys = [
        '4e07e6c1d34225b1b9d30e113d0c4e19',
        'f64d62fd54442b940dca98c2066d6611',
        '8a95b7b90933b951433face6058d29db'
      ];
      keys.forEach(function(k) {
        try {
          var v = inst.getStringValueByStr(k, 0);
          send({t:'gsvbs', key:k, val:''+v});
        } catch(e) { send({t:'gsvbs_err', e:''+e}); }
        try {
          var v2 = inst.getStringCacheInfo(k);
          send({t:'cacheInfo', key:k, val:''+v2});
        } catch(e) {}
      });
    } catch(e) { send({t:'err2', e:''+e}); }

    // getDownloader 试一下
    try {
      var cb = Java.use('com.ss.mediakit.medialoader.AVMDLDataLoader').getDownloader.overload('int','com.ss.mediakit.medialoader.IDownloaderCallback');
      send({t:'getDownloader_sig', sig:'found'});
    } catch(e) { send({t:'getDownloader_sig', sig:''+e}); }

    // 直接 getStringValue(0..10)
    for (var i=0; i<16; i++) {
      try { var v=inst.getStringValue(i); if(v) send({t:'gsv', idx:i, val:''+v}); } catch(e) {}
    }

  }, 300);
});
