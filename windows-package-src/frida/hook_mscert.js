// dump MS.b 关键 op 的返回(类名+长度+base64/字符串) —— 定位 metasec 证书的真实形态。
'use strict';
Java.perform(function(){
  var done=false, tries=0, dumped={};
  var WANT={16777217:1,16777218:1,16777219:1,16777220:1,16777221:1,16777222:1,16777216:1};
  function hook(){
    if(done) return true; tries++;
    var MS; try{ MS=Java.use("com.bytedance.mobsec.metasec.ml.MS"); }catch(e){ return false; }
    MS.b.overloads.forEach(function(ov){
      ov.implementation=function(){
        var ret=ov.apply(this,arguments);
        try{
          var op=arguments.length>0?arguments[0]:-1;
          if(WANT[op] && !dumped[op]){
            dumped[op]=1;
            if(ret==null){ send("MSB op="+op+" -> null"); }
            else {
              var cn=""; try{ cn=""+ret.getClass().getName(); }catch(e){ cn="?"; }
              if(cn=="[B"){ send("###CERT### op="+op+" len="+ret.length+" type=[B b64=\n"+Java.use("android.util.Base64").encodeToString(ret,2)+"\n###END###"); }
              else if(cn.indexOf("String")>=0){ var s=""+ret; send("MSB op="+op+" String("+s.length+")="+s.slice(0,300)); }
              else { send("MSB op="+op+" type="+cn+" val="+(""+ret).slice(0,120)); }
            }
          }
        }catch(e){}
        return ret;
      };
    });
    done=true; send("hooked (tries="+tries+")");
    return true;
  }
  if(!hook()){ var t=setInterval(function(){ if(hook()||tries>120) clearInterval(t); },500); }
});
