package com.dragon.read.kmp.view;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel;
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

@DebugMetadata(c = "com.dragon.read.kmp.view.RelationSeriesDialogViewKt$PanelScrollEffect$1$1", f = "RelationSeriesDialogView.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class RelationSeriesDialogViewKt$PanelScrollEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyGridState;
    final /* synthetic */ RelationSeriesSingleViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RelationSeriesDialogViewKt$PanelScrollEffect$1$1(LazyListState lazyListState, RelationSeriesSingleViewModel relationSeriesSingleViewModel, Continuation<? super RelationSeriesDialogViewKt$PanelScrollEffect$1$1> continuation) {
        super(2, continuation);
        this.$lazyGridState = lazyListState;
        this.$viewModel = relationSeriesSingleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RelationSeriesDialogViewKt$PanelScrollEffect$1$1(this.$lazyGridState, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RelationSeriesDialogViewKt$PanelScrollEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final LazyListState lazyListState = this.$lazyGridState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.view.t0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Pair invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = RelationSeriesDialogViewKt$PanelScrollEffect$1$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            }));
            a aVar = new a(this.$viewModel);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ RelationSeriesSingleViewModel a;

        a(RelationSeriesSingleViewModel relationSeriesSingleViewModel) {
            this.a = relationSeriesSingleViewModel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
        
            if (r1 < 1) goto L8;
         */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(kotlin.Pair<java.lang.Integer, java.lang.Integer> r1, kotlin.coroutines.Continuation<? super kotlin.Unit> r2) {
            /*
                r0 = this;
                java.lang.Object r2 = r1.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r1 = r1.component2()
                java.lang.Number r1 = (java.lang.Number) r1
                int r1 = r1.intValue()
                if (r2 != 0) goto L1a
                r2 = 1
                if (r1 >= r2) goto L1a
                goto L1b
            L1a:
                r2 = 0
            L1b:
                com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel r1 = r0.a
                xm4.a r1 = r1.a
                r1.a(r2)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.view.RelationSeriesDialogViewKt$PanelScrollEffect$1$1.a.emit(kotlin.Pair, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
