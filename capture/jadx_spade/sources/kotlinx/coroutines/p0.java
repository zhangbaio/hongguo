package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.collections.ArrayDeque;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class p0 extends CoroutineDispatcher {
    private long a;
    private boolean b;
    private ArrayDeque<i0<?>> c;

    static {
        Covode.recordClassIndex(658969);
    }

    private final long z(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public boolean I() {
        return false;
    }

    public void shutdown() {
    }

    public final boolean E() {
        if (this.a >= z(true)) {
            return true;
        }
        return false;
    }

    public final boolean F() {
        ArrayDeque<i0<?>> arrayDeque = this.c;
        if (arrayDeque != null) {
            return arrayDeque.isEmpty();
        }
        return true;
    }

    public long G() {
        if (!H()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    protected long B() {
        ArrayDeque<i0<?>> arrayDeque = this.c;
        if (arrayDeque == null || arrayDeque.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean H() {
        i0<?> removeFirstOrNull;
        ArrayDeque<i0<?>> arrayDeque = this.c;
        if (arrayDeque == null || (removeFirstOrNull = arrayDeque.removeFirstOrNull()) == null) {
            return false;
        }
        removeFirstOrNull.run();
        return true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int i) {
        kotlinx.coroutines.internal.p.a(i);
        return this;
    }

    public final void A(i0<?> i0Var) {
        ArrayDeque<i0<?>> arrayDeque = this.c;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
            this.c = arrayDeque;
        }
        arrayDeque.addLast(i0Var);
    }

    public final void C(boolean z) {
        this.a += z(z);
        if (!z) {
            this.b = true;
        }
    }

    public final void w(boolean z) {
        long z2 = this.a - z(z);
        this.a = z2;
        if (z2 <= 0 && this.b) {
            shutdown();
        }
    }

    public static /* synthetic */ void D(p0 p0Var, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            p0Var.C(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public static /* synthetic */ void x(p0 p0Var, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            p0Var.w(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }
}
