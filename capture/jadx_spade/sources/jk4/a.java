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
public final class a {
    public static final a a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function3<MutableState<f1>, Composer, Integer, Unit> c;

    public final Function3<MutableState<f1>, Composer, Integer, Unit> a() {
        return c;
    }

    public final Function2<Composer, Integer, Unit> b() {
        return b;
    }

    /* renamed from: jk4.a$a, reason: collision with other inner class name */
    static final class C0196a implements Function3<MutableState<f1>, Composer, Integer, Unit> {
        public static final C0196a a = new C0196a();

        C0196a() {
        }

        /* renamed from: jk4.a$a$a, reason: collision with other inner class name */
        public static final class C0197a implements gk4.f {
            C0197a() {
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
                    ComposerKt.traceEventStart(-1740141452, i, -1, "com.dragon.read.kmp.nps.ComposableSingletons$StaggeredSimilarNpsHolderKt.lambda$-1740141452.<anonymous> (StaggeredSimilarNpsHolder.kt:28)");
                }
                ym4.f.c("StaggeredSimilarNpsHolder", new C0197a(), a.a.b(), composer, 390);
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
        Covode.recordClassIndex(607866);
        a = new a();
        b = androidx.compose.runtime.internal.t.c(1910209759, false, b.a);
        c = androidx.compose.runtime.internal.t.c(-1740141452, false, C0196a.a);
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
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
                    ComposerKt.traceEventStart(1910209759, i, -1, "com.dragon.read.kmp.nps.ComposableSingletons$StaggeredSimilarNpsHolderKt.lambda$1910209759.<anonymous> (StaggeredSimilarNpsHolder.kt:32)");
                }
                e1.n(composer, 0);
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
