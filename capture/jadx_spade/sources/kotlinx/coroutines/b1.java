package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b1 extends f1 {
    private final z0 e;

    static {
        Covode.recordClassIndex(658994);
    }

    public b1(z0 z0Var) {
        this.e = z0Var;
    }

    @Override // kotlinx.coroutines.z0
    public void invoke(Throwable th) {
        this.e.invoke(th);
    }
}
