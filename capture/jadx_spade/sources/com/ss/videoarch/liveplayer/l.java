package com.ss.videoarch.liveplayer;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.videoarch.liveplayer.k;
import com.ss.videoarch.liveplayer.log.LiveError;
import com.ss.videoarch.strategy.LiveStrategyManager;
import hj6.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class l implements Runnable {
    public b b;
    private k.a c;
    private k.b d;
    private fj6.c f;
    private hj6.a i;
    private jj6.a o;
    private String a = null;
    private com.ss.videoarch.liveplayer.model.a e = new com.ss.videoarch.liveplayer.model.a();
    private String g = "tcp";
    private List<String> h = null;
    private List<String> j = null;
    private String k = "none";
    private String l = null;
    private String m = "none";
    private String n = "none";
    private String p = null;
    private String q = "";
    private boolean r = false;
    private JSONObject s = null;
    private final Handler t = new HandlerDelegate(Looper.myLooper());

    public interface b {
        void a(String str, String str2, String str3, String str4, k.a aVar);
    }

    static {
        Covode.recordClassIndex(652944);
    }

    @Override // java.lang.Runnable
    public void run() {
        t();
    }

    private Boolean k() {
        k.b bVar = this.d;
        boolean z = true;
        if (bVar.d != 1 || bVar.e != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private void q() {
        k.a aVar = this.c;
        this.e = aVar.a;
        this.f = aVar.b;
        this.g = aVar.c;
        this.h = aVar.d;
        this.i = aVar.e;
        this.j = aVar.f;
        this.k = aVar.g;
        this.l = aVar.h;
        this.m = aVar.i;
        this.n = aVar.j;
        this.o = aVar.k;
        this.p = aVar.l;
        this.q = aVar.m;
        this.r = aVar.n;
    }

    private void v() {
        k.a aVar = this.c;
        aVar.a = this.e;
        aVar.b = this.f;
        aVar.c = this.g;
        aVar.d = this.h;
        aVar.e = this.i;
        aVar.f = this.j;
        aVar.g = this.k;
        aVar.h = this.l;
        aVar.i = this.m;
        aVar.j = this.n;
        aVar.k = this.o;
        aVar.l = this.p;
        aVar.m = this.q;
        aVar.n = this.r;
    }

    class a implements a.d {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        /* renamed from: com.ss.videoarch.liveplayer.l$a$a, reason: collision with other inner class name */
        class RunnableC0099a implements Runnable {
            final /* synthetic */ LiveError a;
            final /* synthetic */ String b;

            @Override // java.lang.Runnable
            public void run() {
                LiveError liveError = this.a;
                if (liveError != null) {
                    com.ss.videoarch.liveplayer.log.a.c("VLDNSParser DNSError", liveError.toString());
                    if (l.this.d.h) {
                        l.this.f.k1(this.a);
                    } else {
                        l.this.o.l(this.a, l.this.d.g);
                        a aVar = a.this;
                        l lVar = l.this;
                        String str = aVar.b;
                        lVar.r(str, str, this.b, aVar.a);
                        return;
                    }
                }
                if (l.this.d.i) {
                    com.ss.videoarch.liveplayer.log.a.c("VLDNSParser DNSCancel", "cancel");
                    a aVar2 = a.this;
                    l lVar2 = l.this;
                    String str2 = aVar2.b;
                    lVar2.r(str2, str2, this.b, aVar2.a);
                    return;
                }
                String str3 = this.b;
                String j = l.this.j(str3, false);
                if (!TextUtils.isEmpty(j) && !j.equals(this.b)) {
                    str3 = j;
                }
                String str4 = a.this.b;
                String str5 = this.b;
                if (str5 == null || str5.length() == 0) {
                    str3 = "none";
                } else {
                    hj6.a unused = l.this.i;
                    str4 = hj6.a.n(a.this.b, str3, false);
                }
                l.this.f.w0();
                l.this.f.U1(str3, false);
                l.this.p = str3;
                a aVar3 = a.this;
                l.this.r(str4, aVar3.b, str3, aVar3.a);
            }

            RunnableC0099a(LiveError liveError, String str) {
                this.a = liveError;
                this.b = str;
            }
        }

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // hj6.a.d
        public void a(String str, String str2, LiveError liveError, boolean z) {
            String str3 = this.a;
            if (str3 != null && str != null && str3.equals(str)) {
                l.this.f.Xe = l.this.j;
                l.this.f.j1(!z, false);
                if (z) {
                    l.this.u(new RunnableC0099a(liveError, str2));
                    return;
                }
                String j = l.this.j(str2, false);
                if (TextUtils.isEmpty(j) || j.equals(str2)) {
                    j = str2;
                }
                String str4 = this.b;
                if (str2 != null && str2.length() != 0) {
                    hj6.a unused = l.this.i;
                    str4 = hj6.a.n(this.b, j, false);
                } else {
                    j = "none";
                }
                l.this.f.w0();
                l.this.f.U1(j, false);
                l.this.p = j;
                l.this.r(str4, this.b, j, this.a);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5 */
    private void t() {
        List<String> list;
        com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "2. parsePlayDNS:" + this.a);
        this.r = false;
        String str = this.a;
        String m = hj6.a.m(str);
        this.f.U1("none", false);
        this.f.Ye = m;
        this.l = str;
        if (!hj6.a.p(m)) {
            k.b bVar = this.d;
            if (bVar.c && m != null) {
                jj6.a aVar = this.o;
                aVar.i = m;
                if (bVar.j && aVar.i() <= 3) {
                    a aVar2 = 0;
                    String str2 = null;
                    aVar2 = 0;
                    c cVar = new c(this, aVar2);
                    k.b bVar2 = this.d;
                    if (bVar2.a == 1 && bVar2.k && !bVar2.l && (list = this.h) != null && !list.isEmpty()) {
                        String j = j(this.h.get(0), true);
                        cVar.a = j;
                        JSONObject jSONObject = this.s;
                        if (jSONObject != null && jSONObject.has(j)) {
                            cVar.c = this.s.optString(cVar.a);
                            this.f.Ke = 1;
                        }
                        com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "get node optimize backup ip " + cVar.a);
                    } else {
                        if (k().booleanValue()) {
                            if (this.g.equals("quic") || this.g.equals("h2q")) {
                                cVar.a = l(m);
                                com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "getPreconnIp: " + cVar.a);
                                this.f.cg = TextUtils.isEmpty(cVar.a);
                            }
                            if (TextUtils.isEmpty(cVar.a)) {
                                aVar2 = o(m, cVar);
                            }
                        } else {
                            com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "Not enableNodeOptimizerInStrategySDK and dns is null");
                        }
                        this.f.Ta = new ArrayList();
                        List<String> list2 = this.h;
                        str2 = aVar2;
                        if (list2 != null) {
                            this.f.Ta.addAll(list2);
                            str2 = aVar2;
                        }
                    }
                    if (!TextUtils.isEmpty(cVar.a)) {
                        List<String> list3 = this.h;
                        if (list3 != null && list3.contains(cVar.a)) {
                            this.h.remove(cVar.a);
                        }
                        this.f.j1(false, true);
                        String str3 = cVar.c;
                        if (str3 == null) {
                            str3 = "sdk_previous_dns";
                        }
                        cVar.c = str3;
                        this.f.Y1(str3);
                        if (cVar.d.booleanValue()) {
                            this.f.X = cVar.d.booleanValue();
                        }
                        fj6.c cVar2 = this.f;
                        cVar2.F8 = cVar.b;
                        cVar2.w0();
                        this.f.U1(cVar.a, false);
                        String str4 = cVar.a;
                        this.p = str4;
                        String str5 = str2;
                        if (str2 == null) {
                            str5 = str;
                        }
                        r(hj6.a.n(str5, str4, false), str, this.p, m);
                        return;
                    }
                    this.f.F8 = cVar.b;
                } else {
                    com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "EnableDnsOptimizer: " + this.d.j + ", retry times:" + this.o.i());
                }
                List<String> list4 = this.j;
                if (list4 == null) {
                    this.j = new ArrayList();
                } else {
                    list4.clear();
                }
                s(m, str);
                return;
            }
        }
        n(str, m);
        com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "handleDnsFreeCase");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Runnable runnable) {
        this.t.postAtFrontOfQueue(runnable);
    }

    private String l(String str) {
        return LiveStrategyManager.inst().getPreconnResult(str);
    }

    private class c {
        String a;
        int b;
        String c;
        Boolean d;

        static {
            Covode.recordClassIndex(652946);
        }

        private c() {
            this.a = null;
            this.b = -1;
            this.c = "none";
            this.d = Boolean.FALSE;
        }

        /* synthetic */ c(l lVar, a aVar) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String m(org.json.JSONObject r10) {
        /*
            r9 = this;
            com.ss.videoarch.strategy.LiveStrategyManager r0 = com.ss.videoarch.strategy.LiveStrategyManager.inst()
            r1 = 0
            r2 = 15
            r3 = 0
            java.lang.Object r10 = r0.getConfigAndStrategyByKeyInt(r1, r2, r3, r10)
            org.json.JSONObject r10 = (org.json.JSONObject) r10
            java.lang.String r0 = "VLDNSParser"
            if (r10 == 0) goto Ldd
            fj6.c r1 = r9.f
            java.lang.String r2 = r10.toString()
            r1.Ue = r2
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.String r2 = "quic_preconn_result"
            boolean r4 = r10.has(r2)
            r5 = -1
            if (r4 == 0) goto L44
            int r2 = r10.optInt(r2)
            if (r2 == 0) goto L45
            r4 = -499499(0xfffffffffff860d5, float:NaN)
            if (r2 == r4) goto L45
            java.lang.String r4 = "tcp_preconn_result"
            boolean r6 = r10.has(r4)
            if (r6 == 0) goto L41
            int r4 = r10.optInt(r4)
            if (r4 != 0) goto L46
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            goto L46
        L41:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            goto L45
        L44:
            r2 = -1
        L45:
            r4 = -1
        L46:
            java.lang.String r6 = "quic_preconn_count"
            boolean r7 = r10.has(r6)
            if (r7 == 0) goto L53
            int r6 = r10.optInt(r6)
            goto L54
        L53:
            r6 = -1
        L54:
            java.lang.String r7 = "tcp_preconn_count"
            boolean r8 = r10.has(r7)
            if (r8 == 0) goto L60
            int r5 = r10.optInt(r7)
        L60:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r7 = "quicPreconnResult: "
            r10.append(r7)
            r10.append(r2)
            java.lang.String r2 = ",tcpPreconnResult:  "
            r10.append(r2)
            r10.append(r4)
            java.lang.String r2 = ", quicPreconnCount: "
            r10.append(r2)
            r10.append(r6)
            java.lang.String r2 = ", tcpPreconnCount: "
            r10.append(r2)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            com.ss.videoarch.liveplayer.log.a.c(r0, r10)
            boolean r10 = r1.booleanValue()
            if (r10 == 0) goto Le2
            java.lang.String r10 = r9.k
            java.lang.String r1 = "tls"
            boolean r10 = r10.equals(r1)
            java.lang.String r2 = "httpq"
            if (r10 == 0) goto Lab
            r9.g = r1
            java.lang.String r10 = r9.l
            java.lang.String r1 = "https"
            java.lang.String r10 = r10.replaceAll(r2, r1)
            r9.l = r10
            goto Lb9
        Lab:
            java.lang.String r10 = "tcp"
            r9.g = r10
            java.lang.String r10 = r9.l
            java.lang.String r1 = "http"
            java.lang.String r10 = r10.replaceAll(r2, r1)
            r9.l = r10
        Lb9:
            fj6.c r1 = r9.f
            r2 = 1
            r1.Te = r2
            java.lang.String r2 = r9.m
            java.lang.String r3 = r9.g
            java.lang.String r4 = r9.n
            r1.g2(r2, r3, r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "quic fallback tcp, fallbackURL: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            com.ss.videoarch.liveplayer.log.a.c(r0, r1)
            r3 = r10
            goto Le2
        Ldd:
            java.lang.String r10 = "get quic preconn result null"
            com.ss.videoarch.liveplayer.log.a.c(r0, r10)
        Le2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.liveplayer.l.m(org.json.JSONObject):java.lang.String");
    }

    public void p(k kVar, b bVar) {
        this.c = kVar.c;
        q();
        this.d = kVar.d;
        this.b = bVar;
        this.a = kVar.a;
    }

    private void n(String str, String str2) {
        this.f.j1(false, false);
        this.f.w0();
        this.f.U1(str2, false);
        this.p = str2;
        if (!TextUtils.isEmpty(this.q) && hj6.a.p(str2)) {
            r(str, str, null, this.q);
        } else {
            r(str, str, null, null);
        }
    }

    private void s(String str, String str2) {
        com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "parseDns, host:" + str + ", playURL:" + str2);
        this.i.u(str, this.j, new a(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(String str, boolean z) {
        List<String> list;
        String str2;
        if (this.d.f == 1) {
            if ((TextUtils.equals(this.g, "quic") || TextUtils.equals(this.g, "quicu") || TextUtils.equals(this.g, "h2q") || TextUtils.equals(this.g, "h2qu")) && !hj6.a.q(str, false)) {
                if (z) {
                    list = this.h;
                } else {
                    list = this.j;
                }
                if (list != null && !list.isEmpty()) {
                    Iterator<String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        str2 = it2.next();
                        if (hj6.a.q(str2, false)) {
                            com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "quic not support ipv6: " + str + ", fallback ipv4: " + str2);
                            break;
                        }
                        it2.remove();
                    }
                }
                str2 = str;
                if (TextUtils.equals(str2, str)) {
                    return "";
                }
                return str2;
            }
            return str;
        }
        return str;
    }

    private String o(String str, c cVar) {
        JSONArray optJSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("host", str);
            jSONObject.put("stream_session_vv_id", this.f.N6);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jSONObject2 = (JSONObject) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, 13, null, jSONObject);
        if (jSONObject2 != null) {
            this.f.Ze = jSONObject2.toString();
            if (jSONObject2.has("Ip")) {
                cVar.a = jSONObject2.optString("Ip");
                com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "get ip from strategy sdk, ip: " + cVar.a);
                if (cVar.a != null) {
                    this.f.Ke = 1;
                }
            } else {
                com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "nodeOptimizerInfos no ip:" + str);
            }
            if (jSONObject2.has("RemoteResult") && (optJSONArray = jSONObject2.optJSONArray("RemoteResult")) != null) {
                this.h = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.h.add(optJSONArray.optString(i));
                }
            }
            cVar.a = j(cVar.a, true);
            if (jSONObject2.has("RequestId")) {
                this.f.Yb = jSONObject2.optString("RequestId");
            }
            if (jSONObject2.has("EvaluatorSymbol")) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("EvaluatorSymbol");
                this.s = optJSONObject;
                if (optJSONObject != null && optJSONObject.has(cVar.a)) {
                    cVar.c = this.s.optString(cVar.a);
                }
            }
            if (jSONObject2.has("IsRemoteSorted")) {
                cVar.d = Boolean.valueOf(jSONObject2.optBoolean("IsRemoteSorted"));
            }
        } else {
            com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "null nodeOptimizerInfos:" + str);
        }
        if (TextUtils.isEmpty(cVar.a) || this.d.b != 1 || (!this.g.equals("quic") && !this.g.equals("quicu"))) {
            return null;
        }
        try {
            jSONObject.put("ip", cVar.a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return m(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, String str2, String str3, String str4) {
        if (this.b != null) {
            com.ss.videoarch.liveplayer.log.a.c("VLDNSParser", "3. callback: " + str3);
            v();
            this.b.a(str, str2, str3, str4, this.c);
        }
    }
}
