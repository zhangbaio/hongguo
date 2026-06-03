package gn4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import ig4.i;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(608762);
    }

    public static final Modifier a(Modifier modifier, a absKmpSearchGroupModel, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(absKmpSearchGroupModel, "absKmpSearchGroupModel");
        composer.startReplaceGroup(-2121527926);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2121527926, i, -1, "com.dragon.read.kmp.search.feed.model.setGroupItemCorner (AbsKmpSearchGroupModel.kt:37)");
        }
        if (absKmpSearchGroupModel.h() && absKmpSearchGroupModel.i()) {
            Modifier c = i.c(modifier, x0.i.d(x0.i.g(8)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return c;
        }
        if (absKmpSearchGroupModel.h()) {
            float f = 8;
            float g = x0.i.g(f);
            float g2 = x0.i.g(f);
            float f2 = 0;
            Modifier c2 = i.c(modifier, (x0.i) null, g, g2, x0.i.g(f2), x0.i.g(f2), 1, (Object) null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return c2;
        }
        if (absKmpSearchGroupModel.i()) {
            float f3 = 0;
            float g3 = x0.i.g(f3);
            float g4 = x0.i.g(f3);
            float f4 = 8;
            Modifier c3 = i.c(modifier, (x0.i) null, g3, g4, x0.i.g(f4), x0.i.g(f4), 1, (Object) null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return c3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifier;
    }
}
