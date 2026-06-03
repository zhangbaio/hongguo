package com.dragon.read.kmp.shortvideo.distribution.page;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    static {
        Covode.recordClassIndex(609046);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(LoadStatus loadStatus, Function0 function0, int i, Composer composer, int i2) {
        c(loadStatus, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final void c(final LoadStatus loadStatus, final Function0<Unit> onErrorClick, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(loadStatus, "loadStatus");
        Intrinsics.checkNotNullParameter(onErrorClick, "onErrorClick");
        Composer startRestartGroup = composer.startRestartGroup(-1164618464);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(loadStatus.ordinal())) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(onErrorClick)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z3 = true;
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1164618464, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.PageLoadLayout (PageLoadLayout.kt:15)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
            p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, f);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i5, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (mg4.c.c(loadStatus)) {
                startRestartGroup.startReplaceGroup(-510552955);
                mg4.k.r(loadStatus, (mg4.b) null, l0.b.g(), SizeKt.f(aVar, 0.0f, 1, (Object) null), a.a.a(), false, (Function3) null, (Function3) null, (Function2) null, startRestartGroup, (i2 & 14) | 28032, 482);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-510141213);
                if (loadStatus == LoadStatus.Empty) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                composer2.startReplaceGroup(5004770);
                if ((i2 & 112) != 32) {
                    z3 = false;
                }
                Object rememberedValue = composer2.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d;
                            d = e.d(Function0.this);
                            return d;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceGroup();
                bo4.g.e(z2, (Function0) rememberedValue, composer2, 0, 0);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e2;
                    e2 = e.e(loadStatus, onErrorClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e2;
                }
            });
        }
    }
}
