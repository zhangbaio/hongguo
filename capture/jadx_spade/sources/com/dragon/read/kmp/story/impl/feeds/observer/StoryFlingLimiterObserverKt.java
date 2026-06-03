package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.service.d1;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryFlingLimiterObserverKt {
    static {
        Covode.recordClassIndex(609312);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(String str, np4.c titlePage) {
        Intrinsics.checkNotNullParameter(titlePage, "titlePage");
        return !Intrinsics.areEqual(titlePage.c(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<androidx.compose.foundation.lazy.o, np4.c> f(List<? extends yo4.c> list, LazyListState lazyListState, Function1<? super np4.c, Boolean> function1) {
        Pair<androidx.compose.foundation.lazy.o, np4.c> pair;
        Iterator it2 = lazyListState.x().h().iterator();
        do {
            pair = null;
            if (!it2.hasNext()) {
                break;
            }
            androidx.compose.foundation.lazy.o oVar = (androidx.compose.foundation.lazy.o) it2.next();
            yo4.c cVar = (yo4.c) CollectionsKt___CollectionsKt.getOrNull(list, oVar.getIndex());
            if ((cVar instanceof np4.c) && (function1 == null || function1.invoke(cVar).booleanValue())) {
                pair = new Pair<>(oVar, cVar);
            }
        } while (pair == null);
        return pair;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(tp4.b bVar, KmpStoryClient kmpStoryClient, MutableState<String> mutableState) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("开始fling滑动 title:");
        kp4.b n = kmpStoryClient.n((String) mutableState.getValue());
        if (n != null) {
            str = n.j();
        } else {
            str = null;
        }
        sb.append(str);
        bVar.a(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(tp4.b bVar, KmpStoryClient kmpStoryClient, MutableState<String> mutableState, MutableState<Boolean> mutableState2) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("fling滑动结束 title:");
        kp4.b n = kmpStoryClient.n((String) mutableState.getValue());
        if (n != null) {
            str = n.j();
        } else {
            str = null;
        }
        sb.append(str);
        bVar.a(sb.toString());
        mutableState.setValue((Object) null);
        mutableState2.setValue(Boolean.FALSE);
    }

    public static final androidx.compose.ui.input.nestedscroll.b j(LazyListState lazyListState, KmpStoryClient storyClient, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(storyClient, "storyClient");
        composer.startReplaceGroup(1047371308);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1047371308, i, -1, "com.dragon.read.kmp.story.impl.feeds.observer.rememberStoryFlingLimiterObserver (StoryFlingLimiterObserver.kt:28)");
        }
        composer.startReplaceGroup(1849434622);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new tp4.b("StoryFlingLimiterV2");
            composer.updateRememberedValue(rememberedValue);
        }
        tp4.b bVar = (tp4.b) rememberedValue;
        composer.endReplaceGroup();
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(rememberedValue2);
        }
        CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
        composer.startReplaceGroup(1849434622);
        Object rememberedValue3 = composer.rememberedValue();
        boolean z = false;
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue3);
        }
        MutableState mutableState = (MutableState) rememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1849434622);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue4);
        }
        MutableState mutableState2 = (MutableState) rememberedValue4;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1849434622);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue5);
        }
        MutableState mutableState3 = (MutableState) rememberedValue5;
        composer.endReplaceGroup();
        int b = d1.b(b1.a.o());
        List<yo4.c> d = storyClient.e.d();
        List<kp4.b> j = storyClient.j();
        composer.startReplaceGroup(-1746271574);
        if ((((i & 14) ^ 6) > 4 && composer.changed(lazyListState)) || (i & 6) == 4) {
            z = true;
        }
        boolean changed = composer.changed(d) | z | composer.changed(j);
        Object rememberedValue6 = composer.rememberedValue();
        if (changed || rememberedValue6 == companion.getEmpty()) {
            StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1 storyFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1 = new StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1(bVar, mutableState2, storyClient, mutableState, mutableState3, coroutineScope, d, lazyListState, b);
            composer.updateRememberedValue(storyFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1);
            rememberedValue6 = storyFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1;
        }
        StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1 storyFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$12 = (StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1) rememberedValue6;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return storyFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$12;
    }

    static /* synthetic */ Pair g(List list, LazyListState lazyListState, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return f(list, lazyListState, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<yo4.c, Integer> h(int i, final String str, List<? extends yo4.c> list, LazyListState lazyListState, KmpStoryClient kmpStoryClient) {
        boolean z;
        Object lastOrNull;
        List<yo4.c> h;
        r0 = null;
        if (str == null) {
            return null;
        }
        if (i == 1) {
            Pair<androidx.compose.foundation.lazy.o, np4.c> f = f(list, lazyListState, new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean i2;
                    i2 = StoryFlingLimiterObserverKt.i(str, (np4.c) obj);
                    return Boolean.valueOf(i2);
                }
            });
            if (f == null) {
                return null;
            }
            kp4.b n = kmpStoryClient.n(f.getSecond().c());
            if (n != null && (h = n.h()) != null) {
                for (yo4.c cVar : h) {
                    if (cVar instanceof np4.c) {
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            return new Pair<>(cVar, 0);
        }
        if (g(list, lazyListState, null, 4, null) == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(kmpStoryClient.o(str));
        if (valueOf.intValue() >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        kp4.b bVar = (kp4.b) CollectionsKt___CollectionsKt.getOrNull(kmpStoryClient.j(), valueOf.intValue() - 1);
        if (bVar == null) {
            return null;
        }
        int b = d1.b(b1.a.o());
        if (bVar.m()) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) bVar.h());
            return new Pair<>(lastOrNull, Integer.valueOf(-((int) (b * 0.6f))));
        }
        for (Object obj : bVar.h()) {
            if (((yo4.c) obj) instanceof np4.c) {
                return new Pair<>(obj, 0);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
