package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e extends BaseSmartStrategy {
    private static volatile e b;
    public boolean a = true;

    static {
        Covode.recordClassIndex(653209);
        b = null;
    }

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    private e() {
        this.mStrategyName = "live_stream_strategy_first_play_time_predict";
        this.mProjectKey = "2";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_first_play_time_predict";
            dVar.m = new JSONArray().put("PLAY-FirstStartTime").put("PLAY-FirstStartTimeStamp").put("USER-FeaturesBundle").put("NETWORK-NetworkLevel").put("DEVICE-Battery");
        }
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        JSONObject jSONObject2 = this.mStrategyResult;
        if (jSONObject2 != null) {
            return jSONObject2;
        }
        JSONObject jSONObject3 = new JSONObject();
        com.ss.videoarch.strategy.dataCenter.strategyData.model.a h = nj6.b.h(a().mStrategyName + "_data");
        if (h != null) {
            try {
                return new JSONObject(h.c);
            } catch (JSONException unused) {
                Log.e("PredictFirstPlayTime", "DB don't has this result data");
                return jSONObject3;
            }
        }
        return jSONObject3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(long r12) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.smartStrategy.e.b(long):void");
    }
}
