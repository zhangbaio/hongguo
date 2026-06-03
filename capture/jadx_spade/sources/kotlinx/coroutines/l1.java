package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l1 implements DisposableHandle, q {
    public static final l1 a;

    static {
        Covode.recordClassIndex(659017);
        a = new l1();
    }

    private l1() {
    }

    @Override // kotlinx.coroutines.q
    public boolean b(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
    }

    @Override // kotlinx.coroutines.q
    public Job getParent() {
        return null;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
