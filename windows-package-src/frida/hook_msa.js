'use strict';
Java.perform(function(){
  var done=false,tries=0,seen={};
  function s(x){ try{ if(x===null) return "null"; var c=x.getClass?x.getClass().getName():typeof x; var v=(""+x); return c+"("+(v.length>80?v.slice(0,80)+"…":v)+")"; }catch(e){ return "?"; } }
  function hook(){ tries++;
    var M; try{ M=Java.use("ms.bd.c.m"); }catch(e){ return false; }
    var ms=Object.getOwnPropertyNames(M.__proto__).filter(function(n){return n==="a";});
    if(!ms.length) { send("ms.bd.c.m 无方法a"); return true; }
    M.a.overloads.forEach(function(ov){
      ov.implementation=function(){
        var ret=ov.apply(this,arguments);
        try{
          var op=arguments.length>0?arguments[0]:-1;
          var key=op+"_"+arguments.length;
          if(!seen[key]){ seen[key]=1;
            var a=[]; for(var i=0;i<arguments.length;i++) a.push(s(arguments[i]));
            send("A op="+op+" ("+op.toString(16)+") args=["+a.join(", ")+"] ret="+s(ret));
          }
        }catch(e){}
        return ret;
      };
    });
    done=true; send("ms.bd.c.m.a hooked ("+M.a.overloads.length+" overloads)");
    return true;
  }
  if(!hook()){ var t=setInterval(function(){ if(hook()||tries>120) clearInterval(t); },400); }
});
