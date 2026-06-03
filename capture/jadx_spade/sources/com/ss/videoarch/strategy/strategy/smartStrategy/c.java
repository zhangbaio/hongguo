package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c extends BaseSmartStrategy {
    private static volatile c b;
    private int a = -1;

    static {
        Covode.recordClassIndex(653207);
        b = null;
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private c() {
        this.mStrategyName = "live_stream_strategy_retry_buffer";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_retry_buffer";
            dVar.m = new JSONArray().put("PLAY-DownloadSpeed").put("USER-OverallScore").put("NETWORK-NetworkLevel").put("PLAY-StallTime").put("PLAY-BufferDataSeconds").put("PLAY-DoubleBufferDataSeconds");
        }
        this.mProjectKey = "2";
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        mj6.d dVar;
        double d;
        int i;
        double d2;
        Log.d("GetRetryBufferStrategy", "run local strategy inputFeaturesData:" + jSONObject);
        if (jSONObject != null && (dVar = this.mStrategyConfigInfo) != null) {
            this.a = 1;
            JSONObject jSONObject2 = dVar.h;
            if (jSONObject2 != null) {
                this.a = jSONObject2.optInt("AdaptiveBufferingEndThresholdStrategy", 1);
            }
            if (jSONObject.has("PLAY-BufferDataSeconds")) {
                d = jSONObject.optInt("PLAY-BufferDataSeconds");
            } else {
                d = 200.0d;
            }
            int i2 = this.a;
            long j = -1;
            if (i2 == 1) {
                if (jSONObject.has("NETWORK-NetworkLevel")) {
                    i = jSONObject.optInt("NETWORK-NetworkLevel");
                } else {
                    i = -1;
                }
                if (jSONObject.has("USER-OverallScore")) {
                    d2 = jSONObject.optDouble("USER-OverallScore");
                } else {
                    d2 = -1.0d;
                }
                if (jSONObject.has("PLAY-DownloadSpeed")) {
                    j = jSONObject.optInt("PLAY-DownloadSpeed");
                }
                if (i > 0 && j > 0 && d2 > 0.0d) {
                    double d3 = i;
                    double d4 = j;
                    d = ((((((Math.log(d3) * 18.06d) + 1148.3d) + (Math.log(0.001d * d4) * 81.67d)) - (Math.log(d2) * 234.83d)) + ((27.7d * d3) / d4)) + ((193.1d * d2) / d4)) - ((d3 * 117.43d) / d2);
                }
                Log.d("GetRetryBufferStrategy", "updateStallBuffer net_effective_connection_type:" + i + ",download_speed:" + j + ",overall_score:" + d2 + ",buffering_end:" + ((int) d));
            } else if (i2 == 2) {
                if (jSONObject.has("PLAY-DoubleBufferDataSeconds")) {
                    d = jSONObject.optInt("PLAY-DoubleBufferDataSeconds");
                }
                Log.d("GetRetryBufferStrategy", "strategy:2,buffering_end:" + ((int) d));
            } else if (i2 == 3) {
                if (jSONObject.has("PLAY-StallTime")) {
                    j = jSONObject.optInt("PLAY-StallTime");
                }
                if (j > 0) {
                    d = (int) j;
                }
                Log.d("GetRetryBufferStrategy", "strategy:3,buffering_end:" + ((int) d));
            }
            double min = Math.min(Math.max(d, 100.0d), 1500.0d);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("RetryBufferSize", min);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject3;
        }
        return null;
    }
}
