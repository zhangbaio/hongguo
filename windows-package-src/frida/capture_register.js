// 抓 fresh 状态下真实的 device_register/device_update(url全参数 + 签名 + 是否成功)
let done=false, n=0;
function install(){
  if(done) return; const meta=Process.findModuleByName("libmetasec_ml.so"); if(!meta) return;
  Interceptor.attach(meta.base.add(0x27d288),{
    onEnter(a){ try{ this.url=a[0].readUtf8String(); this.hdr=a[1].readUtf8String(); }catch(e){ this.url=null; } },
    onLeave(r){ if(!this.url) return;
      if(/device_register|device_update|\/service\/2\/device/.test(this.url)){ n++;
        let sig=""; try{ sig=r.readUtf8String(); }catch(e){}
        console.log("\n###REGCALL#"+n+"###");
        console.log("URL="+this.url);
        console.log("HDR="+JSON.stringify(this.hdr));
        console.log("SIG="+JSON.stringify((sig||"").slice(0,200)));
      }
    }
  });
  done=true; console.log("[*] capture_register 就绪 metasec="+meta.base);
}
install();
if(!done){ const dl=Module.findGlobalExportByName("android_dlopen_ext"); if(dl) Interceptor.attach(dl,{onLeave(){install();}});
  const iv=setInterval(()=>{install(); if(done)clearInterval(iv);},80); }
console.log("[*] loaded");
