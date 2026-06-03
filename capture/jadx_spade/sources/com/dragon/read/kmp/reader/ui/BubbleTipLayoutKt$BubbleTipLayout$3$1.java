package com.dragon.read.kmp.reader.ui;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.dragon.read.kmp.reader.ui.BubbleTipLayoutKt$BubbleTipLayout$3$1", f = "BubbleTipLayout.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BubbleTipLayoutKt$BubbleTipLayout$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $dismissBubbleTip;
    final /* synthetic */ long $duration;
    final /* synthetic */ Function0<Unit> $onShow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BubbleTipLayoutKt$BubbleTipLayout$3$1(Function0<Unit> function0, long j, Function0<Unit> function02, Continuation<? super BubbleTipLayoutKt$BubbleTipLayout$3$1> continuation) {
        super(2, continuation);
        this.$onShow = function0;
        this.$duration = j;
        this.$dismissBubbleTip = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BubbleTipLayoutKt$BubbleTipLayout$3$1(this.$onShow, this.$duration, this.$dismissBubbleTip, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BubbleTipLayoutKt$BubbleTipLayout$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            this.$onShow.invoke();
            long j = this.$duration;
            this.label = 1;
            if (DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.$dismissBubbleTip.invoke();
        return Unit.INSTANCE;
    }
}
