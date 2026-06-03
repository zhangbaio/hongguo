package com.dragon.read.kmp.reader.detail.repo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.repo.BookDetailRepository", f = "BookDetailRepository.kt", i = {0}, l = {329}, m = "requestAdaptIp", n = {"bookId"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailRepository$requestAdaptIp$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BookDetailRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailRepository$requestAdaptIp$1(BookDetailRepository bookDetailRepository, Continuation<? super BookDetailRepository$requestAdaptIp$1> continuation) {
        super(continuation);
        this.this$0 = bookDetailRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m = this.this$0.m(null, this);
        return m;
    }
}
