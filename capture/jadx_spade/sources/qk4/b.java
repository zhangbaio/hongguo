package qk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.performance.utils.d;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.performance.PerformancePeriod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int e;
    private String a;
    private boolean b;
    private final Map<String, Long> c;
    private final Map<String, Long> d;

    static {
        Covode.recordClassIndex(607918);
        e = 8;
    }

    public final void c() {
        ym4.a aVar = new ym4.a();
        aVar.g("scene", this.a);
        aVar.g("is_full_kmp_page", Boolean.valueOf(this.b));
        for (Map.Entry<String, Long> entry : this.c.entrySet()) {
            aVar.g(entry.getKey(), Long.valueOf(entry.getValue().longValue()));
        }
        o.a.d("kmp_native_page_duration", aVar);
    }

    public final void b(String method) {
        long j;
        Intrinsics.checkNotNullParameter(method, "method");
        Long l = this.d.get(PerformancePeriod.LAUNCH_PERIOD.getPeriod() + "_start");
        if (l != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        if (j == 0) {
            this.c.put(method, 0L);
        } else {
            this.c.put(method, Long.valueOf(d.a() - j));
        }
    }

    public final void a(String method) {
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(method, "method");
        Long l = this.d.get(method + "_end");
        if (l != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        if (j > 0) {
            j.c(j.a, "KmpNativeTimeTracer", "error - " + method + "_end 已经存在了，检查是否是有重复调用", (Throwable) null, 4, (Object) null);
            return;
        }
        long a = d.a();
        Long valueOf = Long.valueOf(a);
        this.d.put(method + "_end", valueOf);
        Long l2 = this.d.get(method + "_start");
        if (l2 != null) {
            j2 = l2.longValue();
        } else {
            j2 = 0;
        }
        if (j2 == 0) {
            this.c.put(method, 0L);
        } else {
            this.c.put(method, Long.valueOf(a - j2));
        }
    }

    public b(String scene, boolean z) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.b = true;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.a = scene;
        this.b = z;
    }

    public final void d(String method, long j) {
        long j2;
        Intrinsics.checkNotNullParameter(method, "method");
        Long l = this.d.get(method + "_start");
        if (l != null) {
            j2 = l.longValue();
        } else {
            j2 = 0;
        }
        if (j2 > 0) {
            return;
        }
        if (j > 0) {
            Long valueOf = Long.valueOf(j);
            this.d.put(method + "_start", valueOf);
            return;
        }
        this.d.put(method + "_start", Long.valueOf(d.a()));
    }
}
