// 在真实cronet调用的hook内, 用完全相同的参数(同线程)递归重调, 判断是参数还是上下文问题
const meta=Process.getModuleByName("libmetasec_ml.so");
const signFn=new NativeFunction(meta.base.add(0x27d288),'pointer',
  ['pointer','pointer','pointer','pointer','pointer','pointer','pointer','pointer']);
let tested=0;
Interceptor.attach(meta.base.add(0x27d288),{
  onEnter(a){
    if(tested>=2){return;} tested++;
    // 完整抓 x0-x7
    const A=[]; for(let i=0;i<8;i++) A.push(a[i]);
    console.log("\n=== 真实调用#"+tested+" ===");
    console.log("x0(url)="+A[0].readUtf8String().slice(0,60));
    console.log("x2=0x"+A[2].toString(16)+" x3=0x"+A[3].toString(16)+" x4=0x"+A[4].toString(16)+" x5=0x"+A[5].toString(16)+" x6=0x"+A[6].toString(16)+" x7=0x"+A[7].toString(16));
    // 同线程递归重调(用完全相同的8个寄存器)
    try{
      const r=signFn(A[0],A[1],A[2],A[3],A[4],A[5],A[6],A[7]);
      console.log("递归重调结果: "+(r.isNull()?"NULL":("\""+r.readUtf8String().slice(0,50)+"...\"")));
    }catch(e){ console.log("递归重调异常: "+e); }
  },
  onLeave(r){ if(tested<=2) console.log("原始调用返回: "+(r.isNull()?"NULL":"有效 \""+r.readUtf8String().slice(0,20)+"\"")); }
});
console.log("[*] replay hook 就绪 metasec="+meta.base);
