package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d1 extends JobSupport implements CompletableJob {
    private final boolean c;

    static {
        Covode.recordClassIndex(659000);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean O() {
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean L() {
        return this.c;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return c0(Unit.INSTANCE);
    }

    private final boolean F0() {
        r rVar;
        JobSupport t;
        r rVar2;
        q Q = Q();
        if (Q instanceof r) {
            rVar = (r) Q;
        } else {
            rVar = null;
        }
        if (rVar != null && (t = rVar.t()) != null) {
            while (!t.L()) {
                q Q2 = t.Q();
                if (Q2 instanceof r) {
                    rVar2 = (r) Q2;
                } else {
                    rVar2 = null;
                }
                if (rVar2 != null && (t = rVar2.t()) != null) {
                }
            }
            return true;
        }
        return false;
    }

    public d1(Job job) {
        super(true);
        W(job);
        this.c = F0();
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean completeExceptionally(Throwable th) {
        return c0(new v(th, false, 2, null));
    }
}
