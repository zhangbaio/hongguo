package com.dragon.read.kmp.reader.detail.repo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.repo.BookDetailRepository", f = "BookDetailRepository.kt", i = {}, l = {250}, m = "requestCommonPlan", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailRepository$requestCommonPlan$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BookDetailRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailRepository$requestCommonPlan$1(BookDetailRepository bookDetailRepository, Continuation<? super BookDetailRepository$requestCommonPlan$1> continuation) {
        super(continuation);
        this.this$0 = bookDetailRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object q;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        q = this.this$0.q(null, this);
        return q;
    }
}
