// 正确触发播放:
// 1. 用 fromMediaInfoJsonString 构造 VideoModel
// 2. 找空闲的 TTVideoEngine 实例
// 3. setVideoModel + play
// 4. MC hook 抓明文
'use strict';

var fv = null, vBytes = 0;

Java.perform(function() {
  setTimeout(function() {
    // 读 video_model
    var SQLiteDatabase = Java.use('android.database.sqlite.SQLiteDatabase');
    var db=SQLiteDatabase.openDatabase('/data/data/com.phoenix.read/databases/series_download_db',null,1);
    var cur=db.rawQuery('SELECT video_model FROM t_series_video_model LIMIT 1',null);
    cur.moveToFirst(); var vmStr=cur.getString(0); cur.close(); db.close();

    // 构造 VideoModel
    var VM=Java.use('com.ss.ttvideoengine.model.VideoModel');
    var vm=null;
    try{
      vm=VM.$new();
      var r=vm.fromMediaInfoJsonString(vmStr);
      send({t:'vm_build',ret:r, type:vm.getClass().getName()});
    }catch(e){send({t:'vm_err',e:''+e}); return;}

    // 找合适的 engine（有 getCurrentPlayUrl=null 的空闲 engine）
    var engines=[];
    Java.choose('com.ss.ttvideoengine.TTVideoEngine',{
      onMatch:function(inst){ engines.push(inst); },
      onComplete:function(){}
    });
    send({t:'engines',count:engines.length});

    var eng=engines[0]; // 用第一个
    // 列出 play-related 方法签名
    try{
      var meths=eng.getClass().getMethods();
      for(var i=0;i<meths.length;i++){
        var nm=meths[i].getName();
        if(/^play|^start|^resume/i.test(nm))
          send({t:'play_sig',nm:nm,sig:meths[i].toString()});
      }
    }catch(e){}

    // setVideoModel
    try{
      eng.setVideoModel(vm);
      send({t:'setVM_ok'});
    }catch(e){send({t:'setVM_err',e:''+e});}

    // 尝试多种 play 方法
    ['play','startPlay','startVideo','resume'].forEach(function(m){
      try{
        if(eng[m]) { eng[m](); send({t:'play_called',m:m}); }
      }catch(e){}
    });

    // 也尝试 setDirectUrlUseDataLoader
    var urlMatch=vmStr.match(/"main_url"\s*:\s*"([^"]+)"/);
    if(urlMatch){
      var url=urlMatch[1];
      try{
        eng.setDirectUrlUseDataLoader.overload('java.lang.String','java.lang.String').call(eng,url,vmStr);
        send({t:'setDU_ok'});
      }catch(e){
        try{
          eng.setDirectUrlUseDataLoader.overload('java.lang.String').call(eng,url);
          send({t:'setDU_ok2'});
        }catch(e2){send({t:'setDU_err',e:''+e2});}
      }
    }

    // MC hook
    try{
      var FOS=Java.use('java.io.FileOutputStream');
      fv=FOS.$new('/data/local/tmp/force_video.h265',false);
    }catch(e){}
    var MC=Java.use('android.media.MediaCodec');
    MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){
      if(size>4){
        try{
          var name=this.getName().toLowerCase();
          if(name.indexOf('hevc')>=0||name.indexOf('bytevc')>=0){
            var bb=this.getInputBuffer(idx); bb.position(off);
            var a=Java.array('byte',new Array(size).fill(0)); bb.get(a);
            if(fv){fv.write(a,0,size); vBytes+=size;}
            if(vBytes<=512) send({t:'frame',size:size,flags:flags});
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
},5000);
