// 抓签名函数: metasec 在 sign 时通过 JNIEnv->CallStatic*Method 回调 Java MS.b
// 过滤"返回地址∈libmetasec"=> 正在执行签名的 metasec 代码位置
function metaRange(){ const m=Process.findModuleByName("libmetasec_ml.so"); return m?{b:m.base,lo:m.base,hi:m.base.add(m.size)}:null; }
const seen={};
function logRet(ra, tag){
  const mi=metaRange(); if(!mi) return;
  if(ra.compare(mi.lo)>=0 && ra.compare(mi.hi)<0){
    const off=ra.sub(mi.b).toInt32();
    const key=tag+":"+off;
    seen[key]=(seen[key]||0)+1;
    if(seen[key]<=3) console.log(tag+" 返回地址 metasec+0x"+off.toString(16)+" (#"+seen[key]+")");
  }
}
function hookEnv(){
  const env = Java.vm.getEnv();
  const table = env.handle.readPointer();
  // JNINativeInterface 索引: CallStaticObjectMethod=114, V=115, A=116; CallObjectMethod=34,V=35
  const idxs = {114:"CallStaticObj",115:"CallStaticObjV",34:"CallObj",35:"CallObjV",
                49:"CallIntMethod",50:"CallIntMethodV",37:"CallBoolMethod",38:"CallBoolMethodV"};
  for (const idx in idxs){
    const fn = table.add(parseInt(idx)*8).readPointer();
    try{ Interceptor.attach(fn, { onEnter(a){ logRet(this.returnAddress, idxs[idx]); } }); }catch(e){}
  }
  console.log("[*] JNIEnv 表 hook 完成");
}
// 同时 Java 层确认 MS.b 触发并打 op
function hookJava(){
  Java.perform(()=>{
    try{
      const MS = Java.use("com.bytedance.mobsec.metasec.ml.MS");
      const ovs = MS.b.overloads;
      ovs.forEach(o=>{ o.implementation=function(){
        const op = arguments.length>0?arguments[0]:"?";
        console.log("[MS.b] op="+op);
        return o.apply(this, arguments); }; });
      console.log("[*] MS.b hooked ("+ovs.length+" overloads)");
    }catch(e){ console.log("[!] MS.b hook 失败: "+e); }
  });
}
function go(){ hookEnv(); hookJava(); }
if (Java.available) Java.perform(go); else console.log("[!] Java 不可用");
console.log("[*] script loaded");
