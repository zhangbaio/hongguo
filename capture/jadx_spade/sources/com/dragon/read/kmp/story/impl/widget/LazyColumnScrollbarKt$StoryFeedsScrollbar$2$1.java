package com.dragon.read.kmp.story.impl.widget;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.widget.LazyColumnScrollbarKt$StoryFeedsScrollbar$2$1", f = "LazyColumnScrollbar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class LazyColumnScrollbarKt$StoryFeedsScrollbar$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d0.a $haptic;
    final /* synthetic */ MutableState<Boolean> $isSelected$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyColumnScrollbarKt$StoryFeedsScrollbar$2$1(d0.a aVar, MutableState<Boolean> mutableState, Continuation<? super LazyColumnScrollbarKt$StoryFeedsScrollbar$2$1> continuation) {
        super(2, continuation);
        this.$haptic = aVar;
        this.$isSelected$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyColumnScrollbarKt$StoryFeedsScrollbar$2$1(this.$haptic, this.$isSelected$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyColumnScrollbarKt$StoryFeedsScrollbar$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean j;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            j = LazyColumnScrollbarKt.j(this.$isSelected$delegate);
            if (j) {
                this.$haptic.a(d0.b.a.f());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
