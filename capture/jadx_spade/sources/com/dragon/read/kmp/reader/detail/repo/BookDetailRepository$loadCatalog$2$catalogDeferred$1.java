package com.dragon.read.kmp.reader.detail.repo;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$2$catalogDeferred$1", f = "BookDetailRepository.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailRepository$loadCatalog$2$catalogDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends com.dragon.read.kmp.reader.detail.catalog.b>>, Object> {
    final /* synthetic */ String $bookId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BookDetailRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailRepository$loadCatalog$2$catalogDeferred$1(String str, BookDetailRepository bookDetailRepository, Continuation<? super BookDetailRepository$loadCatalog$2$catalogDeferred$1> continuation) {
        super(2, continuation);
        this.$bookId = str;
        this.this$0 = bookDetailRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BookDetailRepository$loadCatalog$2$catalogDeferred$1 bookDetailRepository$loadCatalog$2$catalogDeferred$1 = new BookDetailRepository$loadCatalog$2$catalogDeferred$1(this.$bookId, this.this$0, continuation);
        bookDetailRepository$loadCatalog$2$catalogDeferred$1.L$0 = obj;
        return bookDetailRepository$loadCatalog$2$catalogDeferred$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends com.dragon.read.kmp.reader.detail.catalog.b>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<com.dragon.read.kmp.reader.detail.catalog.b>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<com.dragon.read.kmp.reader.detail.catalog.b>> continuation) {
        return ((BookDetailRepository$loadCatalog$2$catalogDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab A[Catch: all -> 0x00bc, TryCatch #0 {all -> 0x00bc, blocks: (B:6:0x0015, B:8:0x0048, B:10:0x004e, B:11:0x0052, B:12:0x005b, B:14:0x0061, B:16:0x006c, B:23:0x007d, B:26:0x0085, B:28:0x00ab, B:36:0x00b1, B:50:0x002e), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$2$catalogDeferred$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
