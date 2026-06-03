package vp4;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a {
    public static final int f;
    private final String a;
    private final b b;
    public final String c;
    public long d;
    private long e;

    static {
        Covode.recordClassIndex(609375);
        f = 8;
    }

    public Map<String, Object> d() {
        Map<String, Object> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    public final void e() {
        this.d = Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final void c() {
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        this.e = epochMilliseconds;
        a(this.a, Long.valueOf(epochMilliseconds - this.d));
        b(d());
    }

    public final a b(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.b.b(map);
        return this;
    }

    public a(String spanName, b trace) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.a = spanName;
        this.b = trace;
        this.c = String.valueOf(bq4.a.a.b());
    }

    public final a a(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.b.a(key, value);
        return this;
    }
}
