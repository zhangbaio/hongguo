package com.dragon.read.local.db;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ListUtils;
import com.dragon.read.util.NumberUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import lr4.r;
import nr4.k0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c implements f {
    private final String a;
    private final Function0<String> b;

    static {
        Covode.recordClassIndex(611517);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String n(String str) {
        return str;
    }

    private k0 l() {
        return DBManager.obtainCacheDao(this.b.invoke());
    }

    @Override // com.dragon.read.local.db.f
    public long b() {
        return l().b(this.a + "%");
    }

    @Override // com.dragon.read.local.db.f
    public void c() {
        l().a(this.a + '%');
    }

    public Map<String, String> f() {
        List<r> g = l().g(this.a + '%');
        if (g == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(g.size());
        for (r rVar : g) {
            hashMap.put(rVar.b.replaceFirst(this.a, ""), rVar.d);
        }
        return hashMap;
    }

    private String m(String str) {
        return this.a + str;
    }

    public void e(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            r[] rVarArr = new r[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                rVarArr[i] = new r(m(strArr[i]));
            }
            l().f(rVarArr);
        }
    }

    @Override // com.dragon.read.local.db.f
    public void a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            r[] rVarArr = new r[map.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                r rVar = new r(m(entry.getKey()));
                rVar.d = entry.getValue();
                rVar.c = System.currentTimeMillis();
                rVarArr[i] = rVar;
                i++;
            }
            l().d(rVarArr);
        }
    }

    public Map<String, String> k(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(m(it2.next()));
        }
        List<r> c = l().c((String[]) arrayList.toArray(new String[0]));
        if (ListUtils.isEmpty(c)) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (r rVar : c) {
            hashMap.put(rVar.b, rVar.d);
        }
        return hashMap;
    }

    public c(String str, Function0<String> function0) {
        this.a = str;
        this.b = function0;
    }

    public long i(String str, long j) {
        return (long) g(str, j);
    }

    public c(String str, final String str2) {
        this.a = str;
        this.b = new Function0() { // from class: com.dragon.read.local.db.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String n;
                n = c.n(str2);
                return n;
            }
        };
    }

    public double g(String str, double d) {
        String j = j(str, null);
        if (j == null) {
            return d;
        }
        return NumberUtils.parse(j, d);
    }

    public String j(String str, String str2) {
        r e = l().e(m(str));
        if (e == null) {
            return str2;
        }
        return e.d;
    }

    public Map<String, Double> h(List<String> list, double d) {
        Map<String, String> k = k(list);
        HashMap hashMap = new HashMap();
        if (k != null && !k.isEmpty()) {
            for (Map.Entry<String, String> entry : k.entrySet()) {
                hashMap.put(entry.getKey(), Double.valueOf(NumberUtils.parse(entry.getValue(), d)));
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }
}
