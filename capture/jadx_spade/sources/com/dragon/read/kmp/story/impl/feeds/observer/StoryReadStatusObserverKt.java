package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryReadStatusObserverKt {
    static {
        Covode.recordClassIndex(609315);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(LazyListState lazyListState, KmpStoryClient kmpStoryClient, int i, Composer composer, int i2) {
        b(lazyListState, kmpStoryClient, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final void b(final LazyListState lazyListState, final KmpStoryClient storyClient, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        int i3;
        Set emptySet;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(storyClient, "storyClient");
        Composer startRestartGroup = composer.startRestartGroup(1050195323);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(storyClient)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        int i6 = i2;
        boolean z2 = false;
        if ((i6 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1050195323, i6, -1, "com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserver (StoryReadStatusObserver.kt:19)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                emptySet = SetsKt__SetsKt.emptySet();
                rememberedValue = SnapshotStateKt.mutableStateOf$default(emptySet, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(-1224400529);
                int i7 = i6 & 14;
                if (i7 == 4) {
                    z2 = true;
                }
                boolean changedInstance = z2 | startRestartGroup.changedInstance(storyClient) | startRestartGroup.changedInstance(kmpStoryFeedsVM);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changedInstance && rememberedValue2 != companion.getEmpty()) {
                    i3 = i6;
                    composer2 = startRestartGroup;
                } else {
                    i3 = i6;
                    composer2 = startRestartGroup;
                    StoryReadStatusObserverKt$StoryReadStatusObserver$1$1 storyReadStatusObserverKt$StoryReadStatusObserver$1$1 = new StoryReadStatusObserverKt$StoryReadStatusObserver$1$1(lazyListState, storyClient, mutableState, kmpStoryFeedsVM, null);
                    composer2.updateRememberedValue(storyReadStatusObserverKt$StoryReadStatusObserver$1$1);
                    rememberedValue2 = storyReadStatusObserverKt$StoryReadStatusObserver$1$1;
                }
                composer2.endReplaceGroup();
                EffectsKt.LaunchedEffect(lazyListState, storyClient, (Function2) rememberedValue2, composer2, (i3 & 112) | i7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c2;
                    c2 = StoryReadStatusObserverKt.c(lazyListState, storyClient, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c2;
                }
            });
        }
    }
}
