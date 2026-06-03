package com.dragon.read.kmp.widget.slidetab;

import androidx.compose.material.TabRowDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static Function3<List<f>, Composer, Integer, Unit> b;
    private static Function2<Composer, Integer, Unit> c;

    public final Function2<Composer, Integer, Unit> a() {
        return c;
    }

    public final Function3<List<f>, Composer, Integer, Unit> b() {
        return b;
    }

    static {
        Covode.recordClassIndex(609689);
        a = new a();
        b = t.c(-1307695095, false, b.a);
        c = t.c(-1139271487, false, C0083a.a);
    }

    /* renamed from: com.dragon.read.kmp.widget.slidetab.a$a, reason: collision with other inner class name */
    static final class C0083a implements Function2<Composer, Integer, Unit> {
        public static final C0083a a = new C0083a();

        C0083a() {
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
                    ComposerKt.traceEventStart(-1139271487, i, -1, "com.dragon.read.kmp.widget.slidetab.ComposableSingletons$SlideTabLayoutKt.lambda$-1139271487.<anonymous> (SlideTabLayout.kt:56)");
                }
                TabRowDefaults.a.c((Modifier) null, 0.0f, 0L, composer, TabRowDefaults.e << 9, 7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function3<List<? extends f>, Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends f> list, Composer composer, Integer num) {
            a(list, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(List<f> tabPositions, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1307695095, i, -1, "com.dragon.read.kmp.widget.slidetab.ComposableSingletons$SlideTabLayoutKt.lambda$-1307695095.<anonymous> (SlideTabLayout.kt:53)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
