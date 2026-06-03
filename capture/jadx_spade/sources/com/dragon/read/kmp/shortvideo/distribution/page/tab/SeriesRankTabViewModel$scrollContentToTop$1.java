package com.dragon.read.kmp.shortvideo.distribution.page.tab;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabViewModel$scrollContentToTop$1", f = "SeriesRankTabViewModel.kt", i = {}, l = {469}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesRankTabViewModel$scrollContentToTop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SeriesRankTabViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesRankTabViewModel$scrollContentToTop$1(SeriesRankTabViewModel seriesRankTabViewModel, Continuation<? super SeriesRankTabViewModel$scrollContentToTop$1> continuation) {
        super(2, continuation);
        this.this$0 = seriesRankTabViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesRankTabViewModel$scrollContentToTop$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesRankTabViewModel$scrollContentToTop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i;
        LazyListState lazyListState;
        androidx.compose.foundation.lazy.x x;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            LazyListState lazyListState2 = this.this$0.A;
            if (lazyListState2 != null && (x = lazyListState2.x()) != null) {
                i = x.f();
            } else {
                i = 0;
            }
            if (i > 0 && (lazyListState = this.this$0.A) != null) {
                this.label = 1;
                if (LazyListState.E(lazyListState, 0, 0, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
