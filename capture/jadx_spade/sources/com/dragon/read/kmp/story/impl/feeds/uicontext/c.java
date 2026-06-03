package com.dragon.read.kmp.story.impl.feeds.uicontext;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import pp4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(609356);
        a = new c();
    }

    private c() {
    }

    public final int a(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2114932875, i, -1, "com.dragon.read.kmp.story.impl.feeds.uicontext.StoryUiContext.<get-appTheme> (StoryUiContext.kt:20)");
        }
        int intValue = ((Number) composer.consume(qp4.c.f())).intValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return intValue;
    }

    public final d b(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(630947061, i, -1, "com.dragon.read.kmp.story.impl.feeds.uicontext.StoryUiContext.<get-themeColor> (StoryUiContext.kt:15)");
        }
        d dVar = (d) composer.consume(qp4.c.e());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return dVar;
    }
}
