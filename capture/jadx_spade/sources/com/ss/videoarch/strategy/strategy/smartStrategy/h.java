package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class h extends BaseSmartStrategy {
    private static volatile h a;

    static {
        Covode.recordClassIndex(653212);
        a = null;
    }

    public static h a() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h();
                }
            }
        }
        return a;
    }

    private h() {
        this.mStrategyName = "live_stream_strategy_smooth_switch_probe_bitrate";
        this.mProjectKey = "2";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_smooth_switch_probe_bitrate";
            dVar.m = new JSONArray().put("NETWORK-NetworkLevel").put("PLAY-BitrateList");
        }
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runSmartStrategy(JSONObject jSONObject) {
        return super.runSmartStrategy(jSONObject);
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        mj6.d dVar;
        boolean z;
        Log.d("SmoothSwitchStrategy", "run local strategy inputFeaturesData:" + jSONObject);
        if (jSONObject != null && (dVar = this.mStrategyConfigInfo) != null && dVar.h != null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject optJSONObject = jSONObject.optJSONObject("PLAY-BitrateList");
            JSONObject optJSONObject2 = this.mStrategyConfigInfo.h.optJSONObject("NetLevel-Map");
            int optInt = jSONObject.optInt("NETWORK-NetworkLevel", 0);
            boolean z2 = true;
            if (optJSONObject == null) {
                z = true;
            } else {
                z = false;
            }
            if (optJSONObject2 != null) {
                z2 = false;
            }
            if (z2 | z) {
                return jSONObject2;
            }
            Iterator<String> keys = optJSONObject2.keys();
            int i = -1;
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    JSONArray optJSONArray = optJSONObject2.optJSONArray(next);
                    if (optJSONArray != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 < optJSONArray.length()) {
                                if (optJSONArray.get(i2).equals(Integer.valueOf(optInt)) && optJSONObject.has(next)) {
                                    i = optJSONObject.optInt(next);
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject2.put("smooth_switch_probe_bitrate", i);
            return jSONObject2;
        }
        return null;
    }
}
