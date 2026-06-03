package com.dragon.read.kmp.widget.viewpager;

import androidx.compose.animation.core.i;
import androidx.compose.foundation.pager.PagerState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.widget.viewpager.CustomScrollViewPagerKt$CustomScrollViewPager$1$1$2$1$1$1$1", f = "CustomScrollViewPager.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class CustomScrollViewPagerKt$CustomScrollViewPager$1$1$2$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomScrollViewPagerKt$CustomScrollViewPager$1$1$2$1$1$1$1(PagerState pagerState, int i, Continuation<? super CustomScrollViewPagerKt$CustomScrollViewPager$1$1$2$1$1$1$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$pageIndex = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomScrollViewPagerKt$CustomScrollViewPager$1$1$2$1$1$1$1(this.$pagerState, this.$pageIndex, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomScrollViewPagerKt$CustomScrollViewPager$1$1$2$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            PagerState pagerState = this.$pagerState;
            int i2 = this.$pageIndex;
            this.label = 1;
            if (PagerState.n(pagerState, i2, 0.0f, (i) null, this, 6, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
