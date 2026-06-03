package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
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

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.observer.StoryPageChangeObserverKt$StoryPageChangeObserver$1$1", f = "StoryPageChangeObserver.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryPageChangeObserverKt$StoryPageChangeObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $firstAdapterIndex$delegate;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.list.b $listStateListener;
    final /* synthetic */ List<yo4.c> $stateList;
    final /* synthetic */ KmpStoryClient $storyClient;
    final /* synthetic */ List<kp4.b> $storyList;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryPageChangeObserverKt$StoryPageChangeObserver$1$1(LazyListState lazyListState, List<yo4.c> list, KmpStoryClient kmpStoryClient, List<kp4.b> list2, com.dragon.read.kmp.story.impl.feeds.list.b bVar, MutableState<Integer> mutableState, Continuation<? super StoryPageChangeObserverKt$StoryPageChangeObserver$1$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$stateList = list;
        this.$storyClient = kmpStoryClient;
        this.$storyList = list2;
        this.$listStateListener = bVar;
        this.$firstAdapterIndex$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryPageChangeObserverKt$StoryPageChangeObserver$1$1(this.$lazyListState, this.$stateList, this.$storyClient, this.$storyList, this.$listStateListener, this.$firstAdapterIndex$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryPageChangeObserverKt$StoryPageChangeObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int u;
                    u = lazyListState.u();
                    return Integer.valueOf(u);
                }
            }));
            a aVar = new a(this.$stateList, this.$storyClient, this.$storyList, this.$listStateListener, this.$firstAdapterIndex$delegate);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ List<yo4.c> a;
        final /* synthetic */ KmpStoryClient b;
        final /* synthetic */ List<kp4.b> c;
        final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.list.b d;
        final /* synthetic */ MutableState<Integer> e;

        a(List<yo4.c> list, KmpStoryClient kmpStoryClient, List<kp4.b> list2, com.dragon.read.kmp.story.impl.feeds.list.b bVar, MutableState<Integer> mutableState) {
            this.a = list;
            this.b = kmpStoryClient;
            this.c = list2;
            this.d = bVar;
            this.e = mutableState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Number) obj).intValue(), continuation);
        }

        public final Object a(int i, Continuation<? super Unit> continuation) {
            int f;
            if (i < 0 || i >= this.a.size()) {
                StoryPageChangeObserverKt.g(this.e, -1);
                return Unit.INSTANCE;
            }
            yo4.c cVar = this.a.get(i);
            Pair<kp4.b, Integer> i2 = this.b.i(i, this.c);
            kp4.b component1 = i2.component1();
            int intValue = i2.component2().intValue();
            if (component1 != null && intValue != -1) {
                f = StoryPageChangeObserverKt.f(this.e);
                if (i != f) {
                    this.d.a(cVar, intValue, i);
                    StoryPageChangeObserverKt.g(this.e, i);
                }
            }
            return Unit.INSTANCE;
        }
    }
}
