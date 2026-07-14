// 强制启动在线播放:
// 1. 从数据库读 video_model JSON
// 2. 构造 VideoModel 对象
// 3. 找 TTVideoEngine 实例，调 setVideoModel + play
// 4. 同时 hook MediaCodec 捕获解密后的帧
'use strict';

var fv = null, vBytes = 0;
// 预创建文件
Java.perform(function() {
  setTimeout(function() {
    // Part 1: 读 video_model
    var SQLiteDatabase = Java.use('android.database.sqlite.SQLiteDatabase');
    var db = SQLiteDatabase.openDatabase('/data/data/com.phoenix.read/databases/series_download_db', null, 1);
    var cursor = db.rawQuery('SELECT video_id, video_model FROM t_series_video_model LIMIT 1', null);
    cursor.moveToFirst();
    var vid = cursor.getString(0); var vmStr = cursor.getString(1);
    cursor.close(); db.close();
    send({t:'vm', vid:vid, len:vmStr.length});

    // Part 2: 构造 VideoModel (字节内置的 VideoModel.createModel 或 JSON 反序列化)
    var vmCreated = false;
    var VideoModel = null;
    try {
      VideoModel = Java.use('com.ss.ttvideoengine.model.VideoModel');
      // 尝试 fromJson / createModel
      var meths = VideoModel.class.getMethods();
      var factoryMeth = null;
      for(var i=0;i<meths.length;i++){
        var nm=meths[i].getName();
        if(/json|create|from|parse/i.test(nm)&&nm!=='equals') {
          send({t:'vm_method',nm:nm,sig:meths[i].toString()});
          factoryMeth = meths[i].getName();
        }
      }
    }catch(e){send({t:'vm_err',e:''+e});}

    // Part 3: 找活跃 TTVideoEngine 实例
    var engines = [];
    try{
      Java.choose('com.ss.ttvideoengine.TTVideoEngine',{
        onMatch:function(inst){ engines.push(inst); },
        onComplete:function(){}
      });
      send({t:'engines',count:engines.length});
    }catch(e){send({t:'engine_err',e:''+e});}

    if(engines.length > 0) {
      var eng = engines[0];
      // 尝试调 setVideoModelJsonString
      try{
        var meths2=eng.getClass().getMethods();
        var vm_meths=[];
        for(var i=0;i<meths2.length;i++){
          var nm=meths2[i].getName();
          if(/video.?model|json.*model|play.*url|direct.*url/i.test(nm)) vm_meths.push(nm);
        }
        send({t:'play_meths',meths:vm_meths.join(',')});
      }catch(e){}

      // 尝试直接触发播放
      try{
        // setVideoModelJsonString if available
        eng.setVideoModelJsonString(vmStr);
        send({t:'setVMJson_ok'});
      }catch(e){
        send({t:'setVMJson_err',e:''+e});
        // 尝试其他方法
        try{
          var VM2=Java.use('com.ss.ttvideoengine.model.VideoModel');
          var vm=VM2.createVideoModel(vmStr);
          eng.setVideoModel(vm);
          send({t:'setVM_ok'});
        }catch(e2){send({t:'setVM_err2',e:''+e2});}
      }

      // play
      try{ eng.play(); send({t:'play_ok'}); }catch(e){
        try{ eng.startPlay(0); send({t:'startPlay_ok'}); }catch(e2){
          send({t:'play_err',e:''+e2});
        }
      }
    }

    // Part 4: MediaCodec hook (同时)
    try {
      var FileOutputStream = Java.use('java.io.FileOutputStream');
      fv = FileOutputStream.$new('/data/local/tmp/force_video.h265', false);
    } catch(e){}

    var MC = Java.use('android.media.MediaCodec');
    MC.queueInputBuffer.implementation = function(idx,off,size,pts,flags){
      if(size>4){
        try{
          var name=this.getName().toLowerCase();
          if(name.indexOf('hevc')>=0||name.indexOf('bytevc')>=0){
            var bb=this.getInputBuffer(idx); bb.position(off);
            var a=Java.array('byte',new Array(size).fill(0)); bb.get(a);
            if(fv){fv.write(a,0,size); vBytes+=size;}
            if(vBytes<=512) send({t:'frame',size:size,flags:flags,name:name});
          }
        }catch(e){}
      }
      return this.queueInputBuffer(idx,off,size,pts,flags);
    };
    send({t:'mc_hooked'});

  }, 300);
});

setInterval(function(){
  send({t:'tick',vBytes:vBytes});
}, 5000);
