package com.dragon.read.kmp.story.impl.feeds.filter;

import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.story.impl.tab.page.bookmall.f1;
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

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1", f = "KmpFeedFilterLayout.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyGridState $lazyGridState;
    final /* synthetic */ ym4.a $outerArgs;
    final /* synthetic */ String $reportType;
    final /* synthetic */ Set<String> $shownTagValueSet;
    final /* synthetic */ List<f1> $tags;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1(LazyGridState lazyGridState, List<f1> list, Set<String> set, String str, ym4.a aVar, Continuation<? super KmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1> continuation) {
        super(2, continuation);
        this.$lazyGridState = lazyGridState;
        this.$tags = list;
        this.$shownTagValueSet = set;
        this.$reportType = str;
        this.$outerArgs = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1(this.$lazyGridState, this.$tags, this.$shownTagValueSet, this.$reportType, this.$outerArgs, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$1(LazyGridState lazyGridState) {
        List h = lazyGridState.w().h();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(h, 10));
        Iterator it2 = h.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(((androidx.compose.foundation.lazy.grid.p) it2.next()).getIndex()));
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
            final LazyGridState lazyGridState = this.$lazyGridState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.t
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = KmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1.invokeSuspend$lambda$1(lazyGridState);
                    return invokeSuspend$lambda$1;
                }
            }));
            a aVar = new a(this.$tags, this.$shownTagValueSet, this.$reportType, this.$outerArgs);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ List<f1> a;
        final /* synthetic */ Set<String> b;
        final /* synthetic */ String c;
        final /* synthetic */ ym4.a d;

        a(List<f1> list, Set<String> set, String str, ym4.a aVar) {
            this.a = list;
            this.b = set;
            this.c = str;
            this.d = aVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(List<Integer> list, Continuation<? super Unit> continuation) {
            String str;
            List<f1> list2 = this.a;
            Set<String> set = this.b;
            String str2 = this.c;
            ym4.a aVar = this.d;
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                f1 f1Var = (f1) CollectionsKt___CollectionsKt.getOrNull(list2, ((Number) it2.next()).intValue());
                if (f1Var != null && (str = f1Var.c) != null && set.add(str)) {
                    new vc4.a().m(str).n(str2).h("0").j(aVar).c();
                }
            }
            return Unit.INSTANCE;
        }
    }
}
