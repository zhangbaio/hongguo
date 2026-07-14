// 抓 metasec 分发器 a(env,clazz,op1,op2,long,jstring,jobject) 的 init 调用序列
// JNI native: a(JNIEnv*, jclass, int op1, int op2, jlong, jstring, jobject) @ 0x26e684
let done=false, n=0;
function jstr(env, js){ if(js.isNull()) return null; try{
  const GetStringUtfChars = env.add(764*0).readPointer(); // 用 Java api 更稳, 这里简化
  return "<jstr>"; }catch(e){ return "?"; } }
function install(){
  if(done) return; const meta=Process.findModuleByName("libmetasec_ml.so"); if(!meta) return;
  Interceptor.attach(meta.base.add(0x26e684),{
    onEnter(a){ if(n>=25) return; n++;
      // a0=JNIEnv* a1=jclass a2=op1 a3=op2 a4=jlong a5=jstring a6=jobject
      const op1=a[2].toInt32(), op2=a[3].toInt32();
      let sarg="";
      try{ const env=a[0]; const GetStringUtfChars=env.readPointer().add(169*8).readPointer();
        const f=new NativeFunction(GetStringUtfChars,'pointer',['pointer','pointer','pointer']);
        if(!a[5].isNull()){ const cs=f(env,a[5],ptr(0)); sarg=cs.readUtf8String(); } }catch(e){ sarg="<?>"; }
      this.rec="#"+n+" a(op1=0x"+op1.toString(16)+" op2=0x"+op2.toString(16)+" long=0x"+a[4].toString(16)+" str="+JSON.stringify(sarg)+" obj="+(a[6].isNull()?"null":a[6])+")";
      console.log(this.rec);
    },
    onLeave(r){ if(this.rec){ let s=""; try{const x=r.readUtf8String(); if(x&&/[ -~]/.test(x[0])) s=" ret_str=\""+x.slice(0,40)+"\"";}catch(e){}
      console.log("   <<< ret="+r+s); } }
  });
  done=true; console.log("[*] dispatcher hooked. metasec="+meta.base);
}
install();
if(!done){ const dl=Module.findGlobalExportByName("android_dlopen_ext"); if(dl) Interceptor.attach(dl,{onLeave(){install();}});
  const iv=setInterval(()=>{install(); if(done)clearInterval(iv);},80); }
console.log("[*] loaded");
