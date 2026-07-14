// 用 AVMDL 代理获取解密内容:
// 1. 读数据库取完整 video_model
// 2. addDataSource 注册
// 3. 构造代理 URL
// 4. 返回供宿主机 HTTP GET
'use strict';

Java.perform(function() {
  setTimeout(function() {
    var AVMDL = Java.use('com.ss.mediakit.medialoader.AVMDLDataLoader');
    var inst = AVMDL.getInstance();
    var addr = inst.getLocalAddr();
    send({t:'addr', v: ''+addr});

    // 从 series_download_db 读 video_model
    try {
      var File = Java.use('java.io.File');
      var DB_PATH = '/data/data/com.phoenix.read/databases/series_download_db';
      // 通过 ContentResolver 读不方便, 直接 SQLite
      var SQLiteDatabase = Java.use('android.database.sqlite.SQLiteDatabase');
      var db = SQLiteDatabase.openDatabase(DB_PATH, null, 1); // READ_ONLY=1
      var cursor = db.rawQuery('SELECT video_id, video_model FROM t_series_video_model LIMIT 3', null);
      while (cursor.moveToNext()) {
        var vid = cursor.getString(0);
        var vm = cursor.getString(1);
        send({t:'db_row', vid:vid, vm_len: vm ? vm.length : 0});
        if (vm && vm.length > 100) {
          // 找 main_url 和 file_id
          var mi = vm.indexOf('main_url');
          var fi = vm.indexOf('file_id');
          if (mi>=0) send({t:'main_url', vid:vid, url: vm.substr(mi+10, 200)});
          if (fi>=0) send({t:'file_id', vid:vid, fid: vm.substr(fi+10, 40)});

          // addDataSource(type=1, url=video_model_json_or_url)
          try {
            // 尝试直接用 file_id 作为 addDataSource 的 key
            var fidm = vm.match(/"file_id"\s*:\s*"([^"]+)"/);
            if (fidm) {
              var fid = fidm[1];
              // addDataSource 第一个参数 type 可能是1(VIDEO)
              inst.addDataSource(1, vm);
              send({t:'addDS', fid:fid, status:'called with vm'});
              // 等一下再查
              var v = inst.getStringValueByStr(fid, 0);
              send({t:'after_addDS', fid:fid, val:''+v});
              // 也试 proxyUrl
              var TTV = Java.use('com.ss.ttvideoengine.TTVideoEngine');
              // proxyUrl(key, cdnUrl, quals, resolution, extra)
              try {
                var urlm = vm.match(/"main_url"\s*:\s*"([^"]+)"/);
                if (urlm) {
                  var pu = TTV.proxyUrl(fid, urlm[1], null, null, null);
                  send({t:'proxyUrl', fid:fid, url:''+pu});
                }
              } catch(pe){ send({t:'proxyUrl_err', e:''+pe}); }
            }
          } catch(e){ send({t:'addDS_err', e:''+e}); }
        }
      }
      cursor.close(); db.close();
    } catch(e){ send({t:'db_err', e:''+e}); }

  }, 300);
});
