package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class f<T> extends a<T> {
    private final Thread d;
    private final p0 e;

    static {
        Covode.recordClassIndex(658893);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean Y() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T J0() {
        long j;
        c.a();
        try {
            p0 p0Var = this.e;
            v vVar = null;
            if (p0Var != null) {
                p0.D(p0Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    p0 p0Var2 = this.e;
                    if (p0Var2 != null) {
                        j = p0Var2.G();
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (!isCompleted()) {
                        c.a();
                        LockSupport.parkNanos(this, j);
                    } else {
                        c.a();
                        T t = (T) g1.h(R());
                        if (t instanceof v) {
                            vVar = (v) t;
                        }
                        if (vVar == null) {
                            return t;
                        }
                        throw vVar.a;
                    }
                } finally {
                    p0 p0Var3 = this.e;
                    if (p0Var3 != null) {
                        p0.x(p0Var3, false, 1, null);
                    }
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            s(interruptedException);
            throw interruptedException;
        } catch (Throwable th) {
            c.a();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void p(Object obj) {
        if (!Intrinsics.areEqual(Thread.currentThread(), this.d)) {
            Thread thread = this.d;
            c.a();
            LockSupport.unpark(thread);
        }
    }

    public f(CoroutineContext coroutineContext, Thread thread, p0 p0Var) {
        super(coroutineContext, true, true);
        this.d = thread;
        this.e = p0Var;
    }
}
