package com.dragon.read.kmp.shortvideo.distribution.infinite;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BottomSheetContentKt {
    static {
        Covode.recordClassIndex(609023);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(g gVar, FilterType filterType, Function2 function2, int i, int i2, Composer composer, int i3) {
        c(gVar, filterType, function2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(CoroutineScope coroutineScope, Function2 function2) {
        kotlinx.coroutines.i.e(coroutineScope, null, null, new BottomSheetContentKt$BottomSheetContent$1$1$1(function2, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final void c(final g gVar, FilterType filterType, final Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> onClose, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int ordinal;
        int i5;
        int i6;
        boolean z;
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer startRestartGroup = composer.startRestartGroup(-1882318146);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(gVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (filterType == null) {
                ordinal = -1;
            } else {
                ordinal = filterType.ordinal();
            }
            if (startRestartGroup.changed(ordinal)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(onClose)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i7 != 0) {
                filterType = FilterType.DEFAULT;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1882318146, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.infinite.BottomSheetContent (BottomSheetContent.kt:16)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            if (gVar != null && (!gVar.c.isEmpty())) {
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(onClose);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d;
                            d = BottomSheetContentKt.d(CoroutineScope.this, onClose);
                            return d;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                InnerInfinitePanelKt.j(gVar, null, filterType, (Function0) rememberedValue2, startRestartGroup, (i3 & 14) | ((i3 << 3) & 896), 2);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final FilterType filterType2 = filterType;
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e;
                    e = BottomSheetContentKt.e(g.this, filterType2, onClose, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return e;
                }
            });
        }
    }
}
