package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.e;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class e<N extends e<N>> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a;
    private static final /* synthetic */ AtomicReferenceFieldUpdater b;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        Covode.recordClassIndex(659218);
        a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next$volatile");
        b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev$volatile");
    }

    public abstract boolean j();

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f() {
        return a.get(this);
    }

    public final void b() {
        b.set(this, null);
    }

    public final N e() {
        Object f = f();
        if (f == d.a) {
            return null;
        }
        return (N) f;
    }

    public final N g() {
        return (N) b.get(this);
    }

    public final boolean k() {
        if (e() == null) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        return androidx.concurrent.futures.a.a(a, this, (Object) null, d.a);
    }

    private final N c() {
        N g = g();
        while (g != null && g.j()) {
            g = (N) b.get(g);
        }
        return g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.e] */
    private final N d() {
        N e = e();
        Intrinsics.checkNotNull(e);
        while (e.j()) {
            ?? e2 = e.e();
            if (e2 == 0) {
                return e;
            }
            e = e2;
        }
        return e;
    }

    public final void m() {
        Object obj;
        N n;
        if (k()) {
            return;
        }
        while (true) {
            N c = c();
            N d = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            do {
                obj = atomicReferenceFieldUpdater.get(d);
                if (((e) obj) == null) {
                    n = null;
                } else {
                    n = c;
                }
            } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, d, obj, n));
            if (c != null) {
                a.set(c, d);
            }
            if (!d.j() || d.k()) {
                if (c == null || !c.j()) {
                    return;
                }
            }
        }
    }

    public e(N n) {
        this._prev$volatile = n;
    }

    public final boolean n(N n) {
        return androidx.concurrent.futures.a.a(a, this, (Object) null, n);
    }
}
