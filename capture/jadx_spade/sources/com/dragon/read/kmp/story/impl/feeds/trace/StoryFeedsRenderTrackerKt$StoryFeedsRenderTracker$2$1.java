package com.dragon.read.kmp.story.impl.feeds.trace;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.trace.StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1", f = "StoryFeedsRenderTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $hasReported;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ Function1<String, Unit> $onFirstScreenRenderComplete;
    final /* synthetic */ String $pageName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1(LazyListState lazyListState, MutableState<Boolean> mutableState, Function1<? super String, Unit> function1, String str, Continuation<? super StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$hasReported = mutableState;
        this.$onFirstScreenRenderComplete = function1;
        this.$pageName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1(this.$listState, this.$hasReported, this.$onFirstScreenRenderComplete, this.$pageName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if ((!this.$listState.x().h().isEmpty()) && !((Boolean) this.$hasReported.getValue()).booleanValue()) {
                this.$hasReported.setValue(Boxing.boxBoolean(true));
                this.$onFirstScreenRenderComplete.invoke(this.$pageName);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
