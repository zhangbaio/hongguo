package oj6;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static boolean a;

    /* renamed from: oj6.a$a, reason: collision with other inner class name */
    static class C0248a implements SDKMonitor.IGetExtendParams {
        final /* synthetic */ String a;
        final /* synthetic */ Map b;

        public Map<String, String> getCommonParams() {
            return this.b;
        }

        public String getSessionId() {
            return this.a;
        }

        C0248a(String str, Map map) {
            this.a = str;
            this.b = map;
        }
    }

    static {
        Covode.recordClassIndex(653141);
        a = false;
    }

    public static void b(JSONObject jSONObject) {
        in6.a.a("live_stream_strategy_feature_data", jSONObject);
    }

    public static void a(Context context, JSONObject jSONObject) {
        String str;
        String str2 = (String) lj6.a.m().b("live_stream_strategy_slardar_host", "");
        if (jSONObject != null && context != null && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            if (jSONObject.has("oversea") && jSONObject.optInt("oversea") == 1) {
                hashMap.put("oversea", "1");
            }
            try {
                com.ss.videoarch.strategy.log.strategyMonitor.a.a();
                jSONObject.put("sdk_version", "1.10.205.2");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject.has("app_session_id")) {
                str = jSONObject.optString("app_session_id");
            } else {
                str = null;
            }
            List asList = Arrays.asList("https://" + str2 + "/monitor/appmonitor/v2/settings");
            List asList2 = Arrays.asList("https://" + str2 + "/monitor/collect/");
            com.ss.videoarch.strategy.log.strategyMonitor.a.a();
            SDKMonitorUtils.setConfigUrl(com.ss.videoarch.strategy.log.strategyMonitor.a.b, asList);
            com.ss.videoarch.strategy.log.strategyMonitor.a.a();
            SDKMonitorUtils.setDefaultReportUrl(com.ss.videoarch.strategy.log.strategyMonitor.a.b, asList2);
            StringBuilder sb = new StringBuilder();
            sb.append("sdk_app_id:");
            com.ss.videoarch.strategy.log.strategyMonitor.a.a();
            sb.append(com.ss.videoarch.strategy.log.strategyMonitor.a.b);
            sb.append(" sdk_version:");
            com.ss.videoarch.strategy.log.strategyMonitor.a.a();
            sb.append("1.10.205.2");
            sb.append(" app_session_id:");
            sb.append(str);
            sb.append(" urlsOfFetchConfig:");
            sb.append(asList);
            sb.append(" urlsOfReport:");
            sb.append(asList2);
            Log.d("StrategyCenterLogger", sb.toString());
            Context applicationContext = context.getApplicationContext();
            com.ss.videoarch.strategy.log.strategyMonitor.a.a();
            SDKMonitorUtils.initMonitor(applicationContext, com.ss.videoarch.strategy.log.strategyMonitor.a.b, jSONObject, new C0248a(str, hashMap));
            a = true;
            return;
        }
        Log.e("StrategyCenterLogger", "init parameters illegal, headers:" + jSONObject + " context:" + context + " slardarHostName:" + str2);
    }

    public static void c(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (!a) {
            Log.e("StrategyCenterLogger", "slardar not init");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("REAL_SDK_APP_ID:");
        com.ss.videoarch.strategy.log.strategyMonitor.a.a();
        sb.append(com.ss.videoarch.strategy.log.strategyMonitor.a.b);
        sb.append(" serviceName:");
        sb.append(str);
        sb.append(" category:");
        sb.append(jSONObject);
        sb.append(" metric:");
        sb.append(jSONObject2);
        Log.d("StrategyCenterLogger", sb.toString());
        com.ss.videoarch.strategy.log.strategyMonitor.a.a();
        SDKMonitorUtils.getInstance(com.ss.videoarch.strategy.log.strategyMonitor.a.b).monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
    }
}
