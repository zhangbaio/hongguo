package com.dragon.read.kmp.story.impl.feeds.container;

import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.story.impl.quality.QuaTraceStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processRecommendationList$3$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$processRecommendationList$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$processRecommendationList$3$1(KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super KmpStoryFeedsVM$processRecommendationList$3$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryFeedsVM$processRecommendationList$3$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryFeedsVM$processRecommendationList$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.dragon.read.kmp.story.impl.feeds.trace.j jVar;
        com.dragon.read.kmp.story.impl.feeds.trace.j jVar2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.j1(LoadStatus.Error);
            jVar = this.this$0.w;
            jVar.b("status", Boxing.boxInt(QuaTraceStatus.FAIL.getValue()));
            jVar2 = this.this$0.w;
            jVar2.d();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
