package com.dragon.read.kmp.mine.preference.viewmodel;

import com.bytedance.kmp.reading.model.xa0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel$savePreferenceData$1$1$setProfileResponse$1", f = "WatchPreferenceViewModel.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class WatchPreferenceViewModel$savePreferenceData$1$1$setProfileResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super xa0>, Object> {
    int label;
    final /* synthetic */ WatchPreferenceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchPreferenceViewModel$savePreferenceData$1$1$setProfileResponse$1(WatchPreferenceViewModel watchPreferenceViewModel, Continuation<? super WatchPreferenceViewModel$savePreferenceData$1$1$setProfileResponse$1> continuation) {
        super(2, continuation);
        this.this$0 = watchPreferenceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchPreferenceViewModel$savePreferenceData$1$1$setProfileResponse$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super xa0> continuation) {
        return ((WatchPreferenceViewModel$savePreferenceData$1$1$setProfileResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            WatchPreferenceViewModel watchPreferenceViewModel = this.this$0;
            this.label = 1;
            obj = watchPreferenceViewModel.U0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
