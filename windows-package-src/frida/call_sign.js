// 直接调用 metasec 0x27d288 给任意 url/header 签名(设备已初始化, 直接可用)
const meta=Process.getModuleByName("libmetasec_ml.so");
const signFn=new NativeFunction(meta.base.add(0x27d288),'pointer',
  ['pointer','pointer','int','int64','int64','int']);
function sign(url, header){
  const pu=Memory.allocUtf8String(url);
  const ph=Memory.allocUtf8String(header);
  const tick=new Int64("0x2d641eee02cf");
  const x4=new Int64("0xffffffffffffff");
  const r=signFn(pu, ph, 0x18, tick, x4, 0x3a75b16);
  return r.isNull()?null:r.readUtf8String();
}
// 测试: 一个真实 fqnovel url
const url="https://api5-normal-sinfonlinea.fqnovel.com/reading/bookapi/search/tab/v?aid=8662&device_id=1325332544628567&iid=1325332544632663&version_code=72232&query=test";
const header="x-ss-req-ticket\r\n1782800542209\r\ncontent-type\r\napplication/json; charset=utf-8\r\nx-ss-stub\r\n";
console.log("[*] 调用 0x27d288 签名...");
const sig=sign(url, header);
console.log("###SIG_START###");
console.log(sig);
console.log("###SIG_END###");
// 暴露 RPC
rpc.exports={ sign: sign };
