package ej6;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.videoarch.strategy.LiveStrategyManager;
import fj6.c;
import hj6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zi6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static String M;
    private static int N;
    private static int O;
    private static int P;
    private static int Q;
    private static int R;
    private c L;
    private final Context c;
    private int a = -1;
    private int b = -1;
    private boolean d = false;
    private int e = 0;
    private boolean f = false;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = -1;
    private int p = 0;
    private int q = 1048576;
    private int r = -1;
    public int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private long w = 0;
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private String A = "";
    private int B = 0;
    private int C = 0;
    private int D = 1000;
    private int E = 4;
    private int F = -1;
    private int G = 0;
    private int H = 0;
    private int I = N;
    public String J = "";
    private JSONObject K = null;

    public void a() {
        this.I = O;
    }

    private boolean l() {
        if (this.s == 1 && d.i(this.c) != 1) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(653036);
        M = "LiveIO";
        N = 0;
        O = 1;
        P = 2;
        Q = 0;
        R = 1;
    }

    private JSONObject d(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i = 1;
            if (this.H == 1) {
                if (this.l != 1 || this.s != 1) {
                    i = 0;
                }
                jSONObject.put("http_keep_origin_host", i);
            } else {
                jSONObject.put("http_keep_origin_host", this.l);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject j(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = this.K;
        if (jSONObject2 != null && jSONObject2.has("httpx")) {
            try {
                JSONObject optJSONObject = this.K.optJSONObject("httpx");
                if (optJSONObject != null && !l()) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object obj = optJSONObject.get(next);
                        if (obj instanceof JSONObject) {
                            obj = optJSONObject.optString(next);
                        }
                        jSONObject.put(next, obj);
                    }
                    jSONObject.put("HttpScfgPath", this.c.getFilesDir().getAbsolutePath() + "/pullstreamso.scfg");
                }
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.K = jSONObject;
        if (jSONObject.has("LiveIOConfig") && (optJSONObject = jSONObject.optJSONObject("LiveIOConfig")) != null) {
            this.g = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.g), "EnableLiveIO")).intValue();
            int intValue = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.h), "EnableP2P")).intValue();
            this.h = intValue;
            this.i = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(intValue), "EnableP2PQuic")).intValue();
            this.t = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.t), "EnableP2pUp")).intValue();
            this.j = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.j), "EnableHttpPrepare")).intValue();
            this.k = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.k), "EnableHttpReadBlock")).intValue();
            this.m = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.m), "EnableHttpKeepOriginAgent")).intValue();
            this.n = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.n), "EnableHttpKeepRedirectIP")).intValue();
            this.p = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.p), "EnableLiveIOTimeoutInternal")).intValue();
            this.r = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.r), "HttpReadBlockDelay")).intValue();
            this.q = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.q), "LiveIOReadBuffer")).intValue();
            this.B = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.B), "EnableLiveIORace")).intValue();
            this.C = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.C), "EnableLiveIORaceIPV6First")).intValue();
            this.E = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.E), "RaceMaxNodeSize")).intValue();
            this.D = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.D), "Ipv6DegradeDelay")).intValue();
            this.F = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.F), "Ipv6Expversion")).intValue();
            this.H = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.H), "KeepOriginHostOnlyInFreeFlow")).intValue();
            this.l = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(optJSONObject, Integer.valueOf(this.l), "EnableHttpKeepOriginHost")).intValue();
        }
    }

    public List<String> c(String str, int i) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("protocolType", i);
            jSONObject.put("host", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return (List) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, 24, arrayList, jSONObject);
    }

    public a(Context context, c cVar) {
        this.c = context;
        this.L = cVar;
    }

    public JSONObject b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (this.B == 1 && this.I == N) {
                JSONArray i = i(str, Q);
                if (i.length() != 0) {
                    jSONObject.put("trans_enable_race", this.B);
                    jSONObject.put("trans_ipv6_list", i.toString());
                    jSONObject.put("trans_ipv4_list", i(str, R).toString());
                    jSONObject.put("trans_ipv6_race_first", this.C);
                    jSONObject.put("trans_race_max_node", this.E);
                    jSONObject.put("trans_ipv6_degrad_delay", this.D);
                    jSONObject.put("trans_ipv6_degrade_delay", this.D);
                } else {
                    jSONObject.put("trans_enable_race", 0);
                    this.I = P;
                }
            }
            jSONObject.put("is_enable_p2p_quic", this.i);
            return d(j(jSONObject));
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public JSONArray i(String str, int i) {
        ArrayList arrayList = new ArrayList(c(str, i));
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        if (R == i) {
            this.a = jSONArray.length();
            com.ss.videoarch.liveplayer.log.a.c(M, "ipv4 node size: " + this.a);
        } else if (Q == i) {
            int length = jSONArray.length();
            this.b = length;
            String str2 = this.J;
            if (str2 != null && length == 0 && str2.startsWith("[")) {
                jSONArray.put(this.J);
            }
            com.ss.videoarch.liveplayer.log.a.c(M, "ipv6 node size: " + this.b);
        }
        return jSONArray;
    }

    public JSONObject m(int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (-1 != i && i != 0 && 2 == i) {
            try {
                jSONObject.put("ipv4_race_node_size", this.a).put("ipv6_race_node_size", this.b).put("ipv6_exp_version", this.F).put("node_race_enable", this.B).put("node_race_disable_reason", this.I).put("node_race_first", this.C).put("node_reace_degrade_delay", this.D);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private String e(String str, int i, String str2) {
        String y = f.t().y(str, i);
        if (!TextUtils.isEmpty(y)) {
            return y;
        }
        return str2;
    }

    public fj6.d f(fj6.d dVar, String str, int i) {
        if (dVar == null) {
            return null;
        }
        fj6.d h = h(g(dVar, str, i), str, i);
        com.ss.videoarch.liveplayer.log.a.c(M, "liveio tt_quic_sdk_version: " + h.B1 + ", quic_connection_id: " + h.Q1 + ", h2NegotiateProtocol: " + h.E1 + ", h2RaceResult: " + h.G1 + ", h2Reused: " + h.W1 + ", quicOpenResult: " + h.M1 + ", quicConfigCached: " + h.K1 + ", quicCHLOCount:" + h.L1 + ", rej count: " + h.D1 + ", quicRejReasons: " + h.C1);
        return h;
    }

    public fj6.d h(fj6.d dVar, String str, int i) {
        if (dVar == null) {
            return null;
        }
        dVar.B1 = e(str, 1110, dVar.B1);
        dVar.Q1 = e(str, 1138, dVar.Q1);
        dVar.E1 = e(str, 1140, dVar.E1);
        dVar.C1 = e(str, 1112, dVar.C1);
        dVar.f2 = e(str, 1120, dVar.f2);
        dVar.g2 = e(str, 1121, dVar.g2);
        dVar.h2 = e(str, 1122, dVar.h2);
        return dVar;
    }

    public fj6.d g(fj6.d dVar, String str, int i) {
        if (dVar == null) {
            return null;
        }
        dVar.G1 = (int) f.t().w(str, 1141);
        dVar.M1 = (int) f.t().w(str, 1105);
        dVar.W1 = (int) f.t().w(str, 1139);
        dVar.K1 = (int) f.t().w(str, 1107);
        dVar.L1 = (int) f.t().w(str, 1106);
        dVar.D1 = (int) f.t().w(str, 1111);
        dVar.b2 = (int) f.t().w(str, TTVideoEngineInterface.PLAYER_OPTION_CODECPOOL_RESPONSE);
        dVar.c2 = (int) f.t().w(str, 1117);
        dVar.d2 = (int) f.t().w(str, 1118);
        dVar.e2 = (int) f.t().w(str, 1119);
        return dVar;
    }
}
