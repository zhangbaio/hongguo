package com.dragon.read.kmp.reader.detail;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.dragon.read.kmp.reader.detail.b;
import com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel;
import kotlin.ResultKt;
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

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailPageKt$BookDetailPage$2$1", f = "BookDetailPage.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailPageKt$BookDetailPage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $isCatalogVisibleState;
    final /* synthetic */ androidx.compose.material.n2 $sheetState;
    final /* synthetic */ BookDetailViewModel $vm;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailPageKt$BookDetailPage$2$1(androidx.compose.material.n2 n2Var, State<Boolean> state, BookDetailViewModel bookDetailViewModel, Continuation<? super BookDetailPageKt$BookDetailPage$2$1> continuation) {
        super(2, continuation);
        this.$sheetState = n2Var;
        this.$isCatalogVisibleState = state;
        this.$vm = bookDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailPageKt$BookDetailPage$2$1(this.$sheetState, this.$isCatalogVisibleState, this.$vm, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailPageKt$BookDetailPage$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final androidx.compose.material.n2 n2Var = this.$sheetState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.reader.detail.l2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean m;
                    m = n2Var.m();
                    return Boolean.valueOf(m);
                }
            }));
            a aVar = new a(this.$isCatalogVisibleState, this.$vm);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ State<Boolean> a;
        final /* synthetic */ BookDetailViewModel b;

        a(State<Boolean> state, BookDetailViewModel bookDetailViewModel) {
            this.a = state;
            this.b = bookDetailViewModel;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            if (!z && ((Boolean) this.a.getValue()).booleanValue()) {
                this.b.K0(b.f.a);
            }
            return Unit.INSTANCE;
        }
    }
}
