package com.dragon.read.kmp.mine.push;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.t;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ComposableSingletons$InnerPushPageKt {
    public static final ComposableSingletons$InnerPushPageKt a;
    private static Function2<Composer, Integer, Unit> b;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(607744);
        a = new ComposableSingletons$InnerPushPageKt();
        b = t.c(187231706, false, new Function2<Composer, Integer, Unit>() { // from class: com.dragon.read.kmp.mine.push.ComposableSingletons$InnerPushPageKt$lambda$187231706$1
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
                        ComposerKt.traceEventStart(187231706, i, -1, "com.dragon.read.kmp.mine.push.ComposableSingletons$InnerPushPageKt.lambda$187231706.<anonymous> (InnerPushPage.kt:60)");
                    }
                    Unit unit = Unit.INSTANCE;
                    composer.startReplaceGroup(1849434622);
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new ComposableSingletons$InnerPushPageKt$lambda$187231706$1$1$1(null);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue, composer, 6);
                    k.j(composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }
}
