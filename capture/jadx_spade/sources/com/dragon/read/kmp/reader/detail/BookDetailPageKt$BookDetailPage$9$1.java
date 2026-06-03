package com.dragon.read.kmp.reader.detail;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailPageKt$BookDetailPage$9$1", f = "BookDetailPage.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailPageKt$BookDetailPage$9$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ androidx.compose.runtime.snapshots.e0<Integer, Integer> $itemSizeCache;
    final /* synthetic */ LazyListState $scrollState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailPageKt$BookDetailPage$9$1(LazyListState lazyListState, androidx.compose.runtime.snapshots.e0<Integer, Integer> e0Var, Continuation<? super BookDetailPageKt$BookDetailPage$9$1> continuation) {
        super(2, continuation);
        this.$scrollState = lazyListState;
        this.$itemSizeCache = e0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailPageKt$BookDetailPage$9$1(this.$scrollState, this.$itemSizeCache, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailPageKt$BookDetailPage$9$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$1(LazyListState lazyListState) {
        List<androidx.compose.foundation.lazy.o> h = lazyListState.x().h();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(h, 10));
        for (androidx.compose.foundation.lazy.o oVar : h) {
            arrayList.add(TuplesKt.to(Integer.valueOf(oVar.getIndex()), Integer.valueOf(oVar.getSize())));
        }
        return arrayList;
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
            final LazyListState lazyListState = this.$scrollState;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.reader.detail.m2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = BookDetailPageKt$BookDetailPage$9$1.invokeSuspend$lambda$1(lazyListState);
                    return invokeSuspend$lambda$1;
                }
            });
            a aVar = new a(this.$itemSizeCache);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ androidx.compose.runtime.snapshots.e0<Integer, Integer> a;

        a(androidx.compose.runtime.snapshots.e0<Integer, Integer> e0Var) {
            this.a = e0Var;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(List<Pair<Integer, Integer>> list, Continuation<? super Unit> continuation) {
            for (Pair<Integer, Integer> pair : list) {
                int intValue = pair.component1().intValue();
                int intValue2 = pair.component2().intValue();
                if (intValue <= 30 && intValue2 > 0) {
                    this.a.put(Boxing.boxInt(intValue), Boxing.boxInt(intValue2));
                }
            }
            return Unit.INSTANCE;
        }
    }
}
