// 红果 aid-8662 原生签名 RPC: 调 libmetasec 0x27d288(设备已初始化)。
// header 需"非空 + 完整 key\r\nvalue 对"。返回完整 "X-Argus\r\n...\r\n" 串。
const meta=Process.getModuleByName("libmetasec_ml.so");
const SIGN_OFF=0x27d288;
const F=new NativeFunction(meta.base.add(SIGN_OFF),'pointer',
  ['pointer','pointer','pointer','pointer','pointer','pointer','pointer','pointer']);
let tick=0x2d6a9d2f0000, counter=0x3b03000;
function sign(url, header){
  if(!header || header.length===0) header="content-type\r\napplication/json; charset=utf-8\r\n";
  const pu=Memory.allocUtf8String(url);
  const ph=Memory.allocUtf8String(header);
  tick+=0x10000; counter+=2;
  const r=F(pu, ph, ptr(0x18), ptr(tick), ptr("0xffffffffffffff"), ptr(counter), ptr(0), ptr(0));
  return r.isNull()?null:r.readUtf8String();
}
rpc.exports={ sign: sign };
console.log("[*] sign_service 就绪 metasec="+meta.base+" off=0x"+SIGN_OFF.toString(16));
