package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryReadProgressObserverKt {
    static {
        Covode.recordClassIndex(609314);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(LazyListState lazyListState, KmpStoryClient kmpStoryClient, int i, Composer composer, int i2) {
        b(lazyListState, kmpStoryClient, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final void d(List<? extends androidx.compose.foundation.lazy.o> visibleItemsInfo, KmpStoryClient storyClient) {
        Object lastOrNull;
        gp4.b bVar;
        kp4.b n;
        Float a;
        Intrinsics.checkNotNullParameter(visibleItemsInfo, "visibleItemsInfo");
        Intrinsics.checkNotNullParameter(storyClient, "storyClient");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) visibleItemsInfo);
        androidx.compose.foundation.lazy.o oVar = (androidx.compose.foundation.lazy.o) lastOrNull;
        if (oVar == null) {
            return;
        }
        Object orNull = CollectionsKt___CollectionsKt.getOrNull(storyClient.e.b, oVar.getIndex());
        if (orNull instanceof gp4.b) {
            bVar = (gp4.b) orNull;
        } else {
            bVar = null;
        }
        if (bVar != null && (n = storyClient.n(bVar.c())) != null && n.k() && n.m() && (a = com.dragon.read.kmp.story.impl.feeds.progress.b.a(n, bVar, oVar.getSize() + oVar.getOffset())) != null) {
            n.u(a.floatValue());
        }
    }

    public static final void b(final LazyListState lazyListState, final KmpStoryClient storyClient, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(storyClient, "storyClient");
        Composer startRestartGroup = composer.startRestartGroup(-1550594277);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(storyClient)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z2 = false;
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1550594277, i2, -1, "com.dragon.read.kmp.story.impl.feeds.observer.StoryReadProgressObserver (StoryReadProgressObserver.kt:18)");
            }
            startRestartGroup.startReplaceGroup(-1633490746);
            int i5 = i2 & 14;
            if (i5 == 4) {
                z2 = true;
            }
            boolean changedInstance = startRestartGroup.changedInstance(storyClient) | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new StoryReadProgressObserverKt$StoryReadProgressObserver$1$1(lazyListState, storyClient, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(lazyListState, (Function2) rememberedValue, startRestartGroup, i5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = StoryReadProgressObserverKt.c(lazyListState, storyClient, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
