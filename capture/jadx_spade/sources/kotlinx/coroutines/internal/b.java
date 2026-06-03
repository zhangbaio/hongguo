package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b<T> extends y {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a;
    private volatile /* synthetic */ Object _consensus$volatile = a.a;

    static {
        Covode.recordClassIndex(659214);
        a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus$volatile");
    }

    public abstract void b(T t, Object obj);

    public abstract Object e(T t);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.y
    public final Object a(Object obj) {
        Object obj2 = a.get(this);
        if (obj2 == a.a) {
            obj2 = c(e(obj));
        }
        b(obj, obj2);
        return obj2;
    }

    private final Object c(Object obj) {
        Object obj2 = a.get(this);
        Object obj3 = a.a;
        if (obj2 != obj3) {
            return obj2;
        }
        if (androidx.concurrent.futures.a.a(a, this, obj3, obj)) {
            return obj;
        }
        return a.get(this);
    }
}
