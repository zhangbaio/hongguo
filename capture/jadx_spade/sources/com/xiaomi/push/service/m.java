package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ff;
import com.xiaomi.push.gj;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class m {
    private static volatile m a;

    /* renamed from: a, reason: collision with other field name */
    private long f980a;

    /* renamed from: a, reason: collision with other field name */
    private final Context f981a;

    /* renamed from: a, reason: collision with other field name */
    private final SharedPreferences f982a;

    /* renamed from: b, reason: collision with other field name */
    private final boolean f988b;

    /* renamed from: c, reason: collision with other field name */
    private final boolean f989c;

    /* renamed from: a, reason: collision with other field name */
    private final AtomicInteger f984a = new AtomicInteger(0);

    /* renamed from: a, reason: collision with other field name */
    private String f983a = null;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f985a = false;

    /* renamed from: b, reason: collision with other field name */
    private String f986b = null;

    /* renamed from: b, reason: collision with other field name */
    private final AtomicInteger f987b = new AtomicInteger(0);
    private final AtomicInteger c = new AtomicInteger(0);

    /* renamed from: a, reason: collision with other field name */
    private int f979a = -1;
    private long b = -1;
    private final boolean d = m726g();

    static {
        Covode.recordClassIndex(655721);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m728a() {
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m730b() {
        return this.b;
    }

    public synchronized void a(com.xiaomi.push.au auVar) {
        if (m723d()) {
            String str = null;
            if (auVar != null) {
                if (auVar.a() == 0) {
                    String m160b = auVar.m160b();
                    if (!TextUtils.isEmpty(m160b) && !"UNKNOWN".equalsIgnoreCase(m160b)) {
                        str = "M-" + m160b;
                    }
                    b(str);
                    this.f979a = 0;
                } else {
                    if (auVar.a() != 1 && auVar.a() != 6) {
                        b(null);
                        this.f979a = -1;
                    }
                    b("WIFI-ID-UNKNOWN");
                    this.f979a = 1;
                }
            } else {
                b(null);
                this.f979a = -1;
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m729a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (m723d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    public void a(int i) {
        this.f982a.edit().putLong(a.j(), System.currentTimeMillis() + (i * 1000)).apply();
    }

    private long c() {
        return this.f982a.getLong(a.j(), -1L);
    }

    private int a() {
        if (TextUtils.isEmpty(this.f983a)) {
            return -1;
        }
        try {
            return this.f982a.getInt(a.a(this.f983a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private long d() {
        return ah.a(this.f981a).a(gj.ShortHeartbeatEffectivePeriodMsLong.a(), 7776000000L);
    }

    private void e() {
        if (!this.f982a.getBoolean(a.a(), false)) {
            this.f982a.edit().putBoolean(a.a(), true).apply();
        }
    }

    /* renamed from: f, reason: collision with other method in class */
    private boolean m725f() {
        if (this.f980a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f980a;
        if (j <= currentTimeMillis && currentTimeMillis - j < 259200000) {
            return false;
        }
        return true;
    }

    /* renamed from: g, reason: collision with other method in class */
    private boolean m726g() {
        return ah.a(this.f981a).a(gj.IntelligentHeartbeatForUnsupportWifiDigestBoolean.a(), true);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m732c() {
        if (m723d()) {
            this.f986b = this.f983a;
        }
    }

    private boolean b() {
        if (!TextUtils.isEmpty(this.f983a)) {
            if (this.f983a.startsWith("M-")) {
                if (!ah.a(this.f981a).a(gj.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) {
                    return true;
                }
            } else if (this.f983a.equals("W-NETWORK_ID_WIFI_DEFAULT") && !m726g()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m723d() {
        boolean z;
        if (c() >= System.currentTimeMillis()) {
            z = true;
        } else {
            z = false;
        }
        if (this.f989c && (this.f988b || this.d || z)) {
            return true;
        }
        return false;
    }

    /* renamed from: e, reason: collision with other method in class */
    private boolean m724e() {
        long j = this.f982a.getLong(a.c(), -1L);
        if (j == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j <= currentTimeMillis && currentTimeMillis - j < 259200000) {
            return false;
        }
        return true;
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m722c() {
        boolean a2 = ah.a(this.f981a).a(gj.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true);
        if (m723d() && a2 && com.xiaomi.push.m.China.name().equals(b.a(this.f981a).a())) {
            return true;
        }
        return false;
    }

    private void f() {
        String g;
        int i = this.f979a;
        if (i != 0) {
            if (i != 1) {
                g = null;
            } else {
                g = a.h();
            }
        } else {
            g = a.g();
        }
        if (!TextUtils.isEmpty(g)) {
            if (this.f982a.getLong(a.i(), -1L) == -1) {
                this.f980a = System.currentTimeMillis();
                this.f982a.edit().putLong(a.i(), this.f980a).apply();
            }
            this.f982a.edit().putInt(g, this.f982a.getInt(g, 0) + 1).apply();
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m731b() {
        if (m723d()) {
            f();
            if (this.f985a && !TextUtils.isEmpty(this.f983a) && this.f983a.equals(this.f986b)) {
                this.f984a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m54a("[HB] ping timeout count:" + this.f984a);
                if (m721a()) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("[HB] change hb interval for net:" + this.f983a);
                    c(this.f983a);
                    this.f985a = false;
                    this.f984a.getAndSet(0);
                    d(this.f983a);
                }
            }
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m733d() {
        if (m723d()) {
            g();
            if (this.f985a) {
                this.f984a.getAndSet(0);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m721a() {
        if (this.f984a.get() >= Math.max(ah.a(this.f981a).a(gj.IntelligentHeartbeatNATCountInt.a(), 3), 3)) {
            return true;
        }
        return false;
    }

    private void g() {
        int i;
        boolean z;
        String[] split;
        String[] split2;
        if (m722c()) {
            String string = this.f982a.getString(a.f(), null);
            char c = 1;
            char c2 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i2 = 0;
                while (i2 < split.length) {
                    if (!TextUtils.isEmpty(split[i2]) && (split2 = split[i2].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c2];
                        String str2 = split2[c];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", "change");
                        hashMap.put("model", Build.MODEL);
                        hashMap.put("net_type", str2);
                        hashMap.put("net_name", str);
                        hashMap.put("interval", str3);
                        hashMap.put("timestamp", str4);
                        a("category_hb_change", null, hashMap);
                        com.xiaomi.channel.commonutils.logger.b.m54a("[HB] report hb changed events.");
                    }
                    i2++;
                    c = 1;
                    c2 = 0;
                }
                this.f982a.edit().remove(a.f()).apply();
            }
            if (this.f982a.getBoolean(a.a(), false)) {
                long j = this.f982a.getLong(a.b(), 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j > 1296000000) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("event", "support");
                    hashMap2.put("model", Build.MODEL);
                    hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                    a("category_hb_change", null, hashMap2);
                    com.xiaomi.channel.commonutils.logger.b.m54a("[HB] report support wifi digest events.");
                    this.f982a.edit().putLong(a.b(), currentTimeMillis).apply();
                }
            }
            if (m724e()) {
                int i3 = this.f982a.getInt(a.d(), 0);
                int i4 = this.f982a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j2 = this.f982a.getLong(a.c(), -1L);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j2);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("interval", valueOf);
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put("count", String.valueOf(i3 + i4));
                        jSONObject.put("start_time", valueOf2);
                        jSONObject.put("end_time", valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        com.xiaomi.channel.commonutils.logger.b.m54a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f982a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m725f()) {
                String valueOf4 = String.valueOf(this.f980a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f982a.getInt(a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", "M");
                        jSONObject3.put("ptc", i5);
                        jSONObject3.put("start_time", valueOf4);
                        jSONObject3.put("end_time", valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        com.xiaomi.channel.commonutils.logger.b.m54a("[HB] report ping timeout count events of mobile network.");
                        this.f982a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f982a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i = 0;
                int i6 = this.f982a.getInt(a.h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("net_type", "W");
                        jSONObject5.put("ptc", i6);
                        jSONObject5.put("start_time", valueOf4);
                        jSONObject5.put("end_time", valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        com.xiaomi.channel.commonutils.logger.b.m54a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f982a.edit().putInt(a.h(), 0).apply();
                }
                this.f980a = System.currentTimeMillis();
                this.f982a.edit().putLong(a.i(), this.f980a).apply();
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m727a() {
        int a2;
        long b = ff.b();
        boolean z = true;
        if (this.f989c && !b() && ((ah.a(this.f981a).a(gj.IntelligentHeartbeatSwitchBoolean.a(), true) || c() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
            b = a2;
        }
        if (!TextUtils.isEmpty(this.f983a) && !"WIFI-ID-UNKNOWN".equals(this.f983a) && this.f979a == 1) {
            if (b >= 300000) {
                z = false;
            }
            a(z);
        }
        this.b = b;
        com.xiaomi.channel.commonutils.logger.b.m54a("[HB] ping interval:" + b);
        return b;
    }

    private static class a {
        static {
            Covode.recordClassIndex(655722);
        }

        public static String a() {
            return "support_wifi_digest";
        }

        public static String b() {
            return "record_support_wifi_digest_reported_time";
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }
    }

    public static m a(Context context) {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m(context);
                }
            }
        }
        return a;
    }

    private void c(String str) {
        if (!a(str)) {
            return;
        }
        this.f982a.edit().putInt(a.a(str), 235000).apply();
        this.f982a.edit().putLong(a.b(this.f983a), System.currentTimeMillis() + d()).apply();
    }

    private void a(boolean z) {
        AtomicInteger atomicInteger;
        Object obj;
        String e;
        if (!m722c()) {
            return;
        }
        if (z) {
            atomicInteger = this.f987b;
        } else {
            atomicInteger = this.c;
        }
        int incrementAndGet = atomicInteger.incrementAndGet();
        Object[] objArr = new Object[2];
        String str = "short";
        if (z) {
            obj = "short";
        } else {
            obj = "long";
        }
        objArr[0] = obj;
        objArr[1] = Integer.valueOf(incrementAndGet);
        com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", objArr));
        if (incrementAndGet >= 5) {
            if (z) {
                e = a.d();
            } else {
                e = a.e();
            }
            int i = this.f982a.getInt(e, 0) + incrementAndGet;
            this.f982a.edit().putInt(e, i).apply();
            Object[] objArr2 = new Object[2];
            if (!z) {
                str = "long";
            }
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(i);
            com.xiaomi.channel.commonutils.logger.b.m54a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
            if (z) {
                this.f987b.set(0);
            } else {
                this.c.set(0);
            }
        }
    }

    private m(Context context) {
        this.f981a = context;
        this.f989c = com.xiaomi.push.j.m631a(context);
        this.f988b = ah.a(context).a(gj.IntelligentHeartbeatSwitchBoolean.a(), true);
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.f982a = sharedPreferences;
        long currentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(a.c(), -1L) == -1) {
            sharedPreferences.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j = sharedPreferences.getLong(a.i(), -1L);
        this.f980a = j;
        if (j == -1) {
            this.f980a = currentTimeMillis;
            sharedPreferences.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    private void b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f983a;
            if (str2 == null || !str2.startsWith("W-")) {
                if (this.d) {
                    this.f983a = "W-NETWORK_ID_WIFI_DEFAULT";
                } else {
                    this.f983a = null;
                }
            }
        } else {
            this.f983a = str;
        }
        int i = this.f982a.getInt(a.a(this.f983a), -1);
        long j = this.f982a.getLong(a.b(this.f983a), -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (i != -1) {
            if (j == -1) {
                this.f982a.edit().putLong(a.b(this.f983a), currentTimeMillis + d()).apply();
            } else if (currentTimeMillis > j) {
                this.f982a.edit().remove(a.a(this.f983a)).remove(a.b(this.f983a)).apply();
            }
        }
        this.f984a.getAndSet(0);
        if (!TextUtils.isEmpty(this.f983a) && a() == -1) {
            this.f985a = true;
        } else {
            this.f985a = false;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a(String.format("[HB] network changed, netid:%s, %s", this.f983a, Boolean.valueOf(this.f985a)));
    }

    private void d(String str) {
        String str2;
        String str3;
        if (!m722c() || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("W-")) {
            str2 = "W";
        } else if (str.startsWith("M-")) {
            str2 = "M";
        } else {
            return;
        }
        String valueOf = String.valueOf(235000);
        String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":::");
        sb.append(str2);
        sb.append(":::");
        sb.append(valueOf);
        sb.append(":::");
        sb.append(valueOf2);
        String string = this.f982a.getString(a.f(), null);
        if (TextUtils.isEmpty(string)) {
            str3 = sb.toString();
        } else {
            str3 = string + "###" + sb.toString();
        }
        this.f982a.edit().putString(a.f(), str3).apply();
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("W-") && !str.startsWith("M-")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r3 = this;
            com.xiaomi.push.gi r0 = new com.xiaomi.push.gi
            r0.<init>()
            r0.d(r4)
            java.lang.String r4 = "hb_name"
            r0.c(r4)
            java.lang.String r4 = "hb_channel"
            r0.a(r4)
            r1 = 1
            r0.a(r1)
            r0.b(r5)
            r4 = 0
            r0.a(r4)
            long r1 = java.lang.System.currentTimeMillis()
            r0.b(r1)
            android.content.Context r5 = r3.f981a
            java.lang.String r5 = r5.getPackageName()
            r0.g(r5)
            java.lang.String r5 = "com.xiaomi.xmsf"
            r0.e(r5)
            if (r6 != 0) goto L3a
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
        L3a:
            android.content.Context r5 = r3.f981a
            com.xiaomi.push.service.p r5 = com.xiaomi.push.service.q.m745a(r5)
            if (r5 == 0) goto L58
            java.lang.String r1 = r5.f1002a
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L58
            java.lang.String r5 = r5.f1002a
            java.lang.String r1 = "@"
            java.lang.String[] r5 = r5.split(r1)
            int r1 = r5.length
            if (r1 <= 0) goto L58
            r4 = r5[r4]
            goto L59
        L58:
            r4 = 0
        L59:
            java.lang.String r5 = "uuid"
            r6.put(r5, r4)
            java.lang.String r4 = "model"
            java.lang.String r5 = android.os.Build.MODEL
            r6.put(r4, r5)
            android.content.Context r4 = r3.f981a
            java.lang.String r5 = r4.getPackageName()
            int r4 = com.xiaomi.push.g.a(r4, r5)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "avc"
            r6.put(r5, r4)
            r4 = 50906(0xc6da, float:7.1334E-41)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "pvc"
            r6.put(r5, r4)
            r4 = 48
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "cvc"
            r6.put(r5, r4)
            r0.a(r6)
            android.content.Context r4 = r3.f981a
            com.xiaomi.push.gc r4 = com.xiaomi.push.gc.a(r4)
            if (r4 == 0) goto La3
            android.content.Context r5 = r3.f981a
            java.lang.String r5 = r5.getPackageName()
            r4.a(r0, r5)
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.m.a(java.lang.String, java.lang.String, java.util.Map):void");
    }
}
