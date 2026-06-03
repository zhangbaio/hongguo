'use strict';
// hook GetStringUTFChars (JNIEnv vtable idx 169) 捕获传入native的字符串; 匹配spade(base64~52) -> backtrace定位native解包入口
function isSpade(s){ return s && s.length>=44 && s.length<=60 && /^[A-Za-z0-9+/]+={0,2}$/.test(s) && /[A-Z]/.test(s) && /[a-z]/.test(s); }
function modOf(addr){ var r=Process.findRangeByAddress(addr); return r&&r.file?r.file.path.split('/').pop()+'+0x'+addr.sub(r.base).toString(16):addr.toString(); }
var env=Java.vm.getEnv();
var tbl=env.handle.readPointer();
var pGetUTF=tbl.add(169*Process.pointerSize).readPointer();
var pGetUTFR=tbl.add(171*Process.pointerSize).readPointer(); // GetStringUTFRegion (备)
send({t:'info', GetStringUTFChars:pGetUTF.toString()});
var seen={};
Interceptor.attach(pGetUTF,{
  onEnter:function(a){ this.jstr=a[1]; this.ctx=this.context; },
  onLeave:function(ret){
    try{
      var s=ret.readCString();
      if(isSpade(s) && !seen[s]){ seen[s]=1;
        var bt=Thread.backtrace(this.ctx, Backtracer.ACCURATE).slice(0,12).map(modOf);
        send({t:'SPADE_STR', s:s, bt:bt});
      }
    }catch(e){}
  }
});
send({t:'ready', msg:'JNI GetStringUTFChars hook on; 打开全新视频(让spade经JNI传入)'});
