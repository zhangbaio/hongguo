package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o extends v {
    private static final /* synthetic */ AtomicIntegerFieldUpdater c;
    private volatile /* synthetic */ int _resumed$volatile;

    static {
        Covode.recordClassIndex(658907);
        c = AtomicIntegerFieldUpdater.newUpdater(o.class, "_resumed$volatile");
    }

    public final boolean e() {
        return c.compareAndSet(this, 0, 1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o(kotlin.coroutines.Continuation<?> r3, java.lang.Throwable r4, boolean r5) {
        /*
            r2 = this;
            if (r4 != 0) goto L1d
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Continuation "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " was cancelled normally"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
        L1d:
            r2.<init>(r4, r5)
            r3 = 0
            r2._resumed$volatile = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.o.<init>(kotlin.coroutines.Continuation, java.lang.Throwable, boolean):void");
    }
}
