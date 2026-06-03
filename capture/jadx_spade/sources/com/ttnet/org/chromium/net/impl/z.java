package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z extends h0 {
    private final List<String> a;
    private final int b;
    private final String c;
    private final boolean d;
    private final String e;
    private final String f;
    private final AtomicLong g;
    private final a h;

    static {
        Covode.recordClassIndex(654666);
    }

    public static final class a extends h0.a {
        private final List<Map.Entry<String, String>> a;
        private Map<String, List<String>> b;

        static {
            Covode.recordClassIndex(654667);
        }

        public List<Map.Entry<String, String>> a() {
            return this.a;
        }

        public Map<String, List<String>> b() {
            Map<String, List<String>> map = this.b;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, String> entry : this.a) {
                ArrayList arrayList = new ArrayList();
                if (treeMap.containsKey(entry.getKey())) {
                    arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                }
                arrayList.add(entry.getValue());
                treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
            }
            Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
            this.b = unmodifiableMap;
            return unmodifiableMap;
        }

        a(List<Map.Entry<String, String>> list) {
            this.a = list;
        }
    }

    @Override // com.ttnet.org.chromium.net.h0
    public int c() {
        return this.b;
    }

    @Override // com.ttnet.org.chromium.net.h0
    public String d() {
        return this.c;
    }

    @Override // com.ttnet.org.chromium.net.h0
    public List<String> f() {
        return this.a;
    }

    public String g() {
        return this.e;
    }

    public String h() {
        return this.f;
    }

    public boolean k() {
        return this.d;
    }

    @Override // com.ttnet.org.chromium.net.h0
    public Map<String, List<String>> a() {
        return this.h.b();
    }

    @Override // com.ttnet.org.chromium.net.h0
    public List<Map.Entry<String, String>> b() {
        return this.h.a();
    }

    @Override // com.ttnet.org.chromium.net.h0
    public long e() {
        return this.g.get();
    }

    public String i() {
        return this.a.get(r0.size() - 1);
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", Integer.toHexString(System.identityHashCode(this)), i(), f().toString(), Integer.valueOf(c()), d(), b().toString(), Boolean.valueOf(k()), g(), h(), Long.valueOf(e()));
    }

    public void j(long j) {
        this.g.set(j);
    }

    public z(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3, long j) {
        this.a = Collections.unmodifiableList(list);
        this.b = i;
        this.c = str;
        this.h = new a(Collections.unmodifiableList(list2));
        this.d = z;
        this.e = str2;
        this.f = str3;
        this.g = new AtomicLong(j);
    }
}
