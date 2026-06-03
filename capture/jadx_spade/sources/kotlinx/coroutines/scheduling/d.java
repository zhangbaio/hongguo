package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d extends f {
    public static final d a;

    static {
        Covode.recordClassIndex(659327);
        a = new d();
    }

    private d() {
    }

    @Override // kotlinx.coroutines.scheduling.f
    public long a() {
        return System.nanoTime();
    }
}
