package bl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import gk4.n0;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static Function4<androidx.compose.foundation.layout.r, n0, Composer, Integer, Unit> b;
    private static Function4<androidx.compose.foundation.layout.r, n0, Composer, Integer, Unit> c;

    public final Function4<androidx.compose.foundation.layout.r, n0, Composer, Integer, Unit> a() {
        return b;
    }

    public final Function4<androidx.compose.foundation.layout.r, n0, Composer, Integer, Unit> b() {
        return c;
    }

    static {
        Covode.recordClassIndex(608044);
        a = new b();
        b = androidx.compose.runtime.internal.t.c(207480813, false, a.a);
        c = androidx.compose.runtime.internal.t.c(74541019, false, C0008b.a);
    }

    static final class a implements Function4<androidx.compose.foundation.layout.r, n0, Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, n0 n0Var, Composer composer, Integer num) {
            a(rVar, n0Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r rVar, n0 it2, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(rVar, "<this>");
            Intrinsics.checkNotNullParameter(it2, "it");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(207480813, i, -1, "com.dragon.read.kmp.profile.container.ComposableSingletons$SeriesPostItem3ColumnKt.lambda$207480813.<anonymous> (SeriesPostItem3Column.kt:46)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* renamed from: bl4.b$b, reason: collision with other inner class name */
    static final class C0008b implements Function4<androidx.compose.foundation.layout.r, n0, Composer, Integer, Unit> {
        public static final C0008b a = new C0008b();

        C0008b() {
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, n0 n0Var, Composer composer, Integer num) {
            a(rVar, n0Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r rVar, n0 it2, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(rVar, "<this>");
            Intrinsics.checkNotNullParameter(it2, "it");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(74541019, i, -1, "com.dragon.read.kmp.profile.container.ComposableSingletons$SeriesPostItem3ColumnKt.lambda$74541019.<anonymous> (SeriesPostItem3Column.kt:47)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
