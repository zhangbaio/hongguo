package com.dragon.read.kmp.utils;

import com.ss.ttvideoengine.log.IVideoEventLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.dragon.read.kmp.utils.ThreadUtils$1$1$1", f = "ThreadUtils.kt", i = {}, l = {IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ThreadUtils$1$1$1 extends SuspendLambda implements Function2<Function1<? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    ThreadUtils$1$1$1(Continuation<? super ThreadUtils$1$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ThreadUtils$1$1$1 threadUtils$1$1$1 = new ThreadUtils$1$1$1(continuation);
        threadUtils$1$1$1.L$0 = obj;
        return threadUtils$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        return ((ThreadUtils$1$1$1) create(function1, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Function1 function1 = (Function1) this.L$0;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}
