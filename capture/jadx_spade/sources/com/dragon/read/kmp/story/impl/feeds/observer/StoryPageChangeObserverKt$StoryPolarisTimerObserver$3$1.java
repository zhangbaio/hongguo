package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator;
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

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.observer.StoryPageChangeObserverKt$StoryPolarisTimerObserver$3$1", f = "StoryPageChangeObserver.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryPageChangeObserverKt$StoryPolarisTimerObserver$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KmpStoryPolarisTaskCoordinator $coordinator;
    final /* synthetic */ LazyListState $lazyListState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryPageChangeObserverKt$StoryPolarisTimerObserver$3$1(LazyListState lazyListState, KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator, Continuation<? super StoryPageChangeObserverKt$StoryPolarisTimerObserver$3$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$coordinator = kmpStoryPolarisTaskCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryPageChangeObserverKt$StoryPolarisTimerObserver$3$1(this.$lazyListState, this.$coordinator, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryPageChangeObserverKt$StoryPolarisTimerObserver$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean b;
                    b = lazyListState.b();
                    return Boolean.valueOf(b);
                }
            }));
            a aVar = new a(this.$coordinator);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ KmpStoryPolarisTaskCoordinator a;

        a(KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator) {
            this.a = kmpStoryPolarisTaskCoordinator;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            if (z) {
                this.a.p();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }
    }
}
