package com.dragon.read.kmp.share.manger;

import com.bytedance.kmp.reading.model.cb0;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.internal.a1;
import kotlinx.serialization.internal.v2;

@DebugMetadata(c = "com.dragon.read.kmp.share.manger.KmpShareManger$updateShareConfigInMMKV$1", f = "KmpShareManger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpShareManger$updateShareConfigInMMKV$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, cb0> $shareChannelConfig;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpShareManger$updateShareConfigInMMKV$1(Map<String, cb0> map, Continuation<? super KmpShareManger$updateShareConfigInMMKV$1> continuation) {
        super(1, continuation);
        this.$shareChannelConfig = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new KmpShareManger$updateShareConfigInMMKV$1(this.$shareChannelConfig, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((KmpShareManger$updateShareConfigInMMKV$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String a;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            xn0.b a2 = xn0.c.a("KEY_UG_SHARE_CONFIG");
            com.dragon.read.kmp.utils.v vVar = com.dragon.read.kmp.utils.v.a;
            Map<String, cb0> map = this.$shareChannelConfig;
            if (map == null) {
                a = "";
            } else {
                gn6.a c = com.dragon.read.kmp.base.h.c();
                c.getSerializersModule();
                a = c.a(new a1(v2.a, cb0.Companion.serializer()), map);
            }
            a2.storeString("KEY_UG_SHARE_CHANNEL_CONFIG", a);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
