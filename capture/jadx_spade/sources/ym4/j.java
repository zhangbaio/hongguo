package ym4;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public static final int b;
    private final HashMap<String, Object> a = new HashMap<>();

    static {
        Covode.recordClassIndex(608689);
        b = 8;
    }

    public final Map<String, Object> c() {
        return this.a;
    }

    private final void b(Map<String, ? extends Object> map) {
        this.a.putAll(map);
    }

    public final j e(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        b(map);
        return this;
    }

    private final void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    public final j d(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        a(key, value);
        return this;
    }
}
