package com.dragon.read.kmp.story.impl.feeds.filter;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$2$1", f = "KmpFeedFilterLayout.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $hasReportArrowShow$delegate;
    final /* synthetic */ ym4.a $reportArgs;
    final /* synthetic */ boolean $showMoreButton;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$2$1(boolean z, ym4.a aVar, MutableState<Boolean> mutableState, Continuation<? super KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$2$1> continuation) {
        super(2, continuation);
        this.$showMoreButton = z;
        this.$reportArgs = aVar;
        this.$hasReportArrowShow$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$2$1(this.$showMoreButton, this.$reportArgs, this.$hasReportArrowShow$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean I;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$showMoreButton) {
                I = KmpFeedFilterLayoutKt.I(this.$hasReportArrowShow$delegate);
                if (!I) {
                    ym4.o.a.d("filter_panel_arrow_show", this.$reportArgs);
                    KmpFeedFilterLayoutKt.J(this.$hasReportArrowShow$delegate, true);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
