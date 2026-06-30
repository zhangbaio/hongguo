// hook cronet 加 header 的导出, 抓 x-argus 值写入时的 backtrace -> 定位 signer
function off(p){ const m=Process.findModuleByAddress(p); return m?m.name+"+0x"+p.sub(m.base).toString(16):p.toString(); }
function rdstr(p){ try{ return p.readUtf8String(); }catch(e){ try{return p.readCString();}catch(e2){return "?";} } }
const sc=Process.getModuleByName("libsscronet.so");
const TARGETS=["Cronet_UrlRequestParams_request_headers_add","Cronet_HeaderList_header_list_add",
  "Cronet_HttpHeader_name_set","Cronet_HttpHeader_value_set"];
let hooked=0;
TARGETS.forEach(name=>{ try{ const p=sc.getExportByName(name);
  Interceptor.attach(p,{ onEnter(a){
    // 各 API 参数不同, 试着读 a[1]/a[2] 为字符串
    let s1=rdstr(a[1]), s2=rdstr(a[2]);
    const blob=(s1+" "+s2).toLowerCase();
    if(/x-argus|x-gorgon|x-ladon|x-khronos|x-tython/.test(blob)){
      console.log("\n["+name+"] "+s1+" = "+(s2&&s2.length>40?s2.slice(0,40)+"...":s2));
      console.log("  bt:\n   "+Thread.backtrace(this.context,Backtracer.ACCURATE).slice(0,10).map(off).join("\n   "));
    }
  } }); hooked++; }catch(e){} });
console.log("[*] hooked "+hooked+"/"+TARGETS.length+" header APIs. metasec="+Process.getModuleByName("libmetasec_ml.so").base);
