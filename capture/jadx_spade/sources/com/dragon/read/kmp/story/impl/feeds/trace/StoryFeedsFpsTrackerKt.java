package com.dragon.read.kmp.story.impl.feeds.trace;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryFeedsFpsTrackerKt {
    static {
        Covode.recordClassIndex(609349);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(LazyListState lazyListState, int i, Composer composer, int i2) {
        b(lazyListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final void b(final LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Composer startRestartGroup = composer.startRestartGroup(773066158);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
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
                ComposerKt.traceEventStart(773066158, i2, -1, "com.dragon.read.kmp.story.impl.feeds.trace.StoryFeedsFpsTracker (StoryFeedsFpsTracker.kt:13)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Boolean valueOf = Boolean.valueOf(lazyListState.b());
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i2 & 14) != 4) {
                z2 = false;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new StoryFeedsFpsTrackerKt$StoryFeedsFpsTracker$1$1(lazyListState, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.trace.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e;
                    e = StoryFeedsFpsTrackerKt.e(lazyListState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e;
                }
            });
        }
    }
}
