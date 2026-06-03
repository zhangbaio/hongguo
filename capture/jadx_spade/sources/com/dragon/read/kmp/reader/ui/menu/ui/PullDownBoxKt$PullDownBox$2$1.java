package com.dragon.read.kmp.reader.ui.menu.ui;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@DebugMetadata(c = "com.dragon.read.kmp.reader.ui.menu.ui.PullDownBoxKt$PullDownBox$2$1", f = "PullDownBox.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class PullDownBoxKt$PullDownBox$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Job> $dismiss;
    final /* synthetic */ boolean $isHeightMeasured;
    final /* synthetic */ sm4.d $params;
    final /* synthetic */ Function0<Job> $show;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PullDownBoxKt$PullDownBox$2$1(boolean z, sm4.d dVar, Function0<? extends Job> function0, Function0<? extends Job> function02, Continuation<? super PullDownBoxKt$PullDownBox$2$1> continuation) {
        super(2, continuation);
        this.$isHeightMeasured = z;
        this.$params = dVar;
        this.$show = function0;
        this.$dismiss = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullDownBoxKt$PullDownBox$2$1(this.$isHeightMeasured, this.$params, this.$show, this.$dismiss, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PullDownBoxKt$PullDownBox$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isHeightMeasured) {
                if (this.$params.f()) {
                    this.$show.invoke();
                } else {
                    this.$dismiss.invoke();
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
