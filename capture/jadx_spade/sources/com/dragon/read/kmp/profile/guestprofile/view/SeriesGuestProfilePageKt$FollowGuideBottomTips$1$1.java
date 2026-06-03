package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.runtime.MutableState;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt$FollowGuideBottomTips$1$1", f = "SeriesGuestProfilePage.kt", i = {}, l = {1070}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesGuestProfilePageKt$FollowGuideBottomTips$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Pair<Boolean, Integer>> $showFollowGuideBottomTipsPair$delegate;
    final /* synthetic */ GuestProfileViewModel $viewModel;
    final /* synthetic */ MutableState<Boolean> $visible$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesGuestProfilePageKt$FollowGuideBottomTips$1$1(GuestProfileViewModel guestProfileViewModel, MutableState<Pair<Boolean, Integer>> mutableState, MutableState<Boolean> mutableState2, Continuation<? super SeriesGuestProfilePageKt$FollowGuideBottomTips$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = guestProfileViewModel;
        this.$showFollowGuideBottomTipsPair$delegate = mutableState;
        this.$visible$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesGuestProfilePageKt$FollowGuideBottomTips$1$1(this.$viewModel, this.$showFollowGuideBottomTipsPair$delegate, this.$visible$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesGuestProfilePageKt$FollowGuideBottomTips$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            if (((Boolean) SeriesGuestProfilePageKt.N(this.$showFollowGuideBottomTipsPair$delegate).getFirst()).booleanValue()) {
                SeriesGuestProfilePageKt.Q(this.$visible$delegate, true);
                this.label = 1;
                if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        SeriesGuestProfilePageKt.Q(this.$visible$delegate, false);
        this.$viewModel.z.setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
