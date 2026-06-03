package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class m extends BaseSmartStrategy {
    private static volatile m a;

    static {
        Covode.recordClassIndex(653218);
        a = null;
    }

    public static m a() {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m();
                }
            }
        }
        return a;
    }

    private m() {
        this.mStrategyName = "live_stream_strategy_trans_params";
        this.mProjectKey = "2";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_trans_params";
            dVar.m = new JSONArray().put("NETWORK-NetworkLevel").put("NETWORK-RTT").put("NETWORK-VodDownloadSpeed").put("NETWORK-BestMtuLength").put("NETWORK-PacketLossRate").put("PLAY-Bitrate").put("PLAY-NeptuneName").put("PLAY-HistoryBandwidth").put("CLOUD-DefaultRecommendResult").put("CLOUD-MinMultiple").put("CLOUD-MaxMultiple").put("CLOUD-MinBandWidth").put("CLOUD-MaxBandWidth");
        }
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        mj6.d dVar;
        int i;
        long j;
        long j2;
        long j3;
        int i2;
        Log.d("TransportParamRecommend", "run local strategy inputFeaturesData:" + jSONObject);
        if (jSONObject != null && (dVar = this.mStrategyConfigInfo) != null && dVar.h != null) {
            JSONObject jSONObject2 = new JSONObject();
            String optString = jSONObject.optString("PLAY-NeptuneName", "");
            long optLong = jSONObject.optLong("PLAY-HistoryBandwidth", 0L);
            int optInt = jSONObject.optInt("NETWORK-NetworkLevel", 0);
            long optLong2 = jSONObject.optLong("NETWORK-RTT", 0L);
            long optLong3 = jSONObject.optLong("NETWORK-VodDownloadSpeed", 0L);
            long optLong4 = jSONObject.optLong("NETWORK-BestMtuLength", -1L);
            long optLong5 = jSONObject.optLong("NETWORK-PacketLossRate", -1L);
            long optLong6 = this.mStrategyConfigInfo.h.optLong("MinBandWidth", 1500L);
            long optLong7 = this.mStrategyConfigInfo.h.optLong("MaxBandWidth", 80000L);
            JSONObject optJSONObject = this.mStrategyConfigInfo.h.optJSONObject("NetWorkTypeDefaultBandWidth");
            if (optLong <= 0) {
                if (optLong3 > 0) {
                    i = 2;
                    optLong = optLong3;
                } else if (optJSONObject != null && optJSONObject.has(String.valueOf(optInt))) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(String.valueOf(optInt));
                    if (!TextUtils.isEmpty(optString) && optJSONObject2 != null && optJSONObject2.has(optString)) {
                        optLong = optJSONObject2.optLong(optString);
                        i2 = 3;
                    } else {
                        i2 = 0;
                    }
                    i = i2;
                } else {
                    i = 0;
                }
            } else {
                i = 1;
            }
            if (optLong < optLong6 || optLong > optLong7) {
                if (optLong >= optLong6) {
                    optLong6 = optLong7;
                }
                optLong = optLong6;
            }
            if (optLong <= 0) {
                optLong = -1;
            }
            try {
                jSONObject2.put("Bandwidth", optLong);
                if (optLong2 > 0) {
                    j = optLong2;
                } else {
                    j = -1;
                }
                jSONObject2.put("RTT", j);
                if (optLong4 > 0) {
                    j2 = optLong4;
                } else {
                    j2 = -1;
                }
                jSONObject2.put("BestMTULength", j2);
                if (optLong5 > 0) {
                    j3 = optLong5;
                } else {
                    j3 = -1;
                }
                jSONObject2.put("PacketLossRate", j3);
                jSONObject2.put("BandwidthDecision", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("TransportParamRecommend", "local transParamsResult:" + jSONObject2);
            return jSONObject2;
        }
        return null;
    }
}
