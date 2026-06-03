package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryTitleBarStateObserverKt {
    static {
        Covode.recordClassIndex(609316);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(LazyListState lazyListState, KmpStoryClient kmpStoryClient, int i, Composer composer, int i2) {
        c(lazyListState, kmpStoryClient, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b d() {
        return new tp4.b("StoryTitleBarStateObserver");
    }

    public static final void c(final LazyListState lazyListState, final KmpStoryClient storyClient, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(storyClient, "storyClient");
        Composer startRestartGroup = composer.startRestartGroup(1247243273);
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
                ComposerKt.traceEventStart(1247243273, i2, -1, "com.dragon.read.kmp.story.impl.feeds.observer.StoryTitleBarStateObserver (StoryTitleBarStateObserver.kt:18)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        tp4.b d;
                        d = StoryTitleBarStateObserverKt.d();
                        return d;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LazyKt__LazyJVMKt.lazy((Function0) rememberedValue);
            float M0 = ((x0.e) startRestartGroup.consume(CompositionLocalsKt.f())).M0(x0.i.g(20));
            Float valueOf = Float.valueOf(M0);
            startRestartGroup.startReplaceGroup(-1746271574);
            int i5 = i2 & 14;
            if (i5 == 4) {
                z2 = true;
            }
            boolean changedInstance = startRestartGroup.changedInstance(storyClient) | z2 | startRestartGroup.changed(M0);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new StoryTitleBarStateObserverKt$StoryTitleBarStateObserver$1$1(lazyListState, storyClient, M0, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(lazyListState, storyClient, valueOf, (Function2) rememberedValue2, startRestartGroup, i5 | (i2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e;
                    e = StoryTitleBarStateObserverKt.e(lazyListState, storyClient, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e;
                }
            });
        }
    }
}
