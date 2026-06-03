package com.dragon.read.kmp.service;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpFontServiceKt {
    static {
        Covode.recordClassIndex(608882);
    }

    public static final State<androidx.compose.ui.text.font.j> a(String fontFamily, Composer composer, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        composer.startReplaceGroup(-1463167889);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1463167889, i, -1, "com.dragon.read.kmp.service.rememberFontFamily (KmpFontService.kt:30)");
        }
        composer.startReplaceGroup(5004770);
        int i2 = i & 14;
        int i3 = i2 ^ 6;
        boolean z2 = false;
        if ((i3 > 4 && composer.changed(fontFamily)) || (i & 6) == 4) {
            z = true;
        } else {
            z = false;
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default(s0.a.a(fontFamily), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        if (mutableState.getValue() == null) {
            composer.startReplaceGroup(-1633490746);
            if ((i3 > 4 && composer.changed(fontFamily)) || (i & 6) == 4) {
                z2 = true;
            }
            boolean changed = composer.changed(mutableState) | z2;
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new KmpFontServiceKt$rememberFontFamily$1$1(fontFamily, mutableState, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            EffectsKt.LaunchedEffect(fontFamily, (Function2) rememberedValue2, composer, i2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mutableState;
    }
}
