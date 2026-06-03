package com.dragon.read.kmp.reader.detail.repo;

import com.bytedance.kmp.reading.model.t3;
import com.dragon.read.kmp.reader.detail.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$2$bookDetailDeferred$1", f = "BookDetailRepository.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailRepository$load$2$bookDetailDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends t3>>, Object> {
    final /* synthetic */ d $args;
    int label;
    final /* synthetic */ BookDetailRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailRepository$load$2$bookDetailDeferred$1(BookDetailRepository bookDetailRepository, d dVar, Continuation<? super BookDetailRepository$load$2$bookDetailDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = bookDetailRepository;
        this.$args = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailRepository$load$2$bookDetailDeferred$1(this.this$0, this.$args, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends t3>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<t3>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<t3>> continuation) {
        return ((BookDetailRepository$load$2$bookDetailDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object o;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                o = ((Result) obj).m782unboximpl();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            BookDetailRepository bookDetailRepository = this.this$0;
            d dVar = this.$args;
            this.label = 1;
            o = bookDetailRepository.o(dVar, this);
            if (o == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m772boximpl(o);
    }
}
