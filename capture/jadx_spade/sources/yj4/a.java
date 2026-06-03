package yj4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function2<Composer, Integer, Unit> c;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    public final Function2<Composer, Integer, Unit> b() {
        return c;
    }

    static {
        Covode.recordClassIndex(607716);
        a = new a();
        b = androidx.compose.runtime.internal.t.c(-1153459352, false, C0299a.a);
        c = androidx.compose.runtime.internal.t.c(636012254, false, b.a);
    }

    /* renamed from: yj4.a$a, reason: collision with other inner class name */
    static final class C0299a implements Function2<Composer, Integer, Unit> {
        public static final C0299a a = new C0299a();

        C0299a() {
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
                    ComposerKt.traceEventStart(-1153459352, i, -1, "com.dragon.read.kmp.mine.preference.ComposableSingletons$WatchPreferencePageKt.lambda$-1153459352.<anonymous> (WatchPreferencePage.kt:116)");
                }
                w.Z(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
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
            float f;
            float f2;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(636012254, i, -1, "com.dragon.read.kmp.mine.preference.ComposableSingletons$WatchPreferencePageKt.lambda$636012254.<anonymous> (WatchPreferencePage.kt:141)");
                }
                f = w.b;
                f2 = w.a;
                com.dragon.read.kmp.mine.preference.widget.i.b(x0.i.g(f + f2), composer, 6);
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
