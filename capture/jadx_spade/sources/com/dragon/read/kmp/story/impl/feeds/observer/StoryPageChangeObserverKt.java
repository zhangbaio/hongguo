package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryPageChangeObserverKt {

    public static final class a implements DisposableEffectResult {
        public void dispose() {
        }
    }

    static {
        Covode.recordClassIndex(609313);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(LazyListState lazyListState, KmpStoryClient kmpStoryClient, int i, Composer composer, int i2) {
        e(lazyListState, kmpStoryClient, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(LazyListState lazyListState, KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator, int i, Composer composer, int i2) {
        k(lazyListState, kmpStoryPolarisTaskCoordinator, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(LazyListState lazyListState, KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator, int i, Composer composer, int i2) {
        k(lazyListState, kmpStoryPolarisTaskCoordinator, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult l(KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        kmpStoryPolarisTaskCoordinator.q();
        return new a();
    }

    public static final void k(final LazyListState lazyListState, final KmpStoryPolarisTaskCoordinator coordinator, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Composer startRestartGroup = composer.startRestartGroup(2113536097);
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
            if (startRestartGroup.changedInstance(coordinator)) {
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
                ComposerKt.traceEventStart(2113536097, i2, -1, "com.dragon.read.kmp.story.impl.feeds.observer.StoryPolarisTimerObserver (StoryPageChangeObserver.kt:117)");
            }
            if (!com.dragon.read.kmp.story.impl.feeds.polaris.a.a.a()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit n;
                            n = StoryPageChangeObserverKt.n(lazyListState, coordinator, i, (Composer) obj, ((Integer) obj2).intValue());
                            return n;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(coordinator);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult l;
                        l = StoryPageChangeObserverKt.l(KmpStoryPolarisTaskCoordinator.this, (DisposableEffectScope) obj);
                        return l;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(coordinator, (Function1) rememberedValue, startRestartGroup, (i2 >> 3) & 14);
            startRestartGroup.startReplaceGroup(-1633490746);
            int i5 = i2 & 14;
            if (i5 == 4) {
                z2 = true;
            }
            boolean changedInstance2 = startRestartGroup.changedInstance(coordinator) | z2;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new StoryPageChangeObserverKt$StoryPolarisTimerObserver$3$1(lazyListState, coordinator, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(lazyListState, coordinator, (Function2) rememberedValue2, startRestartGroup, i5 | (i2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = StoryPageChangeObserverKt.m(lazyListState, coordinator, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }

    public static final void e(final LazyListState lazyListState, final KmpStoryClient storyClient, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        Object[] objArr;
        List<kp4.b> list;
        List<yo4.c> list2;
        boolean z3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(storyClient, "storyClient");
        Composer startRestartGroup = composer.startRestartGroup(1330006171);
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
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1330006171, i2, -1, "com.dragon.read.kmp.story.impl.feeds.observer.StoryPageChangeObserver (StoryPageChangeObserver.kt:29)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(-1, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(-1, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            List<yo4.c> d = storyClient.e.d();
            List<kp4.b> j = storyClient.j();
            Object[] objArr2 = {lazyListState, d, j, storyClient};
            startRestartGroup.startReplaceGroup(-1224400529);
            int i6 = i2 & 14;
            if (i6 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean changedInstance = z2 | startRestartGroup.changedInstance(d) | startRestartGroup.changedInstance(storyClient) | startRestartGroup.changedInstance(j) | startRestartGroup.changedInstance(storyClient);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changedInstance && rememberedValue3 != companion.getEmpty()) {
                i3 = i6;
                objArr = objArr2;
                list = j;
                list2 = d;
            } else {
                i3 = i6;
                objArr = objArr2;
                list = j;
                list2 = d;
                StoryPageChangeObserverKt$StoryPageChangeObserver$1$1 storyPageChangeObserverKt$StoryPageChangeObserver$1$1 = new StoryPageChangeObserverKt$StoryPageChangeObserver$1$1(lazyListState, d, storyClient, j, storyClient, mutableState, null);
                startRestartGroup.updateRememberedValue(storyPageChangeObserverKt$StoryPageChangeObserver$1$1);
                rememberedValue3 = storyPageChangeObserverKt$StoryPageChangeObserver$1$1;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(objArr, (Function2) rememberedValue3, startRestartGroup, 0);
            List<yo4.c> list3 = list2;
            List<kp4.b> list4 = list;
            Object[] objArr3 = {lazyListState, list3, list4, storyClient};
            startRestartGroup.startReplaceGroup(-1224400529);
            if (i3 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean changedInstance2 = startRestartGroup.changedInstance(list3) | z3 | startRestartGroup.changedInstance(storyClient) | startRestartGroup.changedInstance(list4) | startRestartGroup.changedInstance(storyClient);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == companion.getEmpty()) {
                StoryPageChangeObserverKt$StoryPageChangeObserver$2$1 storyPageChangeObserverKt$StoryPageChangeObserver$2$1 = new StoryPageChangeObserverKt$StoryPageChangeObserver$2$1(lazyListState, list3, storyClient, list4, storyClient, mutableState2, null);
                startRestartGroup.updateRememberedValue(storyPageChangeObserverKt$StoryPageChangeObserver$2$1);
                rememberedValue4 = storyPageChangeObserverKt$StoryPageChangeObserver$2$1;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(objArr3, (Function2) rememberedValue4, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j2;
                    j2 = StoryPageChangeObserverKt.j(lazyListState, storyClient, i, (Composer) obj, ((Integer) obj2).intValue());
                    return j2;
                }
            });
        }
    }
}
