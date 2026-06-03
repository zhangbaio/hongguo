package com.dragon.read.kmp.story.impl.feeds.guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(609288);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(w wVar, int i, Composer composer, int i2) {
        b(wVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final void b(final w agent, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(agent, "agent");
        Composer startRestartGroup = composer.startRestartGroup(-719205670);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(agent)) {
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
                ComposerKt.traceEventStart(-719205670, i2, -1, "com.dragon.read.kmp.story.impl.feeds.guide.KmpCommonStoryExitGuideDialog (KmpCommonStoryExitGuideDialog.kt:6)");
            }
            State collectAsState = SnapshotStateKt.collectAsState(agent.f.i, (CoroutineContext) null, startRestartGroup, 0, 1);
            if (((KmpStoryExitAlertType) ((Pair) collectAsState.getValue()).getFirst()) == KmpStoryExitAlertType.V2) {
                KmpStoryExitGuideDialogV2Kt.o(agent, (kp4.b) ((Pair) collectAsState.getValue()).getSecond(), startRestartGroup, i2 & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = c.c(w.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
