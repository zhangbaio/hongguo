package com.dragon.read.kmp.reader.ui;

import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.ui.BubbleGravity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BubbleTipLayoutKt {
    static {
        Covode.recordClassIndex(608589);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(String str, wg4.m mVar, float f, BubbleGravity bubbleGravity, float f2, long j, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        f(str, mVar, f, bubbleGravity, f2, j, function0, function02, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.INSTANCE;
    }

    private static final boolean l(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float n(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(MutableState mutableState, float f) {
        o(mutableState, f);
        return Unit.INSTANCE;
    }

    private static final void m(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void o(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ BubbleGravity a;
        final /* synthetic */ MutableState<Float> b;
        final /* synthetic */ String c;

        a(BubbleGravity bubbleGravity, MutableState<Float> mutableState, String str) {
            this.a = bubbleGravity;
            this.b = mutableState;
            this.c = str;
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
                    ComposerKt.traceEventStart(-823236588, i, -1, "com.dragon.read.kmp.reader.ui.BubbleTipLayout.<anonymous> (BubbleTipLayout.kt:82)");
                }
                wg4.k.b((Modifier) null, ((qg4.n) composer.consume(zl4.r.s())).x2(), x0.i.g(6), x0.i.g(11), x0.i.g(5), this.a.reverse(), BubbleTipLayoutKt.n(this.b), androidx.compose.runtime.internal.t.e(1815074005, true, new C0050a(this.c), composer, 54), composer, 12610944, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* renamed from: com.dragon.read.kmp.reader.ui.BubbleTipLayoutKt$a$a, reason: collision with other inner class name */
        static final class C0050a implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
            final /* synthetic */ String a;

            C0050a(String str) {
                this.a = str;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
                a(rVar, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void a(androidx.compose.foundation.layout.r BubbleLayout, Composer composer, int i) {
                int i2;
                boolean z;
                int i3;
                Intrinsics.checkNotNullParameter(BubbleLayout, "$this$BubbleLayout");
                if ((i & 6) == 0) {
                    if (composer.changed(BubbleLayout)) {
                        i3 = 4;
                    } else {
                        i3 = 2;
                    }
                    i2 = i | i3;
                } else {
                    i2 = i;
                }
                if ((i2 & 19) != 18) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i2 & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1815074005, i2, -1, "com.dragon.read.kmp.reader.ui.BubbleTipLayout.<anonymous>.<anonymous> (BubbleTipLayout.kt:91)");
                    }
                    long i4 = l0.b.i();
                    long h = x0.x.h(14);
                    int a = w0.h.b.a();
                    float f = 16;
                    a6.j(this.a, f2.u(BubbleLayout.b(Modifier.Companion, androidx.compose.ui.e.a.e()), x0.i.g(f), x0.i.g(8), x0.i.g(f), x0.i.g(12)), i4, h, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a), x0.x.h(16), 0, false, 0, 0, (Function1) null, (g3) null, composer, 3456, 6, 129520);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(wg4.m mVar, Function0 function0, MutableState mutableState) {
        m(mutableState, false);
        mVar.a();
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x030a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final java.lang.String r22, final wg4.m r23, float r24, com.dragon.read.kmp.compose.ui.BubbleGravity r25, float r26, long r27, kotlin.jvm.functions.Function0<kotlin.Unit> r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.ui.BubbleTipLayoutKt.f(java.lang.String, wg4.m, float, com.dragon.read.kmp.compose.ui.BubbleGravity, float, long, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
