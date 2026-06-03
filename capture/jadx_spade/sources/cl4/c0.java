package cl4;

import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 {
    static {
        Covode.recordClassIndex(608061);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(gk4.w wVar, int i, Composer composer, int i2) {
        b(wVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final void b(final gk4.w itemModel, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean changedInstance;
        int i3;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer startRestartGroup = composer.startRestartGroup(56156838);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(itemModel);
            } else {
                changedInstance = startRestartGroup.changedInstance(itemModel);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(56156838, i2, -1, "com.dragon.read.kmp.profile.container.double_column.MainInfo (MainInfo.kt:14)");
            }
            String titleText = itemModel.getTitleText();
            int b = w0.s.b.b();
            float f = 10;
            composer2 = startRestartGroup;
            a6.j(titleText, f2.v(Modifier.Companion, x0.i.g(f), x0.i.g(8), x0.i.g(f), 0.0f, 8, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).T2(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, x0.x.h(22), b, false, 2, 0, (Function1) null, (g3) null, composer2, 199680, 3126, 119760);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: cl4.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = c0.c(gk4.w.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
