package vp4;

import com.bytedance.covode.number.Covode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int i;
    public long d;
    private long e;
    private boolean g;
    public final tp4.b a = new tp4.b("Trace-BaseTrace");
    public final String b = String.valueOf(bq4.a.a.b());
    private final Map<String, a> c = new LinkedHashMap();
    private xm6.a f = xm6.b.a(false);
    public Map<String, Object> h = new LinkedHashMap();

    static {
        Covode.recordClassIndex(609376);
        i = 8;
    }

    public final long e() {
        return this.e - this.d;
    }

    public final void g() {
        if (this.f.c()) {
            return;
        }
        this.f.d(true);
        this.d = Clock.System.INSTANCE.now().toEpochMilliseconds();
        this.a.d("init_interval, " + this.d);
    }

    public final void b(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.h.putAll(map);
    }

    public final void c(String spanName) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        if (!this.f.c()) {
            tp4.b.f(this.a, spanName + " is end after Trace finish or Trace not begin", null, 2, null);
            return;
        }
        a remove = this.c.remove(spanName);
        if (remove != null) {
            remove.c();
        }
    }

    public final void d(Function0<Unit> reportEvent) {
        Intrinsics.checkNotNullParameter(reportEvent, "reportEvent");
        if (!this.f.c()) {
            return;
        }
        this.e = Clock.System.INSTANCE.now().toEpochMilliseconds();
        this.g = true;
        reportEvent.invoke();
        this.a.d("end_interval, " + this.e);
    }

    public final void f(String spanName) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        if (!this.f.c()) {
            tp4.b.f(this.a, spanName + " is start after Trace finish or before Trace begin", null, 2, null);
            return;
        }
        a aVar = new a(spanName, this);
        this.c.put(spanName, aVar);
        aVar.e();
    }

    public final void a(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.h.put(key, value);
    }
}
