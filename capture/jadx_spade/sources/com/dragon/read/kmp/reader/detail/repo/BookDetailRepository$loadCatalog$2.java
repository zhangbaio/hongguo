package com.dragon.read.kmp.reader.detail.repo;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$2", f = "BookDetailRepository.kt", i = {0, 1}, l = {101, 102}, m = "invokeSuspend", n = {"progressDeferred", "catalogData"}, s = {"L$0", "L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailRepository$loadCatalog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends com.dragon.read.kmp.reader.detail.catalog.b>>, Object> {
    final /* synthetic */ String $bookId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BookDetailRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailRepository$loadCatalog$2(BookDetailRepository bookDetailRepository, String str, Continuation<? super BookDetailRepository$loadCatalog$2> continuation) {
        super(2, continuation);
        this.this$0 = bookDetailRepository;
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BookDetailRepository$loadCatalog$2 bookDetailRepository$loadCatalog$2 = new BookDetailRepository$loadCatalog$2(this.this$0, this.$bookId, continuation);
        bookDetailRepository$loadCatalog$2.L$0 = obj;
        return bookDetailRepository$loadCatalog$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends com.dragon.read.kmp.reader.detail.catalog.b>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<com.dragon.read.kmp.reader.detail.catalog.b>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<com.dragon.read.kmp.reader.detail.catalog.b>> continuation) {
        return ((BookDetailRepository$loadCatalog$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x009d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
