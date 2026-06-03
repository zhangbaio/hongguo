package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DisposableHandle;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o extends CoroutineDispatcher implements kotlinx.coroutines.f0 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f;
    private final CoroutineDispatcher a;
    private final int b;
    private final /* synthetic */ kotlinx.coroutines.f0 c;
    private final s<Runnable> d;
    private final Object e;
    private volatile /* synthetic */ int runningWorkers$volatile;

    static {
        Covode.recordClassIndex(659233);
        f = AtomicIntegerFieldUpdater.newUpdater(o.class, "runningWorkers$volatile");
    }

    @Override // kotlinx.coroutines.f0
    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return this.c.invokeOnTimeout(j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.f0
    public void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.c.scheduleResumeAfterDelay(j, cancellableContinuation);
    }

    private final boolean B() {
        synchronized (this.e) {
            if (f.get(this) >= this.b) {
                return false;
            }
            f.incrementAndGet(this);
            return true;
        }
    }

    private final class a implements Runnable {
        private Runnable a;

        static {
            Covode.recordClassIndex(659234);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (true) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    kotlinx.coroutines.z.a(EmptyCoroutineContext.INSTANCE, th);
                }
                Runnable A = o.this.A();
                if (A == null) {
                    return;
                }
                this.a = A;
                i++;
                if (i >= 16 && o.this.a.isDispatchNeeded(o.this)) {
                    o.this.a.dispatch(o.this, this);
                    return;
                }
            }
        }

        public a(Runnable runnable) {
            this.a = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable A() {
        while (true) {
            Runnable e = this.d.e();
            if (e == null) {
                synchronized (this.e) {
                    f.decrementAndGet(this);
                    if (this.d.c() == 0) {
                        return null;
                    }
                    f.incrementAndGet(this);
                }
            } else {
                return e;
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int i) {
        p.a(i);
        if (i >= this.b) {
            return this;
        }
        return super.limitedParallelism(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(CoroutineDispatcher coroutineDispatcher, int i) {
        kotlinx.coroutines.f0 f0Var;
        this.a = coroutineDispatcher;
        this.b = i;
        if (coroutineDispatcher instanceof kotlinx.coroutines.f0) {
            f0Var = (kotlinx.coroutines.f0) coroutineDispatcher;
        } else {
            f0Var = null;
        }
        this.c = f0Var == null ? kotlinx.coroutines.d0.a() : f0Var;
        this.d = new s<>(false);
        this.e = new Object();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable A;
        this.d.a(runnable);
        if (f.get(this) < this.b && B() && (A = A()) != null) {
            this.a.dispatch(this, new a(A));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable A;
        this.d.a(runnable);
        if (f.get(this) < this.b && B() && (A = A()) != null) {
            this.a.dispatchYield(this, new a(A));
        }
    }
}
