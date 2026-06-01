// 尝试通过 AVMDLDataLoader.copyFile() 让 app 自己解密输出 .mdl 文件
// 参数: key = MDL 文件名(不含后缀), dst = 输出路径
'use strict';

Java.perform(function() {
  setTimeout(function() {
    var AVMDL = Java.use('com.ss.mediakit.medialoader.AVMDLDataLoader');
    var inst = AVMDL.getInstance();
    send({t:'avmdl', inst: inst ? ''+inst : 'null'});

    // 列出 copyFile 方法签名
    var meths = AVMDL.class.getMethods();
    for (var i=0; i<meths.length; i++) {
      var m = meths[i];
      if (m.getName().toLowerCase().indexOf('copy') >= 0 ||
          m.getName().toLowerCase().indexOf('export') >= 0 ||
          m.getName().toLowerCase().indexOf('getfile') >= 0) {
        send({t:'method', name: m.getName(), sig: m.toString()});
      }
    }

    // 列出所有 public 方法名(前40个)
    var allMeths = [];
    for (var i=0; i<meths.length; i++) allMeths.push(meths[i].getName());
    send({t:'all_methods', methods: allMeths.join(',')});

    // 试调 copyFile: 用 offline .mdl 的 key
    var KEY = '4e07e6c1d34225b1b9d30e113d0c4e19';  // MDL 文件名
    var DST = '/data/local/tmp/avmdl_out.mp4';
    try {
      var r = inst.copyFile(KEY, DST);
      send({t:'copyFile_result', r: ''+r});
    } catch(e) { send({t:'copyFile_err', e:''+e}); }

    // 尝试另一个签名 copyFile(String, String, boolean)
    try {
      var r2 = inst.copyFile(KEY, DST, false);
      send({t:'copyFile2_result', r: ''+r2});
    } catch(e) { send({t:'copyFile2_err', e:''+e}); }

    // 也尝试 getCacheInfo / getStringCacheInfo
    try {
      var ci = inst.getStringCacheInfo(KEY);
      send({t:'cacheInfo', ci: ''+ci});
    } catch(e) { send({t:'cacheInfo_err', e:''+e}); }

  }, 500);
});
