package cm4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    static {
        Covode.recordClassIndex(608297);
    }

    public static final qm4.a a(Composer composer, int i) {
        l lVar;
        f fVar;
        qm4.a e;
        composer.startReplaceGroup(573563273);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(573563273, i, -1, "com.dragon.read.kmp.reader.config.currentBookCoverIntercept (ReaderImplEx.kt:7)");
        }
        i a = j.a(composer, 0);
        if (a instanceof l) {
            lVar = (l) a;
        } else {
            lVar = null;
        }
        if (lVar != null && (fVar = lVar.h) != null && (e = fVar.e()) != null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return e;
        }
        throw new IllegalArgumentException("bookCoverIntercept is null");
    }
}
