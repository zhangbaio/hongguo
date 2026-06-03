package com.dragon.read.kmp.widget;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m1 {
    static {
        Covode.recordClassIndex(609656);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        c(modifier, z, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final float d(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(State state, androidx.compose.ui.graphics.c1 graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.i(d(state));
        return Unit.INSTANCE;
    }

    public static final void c(Modifier modifier, final boolean z, Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        Modifier modifier3;
        final State state;
        Modifier modifier4;
        Composer startRestartGroup = composer.startRestartGroup(1182226769);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i3 & 19) != 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i3 & 1)) {
            if (i6 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1182226769, i3, -1, "com.dragon.read.kmp.widget.LoadingView (LoadingView.kt:26)");
            }
            InfiniteTransition g = androidx.compose.animation.core.a1.g((String) null, startRestartGroup, 0, 1);
            if (z) {
                startRestartGroup.startReplaceGroup(986022859);
                state = androidx.compose.animation.core.a1.c(g, 0.0f, 360.0f, androidx.compose.animation.core.j.e(androidx.compose.animation.core.j.n(600, 0, androidx.compose.animation.core.m0.d(), 2, (Object) null), RepeatMode.Restart, 0L, 4, (Object) null), (String) null, startRestartGroup, InfiniteTransition.f | 432 | (androidx.compose.animation.core.u0.d << 9), 8);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(986313670);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                state = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endReplaceGroup();
            }
            if (z) {
                androidx.compose.ui.graphics.e1 a = org.jetbrains.compose.resources.c.a(yo2.d2.I(f2.a.a), startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changed = startRestartGroup.changed(state);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.widget.k1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit e;
                            e = m1.e(state, (androidx.compose.ui.graphics.c1) obj);
                            return e;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                modifier4 = modifier3;
                androidx.compose.foundation.z0.g(a, (String) null, androidx.compose.ui.graphics.b1.a(modifier3, (Function1) rememberedValue2), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 48, 248);
            } else {
                modifier4 = modifier3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.l1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = m1.f(modifier2, z, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }
}
