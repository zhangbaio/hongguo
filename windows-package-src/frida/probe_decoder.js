// 全面探测当前解码路径
'use strict';

Java.perform(function(){
  // 1. 检查 Java MediaCodec 是否可用
  try{
    var MC = Java.use('android.media.MediaCodec');
    Java.choose('android.media.MediaCodec',{
      onMatch:function(inst){
        try{ send({t:'active_codec', name:inst.getName()}); }catch(e){}
      },
      onComplete:function(){ send({t:'choose_done'}); }
    });
  }catch(e){ send({t:'mc_err',e:''+e}); }

  // 2. hook MediaCodec.createDecoderByType (检测未来的创建)
  try{
    var MC2=Java.use('android.media.MediaCodec');
    MC2.createDecoderByType.implementation=function(mime){
      var r=this.createDecoderByType(mime);
      send({t:'create',mime:mime,name:r.getName()});
      return r;
    };
    send({t:'create_hooked'});
  }catch(e){}

  // 3. hook ByteVC1 解码器 Java 入口 (如果有)
  try{
    var BVC=Java.use('com.bytedance.bytevc1.ByteVC1Decoder');
    send({t:'bytevc1_found'});
  }catch(e){ send({t:'no_bytevc1',e:''+e}); }

  // 4. hook SurfaceTexture.updateTexImage (每次新帧渲染时调用)
  try{
    var ST=Java.use('android.graphics.SurfaceTexture');
    var frameCount=0;
    ST.updateTexImage.implementation=function(){
      frameCount++;
      if(frameCount<=3||frameCount%100===0) send({t:'surface_frame',n:frameCount});
      return this.updateTexImage();
    };
    send({t:'surface_hooked'});
  }catch(e){ send({t:'surface_err',e:''+e}); }

});

// 5. hook native AMediaCodec
var fn1=Module.findExportByName('libmediandk.so','AMediaCodec_queueInputBuffer');
var fn2=Module.findExportByName('libmediandk.so','AMediaCodec_dequeueInputBuffer');
if(fn1){
  Interceptor.attach(fn1,{onEnter:function(a){
    send({t:'AMediaCodec_qib',sz:parseInt(a[3])});
  }});
}
if(fn2){
  Interceptor.attach(fn2,{onEnter:function(a){
    send({t:'AMediaCodec_dqib',timeout:parseInt(a[2])});
  }});
}
send({t:'native_hooked'});

setInterval(function(){ send({t:'ping'}); },5000);
