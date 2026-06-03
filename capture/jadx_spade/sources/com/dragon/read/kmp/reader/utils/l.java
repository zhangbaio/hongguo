package com.dragon.read.kmp.reader.utils;

import android.view.MotionEvent;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.input.pointer.k0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.util.kotlin.UIKt;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    static {
        Covode.recordClassIndex(608654);
    }

    public static final Modifier b(Composer composer, int i) {
        composer.startReplaceGroup(-1402195878);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1402195878, i, -1, "com.dragon.read.kmp.reader.utils.HorizontalGesturesConflict (HorizontalGesturesConflict.android.kt:15)");
        }
        final View view = (View) composer.consume(AndroidCompositionLocals_androidKt.k());
        composer.startReplaceGroup(1849434622);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1849434622);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        composer.endReplaceGroup();
        final int dp = UIKt.getDp(3);
        Modifier.a aVar = Modifier.Companion;
        composer.startReplaceGroup(-1224400529);
        boolean changedInstance = composer.changedInstance(view) | composer.changed(dp);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.reader.utils.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean c;
                    c = l.c(mutableState, mutableState2, view, dp, (MotionEvent) obj);
                    return Boolean.valueOf(c);
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Modifier c = PointerInteropFilter_androidKt.c(aVar, (k0) null, (Function1) rememberedValue3, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r0 != 3) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(androidx.compose.runtime.MutableState r4, androidx.compose.runtime.MutableState r5, android.view.View r6, int r7, android.view.MotionEvent r8) {
        /*
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5d
            if (r0 == r2) goto L53
            r3 = 2
            if (r0 == r3) goto L16
            r4 = 3
            if (r0 == r4) goto L53
            goto L7c
        L16:
            float r0 = r8.getX()
            java.lang.Object r4 = r4.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r0 = r0 - r4
            float r4 = r8.getY()
            java.lang.Object r5 = r5.getValue()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r4 = r4 - r5
            float r5 = java.lang.Math.abs(r0)
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 <= 0) goto L7c
            float r4 = java.lang.Math.abs(r0)
            float r5 = (float) r7
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L7c
            android.view.ViewParent r4 = r6.getParent()
            if (r4 == 0) goto L7c
            r4.requestDisallowInterceptTouchEvent(r2)
            goto L7c
        L53:
            android.view.ViewParent r4 = r6.getParent()
            if (r4 == 0) goto L7c
            r4.requestDisallowInterceptTouchEvent(r1)
            goto L7c
        L5d:
            float r7 = r8.getX()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            r4.setValue(r7)
            float r4 = r8.getY()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r5.setValue(r4)
            android.view.ViewParent r4 = r6.getParent()
            if (r4 == 0) goto L7c
            r4.requestDisallowInterceptTouchEvent(r2)
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.utils.l.c(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, android.view.View, int, android.view.MotionEvent):boolean");
    }
}
