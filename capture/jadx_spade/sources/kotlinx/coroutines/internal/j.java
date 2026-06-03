package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.v1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j<T> extends kotlinx.coroutines.i0<T> implements CoroutineStackFrame, Continuation<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater e;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final CoroutineDispatcher a;
    public final Continuation<T> b;
    public Object c;
    public final Object d;

    static {
        Covode.recordClassIndex(659225);
        e = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_reusableCancellableContinuation$volatile");
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.b.getContext();
    }

    @Override // kotlinx.coroutines.i0
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void a() {
        while (e.get(this) == k.b) {
        }
    }

    public final boolean f() {
        if (e.get(this) != null) {
            return true;
        }
        return false;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.b;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final void h() {
        a();
        CancellableContinuationImpl<?> d = d();
        if (d != null) {
            d.detachChild$kotlinx_coroutines_core();
        }
    }

    @Override // kotlinx.coroutines.i0
    public Object takeState$kotlinx_coroutines_core() {
        f0 f0Var;
        Object obj = this.c;
        f0Var = k.a;
        this.c = f0Var;
        return obj;
    }

    private final CancellableContinuationImpl<?> d() {
        Object obj = e.get(this);
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.a + ", " + kotlinx.coroutines.b0.c(this.b) + ']';
    }

    public final CancellableContinuationImpl<T> b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                e.set(this, k.b);
                return null;
            }
            if (obj instanceof CancellableContinuationImpl) {
                if (androidx.concurrent.futures.a.a(e, this, obj, k.b)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != k.b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final boolean g(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            f0 f0Var = k.b;
            if (Intrinsics.areEqual(obj, f0Var)) {
                if (androidx.concurrent.futures.a.a(e, this, f0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.a.a(e, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final Throwable i(CancellableContinuation<?> cancellableContinuation) {
        f0 f0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            f0Var = k.b;
            if (obj != f0Var) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.a.a(e, this, obj, (Object) null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(e, this, f0Var, cancellableContinuation));
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context = this.b.getContext();
        Object d = kotlinx.coroutines.x.d(obj, null, 1, null);
        if (this.a.isDispatchNeeded(context)) {
            this.c = d;
            this.resumeMode = 0;
            this.a.dispatch(context, this);
            return;
        }
        p0 b = v1.a.b();
        if (b.E()) {
            this.c = d;
            this.resumeMode = 0;
            b.A(this);
            return;
        }
        b.C(true);
        try {
            CoroutineContext context2 = getContext();
            Object c = ThreadContextKt.c(context2, this.d);
            try {
                this.b.resumeWith(obj);
                Unit unit = Unit.INSTANCE;
                while (b.H()) {
                }
            } finally {
                ThreadContextKt.a(context2, c);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void c(CoroutineContext coroutineContext, T t) {
        this.c = t;
        this.resumeMode = 1;
        this.a.dispatchYield(coroutineContext, this);
    }

    @Override // kotlinx.coroutines.i0
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
        if (obj instanceof kotlinx.coroutines.w) {
            ((kotlinx.coroutines.w) obj).b.invoke(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        f0 f0Var;
        this.a = coroutineDispatcher;
        this.b = continuation;
        f0Var = k.a;
        this.c = f0Var;
        this.d = ThreadContextKt.b(getContext());
    }
}
