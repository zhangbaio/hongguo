// 抓完整 metasec init 配置(op1=0x4000001 的 JSON, 含 license)
let done=false, got=false;
function install(){
  if(done) return; const meta=Process.findModuleByName("libmetasec_ml.so"); if(!meta) return;
  Interceptor.attach(meta.base.add(0x26e684),{
    onEnter(a){ const op1=a[2].toInt32();
      if(op1!==0x4000001 || got) return;
      try{ const env=a[0]; const GetStringUtfChars=env.readPointer().add(169*8).readPointer();
        const f=new NativeFunction(GetStringUtfChars,'pointer',['pointer','pointer','pointer']);
        if(!a[5].isNull()){ const cs=f(env,a[5],ptr(0)); const s=cs.readUtf8String();
          got=true; console.log("###INITCFG_START###"); console.log(s); console.log("###INITCFG_END### len="+s.length); } }catch(e){ console.log("err "+e); }
    }
  });
  done=true; console.log("[*] hooked. metasec="+meta.base);
}
install();
if(!done){ const dl=Module.findGlobalExportByName("android_dlopen_ext"); if(dl) Interceptor.attach(dl,{onLeave(){install();}});
  const iv=setInterval(()=>{install(); if(done)clearInterval(iv);},80); }
