package com.dragon.read.kmp.story.impl.widget;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.widget.LazyColumnScrollbarKt$StoryFeedsScrollbar$onDragDelta$2$1$1", f = "LazyColumnScrollbar.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class LazyColumnScrollbarKt$StoryFeedsScrollbar$onDragDelta$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ int $targetIndex;
    final /* synthetic */ int $targetScrollOffset;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyColumnScrollbarKt$StoryFeedsScrollbar$onDragDelta$2$1$1(LazyListState lazyListState, int i, int i2, Continuation<? super LazyColumnScrollbarKt$StoryFeedsScrollbar$onDragDelta$2$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$targetIndex = i;
        this.$targetScrollOffset = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyColumnScrollbarKt$StoryFeedsScrollbar$onDragDelta$2$1$1(this.$listState, this.$targetIndex, this.$targetScrollOffset, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyColumnScrollbarKt$StoryFeedsScrollbar$onDragDelta$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            LazyListState lazyListState = this.$listState;
            int i2 = this.$targetIndex;
            int i3 = this.$targetScrollOffset;
            this.label = 1;
            if (lazyListState.D(i2, i3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
