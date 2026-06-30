// 抓一组完整签名输入输出(精确), 用于 unidbg 离线复现验证
const meta=Process.getModuleByName("libmetasec_ml.so");
const SIGN=0x27d288;
let captured=0;
Interceptor.attach(meta.base.add(SIGN),{
  onEnter(a){ if(captured>=2){return;} this.cap=true;
    this.url=a[0]; this.hdr=a[1];
    this.x2=a[2]; this.x3=a[3]; this.x4=a[4]; this.x5=a[5];
  },
  onLeave(r){ if(!this.cap || captured>=2) return; captured++;
    console.log("\n########## 样本"+captured+" ##########");
    console.log("URL_LEN="+ (this.url.readUtf8String()||"").length);
    console.log("URL="+this.url.readUtf8String());
    let hdr=""; try{hdr=this.hdr.readUtf8String();}catch(e){hdr="<读取失败>";}
    console.log("HDR_REPR="+JSON.stringify(hdr));
    console.log("x2=0x"+this.x2.toString(16)+"  x3=0x"+this.x3.toString(16)+"  x4=0x"+this.x4.toString(16)+"  x5=0x"+this.x5.toString(16));
    console.log("x3_dec="+this.x3.toString()+"  x5_dec="+this.x5.toString());
    let ret=""; try{ret=r.readUtf8String();}catch(e){ret="<读取失败>";}
    console.log("RET_REPR="+JSON.stringify(ret));
    console.log("########## 样本"+captured+" END ##########");
  }
});
console.log("[*] grab hook on METASEC+0x"+SIGN.toString(16)+"  base="+meta.base);
