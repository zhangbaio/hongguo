package cl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public static final r a;
    private static Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> b;

    public final Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(608055);
        a = new r();
        b = androidx.compose.runtime.internal.t.c(199270886, false, a.a);
    }

    static final class a implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r rVar, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(rVar, "<this>");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(199270886, i, -1, "com.dragon.read.kmp.profile.container.double_column.ComposableSingletons$PugcVideoListItem2ColumnKt.lambda$199270886.<anonymous> (PugcVideoListItem2Column.kt:11)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }
}
