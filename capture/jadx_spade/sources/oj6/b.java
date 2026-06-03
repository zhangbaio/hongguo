package oj6;

import com.bytedance.covode.number.Covode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    static {
        Covode.recordClassIndex(653142);
    }

    public static void a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("duration", com.ss.videoarch.strategy.log.strategyMonitor.a.a().a);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        a.c("sdk_start", null, jSONObject, null);
    }

    public static void b(int i, int i2, int i3, String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (lj6.a.m().r.e.mEnableUploadStrategyMonitorLog != 1) {
            return;
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.put("request_cost", i3);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("request_id", str2).put("code", i2).put("index", i).put("settings_info", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject2 = null;
        }
        a.c("settings_update", jSONObject2, jSONObject, null);
    }
}
