package wm4;

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
    private static Function3<MutableState<fe4.n>, Composer, Integer, Unit> c;

    public final Function3<MutableState<fe4.n>, Composer, Integer, Unit> a() {
        return c;
    }

    public final Function2<Composer, Integer, Unit> b() {
        return b;
    }

    /* renamed from: wm4.a$a, reason: collision with other inner class name */
    static final class C0286a implements Function3<MutableState<fe4.n>, Composer, Integer, Unit> {
        public static final C0286a a = new C0286a();

        C0286a() {
        }

        /* renamed from: wm4.a$a$a, reason: collision with other inner class name */
        public static final class C0287a implements gk4.f {
            C0287a() {
            }

            @Override // gk4.f
            public long a() {
                return System.currentTimeMillis();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(MutableState<fe4.n> mutableState, Composer composer, Integer num) {
            a(mutableState, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(MutableState<fe4.n> it2, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(it2, "it");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1165051675, i, -1, "com.dragon.read.kmp.relatedwrok.ComposableSingletons$RelatedWork2ColHolderKt.lambda$-1165051675.<anonymous> (RelatedWork2ColHolder.kt:38)");
                }
                ym4.f.c("RelatedWork2ColHolder", new C0287a(), a.a.b(), composer, 390);
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
        Covode.recordClassIndex(608668);
        a = new a();
        b = androidx.compose.runtime.internal.t.c(-1809667760, false, b.a);
        c = androidx.compose.runtime.internal.t.c(-1165051675, false, C0286a.a);
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
                    ComposerKt.traceEventStart(-1809667760, i, -1, "com.dragon.read.kmp.relatedwrok.ComposableSingletons$RelatedWork2ColHolderKt.lambda$-1809667760.<anonymous> (RelatedWork2ColHolder.kt:42)");
                }
                n.m(composer, 0);
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
