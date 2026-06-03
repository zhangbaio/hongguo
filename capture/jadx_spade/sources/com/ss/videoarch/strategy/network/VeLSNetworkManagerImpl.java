package com.ss.videoarch.strategy.network;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer;
import com.ss.videoarch.strategy.utils.JNINamespace;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VeLSNetworkManagerImpl {
    static String TAG;
    private com.ss.videoarch.strategy.network.a mHttpApi;

    private native void nativeNotifyNetworkChange(int i);

    private static class a {
        private static final VeLSNetworkManagerImpl a;

        static {
            Covode.recordClassIndex(653161);
            a = new VeLSNetworkManagerImpl();
        }
    }

    public static VeLSNetworkManagerImpl getInstance() {
        return a.a;
    }

    static {
        Covode.recordClassIndex(653160);
        TAG = "VeLSSettingsManager";
    }

    public int getNetworkType() {
        return d.e().c();
    }

    public void notifyNetworkChange() {
        int networkType = getNetworkType();
        Log.d(TAG, "notifyNetworkChange: " + networkType);
        nativeNotifyNetworkChange(networkType);
    }

    public String SendRequest(String str) {
        return sendRequestByGet(str);
    }

    public void init(LSSDKConfig lSSDKConfig) {
        this.mHttpApi = new com.ss.videoarch.strategy.network.a(lSSDKConfig);
    }

    private String sendRequestByGet(String str) {
        if (this.mHttpApi == null) {
            Log.e(TAG, "null mHttpApi");
            return "";
        }
        Log.d(TAG, "sendRequestByGet: " + str);
        try {
            return this.mHttpApi.e(str).toString();
        } catch (Exception e) {
            Log.d(TAG, "sendRequestByGet Exception:" + e.toString());
            return "";
        }
    }

    public JSONObject sendDnsRequestByHosts(List<String> list) {
        Log.d(TAG, "sendDnsRequestByHosts: " + list);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Enabled", true);
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            jSONObject.put("DomainNames", jSONArray);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("HTTPDNSRequest", jSONObject);
            return this.mHttpApi.f("/api/neptune/v3/sdk/PackLiveSDK", jSONObject2);
        } catch (Exception e) {
            Log.d(TAG, "sendDnsRequestByHost Exception:" + e);
            return null;
        }
    }

    public String SendRequest(String str, String str2) {
        return sendRequestByPost(str, str2);
    }

    private String sendRequestByPost(String str, String str2) {
        if (this.mHttpApi == null) {
            Log.e(TAG, "null mHttpApi");
            return "";
        }
        try {
            return this.mHttpApi.f(str, new JSONObject(str2)).toString();
        } catch (Exception e) {
            Log.d(TAG, "sendRequestByPost Exception:" + e.toString());
            return "";
        }
    }

    public String SendRequestWithNodeInfo(String str, String str2, boolean z, boolean z2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = null;
        }
        String G = DnsOptimizer.O().G(z, z2, str3);
        if (!TextUtils.isEmpty(G)) {
            str2 = ((str2.substring(0, str2.length() - 1) + ",") + G) + "}";
        }
        Log.d(TAG, "SendRequestWithNodeInfo:" + str2);
        return sendRequestByPost(str, str2);
    }
}
