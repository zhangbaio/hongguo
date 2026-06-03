package com.dragon.read.kmp.story.impl.feeds.actionbar.menu;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o;
import androidx.compose.runtime.SnapshotStateKt;
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
import x0.r;
import x0.s;
import x0.u;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.StoryMenuDialogKt$StoryMenuDialogContent$1$1", f = "StoryMenuDialog.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryMenuDialogKt$StoryMenuDialogContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ h $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryMenuDialogKt$StoryMenuDialogContent$1$1(LazyListState lazyListState, h hVar, Continuation<? super StoryMenuDialogKt$StoryMenuDialogContent$1$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$params = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryMenuDialogKt$StoryMenuDialogContent$1$1(this.$lazyListState, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryMenuDialogKt$StoryMenuDialogContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final LazyListState lazyListState = this.$lazyListState;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StoryMenuDialogKt$StoryMenuDialogContent$1$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            });
            a aVar = new a(this.$params, this.$lazyListState);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ h a;
        final /* synthetic */ LazyListState b;

        a(h hVar, LazyListState lazyListState) {
            this.a = hVar;
            this.b = lazyListState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(List<? extends o> list, Continuation<? super Unit> continuation) {
            h hVar = this.a;
            LazyListState lazyListState = this.b;
            for (o oVar : list) {
                fp4.c cVar = (fp4.c) CollectionsKt___CollectionsKt.getOrNull(hVar.a, oVar.getIndex());
                if (cVar != null) {
                    a0.h c = s.c(new r(oVar.getOffset(), 0, oVar.getOffset() + oVar.getSize(), (int) (lazyListState.x().a() & 4294967295L)));
                    a0.h p = c.p(s.c(u.d(lazyListState.x().a())));
                    if ((c.c - c.a) * (c.d - c.b) > 0.0f && ((p.c - p.a) * (p.d - p.b)) / r4 > 0.3d) {
                        cVar.d.invoke();
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
