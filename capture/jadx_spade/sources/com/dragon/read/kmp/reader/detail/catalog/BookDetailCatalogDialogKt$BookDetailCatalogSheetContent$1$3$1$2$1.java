package com.dragon.read.kmp.reader.detail.catalog;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.catalog.BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1", f = "BookDetailCatalogDialog.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ MutableState<Integer> $savedIndex$delegate;
    final /* synthetic */ MutableState<Integer> $savedOffset$delegate;
    final /* synthetic */ s $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1(s sVar, LazyListState lazyListState, MutableState<Integer> mutableState, MutableState<Integer> mutableState2, Continuation<? super BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1> continuation) {
        super(2, continuation);
        this.$state = sVar;
        this.$listState = lazyListState;
        this.$savedIndex$delegate = mutableState;
        this.$savedOffset$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1(this.$state, this.$listState, this.$savedIndex$delegate, this.$savedOffset$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3.j(this.$savedIndex$delegate, 0);
            BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3.m(this.$savedOffset$delegate, 0);
            if (!this.$state.c.isEmpty()) {
                LazyListState lazyListState = this.$listState;
                this.label = 1;
                if (LazyListState.E(lazyListState, 0, 0, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
