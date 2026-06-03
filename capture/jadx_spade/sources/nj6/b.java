package nj6;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends a {
    public static String a;
    public static final String b;
    public static String c;
    public static String d;
    public static String e;
    public static e f;
    public static Map<String, com.ss.videoarch.strategy.dataCenter.strategyData.model.a> g;

    static {
        Covode.recordClassIndex(653123);
        a = "settings_config";
        b = "CREATE TABLE IF NOT EXISTS " + a + " (settings_name text not null ,settings_value text ,expand_value text ,update_time text ,create_time timestamp not null default (datetime('now','localtime')))";
        c = "StrategyConfig";
        d = "FeatureConfig";
        e = "CommonConfig";
        f = new e();
        g = new ConcurrentHashMap();
    }

    public static long f(List<com.ss.videoarch.strategy.dataCenter.strategyData.model.a> list) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("ConfigTableOperate", "add Settings Config");
        if (list != null && list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"settings_name"};
            ArrayList arrayList = new ArrayList();
            for (com.ss.videoarch.strategy.dataCenter.strategyData.model.a aVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("settings_name", aVar.a);
                contentValues.put("settings_value", aVar.b);
                contentValues.put("expand_value", aVar.c);
                contentValues.put("update_time", a.c());
                sb.append(aVar.a);
                arrayList.add(contentValues);
            }
            long e2 = a.e(a, strArr, arrayList);
            f.a(a, com.ss.videoarch.strategy.log.strategyMonitor.b.MONITOR_UPDATE_OPERATE, sb.toString(), e2, currentTimeMillis, "none");
            f.uploadMonitorLog();
            return e2;
        }
        return -1L;
    }

    public static com.ss.videoarch.strategy.dataCenter.strategyData.model.a h(String str) {
        Log.d("ConfigTableOperate", "get StrategyConfig from DB:" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.ss.videoarch.strategy.dataCenter.strategyData.model.a aVar = new com.ss.videoarch.strategy.dataCenter.strategyData.model.a();
        if (g.containsKey(str)) {
            Log.d("ConfigTableOperate", "hit cache：" + str);
            aVar = g.get(str);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            Cursor query = a.query(a, new String[]{"settings_name", "settings_value", "expand_value", "update_time", "create_time"}, "settings_name = ?", new String[]{str}, null, null, null);
            if (query == null) {
                return null;
            }
            long j = -1;
            while (query.moveToNext()) {
                try {
                    aVar.a = query.getString(0);
                    aVar.b = query.getString(1);
                    aVar.c = query.getString(2);
                    aVar.d = query.getString(3);
                    aVar.e = query.getString(4);
                    g.put(str, aVar);
                    j = 1;
                } catch (Exception unused) {
                } catch (Throwable th) {
                    try {
                        query.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            }
            f.a(a, com.ss.videoarch.strategy.log.strategyMonitor.b.MONITOR_QUERY_OPERATE, str, j, currentTimeMillis, "none");
            f.uploadMonitorLog();
            try {
                query.close();
            } catch (Exception unused3) {
            }
        }
        Log.d("ConfigTableOperate", "get Settings Config from DB result:" + aVar.toString());
        return aVar;
    }

    public static JSONObject g(String str, String str2) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        com.ss.videoarch.strategy.dataCenter.strategyData.model.a h = h(str);
        new JSONObject();
        if (h != null && !TextUtils.isEmpty(h.b)) {
            try {
                JSONObject jSONObject2 = new JSONObject(h.b);
                if (jSONObject2.has(str2)) {
                    jSONObject = jSONObject2.optJSONObject(str2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        Log.d("ConfigTableOperate", "get Config Result From Settings Value:" + jSONObject);
        return jSONObject;
    }
}
