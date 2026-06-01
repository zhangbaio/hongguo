// 用 AVMDL 的 addDataSource + getDownloader + _dhRead 直接读取解密后的视频数据
// 从数据库取 video_model, 注册数据源, 然后通过下载器读出解密字节
'use strict';

Java.perform(function() {
  setTimeout(function() {
    var AVMDL = Java.use('com.ss.mediakit.medialoader.AVMDLDataLoader');
    var inst = AVMDL.getInstance();

    // 读数据库取 video_model JSON
    try {
      var SQLiteDatabase = Java.use('android.database.sqlite.SQLiteDatabase');
      var DB='/data/data/com.phoenix.read/databases/series_download_db';
      var db=SQLiteDatabase.openDatabase(DB,null,1);
      var cursor=db.rawQuery('SELECT video_id,video_model FROM t_series_video_model LIMIT 3',null);
      while(cursor.moveToNext()){
        var vid=cursor.getString(0); var vm=cursor.getString(1);
        if(!vm||vm.length<100) continue;
        send({t:'db_row',vid:vid,vm_len:vm.length});

        // 找 main_url 和 file_id
        var urlMatch=vm.match(/"main_url"\s*:\s*"([^"]+)"/);
        var fidMatch=vm.match(/"file_id"\s*:\s*"([^"]+)"/);
        if(!urlMatch||!fidMatch) continue;
        var mainUrl=urlMatch[1]; var fid=fidMatch[1];
        send({t:'url',fid:fid,url:mainUrl.substr(0,80)});

        // 尝试 addDataSource(type=1, url=mainUrl)
        try{
          inst.addDataSource(1,mainUrl);
          send({t:'addDS_ok',fid:fid});
        }catch(e){send({t:'addDS_err',e:''+e});}

        // 等500ms后尝试 copyFile
        setTimeout(function(){
          try{
            var r=inst.copyFile(fid,'/data/local/tmp/avmdl_out_'+fid.substr(0,8)+'.mp4');
            send({t:'copyFile',fid:fid,ret:''+r});
          }catch(e){send({t:'copyFile_err',e:''+e});}

          // getStringValueByStr
          try{
            var v=inst.getStringValueByStr(fid,0);
            send({t:'gsv',fid:fid,v:''+v});
          }catch(e){}

          // getCacheInfo
          try{
            var ci=inst.getStringCacheInfo(fid);
            send({t:'ci',fid:fid,v:''+ci});
          }catch(e){}
        },500);
        break; // 只用第一个
      }
      cursor.close(); db.close();
    }catch(e){send({t:'db_err',e:''+e});}

    // 列出所有方法中含 "download" 的
    try{
      var meths=AVMDL.class.getMethods();
      var dl_meths=[];
      for(var i=0;i<meths.length;i++){
        var nm=meths[i].getName();
        if(/download|read|data|source/i.test(nm)) dl_meths.push(nm);
      }
      send({t:'dl_methods',meths:dl_meths.join(',')});
    }catch(e){}

  },300);
});
