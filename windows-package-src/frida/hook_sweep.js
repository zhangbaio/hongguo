// 广撒网: hook cronet 注册类导出, 任一参数指向 libmetasec 即记录(= metasec 注册回调/sign)
function metaRange(){ const m=Process.findModuleByName("libmetasec_ml.so"); return m?{b:m.base,lo:m.base,hi:m.base.add(m.size)}:null; }
function inMeta(p){ const mi=metaRange(); return mi && p.compare(mi.lo)>=0 && p.compare(mi.hi)<0; }
const seen={};
let installed=false;
function install(){
  if(installed) return; const sc=Process.findModuleByName("libsscronet.so"); if(!sc) return;
  const exps=sc.enumerateExports();
  const re=/[Rr]egister|_set|_add|[Cc]allback|[Dd]elegate|[Oo]paque|[Ss]ign|Oec|OEC|[Ii]nit|CreateWith|SetClientContext|auth/;
  let n=0;
  exps.forEach(e=>{ if(e.type!=="function" || !re.test(e.name)) return;
    try{ Interceptor.attach(e.address,{ onEnter(a){
      for(let i=0;i<6;i++){ let v; try{v=a[i];}catch(_){break;} if(v && !v.isNull() && inMeta(v)){
        const mi=metaRange(); const key=e.name+":"+i;
        if(!seen[key]){ seen[key]=1; console.log("[HIT] "+e.name+" arg"+i+" -> METASEC+0x"+v.sub(mi.b).toString(16)); }
      } }
    } }); n++; }catch(_){}
  });
  installed=true;
  console.log("[*] swept "+n+" exports. metasec="+(metaRange()?metaRange().b:"未加载"));
}
install();
if(!installed){ const dl=Module.findGlobalExportByName("android_dlopen_ext"); if(dl) Interceptor.attach(dl,{onLeave(){install();}});
  const iv=setInterval(()=>{install(); if(installed)clearInterval(iv);},120); }
console.log("[*] script loaded");
