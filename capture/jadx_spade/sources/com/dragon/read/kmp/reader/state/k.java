package com.dragon.read.kmp.reader.state;

import androidx.compose.foundation.b1;
import androidx.compose.foundation.c1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k implements b1 {
    public static final k a;

    static {
        Covode.recordClassIndex(608578);
        a = new k();
    }

    private k() {
    }

    private static final class a implements c1 {
        public static final a a;

        static {
            Covode.recordClassIndex(608579);
            a = new a();
        }

        private a() {
        }

        public void a(androidx.compose.ui.graphics.drawscope.c cVar) {
            Intrinsics.checkNotNullParameter(cVar, "<this>");
            cVar.E1();
        }
    }

    public c1 b(androidx.compose.foundation.interaction.g interactionSource, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceGroup(-353440194);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-353440194, i, -1, "com.dragon.read.kmp.reader.state.NoIndication.rememberUpdatedInstance (ReaderUIStyle.kt:23)");
        }
        a aVar = a.a;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return aVar;
    }
}
