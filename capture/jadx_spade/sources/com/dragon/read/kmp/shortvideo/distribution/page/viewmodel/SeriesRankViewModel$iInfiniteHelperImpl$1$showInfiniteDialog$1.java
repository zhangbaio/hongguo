package com.dragon.read.kmp.shortvideo.distribution.page.viewmodel;

import androidx.compose.material.n2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel$iInfiniteHelperImpl$1$showInfiniteDialog$1", f = "SeriesRankViewModel.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesRankViewModel$iInfiniteHelperImpl$1$showInfiniteDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SeriesRankViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesRankViewModel$iInfiniteHelperImpl$1$showInfiniteDialog$1(SeriesRankViewModel seriesRankViewModel, Continuation<? super SeriesRankViewModel$iInfiniteHelperImpl$1$showInfiniteDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = seriesRankViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesRankViewModel$iInfiniteHelperImpl$1$showInfiniteDialog$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesRankViewModel$iInfiniteHelperImpl$1$showInfiniteDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            n2 n2Var = this.this$0.l;
            if (n2Var != null) {
                this.label = 1;
                if (n2Var.n(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
