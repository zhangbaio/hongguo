package com.ss.videoarch.strategy.strategy.smartStrategy;

import com.bytedance.covode.number.Covode;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class g extends BaseSmartStrategy {
    private static volatile g a;

    static {
        Covode.recordClassIndex(653211);
        a = null;
    }

    public static g a() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    private g() {
        this.mStrategyName = "live_stream_strategy_startup_bitrate_predict";
        this.mProjectKey = "2";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_startup_bitrate_predict";
            dVar.m = new JSONArray().put("NETWORK-RecommendBitrate").put("PLAY-BitrateList");
        }
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runSmartStrategy(JSONObject jSONObject) {
        return super.runSmartStrategy(jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0168  */
    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject runLocalStrategy(org.json.JSONObject r20) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.smartStrategy.g.runLocalStrategy(org.json.JSONObject):org.json.JSONObject");
    }
}
