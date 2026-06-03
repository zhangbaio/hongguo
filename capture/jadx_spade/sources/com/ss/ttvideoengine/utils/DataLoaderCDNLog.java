package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.net.URL;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DataLoaderCDNLog {
    public long contentLength;
    public String fileKey;
    public String host;
    public long reqEndT;
    public long reqStartT;
    public String serverIp;
    public String url;
    public String xCache;
    public String xMCache;

    static {
        Covode.recordClassIndex(652738);
    }

    public static JSONObject process(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                String host = new URL(optString).getHost();
                if (!TextUtils.isEmpty(host)) {
                    jSONObject.put("host", host);
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public DataLoaderCDNLog(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            try {
                this.url = jSONObject.optString("url");
                this.host = new URL(this.url).getHost();
                this.serverIp = jSONObject.optString("server_ip");
                this.xCache = jSONObject.optString("x_cache");
                this.xMCache = jSONObject.optString("x_m_cache");
                this.fileKey = jSONObject.optString("f_key");
                this.contentLength = jSONObject.optLong("contentLength", -1L);
                this.reqStartT = jSONObject.optLong("req_start_t", -1L);
                this.reqEndT = jSONObject.optLong("req_end_t", -1L);
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        throw new Exception("log null");
    }
}
