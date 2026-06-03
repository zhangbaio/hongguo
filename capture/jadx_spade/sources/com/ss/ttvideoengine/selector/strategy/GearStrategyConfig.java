package com.ss.ttvideoengine.selector.strategy;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class GearStrategyConfig {
    private String mParsedStrategyConfigString;
    private IGearStrategyListener mGearStrategyListener = null;
    private Object mUserData = null;
    private String mExtraConfig = "";
    private final Map<Integer, Object> mConfigValue = Collections.synchronizedMap(new HashMap());
    private final Map<String, String> mParam = new HashMap();

    static {
        Covode.recordClassIndex(652670);
    }

    public String getExtraConfig() {
        return this.mExtraConfig;
    }

    public IGearStrategyListener getGearStrategyListener() {
        return this.mGearStrategyListener;
    }

    public Map<String, String> getParam() {
        return this.mParam;
    }

    public Object getUserData() {
        return this.mUserData;
    }

    public void parse() {
        JSONObject jSONObject = null;
        String stringValue = getStringValue(3, null, false);
        if (TextUtils.isEmpty(stringValue)) {
            return;
        }
        synchronized (GearStrategyConfig.class) {
            GearStrategyConfig globalConfig = GearStrategy.getGlobalConfig();
            if (stringValue != null && TextUtils.equals(stringValue, globalConfig.mParsedStrategyConfigString)) {
                TTVideoEngineLog.d("TTVideoEngine.GearStrategy", "global parsed already");
                return;
            }
            if (TextUtils.equals(this.mParsedStrategyConfigString, stringValue)) {
                TTVideoEngineLog.d("TTVideoEngine.GearStrategy", "parsed already");
                return;
            }
            this.mParsedStrategyConfigString = stringValue;
            try {
                jSONObject = new JSONObject(stringValue).optJSONObject("vod_strategy_select_bitrate");
                TTVideoEngineLog.d("TTVideoEngine.GearStrategy", "parse success " + stringValue);
            } catch (JSONException e) {
                e.printStackTrace();
                TTVideoEngineLog.d("TTVideoEngine.GearStrategy", "parse error " + stringValue);
            }
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.has("strategy_type")) {
                setIntValue(1, jSONObject.optInt("strategy_type", -1));
            }
            if (jSONObject.has("strategy_module")) {
                setIntValue(2, jSONObject.optInt("strategy_module", -1));
            }
            if (jSONObject.has("switch_cs_model")) {
                setIntValue(44, jSONObject.optInt("switch_cs_model", 1));
            }
            if (jSONObject.has("fixed_level")) {
                setIntValue(45, jSONObject.optInt("fixed_level", 2));
            }
            if (jSONObject.has("startup_model")) {
                setIntValue(46, jSONObject.optInt("startup_model", 0));
            }
            if (jSONObject.has("startup_bandwidth_parameter")) {
                setFloatValue(47, TTHelper.safeParseFloat(jSONObject, "startup_bandwidth_parameter", 0.9f));
            }
            if (jSONObject.has("startup_first_param_str")) {
                setDoubleValue(48, TTHelper.safeParseDouble(jSONObject, "startup_first_param_str", 0.0d));
            }
            if (jSONObject.has("startup_second_param_str")) {
                setDoubleValue(49, TTHelper.safeParseDouble(jSONObject, "startup_second_param_str", 2.67952228E-5d));
            }
            if (jSONObject.has("startup_third_param_str")) {
                setDoubleValue(50, TTHelper.safeParseDouble(jSONObject, "startup_third_param_str", 0.151840652d));
            }
            if (jSONObject.has("startup_fourth_param_str")) {
                setDoubleValue(51, TTHelper.safeParseDouble(jSONObject, "startup_fourth_param_str", 69.0106422d));
            }
            if (jSONObject.has("startup_use_cache")) {
                setIntValue(52, jSONObject.optInt("startup_use_cache", 0));
            }
            if (jSONObject.has("flow_json")) {
                setStringValue(53, jSONObject.optString("flow_json"));
            }
            if (jSONObject.has("preload_json")) {
                setStringValue(54, jSONObject.optString("preload_json"));
            }
            if (jSONObject.has("startup_json")) {
                setStringValue(55, jSONObject.optString("startup_json"));
            }
            if (jSONObject.has("abr_pool_enable")) {
                setIntValue(56, jSONObject.optInt("abr_pool_enable", 0));
            }
            if (jSONObject.has("startup_algo_type")) {
                setIntValue(16, jSONObject.optInt("startup_algo_type", 0));
            }
            if (jSONObject.has("startup_speed_type")) {
                setIntValue(9, jSONObject.optInt("startup_speed_type", 4));
            }
            if (jSONObject.has("wifi_default_resolution_index")) {
                setIntValue(17, jSONObject.optInt("wifi_default_resolution_index", -1));
            }
            if (jSONObject.has("wifi_max_resolution_index")) {
                setIntValue(21, jSONObject.optInt("wifi_max_resolution_index", -1));
            }
            if (jSONObject.has("cellular_max_resolution_index")) {
                setIntValue(19, jSONObject.optInt("cellular_max_resolution_index", -1));
            }
            if (jSONObject.has("wifi_default_resolution_quality")) {
                setStringValue(18, jSONObject.optString("wifi_default_resolution_quality"));
            }
            if (jSONObject.has("wifi_max_resolution_quality")) {
                setStringValue(22, jSONObject.optString("wifi_max_resolution_quality"));
            }
            if (jSONObject.has("cellular_max_resolution_quality")) {
                setStringValue(20, jSONObject.optString("cellular_max_resolution_quality"));
            }
            if (jSONObject.has("startup_narrow_screen_use_width")) {
                setIntValue(31, jSONObject.optInt("startup_narrow_screen_use_width", 0));
            }
        }
    }

    public GearStrategyConfig setExtraConfig(String str) {
        this.mExtraConfig = str;
        return this;
    }

    public GearStrategyConfig setGearStrategyListener(IGearStrategyListener iGearStrategyListener) {
        this.mGearStrategyListener = iGearStrategyListener;
        return this;
    }

    public GearStrategyConfig setUserData(Object obj) {
        this.mUserData = obj;
        return this;
    }

    public double getDoubleValue(int i) {
        return getDoubleValue(i, -1.0d);
    }

    public float getFloatValue(int i) {
        return getFloatValue(i, -1.0f);
    }

    public int getIntValue(int i) {
        return getIntValue(i, -1);
    }

    public <T> T getObjectValue(int i) {
        return (T) getObjectValue(i, null);
    }

    public String getStringValue(int i) {
        return getStringValue(i, null);
    }

    public double getDoubleValue(int i, double d) {
        return getDoubleValue(i, d, true);
    }

    public float getFloatValue(int i, float f) {
        return getFloatValue(i, f, true);
    }

    public int getIntValue(int i, int i2) {
        return getIntValue(i, i2, true);
    }

    public <T> T getObjectValue(int i, T t) {
        return (T) getObjectValue(i, t, true);
    }

    public String getStringValue(int i, String str) {
        return getStringValue(i, str, true);
    }

    public GearStrategyConfig setDoubleValue(int i, double d) {
        this.mConfigValue.put(Integer.valueOf(i), Double.valueOf(d));
        return this;
    }

    public GearStrategyConfig setFloatValue(int i, float f) {
        this.mConfigValue.put(Integer.valueOf(i), Float.valueOf(f));
        return this;
    }

    public GearStrategyConfig setIntValue(int i, int i2) {
        this.mConfigValue.put(Integer.valueOf(i), Integer.valueOf(i2));
        return this;
    }

    public GearStrategyConfig setObjectValue(int i, Object obj) {
        this.mConfigValue.put(Integer.valueOf(i), obj);
        return this;
    }

    public GearStrategyConfig setStringValue(int i, String str) {
        this.mConfigValue.put(Integer.valueOf(i), str);
        return this;
    }

    public GearStrategyConfig setIntValueIfNotExist(int i, int i2) {
        if (!this.mConfigValue.containsKey(Integer.valueOf(i))) {
            this.mConfigValue.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
        return this;
    }

    public GearStrategyConfig setObjectValueIfNotExist(int i, Object obj) {
        if (!this.mConfigValue.containsKey(Integer.valueOf(i))) {
            this.mConfigValue.put(Integer.valueOf(i), obj);
        }
        return this;
    }

    public GearStrategyConfig setStringValueIfNotExist(int i, String str) {
        if (!this.mConfigValue.containsKey(Integer.valueOf(i))) {
            this.mConfigValue.put(Integer.valueOf(i), str);
        }
        return this;
    }

    public <T> T getObjectValue(int i, T t, boolean z) {
        T t2 = (T) this.mConfigValue.get(Integer.valueOf(i));
        if (t2 != null) {
            return t2;
        }
        if (z) {
            GearStrategyConfig globalConfig = GearStrategy.getGlobalConfig();
            if (globalConfig == this) {
                return t;
            }
            return (T) globalConfig.getObjectValue(i, t, false);
        }
        return t;
    }

    public double getDoubleValue(int i, double d, boolean z) {
        Object obj = this.mConfigValue.get(Integer.valueOf(i));
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (z) {
            GearStrategyConfig globalConfig = GearStrategy.getGlobalConfig();
            if (globalConfig == this) {
                return d;
            }
            return globalConfig.getDoubleValue(i, d, false);
        }
        return d;
    }

    public float getFloatValue(int i, float f, boolean z) {
        Object obj = this.mConfigValue.get(Integer.valueOf(i));
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (z) {
            GearStrategyConfig globalConfig = GearStrategy.getGlobalConfig();
            if (globalConfig == this) {
                return f;
            }
            return globalConfig.getFloatValue(i, f, false);
        }
        return f;
    }

    public int getIntValue(int i, int i2, boolean z) {
        Object obj = this.mConfigValue.get(Integer.valueOf(i));
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (z) {
            GearStrategyConfig globalConfig = GearStrategy.getGlobalConfig();
            if (globalConfig == this) {
                return i2;
            }
            return globalConfig.getIntValue(i, i2, false);
        }
        return i2;
    }

    public String getStringValue(int i, String str, boolean z) {
        Object obj = this.mConfigValue.get(Integer.valueOf(i));
        if (obj instanceof String) {
            return (String) obj;
        }
        if (z) {
            GearStrategyConfig globalConfig = GearStrategy.getGlobalConfig();
            if (globalConfig == this) {
                return str;
            }
            return globalConfig.getStringValue(i, str, false);
        }
        return str;
    }
}
