// 探测 0x27d288 真实参数语义: 换x0 url / 清零x6x7 / 看x1指向什么
const meta=Process.getModuleByName("libmetasec_ml.so");
const F=new NativeFunction(meta.base.add(0x27d288),'pointer',
  ['pointer','pointer','pointer','pointer','pointer','pointer','pointer','pointer']);
let n=0;
Interceptor.attach(meta.base.add(0x27d288),{
  onEnter(a){ if(n>=1){return;} n++;
    const A=[]; for(let i=0;i<8;i++) A.push(a[i]);
    console.log("\n=== 真实调用 ===");
    console.log("x0->\""+A[0].readUtf8String().slice(0,50)+"\"");
    // x1 指向什么?
    let x1deref="?"; try{ x1deref=A[1].readUtf8String().slice(0,60);}catch(e){ try{x1deref="ptr->"+A[1].readPointer();}catch(e2){}}
    console.log("x1->\""+x1deref+"\"");
    console.log("x2=0x"+A[2].toString(16)+" x3=0x"+A[3].toString(16)+" x4=0x"+A[4].toString(16)+" x5=0x"+A[5].toString(16));
    console.log("x6=0x"+A[6].toString(16)+" x7=0x"+A[7].toString(16));
    function call(tag,args){ try{ const r=F.apply(null,args); console.log(tag+": "+(r.isNull()?"NULL":"OK \""+r.readUtf8String().slice(0,16)+"\"")); }catch(e){console.log(tag+" ERR "+e);} }
    // 1) 原样
    call("[原样]",[A[0],A[1],A[2],A[3],A[4],A[5],A[6],A[7]]);
    // 2) 清零 x6,x7
    call("[x6x7=0]",[A[0],A[1],A[2],A[3],A[4],A[5],ptr(0),ptr(0)]);
    // 3) 换我的 url (x0)
    const myurl=Memory.allocUtf8String("https://api5-normal-sinfonlinea.fqnovel.com/reading/bookapi/search/tab/v?aid=8662&query=mytest&device_id=1325332544628567");
    call("[换myurl]",[myurl,A[1],A[2],A[3],A[4],A[5],A[6],A[7]]);
    // 4) 换我的 url + 我的 header
    const myhdr=Memory.allocUtf8String("content-type\r\napplication/json; charset=utf-8\r\nx-ss-stub\r\n");
    call("[换my url+hdr]",[myurl,myhdr,A[2],A[3],A[4],A[5],A[6],A[7]]);
  }
});
console.log("[*] probe 就绪");
