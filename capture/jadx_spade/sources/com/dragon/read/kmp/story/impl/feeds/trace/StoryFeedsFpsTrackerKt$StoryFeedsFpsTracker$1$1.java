package com.dragon.read.kmp.story.impl.feeds.trace;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
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
import lx1.o;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.trace.StoryFeedsFpsTrackerKt$StoryFeedsFpsTracker$1$1", f = "StoryFeedsFpsTracker.kt", i = {}, l = {ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryFeedsFpsTrackerKt$StoryFeedsFpsTracker$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $hasStartListFpsMonitor$delegate;
    final /* synthetic */ LazyListState $lazyListState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryFeedsFpsTrackerKt$StoryFeedsFpsTracker$1$1(LazyListState lazyListState, MutableState<Boolean> mutableState, Continuation<? super StoryFeedsFpsTrackerKt$StoryFeedsFpsTracker$1$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$hasStartListFpsMonitor$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryFeedsFpsTrackerKt$StoryFeedsFpsTracker$1$1(this.$lazyListState, this.$hasStartListFpsMonitor$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryFeedsFpsTrackerKt$StoryFeedsFpsTracker$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.trace.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean b;
                    b = lazyListState.b();
                    return Boolean.valueOf(b);
                }
            });
            a aVar = new a(this.$hasStartListFpsMonitor$delegate);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ MutableState<Boolean> a;

        a(MutableState<Boolean> mutableState) {
            this.a = mutableState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            boolean c;
            boolean c2;
            if (z) {
                c2 = StoryFeedsFpsTrackerKt.c(this.a);
                if (!c2) {
                    o.a.b0("kmp_story_feeds_page");
                    StoryFeedsFpsTrackerKt.d(this.a, true);
                }
            } else {
                c = StoryFeedsFpsTrackerKt.c(this.a);
                if (c) {
                    o.a.H0("kmp_story_feeds_page");
                    StoryFeedsFpsTrackerKt.d(this.a, false);
                }
            }
            return Unit.INSTANCE;
        }
    }
}
