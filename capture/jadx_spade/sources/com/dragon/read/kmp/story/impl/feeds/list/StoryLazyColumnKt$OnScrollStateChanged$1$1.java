package com.dragon.read.kmp.story.impl.feeds.list;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import com.ss.ttvideoengine.TTVideoEngineInterface;
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

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$OnScrollStateChanged$1$1", f = "StoryLazyColumn.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_STRENGTH}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryLazyColumnKt$OnScrollStateChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onStartScroll;
    final /* synthetic */ Function0<Unit> $onStopScroll;
    final /* synthetic */ LazyListState $this_OnScrollStateChanged;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryLazyColumnKt$OnScrollStateChanged$1$1(LazyListState lazyListState, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super StoryLazyColumnKt$OnScrollStateChanged$1$1> continuation) {
        super(2, continuation);
        this.$this_OnScrollStateChanged = lazyListState;
        this.$onStartScroll = function0;
        this.$onStopScroll = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryLazyColumnKt$OnScrollStateChanged$1$1(this.$this_OnScrollStateChanged, this.$onStartScroll, this.$onStopScroll, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryLazyColumnKt$OnScrollStateChanged$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final LazyListState lazyListState = this.$this_OnScrollStateChanged;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.list.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean b;
                    b = lazyListState.b();
                    return Boolean.valueOf(b);
                }
            });
            a aVar = new a(this.$onStartScroll, this.$onStopScroll);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ Function0<Unit> a;
        final /* synthetic */ Function0<Unit> b;

        a(Function0<Unit> function0, Function0<Unit> function02) {
            this.a = function0;
            this.b = function02;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            if (z) {
                Function0<Unit> function0 = this.a;
                if (function0 != null) {
                    function0.invoke();
                }
            } else {
                Function0<Unit> function02 = this.b;
                if (function02 != null) {
                    function02.invoke();
                }
            }
            return Unit.INSTANCE;
        }
    }
}
