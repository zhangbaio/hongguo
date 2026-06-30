// hook 两个 metasec 回调候选, dump 参数+返回, 找请求签名函数及调用约定
const meta=Process.getModuleByName("libmetasec_ml.so");
const CANDS=[0x27d288, 0x27d950];
function dumpArg(a,idx){
  let line="  x"+idx+"="+a;
  try{ const s=a.readUtf8String(); if(s && s.length>0 && /[ -~]/.test(s[0])) line+="  str=\""+s.slice(0,120)+"\""; }catch(e){}
  if(!a.isNull()){ try{ const p=a.readPointer();
    try{ const s2=p.readUtf8String(); if(s2 && /[ -~]/.test(s2[0])) line+="  *->str=\""+s2.slice(0,80)+"\""; }catch(e){} }catch(e){} }
  return line;
}
CANDS.forEach((off,ci)=>{
  const addr=meta.base.add(off);
  Interceptor.attach(addr,{
    onEnter(a){ this.off=off;
      console.log("\n===== METASEC+0x"+off.toString(16)+" 进入 =====");
      for(let i=0;i<6;i++){ try{ console.log(dumpArg(a[i],i)); }catch(e){ console.log("  x"+i+" 读失败"); } }
      this.x0=a[0];
    },
    onLeave(r){
      let line="  ret="+r;
      try{ const s=r.readUtf8String(); if(s) line+="  retstr=\""+s.slice(0,200)+"\""; }catch(e){}
      console.log("  <<< METASEC+0x"+this.off.toString(16)+line);
    }
  });
  console.log("[*] hooked METASEC+0x"+off.toString(16)+" @ "+addr);
});
console.log("[*] metasec="+meta.base);
