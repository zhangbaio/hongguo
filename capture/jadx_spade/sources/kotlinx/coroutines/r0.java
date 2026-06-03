package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.q0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class r0 extends p0 {
    static {
        Covode.recordClassIndex(658975);
    }

    protected abstract Thread K();

    protected final void N() {
        Thread K = K();
        if (Thread.currentThread() != K) {
            c.a();
            LockSupport.unpark(K);
        }
    }

    protected void L(long j, q0.c cVar) {
        c0.g.Z(j, cVar);
    }
}
