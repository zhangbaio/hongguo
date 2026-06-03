package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.pitaya.api.PTYTaskResultCallback;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYPackageInfo;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.featureCenter.FeatureFactory;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BaseSmartStrategy extends com.ss.videoarch.strategy.log.strategyMonitor.b {
    protected static String TAG;
    public String mStrategyName = "lsstrategy_base_strategy_model";
    protected mj6.d mStrategyConfigInfo = new mj6.d();
    protected JSONObject mStrategyResult = null;
    protected JSONObject mInputFeatures = null;
    protected int mIndex = 0;
    protected float mRandomFloat = new Random().nextFloat();
    protected String mProjectKey = "none";
    protected String mResult = "none";
    protected String mExtraLog = "none";
    protected int mCode = -1;
    protected int mRunIndex = 0;
    protected int mEnableCloudPackage = -1;
    protected boolean mFallbackLocal = false;
    protected long mTotalCost = -1;
    protected long mLoadPackageCost = -1;
    protected long mRunCost = -1;
    protected double mCpuInc = 0.0d;
    protected double mMemoryInc = 0.0d;

    private native String nativeRunCloudStrategy(String str, String str2);

    private native void nativeSetObject();

    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        return null;
    }

    public void initStrategyConfig() {
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.a();
        }
    }

    public JSONObject runStrategy() {
        return runStrategy(null);
    }

    static {
        Covode.recordClassIndex(653205);
        TAG = "BaseSmartStrategy";
    }

    public JSONObject fetchData() {
        if (this.mStrategyConfigInfo != null) {
            return FeatureFactory.inst().featureFetch(this.mStrategyConfigInfo.s, this.mProjectKey, this.mStrategyName);
        }
        return null;
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createMetric() {
        try {
            return new JSONObject().put("load_cost", this.mLoadPackageCost).put("run_cost", this.mRunCost).put("duration", this.mTotalCost).put("cpu_inc", this.mCpuInc).put("memory_inc", this.mMemoryInc);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getInputFeatures() {
        String str;
        JSONObject fetchData = fetchData();
        if (fetchData != null) {
            str = fetchData.toString();
        } else {
            str = "";
        }
        Log.d(TAG, "CalledByNative: strategyName: " + this.mStrategyName + " inputFeaturesData :" + fetchData);
        return str;
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public int strategyCode() {
        if (!LiveStrategyManager.inst().mIsRunning) {
            this.mCode = 1;
        } else if (this.mStrategyConfigInfo == null) {
            this.mCode = 2;
        } else {
            String str = this.mResult;
            if (str != null && !TextUtils.isEmpty(str) && !this.mResult.equals("none")) {
                this.mCode = 0;
            }
        }
        return this.mCode;
    }

    BaseSmartStrategy() {
        if (lj6.a.m().r.e.mEnableNativeStrategyCenter == 1) {
            nativeSetObject();
        }
    }

    private JSONObject createCommonLog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stream_type", TypePlayFeaturesCollector.h().e("neptuneName", "none")).put("enter_from", TypePlayFeaturesCollector.h().e("enter_from", "none")).put("run_index", this.mRunIndex).put("is_preview", TypePlayFeaturesCollector.h().e("is_preview", -1)).put("strategy_name", this.mStrategyName).put("strategy_id", this.mStrategyConfigInfo.c).put("strategy_ABInfo", lj6.a.m().h()).put("strategy_common_trace", lj6.a.m().i()).put("pitaya_ab_package_name", this.mStrategyConfigInfo.d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createCategory() {
        Object d;
        int i;
        JSONObject createCommonLog = createCommonLog();
        try {
            JSONObject put = createCommonLog.put("caller", this.mProjectKey);
            if (this.mProjectKey == "2") {
                d = TypePlayFeaturesCollector.h().e("stream_session_vv_id", "none");
            } else {
                d = com.ss.videoarch.strategy.featureCenter.featureType.d.e().d("stream_session_vv_id", "none");
            }
            JSONObject put2 = put.put("caller_session_id", d).put("result", this.mResult);
            if (this.mFallbackLocal) {
                i = 1;
            } else {
                i = 0;
            }
            put2.put("fallback_local", i).put("enable_cloud_package", this.mEnableCloudPackage).put("code", strategyCode()).put("extra_info", this.mExtraLog);
            return createCommonLog;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject runCloudStrategy(JSONObject jSONObject) {
        String str;
        JSONObject optJSONObject = this.mStrategyConfigInfo.h.optJSONObject("cloudStrategyParam");
        JSONObject jSONObject2 = null;
        if (optJSONObject != null) {
            str = nativeRunCloudStrategy(optJSONObject.toString(), jSONObject.toString());
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject2 = new JSONObject(str);
            } catch (JSONException e) {
                Log.e(TAG, "runCloudStrategy: ", e);
            }
        }
        if (jSONObject2 != null) {
            return jSONObject2;
        }
        return runLocalStrategy(jSONObject);
    }

    public JSONObject runSmartStrategy(JSONObject jSONObject) {
        final JSONObject[] jSONObjectArr = {null};
        Log.d(TAG, " run smart strategy " + this.mStrategyName + " inputFeaturesData:" + jSONObject);
        if (PitayaWrapper.f().h(this.mStrategyName, jSONObject, new PTYTaskResultCallback() { // from class: com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy.1
            public void onResult(boolean z, PTYError pTYError, PTYTaskData pTYTaskData, PTYPackageInfo pTYPackageInfo) {
                if (pTYTaskData != null) {
                    jSONObjectArr[0] = pTYTaskData.getParams();
                    Log.e(BaseSmartStrategy.TAG, "pitaya run task:" + z + "error is:" + pTYError + "result[0]:" + jSONObjectArr[0]);
                    return;
                }
                Log.e(BaseSmartStrategy.TAG, "pitaya run task:" + z + ",result is: null, error is:" + pTYError);
            }
        }) && jSONObjectArr[0] != null) {
            Log.d(TAG, " run package success, result: " + jSONObjectArr[0]);
            this.mFallbackLocal = false;
            return jSONObjectArr[0];
        }
        Log.e(TAG, "fall back local strategy");
        this.mFallbackLocal = true;
        return runLocalStrategy(jSONObject);
    }

    public void uploadGroundTruth(JSONObject jSONObject) {
        JSONObject jSONObject2;
        float f;
        Log.d(TAG, "uploadGroundTruth");
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null && (jSONObject2 = dVar.k) != null && jSONObject2.has("GroundTruthSample")) {
            JSONObject optJSONObject = this.mStrategyConfigInfo.k.optJSONObject("GroundTruthSample");
            if (optJSONObject != null && optJSONObject.has("Enable") && optJSONObject.optInt("Enable") != -1) {
                Log.d(TAG, "enable uploadGroundTruth");
                if (optJSONObject.has("ReportRate")) {
                    f = (float) optJSONObject.optDouble("ReportRate");
                } else {
                    f = 0.1f;
                }
                if (this.mRandomFloat < f) {
                    JSONObject createCommonLog = createCommonLog();
                    try {
                        createCommonLog.put("input_features", this.mInputFeatures).put("ground_truth", jSONObject).put("unique_symbol", LiveStrategyManager.mLoadLibraryTime + "." + LiveStrategyManager.inst().mDeviceId + "." + this.mIndex);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "real uploadGroundTruth:" + createCommonLog);
                    oj6.a.b(createCommonLog);
                }
            } else {
                return;
            }
        }
        this.mIndex++;
        this.mRandomFloat = new Random().nextFloat();
    }

    public void uploadPredictValue(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        float f;
        Log.d(TAG, "uploadPredictResult");
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null && (jSONObject2 = dVar.k) != null && jSONObject2.has("PredictResultSample") && (optJSONObject = this.mStrategyConfigInfo.k.optJSONObject("PredictResultSample")) != null && optJSONObject.has("Enable") && optJSONObject.optInt("Enable") != -1) {
            Log.d(TAG, "enable uploadPredictResult");
            if (optJSONObject.has("ReportRate")) {
                f = (float) optJSONObject.optDouble("ReportRate");
            } else {
                f = 0.1f;
            }
            if (this.mRandomFloat < f) {
                JSONObject createCommonLog = createCommonLog();
                try {
                    createCommonLog.put("input_features", this.mInputFeatures).put("predict", jSONObject).put("unique_symbol", LiveStrategyManager.mLoadLibraryTime + "." + LiveStrategyManager.inst().mDeviceId + "." + this.mIndex);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "real uploadPredictResult:" + createCommonLog);
                oj6.a.b(createCommonLog);
            }
        }
    }

    public JSONObject runStrategy(JSONObject jSONObject) {
        int i;
        JSONObject jSONObject2;
        if (this.mServiceName == null) {
            this.mServiceName = "live_stream_strategy_common_monitor";
        }
        JSONObject jSONObject3 = null;
        if (getEnableStrategy(this.mStrategyName, 0) != 1) {
            Log.e(TAG, this.mStrategyName + " return null");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject fetchData = fetchData();
        this.mInputFeatures = fetchData;
        if (jSONObject != null && fetchData != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    fetchData.put(next, jSONObject.get(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (fetchData != null && (jSONObject2 = this.mStrategyConfigInfo.h) != null) {
            try {
                fetchData.put("InputSettingsParams", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        Log.d(TAG, " strategyName: " + this.mStrategyName + " inputFeaturesData :" + fetchData);
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null && ((i = dVar.f) == 1 || dVar.g == 1)) {
            this.mEnableCloudPackage = 1;
            if (i == 1) {
                Log.d(TAG, " strategyName: " + this.mStrategyName + " runSmartStrategy");
                jSONObject3 = runSmartStrategy(fetchData);
            } else if (dVar.g == 1) {
                Log.d(TAG, " strategyName: " + this.mStrategyName + " runCloudStrategy");
                jSONObject3 = runCloudStrategy(fetchData);
            }
        } else {
            this.mEnableCloudPackage = 0;
            Log.d(TAG, " strategyName: " + this.mStrategyName + "runLocalStrategy");
            jSONObject3 = runLocalStrategy(fetchData);
        }
        this.mRunIndex++;
        Log.d(TAG, "Strategy Name: " + this.mStrategyName + " predictResult: " + jSONObject3);
        if (jSONObject3 != null) {
            this.mResult = jSONObject3.toString();
        } else {
            this.mResult = "none";
        }
        this.mTotalCost = System.currentTimeMillis() - currentTimeMillis;
        uploadMonitorLog();
        this.mStrategyResult = jSONObject3;
        return jSONObject3;
    }

    public int getEnableStrategy(String str, int i) {
        if (LiveStrategyManager.inst().mIsRunning) {
            mj6.d dVar = this.mStrategyConfigInfo;
            if (dVar != null) {
                i = dVar.e;
            }
        } else {
            Log.d(TAG, "getEnableStrategy from db:" + str);
            JSONObject g = nj6.b.g(nj6.b.c, str);
            if (g != null) {
                i = g.optInt("Enable");
                mj6.d dVar2 = this.mStrategyConfigInfo;
                if (dVar2 != null) {
                    dVar2.h = g.optJSONObject("InputSettingsParam");
                }
            }
        }
        Log.d(TAG, "strategy name:" + str + ",enableStrategy:" + i);
        return i;
    }
}
