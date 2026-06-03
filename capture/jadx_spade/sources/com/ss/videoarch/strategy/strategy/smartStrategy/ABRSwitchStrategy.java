package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.pitaya.api.PTYTaskResultCallback;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYPackageInfo;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.ss.videoarch.strategy.strategy.abr.DecisionMaker;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ABRSwitchStrategy extends BaseSmartStrategy {
    private static volatile ABRSwitchStrategy sInstance;
    private boolean mPitayaReady = false;

    static {
        Covode.recordClassIndex(653204);
        sInstance = null;
    }

    public static ABRSwitchStrategy inst() {
        if (sInstance == null) {
            synchronized (ABRSwitchStrategy.class) {
                if (sInstance == null) {
                    sInstance = new ABRSwitchStrategy();
                }
            }
        }
        return sInstance;
    }

    private ABRSwitchStrategy() {
        this.mStrategyName = "live_stream_strategy_abr_predict_bitrate";
        this.mProjectKey = "2";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_abr_predict_bitrate";
            dVar.m = new JSONArray().put("PLAY-BitrateList");
        }
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        return runABRStrategy(jSONObject);
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runSmartStrategy(JSONObject jSONObject) {
        return runABRStrategy(jSONObject);
    }

    public JSONObject runABRStrategy(JSONObject jSONObject) {
        Log.d("ABRSwitchStrategy", "run strategy with inputFeatures: " + jSONObject);
        this.mPitayaReady = PitayaWrapper.f().d();
        return DecisionMaker.a().b(jSONObject);
    }

    private String runPitayaStrategy(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        StringBuilder sb = new StringBuilder();
        if (this.mPitayaReady) {
            str3 = "";
        } else {
            str3 = "not ";
        }
        sb.append(str3);
        sb.append("ready to run pitaya strategy, strategyName: ");
        sb.append(str);
        sb.append(", inputFeatures: ");
        sb.append(str2);
        Log.d("ABRSwitchStrategy", sb.toString());
        if (!this.mPitayaReady) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (str == null) {
                str = this.mStrategyName;
            }
            final JSONObject[] jSONObjectArr = {null};
            if (!PitayaWrapper.f().h(str, jSONObject2, new PTYTaskResultCallback() { // from class: com.ss.videoarch.strategy.strategy.smartStrategy.a
                public final void onResult(boolean z, PTYError pTYError, PTYTaskData pTYTaskData, PTYPackageInfo pTYPackageInfo) {
                    ABRSwitchStrategy.lambda$runPitayaStrategy$0(jSONObjectArr, z, pTYError, pTYTaskData, pTYPackageInfo);
                }
            }) || (jSONObject = jSONObjectArr[0]) == null) {
                return null;
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runPitayaStrategy$0(JSONObject[] jSONObjectArr, boolean z, PTYError pTYError, PTYTaskData pTYTaskData, PTYPackageInfo pTYPackageInfo) {
        if (pTYTaskData != null) {
            jSONObjectArr[0] = pTYTaskData.getParams();
            Log.d("ABRSwitchStrategy", "on pitaya task result, succeed: " + z + ", result:" + jSONObjectArr[0] + ", error:" + pTYError);
            return;
        }
        Log.d("ABRSwitchStrategy", "on pitaya task result without task data, error: " + pTYError);
    }
}
