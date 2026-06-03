package cm4;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    static {
        Covode.recordClassIndex(608293);
    }

    public static final i a(Composer composer, int i) {
        NsReaderActivity nsReaderActivity;
        composer.startReplaceGroup(-1673482590);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1673482590, i, -1, "com.dragon.read.kmp.reader.config.currentReader (NsReader.android.kt:7)");
        }
        NsReaderActivity nsReaderActivity2 = (Context) composer.consume(AndroidCompositionLocals_androidKt.g());
        i iVar = null;
        if (nsReaderActivity2 instanceof NsReaderActivity) {
            nsReaderActivity = nsReaderActivity2;
        } else {
            nsReaderActivity = null;
        }
        if (nsReaderActivity != null) {
            iVar = nsReaderActivity.h2();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iVar;
    }
}
