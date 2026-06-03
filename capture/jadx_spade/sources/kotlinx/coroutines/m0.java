package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class m0 implements l {
    private final DisposableHandle a;

    static {
        Covode.recordClassIndex(658966);
    }

    public String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }

    public m0(DisposableHandle disposableHandle) {
        this.a = disposableHandle;
    }

    @Override // kotlinx.coroutines.l
    public void invoke(Throwable th) {
        this.a.dispose();
    }
}
