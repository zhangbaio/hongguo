// metasec 把回调表(含sign)注册给cronet: 抓 SetOpaque/SetOecOpaque 的 opaque, 扫出 metasec 指针
let done=false;
function metaRange(){ const m=Process.findModuleByName("libmetasec_ml.so"); return m?{b:m.base,lo:m.base,hi:m.base.add(m.size),sz:m.size}:null; }
function scanStruct(p, words, tag){
  const mi=metaRange(); if(!mi){ console.log("  (metasec未加载, 跳过扫描)"); return; }
  console.log(tag+" 扫描 "+p+" 找 metasec 指针:");
  let found=0;
  for(let i=0;i<words;i++){ try{ const v=p.add(i*8).readPointer();
    if(v.compare(mi.lo)>=0 && v.compare(mi.hi)<0){ console.log("    [+0x"+(i*8).toString(16)+"] -> METASEC+0x"+v.sub(mi.b).toString(16)); found++; }
  }catch(e){} }
  if(!found) console.log("    (无 metasec 指针)");
}
function install(){
  if(done) return; const sc=Process.findModuleByName("libsscronet.so"); if(!sc) return;
  ["Cronet_Engine_SetOecOpaque","Cronet_Engine_SetOpaque"].forEach(name=>{
    try{ const p=sc.getExportByName(name);
      Interceptor.attach(p,{ onEnter(a){ console.log("\n["+name+"] engine="+a[0]+" opaque="+a[1]);
        if(!a[1].isNull()) scanStruct(a[1], 64, "  "); } });
      console.log("[*] hooked "+name);
    }catch(e){ console.log("[!] "+name+" 失败"); }
  });
  // 也hook AddClientOpaqueData / ClientOpaqueData_Create
  ["Cronet_Engine_AddClientOpaqueData","Cronet_ClientOpaqueData_Create"].forEach(name=>{
    try{ const p=sc.getExportByName(name);
      Interceptor.attach(p,{ onEnter(a){ this.a1=a[1]; }, onLeave(r){
        console.log("\n["+name+"] ret/arg="+(name.endsWith("Create")?r:this.a1));
        const t=name.endsWith("Create")?r:this.a1; if(t&&!t.isNull()) scanStruct(t,48,"  "); } }); }catch(e){}
  });
  done=true;
}
install();
if(!done){ const dl=Module.findGlobalExportByName("android_dlopen_ext"); if(dl) Interceptor.attach(dl,{onLeave(){install();}});
  const iv=setInterval(()=>{install(); if(done)clearInterval(iv);},150); }
console.log("[*] script loaded");
