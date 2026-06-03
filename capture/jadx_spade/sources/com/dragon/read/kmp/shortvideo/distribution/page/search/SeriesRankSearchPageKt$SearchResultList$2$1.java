package com.dragon.read.kmp.shortvideo.distribution.page.search;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
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

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchPageKt$SearchResultList$2$1", f = "SeriesRankSearchPage.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesRankSearchPageKt$SearchResultList$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ Function0<Unit> $onListScroll;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesRankSearchPageKt$SearchResultList$2$1(LazyListState lazyListState, Function0<Unit> function0, Continuation<? super SeriesRankSearchPageKt$SearchResultList$2$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$onListScroll = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesRankSearchPageKt$SearchResultList$2$1(this.$listState, this.$onListScroll, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesRankSearchPageKt$SearchResultList$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.q
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean b;
                    b = lazyListState.b();
                    return Boolean.valueOf(b);
                }
            });
            a aVar = new a(this.$onListScroll);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ Function0<Unit> a;

        a(Function0<Unit> function0) {
            this.a = function0;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            if (z) {
                this.a.invoke();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }
    }
}
