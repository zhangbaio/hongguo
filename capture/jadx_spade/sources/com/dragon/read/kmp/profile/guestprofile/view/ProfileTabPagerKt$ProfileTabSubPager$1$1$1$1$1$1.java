package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.pager.PagerState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt$ProfileTabSubPager$1$1$1$1$1$1", f = "ProfileTabPager.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileTabPagerKt$ProfileTabSubPager$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $reservationIndex;
    final /* synthetic */ PagerState $subPagerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileTabPagerKt$ProfileTabSubPager$1$1$1$1$1$1(int i, PagerState pagerState, Continuation<? super ProfileTabPagerKt$ProfileTabSubPager$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$reservationIndex = i;
        this.$subPagerState = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileTabPagerKt$ProfileTabSubPager$1$1$1$1$1$1(this.$reservationIndex, this.$subPagerState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileTabPagerKt$ProfileTabSubPager$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            int i2 = this.$reservationIndex;
            boolean z = false;
            if (i2 >= 0 && i2 < this.$subPagerState.z()) {
                z = true;
            }
            if (z) {
                PagerState pagerState = this.$subPagerState;
                int i3 = this.$reservationIndex;
                this.label = 1;
                if (PagerState.U(pagerState, i3, 0.0f, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
