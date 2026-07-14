// 看 metasec 用 dlsym 解析了哪些 cronet 符号(尤其 sign 回调注册)
function callerMod(ra){ try{ const m=Process.findModuleByAddress(ra); return m?m.name+"+0x"+ra.sub(m.base).toString(16):"?"; }catch(e){return "?";} }
function isMeta(ra){ const m=Process.findModuleByName("libmetasec_ml.so"); return m && ra.compare(m.base)>=0 && ra.compare(m.base.add(m.size))<0; }
let n=0;
function install(){
  const ds=Module.findGlobalExportByName("dlsym"); if(!ds){ setTimeout(install,100); return; }
  Interceptor.attach(ds,{
    onEnter(a){ try{ this.name=a[1].readCString(); }catch(e){ this.name=null; } this.ra=this.returnAddress; },
    onLeave(r){ if(!this.name) return;
      const fromMeta=isMeta(this.ra);
      // 只看 metasec 发起的, 或名字含 cronet/sign/header/opaque
      if(fromMeta || /[Cc]ronet|sign|Sign|header|Header|[Oo]paque|TTNet|callback/.test(this.name)){
        console.log((fromMeta?"[META] ":"[    ] ")+this.name+" -> "+r+"  caller="+callerMod(this.ra)); }
    }
  });
  console.log("[*] dlsym hook installed");
}
install();
console.log("[*] script loaded");
