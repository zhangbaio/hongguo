// 扫 libsscronet 可写段中落在 libmetasec 区间的指针 = metasec 注册给 cronet 的回调(含 sign)
const sc=Process.getModuleByName("libsscronet.so");
const meta=Process.getModuleByName("libmetasec_ml.so");
const lo=meta.base, hi=meta.base.add(meta.size);
console.log("[*] sscronet="+sc.base+" size=0x"+sc.size.toString(16)+"  metasec="+meta.base+" size=0x"+meta.size.toString(16));
let hits=[];
// 遍历 sscronet 的可写内存段
Process.enumerateRanges('rw-').forEach(r=>{
  if(r.base.compare(sc.base)<0 || r.base.compare(sc.base.add(sc.size))>=0) {
    // 也包含紧邻 sscronet 之后的 .bss(可能单独 range)
  }
  // 只扫与 sscronet 关联的段(文件映射或紧邻)
  const inScronet = r.base.compare(sc.base)>=0 && r.base.compare(sc.base.add(sc.size).add(0x100000))<0;
  if(!inScronet) return;
  const n=r.size/8;
  for(let i=0;i<n;i++){ try{ const a=r.base.add(i*8); const v=a.readPointer();
    if(v.compare(lo)>=0 && v.compare(hi)<0){
      hits.push({at:a, atoff:a.sub(sc.base), moff:v.sub(meta.base)});
    } }catch(e){} }
});
console.log("[*] 命中 "+hits.length+" 个 metasec 指针:");
hits.forEach(h=>{
  // 读目标处前几条指令判断是否函数(stp/sub sp 序言)
  let dis="";
  try{ const ins=Instruction.parse(meta.base.add(h.moff)); dis=ins.mnemonic+" "+ins.opStr; }catch(e){ dis="?"; }
  console.log("  sscronet+0x"+h.atoff.toString(16)+"  ->  METASEC+0x"+h.moff.toString(16)+"   ["+dis+"]");
});
