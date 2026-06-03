package com.dragon.read.kmp.story.impl.widget;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.widget.LazyColumnScrollbarKt$StoryFeedsScrollbar$1$1", f = "LazyColumnScrollbar.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class LazyColumnScrollbarKt$StoryFeedsScrollbar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isDragging$delegate;
    final /* synthetic */ MutableState<Boolean> $isSelected$delegate;
    final /* synthetic */ MutableState<Boolean> $isVisible$delegate;
    final /* synthetic */ LazyListState $listState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyColumnScrollbarKt$StoryFeedsScrollbar$1$1(LazyListState lazyListState, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super LazyColumnScrollbarKt$StoryFeedsScrollbar$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$isDragging$delegate = mutableState;
        this.$isSelected$delegate = mutableState2;
        this.$isVisible$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyColumnScrollbarKt$StoryFeedsScrollbar$1$1(this.$listState, this.$isDragging$delegate, this.$isSelected$delegate, this.$isVisible$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyColumnScrollbarKt$StoryFeedsScrollbar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean C;
        boolean j;
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
            if (!this.$listState.b()) {
                C = LazyColumnScrollbarKt.C(this.$isDragging$delegate);
                if (!C) {
                    j = LazyColumnScrollbarKt.j(this.$isSelected$delegate);
                    if (!j) {
                        this.label = 1;
                        if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            LazyColumnScrollbarKt.I(this.$isVisible$delegate, true);
            return Unit.INSTANCE;
        }
        LazyColumnScrollbarKt.I(this.$isVisible$delegate, false);
        return Unit.INSTANCE;
    }
}
