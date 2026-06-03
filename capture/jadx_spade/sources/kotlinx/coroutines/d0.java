package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d0 {
    private static final boolean a;
    private static final f0 b;

    public static final f0 a() {
        return b;
    }

    static {
        Covode.recordClassIndex(658948);
        a = kotlinx.coroutines.internal.g0.f("kotlinx.coroutines.main.delay", false);
        b = b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final f0 b() {
        if (!a) {
            return c0.g;
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        if (!kotlinx.coroutines.internal.w.c(main) && (main instanceof f0)) {
            return (f0) main;
        }
        return c0.g;
    }
}
