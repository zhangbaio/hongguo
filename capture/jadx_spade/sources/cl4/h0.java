package cl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h0 {
    static {
        Covode.recordClassIndex(608063);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(gk4.r rVar, Function0 function0, Function0 function02, Function3 function3, int i, int i2, Composer composer, int i3) {
        d(rVar, function0, function02, function3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        return Unit.INSTANCE;
    }

    public static final void d(final gk4.r itemModel, Function0<Unit> function0, Function0<Unit> function02, Function3<? super androidx.compose.foundation.layout.r, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer startRestartGroup = composer.startRestartGroup(1331846750);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(itemModel)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(function3)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i8 != 0) {
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: cl4.e0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e;
                            e = h0.e();
                            return e;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                function0 = (Function0) rememberedValue;
                startRestartGroup.endReplaceGroup();
            }
            if (i9 != 0) {
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: cl4.f0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit f;
                            f = h0.f();
                            return f;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                function02 = (Function0) rememberedValue2;
                startRestartGroup.endReplaceGroup();
            }
            if (i10 != 0) {
                function3 = r.a.a();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1331846750, i3, -1, "com.dragon.read.kmp.profile.container.double_column.PugcVideoListItem2Column (PugcVideoListItem2Column.kt:12)");
            }
            z0.j(itemModel, function0, function02, function3, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final Function0<Unit> function03 = function0;
        final Function0<Unit> function04 = function02;
        final Function3<? super androidx.compose.foundation.layout.r, ? super Composer, ? super Integer, Unit> function32 = function3;
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: cl4.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = h0.g(gk4.r.this, function03, function04, function32, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }
}
