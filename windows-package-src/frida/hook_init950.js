// 看 0x27d950 是不是 init(调用时机/参数), 以及 0x27d288 sign 调用顺序
function dump(a,n){ let o=[]; for(let i=0;i<n;i++){ let v=a[i]; let s="x"+i+"="+v;
  try{ const str=v.readUtf8String(); if(str&&str.length&&/[ -~]/.test(str[0])) s+=" str=\""+str.slice(0,80)+"\""; }catch(e){}
  o.push(s); } return o.join("  "); }
let order=0, done=false;
function install(){
  if(done) return; const meta=Process.findModuleByName("libmetasec_ml.so"); if(!meta) return;
  [[0x27d950,"INIT?950"],[0x27d288,"SIGN288"]].forEach(([off,tag])=>{
    Interceptor.attach(meta.base.add(off),{
      onEnter(a){ this.t=tag; this.o=++order;
        if(this.o<=8 || tag.startsWith("INIT")) console.log("\n#"+this.o+" ["+tag+"] "+dump(a,6)); },
      onLeave(r){ if(this.o<=8 || this.t.startsWith("INIT")){
        let s=""; try{ const x=r.readUtf8String(); if(x) s=" ret_str=\""+x.slice(0,60)+"\""; }catch(e){}
        console.log("  <<<#"+this.o+" ["+this.t+"] ret="+r+s); } }
    });
    console.log("[*] hooked "+tag+" @ METASEC+0x"+off.toString(16));
  });
  done=true; console.log("[*] metasec="+meta.base);
}
install();
if(!done){ const dl=Module.findGlobalExportByName("android_dlopen_ext"); if(dl) Interceptor.attach(dl,{onLeave(){install();}});
  const iv=setInterval(()=>{install(); if(done)clearInterval(iv);},100); }
console.log("[*] script loaded");
