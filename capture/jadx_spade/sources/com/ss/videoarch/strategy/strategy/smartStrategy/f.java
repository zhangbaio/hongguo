package com.ss.videoarch.strategy.strategy.smartStrategy;

import com.bytedance.covode.number.Covode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class f extends BaseSmartStrategy {
    private static volatile f a;

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        return null;
    }

    static {
        Covode.recordClassIndex(653210);
        a = null;
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    private f() {
        this.mStrategyName = "live_stream_strategy_short_time_leave_predict";
        this.mProjectKey = "2";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_short_time_leave_predict";
            dVar.m = new JSONArray().put("USER-FeaturesBundle").put("PLAY-HistoryDuration");
        }
    }

    public void b(long j) {
        JSONObject jSONObject;
        if (getEnableStrategy(this.mStrategyName, 0) == 1 && j != -1) {
            try {
                jSONObject = new JSONObject().put("result", j);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            uploadGroundTruth(jSONObject);
        }
    }
}
