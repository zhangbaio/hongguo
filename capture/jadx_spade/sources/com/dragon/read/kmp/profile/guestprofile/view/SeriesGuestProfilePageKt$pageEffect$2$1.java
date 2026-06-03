package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.pager.PagerState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt$pageEffect$2$1", f = "SeriesGuestProfilePage.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesGuestProfilePageKt$pageEffect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ Integer $targetIndex;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesGuestProfilePageKt$pageEffect$2$1(PagerState pagerState, Integer num, Continuation<? super SeriesGuestProfilePageKt$pageEffect$2$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$targetIndex = num;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesGuestProfilePageKt$pageEffect$2$1(this.$pagerState, this.$targetIndex, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesGuestProfilePageKt$pageEffect$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IntRange until;
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
            until = RangesKt___RangesKt.until(0, this.$pagerState.z());
            if (until.contains(this.$targetIndex.intValue())) {
                int u = this.$pagerState.u();
                Integer num = this.$targetIndex;
                if (num == null || u != num.intValue()) {
                    PagerState pagerState = this.$pagerState;
                    int intValue = this.$targetIndex.intValue();
                    this.label = 1;
                    if (PagerState.U(pagerState, intValue, 0.0f, this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
