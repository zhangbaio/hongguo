package com.dragon.read.kmp.reader.detail.catalog;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.catalog.BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$1$1", f = "BookDetailCatalogDialog.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ MutableState<Integer> $savedIndex$delegate;
    final /* synthetic */ MutableState<Integer> $savedOffset$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$1$1(LazyListState lazyListState, MutableState<Integer> mutableState, MutableState<Integer> mutableState2, Continuation<? super BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$savedIndex$delegate = mutableState;
        this.$savedOffset$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$1$1(this.$listState, this.$savedIndex$delegate, this.$savedOffset$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(LazyListState lazyListState) {
        return TuplesKt.to(Integer.valueOf(lazyListState.u()), Integer.valueOf(lazyListState.v()));
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
            final LazyListState lazyListState = this.$listState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.reader.detail.catalog.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Pair invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$1$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            }));
            a aVar = new a(this.$savedIndex$delegate, this.$savedOffset$delegate);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ MutableState<Integer> a;
        final /* synthetic */ MutableState<Integer> b;

        a(MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
            this.a = mutableState;
            this.b = mutableState2;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Pair<Integer, Integer> pair, Continuation<? super Unit> continuation) {
            int intValue = pair.component1().intValue();
            int intValue2 = pair.component2().intValue();
            BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3.j(this.a, intValue);
            BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3.m(this.b, intValue2);
            return Unit.INSTANCE;
        }
    }
}
