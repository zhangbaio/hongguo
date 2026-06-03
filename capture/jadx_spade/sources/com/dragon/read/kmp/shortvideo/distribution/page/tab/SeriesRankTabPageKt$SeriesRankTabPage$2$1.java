package com.dragon.read.kmp.shortvideo.distribution.page.tab;

import com.dragon.read.kmp.compose.common.load.LoadStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabPageKt$SeriesRankTabPage$2$1", f = "SeriesRankTabPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesRankTabPageKt$SeriesRankTabPage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoadStatus $loadState;
    final /* synthetic */ SeriesRankTabViewModel $tabViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesRankTabPageKt$SeriesRankTabPage$2$1(LoadStatus loadStatus, SeriesRankTabViewModel seriesRankTabViewModel, Continuation<? super SeriesRankTabPageKt$SeriesRankTabPage$2$1> continuation) {
        super(2, continuation);
        this.$loadState = loadStatus;
        this.$tabViewModel = seriesRankTabViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesRankTabPageKt$SeriesRankTabPage$2$1(this.$loadState, this.$tabViewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesRankTabPageKt$SeriesRankTabPage$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$loadState == LoadStatus.Content) {
                this.$tabViewModel.z0();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
