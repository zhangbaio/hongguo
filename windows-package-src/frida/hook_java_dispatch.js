// Java层hook分发器 ms.bd.c.m.a 抓init协议(尽早挂, 轮询类加载)
let hooked=false, n=0;
function tryHook(){
  if(hooked) return;
  if(!Java.available){ setTimeout(tryHook,30); return; }
  Java.perform(function(){
    let M;
    try{ M=Java.use("ms.bd.c.m"); }catch(e){ setTimeout(tryHook,30); return; }
    M.a.overload('int','int','long','java.lang.String','java.lang.Object').implementation=function(op1,op2,lv,s,obj){
      n++;
      let desc="obj=null";
      if(obj!==null){ try{ const cn=obj.getClass().getName();
        if(cn==="[B"){ const b=Java.array('byte',obj); let h=""; for(let i=0;i<Math.min(b.length,80);i++)h+=((b[i]&0xff).toString(16).padStart(2,'0')); desc="byte["+b.length+"] "+h; }
        else desc="("+cn+")"+String(obj.toString()).slice(0,120);
      }catch(e){ desc="obj<?>"; } }
      if(n<=30) console.log("#"+n+" a(op1=0x"+(op1>>>0).toString(16)+" op2=0x"+(op2>>>0).toString(16)+" long="+lv+" str="+JSON.stringify(s)+" "+desc+")");
      const r=this.a(op1,op2,lv,s,obj);
      if(n<=30){ let rs="null"; try{ if(r!==null) rs=String(r.toString()).slice(0,50); }catch(e){} console.log("   ret="+rs); }
      return r;
    };
    hooked=true; console.log("[*] Java m.a hooked (n="+n+")");
  });
}
tryHook();
console.log("[*] loaded");
