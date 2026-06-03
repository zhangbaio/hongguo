package com.dragon.read.kmp.reader.bookcover.epub;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
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

@DebugMetadata(c = "com.dragon.read.kmp.reader.bookcover.epub.HotlinePagerKt$HotlinePager$2$1", f = "HotlinePager.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class HotlinePagerKt$HotlinePager$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.dragon.read.kmp.reader.state.i> $hotlines;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ Set<String> $seenIds;
    final /* synthetic */ com.dragon.read.kmp.reader.state.a $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HotlinePagerKt$HotlinePager$2$1(LazyListState lazyListState, List<com.dragon.read.kmp.reader.state.i> list, Set<String> set, com.dragon.read.kmp.reader.state.a aVar, Continuation<? super HotlinePagerKt$HotlinePager$2$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$hotlines = list;
        this.$seenIds = set;
        this.$state = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotlinePagerKt$HotlinePager$2$1(this.$listState, this.$hotlines, this.$seenIds, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HotlinePagerKt$HotlinePager$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$1(LazyListState lazyListState) {
        List h = lazyListState.x().h();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(h, 10));
        Iterator it2 = h.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(((androidx.compose.foundation.lazy.o) it2.next()).getIndex()));
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
            final LazyListState lazyListState = this.$listState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.r0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = HotlinePagerKt$HotlinePager$2$1.invokeSuspend$lambda$1(lazyListState);
                    return invokeSuspend$lambda$1;
                }
            }));
            a aVar = new a(this.$hotlines, this.$seenIds, this.$state);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ List<com.dragon.read.kmp.reader.state.i> a;
        final /* synthetic */ Set<String> b;
        final /* synthetic */ com.dragon.read.kmp.reader.state.a c;

        a(List<com.dragon.read.kmp.reader.state.i> list, Set<String> set, com.dragon.read.kmp.reader.state.a aVar) {
            this.a = list;
            this.b = set;
            this.c = aVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(List<Integer> list, Continuation<? super Unit> continuation) {
            List<com.dragon.read.kmp.reader.state.i> list2 = this.a;
            Set<String> set = this.b;
            com.dragon.read.kmp.reader.state.a aVar = this.c;
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue = ((Number) it2.next()).intValue();
                com.dragon.read.kmp.reader.state.i iVar = (com.dragon.read.kmp.reader.state.i) CollectionsKt___CollectionsKt.getOrNull(list2, intValue);
                if (iVar != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(iVar.p);
                    sb.append('_');
                    sb.append(iVar.o);
                    if (set.add(sb.toString())) {
                        s0.e(s0.a, aVar.a, String.valueOf(iVar.p), String.valueOf(iVar.o), null, null, intValue, 24, null);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
