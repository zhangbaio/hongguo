package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j0 {
    static {
        Covode.recordClassIndex(658960);
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    private static final void e(i0<?> i0Var) {
        p0 b = v1.a.b();
        if (b.E()) {
            b.A(i0Var);
            return;
        }
        b.C(true);
        try {
            d(i0Var, i0Var.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (b.H());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final <T> void a(i0<? super T> i0Var, int i) {
        boolean z;
        Continuation<? super T> delegate$kotlinx_coroutines_core = i0Var.getDelegate$kotlinx_coroutines_core();
        if (i == 4) {
            z = true;
        } else {
            z = false;
        }
        if (!z && (delegate$kotlinx_coroutines_core instanceof kotlinx.coroutines.internal.j) && b(i) == b(i0Var.resumeMode)) {
            CoroutineDispatcher coroutineDispatcher = ((kotlinx.coroutines.internal.j) delegate$kotlinx_coroutines_core).a;
            CoroutineContext context = delegate$kotlinx_coroutines_core.getContext();
            if (coroutineDispatcher.isDispatchNeeded(context)) {
                coroutineDispatcher.dispatch(context, i0Var);
                return;
            } else {
                e(i0Var);
                return;
            }
        }
        d(i0Var, delegate$kotlinx_coroutines_core, z);
    }

    public static final <T> void d(i0<? super T> i0Var, Continuation<? super T> continuation, boolean z) {
        Object successfulResult$kotlinx_coroutines_core;
        d2<?> d2Var;
        boolean J0;
        Object takeState$kotlinx_coroutines_core = i0Var.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = i0Var.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Result.Companion companion = Result.Companion;
            successfulResult$kotlinx_coroutines_core = ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core);
        } else {
            Result.Companion companion2 = Result.Companion;
            successfulResult$kotlinx_coroutines_core = i0Var.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        Object m773constructorimpl = Result.m773constructorimpl(successfulResult$kotlinx_coroutines_core);
        if (z) {
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) continuation;
            Continuation<T> continuation2 = jVar.b;
            Object obj = jVar.d;
            CoroutineContext context = continuation2.getContext();
            Object c = ThreadContextKt.c(context, obj);
            if (c != ThreadContextKt.a) {
                d2Var = CoroutineContextKt.g(continuation2, context, c);
            } else {
                d2Var = null;
            }
            try {
                jVar.b.resumeWith(m773constructorimpl);
                Unit unit = Unit.INSTANCE;
                if (d2Var != null) {
                    if (!J0) {
                        return;
                    }
                }
                return;
            } finally {
                if (d2Var == null || d2Var.J0()) {
                    ThreadContextKt.a(context, c);
                }
            }
        }
        continuation.resumeWith(m773constructorimpl);
    }
}
