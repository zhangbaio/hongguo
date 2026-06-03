package com.dragon.read.kmp.reader.detail;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailModulesKt$MetaRankItem$1$1", f = "BookDetailModules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailModulesKt$MetaRankItem$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bookId;
    final /* synthetic */ p2 $detailReporter;
    final /* synthetic */ MutableState<Boolean> $hasReportedShow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailModulesKt$MetaRankItem$1$1(MutableState<Boolean> mutableState, p2 p2Var, String str, Continuation<? super BookDetailModulesKt$MetaRankItem$1$1> continuation) {
        super(2, continuation);
        this.$hasReportedShow = mutableState;
        this.$detailReporter = p2Var;
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailModulesKt$MetaRankItem$1$1(this.$hasReportedShow, this.$detailReporter, this.$bookId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailModulesKt$MetaRankItem$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (((Boolean) this.$hasReportedShow.getValue()).booleanValue()) {
                return Unit.INSTANCE;
            }
            this.$hasReportedShow.setValue(Boxing.boxBoolean(true));
            this.$detailReporter.o(this.$bookId);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
