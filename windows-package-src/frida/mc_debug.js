// 完全不过滤的 MediaCodec 调试 hook:
// 记录所有 createDecoderByType + queueInputBuffer 调用, 不管 codec 类型
'use strict';

var codecStats = {};

Java.perform(function(){
  var MC = Java.use('android.media.MediaCodec');

  // hook createDecoderByType
  MC.createDecoderByType.implementation = function(mime){
    var r = this.createDecoderByType(mime);
    try { send({t:'create', mime:mime, name:r.getName()}); } catch(e){}
    return r;
  };

  // hook ALL queueInputBuffer (no filter)
  MC.queueInputBuffer.implementation = function(idx,off,size,pts,flags){
    try{
      var nm = this.getName();
      if(!codecStats[nm]) codecStats[nm]=0;
      codecStats[nm]+=size;
      // 只在首次或每1000次报一次
      if(codecStats[nm]<= size || codecStats[nm]%100000 < size)
        send({t:'qib', name:nm, size:size, flags:flags, total:codecStats[nm]});
    }catch(e){}
    return this.queueInputBuffer(idx,off,size,pts,flags);
  };

  // hook configure (codec 配置时)
  MC.configure.overload('android.media.MediaFormat','android.view.Surface','android.media.MediaCrypto','int').implementation = function(fmt,surf,crypto,flags){
    try{
      send({t:'configure', name:this.getName(), fmt:fmt.toString().substr(0,100), hasSurface:surf!=null, hasCrypto:crypto!=null});
    }catch(e){}
    return this.configure(fmt,surf,crypto,flags);
  };

  send({t:'debug_hooked'});

  // 定期汇报 codec 使用统计
  setInterval(function(){
    send({t:'stats', stats:JSON.stringify(codecStats).substr(0,200)});
  }, 5000);
});
