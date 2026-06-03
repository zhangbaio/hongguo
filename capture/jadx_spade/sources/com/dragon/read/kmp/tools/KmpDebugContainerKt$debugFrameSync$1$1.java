package com.dragon.read.kmp.tools;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.n1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.tools.KmpDebugContainerKt$debugFrameSync$1$1", f = "KmpDebugContainer.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpDebugContainerKt$debugFrameSync$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fc4.a $composeTracker;
    final /* synthetic */ MutableState<Long> $lastFrameTime$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpDebugContainerKt$debugFrameSync$1$1(fc4.a aVar, MutableState<Long> mutableState, Continuation<? super KmpDebugContainerKt$debugFrameSync$1$1> continuation) {
        super(2, continuation);
        this.$lastFrameTime$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpDebugContainerKt$debugFrameSync$1$1(null, this.$lastFrameTime$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpDebugContainerKt$debugFrameSync$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public static final class a implements Function1<Long, Unit> {
        final /* synthetic */ MutableState<Long> a;

        public a(fc4.a aVar, MutableState<Long> mutableState) {
            this.a = mutableState;
        }

        public final void a(long j) {
            throw null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            a(l.longValue());
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        a aVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0 && i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        do {
            aVar = new a(null, this.$lastFrameTime$delegate);
            this.label = 1;
        } while (n1.b(aVar, this) != coroutine_suspended);
        return coroutine_suspended;
    }
}
