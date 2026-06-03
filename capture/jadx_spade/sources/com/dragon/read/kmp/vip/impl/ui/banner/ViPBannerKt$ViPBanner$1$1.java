package com.dragon.read.kmp.vip.impl.ui.banner;

import an4.e;
import androidx.compose.runtime.MutableState;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.service.c0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.vip.impl.ui.banner.ViPBannerKt$ViPBanner$1$1", f = "ViPBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ViPBannerKt$ViPBanner$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callback;
    final /* synthetic */ MutableState<e> $vipInfo$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViPBannerKt$ViPBanner$1$1(a aVar, MutableState<e> mutableState, Continuation<? super ViPBannerKt$ViPBanner$1$1> continuation) {
        super(2, continuation);
        this.$vipInfo$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ViPBannerKt$ViPBanner$1$1(null, this.$vipInfo$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ViPBannerKt$ViPBanner$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                b.b(this.$vipInfo$delegate, gq4.b.a.a());
                c0.a.G8(null);
            } catch (Exception e) {
                j.a.b("ViPBanner", "Error initializing VipInfo", e);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
