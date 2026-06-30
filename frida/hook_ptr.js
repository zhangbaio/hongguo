'use strict';
Java.perform(function(){
  var m=Process.findModuleByName("libmetasec_ml.so"); if(!m){send("no metasec");return;}
  var seen=0;
  Interceptor.attach(m.base.add(0x26e684),{
    onEnter:function(a){ try{
      var op=a[2].toInt32(), Y=a[4];
      if((op===0x3000003||op===0x200000d) && !Y.isNull() && Y.compare(ptr(0x1000))>0){
        if(seen++>6) return;
        var asStr=""; try{ asStr=Y.readCString(); }catch(e){}
        var hex=""; try{ hex=Y.readByteArray(48); }catch(e){}
        send("PTR op=0x"+op.toString(16)+" @"+Y+" cstr="+(asStr?("「"+asStr.slice(0,80)+"」"):"-"));
        if(hex) send(hexdump(hex,{length:48,header:false}));
      }
    }catch(e){} }
  });
  send("ptr ready");
});
