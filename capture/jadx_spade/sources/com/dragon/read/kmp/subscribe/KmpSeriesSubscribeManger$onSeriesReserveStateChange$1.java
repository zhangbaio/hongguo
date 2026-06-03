package com.dragon.read.kmp.subscribe;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.subscribe.KmpSeriesSubscribeManger$onSeriesReserveStateChange$1", f = "KmpSeriesSubscribeManger.kt", i = {}, l = {ConstantsAPI.COMMAND_NON_TAX_PAY}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpSeriesSubscribeManger$onSeriesReserveStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Pair<String, Boolean>> $reserveStateList;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpSeriesSubscribeManger$onSeriesReserveStateChange$1(List<Pair<String, Boolean>> list, Continuation<? super KmpSeriesSubscribeManger$onSeriesReserveStateChange$1> continuation) {
        super(2, continuation);
        this.$reserveStateList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpSeriesSubscribeManger$onSeriesReserveStateChange$1(this.$reserveStateList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpSeriesSubscribeManger$onSeriesReserveStateChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            KmpSeriesSubscribeManger kmpSeriesSubscribeManger = KmpSeriesSubscribeManger.a;
            dq4.b bVar = new dq4.b();
            bVar.a = this.$reserveStateList;
            this.label = 1;
            if (kmpSeriesSubscribeManger.b(bVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
