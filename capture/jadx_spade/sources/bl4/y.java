package bl4;

import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import gk4.n0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y {

    public static final class a implements DisposableEffectResult {
        public void dispose() {
        }
    }

    static {
        Covode.recordClassIndex(608048);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(n0 n0Var, int i, Composer composer, int i2) {
        g(n0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(n0 n0Var, Modifier modifier, Function0 function0, Function0 function02, Function4 function4, Function4 function42, int i, int i2, Composer composer, int i3) {
        i(n0Var, modifier, function0, function02, function4, function42, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult k(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new a();
    }

    private static final void g(final n0 n0Var, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-113201032);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(n0Var)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-113201032, i2, -1, "com.dragon.read.kmp.profile.container.MainInfo (SeriesPostItem3Column.kt:103)");
            }
            String str = n0Var.c;
            int b = w0.s.b.b();
            composer2 = startRestartGroup;
            a6.j(str, f2.v(Modifier.Companion, 0.0f, x0.i.g(8), 0.0f, 0.0f, 13, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, x0.x.h(14), b, false, 1, 0, (Function1) null, (g3) null, composer2, 3120, 3126, 119792);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bl4.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h;
                    h = y.h(n0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return h;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final gk4.n0 r36, androidx.compose.ui.Modifier r37, kotlin.jvm.functions.Function0<kotlin.Unit> r38, kotlin.jvm.functions.Function0<kotlin.Unit> r39, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.r, ? super gk4.n0, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.r, ? super gk4.n0, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bl4.y.i(gk4.n0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function4, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
