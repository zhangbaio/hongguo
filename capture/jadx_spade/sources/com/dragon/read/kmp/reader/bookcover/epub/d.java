package com.dragon.read.kmp.reader.bookcover.epub;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.window.SecureFlagPolicy;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(608267);
    }

    public static final androidx.compose.ui.window.f a(Composer composer, int i) {
        composer.startReplaceGroup(220172277);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(220172277, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.getBookCoverCopyrightDialogProperties (BookCoverDialogHelper.android.kt:17)");
        }
        androidx.compose.ui.window.f fVar = new androidx.compose.ui.window.f(true, false, (SecureFlagPolicy) null, false, false, (String) null, 36, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return fVar;
    }
}
