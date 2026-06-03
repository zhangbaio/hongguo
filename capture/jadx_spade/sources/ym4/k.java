package ym4;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class k {
    public static final int f;
    public final String a;
    public final String b;
    public final String c;
    public k d;
    private final HashMap<String, Object> e;

    static {
        Covode.recordClassIndex(608690);
        f = 8;
    }

    public k() {
        this(null, null, null, null, 15, null);
    }

    public final Map<String, Object> i() {
        return this.e;
    }

    public final a n() {
        a aVar = new a();
        aVar.h(this.e);
        return aVar;
    }

    public final Map<String, String> j() {
        HashMap hashMap = new HashMap();
        for (String str : this.e.keySet()) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            String str2 = str;
            hashMap.put(str2, String.valueOf(this.e.get(str2)));
        }
        return hashMap;
    }

    public final Map<String, String> k() {
        HashMap hashMap = new HashMap();
        for (String str : this.e.keySet()) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            String str2 = str;
            hashMap.put(str2, String.valueOf(this.e.get(str2)));
        }
        return hashMap;
    }

    public String toString() {
        return "PageRecorder{page='" + this.a + "', module='" + this.b + "', object='" + this.c + "', extraInfo=" + this.e + ", parentRecorder=" + this.d + '}';
    }

    public final void b(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.e.putAll(map);
    }

    public final k f(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        b(map);
        return this;
    }

    public final k h(j map) {
        Intrinsics.checkNotNullParameter(map, "map");
        b(map.c());
        return this;
    }

    public final Object l(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.e.get(key);
    }

    public final k m(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.e.remove(key);
        return this;
    }

    public final k g(a aVar) {
        if (aVar != null) {
            Map<String, Object> map = aVar.a;
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (obj != null) {
                    this.e.put(str, obj);
                }
            }
        }
        return this;
    }

    private final void a(String str, Object obj) {
        this.e.put(str, obj);
    }

    public final k c(String key, Number obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(obj, "obj");
        a(key, obj);
        return this;
    }

    public final k d(String key, String obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(obj, "obj");
        a(key, obj);
        return this;
    }

    public final k e(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        a(key, Boolean.valueOf(z));
        return this;
    }

    public k(String str, String str2, String str3, k kVar) {
        String str4;
        String str5;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = kVar;
        HashMap<String, Object> hashMap = new HashMap<>(4);
        this.e = hashMap;
        if (this.d != null) {
            k kVar2 = this.d;
            if (kVar2 != null) {
                str4 = kVar2.a;
            } else {
                str4 = null;
            }
            if (kVar2 != null) {
                str5 = kVar2.b;
            } else {
                str5 = null;
            }
            c cVar = new c(str4, str5, kVar2 != null ? kVar2.c : null);
            this.d = cVar;
            Intrinsics.checkNotNull(cVar);
            hashMap.putAll(cVar.i());
        }
    }

    public /* synthetic */ k(String str, String str2, String str3, k kVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : kVar);
    }
}
