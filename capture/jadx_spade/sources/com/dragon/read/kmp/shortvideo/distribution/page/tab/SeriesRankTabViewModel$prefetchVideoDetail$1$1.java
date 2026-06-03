package com.dragon.read.kmp.shortvideo.distribution.page.tab;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabViewModel$prefetchVideoDetail$1$1", f = "SeriesRankTabViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesRankTabViewModel$prefetchVideoDetail$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<io4.d> $preloadItems;
    final /* synthetic */ SeriesRankTabViewModel $this_runCatching;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SeriesRankTabViewModel$prefetchVideoDetail$1$1(SeriesRankTabViewModel seriesRankTabViewModel, List<? extends io4.d> list, Continuation<? super SeriesRankTabViewModel$prefetchVideoDetail$1$1> continuation) {
        super(2, continuation);
        this.$this_runCatching = seriesRankTabViewModel;
        this.$preloadItems = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesRankTabViewModel$prefetchVideoDetail$1$1(this.$this_runCatching, this.$preloadItems, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesRankTabViewModel$prefetchVideoDetail$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            lo4.a aVar = this.$this_runCatching.d;
            if (aVar != null) {
                aVar.i(this.$preloadItems);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
