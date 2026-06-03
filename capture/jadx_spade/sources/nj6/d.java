package nj6;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.covode.number.Covode;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d extends a {
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static final String f;
    public static e g;

    static {
        Covode.recordClassIndex(653127);
        a = "node_optimizer";
        b = "domain";
        c = "network_type";
        d = "ips";
        e = "ttl";
        f = "CREATE TABLE IF NOT EXISTS " + a + " (" + b + " text not null," + c + " text," + d + " text ," + e + " integer,expand_value text ,update_time text,create_time timestamp not null default (datetime('now','localtime')))";
        g = new e();
    }

    public static Set<String> g() {
        HashSet hashSet = new HashSet();
        Cursor d2 = a.d(a, "select DISTINCT " + b + " from " + a);
        if (d2 == null) {
            return hashSet;
        }
        while (d2.moveToNext()) {
            try {
                hashSet.add(d2.getString(0));
            } catch (Exception unused) {
            } catch (Throwable th) {
                try {
                    d2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        try {
            d2.close();
        } catch (Exception unused3) {
        }
        return hashSet;
    }

    public static long i(List<com.ss.videoarch.strategy.dataCenter.strategyData.model.b> list) {
        if (list != null && list.size() > 0) {
            String[] strArr = {b, c};
            ArrayList arrayList = new ArrayList();
            for (com.ss.videoarch.strategy.dataCenter.strategyData.model.b bVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b, bVar.a);
                contentValues.put(c, bVar.b);
                contentValues.put(d, bVar.c);
                contentValues.put(e, Integer.valueOf(bVar.d));
                contentValues.put("update_time", bVar.e);
                arrayList.add(contentValues);
            }
            return a.e(a, strArr, arrayList);
        }
        return -1L;
    }

    public static long h(Set<String> set) {
        if (set == null) {
            return -1L;
        }
        com.ss.videoarch.strategy.log.strategyMonitor.a.a();
        String valueOf = String.valueOf(SDKMonitorUtils.getInstance(com.ss.videoarch.strategy.log.strategyMonitor.a.b).getNetWorkType());
        try {
            if (a.b(a, b, null) < set.size()) {
                ContentValues contentValues = new ContentValues();
                for (String str : set) {
                    int i = 0;
                    Cursor query = a.query(a, new String[]{b}, b + " = ?", new String[]{str}, null, null, null);
                    if (query != null) {
                        i = query.getCount();
                        query.close();
                    }
                    if (i == 0) {
                        contentValues.put(b, str);
                        contentValues.put(c, valueOf);
                        contentValues.put(e, Integer.valueOf(lj6.a.m().F));
                        contentValues.put("update_time", a.c());
                        a.insert(a, contentValues);
                        contentValues.clear();
                    }
                }
                return 0L;
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static HashMap<String, JSONObject> f(String str, String[] strArr, String str2, String str3, String str4) {
        HashMap<String, JSONObject> hashMap = new HashMap<>();
        Cursor query = a.query(a, new String[]{b, c, d, e, "update_time", "create_time"}, str, strArr, str2, str3, str4);
        if (query == null) {
            return hashMap;
        }
        while (query.moveToNext()) {
            try {
                JSONObject jSONObject = new JSONObject();
                com.ss.videoarch.strategy.dataCenter.strategyData.model.b bVar = new com.ss.videoarch.strategy.dataCenter.strategyData.model.b();
                bVar.a = query.getString(0);
                bVar.b = query.getString(1);
                bVar.c = query.getString(2);
                bVar.d = query.getInt(3);
                bVar.e = query.getString(4);
                bVar.f = query.getString(5);
                if (hashMap.containsKey(bVar.a)) {
                    jSONObject = hashMap.get(bVar.a);
                }
                jSONObject.put(bVar.b, bVar);
                hashMap.put(bVar.a, jSONObject);
            } catch (Exception unused) {
            } catch (Throwable th) {
                try {
                    query.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        try {
            query.close();
        } catch (Exception unused3) {
        }
        return hashMap;
    }
}
