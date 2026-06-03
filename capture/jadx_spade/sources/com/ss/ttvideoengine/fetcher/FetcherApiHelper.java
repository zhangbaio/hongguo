package com.ss.ttvideoengine.fetcher;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.AppInfo;
import com.ss.ttvideoengine.BaseAppInfo;
import com.ss.ttvideoengine.InfoWrapper;
import com.ss.ttvideoengine.net.ChannelSelect;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FetcherApiHelper {
    private int mApiVersion;
    private String mAuthorization;
    private final String mCodecType;
    private final boolean mDashEnable;
    private final boolean mEncryptEnable;
    private final boolean mHlsEnable;
    private HashMap<String, String> mParams;

    static {
        Covode.recordClassIndex(652436);
    }

    public int getApiVersion() {
        return this.mApiVersion;
    }

    public String getAuthorization() {
        return this.mAuthorization;
    }

    public String getAPIString() {
        if (TextUtils.isEmpty(this.mAuthorization)) {
            TTVideoEngineLog.d("FetcherApiHelper", "getAPIString null");
            return null;
        }
        String addParam = addParam(addHostToUrl(), this.mAuthorization);
        TTVideoEngineLog.d("FetcherApiHelper", "getAPIString " + addParam);
        return addParam;
    }

    private String addHostToUrl() {
        String host = getHost();
        TTVideoEngineLog.d("FetcherApiHelper", "getHost " + host);
        if (TextUtils.isEmpty(host)) {
            return this.mAuthorization;
        }
        if (this.mAuthorization.startsWith("http")) {
            String replaceHostInURL = TTHelper.replaceHostInURL(this.mAuthorization, host);
            if (!TextUtils.isEmpty(replaceHostInURL)) {
                return replaceHostInURL;
            }
            return this.mAuthorization;
        }
        StringBuilder sb = new StringBuilder();
        if (host.startsWith("http")) {
            sb.append(host);
            sb.append("?");
            sb.append(this.mAuthorization);
            return sb.toString();
        }
        sb.append("https://");
        sb.append(host);
        sb.append("?");
        sb.append(this.mAuthorization);
        return sb.toString();
    }

    private String getHost() {
        if (!TextUtils.isEmpty(BaseAppInfo.mOpenApiHostName)) {
            return BaseAppInfo.mOpenApiHostName;
        }
        if (InfoWrapper.getUseHostSelect()) {
            if (this.mApiVersion == 2) {
                ChannelSelect.getInstance().setHostList(2, InfoWrapper.getTopHostArray());
            } else {
                ChannelSelect.getInstance().setHostList(4, InfoWrapper.getTopHostArrayV2());
            }
            String selectNext = ChannelSelect.getInstance().selectNext(this.mApiVersion, null);
            if (!TextUtils.isEmpty(selectNext)) {
                return selectNext;
            }
        }
        if (this.mApiVersion == 2) {
            JSONArray topHostArray = InfoWrapper.getTopHostArray();
            if (!TTHelper.isEmpty(topHostArray)) {
                Object opt = topHostArray.opt(0);
                if (opt instanceof String) {
                    return (String) opt;
                }
            }
            return AppInfo.getDefaultVodTopHost();
        }
        JSONArray topHostArrayV2 = InfoWrapper.getTopHostArrayV2();
        if (!TTHelper.isEmpty(topHostArrayV2)) {
            Object opt2 = topHostArrayV2.opt(0);
            if (opt2 instanceof String) {
                return (String) opt2;
            }
        }
        return AppInfo.getDefaultVodTopHostV2();
    }

    public void setParams(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            HashMap<String, String> hashMap = new HashMap<>();
            this.mParams = hashMap;
            hashMap.putAll(map);
        }
    }

    private String getAuthorization(String str) {
        TTVideoEngineLog.d("FetcherApiHelper", "getAuthorization " + str);
        String base64Decode = TTHelper.base64Decode(str);
        if (TextUtils.isEmpty(base64Decode)) {
            TTVideoEngineLog.d("FetcherApiHelper", "getAuthorization result null");
            return null;
        }
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(base64Decode);
            String optString = jSONObject.optString("GetPlayInfoToken");
            if (!TextUtils.isEmpty(optString)) {
                base64Decode = optString;
            }
            str2 = jSONObject.optString("TokenVersion");
            if (!TextUtils.isEmpty(str2) && str2.equals("V2")) {
                this.mApiVersion = 4;
            } else {
                this.mApiVersion = 2;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TTVideoEngineLog.d("FetcherApiHelper", "getAuthorization result:" + base64Decode + ", version:" + str2);
        return base64Decode;
    }

    public FetcherApiHelper(String str, String str2) {
        this(str, null, 1, false, false, false, str2);
    }

    private String addParam(String str, String str2) {
        HashMap<String, String> hashMap;
        HashMap<String, String> hashMap2 = this.mParams;
        if (hashMap2 != null && !hashMap2.isEmpty()) {
            hashMap = this.mParams;
        } else {
            hashMap = new HashMap<>();
        }
        int i = this.mApiVersion;
        if (i == 2) {
            if (this.mHlsEnable) {
                hashMap.put("format_type", "hls");
            }
            if (this.mDashEnable) {
                hashMap.put("format_type", "dash");
            }
            if (TextUtils.equals(this.mCodecType, "bytevc1") && !str2.contains("codec_type")) {
                hashMap.put("codec_type", "1");
            }
            if (this.mEncryptEnable) {
                hashMap.put("stream_type", "evideo");
            }
        } else if (i == 4 && !str2.contains("Codec")) {
            if (TextUtils.equals(this.mCodecType, "bytevc1")) {
                hashMap.put("Codec", "bytevc1");
            } else if (TextUtils.equals(this.mCodecType, "bytevc2")) {
                hashMap.put("Codec", "bytevc2");
            }
        }
        hashMap.put("device_type", Build.MODEL);
        hashMap.put("device_platform", "android");
        hashMap.put("aid", InfoWrapper.getAppID());
        String deviceID = InfoWrapper.getDeviceID();
        if (!TextUtils.isEmpty(deviceID)) {
            hashMap.put("device_id", deviceID);
        }
        if (!TextUtils.isEmpty(BaseAppInfo.mAppVersion)) {
            hashMap.put("version_code", BaseAppInfo.mAppVersion);
        }
        StringBuilder sb = new StringBuilder(str);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            sb.append(String.format("&%s=%s", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public FetcherApiHelper(String str, boolean z, boolean z2, boolean z3, String str2) {
        this(str, null, 1, z, z2, z3, str2);
    }

    public FetcherApiHelper(String str, int i, boolean z, boolean z2, boolean z3, String str2) {
        this(null, str, i, z, z2, z3, str2);
    }

    public FetcherApiHelper(String str, String str2, int i, boolean z, boolean z2, boolean z3, String str3) {
        this.mDashEnable = z;
        this.mHlsEnable = z2;
        this.mEncryptEnable = z3;
        this.mCodecType = str3;
        this.mAuthorization = str2;
        this.mApiVersion = i;
        if (TextUtils.isEmpty(str2)) {
            this.mAuthorization = getAuthorization(str);
        }
        TTVideoEngineLog.d("FetcherApiHelper", "new FetcherApiHelper authorization " + this.mAuthorization + "， apiVersion " + this.mApiVersion + "， mCodecType " + str3);
    }
}
