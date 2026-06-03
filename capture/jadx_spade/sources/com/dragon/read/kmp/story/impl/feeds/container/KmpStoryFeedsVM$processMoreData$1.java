package com.dragon.read.kmp.story.impl.feeds.container;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM", f = "KmpStoryFeedsVM.kt", i = {0}, l = {609, 637}, m = "processMoreData", n = {"storyFeedData"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$processMoreData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$processMoreData$1(KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super KmpStoryFeedsVM$processMoreData$1> continuation) {
        super(continuation);
        this.this$0 = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object J1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        J1 = this.this$0.J1(null, this);
        return J1;
    }
}
