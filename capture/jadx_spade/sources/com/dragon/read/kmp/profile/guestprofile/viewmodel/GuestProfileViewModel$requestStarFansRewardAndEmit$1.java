package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import com.dragon.read.kmp.profile.guestprofile.GuestProfileStarFansRewardUseCase;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.b;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$requestStarFansRewardAndEmit$1", f = "GuestProfileViewModel.kt", i = {}, l = {1056}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileViewModel$requestStarFansRewardAndEmit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actorUid;
    final /* synthetic */ String $currentUserId;
    final /* synthetic */ String $triggerSource;
    int label;
    final /* synthetic */ GuestProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileViewModel$requestStarFansRewardAndEmit$1(GuestProfileViewModel guestProfileViewModel, String str, String str2, String str3, Continuation<? super GuestProfileViewModel$requestStarFansRewardAndEmit$1> continuation) {
        super(2, continuation);
        this.this$0 = guestProfileViewModel;
        this.$currentUserId = str;
        this.$actorUid = str2;
        this.$triggerSource = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuestProfileViewModel$requestStarFansRewardAndEmit$1(this.this$0, this.$currentUserId, this.$actorUid, this.$triggerSource, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuestProfileViewModel$requestStarFansRewardAndEmit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        GuestProfileStarFansRewardUseCase guestProfileStarFansRewardUseCase;
        MutableSharedFlow mutableSharedFlow;
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
            guestProfileStarFansRewardUseCase = this.this$0.d;
            String str = this.$currentUserId;
            String str2 = this.$actorUid;
            this.label = 1;
            obj = guestProfileStarFansRewardUseCase.a(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        com.dragon.read.kmp.profile.guestprofile.p pVar = (com.dragon.read.kmp.profile.guestprofile.p) obj;
        if (pVar == null) {
            this.this$0.b.d("starFansToast skip emit, no reward result, actorUid=" + this.$actorUid + ", triggerSource=" + this.$triggerSource);
            return Unit.INSTANCE;
        }
        this.this$0.b.d("starFansToast emit effect, actorUid=" + pVar.a + ", sum=" + pVar.b + ", triggerSource=" + this.$triggerSource);
        mutableSharedFlow = this.this$0.m;
        mutableSharedFlow.tryEmit(new b.c(pVar.a, pVar.b));
        return Unit.INSTANCE;
    }
}
