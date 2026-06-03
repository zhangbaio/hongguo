package com.dragon.read.kmp.reader.detail.viewmodel;

import com.dragon.read.kmp.reader.detail.d;
import com.dragon.read.kmp.reader.detail.repo.BookDetailRepository;
import com.dragon.read.kmp.reader.detail.repo.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel$load$1$result$1", f = "BookDetailViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailViewModel$load$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends b>>, Object> {
    final /* synthetic */ d $args;
    int label;
    final /* synthetic */ BookDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailViewModel$load$1$result$1(BookDetailViewModel bookDetailViewModel, d dVar, Continuation<? super BookDetailViewModel$load$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = bookDetailViewModel;
        this.$args = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailViewModel$load$1$result$1(this.this$0, this.$args, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends b>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<b>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<b>> continuation) {
        return ((BookDetailViewModel$load$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        BookDetailRepository bookDetailRepository;
        Object k;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                k = ((Result) obj).m782unboximpl();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            bookDetailRepository = this.this$0.e;
            d dVar = this.$args;
            this.label = 1;
            k = bookDetailRepository.k(dVar, this);
            if (k == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m772boximpl(k);
    }
}
