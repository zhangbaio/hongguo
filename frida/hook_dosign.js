// 全面抓红果 sign 指针来源
function metaInfo(){ const m=Process.findModuleByName("libmetasec_ml.so"); return m?{lo:m.base,hi:m.base.add(m.size),b:m.base}:null; }
function showPtr(tag,p){ if(p.isNull()){console.log(tag+" NULL");return;}
  const mi=metaInfo();
  if(mi && p.compare(mi.lo)>=0 && p.compare(mi.hi)<0){ console.log(tag+" ptr="+p+"  >>> METASEC off=0x"+p.sub(mi.b).toString(16)+" <<<"); return; }
  let m=null; try{m=Process.findModuleByAddress(p);}catch(e){}
  console.log(tag+" ptr="+p+"  mod="+(m?m.name+"+0x"+p.sub(m.base).toString(16):"?")); }

let done=false;
function install(){
  if(done) return; const sc=Process.findModuleByName("libsscronet.so"); if(!sc) return;
  function H(name, leaveSignPtr){ try{ const p=sc.getExportByName(name);
    Interceptor.attach(p,{ onEnter(a){ this.a0=a[0]; this.a1=a[1]; },
      onLeave(r){ if(leaveSignPtr){ showPtr("["+name+" ret]", r);} else { showPtr("["+name+" arg1]", this.a1); } } });
    return true; }catch(e){ return false; } }
  H("Cronet_ClientOpaqueData_do_sign_set", false);
  H("Cronet_ClientOpaqueData_do_sign_get", true);
  // Create 返回 opaque, 记下以便后续读 [opaque+0x68]
  try{ const cp=sc.getExportByName("Cronet_ClientOpaqueData_Create");
    Interceptor.attach(cp,{ onLeave(r){ if(!r.isNull()){ global._opq=r; console.log("[OpaqueData_Create] opaque="+r);
      try{ const f=r.add(0x68).readPointer(); if(!f.isNull()) showPtr("   [opaque+0x68 立即]", f);}catch(e){} } } }); }catch(e){}
  done=true;
  const mi=metaInfo();
  console.log("[*] installed. sscronet="+sc.base+" metasec="+(mi?mi.b:"?"));
}
install();
if(!done){ const dl=Module.findGlobalExportByName("android_dlopen_ext"); if(dl) Interceptor.attach(dl,{onLeave(){install();}});
  const iv=setInterval(()=>{install(); if(done)clearInterval(iv);},150); }

// hook dlsym 看 metasec 何时解析 do_sign 符号
try{ const ds=Module.findGlobalExportByName("dlsym");
  Interceptor.attach(ds,{ onEnter(a){ try{ this.n=a[1].readCString(); }catch(e){ this.n=null; } },
    onLeave(r){ if(this.n && /do_sign|do_sign_set|OpaqueData|Engine_SetOpaque/.test(this.n)) console.log("[dlsym] "+this.n+" -> "+r); } }); }catch(e){}

// 周期性主动读 opaque+0x68
setInterval(()=>{ if(global._opq){ try{ const f=global._opq.add(0x68).readPointer(); if(!f.isNull()) showPtr("[轮询 opaque+0x68]", f); }catch(e){} } }, 1500);
console.log("[*] script loaded");
