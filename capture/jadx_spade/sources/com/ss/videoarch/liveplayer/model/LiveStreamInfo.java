package com.ss.videoarch.liveplayer.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.utils.d;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LiveStreamInfo {
    public String H;
    public String K;
    public String L;
    public String M;
    public JSONObject N;
    public int O;
    public JSONObject P;
    private JSONObject a;
    private JSONObject b;
    private int c;
    public String d;
    private String d0;
    public String e;
    private String e0;
    private String i;
    private String j;
    public String r0;
    public String u0;
    private JSONObject v0;
    public long w0;
    public boolean f = false;
    private long g = -1;
    private int h = -1;
    private String k = "";
    private String l = "";
    public int m = 0;
    public int n = 0;
    private final String o = "LiveStreamInfo";
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public int t = 0;
    private int u = 0;
    public int v = 0;
    public int w = 0;
    public int x = 0;
    public int y = 0;
    public int z = 0;
    public int A = 0;
    public String B = "";
    public boolean C = false;
    public JSONObject D = null;
    public JSONObject E = null;
    public JSONObject F = null;
    public boolean G = false;
    public String I = "none";
    public String J = "none";
    private int Q = -1;
    public boolean R = false;
    public boolean S = false;
    private int T = 0;
    private int U = 0;
    public int V = 0;
    public String W = "1.0.105.5";
    public int X = 0;
    public int Y = 0;
    public int Z = 0;
    public int a0 = 0;
    public int b0 = 0;
    public String c0 = "h2q";
    public int f0 = 0;
    private int g0 = 0;
    private String h0 = "";
    public long i0 = -1;
    private HashSet<String> j0 = new HashSet<>();
    public String k0 = "";
    private int l0 = -1;
    public String m0 = "";
    private List<Long> n0 = null;
    private ConcurrentHashMap<String, ConcurrentHashMap<String, JSONObject>> o0 = new ConcurrentHashMap<>();
    private HashMap<String, String> p0 = null;
    private HashMap<String, String> q0 = null;
    private JSONObject s0 = null;
    private HashSet<String> t0 = null;

    static {
        Covode.recordClassIndex(653060);
    }

    public String L() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString("stream_name");
    }

    public String B() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null && jSONObject.has("rule_ids")) {
            return this.b.optString("rule_ids");
        }
        return null;
    }

    public String F() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null && jSONObject.has("session_id")) {
            return this.b.optString("session_id");
        }
        return null;
    }

    public long G() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null || !jSONObject.has("ts")) {
            return 0L;
        }
        return d.f(this.b.optString("ts"), 0L);
    }

    public JSONArray R() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return jSONArray;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            jSONArray.put(keys.next());
        }
        return jSONArray;
    }

    public boolean b0() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null && jSONObject.has("secret_key")) {
            this.B = this.b.optString("secret_key");
            return true;
        }
        return false;
    }

    public JSONObject d() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (!jSONObject.has("auto")) {
                return null;
            }
            return this.b.getJSONObject("auto");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject u() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (!jSONObject.has("p2p_params")) {
                return null;
            }
            return this.b.getJSONObject("p2p_params");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, String> n() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null && jSONObject.has("header")) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject2 = this.b.getJSONObject("header");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.getString(next));
                }
                return hashMap;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int h0() {
        JSONObject D;
        int i;
        int i2;
        int i3 = this.l0;
        if (i3 >= 0) {
            return i3;
        }
        if (TextUtils.isEmpty(this.d)) {
            return -1;
        }
        try {
            D = D(this.d, "main");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (D == null) {
            com.ss.videoarch.liveplayer.log.a.b("LiveStreamInfo", "sdkParamsJson is null");
            return -1;
        }
        String[] split = D.optString("resolution").split("x");
        if (split.length == 2) {
            try {
                i = Integer.parseInt(split[0]);
            } catch (NumberFormatException e2) {
                e = e2;
                i = 0;
            }
            try {
                i2 = Integer.parseInt(split[1]);
            } catch (NumberFormatException e3) {
                e = e3;
                e.printStackTrace();
                i2 = 0;
                if (i2 <= 0) {
                }
                if (i > 0) {
                    this.l0 = 0;
                }
                return this.l0;
            }
            if (i2 <= 0 && i >= i2) {
                this.l0 = 1;
            } else if (i > 0 && i2 > i) {
                this.l0 = 0;
            }
        }
        return this.l0;
    }

    public HashMap<String, String> p() {
        JSONObject optJSONObject;
        HashMap<String, String> hashMap = this.p0;
        if (hashMap != null) {
            return hashMap;
        }
        this.p0 = new HashMap<>();
        JSONObject jSONObject = this.b;
        if (jSONObject != null && jSONObject.has("lines") && (optJSONObject = this.b.optJSONObject("lines")) != null) {
            if (optJSONObject.has("main") && !TextUtils.isEmpty(optJSONObject.optString("main"))) {
                this.p0.put("main", optJSONObject.optString("main"));
            }
            if (optJSONObject.has("backup") && !TextUtils.isEmpty(optJSONObject.optString("backup"))) {
                this.p0.put("backup", optJSONObject.optString("backup"));
            }
        }
        return this.p0;
    }

    public String y() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null && jSONObject.has("query")) {
            if (!TextUtils.isEmpty(this.d0)) {
                return this.d0;
            }
            StringBuilder sb = new StringBuilder();
            try {
                JSONObject jSONObject2 = this.b.getJSONObject("query");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject2.getString(next);
                    String encode = URLEncoder.encode(next, "UTF-8");
                    String encode2 = URLEncoder.encode(string, "UTF-8");
                    sb.append("&");
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
                String sb2 = sb.toString();
                this.d0 = sb2;
                return sb2;
            } catch (UnsupportedEncodingException | JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public JSONObject S() {
        String optString;
        String str;
        JSONObject jSONObject = this.s0;
        if (jSONObject != null) {
            return jSONObject;
        }
        this.s0 = new JSONObject();
        try {
            JSONObject jSONObject2 = this.a;
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = new JSONObject(this.a.optString(next));
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject3.has("main")) {
                        JSONObject jSONObject5 = new JSONObject(jSONObject3.optString("main"));
                        if (jSONObject5.has("templateExtraInfo")) {
                            str = new JSONObject(jSONObject5.getString("templateExtraInfo")).optString("name", null);
                            if (str != null) {
                                jSONObject4.put("main", str);
                            }
                        } else {
                            str = null;
                        }
                        if (str == null && jSONObject5.has("flv")) {
                            jSONObject4.put("main", d.c(jSONObject5.optString("flv")));
                        }
                    }
                    if (jSONObject3.has("backup")) {
                        JSONObject jSONObject6 = new JSONObject(jSONObject3.optString("backup"));
                        if (jSONObject6.has("templateExtraInfo") && (optString = new JSONObject(jSONObject6.getString("templateExtraInfo")).optString("name", null)) != null) {
                            jSONObject4.put("backup", optString);
                        }
                        if (jSONObject6.has("flv")) {
                            jSONObject4.put("backup", d.c(jSONObject6.optString("flv")));
                        }
                    }
                    this.s0.put(next, jSONObject4);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.s0;
    }

    public boolean c0(String str) {
        return d0(str, null);
    }

    public boolean t0(int i) {
        this.c = i | this.c;
        return true;
    }

    public boolean f0(float f) {
        int i = this.u;
        if (i > 0 && f > i) {
            return false;
        }
        return true;
    }

    private boolean i0(String str) {
        if (!TextUtils.isEmpty(str) && str.equals("auto") && !TextUtils.isEmpty(this.d)) {
            return true;
        }
        return false;
    }

    public boolean g0(float f) {
        int i;
        int i2 = this.T;
        if ((i2 > 0 && f > i2) || ((i = this.U) > 0 && f <= i)) {
            return false;
        }
        return true;
    }

    public void r0(String str) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return;
        }
        this.d = str;
    }

    public void s0(int i) {
        this.Q = i;
        com.ss.videoarch.liveplayer.log.a.c("LiveStreamInfo", "setFastOpenDuration: " + i);
    }

    public int w(String str) {
        JSONObject jSONObject;
        if (str == null || (jSONObject = this.b) == null) {
            return 0;
        }
        return jSONObject.optInt(str + "_push_id", 0);
    }

    public JSONObject K(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray R = R();
            for (int i = 0; i < R.length(); i++) {
                String string = R.getString(i);
                int J = J(string, str);
                if (J > 0) {
                    jSONObject.put(string, J);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject T(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject S = S();
        if (S != null) {
            try {
                Iterator<String> keys = S.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, S.getJSONObject(next).getString(str));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public JSONObject h(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray R = R();
            for (int i = 0; i < R.length(); i++) {
                String string = R.getString(i);
                long g = g(string, str);
                if (g > 0) {
                    jSONObject.put(string, g);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void q0(HashSet<String> hashSet) {
        if (hashSet != null && !hashSet.isEmpty() && this.a != null) {
            this.t0 = hashSet;
            Iterator<String> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (this.a.has(next)) {
                    this.a.remove(next);
                }
                JSONObject jSONObject = this.s0;
                if (jSONObject != null) {
                    jSONObject.remove(next);
                }
                HashSet<String> hashSet2 = this.j0;
                if (hashSet2 != null) {
                    hashSet2.remove(next);
                }
            }
        }
    }

    public JSONObject z(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray R = R();
            for (int i = 0; i < R.length(); i++) {
                String string = R.getString(i);
                String optString = new JSONObject(C(string, str)).optString("resolution", null);
                if (optString != null && !optString.isEmpty()) {
                    jSONObject.put(string, optString);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean a0(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return false;
        }
        int i = this.h;
        if (i >= 0) {
            if (i != 1) {
                return false;
            }
            return true;
        }
        this.h = 1;
        Iterator<String> keys = this.a.keys();
        String str2 = null;
        String str3 = null;
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            String next = keys.next();
            if (c0(next)) {
                str3 = W(next, str);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                    this.h = 0;
                    break;
                }
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str3;
                }
            }
        }
        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
            this.h = 0;
        }
        if (this.h != 1) {
            return false;
        }
        return true;
    }

    public a b(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!jSONObject.has("adaptationSet") || (jSONObject2 = jSONObject.getJSONObject("adaptationSet")) == null || !jSONObject2.has("representation") || (jSONArray = jSONObject2.getJSONArray("representation")) == null) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            if (jSONObject3.has("defaultSelect") && jSONObject3.has("url") && jSONObject3.optInt("defaultSelect") == 1) {
                return new a(jSONObject3.getString("url"), jSONObject3.getString("qualityType"), jSONObject3.getInt("bitrate"));
            }
        }
        return null;
    }

    public boolean n0(String str) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            if (this.f0 == 1 && !this.j0.isEmpty() && this.j0.contains(str)) {
                return true;
            }
            JSONObject jSONObject = null;
            try {
                if (this.a.has(str)) {
                    jSONObject = this.a.getJSONObject(str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject != null) {
                if (this.f0 == 1) {
                    this.j0.add(str);
                }
                return true;
            }
        }
        return false;
    }

    public long q(String str) {
        long j;
        List<Long> list;
        long j2 = -1;
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        JSONObject jSONObject = this.E;
        if (jSONObject != null) {
            j = jSONObject.optLong(str);
        } else {
            j = -1;
        }
        if (j != -1 && (list = this.n0) != null && !list.isEmpty()) {
            Collections.sort(this.n0);
            int i = 0;
            while (i < this.n0.size()) {
                long longValue = this.n0.get(i).longValue();
                if (j <= longValue) {
                    break;
                }
                i++;
                j2 = longValue;
            }
        }
        return j2;
    }

    private String x0(String str) {
        int indexOf;
        int indexOf2 = str.indexOf(".com");
        int indexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.l)) {
            if (indexOf3 != -1) {
                int i = indexOf3 + 5;
                int i2 = i + 1;
                while (i2 < sb.length() && sb.charAt(i2) - '0' >= 0 && sb.charAt(i2) - '0' <= 9) {
                    i2++;
                }
                sb.replace(i, i2, this.l);
            } else if (indexOf2 != -1 && ((indexOf = str.indexOf("vhost")) == -1 || indexOf > indexOf2)) {
                sb.insert(indexOf2 + 4, ":" + this.l);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int indexOf4 = sb2.indexOf("://");
        if (!TextUtils.isEmpty(this.k)) {
            if (this.k.equals("kcp")) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpk");
                }
            } else if (!this.k.equals("quic") && !this.k.equals("quicu")) {
                if (this.k.equals("tls")) {
                    if (indexOf4 != -1) {
                        sb2.replace(0, indexOf4, "https");
                    }
                } else if (this.k.equals("tcp")) {
                    if (indexOf4 != -1) {
                        sb2.replace(0, indexOf4, "http");
                    }
                } else if ((this.k.equals("h2") || this.k.equals("h2q") || this.k.equals("h2qu")) && indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpx");
                }
            } else if (indexOf4 != -1) {
                sb2.replace(0, indexOf4, "httpq");
            }
        }
        return sb2.toString();
    }

    public int I(String str) {
        String[] split;
        JSONObject jSONObject;
        String str2 = "backup";
        try {
            String optString = this.a.optString(str);
            JSONObject jSONObject2 = null;
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject3 = new JSONObject(optString);
                if (jSONObject3.has("main")) {
                    jSONObject = new JSONObject(jSONObject3.optString("main"));
                    str2 = "main";
                } else if (!jSONObject3.has("backup")) {
                    str2 = "";
                    jSONObject = null;
                } else {
                    jSONObject = new JSONObject(jSONObject3.optString("backup"));
                }
                if (jSONObject != null) {
                    jSONObject2 = new JSONObject(jSONObject.optString("sdk_params"));
                }
                jSONObject2 = o0(str2, jSONObject2);
            }
            if (jSONObject2 == null) {
                return -1;
            }
            String optString2 = jSONObject2.optString("resolution");
            if (!TextUtils.isEmpty(optString2) && optString2.contains("x") && (split = optString2.split("x")) != null && split.length >= 2) {
                return Math.min(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }
            return -1;
        } catch (JSONException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0038 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String t(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "/"
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r9.q0
            if (r1 != 0) goto L83
            com.ss.videoarch.liveplayer.model.LiveStreamInfo$1 r1 = new com.ss.videoarch.liveplayer.model.LiveStreamInfo$1
            r1.<init>()
            org.json.JSONObject r2 = r9.a
            r3 = 0
            if (r2 != 0) goto L11
            return r3
        L11:
            java.util.Iterator r2 = r2.keys()
        L15:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L81
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "md"
            if (r4 == r5) goto L15
            java.lang.String r5 = "auto"
            if (r4 != r5) goto L2a
            goto L15
        L2a:
            org.json.JSONObject r2 = r9.a
            org.json.JSONObject r2 = r2.optJSONObject(r4)
            java.util.Set r4 = r1.keySet()
            java.util.Iterator r4 = r4.iterator()
        L38:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L81
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            org.json.JSONObject r6 = r2.optJSONObject(r5)
            if (r6 != 0) goto L4b
            goto L38
        L4b:
            java.lang.String r7 = "flv"
            java.lang.String r6 = r6.optString(r7)
            if (r6 != 0) goto L54
            goto L38
        L54:
            java.net.URL r7 = new java.net.URL     // Catch: java.net.MalformedURLException -> L76
            r7.<init>(r6)     // Catch: java.net.MalformedURLException -> L76
            java.lang.String r6 = r7.getFile()     // Catch: java.net.MalformedURLException -> L76
            int r7 = r6.indexOf(r0)     // Catch: java.net.MalformedURLException -> L76
            int r8 = r6.lastIndexOf(r0)     // Catch: java.net.MalformedURLException -> L76
            if (r7 >= r8) goto L7a
            int r7 = r6.indexOf(r0)     // Catch: java.net.MalformedURLException -> L76
            int r7 = r7 + 1
            int r8 = r6.lastIndexOf(r0)     // Catch: java.net.MalformedURLException -> L76
            java.lang.String r6 = r6.substring(r7, r8)     // Catch: java.net.MalformedURLException -> L76
            goto L7b
        L76:
            r6 = move-exception
            r6.printStackTrace()
        L7a:
            r6 = r3
        L7b:
            if (r6 == 0) goto L38
            r1.put(r5, r6)
            goto L38
        L81:
            r9.q0 = r1
        L83:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r9.q0
            java.lang.Object r10 = r0.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.liveplayer.model.LiveStreamInfo.t(java.lang.String):java.lang.String");
    }

    public JSONObject x(String str) {
        String str2;
        JSONObject jSONObject = this.D;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = this.a;
            JSONObject jSONObject3 = null;
            if (jSONObject2 != null) {
                str2 = jSONObject2.optString("origin");
            } else {
                str2 = null;
            }
            if (str2 != null) {
                JSONObject jSONObject4 = new JSONObject(str2);
                if (jSONObject4.has(str)) {
                    jSONObject3 = o0(str, new JSONObject(new JSONObject(jSONObject4.optString(str)).optString("sdk_params")));
                }
            }
            if (jSONObject3 != null) {
                this.D = new JSONObject();
                if (jSONObject3.has("resolution")) {
                    String optString = jSONObject3.optString("resolution");
                    if (!TextUtils.isEmpty(optString) && optString.contains("x")) {
                        this.D.put("push_client_resolution", optString.replace('x', '*'));
                    }
                }
                if (jSONObject3.has("VCodec")) {
                    this.D.put("push_client_codec_type", jSONObject3.optString("VCodec"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.D;
    }

    public LiveStreamInfo(JSONObject jSONObject) {
        int i;
        JSONObject jSONObject2;
        this.H = "none";
        this.K = "none";
        this.L = "none";
        this.M = "none";
        this.N = null;
        this.O = -1;
        this.P = null;
        this.r0 = "";
        this.u0 = "";
        this.v0 = null;
        this.w0 = -1L;
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.getJSONObject("data");
            if (jSONObject.has("common")) {
                this.b = jSONObject.getJSONObject("common");
            }
            JSONObject jSONObject3 = this.b;
            if (jSONObject3 != null && jSONObject3.has("auto") && (jSONObject2 = this.b.getJSONObject("auto")) != null && jSONObject2.has("default")) {
                this.d = jSONObject2.getString("default");
                com.ss.videoarch.liveplayer.log.a.c("LiveStreamInfo", "mDefaultResolution: " + this.d);
            }
            JSONObject jSONObject4 = this.b;
            if (jSONObject4 != null && jSONObject4.has("app_id")) {
                this.H = this.b.optString("app_id");
            }
            JSONObject jSONObject5 = this.b;
            if (jSONObject5 != null && jSONObject5.has("common_trace")) {
                this.K = this.b.optString("common_trace");
            }
            if (!TextUtils.equals(this.K, "none")) {
                JSONObject jSONObject6 = new JSONObject(this.K);
                if (jSONObject6.has("BusinessType")) {
                    this.L = jSONObject6.optString("BusinessType");
                }
                if (jSONObject6.has("SceneTags")) {
                    this.P = jSONObject6.optJSONObject("SceneTags");
                }
            }
            JSONObject jSONObject7 = this.b;
            if (jSONObject7 != null && jSONObject7.has("stream")) {
                this.r0 = this.b.optString("stream");
            }
            JSONObject jSONObject8 = this.b;
            if (jSONObject8 != null && jSONObject8.has("mode")) {
                this.u0 = this.b.optString("mode");
            }
            JSONObject jSONObject9 = this.b;
            if (jSONObject9 != null && jSONObject9.has("major_anchor_level")) {
                this.M = this.b.optString("major_anchor_level");
            }
            JSONObject jSONObject10 = this.b;
            if (jSONObject10 != null && jSONObject10.has("common_sdk_params")) {
                this.v0 = this.b.getJSONObject("common_sdk_params");
            }
            JSONObject jSONObject11 = this.b;
            if (jSONObject11 != null && jSONObject11.has("pre_node_selection")) {
                this.N = this.b.optJSONObject("pre_node_selection");
            }
            JSONObject jSONObject12 = this.b;
            if (jSONObject12 != null && jSONObject12.has("is_cold_start")) {
                if (this.b.optBoolean("is_cold_start")) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.O = i;
            }
            JSONObject jSONObject13 = this.b;
            if (jSONObject13 != null && jSONObject13.has(Constants.VERSION)) {
                this.w0 = this.b.optLong(Constants.VERSION, -1L);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.c = 0;
    }

    public boolean d0(String str, String str2) {
        return e0(str, false, str2);
    }

    public void w0(String str, String str2) {
        this.k = str;
        this.l = str2;
    }

    public String C(String str, String str2) {
        JSONObject D = D(str, str2);
        if (D != null) {
            return D.toString();
        }
        return "";
    }

    public long V(String str, String str2) {
        String A = A(str, str2);
        if (A == null) {
            return -1L;
        }
        return g(A, str);
    }

    private String p0(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            return this.a.getJSONObject(str).getJSONObject(str2).optString("sdk_params");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String A(String str, String str2) {
        JSONObject S;
        if (str2 != null && (S = S()) != null) {
            Iterator<String> keys = S.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (str2.equals(S.optJSONObject(next).optString(str, null))) {
                    return next;
                }
            }
        }
        return null;
    }

    public int J(String str, String str2) {
        JSONObject jSONObject;
        int i;
        JSONObject jSONObject2 = this.a;
        if (jSONObject2 == null) {
            return -1;
        }
        JSONObject optJSONObject = jSONObject2.optJSONObject(str);
        JSONObject jSONObject3 = null;
        if (optJSONObject != null) {
            jSONObject = optJSONObject.optJSONObject(str2);
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            jSONObject3 = jSONObject.optJSONObject("templateRealTimeInfo");
        }
        if (jSONObject3 != null) {
            i = jSONObject3.optInt("bitrateKbps", -1);
        } else {
            i = -1;
        }
        if (i <= 0) {
            return -1;
        }
        return i * 1000;
    }

    public String O(String str, String str2) {
        String str3;
        JSONObject D;
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            D = D(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (D != null && D.has("SuggestAccessCode")) {
            str3 = D.optString("SuggestAccessCode");
            if (str3 == null && !str3.isEmpty()) {
                return str3;
            }
        }
        str3 = null;
        return str3 == null ? null : null;
    }

    public String P(String str, String str2) {
        String str3;
        JSONObject D;
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            D = D(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (D != null && D.has("SuggestFormat")) {
            str3 = D.optString("SuggestFormat");
            if (str3 == null && !str3.isEmpty()) {
                return str3;
            }
        }
        str3 = null;
        return str3 == null ? null : null;
    }

    public String U(String str, int i) {
        String str2;
        JSONObject optJSONObject;
        JSONObject h = h(str);
        if (h == null) {
            return null;
        }
        Iterator<String> keys = h.keys();
        while (true) {
            if (keys.hasNext()) {
                str2 = keys.next();
                if (h.optInt(str2, -1) == i) {
                    break;
                }
            } else {
                str2 = null;
                break;
            }
        }
        JSONObject S = S();
        if (S == null || (optJSONObject = S.optJSONObject(str2)) == null) {
            return null;
        }
        return optJSONObject.optString(str, null);
    }

    public String W(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null || !D.has("VCodec")) {
                return null;
            }
            return D.optString("VCodec");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Y(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null || !D.has("resolution")) {
                return null;
            }
            return D.optString("resolution");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String f(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null || !D.has("AvLines")) {
                return null;
            }
            return D.optString("AvLines");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long g(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return 0L;
        }
        if (str.equals("origin")) {
            long j = this.g;
            if (j > 0) {
                return j;
            }
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null || !D.has("vbitrate")) {
                return 0L;
            }
            return D.optLong("vbitrate");
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public JSONObject i(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            JSONObject D = D(str, str2);
            if (D != null && D.has("cmaf")) {
                return new JSONObject(D.optString("cmaf"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int j(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return -1;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null || !D.has("CheckSilenceInterval")) {
                return -1;
            }
            return D.optInt("CheckSilenceInterval");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String k(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null || !D.has("drType")) {
                return null;
            }
            return D.optString("drType");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long l(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return -1L;
        }
        int i = this.Q;
        if (i != -1) {
            return i;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null || !D.has("FastOpenDuration")) {
                return -1L;
            }
            return D.optLong("FastOpenDuration");
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public long m(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return 0L;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null || !D.has("gop")) {
                return 0L;
            }
            return D.optLong("gop");
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public JSONObject s(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            JSONObject D = D(str, str2);
            if (D != null && D.has("MKRL")) {
                return new JSONObject(D.optString("MKRL"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject D(String str, String str2) {
        JSONObject jSONObject = null;
        try {
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = this.o0.get(str);
            if (concurrentHashMap != null && concurrentHashMap.get(str2) != null) {
                jSONObject = concurrentHashMap.get(str2);
            } else {
                String p0 = p0(str, str2);
                if (!TextUtils.isEmpty(p0)) {
                    JSONObject jSONObject2 = new JSONObject(p0);
                    try {
                        jSONObject = o0(str2, jSONObject2);
                        ConcurrentHashMap<String, JSONObject> concurrentHashMap2 = new ConcurrentHashMap<>();
                        concurrentHashMap2.put(str2, jSONObject);
                        this.o0.put(str, concurrentHashMap2);
                    } catch (Exception e) {
                        e = e;
                        jSONObject = jSONObject2;
                        e.printStackTrace();
                        return jSONObject;
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return jSONObject;
    }

    public int X(String str, String str2) {
        int i;
        int i2;
        JSONObject D;
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return -1;
        }
        try {
            D = D(str, str2);
        } catch (Exception e) {
            e = e;
            i = -1;
        }
        if (D == null) {
            com.ss.videoarch.liveplayer.log.a.b("LiveStreamInfo", "sdkParamsJson is null");
            return -1;
        }
        String[] split = D.optString("resolution").split("x");
        if (split.length < 2) {
            return -1;
        }
        try {
            i = Integer.parseInt(split[0]);
            try {
                i2 = Integer.parseInt(split[1]);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                i2 = -1;
                return i == -1 ? -1 : -1;
            }
            if (i == -1 && i2 != -1) {
                return i | (i2 << 16);
            }
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public boolean m0(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return false;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null) {
                com.ss.videoarch.liveplayer.log.a.b("LiveStreamInfo", "sdkParamsJson is null");
                return false;
            }
            String[] split = D.optString("resolution").split("x");
            if (split.length < 2) {
                return false;
            }
            try {
                return l0(Integer.parseInt(split[0]), Integer.parseInt(split[1]), D.has("VR"));
            } catch (NumberFormatException unused) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
    
        if (r7.optInt("EnablePercentType") == 1) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject o0(java.lang.String r7, org.json.JSONObject r8) {
        /*
            r6 = this;
            java.lang.String r0 = "LiveStreamInfo"
            org.json.JSONObject r1 = r6.v0
            if (r1 == 0) goto Le2
            int r1 = r1.length()
            if (r1 != 0) goto Le
            goto Le2
        Le:
            java.lang.String r1 = "common"
            r2 = 0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.String, org.json.JSONObject>> r3 = r6.o0     // Catch: java.lang.Exception -> L62
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Exception -> L62
            java.util.concurrent.ConcurrentHashMap r3 = (java.util.concurrent.ConcurrentHashMap) r3     // Catch: java.lang.Exception -> L62
            if (r3 == 0) goto L28
            java.lang.Object r4 = r3.get(r7)     // Catch: java.lang.Exception -> L62
            if (r4 == 0) goto L28
            java.lang.Object r7 = r3.get(r7)     // Catch: java.lang.Exception -> L62
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch: java.lang.Exception -> L62
            goto L67
        L28:
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Exception -> L62
            r3.<init>()     // Catch: java.lang.Exception -> L62
            org.json.JSONObject r4 = r6.v0     // Catch: java.lang.Exception -> L62
            boolean r4 = r4.has(r7)     // Catch: java.lang.Exception -> L62
            if (r4 == 0) goto L41
            org.json.JSONObject r4 = r6.v0     // Catch: java.lang.Exception -> L62
            java.lang.String r4 = r4.optString(r7)     // Catch: java.lang.Exception -> L62
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L62
            r5.<init>(r4)     // Catch: java.lang.Exception -> L62
            r2 = r5
        L41:
            r3.put(r7, r2)     // Catch: java.lang.Exception -> L62
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.String, org.json.JSONObject>> r7 = r6.o0     // Catch: java.lang.Exception -> L62
            r7.put(r1, r3)     // Catch: java.lang.Exception -> L62
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L62
            r7.<init>()     // Catch: java.lang.Exception -> L62
            java.lang.String r1 = "add commonSdkParams size: "
            r7.append(r1)     // Catch: java.lang.Exception -> L62
            int r1 = r2.length()     // Catch: java.lang.Exception -> L62
            r7.append(r1)     // Catch: java.lang.Exception -> L62
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L62
            android.util.Log.d(r0, r7)     // Catch: java.lang.Exception -> L62
            goto L66
        L62:
            r7 = move-exception
            r7.printStackTrace()
        L66:
            r7 = r2
        L67:
            if (r7 == 0) goto Le2
            int r1 = r7.length()
            if (r1 != 0) goto L71
            goto Le2
        L71:
            if (r8 == 0) goto Le1
            int r1 = r8.length()
            if (r1 != 0) goto L7a
            goto Le1
        L7a:
            java.lang.String r1 = "EnablePercentType"
            boolean r2 = r7.has(r1)
            if (r2 == 0) goto L8a
            int r1 = r7.optInt(r1)
            r2 = 1
            if (r1 != r2) goto L8a
            goto L8b
        L8a:
            r2 = 0
        L8b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "BeforeMerge: resolution: "
            r1.append(r3)
            int r3 = r8.length()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            java.util.Iterator r1 = r7.keys()     // Catch: java.lang.Exception -> Lc4
        La7:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc8
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Exception -> Lc4
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> Lc4
            if (r2 != 0) goto Lbc
            boolean r4 = r8.has(r3)     // Catch: java.lang.Exception -> Lc4
            if (r4 == 0) goto Lbc
            goto La7
        Lbc:
            java.lang.Object r4 = r7.get(r3)     // Catch: java.lang.Exception -> Lc4
            r8.put(r3, r4)     // Catch: java.lang.Exception -> Lc4
            goto La7
        Lc4:
            r7 = move-exception
            r7.printStackTrace()
        Lc8:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "AfterMerge: resolution: "
            r7.append(r1)
            int r1 = r8.length()
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r0, r7)
            return r8
        Le1:
            return r7
        Le2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.liveplayer.model.LiveStreamInfo.o0(java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }

    public JSONObject E(String str, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null) {
                com.ss.videoarch.liveplayer.log.a.b("LiveStreamInfo", "sdkParamsJson is null");
                return null;
            }
            JSONObject jSONObject = new JSONObject(D.optString("NNSR"));
            this.p = jSONObject.optInt("ShorterSideUpperBound");
            this.q = jSONObject.optInt("LongerSideUpperBound");
            if (jSONObject.has("PanoEnabled")) {
                this.r = jSONObject.optInt("PanoEnabled");
            }
            if (jSONObject.has("PanoShorterSideUpperBound")) {
                this.s = jSONObject.optInt("PanoShorterSideUpperBound");
            }
            if (jSONObject.has("PanoLongerSideUpperBound")) {
                this.t = jSONObject.optInt("PanoLongerSideUpperBound");
            }
            com.ss.videoarch.liveplayer.log.a.c("LiveStreamInfo", "PanoEnabled:" + this.r + ",PanoShorterSideUpperBound:" + this.s + ",PanoLongerSideUpperBound:" + this.t);
            this.u = jSONObject.optInt("FrameRateUpperBound");
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Q(String str, String str2) {
        String str3;
        JSONObject D;
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return null;
        }
        try {
            D = D(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            str3 = null;
        }
        if (D == null) {
            com.ss.videoarch.liveplayer.log.a.b("LiveStreamInfo", "sdkParamsJson is null");
            return null;
        }
        str3 = D.optString("SuggestProtocol");
        this.V = D.optInt("QuicDisableOnFreeFlow", 0);
        this.W = D.optString("QuicPluginMinVersion", "1.0.105.5");
        this.X = D.optInt("EnableQuicPluginVersionCheck", 0);
        this.Y = D.optInt("EnableQuicDegradeInNonPreivew", 0);
        this.Z = D.optInt("EnableQuicByUserSetQosConstraint", 0);
        this.c0 = D.optString("FastFirstFrameProtocol", "h2q");
        this.a0 = D.optInt("EnableQuicDegradeInFaultFormat", 0);
        this.b0 = D.optInt("EnableLSSSuggestProtocol", 0);
        com.ss.videoarch.liveplayer.log.a.c("LiveStreamInfo", "protocol:" + str3 + ", mDisableQuicOnFreeFlow: " + this.V + ", mQuicPluginMinVersion:" + this.W + ", mEnableQuicDegradeInNonPreivew: " + this.Y + ", mEnableQuicByUserSetQosConstraint: " + this.Z + ", mEnableQuicDegradeInFaultFormat: " + this.a0 + ", mFastFirstFrameProtocol: " + this.c0 + ", mEnableLSSSuggestProtocol: " + this.b0);
        if (str3 == null || str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public void u0(String str, String str2, String str3) {
        this.e = str;
        this.i = str2;
        this.j = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String M(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            boolean r0 = r2.n0(r3)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            org.json.JSONObject r0 = r2.a     // Catch: org.json.JSONException -> L23
            java.lang.String r3 = r0.optString(r3)     // Catch: org.json.JSONException -> L23
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L23
            r0.<init>(r3)     // Catch: org.json.JSONException -> L23
            boolean r3 = r0.has(r5)     // Catch: org.json.JSONException -> L23
            if (r3 == 0) goto L27
            java.lang.String r3 = r0.optString(r5)     // Catch: org.json.JSONException -> L23
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L23
            r5.<init>(r3)     // Catch: org.json.JSONException -> L23
            goto L28
        L23:
            r3 = move-exception
            r3.printStackTrace()
        L27:
            r5 = r1
        L28:
            if (r5 == 0) goto L2e
            java.lang.String r1 = r5.optString(r4)
        L2e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.liveplayer.model.LiveStreamInfo.M(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public boolean j0(int i, int i2, boolean z) {
        int max = Math.max(i, i2);
        int min = Math.min(i, i2);
        if (this.r == 1 && z) {
            if (max > this.t || min > this.s) {
                return false;
            }
            return true;
        }
        if (max > this.q || min > this.p) {
            return false;
        }
        return true;
    }

    public boolean l0(int i, int i2, boolean z) {
        boolean z2;
        int max = Math.max(i, i2);
        int min = Math.min(i, i2);
        boolean z3 = true;
        if (max >= this.w && max <= this.v && min >= this.y && min <= this.x) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && this.S) {
            if (max > this.z || min > this.A) {
                z3 = false;
            }
            return z3;
        }
        return z2;
    }

    public String o(long j, String str, String str2) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        Iterator<String> keys = this.a.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (d0(next, str2) && j == g(next, str)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String v(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            org.json.JSONObject r0 = r2.b
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.lang.String r0 = "rtmp"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L11
            java.lang.String r3 = "rtmp_ports"
            goto L13
        L11:
            java.lang.String r3 = "http_ports"
        L13:
            org.json.JSONObject r0 = r2.b     // Catch: org.json.JSONException -> L2f
            boolean r0 = r0.has(r3)     // Catch: org.json.JSONException -> L2f
            if (r0 == 0) goto L33
            org.json.JSONObject r0 = r2.b     // Catch: org.json.JSONException -> L2f
            org.json.JSONObject r3 = r0.getJSONObject(r3)     // Catch: org.json.JSONException -> L2f
            java.lang.String r3 = r3.optString(r4)     // Catch: org.json.JSONException -> L2f
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L2f
            r4.<init>(r3)     // Catch: org.json.JSONException -> L2f
            java.lang.String r3 = r4.optString(r5)     // Catch: org.json.JSONException -> L2f
            goto L34
        L2f:
            r3 = move-exception
            r3.printStackTrace()
        L33:
            r3 = r1
        L34:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L3b
            goto L3c
        L3b:
            r1 = r3
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.liveplayer.model.LiveStreamInfo.v(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public void v0(String str, String str2, JSONObject jSONObject) {
        com.ss.videoarch.liveplayer.log.a.c("LiveStreamInfo", "setSdkParamsJson: " + str + " " + str2);
        ConcurrentHashMap<String, JSONObject> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(str2, jSONObject);
        this.o0.put(str, concurrentHashMap);
    }

    public boolean a(String str, String str2, String str3) {
        if (this.a == null || !n0(str) || !n0(str2)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("ld");
        arrayList.add("sd");
        arrayList.add("hd");
        arrayList.add("uhd");
        arrayList.add("origin");
        int indexOf = arrayList.indexOf(str);
        int indexOf2 = arrayList.indexOf(str2);
        if (indexOf == -1 || indexOf2 == -1 || indexOf <= indexOf2) {
            return false;
        }
        return true;
    }

    public JSONObject c(String str, int i, String str2) {
        JSONObject jSONObject = this.E;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = this.a;
        if (jSONObject2 == null || jSONObject2.length() <= 0) {
            return null;
        }
        Iterator<String> keys = this.a.keys();
        this.E = new JSONObject();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (i == 21 && !TextUtils.isEmpty(this.k0)) {
                    if (!this.k0.contains("\"" + next + "\"")) {
                    }
                }
                if (d0(next, str2)) {
                    this.E.put(next, g(next, str));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.E;
    }

    public JSONObject e(String str, int i, String str2) {
        String Y;
        JSONObject jSONObject = this.F;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = this.a;
        if (jSONObject2 == null || jSONObject2.length() <= 0) {
            return null;
        }
        Iterator<String> keys = this.a.keys();
        this.F = new JSONObject();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (d0(next, str2) && (Y = Y(next, str)) != null) {
                    this.F.put(next, Y);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.F;
    }

    public boolean e0(String str, boolean z, String str2) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return false;
        }
        if (TextUtils.equals(str2, "lls")) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(this.e0)) {
                JSONObject d = d();
                if (d != null && d.has("list")) {
                    JSONArray optJSONArray = d.optJSONArray("list");
                    if (optJSONArray != null) {
                        this.e0 = optJSONArray.toString();
                    }
                }
                return false;
            }
            if (!TextUtils.isEmpty(this.e0)) {
                if (this.e0.contains("\"" + str + "\"")) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!z || !TextUtils.equals(str, this.m0)) {
            return false;
        }
        return true;
    }

    public boolean k0(String str, String str2, boolean z) {
        if (i0(str)) {
            str = this.d;
        }
        if (!n0(str)) {
            return false;
        }
        try {
            JSONObject D = D(str, str2);
            if (D == null) {
                com.ss.videoarch.liveplayer.log.a.b("LiveStreamInfo", "sdkParamsJson is null");
                return false;
            }
            String[] split = D.optString("resolution").split("x");
            if (split.length < 2) {
                return false;
            }
            try {
                return j0(Integer.parseInt(split[0]), Integer.parseInt(split[1]), z);
            } catch (NumberFormatException unused) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0097 A[Catch: JSONException -> 0x00c8, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00c8, blocks: (B:9:0x0018, B:11:0x001e, B:13:0x0026, B:15:0x002c, B:18:0x0097, B:20:0x0037, B:22:0x003d, B:24:0x004f, B:25:0x0051, B:27:0x0059, B:28:0x005b, B:30:0x005f, B:31:0x006f, B:33:0x0073, B:36:0x007b, B:38:0x0083, B:41:0x008b), top: B:8:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject H(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r0 = "NonPreview"
            java.lang.String r1 = "Preview"
            java.lang.String r2 = "BMFASF"
            java.lang.String r3 = "ASF"
            boolean r4 = r7.i0(r8)
            if (r4 == 0) goto L10
            java.lang.String r8 = r7.d
        L10:
            boolean r4 = r7.n0(r8)
            r5 = 0
            if (r4 != 0) goto L18
            return r5
        L18:
            org.json.JSONObject r8 = r7.D(r8, r9)     // Catch: org.json.JSONException -> Lc8
            if (r8 != 0) goto L26
            java.lang.String r8 = "LiveStreamInfo"
            java.lang.String r9 = "sdkParamsJson is null"
            com.ss.videoarch.liveplayer.log.a.b(r8, r9)     // Catch: org.json.JSONException -> Lc8
            return r5
        L26:
            boolean r9 = r8.has(r3)     // Catch: org.json.JSONException -> Lc8
            if (r9 == 0) goto L37
            java.lang.String r8 = r8.optString(r3)     // Catch: org.json.JSONException -> Lc8
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: org.json.JSONException -> Lc8
            r9.<init>(r8)     // Catch: org.json.JSONException -> Lc8
        L35:
            r8 = r9
            goto L95
        L37:
            boolean r9 = r8.has(r2)     // Catch: org.json.JSONException -> Lc8
            if (r9 == 0) goto L93
            java.lang.String r8 = r8.optString(r2)     // Catch: org.json.JSONException -> Lc8
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: org.json.JSONException -> Lc8
            r9.<init>(r8)     // Catch: org.json.JSONException -> Lc8
            java.lang.String r8 = "Enabled"
            int r8 = r9.optInt(r8)     // Catch: org.json.JSONException -> Lc8
            r2 = 1
            if (r8 != r2) goto L51
            r7.R = r2     // Catch: org.json.JSONException -> Lc8
        L51:
            java.lang.String r8 = "PanoEnabled"
            int r8 = r9.optInt(r8)     // Catch: org.json.JSONException -> Lc8
            if (r8 != r2) goto L5b
            r7.S = r2     // Catch: org.json.JSONException -> Lc8
        L5b:
            boolean r8 = r7.S     // Catch: org.json.JSONException -> Lc8
            if (r8 == 0) goto L6f
            java.lang.String r8 = "PanoLongerSideUpperBound"
            int r8 = r9.optInt(r8)     // Catch: org.json.JSONException -> Lc8
            r7.z = r8     // Catch: org.json.JSONException -> Lc8
            java.lang.String r8 = "PanoShorterSideUpperBound"
            int r8 = r9.optInt(r8)     // Catch: org.json.JSONException -> Lc8
            r7.A = r8     // Catch: org.json.JSONException -> Lc8
        L6f:
            boolean r8 = r7.R     // Catch: org.json.JSONException -> Lc8
            if (r8 == 0) goto L90
            boolean r8 = r9.has(r1)     // Catch: org.json.JSONException -> Lc8
            if (r8 == 0) goto L83
            if (r10 == 0) goto L83
            org.json.JSONObject r8 = r9.optJSONObject(r1)     // Catch: org.json.JSONException -> Lc8
        L7f:
            r6 = r9
            r9 = r8
            r8 = r6
            goto L95
        L83:
            boolean r8 = r9.has(r0)     // Catch: org.json.JSONException -> Lc8
            if (r8 == 0) goto L35
            if (r10 != 0) goto L35
            org.json.JSONObject r8 = r9.optJSONObject(r0)     // Catch: org.json.JSONException -> Lc8
            goto L7f
        L90:
            r8 = r9
            r9 = r5
            goto L95
        L93:
            r8 = r5
            r9 = r8
        L95:
            if (r9 == 0) goto Lc7
            java.lang.String r10 = "LongerSideUpperBound"
            int r10 = r9.optInt(r10)     // Catch: org.json.JSONException -> Lc8
            r7.v = r10     // Catch: org.json.JSONException -> Lc8
            java.lang.String r10 = "LongerSideLowerBound"
            int r10 = r9.optInt(r10)     // Catch: org.json.JSONException -> Lc8
            r7.w = r10     // Catch: org.json.JSONException -> Lc8
            java.lang.String r10 = "ShorterSideUpperBound"
            int r10 = r9.optInt(r10)     // Catch: org.json.JSONException -> Lc8
            r7.x = r10     // Catch: org.json.JSONException -> Lc8
            java.lang.String r10 = "ShorterSideLowerBound"
            int r10 = r9.optInt(r10)     // Catch: org.json.JSONException -> Lc8
            r7.y = r10     // Catch: org.json.JSONException -> Lc8
            java.lang.String r10 = "FrameRateLowerBound"
            int r10 = r9.optInt(r10)     // Catch: org.json.JSONException -> Lc8
            r7.U = r10     // Catch: org.json.JSONException -> Lc8
            java.lang.String r10 = "FrameRateUpperBound"
            int r9 = r9.optInt(r10)     // Catch: org.json.JSONException -> Lc8
            r7.T = r9     // Catch: org.json.JSONException -> Lc8
        Lc7:
            return r8
        Lc8:
            r8 = move-exception
            r8.printStackTrace()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.liveplayer.model.LiveStreamInfo.H(java.lang.String, java.lang.String, boolean):org.json.JSONObject");
    }

    public boolean Z(String str, String str2, long j) {
        char c;
        boolean z = true;
        long j2 = 0;
        if (j > 0 && this.g > 0) {
            return true;
        }
        if (!c0("origin")) {
            return false;
        }
        long g = g("origin", str2);
        String str3 = "uhd";
        while (true) {
            if (TextUtils.isEmpty(str3)) {
                break;
            }
            if (c0(str3) && !str3.equals("origin")) {
                long g2 = g(str3, str2);
                if (g2 > j2 && g < g2) {
                    if (j > 0) {
                        this.g = j;
                    } else {
                        return z;
                    }
                }
            } else {
                int hashCode = str3.hashCode();
                if (hashCode != -1008619738) {
                    if (hashCode != 3324) {
                        if (hashCode != 3448) {
                            if (hashCode != 3665) {
                                if (hashCode == 115761 && str3.equals("uhd")) {
                                    c = 1;
                                }
                                c = 65535;
                            } else {
                                if (str3.equals("sd")) {
                                    c = 3;
                                }
                                c = 65535;
                            }
                        } else {
                            if (str3.equals("ld")) {
                                c = 4;
                            }
                            c = 65535;
                        }
                    } else {
                        if (str3.equals("hd")) {
                            c = 2;
                        }
                        c = 65535;
                    }
                } else {
                    if (str3.equals("origin")) {
                        c = 0;
                    }
                    c = 65535;
                }
                if (c != 0) {
                    if (c == 1) {
                        str3 = "hd";
                    } else if (c == 2) {
                        str3 = "sd";
                    } else if (c == 3) {
                        str3 = "ld";
                    }
                    z = true;
                    j2 = 0;
                }
                str3 = null;
                z = true;
                j2 = 0;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String N(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.liveplayer.model.LiveStreamInfo.N(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public class a {
        public final String a;
        public final String b;
        public final int c;

        static {
            Covode.recordClassIndex(653061);
        }

        public a(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7 A[Catch: JSONException -> 0x01aa, TryCatch #0 {JSONException -> 0x01aa, blocks: (B:33:0x0091, B:35:0x0097, B:36:0x00c4, B:39:0x00dc, B:41:0x00e7, B:43:0x00ee, B:44:0x0104, B:46:0x010c, B:47:0x0122, B:50:0x012a, B:53:0x0134, B:55:0x013e, B:56:0x014e, B:58:0x0157, B:61:0x0165, B:62:0x0169, B:65:0x014b, B:68:0x00af, B:86:0x0176, B:89:0x0183, B:91:0x018e, B:92:0x0193), top: B:32:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012a A[Catch: JSONException -> 0x01aa, TRY_ENTER, TryCatch #0 {JSONException -> 0x01aa, blocks: (B:33:0x0091, B:35:0x0097, B:36:0x00c4, B:39:0x00dc, B:41:0x00e7, B:43:0x00ee, B:44:0x0104, B:46:0x010c, B:47:0x0122, B:50:0x012a, B:53:0x0134, B:55:0x013e, B:56:0x014e, B:58:0x0157, B:61:0x0165, B:62:0x0169, B:65:0x014b, B:68:0x00af, B:86:0x0176, B:89:0x0183, B:91:0x018e, B:92:0x0193), top: B:32:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0157 A[Catch: JSONException -> 0x01aa, TryCatch #0 {JSONException -> 0x01aa, blocks: (B:33:0x0091, B:35:0x0097, B:36:0x00c4, B:39:0x00dc, B:41:0x00e7, B:43:0x00ee, B:44:0x0104, B:46:0x010c, B:47:0x0122, B:50:0x012a, B:53:0x0134, B:55:0x013e, B:56:0x014e, B:58:0x0157, B:61:0x0165, B:62:0x0169, B:65:0x014b, B:68:0x00af, B:86:0x0176, B:89:0x0183, B:91:0x018e, B:92:0x0193), top: B:32:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0165 A[Catch: JSONException -> 0x01aa, TryCatch #0 {JSONException -> 0x01aa, blocks: (B:33:0x0091, B:35:0x0097, B:36:0x00c4, B:39:0x00dc, B:41:0x00e7, B:43:0x00ee, B:44:0x0104, B:46:0x010c, B:47:0x0122, B:50:0x012a, B:53:0x0134, B:55:0x013e, B:56:0x014e, B:58:0x0157, B:61:0x0165, B:62:0x0169, B:65:0x014b, B:68:0x00af, B:86:0x0176, B:89:0x0183, B:91:0x018e, B:92:0x0193), top: B:32:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String r(java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.liveplayer.model.LiveStreamInfo.r(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
