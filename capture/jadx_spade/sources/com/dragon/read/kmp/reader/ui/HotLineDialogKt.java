package com.dragon.read.kmp.reader.ui;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.m0;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HotLineDialogKt {
    private static final com.dragon.read.kmp.i a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(boolean z, float f, long j, int i, Composer composer, int i2) {
        d(z, f, j, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(n nVar, int i, Composer composer, int i2) {
        g(nVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final com.dragon.read.kmp.i j() {
        return a;
    }

    static {
        Covode.recordClassIndex(608590);
        a = new com.dragon.read.kmp.i("HotLineDialog");
    }

    public static final void g(final n param, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(param, "param");
        Composer startRestartGroup = composer.startRestartGroup(-1261886839);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(param)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        boolean z2 = false;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1261886839, i2, -1, "com.dragon.read.kmp.reader.ui.HotLineDialog (HotLineDialog.kt:68)");
            }
            a.a("HotLineDialog param = " + param);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(5004770);
            if ((i2 & 14) == 4) {
                z2 = true;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new HotLineDialogKt$HotLineDialog$1$1(param, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue, startRestartGroup, 6);
            com.dragon.read.kmp.reader.state.t.f(androidx.compose.runtime.internal.t.e(540973306, true, new HotLineDialogKt$HotLineDialog$2(param), startRestartGroup, 54), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h;
                    h = HotLineDialogKt.h(n.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return h;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(long j, boolean z, float f, androidx.compose.ui.graphics.drawscope.f Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float M0 = Canvas.M0(x0.i.g(16));
        float M02 = Canvas.M0(x0.i.g(8));
        Path a2 = androidx.compose.ui.graphics.t.a();
        if (z) {
            a2.moveTo(f, 0.0f);
            float f2 = M0 / 2;
            a2.lineTo(f - f2, M02);
            a2.lineTo(f + f2, M02);
        } else {
            float f3 = M0 / 2;
            a2.moveTo(f - f3, 0.0f);
            a2.lineTo(f3 + f, 0.0f);
            a2.lineTo(f, M02);
        }
        a2.close();
        DrawScope.-CC.m(Canvas, a2, j, 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (m0) null, 0, 60, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final boolean z, final float f, final long j, Composer composer, final int i) {
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1878901184);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(z)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(f)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(j)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        boolean z5 = false;
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1878901184, i2, -1, "com.dragon.read.kmp.reader.ui.Arrow (HotLineDialog.kt:297)");
            }
            Modifier i6 = SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(8));
            startRestartGroup.startReplaceGroup(-1746271574);
            if ((i2 & 14) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((i2 & 112) == 32) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z6 = z3 | z4;
            if ((i2 & 896) == 256) {
                z5 = true;
            }
            boolean z7 = z6 | z5;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.ui.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit e;
                        e = HotLineDialogKt.e(j, z, f, (androidx.compose.ui.graphics.drawscope.f) obj);
                        return e;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            androidx.compose.foundation.z.b(i6, (Function1) rememberedValue, startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f2;
                    f2 = HotLineDialogKt.f(z, f, j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return f2;
                }
            });
        }
    }
}
