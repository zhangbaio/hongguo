package com.dragon.read.kmp.story.impl.feeds.page.view;

import androidx.compose.material.p0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    static {
        Covode.recordClassIndex(609324);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(np4.b bVar, int i, Composer composer, int i2) {
        b(bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final void b(final np4.b page, Composer composer, final int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(page, "page");
        Composer startRestartGroup = composer.startRestartGroup(76133289);
        int i2 = i & 1;
        if (i2 != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(76133289, i, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.ContentDividerView (ContentDividerView.kt:10)");
            }
            p0.b((Modifier) null, com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(startRestartGroup, 6).o(), x0.i.g(8), 0.0f, startRestartGroup, 384, 9);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = h.c(np4.b.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
