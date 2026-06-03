package com.dragon.read.kmp.shortvideo.distribution.page.search;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.KmpDialogServiceKt;
import com.dragon.read.kmp.service.g1;
import com.dragon.read.kmp.shortvideo.distribution.page.search.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static String b;
    public static final int c;

    private b() {
    }

    static {
        Covode.recordClassIndex(609065);
        a = new b();
        b = "";
        c = 8;
    }

    static final class a implements Function3<com.dragon.read.kmp.service.g, Composer, Integer, Unit> {
        final /* synthetic */ Function2<io4.a, Integer, Unit> a;
        final /* synthetic */ Function2<io4.a, Integer, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super io4.a, ? super Integer, Unit> function2, Function2<? super io4.a, ? super Integer, Unit> function22) {
            this.a = function2;
            this.b = function22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(com.dragon.read.kmp.service.g gVar) {
            gVar.a();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.service.g gVar, Composer composer, Integer num) {
            b(gVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(final com.dragon.read.kmp.service.g controller, Composer composer, int i) {
            boolean z;
            boolean changedInstance;
            int i2;
            Intrinsics.checkNotNullParameter(controller, "controller");
            if ((i & 6) == 0) {
                if ((i & 8) == 0) {
                    changedInstance = composer.changed(controller);
                } else {
                    changedInstance = composer.changedInstance(controller);
                }
                if (changedInstance) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
                i |= i2;
            }
            boolean z2 = true;
            if ((i & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1325590396, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.KmpSeriesRankSearchDialog.show.<anonymous> (KmpSeriesRankSearchDialog.kt:29)");
                }
                composer.startReplaceGroup(5004770);
                if ((i & 14) != 4 && ((i & 8) == 0 || !composer.changedInstance(controller))) {
                    z2 = false;
                }
                Object rememberedValue = composer.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = b.a.c(com.dragon.read.kmp.service.g.this);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                SeriesRankSearchPageKt.I(new d0((Function0) rememberedValue, this.a, this.b), controller, composer, ((i << 3) & 112) | (com.dragon.read.kmp.service.g.b << 3), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public final String a(Function2<? super io4.a, ? super Integer, Unit> onShowActor, Function2<? super io4.a, ? super Integer, Unit> onClickActor) {
        Intrinsics.checkNotNullParameter(onShowActor, "onShowActor");
        Intrinsics.checkNotNullParameter(onClickActor, "onClickActor");
        g1 g1Var = new g1(true, true, null, true, 4, null);
        g1Var.i = false;
        g1Var.g = true;
        String l = KmpDialogServiceKt.l(g1Var, androidx.compose.runtime.internal.t.c(-1325590396, true, new a(onClickActor, onShowActor)));
        b = l;
        return l;
    }
}
