package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g extends q0 {
    private final Thread g;

    static {
        Covode.recordClassIndex(658894);
    }

    @Override // kotlinx.coroutines.r0
    protected Thread K() {
        return this.g;
    }

    public g(Thread thread) {
        this.g = thread;
    }
}
