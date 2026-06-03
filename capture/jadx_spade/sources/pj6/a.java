package pj6;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private com.ss.videoarch.strategy.a b;
    private Map<String, C0253a> e;
    private List<String> a = new ArrayList();
    private Map<String, Integer> c = new ArrayMap();
    private Map<String, JSONObject> d = new ArrayMap();
    private final String f = "quic";
    private long g = 300000;
    private int h = 50;

    static {
        Covode.recordClassIndex(653165);
    }

    public void d() {
        Map<String, C0253a> map = this.e;
        if (map != null && !map.isEmpty()) {
            this.e.clear();
        }
    }

    public void h() {
        Map<String, C0253a> map = this.e;
        if (map != null && !map.isEmpty()) {
            Iterator<Map.Entry<String, C0253a>> it2 = this.e.entrySet().iterator();
            while (it2.hasNext()) {
                C0253a value = it2.next().getValue();
                if (value != null) {
                    long j = value.b;
                    if (j > 0 && System.currentTimeMillis() - j > this.g) {
                        it2.remove();
                    }
                }
            }
        }
    }

    public void f(com.ss.videoarch.strategy.a aVar) {
        if (aVar != null) {
            Log.d("LiveIOEngine", "set mEngine");
            this.b = aVar;
        } else {
            Log.e("LiveIOEngine", "set null mEngine");
        }
    }

    public a(com.ss.videoarch.strategy.a aVar) {
        this.b = null;
        if (aVar != null) {
            Log.d("LiveIOEngine", "set mEngine");
            this.b = aVar;
        } else {
            Log.e("LiveIOEngine", "set null mEngine");
        }
    }

    public JSONObject b(String str) {
        C0253a c0253a;
        Map<String, C0253a> map = this.e;
        if (map == null || map.isEmpty() || !this.e.containsKey(str) || (c0253a = this.e.get(str)) == null) {
            return null;
        }
        return c0253a.a;
    }

    public void c(String str) {
        Log.d("LiveIOEngine", "CharacterFetchStrategy: notifyCharacterChange" + str);
        com.ss.videoarch.strategy.a aVar = this.b;
        if (aVar != null) {
            aVar.a(2, str);
        } else {
            Log.d("LiveIOEngine", "CharacterFetchStrategy: empty mEngine");
        }
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = "";
            if (jSONObject.has("ip")) {
                str2 = jSONObject.optString("ip");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
            }
            Log.d("LiveIOEngine", "preconnect ip: " + str2 + ", preconnresult:  " + str);
            if (this.e != null) {
                Log.d("LiveIOEngine", "preconnect result map size: " + this.e.size());
                if (this.e.size() >= this.h) {
                    h();
                }
                this.e.put(str2, new C0253a(jSONObject, System.currentTimeMillis()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void g(String str) {
        String optString;
        String str2 = (String) lj6.a.m().b("live_stream_strategy_preconnect_protocol", "{}");
        this.a = (List) lj6.a.m().b("live_stream_strategy_preconnect_domains", new ArrayList());
        String str3 = (String) lj6.a.m().b("live_stream_strategy_peconnect_params", "{}");
        this.g = ((Long) lj6.a.m().b("live_stream_strategy_peconnect_result_ttl", 300000L)).longValue();
        this.h = ((Integer) lj6.a.m().b("live_stream_strategy_peconnect_result_capacity", 50)).intValue();
        this.e = new ArrayMap(this.h);
        Log.d("LiveIOEngine", "preconnect protocol info: " + str2 + ", domains: " + this.a + ", params: " + str3 + ", ttl: " + this.g + ", result capacity: " + this.h);
        if (str2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.c.put(next, Integer.valueOf(jSONObject.optInt(next)));
                    if (str3 != null && (optString = new JSONObject(str3).optString(next)) != null) {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        if (next.equals("quic") && !TextUtils.isEmpty(str)) {
                            jSONObject2.put("scfg_address", str);
                        }
                        this.d.put(next, jSONObject2);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str, String str2) {
        JSONObject jSONObject;
        C0253a c0253a;
        if (this.a.isEmpty() || this.c.isEmpty() || !this.a.contains(str)) {
            return;
        }
        Map<String, C0253a> map = this.e;
        if (map != null && map.containsKey(str2) && (c0253a = this.e.get(str2)) != null) {
            long j = c0253a.b;
            if (j > 0 && System.currentTimeMillis() - j < this.g) {
                Log.d("LiveIOEngine", "preconn result is in ttl, no need to preconnect again");
                return;
            }
        }
        for (String str3 : this.c.keySet()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                int intValue = this.c.get(str3).intValue();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("given_ips", str2);
                jSONObject3.put("host", str);
                jSONObject3.put("port", intValue);
                jSONObject3.put("suggest_protocol", str3);
                jSONObject2.put("url_info", jSONObject3.toString());
                if (this.d.containsKey(str3) && (jSONObject = this.d.get(str3)) != null) {
                    jSONObject2.put("preconn_params", jSONObject.toString());
                }
                com.ss.videoarch.strategy.a aVar = this.b;
                if (aVar != null) {
                    aVar.a(1, String.valueOf(jSONObject2.toString()));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: pj6.a$a, reason: collision with other inner class name */
    public class C0253a {
        public JSONObject a;
        public long b;

        static {
            Covode.recordClassIndex(653166);
        }

        C0253a(JSONObject jSONObject, long j) {
            this.a = jSONObject;
            this.b = j;
        }
    }
}
