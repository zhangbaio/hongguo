package bl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    private static Function4<androidx.compose.foundation.layout.r, bl4.a, Composer, Integer, Unit> b;
    private static Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> c;

    public final Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> a() {
        return c;
    }

    public final Function4<androidx.compose.foundation.layout.r, bl4.a, Composer, Integer, Unit> b() {
        return b;
    }

    static {
        Covode.recordClassIndex(608045);
        a = new c();
        b = androidx.compose.runtime.internal.t.c(569200752, false, b.a);
        c = androidx.compose.runtime.internal.t.c(219671739, false, a.a);
    }

    static final class a implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r rVar, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(rVar, "<this>");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219671739, i, -1, "com.dragon.read.kmp.profile.container.ComposableSingletons$VideoListItem3ColumnKt.lambda$219671739.<anonymous> (VideoListItem3Column.kt:50)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function4<androidx.compose.foundation.layout.r, bl4.a, Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, bl4.a aVar, Composer composer, Integer num) {
            a(rVar, aVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r rVar, bl4.a it2, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(rVar, "<this>");
            Intrinsics.checkNotNullParameter(it2, "it");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(569200752, i, -1, "com.dragon.read.kmp.profile.container.ComposableSingletons$VideoListItem3ColumnKt.lambda$569200752.<anonymous> (VideoListItem3Column.kt:49)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
