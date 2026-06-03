package com.dragon.read.kmp.profile.guestprofile.view;

import com.bytedance.kmp.reading.model.ej;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.ProfileUserHeaderKt$UserNameLayout$1$1", f = "ProfileUserHeader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileUserHeaderKt$UserNameLayout$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ej $expandTextTag;
    final /* synthetic */ GuestProfileViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileUserHeaderKt$UserNameLayout$1$1(ej ejVar, GuestProfileViewModel guestProfileViewModel, Continuation<? super ProfileUserHeaderKt$UserNameLayout$1$1> continuation) {
        super(2, continuation);
        this.$expandTextTag = ejVar;
        this.$viewModel = guestProfileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileUserHeaderKt$UserNameLayout$1$1(this.$expandTextTag, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileUserHeaderKt$UserNameLayout$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ej ejVar = this.$expandTextTag;
            if (ejVar != null && (str = ejVar.b) != null) {
                GuestProfileViewModel guestProfileViewModel = this.$viewModel;
                com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
                com.dragon.read.kmp.r.v(rVar, guestProfileViewModel.r0(), str, "profile_page", rVar.e(), rVar.d(), (String) null, 32, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
