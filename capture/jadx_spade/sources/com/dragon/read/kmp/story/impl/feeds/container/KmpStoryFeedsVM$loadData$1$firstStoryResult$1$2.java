package com.dragon.read.kmp.story.impl.feeds.container;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadData$1$firstStoryResult$1$2", f = "KmpStoryFeedsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$loadData$1$firstStoryResult$1$2 extends SuspendLambda implements Function2<m<kp4.b>, Continuation<? super m<kp4.b>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$loadData$1$firstStoryResult$1$2(KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super KmpStoryFeedsVM$loadData$1$firstStoryResult$1$2> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KmpStoryFeedsVM$loadData$1$firstStoryResult$1$2 kmpStoryFeedsVM$loadData$1$firstStoryResult$1$2 = new KmpStoryFeedsVM$loadData$1$firstStoryResult$1$2(this.this$0, continuation);
        kmpStoryFeedsVM$loadData$1$firstStoryResult$1$2.L$0 = obj;
        return kmpStoryFeedsVM$loadData$1$firstStoryResult$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m<kp4.b> mVar, Continuation<? super m<kp4.b>> continuation) {
        return ((KmpStoryFeedsVM$loadData$1$firstStoryResult$1$2) create(mVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        tp4.b bVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            m mVar = (m) this.L$0;
            bVar = this.this$0.e;
            bVar.d("loadData network return first");
            return mVar;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
