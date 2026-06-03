package com.ss.ttvideoengine.net;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class HTTPDNS extends BaseDNS {
    private static String mTTDNSServerHost;
    private int mHttpDNSType;

    static {
        Covode.recordClassIndex(652580);
        mTTDNSServerHost = "";
    }

    private static String getTTDNSServerHost() {
        String str;
        synchronized (LocalDNS.class) {
            str = mTTDNSServerHost;
        }
        return str;
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        getTTDNSServerHost();
        sb.append("https://" + mTTDNSServerHost + "/q?host=");
        sb.append(this.mHostname);
        String sb2 = sb.toString();
        TTVideoEngineLog.d("HTTPDNS", "http dns parse url is" + sb2);
        return sb2;
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void start() {
        String _getURL = _getURL();
        Method[] declaredMethods = this.mNetClient.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Method method = declaredMethods[i];
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            this.mNetClient.startTask(_getURL, (Map<String, String>) null, (JSONObject) null, 0, new TTVNetClient.CompletionListener() { // from class: com.ss.ttvideoengine.net.HTTPDNS.1
                @Override // com.ss.ttvideoengine.net.TTVNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        } else {
            this.mNetClient.startTask(_getURL, null, new TTVNetClient.CompletionListener() { // from class: com.ss.ttvideoengine.net.HTTPDNS.2
                @Override // com.ss.ttvideoengine.net.TTVNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        }
    }

    public static void setTTDNSServerHost(String str) {
        synchronized (LocalDNS.class) {
            if (!TextUtils.isEmpty(str)) {
                mTTDNSServerHost = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        Error error2;
        if (error != null) {
            error.domain = "kTTVideoErrorDomainHTTPDNS";
        } else {
            String str = "TT_";
            if (jSONObject != null && jSONObject.length() != 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    try {
                        jSONObject.put("time", System.currentTimeMillis());
                        jSONObject.put("dns_type", "httpDNS");
                    } catch (JSONException e) {
                        TTVideoEngineLog.d(e);
                    }
                    notifySuccess(jSONObject);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                if (this.mHttpDNSType != 2) {
                    str = "ALI_";
                }
                sb.append(str);
                sb.append("HTTP dns empty");
                error2 = new Error("kTTVideoErrorDomainHTTPDNS", -9997, sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (this.mHttpDNSType != 2) {
                    str = "ALI_";
                }
                sb2.append(str);
                sb2.append("HTTP dns empty");
                error2 = new Error("kTTVideoErrorDomainHTTPDNS", -9997, sb2.toString());
            }
            error = error2;
        }
        notifyError(error);
    }

    public HTTPDNS(String str, TTVNetClient tTVNetClient, int i) {
        super(str, tTVNetClient);
        String str2;
        this.mHttpDNSType = i;
        StringBuilder sb = new StringBuilder();
        sb.append("DNS use HTTPDNS");
        if (i == 2) {
            str2 = "_TT";
        } else {
            str2 = "_ALI";
        }
        sb.append(str2);
        TTVideoEngineLog.i("HTTPDNS", sb.toString());
    }
}
