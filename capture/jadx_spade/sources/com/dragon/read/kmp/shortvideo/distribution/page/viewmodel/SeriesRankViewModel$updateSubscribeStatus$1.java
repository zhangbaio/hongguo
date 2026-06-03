package com.dragon.read.kmp.shortvideo.distribution.page.viewmodel;

import android.content.Intent;
import com.dragon.read.kmp.utils.AppUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel$updateSubscribeStatus$1", f = "SeriesRankViewModel.kt", i = {}, l = {486}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesRankViewModel$updateSubscribeStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $jsonString;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesRankViewModel$updateSubscribeStatus$1(String str, Continuation<? super SeriesRankViewModel$updateSubscribeStatus$1> continuation) {
        super(2, continuation);
        this.$jsonString = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesRankViewModel$updateSubscribeStatus$1(this.$jsonString, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesRankViewModel$updateSubscribeStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            AppUtils appUtils = AppUtils.a;
            Intent intent = new Intent("action_subscribe_status_update");
            intent.putExtra("key_subscribe_item", this.$jsonString);
            this.label = 1;
            if (AppUtils.d(appUtils, intent, false, this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
