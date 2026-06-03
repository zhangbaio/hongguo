package com.dragon.read.kmp.story.impl.feeds.container;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM", f = "KmpStoryFeedsVM.kt", i = {0}, l = {599}, m = "onLoadMoreData-IoAF18A", n = {"$this$onLoadMoreData_IoAF18A_u24lambda_u2417"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$onLoadMoreData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$onLoadMoreData$1(KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super KmpStoryFeedsVM$onLoadMoreData$1> continuation) {
        super(continuation);
        this.this$0 = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object B1;
        Object coroutine_suspended;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        B1 = this.this$0.B1(this);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return B1 == coroutine_suspended ? B1 : Result.m772boximpl(B1);
    }
}
