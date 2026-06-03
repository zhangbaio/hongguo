package ym4;

import com.bytedance.covode.number.Covode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;

@Serializable(with = b.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final C0301a Companion;
    public static final int b;
    private static final a c;
    public final Map<String, Object> a;

    /* renamed from: ym4.a$a, reason: collision with other inner class name */
    public static final class C0301a {
        static {
            Covode.recordClassIndex(608680);
        }

        private C0301a() {
        }

        public /* synthetic */ C0301a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<a> serializer() {
            return b.a;
        }

        public final a a() {
            return a.c;
        }
    }

    public final void b() {
        this.a.clear();
    }

    public a() {
        this.a = new LinkedHashMap();
    }

    static {
        Covode.recordClassIndex(608679);
        Companion = new C0301a(null);
        b = 8;
        c = new a();
    }

    public final Map<String, String> f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : this.a.keySet()) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            String str2 = str;
            linkedHashMap.put(str2, String.valueOf(this.a.get(str2)));
        }
        return linkedHashMap;
    }

    public final boolean c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.containsKey(key);
    }

    public final Object d(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.get(key);
    }

    public final a j(a aVar) {
        if (aVar != null) {
            this.a.putAll(aVar.a);
        }
        return this;
    }

    public final a h(Map<String, ? extends Object> map) {
        if (map == null) {
            return this;
        }
        if (!map.isEmpty()) {
            this.a.putAll(map);
        }
        return this;
    }

    public final a k(String key) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        if (key.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.a.remove(key);
        }
        return this;
    }

    public a(Map<String, ? extends Object> m) {
        Intrinsics.checkNotNullParameter(m, "m");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = linkedHashMap;
        linkedHashMap.putAll(m);
    }

    public final a i(JsonElement jsonElement) {
        Map<? extends String, ? extends Object> map;
        if (jsonElement == null) {
            return this;
        }
        try {
            map = MapsKt__MapsKt.toMap((Map) JsonElementKt.getJsonObject(jsonElement));
            this.a.putAll(map);
        } catch (Exception e) {
            System.out.println((Object) ("JSON 语法错误: " + e.getMessage()));
        }
        return this;
    }

    public a(Pair<String, ? extends Object>... pairs) {
        Map map;
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = linkedHashMap;
        map = MapsKt__MapsKt.toMap(pairs);
        linkedHashMap.putAll(map);
    }

    public a(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = new LinkedHashMap();
        g(key, value);
    }

    public final String e(String key, String defaultValue) {
        String obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Object obj2 = this.a.get(key);
        if (obj2 != null && (obj = obj2.toString()) != null) {
            return obj;
        }
        return defaultValue;
    }

    public final a g(String key, Object obj) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj == null) {
            return this;
        }
        if (key.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.a.put(key, obj);
        }
        return this;
    }
}
