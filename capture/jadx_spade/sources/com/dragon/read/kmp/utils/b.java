package com.dragon.read.kmp.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(609521);
    }

    public static final w0 b(Theme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (com.dragon.read.kmp.service.d1.d(theme)) {
            return m.a;
        }
        return z.a;
    }

    public static final w0 a(Composer composer, int i) {
        composer.startReplaceGroup(-32404704);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-32404704, i, -1, "com.dragon.read.kmp.utils.getThemeColor (BizThemeColor.kt:15)");
        }
        w0 b = b(og4.a.a.e(composer, og4.a.b));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return b;
    }
}
