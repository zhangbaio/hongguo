package com.dragon.read.kmp.vip.impl.ui;

import androidx.compose.runtime.z1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCouponKt$ChapterEndVipCoupon$1$1", f = "ChapterEndVipCoupon.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ChapterEndVipCouponKt$ChapterEndVipCoupon$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z1 $leftTime$delegate;
    final /* synthetic */ Function0<Unit> $timeoutCallback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChapterEndVipCouponKt$ChapterEndVipCoupon$1$1(Function0<Unit> function0, z1 z1Var, Continuation<? super ChapterEndVipCouponKt$ChapterEndVipCoupon$1$1> continuation) {
        super(2, continuation);
        this.$timeoutCallback = function0;
        this.$leftTime$delegate = z1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChapterEndVipCouponKt$ChapterEndVipCoupon$1$1(this.$timeoutCallback, this.$leftTime$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChapterEndVipCouponKt$ChapterEndVipCoupon$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003e -> B:5:0x0041). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r4 = 1
            if (r1 == 0) goto L1a
            if (r1 != r4) goto L12
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            goto L41
        L12:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1a:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
        L1e:
            androidx.compose.runtime.z1 r1 = r10.$leftTime$delegate
            long r5 = com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCouponKt.f(r1)
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 <= 0) goto L51
            androidx.compose.runtime.z1 r1 = r10.$leftTime$delegate
            long r5 = com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCouponKt.f(r1)
            androidx.compose.runtime.z1 r1 = r10.$leftTime$delegate
            r7 = -1
            long r5 = r5 + r7
            com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCouponKt.g(r1, r5)
            r10.label = r4
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r5, r10)
            if (r1 != r0) goto L41
            return r0
        L41:
            androidx.compose.runtime.z1 r1 = r10.$leftTime$delegate
            long r5 = com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCouponKt.f(r1)
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 > 0) goto L1e
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r10.$timeoutCallback
            r1.invoke()
            goto L1e
        L51:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCouponKt$ChapterEndVipCoupon$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
