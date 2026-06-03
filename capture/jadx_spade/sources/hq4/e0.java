package hq4;

import android.view.View;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e0 {
    static {
        Covode.recordClassIndex(609673);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(float f, int i, Composer composer, int i2) {
        c(f, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(View view, float f) {
        androidx.compose.ui.window.g gVar;
        androidx.compose.ui.window.g parent = view.getParent();
        Window window = null;
        if (parent instanceof androidx.compose.ui.window.g) {
            gVar = parent;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            window = gVar.getWindow();
        }
        if (window != null) {
            window.setDimAmount(f);
        }
        return Unit.INSTANCE;
    }

    public static final void c(final float f, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(433473907);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(f)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        boolean z2 = true;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(433473907, i2, -1, "com.dragon.read.kmp.widget.dialog.ConfigureDialogDim (DialogDimHelper.android.kt:8)");
            }
            final View view = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.k());
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance = startRestartGroup.changedInstance(view);
            if ((i2 & 14) != 4) {
                z2 = false;
            }
            boolean z3 = changedInstance | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: hq4.c0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d;
                        d = e0.d(view, f);
                        return d;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: hq4.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e;
                    e = e0.e(f, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e;
                }
            });
        }
    }
}
