package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d extends BaseSmartStrategy {
    private static volatile d b;
    private JSONObject a = null;

    static {
        Covode.recordClassIndex(653208);
        b = null;
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    private d() {
        this.mStrategyName = "live_stream_strategy_net_connect_type";
        this.mProjectKey = "2";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_net_connect_type";
            dVar.m = new JSONArray().put("NETWORK-NetworkLevel");
        }
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        if (jSONObject == null) {
            return null;
        }
        Log.w("NetConnectionType", "into getNetConnectionTypeStrategy");
        JSONObject jSONObject3 = this.mStrategyConfigInfo.h;
        if (jSONObject3 != null) {
            this.a = jSONObject3.optJSONObject("netEffectiveConnectionTypeStrategy");
        }
        Log.d("NetConnectionType", "netEffectiveConnectionTypeStrategy: " + this.a);
        int optInt = jSONObject.optInt("NETWORK-NetworkLevel");
        if (optInt == 1) {
            optInt = 7;
        }
        JSONObject jSONObject4 = this.a;
        if (jSONObject4 != null && jSONObject4.has(String.valueOf(optInt))) {
            try {
                jSONObject2 = this.a.getJSONObject(String.valueOf(optInt));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.w("NetConnectionType", "return config：" + jSONObject2);
        return jSONObject2;
    }
}
