package com.dragon.read.kmp.reader.state;

import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.state.BookCoverViewModelKt$rememberBookCoverState$1$1", f = "BookCoverViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookCoverViewModelKt$rememberBookCoverState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReaderBgColorType $bgType;
    final /* synthetic */ int $theme;
    final /* synthetic */ b $vm;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookCoverViewModelKt$rememberBookCoverState$1$1(b bVar, int i, ReaderBgColorType readerBgColorType, Continuation<? super BookCoverViewModelKt$rememberBookCoverState$1$1> continuation) {
        super(2, continuation);
        this.$vm = bVar;
        this.$theme = i;
        this.$bgType = readerBgColorType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookCoverViewModelKt$rememberBookCoverState$1$1(this.$vm, this.$theme, this.$bgType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookCoverViewModelKt$rememberBookCoverState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$vm.I0(this.$theme, this.$bgType);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
