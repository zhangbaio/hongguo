package com.dragon.read.kmp.widget.expandableText;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static Function5<androidx.compose.ui.text.e, g3, Integer, Composer, Integer, Unit> b;
    private static Function5<androidx.compose.ui.text.e, g3, Integer, Composer, Integer, Unit> c;

    public final Function5<androidx.compose.ui.text.e, g3, Integer, Composer, Integer, Unit> a() {
        return c;
    }

    public final Function5<androidx.compose.ui.text.e, g3, Integer, Composer, Integer, Unit> b() {
        return b;
    }

    static {
        Covode.recordClassIndex(609676);
        a = new a();
        b = t.c(1527377081, false, b.a);
        c = t.c(-1872574277, false, C0082a.a);
    }

    /* renamed from: com.dragon.read.kmp.widget.expandableText.a$a, reason: collision with other inner class name */
    static final class C0082a implements Function5<androidx.compose.ui.text.e, g3, Integer, Composer, Integer, Unit> {
        public static final C0082a a = new C0082a();

        C0082a() {
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.text.e eVar, g3 g3Var, Integer num, Composer composer, Integer num2) {
            a(eVar, g3Var, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.ui.text.e text, g3 style, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            int i6;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(style, "style");
            if ((i2 & 6) == 0) {
                if (composer.changed(text)) {
                    i6 = 4;
                } else {
                    i6 = 2;
                }
                i3 = i6 | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(style)) {
                    i5 = 32;
                } else {
                    i5 = 16;
                }
                i3 |= i5;
            }
            if ((i2 & 384) == 0) {
                if (composer.changed(i)) {
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
                    ComposerKt.traceEventStart(-1872574277, i3, -1, "com.dragon.read.kmp.widget.expandableText.ComposableSingletons$ExtandableTextKt.lambda$-1872574277.<anonymous> (ExtandableText.kt:99)");
                }
                ExtandableTextKt.h(text, style, i, composer, (i3 & 14) | (i3 & 112) | (i3 & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function5<androidx.compose.ui.text.e, g3, Integer, Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.text.e eVar, g3 g3Var, Integer num, Composer composer, Integer num2) {
            a(eVar, g3Var, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.ui.text.e text, g3 style, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            int i6;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(style, "style");
            if ((i2 & 6) == 0) {
                if (composer.changed(text)) {
                    i6 = 4;
                } else {
                    i6 = 2;
                }
                i3 = i6 | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(style)) {
                    i5 = 32;
                } else {
                    i5 = 16;
                }
                i3 |= i5;
            }
            if ((i2 & 384) == 0) {
                if (composer.changed(i)) {
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
                    ComposerKt.traceEventStart(1527377081, i3, -1, "com.dragon.read.kmp.widget.expandableText.ComposableSingletons$ExtandableTextKt.lambda$1527377081.<anonymous> (ExtandableText.kt:60)");
                }
                ExtandableTextKt.h(text, style, i, composer, (i3 & 14) | (i3 & 112) | (i3 & 896));
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
