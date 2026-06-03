package ym6;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.v;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    static {
        Covode.recordClassIndex(659280);
    }

    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Object invoke;
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, null);
            try {
                if (!(function2 instanceof BaseContinuationImpl)) {
                    invoke = IntrinsicsKt__IntrinsicsJvmKt.wrapWithContinuationImpl(function2, r, probeCoroutineCreated);
                } else {
                    invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, probeCoroutineCreated);
                }
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (invoke != coroutine_suspended) {
                    probeCoroutineCreated.resumeWith(Result.m773constructorimpl(invoke));
                }
            } finally {
                ThreadContextKt.a(context, c);
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <T, R> Object b(b0<? super T> b0Var, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object vVar;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        try {
            if (!(function2 instanceof BaseContinuationImpl)) {
                vVar = IntrinsicsKt__IntrinsicsJvmKt.wrapWithContinuationImpl(function2, r, b0Var);
            } else {
                vVar = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, b0Var);
            }
        } catch (Throwable th) {
            vVar = new v(th, false, 2, null);
        }
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (vVar == coroutine_suspended) {
            coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended3;
        }
        Object d0 = b0Var.d0(vVar);
        if (d0 == g1.b) {
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended2;
        }
        if (!(d0 instanceof v)) {
            return g1.h(d0);
        }
        throw ((v) d0).a;
    }

    public static final <T, R> Object c(b0<? super T> b0Var, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object vVar;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        boolean z = false;
        try {
            if (!(function2 instanceof BaseContinuationImpl)) {
                vVar = IntrinsicsKt__IntrinsicsJvmKt.wrapWithContinuationImpl(function2, r, b0Var);
            } else {
                vVar = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, b0Var);
            }
        } catch (Throwable th) {
            vVar = new v(th, false, 2, null);
        }
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (vVar == coroutine_suspended) {
            coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended3;
        }
        Object d0 = b0Var.d0(vVar);
        if (d0 == g1.b) {
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended2;
        }
        if (d0 instanceof v) {
            Throwable th2 = ((v) d0).a;
            if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).coroutine != b0Var) {
                z = true;
            }
            if (!z) {
                if (vVar instanceof v) {
                    throw ((v) vVar).a;
                }
            } else {
                throw th2;
            }
        } else {
            vVar = g1.h(d0);
        }
        return vVar;
    }
}
