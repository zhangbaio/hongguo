package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cb {

    /* renamed from: a, reason: collision with other field name */
    private long f180a;

    /* renamed from: a, reason: collision with other field name */
    public String f181a;

    /* renamed from: b, reason: collision with other field name */
    public String f183b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private String i;

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<ci> f182a = new ArrayList<>();
    private double a = 0.1d;
    private String j = "s.mi1.cc";
    private long b = 86400000;

    static {
        Covode.recordClassIndex(655404);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m225a() {
        return TextUtils.equals(this.f181a, cf.m231a());
    }

    public boolean a(cb cbVar) {
        return TextUtils.equals(this.f181a, cbVar.f181a);
    }

    public void a(String str, long j, long j2) {
        try {
            b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j, long j2, Exception exc) {
        try {
            b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new ca(i, j, j2, exc));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r1.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(java.lang.String r4, com.xiaomi.push.ca r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList<com.xiaomi.push.ci> r0 = r3.f182a     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L20
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L20
            com.xiaomi.push.ci r1 = (com.xiaomi.push.ci) r1     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r1.f199a     // Catch: java.lang.Throwable -> L20
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L7
            r1.a(r5)     // Catch: java.lang.Throwable -> L20
        L1e:
            monitor-exit(r3)
            return
        L20:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cb.a(java.lang.String, com.xiaomi.push.ca):void");
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m224a(String str) {
        a(new ci(str));
    }

    public synchronized void a(String[] strArr) {
        int i;
        int size = this.f182a.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f182a.get(size).f199a, strArr[i])) {
                        this.f182a.remove(size);
                        break;
                    }
                    i++;
                }
            }
            size--;
        }
        Iterator<ci> it2 = this.f182a.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            int i3 = it2.next().a;
            if (i3 > i2) {
                i2 = i3;
            }
        }
        while (i < strArr.length) {
            a(new ci(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<String> m222a() {
        return a(false);
    }

    public boolean b() {
        if (System.currentTimeMillis() - this.f180a < this.b) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f181a);
        sb.append("\n");
        sb.append(a());
        Iterator<ci> it2 = this.f182a.iterator();
        while (it2.hasNext()) {
            ci next = it2.next();
            sb.append("\n");
            sb.append(next.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    boolean c() {
        long j = this.b;
        if (864000000 >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f180a;
        if (currentTimeMillis - j2 <= j && (currentTimeMillis - j2 <= this.b || !this.f181a.startsWith("WIFI-"))) {
            return false;
        }
        return true;
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        }
        if (TextUtils.isEmpty(this.e)) {
            return "hardcode_isp";
        }
        String a = ba.a(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
        this.i = a;
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m223a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f181a);
        jSONObject.put("ttl", this.b);
        jSONObject.put("pct", this.a);
        jSONObject.put("ts", this.f180a);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put("ip", this.f);
        jSONObject.put("host", this.f183b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<ci> it2 = this.f182a.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d) {
        this.a = d;
    }

    public void b(String str) {
        this.j = str;
    }

    public void a(long j) {
        if (j > 0) {
            this.b = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j);
    }

    private synchronized void c(String str) {
        Iterator<ci> it2 = this.f182a.iterator();
        while (it2.hasNext()) {
            if (TextUtils.equals(it2.next().f199a, str)) {
                it2.remove();
            }
        }
    }

    synchronized void a(ci ciVar) {
        c(ciVar.f199a);
        this.f182a.add(ciVar);
    }

    public cb(String str) {
        this.f181a = "";
        if (!TextUtils.isEmpty(str)) {
            this.f180a = System.currentTimeMillis();
            this.f182a.add(new ci(str, -1));
            this.f181a = cf.m231a();
            this.f183b = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    public synchronized cb a(JSONObject jSONObject) {
        this.f181a = jSONObject.optString("net");
        this.b = jSONObject.getLong("ttl");
        this.a = jSONObject.getDouble("pct");
        this.f180a = jSONObject.getLong("ts");
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString("ip");
        this.f183b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new ci().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public ArrayList<String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f183b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it2 = a(true).iterator();
                while (it2.hasNext()) {
                    cd a = cd.a(it2.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a.m230a(), a.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        int size = this.f182a.size();
        ci[] ciVarArr = new ci[size];
        this.f182a.toArray(ciVarArr);
        Arrays.sort(ciVarArr);
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ci ciVar = ciVarArr[i];
            if (z) {
                arrayList.add(ciVar.f199a);
            } else {
                int indexOf = ciVar.f199a.indexOf(":");
                if (indexOf != -1) {
                    arrayList.add(ciVar.f199a.substring(0, indexOf));
                } else {
                    arrayList.add(ciVar.f199a);
                }
            }
        }
        return arrayList;
    }

    public void b(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void b(String str, long j, long j2, Exception exc) {
        a(str, -1, j, j2, exc);
    }
}
