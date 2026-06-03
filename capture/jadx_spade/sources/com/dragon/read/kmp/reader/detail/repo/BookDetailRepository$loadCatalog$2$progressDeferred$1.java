package com.dragon.read.kmp.reader.detail.repo;

import com.dragon.read.kmp.progress.c;
import com.dragon.read.kmp.progress.d;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$2$progressDeferred$1", f = "BookDetailRepository.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailRepository$loadCatalog$2$progressDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends c>>, Object> {
    final /* synthetic */ String $bookId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailRepository$loadCatalog$2$progressDeferred$1(String str, Continuation<? super BookDetailRepository$loadCatalog$2$progressDeferred$1> continuation) {
        super(2, continuation);
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BookDetailRepository$loadCatalog$2$progressDeferred$1 bookDetailRepository$loadCatalog$2$progressDeferred$1 = new BookDetailRepository$loadCatalog$2$progressDeferred$1(this.$bookId, continuation);
        bookDetailRepository$loadCatalog$2$progressDeferred$1.L$0 = obj;
        return bookDetailRepository$loadCatalog$2$progressDeferred$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, ? extends c>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Map<String, c>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Map<String, c>> continuation) {
        return ((BookDetailRepository$loadCatalog$2$progressDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object m773constructorimpl;
        Map emptyMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                String str = this.$bookId;
                Result.Companion companion = Result.Companion;
                d dVar = d.a;
                this.label = 1;
                obj = dVar.a(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            m773constructorimpl = Result.m773constructorimpl((Map) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m779isFailureimpl(m773constructorimpl)) {
            m773constructorimpl = null;
        }
        Map map = (Map) m773constructorimpl;
        if (map == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return map;
    }
}
