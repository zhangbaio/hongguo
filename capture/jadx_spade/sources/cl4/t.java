package cl4;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.m0;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    public static final t a;
    private static Function2<Composer, Integer, Unit> b;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(608057);
        a = new t();
        b = androidx.compose.runtime.internal.t.c(1508271951, false, a.a);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1508271951, i, -1, "com.dragon.read.kmp.profile.container.double_column.ComposableSingletons$VideoListItemReservation2ColKt.lambda$1508271951.<anonymous> (VideoListItemReservation2Col.kt:196)");
                }
                androidx.compose.foundation.z0.c(org.jetbrains.compose.resources.c.b(b4.C(d4.a), composer, 0), (String) null, SizeKt.s(Modifier.Companion, x0.i.g(12)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, og4.a.a.h(composer, og4.a.b).r(), 0, 2, (Object) null), composer, 432, 56);
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
