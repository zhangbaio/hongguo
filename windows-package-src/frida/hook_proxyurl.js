// Hook proxyUrl + addDataSource + setVideoModel 捕获本地代理 URL
// 请在 app 里点击播放任何一个已下载/正在播放的视频来触发
'use strict';

Java.perform(function() {
  // Hook proxyUrl (静态方法)
  try {
    var TTV = Java.use('com.ss.ttvideoengine.TTVideoEngine');
    TTV.proxyUrl.overload('java.lang.String','java.lang.String','[Ljava.lang.String;','com.ss.ttvideoengine.Resolution','java.lang.String').implementation = function(key, url, quals, res, ext) {
      var r = this.proxyUrl(key, url, quals, res, ext);
      send({t:'proxyUrl', key:''+key, url:(url?url.toString():'null').substr(0,100), result:''+r});
      return r;
    };
  } catch(e) { send({t:'proxyUrl_hook_err', e:''+e}); }

  try {
    var TTV2 = Java.use('com.ss.ttvideoengine.TTVideoEngine');
    TTV2.proxyUrl.overload('java.lang.String','java.lang.String','[Ljava.lang.String;','com.ss.ttvideoengine.Resolution','java.lang.String','java.lang.String').implementation = function(key, url, quals, res, ext1, ext2) {
      var r = this.proxyUrl(key, url, quals, res, ext1, ext2);
      send({t:'proxyUrl2', key:''+key, url:(url?url.toString():'null').substr(0,100), result:''+r});
      return r;
    };
  } catch(e) { send({t:'proxyUrl2_hook_err', e:''+e}); }

  // Hook addDataSource
  try {
    var AVMDL = Java.use('com.ss.mediakit.medialoader.AVMDLDataLoader');
    AVMDL.addDataSource.overload('int','java.lang.String').implementation = function(type, url) {
      send({t:'addDataSource', type:type, url:(''+url).substr(0,200)});
      return this.addDataSource(type, url);
    };
  } catch(e) { send({t:'addDataSource_hook_err', e:''+e}); }

  // Hook setVideoModel
  try {
    var TTV3 = Java.use('com.ss.ttvideoengine.TTVideoEngine');
    TTV3.setVideoModel.overload('com.ss.ttvideoengine.model.VideoModel').implementation = function(vm) {
      var vms = vm ? vm.toString() : 'null';
      send({t:'setVideoModel', vm: vms.substr(0,300)});
      return this.setVideoModel(vm);
    };
  } catch(e) { send({t:'setVM_hook_err', e:''+e}); }

  // Hook getCurrentPlayUrl
  try {
    var TTV4 = Java.use('com.ss.ttvideoengine.TTVideoEngine');
    TTV4.getCurrentPlayUrl.implementation = function() {
      var r = this.getCurrentPlayUrl();
      send({t:'getCurrentPlayUrl', result:''+r});
      return r;
    };
  } catch(e) { send({t:'gpurl_err', e:''+e}); }

  send({t:'info', msg:'all hooks installed, please play a downloaded video in the app'});
});
