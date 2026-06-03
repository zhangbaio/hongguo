package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n0 extends f1 {
    private final DisposableHandle e;

    static {
        Covode.recordClassIndex(658967);
    }

    public n0(DisposableHandle disposableHandle) {
        this.e = disposableHandle;
    }

    @Override // kotlinx.coroutines.z0
    public void invoke(Throwable th) {
        this.e.dispose();
    }
}
