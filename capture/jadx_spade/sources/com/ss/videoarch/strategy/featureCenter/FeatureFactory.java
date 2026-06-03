package com.ss.videoarch.strategy.featureCenter;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.c;
import com.ss.videoarch.strategy.featureCenter.featureType.d;
import com.ss.videoarch.strategy.featureCenter.featureType.e;
import lj6.a;
import mj6.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FeatureFactory {
    private static volatile FeatureFactory sInstance;

    static {
        Covode.recordClassIndex(653133);
        sInstance = null;
    }

    public static FeatureFactory inst() {
        if (sInstance == null) {
            synchronized (FeatureFactory.class) {
                if (sInstance == null) {
                    sInstance = new FeatureFactory();
                }
            }
        }
        return sInstance;
    }

    private JSONObject getStringExtraInfo(String str) {
        String str2 = (String) a.m().b(str, "");
        if (str2.length() != 0) {
            try {
                return new JSONObject(str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private JSONObject getIntExtraInfo(String str) {
        int intValue = ((Integer) a.m().b(str, -1)).intValue();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, intValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private static JSONObject FeatureList2FeatureBundle(JSONArray jSONArray) {
        JSONObject jSONObject;
        String string;
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        JSONArray jSONArray5 = new JSONArray();
        JSONArray jSONArray6 = new JSONArray();
        JSONArray jSONArray7 = new JSONArray();
        JSONArray jSONArray8 = new JSONArray();
        JSONArray jSONArray9 = new JSONArray();
        JSONArray jSONArray10 = new JSONArray();
        JSONArray jSONArray11 = new JSONArray();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                string = jSONArray.getString(i);
                String b = b.b(string);
                StringBuilder sb = new StringBuilder();
                jSONObject = jSONObject2;
                sb.append("featureName:");
                sb.append(string);
                sb.append(" featureType:");
                sb.append(b);
                Log.d("FeatureFactory", sb.toString());
                b.hashCode();
                switch (b) {
                    case "NETWORK":
                        if (c.d().b != null && c.d().b.f != null && c.d().b.f.contains(string)) {
                            jSONArray5.put(string);
                            break;
                        } else {
                            jSONArray4.put(string);
                            break;
                        }
                        break;
                    case "PLAY":
                        if (TypePlayFeaturesCollector.h().b != null && TypePlayFeaturesCollector.h().b.f != null && TypePlayFeaturesCollector.h().b.f.contains(string)) {
                            jSONArray3.put(string);
                            break;
                        } else {
                            jSONArray2.put(string);
                            break;
                        }
                        break;
                    case "PUSH":
                        if (d.e().b != null && d.e().b.f != null && d.e().b.f.contains(string)) {
                            jSONArray11.put(string);
                            break;
                        } else {
                            jSONArray10.put(string);
                            break;
                        }
                        break;
                    case "USER":
                    case "ANCHOR":
                        if (e.e().b != null && e.e().b.f != null && e.e().b.f.contains(string)) {
                            jSONArray9.put(string);
                            break;
                        } else {
                            jSONArray8.put(string);
                            break;
                        }
                        break;
                    case "DEVICE":
                        if (com.ss.videoarch.strategy.featureCenter.featureType.b.f().b != null && com.ss.videoarch.strategy.featureCenter.featureType.b.f().b.f != null && com.ss.videoarch.strategy.featureCenter.featureType.b.f().b.f.contains(string)) {
                            jSONArray7.put(string);
                            break;
                        } else {
                            jSONArray6.put(string);
                            break;
                        }
                        break;
                }
            } catch (JSONException e) {
                jSONObject = jSONObject2;
                e.printStackTrace();
            }
            i++;
            jSONObject2 = jSONObject;
        }
        try {
            jSONObject2.put("PlayFeaturesBundle", jSONArray2).put("RTPlayFeaturesBundle", jSONArray3).put("NetworkFeaturesBundle", jSONArray4).put("RTNetworkFeaturesBundle", jSONArray5).put("DeviceFeaturesBundle", jSONArray6).put("RTDeviceFeaturesBundle", jSONArray7).put("UserFeaturesBundle", jSONArray8).put("RTUserFeaturesBundle", jSONArray9).put("PushFeaturesBundle", jSONArray10).put("RTPushFeaturesBundle", jSONArray11);
            Log.d("FeatureFactory", "tmpFeaturesBundle" + jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject2;
    }

    public void setFeature(int i, JSONObject jSONObject) {
        switch (i) {
            case 60:
                if (a.m().r.e.mEnableDeviceFeatureData == 1) {
                    com.ss.videoarch.strategy.featureCenter.featureType.b.f().g(jSONObject);
                }
                TypePlayFeaturesCollector.h().j(i, jSONObject);
                break;
            case 61:
            case 62:
                TypePlayFeaturesCollector.h().j(i, jSONObject);
                break;
            case 63:
                TypePlayFeaturesCollector.h().j(i, jSONObject);
                if (a.m().r.e.mEnableDeviceFeatureData == 1) {
                    com.ss.videoarch.strategy.featureCenter.featureType.b.f().h(jSONObject);
                    break;
                }
                break;
        }
    }

    public JSONObject featureFetch(JSONArray jSONArray, String str, String str2) {
        if (jSONArray != null && jSONArray.length() != 0) {
            return featureFetch(FeatureList2FeatureBundle(jSONArray), str, str2);
        }
        return null;
    }

    public static String getFeatures(String str, String str2, String str3) {
        String str4 = "";
        try {
            JSONObject featureFetch = inst().featureFetch(new JSONArray(str), str2, str3);
            if (featureFetch != null) {
                str4 = featureFetch.toString();
            }
            Log.d("FeatureFactory", "CalledByNative: strategyName: " + str3 + " inputFeaturesData :" + featureFetch);
        } catch (Exception e) {
            Log.e("FeatureFactory", "getFeatures: " + e.getMessage());
        }
        return str4;
    }

    public JSONObject featureFetch(JSONObject jSONObject, String str, String str2) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        JSONArray optJSONArray5;
        JSONArray optJSONArray6;
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject stringExtraInfo = getStringExtraInfo("TTNet_NQE_INFO");
        JSONObject intExtraInfo = getIntExtraInfo("USER-HumanActivityRecognition");
        if (jSONObject.has("PlayFeaturesBundle") && (optJSONArray6 = jSONObject.optJSONArray("PlayFeaturesBundle")) != null && optJSONArray6.length() != 0) {
            TypePlayFeaturesCollector.h().c(jSONObject2, optJSONArray6, str, str2, stringExtraInfo);
        }
        if (jSONObject.has("RTPlayFeaturesBundle") && (optJSONArray5 = jSONObject.optJSONArray("RTPlayFeaturesBundle")) != null && optJSONArray5.length() != 0) {
            TypePlayFeaturesCollector.h().d(jSONObject2, optJSONArray5, str, str2, stringExtraInfo);
        }
        if (jSONObject.has("NetworkFeaturesBundle") && (optJSONArray4 = jSONObject.optJSONArray("NetworkFeaturesBundle")) != null && optJSONArray4.length() != 0) {
            c.d().c(jSONObject2, optJSONArray4, str, str2, stringExtraInfo);
        }
        if (jSONObject.has("DeviceFeaturesBundle") && (optJSONArray3 = jSONObject.optJSONArray("DeviceFeaturesBundle")) != null && optJSONArray3.length() != 0) {
            com.ss.videoarch.strategy.featureCenter.featureType.b.f().c(jSONObject2, optJSONArray3, str, str2, stringExtraInfo);
        }
        if (jSONObject.has("UserFeaturesBundle") && (optJSONArray2 = jSONObject.optJSONArray("UserFeaturesBundle")) != null && optJSONArray2.length() != 0) {
            e.e().d(jSONObject2, optJSONArray2, str, str2, intExtraInfo);
        }
        if (jSONObject.has("PushFeaturesBundle") && (optJSONArray = jSONObject.optJSONArray("PushFeaturesBundle")) != null && optJSONArray.length() != 0) {
            d.e().c(jSONObject2, optJSONArray, str, str2, stringExtraInfo);
        }
        Log.d("FeatureFactory", "featuresData" + jSONObject2);
        return jSONObject2;
    }
}
