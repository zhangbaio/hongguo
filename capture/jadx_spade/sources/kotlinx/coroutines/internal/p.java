package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p {
    static {
        Covode.recordClassIndex(659235);
    }

    public static final void a(int i) {
        boolean z = true;
        if (i < 1) {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i).toString());
    }
}
