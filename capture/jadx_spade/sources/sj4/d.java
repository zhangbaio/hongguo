package sj4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yj4.w;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements ek4.b {
    static {
        Covode.recordClassIndex(607671);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(d dVar, wj4.c cVar, wj4.a aVar, int i, Composer composer, int i2) {
        dVar.h3(cVar, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    @Override // ek4.b
    public void h3(final wj4.c watchPreferencePageParams, final wj4.a iFunctionDepend, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(watchPreferencePageParams, "watchPreferencePageParams");
        Intrinsics.checkNotNullParameter(iFunctionDepend, "iFunctionDepend");
        Composer startRestartGroup = composer.startRestartGroup(1834880705);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(watchPreferencePageParams)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(iFunctionDepend);
            } else {
                changedInstance = startRestartGroup.changedInstance(iFunctionDepend);
            }
            if (changedInstance) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1834880705, i2, -1, "com.dragon.read.kmp.mine.KmpPreferenceServiceImpl.obtainWatchPreferencePage (KmpPreferenceServiceImpl.kt:16)");
            }
            w.X(watchPreferencePageParams, iFunctionDepend, startRestartGroup, (i2 & 14) | (i2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: sj4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit F0;
                    F0 = d.F0(d.this, watchPreferencePageParams, iFunctionDepend, i, (Composer) obj, ((Integer) obj2).intValue());
                    return F0;
                }
            });
        }
    }
}
