package com.dragon.read.kmp.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i0 {
    public static final i0 a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function5<Integer, String, Function0<Unit>, Composer, Integer, Unit> c;
    private static Function5<Integer, String, Function0<Unit>, Composer, Integer, Unit> d;

    public final Function5<Integer, String, Function0<Unit>, Composer, Integer, Unit> a() {
        return c;
    }

    public final Function5<Integer, String, Function0<Unit>, Composer, Integer, Unit> b() {
        return d;
    }

    public final Function2<Composer, Integer, Unit> c() {
        return b;
    }

    static {
        Covode.recordClassIndex(609646);
        a = new i0();
        b = androidx.compose.runtime.internal.t.c(188538950, false, c.a);
        c = androidx.compose.runtime.internal.t.c(-139452529, false, a.a);
        d = androidx.compose.runtime.internal.t.c(-1673707148, false, b.a);
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        public static final c a = new c();

        c() {
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
                    ComposerKt.traceEventStart(188538950, i, -1, "com.dragon.read.kmp.widget.ComposableSingletons$CommonLayoutKt.lambda$188538950.<anonymous> (CommonLayout.kt:37)");
                }
                t0.c(null, null, 0, null, null, composer, 0, 31);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class a implements Function5<Integer, String, Function0<? extends Unit>, Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Function0<? extends Unit> function0, Composer composer, Integer num2) {
            a(num.intValue(), str, function0, composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(int i, String msg, Function0<Unit> retry, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            int i6;
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(retry, "retry");
            if ((i2 & 6) == 0) {
                if (composer.changed(i)) {
                    i6 = 4;
                } else {
                    i6 = 2;
                }
                i3 = i6 | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(msg)) {
                    i5 = 32;
                } else {
                    i5 = 16;
                }
                i3 |= i5;
            }
            if ((i2 & 384) == 0) {
                if (composer.changedInstance(retry)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-139452529, i3, -1, "com.dragon.read.kmp.widget.ComposableSingletons$CommonLayoutKt.lambda$-139452529.<anonymous> (CommonLayout.kt:39)");
                }
                CommonLayoutKt.l(i, msg, retry, composer, (i3 & 14) | (i3 & 112) | (i3 & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function5<Integer, String, Function0<? extends Unit>, Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Function0<? extends Unit> function0, Composer composer, Integer num2) {
            a(num.intValue(), str, function0, composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(int i, String msg, Function0<Unit> retry, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            int i6;
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(retry, "retry");
            if ((i2 & 6) == 0) {
                if (composer.changed(i)) {
                    i6 = 4;
                } else {
                    i6 = 2;
                }
                i3 = i6 | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(msg)) {
                    i5 = 32;
                } else {
                    i5 = 16;
                }
                i3 |= i5;
            }
            if ((i2 & 384) == 0) {
                if (composer.changedInstance(retry)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1673707148, i3, -1, "com.dragon.read.kmp.widget.ComposableSingletons$CommonLayoutKt.lambda$-1673707148.<anonymous> (CommonLayout.kt:41)");
                }
                CommonLayoutKt.p(i, msg, retry, composer, (i3 & 14) | (i3 & 112) | (i3 & 896), 0);
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
