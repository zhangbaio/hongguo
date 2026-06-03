package lj6;

import android.os.Handler;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.IAppInfoBundle;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.d;
import com.ss.videoarch.strategy.featureCenter.featureType.e;
import com.ss.videoarch.strategy.strategy.networkStrategy.NetworkProber;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import com.ss.videoarch.strategy.strategy.smartStrategy.ABRSwitchStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.TopNHostStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.f;
import com.ss.videoarch.strategy.strategy.smartStrategy.g;
import com.ss.videoarch.strategy.strategy.smartStrategy.h;
import com.ss.videoarch.strategy.strategy.smartStrategy.i;
import com.ss.videoarch.strategy.strategy.smartStrategy.j;
import com.ss.videoarch.strategy.strategy.smartStrategy.l;
import com.ss.videoarch.strategy.strategy.smartStrategy.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mj6.c;
import nj6.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static volatile a d0;
    private JSONObject a = null;
    public JSONObject b = null;
    public JSONObject c = null;
    public JSONObject d = null;
    public final int e = 5000;
    public final long f = 0;
    public JSONArray g = null;
    public String h = null;
    public JSONObject i = null;
    public String j = null;
    public Map<String, Integer> k = new HashMap();
    public Map<String, Object> l = new HashMap();
    public Map<String, Object> m = new HashMap();
    public JSONObject n = null;
    public JSONObject o = null;
    public JSONObject p = null;
    public JSONObject q = null;
    public mj6.a r = new mj6.a();
    public c s = new c();
    public int t = 0;
    public boolean u = false;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public int y = -1;
    public boolean z = false;
    public int A = -1;
    public int B = -1;
    public int C = -1;
    public int D = -1;
    public int E = -1;
    public int F = 300;
    public long G = 0;
    public long H = 0;
    public int I = 0;
    public int J = -1;
    public int K = -1;
    public int L = -1;
    public int M = -1;
    public int N = -1;
    public int O = -1;
    public int P = -1;
    public int Q = -1;
    public int R = -1;
    public int S = -1;
    public int T = 5;
    public int U = 10000;
    public int V = -1;
    public int W = -1;
    public int X = -1;
    public int Y = -1;
    public List<String> Z = new ArrayList();
    public Map<String, List<String>> a0 = new ConcurrentHashMap();
    private IAppInfoBundle b0 = null;
    public Handler c0 = null;

    /* renamed from: lj6.a$a, reason: collision with other inner class name */
    class RunnableC0235a implements Runnable {
        final /* synthetic */ List a;

        @Override // java.lang.Runnable
        public void run() {
            b.f(this.a);
        }

        RunnableC0235a(List list) {
            this.a = list;
        }
    }

    static {
        Covode.recordClassIndex(653113);
        d0 = null;
    }

    public static a m() {
        if (d0 == null) {
            synchronized (a.class) {
                if (d0 == null) {
                    d0 = new a();
                }
            }
        }
        return d0;
    }

    public Set<String> g() {
        HashSet hashSet = new HashSet();
        JSONObject jSONObject = this.i;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                hashSet.add(keys.next());
            }
        }
        return hashSet;
    }

    public String h() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return "";
        }
        try {
            if (!jSONObject.has("ABVersionTrace")) {
                return "";
            }
            return this.b.optString("ABVersionTrace", "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String i() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return "";
        }
        try {
            if (!jSONObject.has("CommonTrace")) {
                return "";
            }
            return this.b.optString("CommonTrace", "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public Set<String> d() {
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = this.g;
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < this.g.length(); i++) {
                JSONObject optJSONObject = this.g.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.has("DomainName")) {
                    String optString = optJSONObject.optString("DomainName");
                    hashSet.add(optString);
                    this.k.put(optString, Integer.valueOf(optJSONObject.optInt("DomainParseType")));
                }
            }
        }
        return hashSet;
    }

    public void a() {
        List<String> list;
        HashMap hashMap = new HashMap();
        if (this.p != null && (list = this.Z) != null) {
            for (String str : list) {
                JSONObject optJSONObject = this.p.optJSONObject(str);
                JSONObject g = b.g(b.e, str);
                if (optJSONObject != null && g != null && !optJSONObject.toString().equals(g.toString())) {
                    hashMap.put(str, optJSONObject);
                }
            }
        }
        Map<String, List<String>> map = this.a0;
        if (map != null && map.size() > 0) {
            for (String str2 : this.a0.keySet()) {
                JSONObject jSONObject = new JSONObject();
                List<String> list2 = this.a0.get(str2);
                if (list2 != null && list2.size() > 0) {
                    for (String str3 : list2) {
                        if (hashMap.containsKey(str3)) {
                            try {
                                jSONObject.put(str3, hashMap.get(str3));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    LiveStrategyManager.inst().mListenerMap.get(str2).getAppInfoForKey("hot_update", jSONObject);
                }
            }
        }
    }

    public void n() {
        if (m().s.i == 1) {
            if (m().t % m().s.j == 0 || m().t == 1) {
                Log.d("LSSettings", "update Config To DB");
                ArrayList arrayList = new ArrayList();
                if (this.n != null) {
                    com.ss.videoarch.strategy.dataCenter.strategyData.model.a aVar = new com.ss.videoarch.strategy.dataCenter.strategyData.model.a();
                    aVar.a = b.c;
                    aVar.b = this.n.toString();
                    arrayList.add(aVar);
                    b.g.put(b.c, aVar);
                }
                if (this.o != null) {
                    com.ss.videoarch.strategy.dataCenter.strategyData.model.a aVar2 = new com.ss.videoarch.strategy.dataCenter.strategyData.model.a();
                    aVar2.a = b.d;
                    aVar2.b = this.o.toString();
                    arrayList.add(aVar2);
                    b.g.put(b.d, aVar2);
                }
                if (this.p != null) {
                    com.ss.videoarch.strategy.dataCenter.strategyData.model.a aVar3 = new com.ss.videoarch.strategy.dataCenter.strategyData.model.a();
                    aVar3.a = b.e;
                    aVar3.b = this.r.toString();
                    arrayList.add(aVar3);
                    b.g.put(b.e, aVar3);
                }
                Handler handler = this.c0;
                if (handler != null) {
                    handler.postDelayed(new RunnableC0235a(arrayList), this.s.k);
                }
            }
        }
    }

    public void o() {
        Log.d("LSSettings", "updateStrategyAndFeatureConfig");
        com.ss.videoarch.strategy.featureCenter.featureType.b.f().b();
        com.ss.videoarch.strategy.featureCenter.featureType.b.f().e();
        com.ss.videoarch.strategy.featureCenter.featureType.c.d().b();
        TypePlayFeaturesCollector.h().b();
        d.e().b();
        e.e().f();
        m.a().initStrategyConfig();
        g.a().initStrategyConfig();
        ABRSwitchStrategy.inst().initStrategyConfig();
        h.a().initStrategyConfig();
        l.g().initStrategyConfig();
        l.g().h();
        com.ss.videoarch.strategy.strategy.smartStrategy.e.a().initStrategyConfig();
        f.a().initStrategyConfig();
        TopNHostStrategy.f().initStrategyConfig();
        com.ss.videoarch.strategy.strategy.smartStrategy.d.a().initStrategyConfig();
        j.b().initStrategyConfig();
        NetworkProber.e().d();
        i.a().initStrategyConfig();
        com.ss.videoarch.strategy.strategy.smartStrategy.b.a().initStrategyConfig();
        com.ss.videoarch.strategy.strategy.smartStrategy.c.a().initStrategyConfig();
        JSONObject jSONObject = this.q;
        if (jSONObject != null) {
            if (jSONObject.has("PlayerFeatureParam")) {
                JSONObject optJSONObject = this.q.optJSONObject("PlayerFeatureParam");
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.l.put(next.replaceAll("_", ""), optJSONObject.opt(next));
                }
            }
            if (this.q.has("AnchorFeatureParam")) {
                JSONObject optJSONObject2 = this.q.optJSONObject("AnchorFeatureParam");
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    this.m.put(next2.replaceAll("_", ""), optJSONObject2.opt(next2));
                }
            }
            e.e().g(this.q);
        }
    }

    public JSONObject c(String str) {
        JSONObject jSONObject = this.p;
        if (jSONObject == null && this.t == 0) {
            return b.g(b.e, str);
        }
        if (jSONObject != null && jSONObject.has(str)) {
            return this.p.optJSONObject(str);
        }
        return null;
    }

    public JSONArray f(String str) {
        JSONObject jSONObject = this.i;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    return this.i.getJSONArray(str);
                }
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public boolean k(SettingsManager.ResponseData responseData) {
        JSONObject jSONObject;
        if (responseData == null) {
            return false;
        }
        try {
            jSONObject = new JSONObject(responseData.responseJsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        this.t++;
        SettingsManager.getInstance().initLSSettings(jSONObject.toString(), this);
        this.r.a();
        o();
        a();
        n();
        oj6.b.b(this.t, responseData.statusCode, responseData.responseCost, responseData.responseJsonStr, this.h);
        return true;
    }

    public void l(IAppInfoBundle iAppInfoBundle) {
        if (iAppInfoBundle == null) {
            return;
        }
        this.b0 = iAppInfoBundle;
        this.w = ((Integer) iAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_open_preconnect", 0)).intValue();
        this.v = ((Integer) this.b0.getAppInfoForKey("live_stream_strategy_enable_performance_optimization", 0)).intValue();
        this.G = ((Long) this.b0.getAppInfoForKey("live_stream_strategy_start_up_delay", 0L)).longValue();
        this.x = ((Integer) this.b0.getAppInfoForKey("live_sdk_enable_liveio", 0)).intValue();
        this.y = ((Integer) this.b0.getAppInfoForKey("live_sdk_enable_liveio_engine", 0)).intValue();
        this.A = ((Integer) this.b0.getAppInfoForKey("live_stream_strategy_enable_thread_timeout", 1)).intValue();
        this.B = ((Integer) this.b0.getAppInfoForKey("live_stream_strategy_enable_hot_domain_precnn", 0)).intValue();
        this.J = ((Integer) this.b0.getAppInfoForKey("live_stream_strategy_enable_room_info_precnn", 0)).intValue();
        this.K = ((Integer) this.b0.getAppInfoForKey("live_stream_strategy_enable_H2Q_precnn", 0)).intValue();
        this.L = ((Integer) this.b0.getAppInfoForKey("live_stream_strategy_socket_idle_timeout", 0)).intValue();
        this.M = ((Integer) this.b0.getAppInfoForKey("live_stream_strategy_enable_precnn_probe", 0)).intValue();
        this.N = ((Integer) this.b0.getAppInfoForKey("live_get_precnn_ip_timeout", 0)).intValue();
        this.O = ((Integer) this.b0.getAppInfoForKey("live_stream_strategy_enable_get_precnn_ip", 0)).intValue();
        this.P = ((Integer) this.b0.getAppInfoForKey("live_enable_pre_created_player", 0)).intValue();
        this.C = ((Integer) this.b0.getAppInfoForKey("live_sdk_super_resolution_enable", 0)).intValue();
        this.s.a((String) this.b0.getAppInfoForKey("live_stream_strategy_enable_persistence", ""));
        this.D = ((Integer) this.b0.getAppInfoForKey("live_stream_strategy_enable_get_httpdns_ip_first", 0)).intValue();
        this.Q = ((Integer) this.b0.getAppInfoForKey("live_sdk_enable_settingmgr_char", 0)).intValue();
        this.R = ((Integer) this.b0.getAppInfoForKey("live_sdk_enable_settingmgr_topn", 0)).intValue();
        this.S = ((Integer) this.b0.getAppInfoForKey("live_sdk_enable_data_warehouse", 0)).intValue();
        this.E = ((Integer) this.b0.getAppInfoForKey("live_sdk_enable_get_ipv6_httpdns_ip_first", 0)).intValue();
        this.T = ((Integer) this.b0.getAppInfoForKey("live_sdk_request_max_retry_times", 5)).intValue();
        this.U = ((Integer) this.b0.getAppInfoForKey("live_sdk_request_retry_sync_interval", 10000)).intValue();
        this.V = ((Integer) this.b0.getAppInfoForKey("live_sdk_enable_new_thread", 0)).intValue();
        this.W = ((Integer) this.b0.getAppInfoForKey("live_sdk_enable_neptune_player", 0)).intValue();
        this.X = ((Integer) this.b0.getAppInfoForKey("live_sdk_get_hot_domains_first_request", 0)).intValue();
        this.Y = ((Integer) this.b0.getAppInfoForKey("live_sdk_set_config_to_liveio", 0)).intValue();
    }

    public <T> T b(String str, T t) {
        IAppInfoBundle iAppInfoBundle = this.b0;
        if (iAppInfoBundle != null) {
            return (T) iAppInfoBundle.getAppInfoForKey(str, t);
        }
        return t;
    }

    public String j(String str, String str2) {
        if (this.q == null) {
            return null;
        }
        Log.d("LSSettings", "UidFeatureJSON:" + this.q.toString());
        try {
            if (this.q.has(str2)) {
                JSONObject jSONObject = this.q.getJSONObject(str2);
                if (jSONObject.has(str)) {
                    return jSONObject.optString(str);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject e(String str, int i) {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has("BatchSettingsParams")) {
                String optString = this.b.getJSONObject("BatchSettingsParams").getJSONObject("live_stream_strategy_engine").optString(str);
                if (optString != null && optString.startsWith("\ufeff")) {
                    optString = optString.substring(1);
                    Log.d("LSSettings", "remove:" + optString);
                }
                JSONObject jSONObject2 = new JSONObject(optString);
                if (i != 0) {
                    if (i != 3) {
                        return jSONObject2;
                    }
                    return this.r.d;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("LivePlayerSettings", this.r.c);
                jSONObject3.put("LSStrategySDKSettings", this.r.b);
                jSONObject3.put("StrategyConfig", this.n);
                return jSONObject3;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
