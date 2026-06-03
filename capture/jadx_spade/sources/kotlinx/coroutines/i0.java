package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class i0<T> extends kotlinx.coroutines.scheduling.g {
    public int resumeMode;

    static {
        Covode.recordClassIndex(658959);
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    @Override // java.lang.Runnable
    public final void run() {
        Object m773constructorimpl;
        d2<?> d2Var;
        Job job;
        Object m773constructorimpl2;
        kotlinx.coroutines.scheduling.h hVar = this.taskContext;
        try {
            Continuation<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            Intrinsics.checkNotNull(delegate$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) delegate$kotlinx_coroutines_core;
            Continuation<T> continuation = jVar.b;
            Object obj = jVar.d;
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, obj);
            if (c != ThreadContextKt.a) {
                d2Var = CoroutineContextKt.g(continuation, context, c);
            } else {
                d2Var = null;
            }
            try {
                CoroutineContext context2 = continuation.getContext();
                Object takeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                if (exceptionalResult$kotlinx_coroutines_core == null && j0.b(this.resumeMode)) {
                    job = (Job) context2.get(Job.Key);
                } else {
                    job = null;
                }
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core, cancellationException);
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(cancellationException)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    Result.Companion companion2 = Result.Companion;
                    continuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    Result.Companion companion3 = Result.Companion;
                    continuation.resumeWith(Result.m773constructorimpl(getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core)));
                }
                Unit unit = Unit.INSTANCE;
                try {
                    hVar.a();
                    m773constructorimpl2 = Result.m773constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion4 = Result.Companion;
                    m773constructorimpl2 = Result.m773constructorimpl(ResultKt.createFailure(th));
                }
                handleFatalException$kotlinx_coroutines_core(null, Result.m776exceptionOrNullimpl(m773constructorimpl2));
            } finally {
                if (d2Var == null || d2Var.J0()) {
                    ThreadContextKt.a(context, c);
                }
            }
        } catch (Throwable th2) {
            try {
                Result.Companion companion5 = Result.Companion;
                hVar.a();
                m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.Companion;
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th3));
            }
            handleFatalException$kotlinx_coroutines_core(th2, Result.m776exceptionOrNullimpl(m773constructorimpl));
        }
    }

    public i0(int i) {
        this.resumeMode = i;
    }

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        v vVar;
        if (obj instanceof v) {
            vVar = (v) obj;
        } else {
            vVar = null;
        }
        if (vVar == null) {
            return null;
        }
        return vVar.a;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics.checkNotNull(th);
        z.a(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }
}
