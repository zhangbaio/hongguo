package qk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.performance.PerformancePeriod;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static final ge4.a<String, b> b;
    public static final int c;

    private a() {
    }

    static {
        Covode.recordClassIndex(607916);
        a = new a();
        b = new ge4.a<>(100);
        c = 8;
    }

    public final void a(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        b(scene, PerformancePeriod.LAUNCH_PERIOD);
    }

    public final void d(String scene, long j) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        e(scene, PerformancePeriod.LAUNCH_PERIOD, j, true);
    }

    public final void c(String scene, PerformancePeriod period) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(period, "period");
        b bVar = (b) b.get(scene);
        if (bVar != null) {
            bVar.b(period.getPeriod());
        }
    }

    public final void b(String scene, PerformancePeriod period) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(period, "period");
        ge4.a<String, b> aVar = b;
        b bVar = (b) aVar.get(scene);
        if (bVar != null) {
            bVar.a(period.getPeriod());
            if (period == PerformancePeriod.LAUNCH_PERIOD) {
                bVar.c();
                aVar.remove(scene);
            }
            j.a.a("KmpNativeTimeTracer", scene + " end " + period.getPeriod());
        }
    }

    public final void e(String scene, PerformancePeriod period, long j, boolean z) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(period, "period");
        ge4.a<String, b> aVar = b;
        b bVar = (b) aVar.get(scene);
        if (bVar == null && period == PerformancePeriod.LAUNCH_PERIOD) {
            bVar = new b(scene, z);
            aVar.put(scene, bVar);
        }
        if (bVar != null) {
            bVar.d(period.getPeriod(), j);
            j.a.a("KmpNativeTimeTracer", scene + " start " + period.getPeriod());
        }
    }
}
