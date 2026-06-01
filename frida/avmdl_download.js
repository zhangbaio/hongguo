// AVMDL 解密下载流程:
// 1. 从DB取 video_model (包含 spade_a + main_url)
// 2. addDataSource 注册
// 3. preloadResource 触发下载
// 4. 轮询 getStringCacheInfo 等待完成
// 5. copyFile 导出解密后的文件
'use strict';

Java.perform(function() {
  setTimeout(function() {
    var AVMDL = Java.use('com.ss.mediakit.medialoader.AVMDLDataLoader');
    var inst = AVMDL.getInstance();

    // 从DB取 video_model
    var SQLiteDatabase = Java.use('android.database.sqlite.SQLiteDatabase');
    var db=SQLiteDatabase.openDatabase('/data/data/com.phoenix.read/databases/series_download_db',null,1);
    var cursor=db.rawQuery('SELECT video_id,video_model FROM t_series_video_model ORDER BY ROWID LIMIT 1',null);
    cursor.moveToFirst();
    var vid=cursor.getString(0); var vm=cursor.getString(1);
    cursor.close(); db.close();
    send({t:'vm',vid:vid,len:vm.length});

    var urlMatch=vm.match(/"main_url"\s*:\s*"([^"]+)"/);
    var fidMatch=vm.match(/"file_id"\s*:\s*"([^"]+)"/);
    var sizeMatch=vm.match(/"size"\s*:\s*(\d+)/);
    if(!urlMatch||!fidMatch){send({t:'err',e:'no url/fid'}); return;}
    var url=urlMatch[1]; var fid=fidMatch[1]; var sz=sizeMatch?parseInt(sizeMatch[1]):0;
    send({t:'info',url:url.substr(0,80),fid:fid,size:sz});

    // Step1: addDataSource
    try{inst.addDataSource(1,url);}catch(e){}
    send({t:'addDS_done'});

    // Step2: preloadResource (尝试不同重载)
    var preloaded=false;
    ['preloadResource'].forEach(function(nm){
      if(preloaded) return;
      try{
        inst.preloadResource.overload('java.lang.String','long').call(inst,fid,sz);
        preloaded=true; send({t:'preload_ok',sig:'String,long'});
      }catch(e){
        try{
          inst.preloadResource.overload('java.lang.String','long','long').call(inst,fid,0,sz);
          preloaded=true; send({t:'preload_ok',sig:'String,long,long'});
        }catch(e2){
          send({t:'preload_err',e:''+e2});
        }
      }
    });

    // Step3: 轮询 getCacheInfo 等待下载完成, 超时后 copyFile
    var tries=0; var maxTries=30;
    function pollAndCopy(){
      tries++;
      var ci=''; try{ci=''+inst.getStringCacheInfo(fid);}catch(e){}
      send({t:'poll',try:tries,ci:ci.substr(0,80)});

      if(ci&&ci!='null'&&ci.indexOf(',')>0){
        var parts=ci.split(',');
        var downloaded=parseInt(parts[0])||0; var total=parseInt(parts[1])||0;
        if(total>0&&downloaded>=total){
          send({t:'download_complete',downloaded:downloaded,total:total});
          // copyFile
          ['/data/local/tmp/avmdl_dec.mp4','/sdcard/avmdl_dec.mp4'].forEach(function(dst){
            try{
              var r=inst.copyFile(fid,dst);
              send({t:'copyFile',dst:dst,ret:''+r});
            }catch(e){send({t:'copyFile_err',e:''+e});}
          });
          // writeDataToFile (backup)
          try{
            inst.writeDataToFile(fid,'/data/local/tmp/avmdl_wdf.mp4',false);
            send({t:'writeDataToFile_ok'});
          }catch(e){send({t:'wdf_err',e:''+e});}
          return;
        }
      }
      if(tries<maxTries) setTimeout(pollAndCopy,2000);
      else {
        send({t:'timeout_copyFile'});
        ['/data/local/tmp/avmdl_dec.mp4'].forEach(function(dst){
          try{var r=inst.copyFile(fid,dst); send({t:'copyFile_timeout',dst:dst,ret:''+r});}catch(e){}
        });
      }
    }
    setTimeout(pollAndCopy,2000);

  },500);
});
