package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static {
        Covode.recordClassIndex(659219);
    }

    public static final <T> T a(AtomicReference<T> atomicReference) {
        return atomicReference.get();
    }

    public static final <T> void b(AtomicReference<T> atomicReference, T t) {
        atomicReference.set(t);
    }
}
