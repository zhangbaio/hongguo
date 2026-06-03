package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class r extends c1 implements q {
    public final s e;

    static {
        Covode.recordClassIndex(658911);
    }

    @Override // kotlinx.coroutines.q
    public Job getParent() {
        return t();
    }

    public r(s sVar) {
        this.e = sVar;
    }

    @Override // kotlinx.coroutines.q
    public boolean b(Throwable th) {
        return t().z(th);
    }

    @Override // kotlinx.coroutines.z0
    public void invoke(Throwable th) {
        this.e.a(t());
    }
}
