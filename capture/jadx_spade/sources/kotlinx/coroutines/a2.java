package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a2 implements z0 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater d;
    private volatile /* synthetic */ int _state$volatile;
    private final Job a;
    private final Thread b = Thread.currentThread();
    private DisposableHandle c;

    static {
        Covode.recordClassIndex(659038);
        d = AtomicIntegerFieldUpdater.newUpdater(a2.class, "_state$volatile");
    }

    public final void a() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        while (true) {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        c(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (d.compareAndSet(this, i, 1)) {
                DisposableHandle disposableHandle = this.c;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    public final void d() {
        int i;
        this.c = JobKt.invokeOnCompletion(this.a, true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 2 && i != 3) {
                    c(i);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!d.compareAndSet(this, i, 0));
    }

    public a2(Job job) {
        this.a = job;
    }

    private final Void c(int i) {
        throw new IllegalStateException(("Illegal state " + i).toString());
    }

    @Override // kotlinx.coroutines.z0
    public void invoke(Throwable th) {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    c(i);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!d.compareAndSet(this, i, 2));
        this.b.interrupt();
        d.set(this, 3);
    }
}
