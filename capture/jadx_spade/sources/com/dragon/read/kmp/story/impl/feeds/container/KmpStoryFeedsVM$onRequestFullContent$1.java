package com.dragon.read.kmp.story.impl.feeds.container;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM", f = "KmpStoryFeedsVM.kt", i = {0, 0}, l = {792}, m = "onRequestFullContent", n = {"story", "$this$onRequestFullContent_u24lambda_u2420"}, s = {"L$0", "L$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$onRequestFullContent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$onRequestFullContent$1(KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super KmpStoryFeedsVM$onRequestFullContent$1> continuation) {
        super(continuation);
        this.this$0 = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object D1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        D1 = this.this$0.D1(null, this);
        return D1;
    }
}
