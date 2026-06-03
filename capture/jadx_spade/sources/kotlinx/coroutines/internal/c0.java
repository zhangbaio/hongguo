package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.m1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class c0<S extends c0<S>> extends e<S> implements m1 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater d;
    public final long c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    static {
        Covode.recordClassIndex(659261);
        d = AtomicIntegerFieldUpdater.newUpdater(c0.class, "cleanedAndPointers$volatile");
    }

    public abstract int q();

    public abstract void r(int i, Throwable th, CoroutineContext coroutineContext);

    @Override // kotlinx.coroutines.internal.e
    public boolean j() {
        if (d.get(this) == q() && !k()) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        if (d.addAndGet(this, -65536) == q() && !k()) {
            return true;
        }
        return false;
    }

    public final void s() {
        if (d.incrementAndGet(this) == q()) {
            m();
        }
    }

    public final boolean t() {
        int i;
        boolean z;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i == q() && !k()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }

    public c0(long j, S s, int i) {
        super(s);
        this.c = j;
        this.cleanedAndPointers$volatile = i << 16;
    }
}
