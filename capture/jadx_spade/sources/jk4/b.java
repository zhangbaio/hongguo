package jk4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function3<MutableState<f1>, Composer, Integer, Unit> c;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    public final Function3<MutableState<f1>, Composer, Integer, Unit> b() {
        return c;
    }

    /* renamed from: jk4.b$b, reason: collision with other inner class name */
    static final class C0198b implements Function3<MutableState<f1>, Composer, Integer, Unit> {
        public static final C0198b a = new C0198b();

        C0198b() {
        }

        /* renamed from: jk4.b$b$a */
        public static final class a implements gk4.f {
            a() {
            }

            @Override // gk4.f
            public long a() {
                return System.currentTimeMillis();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(MutableState<f1> mutableState, Composer composer, Integer num) {
            a(mutableState, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(MutableState<f1> it2, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(it2, "it");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-28146444, i, -1, "com.dragon.read.kmp.nps.ComposableSingletons$StaggeredSimilarSeriesDetailNpsHolderKt.lambda$-28146444.<anonymous> (StaggeredSimilarSeriesDetailNpsHolder.kt:64)");
                }
                ym4.f.c("StaggeredSimilarNpsHolder", new a(), b.a.a(), composer, 390);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static {
        Covode.recordClassIndex(607867);
        a = new b();
        b = androidx.compose.runtime.internal.t.c(-1756978081, false, a.a);
        c = androidx.compose.runtime.internal.t.c(-28146444, false, C0198b.a);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1756978081, i, -1, "com.dragon.read.kmp.nps.ComposableSingletons$StaggeredSimilarSeriesDetailNpsHolderKt.lambda$-1756978081.<anonymous> (StaggeredSimilarSeriesDetailNpsHolder.kt:68)");
                }
                e1.j(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }
}
