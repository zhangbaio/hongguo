package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.v1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k {
    private static final f0 a;
    public static final f0 b;

    static {
        Covode.recordClassIndex(659226);
        a = new f0("UNDEFINED");
        b = new f0("REUSABLE_CLAIMED");
    }

    public static final boolean d(j<? super Unit> jVar) {
        Unit unit = Unit.INSTANCE;
        p0 b2 = v1.a.b();
        if (b2.F()) {
            return false;
        }
        if (b2.E()) {
            jVar.c = unit;
            jVar.resumeMode = 1;
            b2.A(jVar);
            return true;
        }
        b2.C(true);
        try {
            jVar.run();
            do {
            } while (b2.H());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }

    /* JADX WARN: Finally extract failed */
    public static final <T> void b(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        boolean z;
        d2<?> d2Var;
        if (continuation instanceof j) {
            j jVar = (j) continuation;
            Object b2 = kotlinx.coroutines.x.b(obj, function1);
            if (jVar.a.isDispatchNeeded(jVar.getContext())) {
                jVar.c = b2;
                jVar.resumeMode = 1;
                jVar.a.dispatch(jVar.getContext(), jVar);
                return;
            }
            p0 b3 = v1.a.b();
            if (b3.E()) {
                jVar.c = b2;
                jVar.resumeMode = 1;
                b3.A(jVar);
                return;
            }
            b3.C(true);
            try {
                Job job = (Job) jVar.getContext().get(Job.Key);
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    jVar.cancelCompletedResult$kotlinx_coroutines_core(b2, cancellationException);
                    Result.Companion companion = Result.Companion;
                    jVar.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(cancellationException)));
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    Continuation<T> continuation2 = jVar.b;
                    Object obj2 = jVar.d;
                    CoroutineContext context = continuation2.getContext();
                    Object c = ThreadContextKt.c(context, obj2);
                    if (c != ThreadContextKt.a) {
                        d2Var = CoroutineContextKt.g(continuation2, context, c);
                    } else {
                        d2Var = null;
                    }
                    try {
                        jVar.b.resumeWith(obj);
                        Unit unit = Unit.INSTANCE;
                        if (d2Var == null || d2Var.J0()) {
                            ThreadContextKt.a(context, c);
                        }
                    } catch (Throwable th) {
                        if (d2Var == null || d2Var.J0()) {
                            ThreadContextKt.a(context, c);
                        }
                        throw th;
                    }
                }
                while (b3.H()) {
                }
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        continuation.resumeWith(obj);
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }
}
