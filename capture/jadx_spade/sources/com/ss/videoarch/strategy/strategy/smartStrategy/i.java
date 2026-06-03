package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class i extends BaseSmartStrategy {
    private static volatile i b;
    public nj6.e a;

    static {
        Covode.recordClassIndex(653213);
        b = null;
    }

    private i() {
        this.mStrategyName = "live_stream_strategy_socket_buffer";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_socket_buffer";
        }
        this.mProjectKey = "2";
        this.a = new nj6.e();
    }

    public static i a() {
        if (b == null) {
            synchronized (i.class) {
                if (b == null) {
                    b = new i();
                }
            }
        }
        return b;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        mj6.d dVar;
        Log.d("SocketBufferStrategy", "run local strategy inputFeaturesData:" + jSONObject);
        if (jSONObject != null && (dVar = this.mStrategyConfigInfo) != null && dVar.h != null) {
            JSONObject jSONObject2 = new JSONObject();
            int optInt = jSONObject.optInt("NETWORK-NetworkLevel", 0);
            if (this.mStrategyConfigInfo.h.has(String.valueOf(optInt))) {
                return this.mStrategyConfigInfo.h.optJSONObject(String.valueOf(optInt));
            }
            return jSONObject2;
        }
        return null;
    }
}
