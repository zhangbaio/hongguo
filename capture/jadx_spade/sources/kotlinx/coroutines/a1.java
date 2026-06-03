package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a1 extends c1 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f;
    private volatile /* synthetic */ int _invoked$volatile;
    private final z0 e;

    static {
        Covode.recordClassIndex(658993);
        f = AtomicIntegerFieldUpdater.newUpdater(a1.class, "_invoked$volatile");
    }

    public a1(z0 z0Var) {
        this.e = z0Var;
    }

    @Override // kotlinx.coroutines.z0
    public void invoke(Throwable th) {
        if (f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }
}
