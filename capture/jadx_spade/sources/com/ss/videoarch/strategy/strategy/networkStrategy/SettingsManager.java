package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel.CharacterConfig;
import com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel.LSStrategySDKSettings;
import com.ss.videoarch.strategy.utils.JNINamespace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SettingsManager {
    private Map<String, List<StrategyConfigUpdateCallBack>> mCallBackMap;

    public static class LSToggles {
        public int mBasePostRequestInterval = 300;
        public boolean mEnableSelectNode = false;
        public String mDomainInfos = "";
        public String mRequestId = "";
        public String mNodeInfos = null;
        public String mSettings = "";
        public String mClientInfos = "";
        public String mProjectSettings = "";
        public String mStrategyConfigJSON = "";
        public String mFeatureConfigJSON = "";
        public String mCommonConfigJSON = "";
        public String mUidFeatureJSON = "";

        static {
            Covode.recordClassIndex(653187);
        }
    }

    public interface StrategyConfigUpdateCallBack {
        void onConfigUpdated(String str);
    }

    static {
        Covode.recordClassIndex(653186);
    }

    private native boolean nativeGetCharacterConfig(String str, String str2, CharacterConfig characterConfig);

    private native boolean nativeGetLSSettings(String str, LSToggles lSToggles);

    private native String nativeGetStrategyConfigByName(String str, String str2);

    private native LSStrategySDKSettings nativeGetStrategySDKSettings(String str, LSStrategySDKSettings lSStrategySDKSettings);

    private native void nativeLoadDB();

    private native void nativeRegisterStrategyConfigUpdate(String str);

    private native void nativeSendRequest(String str, ResponseData responseData);

    private native void nativeSetSDKParams(String str);

    private static class b {
        private static final SettingsManager a;

        static {
            Covode.recordClassIndex(653189);
            a = new SettingsManager();
        }
    }

    public static SettingsManager getInstance() {
        return b.a;
    }

    private SettingsManager() {
        this.mCallBackMap = new HashMap();
    }

    public void loadDB() {
        if (lj6.a.m().S == 1 && com.ss.videoarch.strategy.utils.b.a()) {
            Log.d("VeLSSettingsManager", "nativeLoadDB");
            nativeLoadDB();
        }
    }

    public class ResponseData {
        public int responseCost;
        public String responseJsonStr = "";
        public int statusCode;

        static {
            Covode.recordClassIndex(653188);
        }

        public ResponseData() {
        }
    }

    public void SetSDKParams(String str) {
        if (!com.ss.videoarch.strategy.utils.b.a()) {
            return;
        }
        if (lj6.a.m().r.e.mEnableSetSDKParams != 1) {
            Log.d("VeLSSettingsManager", "SetSDKParams toggle off");
        } else {
            nativeSetSDKParams(str);
        }
    }

    public ResponseData sendRequest(String str) {
        ResponseData responseData = new ResponseData();
        if (!com.ss.videoarch.strategy.utils.b.a()) {
            return responseData;
        }
        Log.d("VeLSSettingsManager", "sendRequest: retryHost: " + str);
        nativeSendRequest(str, responseData);
        Log.d("VeLSSettingsManager", "code: " + responseData.statusCode + ", response length:" + responseData.responseJsonStr.length());
        return responseData;
    }

    public LSStrategySDKSettings getStrategySDKSettings(String str, LSStrategySDKSettings lSStrategySDKSettings) {
        if (!TextUtils.isEmpty(str) && com.ss.videoarch.strategy.utils.b.a()) {
            Log.d("VeLSSettingsManager", "getStrategySDKSettings");
            return nativeGetStrategySDKSettings(str, lSStrategySDKSettings);
        }
        Log.d("VeLSSettingsManager", "empty jsonStr");
        return lSStrategySDKSettings;
    }

    public String getStrategyConfigByName(String str, String str2) {
        if (!com.ss.videoarch.strategy.utils.b.a()) {
            return "";
        }
        Log.d("VeLSSettingsManager", "getStrategyConfigByName:" + str2);
        return nativeGetStrategyConfigByName(str, str2);
    }

    public void onConfigUpdate(String str, String str2) {
        List<StrategyConfigUpdateCallBack> list;
        if (!this.mCallBackMap.containsKey(str) || (list = this.mCallBackMap.get(str)) == null) {
            return;
        }
        for (StrategyConfigUpdateCallBack strategyConfigUpdateCallBack : list) {
            if (strategyConfigUpdateCallBack != null) {
                strategyConfigUpdateCallBack.onConfigUpdated(str2);
            }
        }
    }

    public void registerStrategyConfigUpdate(String str, StrategyConfigUpdateCallBack strategyConfigUpdateCallBack) {
        if (this.mCallBackMap.containsKey(str)) {
            List<StrategyConfigUpdateCallBack> list = this.mCallBackMap.get(str);
            Objects.requireNonNull(list);
            list.add(strategyConfigUpdateCallBack);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(strategyConfigUpdateCallBack);
            this.mCallBackMap.put(str, arrayList);
        }
        if (!com.ss.videoarch.strategy.utils.b.a()) {
            return;
        }
        nativeRegisterStrategyConfigUpdate(str);
    }

    public boolean getFeatureConfig(String str, mj6.b bVar) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        if (!com.ss.videoarch.strategy.utils.b.a()) {
            return false;
        }
        Log.d("VeLSSettingsManager", "getFeatureConfig:" + bVar.a);
        CharacterConfig characterConfig = new CharacterConfig();
        if (nativeGetCharacterConfig(str, bVar.a, characterConfig)) {
            try {
                if (characterConfig.mFeaturesList.isEmpty()) {
                    jSONArray = bVar.b;
                } else {
                    jSONArray = new JSONArray((Collection) characterConfig.mFeaturesList);
                }
                bVar.b = jSONArray;
                if (!characterConfig.mRTFeaturesList.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray((Collection) characterConfig.mRTFeaturesList);
                    bVar.d = jSONArray2;
                    bVar.f = jSONArray2.toString();
                }
                if (TextUtils.isEmpty(characterConfig.mFeaturesCollectRules)) {
                    jSONObject = bVar.g;
                } else {
                    jSONObject = new JSONObject(characterConfig.mFeaturesCollectRules);
                }
                bVar.g = jSONObject;
                return true;
            } catch (JSONException e) {
                Log.d("VeLSSettingsManager", e.toString());
                return false;
            }
        }
        Log.e("VeLSSettingsManager", "getFeatureConfig failed");
        return false;
    }

    public boolean initLSSettings(String str, lj6.a aVar) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        if (!TextUtils.isEmpty(str) && com.ss.videoarch.strategy.utils.b.a()) {
            Log.d("VeLSSettingsManager", "initLSSettings");
            LSToggles lSToggles = new LSToggles();
            if (nativeGetLSSettings(str, lSToggles)) {
                aVar.F = lSToggles.mBasePostRequestInterval;
                aVar.u = lSToggles.mEnableSelectNode;
                aVar.h = lSToggles.mRequestId;
                try {
                    if (TextUtils.isEmpty(lSToggles.mDomainInfos)) {
                        jSONArray = aVar.g;
                    } else {
                        jSONArray = new JSONArray(lSToggles.mDomainInfos);
                    }
                    aVar.g = jSONArray;
                    if (TextUtils.isEmpty(lSToggles.mNodeInfos)) {
                        jSONObject = aVar.i;
                    } else {
                        jSONObject = new JSONObject(lSToggles.mNodeInfos);
                    }
                    aVar.i = jSONObject;
                    if (TextUtils.isEmpty(lSToggles.mSettings)) {
                        jSONObject2 = aVar.b;
                    } else {
                        jSONObject2 = new JSONObject(lSToggles.mSettings);
                    }
                    aVar.b = jSONObject2;
                    if (TextUtils.isEmpty(lSToggles.mClientInfos)) {
                        jSONObject3 = aVar.c;
                    } else {
                        jSONObject3 = new JSONObject(lSToggles.mClientInfos);
                    }
                    aVar.c = jSONObject3;
                    if (TextUtils.isEmpty(lSToggles.mProjectSettings)) {
                        jSONObject4 = aVar.d;
                    } else {
                        jSONObject4 = new JSONObject(lSToggles.mProjectSettings);
                    }
                    aVar.d = jSONObject4;
                    if (TextUtils.isEmpty(lSToggles.mStrategyConfigJSON)) {
                        jSONObject5 = aVar.n;
                    } else {
                        jSONObject5 = new JSONObject(lSToggles.mStrategyConfigJSON);
                    }
                    aVar.n = jSONObject5;
                    if (TextUtils.isEmpty(lSToggles.mFeatureConfigJSON)) {
                        jSONObject6 = aVar.o;
                    } else {
                        jSONObject6 = new JSONObject(lSToggles.mFeatureConfigJSON);
                    }
                    aVar.o = jSONObject6;
                    if (TextUtils.isEmpty(lSToggles.mCommonConfigJSON)) {
                        jSONObject7 = aVar.p;
                    } else {
                        jSONObject7 = new JSONObject(lSToggles.mCommonConfigJSON);
                    }
                    aVar.p = jSONObject7;
                    if (TextUtils.isEmpty(lSToggles.mUidFeatureJSON)) {
                        jSONObject8 = aVar.q;
                    } else {
                        jSONObject8 = new JSONObject(lSToggles.mUidFeatureJSON);
                    }
                    aVar.q = jSONObject8;
                    return true;
                } catch (JSONException e) {
                    Log.d("VeLSSettingsManager", e.toString());
                    return false;
                }
            }
            Log.e("VeLSSettingsManager", "nativeGetLSSettings failed");
            return false;
        }
        Log.d("VeLSSettingsManager", "empty jsonStr");
        return false;
    }
}
