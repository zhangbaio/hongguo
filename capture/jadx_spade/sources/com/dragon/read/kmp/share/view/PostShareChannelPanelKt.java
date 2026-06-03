package com.dragon.read.kmp.share.view;

import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import xn4.d0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PostShareChannelPanelKt {
    static {
        Covode.recordClassIndex(608985);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(String str, List list, Function1 function1, boolean z, boolean z2, boolean z3, Function0 function0, Function1 function12, int i, Composer composer, int i2) {
        c(str, list, function1, z, z2, z3, function0, function12, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final e1 j(String str) {
        boolean z;
        Object m773constructorimpl;
        byte[] b2 = xn4.b0.a.b(str);
        Object obj = null;
        if (b2 == null) {
            return null;
        }
        if (b2.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(d0.a(b2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m779isFailureimpl(m773constructorimpl)) {
            obj = m773constructorimpl;
        }
        return (e1) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;

        a(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            long j;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-721447128, i, -1, "com.dragon.read.kmp.share.view.PostShareChannelPanel.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PostShareChannelPanel.kt:100)");
                }
                long h = x0.x.h(16);
                c0 a = c0.b.a();
                if (this.a) {
                    j = 4294967295L;
                } else {
                    j = 4278190080L;
                }
                a6.j(this.b, (Modifier) null, n0.d(j), h, (androidx.compose.ui.text.font.y) null, a, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 131026);
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
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            long j;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-347666847, i, -1, "com.dragon.read.kmp.share.view.PostShareChannelPanel.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PostShareChannelPanel.kt:133)");
                }
                long h = x0.x.h(12);
                if (this.a) {
                    j = 2583691263L;
                } else {
                    j = 2986344448L;
                }
                a6.j("展示二维码", (Modifier) null, n0.d(j), h, (androidx.compose.ui.text.font.y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3078, 0, 131058);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function1 function1, MutableState mutableState) {
        g(mutableState, !d(mutableState));
        function1.invoke(Boolean.valueOf(d(mutableState)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x01ba, code lost:
    
        if (r4 == r27.getEmpty()) goto L103;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final java.lang.String r62, final java.util.List<bh1.a> r63, final kotlin.jvm.functions.Function1<? super bh1.a, kotlin.Unit> r64, final boolean r65, final boolean r66, final boolean r67, final kotlin.jvm.functions.Function0<kotlin.Unit> r68, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r69, androidx.compose.runtime.Composer r70, final int r71) {
        /*
            Method dump skipped, instructions count: 1702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.view.PostShareChannelPanelKt.c(java.lang.String, java.util.List, kotlin.jvm.functions.Function1, boolean, boolean, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }
}
