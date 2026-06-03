package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.observer.StoryTitleBarStateObserverKt$StoryTitleBarStateObserver$1$1", f = "StoryTitleBarStateObserver.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryTitleBarStateObserverKt$StoryTitleBarStateObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ KmpStoryClient $storyClient;
    final /* synthetic */ float $titleDisplayThreshold;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryTitleBarStateObserverKt$StoryTitleBarStateObserver$1$1(LazyListState lazyListState, KmpStoryClient kmpStoryClient, float f, Continuation<? super StoryTitleBarStateObserverKt$StoryTitleBarStateObserver$1$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$storyClient = kmpStoryClient;
        this.$titleDisplayThreshold = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryTitleBarStateObserverKt$StoryTitleBarStateObserver$1$1(this.$lazyListState, this.$storyClient, this.$titleDisplayThreshold, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryTitleBarStateObserverKt$StoryTitleBarStateObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(LazyListState lazyListState) {
        return TuplesKt.to(Integer.valueOf(lazyListState.u()), Integer.valueOf(lazyListState.v()));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            final LazyListState lazyListState = this.$lazyListState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.s
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Pair invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StoryTitleBarStateObserverKt$StoryTitleBarStateObserver$1$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            }));
            a aVar = new a(this.$lazyListState, this.$storyClient, this.$titleDisplayThreshold);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ LazyListState a;
        final /* synthetic */ KmpStoryClient b;
        final /* synthetic */ float c;

        a(LazyListState lazyListState, KmpStoryClient kmpStoryClient, float f) {
            this.a = lazyListState;
            this.b = kmpStoryClient;
            this.c = f;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Pair<Integer, Integer> pair, Continuation<? super Unit> continuation) {
            Object firstOrNull;
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.a.x().h());
            androidx.compose.foundation.lazy.o oVar = (androidx.compose.foundation.lazy.o) firstOrNull;
            if (oVar == null) {
                return Unit.INSTANCE;
            }
            int index = oVar.getIndex();
            List<yo4.c> d = this.b.e.d();
            if (index >= 0 && index < d.size()) {
                yo4.c cVar = d.get(index);
                KmpStoryClient kmpStoryClient = this.b;
                kp4.b component1 = kmpStoryClient.i(index, kmpStoryClient.j()).component1();
                if (component1 != null) {
                    boolean f = component1.e.f();
                    boolean z = true;
                    if (!(cVar instanceof np4.c) ? !(cVar instanceof np4.b) : oVar.getSize() + oVar.getOffset() < this.c) {
                        z = false;
                    }
                    if (f != z) {
                        component1.e.i(z);
                    }
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }
}
