package com.dragon.read.kmp.reader.detail.repo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.repo.BookDetailRepository", f = "BookDetailRepository.kt", i = {}, l = {216}, m = "requestAlsoRead", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailRepository$requestAlsoRead$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BookDetailRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailRepository$requestAlsoRead$1(BookDetailRepository bookDetailRepository, Continuation<? super BookDetailRepository$requestAlsoRead$1> continuation) {
        super(continuation);
        this.this$0 = bookDetailRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(null, this);
    }
}
