package zl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s {
    public static final s a;
    public static final int b = 0;

    static {
        Covode.recordClassIndex(608258);
        a = new s();
    }

    private s() {
    }

    public final ReaderBgColorType a(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1929290610, i, -1, "com.dragon.read.kmp.reader.base.RSUiContext.<get-backgroundType> (RSUiContext.kt:33)");
        }
        ReaderBgColorType readerBgColorType = (ReaderBgColorType) composer.consume(r.u());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return readerBgColorType;
    }

    public final b b(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(268520744, i, -1, "com.dragon.read.kmp.reader.base.RSUiContext.<get-colorScheme> (RSUiContext.kt:23)");
        }
        b bVar = (b) composer.consume(r.w());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return bVar;
    }

    public final int c(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(644845650, i, -1, "com.dragon.read.kmp.reader.base.RSUiContext.<get-theme> (RSUiContext.kt:18)");
        }
        int intValue = ((Number) composer.consume(r.A())).intValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return intValue;
    }
}
