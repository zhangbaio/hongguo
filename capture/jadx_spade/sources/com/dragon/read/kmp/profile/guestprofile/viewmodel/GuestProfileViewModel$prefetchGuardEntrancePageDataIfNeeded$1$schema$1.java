package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import com.bytedance.kmp.reading.model.eo;
import com.bytedance.kmp.reading.model.l10;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonObject;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1$schema$1", f = "GuestProfileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1$schema$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ eo $latestProfileData;
    final /* synthetic */ JsonObject $response;
    final /* synthetic */ long $taskPrefetchTimestamp;
    int label;
    final /* synthetic */ GuestProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1$schema$1(GuestProfileViewModel guestProfileViewModel, eo eoVar, JsonObject jsonObject, long j, Continuation<? super GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1$schema$1> continuation) {
        super(2, continuation);
        this.this$0 = guestProfileViewModel;
        this.$latestProfileData = eoVar;
        this.$response = jsonObject;
        this.$taskPrefetchTimestamp = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1$schema$1(this.this$0, this.$latestProfileData, this.$response, this.$taskPrefetchTimestamp, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1$schema$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String P;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GuestProfileViewModel guestProfileViewModel = this.this$0;
            l10 l10Var = this.$latestProfileData.i;
            if (l10Var != null) {
                str = l10Var.d;
            } else {
                str = null;
            }
            P = guestProfileViewModel.P(str, this.$response, this.$taskPrefetchTimestamp);
            return P;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
