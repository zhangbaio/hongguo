// 定位 header(x1) 的格式要求
const meta=Process.getModuleByName("libmetasec_ml.so");
const F=new NativeFunction(meta.base.add(0x27d288),'pointer',
  ['pointer','pointer','pointer','pointer','pointer','pointer','pointer','pointer']);
let n=0;
Interceptor.attach(meta.base.add(0x27d288),{
  onEnter(a){ if(n>=1){return;} n++;
    const A=[a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7]];
    const realhdr=A[1].readUtf8String();
    console.log("真实header全文:\n"+JSON.stringify(realhdr));
    const myurl=Memory.allocUtf8String("https://api5-normal-sinfonlinea.fqnovel.com/reading/bookapi/search/tab/v?aid=8662&query=mytest");
    function call(tag,hdrStr){ const h=Memory.allocUtf8String(hdrStr);
      try{ const r=F(myurl,h,A[2],A[3],A[4],A[5],A[6],A[7]); console.log(tag+": "+(r.isNull()?"NULL":"OK")); }catch(e){console.log(tag+" ERR");} }
    call("[复制真header]", realhdr);
    call("[最小:ct]", "content-type\r\napplication/json; charset=utf-8\r\n");
    call("[ct+stub空]", "content-type\r\napplication/json; charset=utf-8\r\nx-ss-stub\r\n\r\n");
    call("[空]", "");
    call("[只stub]", "x-ss-stub\r\nD41D8CD98F00B204E9800998ECF8427E\r\n");
    // 真header但换url已知OK; 试真header去掉cookie行
    const noCookie=realhdr.split("\r\n").slice(2).join("\r\n");
    call("[真header去cookie]", noCookie);
  }
});
console.log("[*] probe_hdr 就绪");
