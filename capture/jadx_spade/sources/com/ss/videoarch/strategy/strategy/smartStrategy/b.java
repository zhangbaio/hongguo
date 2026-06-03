package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.LiveStrategyManager;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends BaseSmartStrategy {
    private static volatile b a;

    static {
        Covode.recordClassIndex(653206);
        a = null;
    }

    private b() {
        this.mStrategyName = "live_stream_strategy_character_fetch";
        this.mProjectKey = "2";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_character_fetch";
        }
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        Log.i("CharacterFetchStrategy", "return：" + jSONObject);
        pj6.a aVar = LiveStrategyManager.mLiveIOEngine;
        if (aVar != null && jSONObject != null) {
            aVar.c(jSONObject.toString());
        }
        return jSONObject;
    }
}
