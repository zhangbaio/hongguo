package com.dragon.read.kmp.reader.detail;

import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.State;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailPageKt$BookDetailPage$1$1", f = "BookDetailPage.kt", i = {}, l = {117, 122}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailPageKt$BookDetailPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ androidx.compose.material.n2 $sheetState;
    final /* synthetic */ State<n2> $state$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailPageKt$BookDetailPage$1$1(androidx.compose.material.n2 n2Var, State<n2> state, Continuation<? super BookDetailPageKt$BookDetailPage$1$1> continuation) {
        super(2, continuation);
        this.$sheetState = n2Var;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailPageKt$BookDetailPage$1$1(this.$sheetState, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailPageKt$BookDetailPage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        n2 l;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            l = BookDetailPageKt.l(this.$state$delegate);
            if (l.d.a) {
                androidx.compose.material.n2 n2Var = this.$sheetState;
                this.label = 1;
                if (n2Var.n(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                ModalBottomSheetValue h = this.$sheetState.h();
                ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                if (h != modalBottomSheetValue || this.$sheetState.j() != modalBottomSheetValue) {
                    androidx.compose.material.n2 n2Var2 = this.$sheetState;
                    this.label = 2;
                    if (n2Var2.l(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
