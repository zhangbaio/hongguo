package com.dragon.read.kmp.shortvideo.distribution.page.conent;

import androidx.compose.foundation.pager.PagerState;
import com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesTopicRankPageKt$SeriesTopicRankPage$1$1", f = "SeriesTopicRankPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesTopicRankPageKt$SeriesTopicRankPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $horizontalPagerState;
    final /* synthetic */ SeriesRankViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesTopicRankPageKt$SeriesTopicRankPage$1$1(SeriesRankViewModel seriesRankViewModel, PagerState pagerState, Continuation<? super SeriesTopicRankPageKt$SeriesTopicRankPage$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = seriesRankViewModel;
        this.$horizontalPagerState = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesTopicRankPageKt$SeriesTopicRankPage$1$1(this.$viewModel, this.$horizontalPagerState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesTopicRankPageKt$SeriesTopicRankPage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$viewModel.Y0(this.$horizontalPagerState.u());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
