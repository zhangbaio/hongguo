package com.dragon.read.kmp.profile.guestprofile;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.GuestProfileStarFansRewardUseCase", f = "GuestProfileStarFansRewardUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG, ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY, ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW, 43}, m = "invoke", n = {"userId", "actorUid", "starFansService", "userId", "actorUid", "starFansService", "requestSucceededTasks", "userId", "actorUid", "starFansService", "requestSucceededTasks", "actionCompletedTasks", "userId", "actorUid", "starFansService", "allSucceededTasks", "task"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$5"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileStarFansRewardUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuestProfileStarFansRewardUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileStarFansRewardUseCase$invoke$1(GuestProfileStarFansRewardUseCase guestProfileStarFansRewardUseCase, Continuation<? super GuestProfileStarFansRewardUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = guestProfileStarFansRewardUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
