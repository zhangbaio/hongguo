package com.dragon.read.kmp.mine.sidebar;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.mine.model.j;
import com.dragon.read.kmp.mine.model.l;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
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

@DebugMetadata(c = "com.dragon.read.kmp.mine.sidebar.MineSidebarPageKt$SideBarFunctionItemGroup$1$1", f = "MineSidebarPage.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class MineSidebarPageKt$SideBarFunctionItemGroup$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<l> $itemModels;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ j $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MineSidebarPageKt$SideBarFunctionItemGroup$1$1(LazyListState lazyListState, j jVar, List<l> list, Continuation<? super MineSidebarPageKt$SideBarFunctionItemGroup$1$1> continuation) {
        super(2, continuation);
        this.$state = lazyListState;
        this.$viewModel = jVar;
        this.$itemModels = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MineSidebarPageKt$SideBarFunctionItemGroup$1$1(this.$state, this.$viewModel, this.$itemModels, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MineSidebarPageKt$SideBarFunctionItemGroup$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$0(LazyListState lazyListState) {
        return lazyListState.x().h();
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
            final LazyListState lazyListState = this.$state;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.mine.sidebar.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = MineSidebarPageKt$SideBarFunctionItemGroup$1$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            });
            a aVar = new a(this.$viewModel, this.$itemModels);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ j a;
        final /* synthetic */ List<l> b;

        a(j jVar, List<l> list) {
            this.a = jVar;
            this.b = list;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(List<? extends o> list, Continuation<? super Unit> continuation) {
            j jVar = this.a;
            if (jVar.c) {
                List<l> list2 = this.b;
                for (o oVar : list) {
                    l lVar = (l) CollectionsKt___CollectionsKt.getOrNull(list2, oVar.getIndex());
                    if (lVar != null) {
                        jVar.N0(lVar, oVar.getIndex(), true);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
