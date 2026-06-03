package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.runtime.MutableState;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt$FollowGuideBottomTips$2$1", f = "SeriesGuestProfilePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesGuestProfilePageKt$FollowGuideBottomTips$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<com.dragon.read.kmp.profile.guestprofile.viewmodel.g0> $userRelation$delegate;
    final /* synthetic */ GuestProfileViewModel $viewModel;
    final /* synthetic */ MutableState<Boolean> $visible$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesGuestProfilePageKt$FollowGuideBottomTips$2$1(GuestProfileViewModel guestProfileViewModel, MutableState<com.dragon.read.kmp.profile.guestprofile.viewmodel.g0> mutableState, MutableState<Boolean> mutableState2, Continuation<? super SeriesGuestProfilePageKt$FollowGuideBottomTips$2$1> continuation) {
        super(2, continuation);
        this.$viewModel = guestProfileViewModel;
        this.$userRelation$delegate = mutableState;
        this.$visible$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesGuestProfilePageKt$FollowGuideBottomTips$2$1(this.$viewModel, this.$userRelation$delegate, this.$visible$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesGuestProfilePageKt$FollowGuideBottomTips$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 R;
        boolean z;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            R = SeriesGuestProfilePageKt.R(this.$userRelation$delegate);
            if (R != null && !com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.c(R)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                SeriesGuestProfilePageKt.Q(this.$visible$delegate, false);
                this.$viewModel.z.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
