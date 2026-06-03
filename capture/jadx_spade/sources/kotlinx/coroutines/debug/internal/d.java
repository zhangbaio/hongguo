package kotlinx.coroutines.debug.internal;

import com.bytedance.covode.number.Covode;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> extends WeakReference<T> {
    public final int a;

    static {
        Covode.recordClassIndex(659123);
    }

    public d(T t, ReferenceQueue<T> referenceQueue) {
        super(t, referenceQueue);
        int i;
        if (t != null) {
            i = t.hashCode();
        } else {
            i = 0;
        }
        this.a = i;
    }
}
