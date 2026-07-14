// 看设备何时打开 .mss/.msp/.msf 状态文件 + backtrace(定位加载证书的metasec函数/触发点)
function off(p){ const m=Process.findModuleByAddress(p); return m?m.name+"+0x"+p.sub(m.base).toString(16):p.toString(); }
let done=false, hits=0;
function install(){
  if(done) return; const meta=Process.findModuleByName("libmetasec_ml.so"); if(!meta) return;
  ["open","openat"].forEach(name=>{
    const p=Module.findGlobalExportByName(name); if(!p) return;
    Interceptor.attach(p,{ onEnter(a){ try{
      const path=(name==="open"?a[0]:a[1]).readUtf8String();
      if(path && /\.ms[spf]|\.mss_|\.msp_|\.msf/.test(path)){ hits++;
        if(hits<=12){ console.log("\n["+name+"] "+path);
          console.log("  bt:\n   "+Thread.backtrace(this.context,Backtracer.ACCURATE).slice(0,8).map(off).join("\n   ")); }
      } }catch(e){} } });
  });
  done=true; console.log("[*] openat hooked. metasec="+meta.base);
}
install();
if(!done){ const dl=Module.findGlobalExportByName("android_dlopen_ext"); if(dl) Interceptor.attach(dl,{onLeave(){install();}});
  const iv=setInterval(()=>{install(); if(done)clearInterval(iv);},80); }
console.log("[*] loaded");
