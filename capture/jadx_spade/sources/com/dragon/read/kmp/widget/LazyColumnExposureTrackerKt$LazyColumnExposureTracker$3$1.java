package com.dragon.read.kmp.widget;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
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

@DebugMetadata(c = "com.dragon.read.kmp.widget.LazyColumnExposureTrackerKt$LazyColumnExposureTracker$3$1", f = "LazyColumnExposureTracker.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class LazyColumnExposureTrackerKt$LazyColumnExposureTracker$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ MutableState<Boolean> $reachTop$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyColumnExposureTrackerKt$LazyColumnExposureTracker$3$1(LazyListState lazyListState, MutableState<Boolean> mutableState, Continuation<? super LazyColumnExposureTrackerKt$LazyColumnExposureTracker$3$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$reachTop$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyColumnExposureTrackerKt$LazyColumnExposureTracker$3$1(this.$lazyListState, this.$reachTop$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyColumnExposureTrackerKt$LazyColumnExposureTracker$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final LazyListState lazyListState = this.$lazyListState;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.widget.j1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int v;
                    v = lazyListState.v();
                    return Integer.valueOf(v);
                }
            });
            a aVar = new a(this.$lazyListState, this.$reachTop$delegate);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ LazyListState a;
        final /* synthetic */ MutableState<Boolean> b;

        a(LazyListState lazyListState, MutableState<Boolean> mutableState) {
            this.a = lazyListState;
            this.b = mutableState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Number) obj).intValue(), continuation);
        }

        public final Object a(int i, Continuation<? super Unit> continuation) {
            boolean z;
            MutableState<Boolean> mutableState = this.b;
            if (this.a.u() == 0 && this.a.v() == 0) {
                z = true;
            } else {
                z = false;
            }
            LazyColumnExposureTrackerKt.d(mutableState, z);
            return Unit.INSTANCE;
        }
    }
}
