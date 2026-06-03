package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.c2;
import androidx.compose.foundation.gestures.r2;
import androidx.compose.foundation.lazy.LazyListState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.observer.StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1$onPreScroll$1", f = "StoryFlingLimiterObserver.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1$onPreScroll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1$onPreScroll$1(LazyListState lazyListState, Continuation<? super StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1$onPreScroll$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1$onPreScroll$1(this.$lazyListState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1$onPreScroll$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.observer.StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1$onPreScroll$1$1", f = "StoryFlingLimiterObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.observer.StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1$onPreScroll$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<c2, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(c2 c2Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(c2Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
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
            LazyListState lazyListState = this.$lazyListState;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            if (r2.c(lazyListState, (MutatePriority) null, anonymousClass1, this, 1, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
