package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m {
    private static final /* synthetic */ AtomicReferenceFieldUpdater b;
    private static final /* synthetic */ AtomicIntegerFieldUpdater c;
    private static final /* synthetic */ AtomicIntegerFieldUpdater d;
    private static final /* synthetic */ AtomicIntegerFieldUpdater e;
    private final AtomicReferenceArray<g> a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    static {
        Covode.recordClassIndex(659336);
        b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask$volatile");
        c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex$volatile");
        d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex$volatile");
        e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer$volatile");
    }

    public final g l() {
        return p(true);
    }

    public final g n() {
        return p(false);
    }

    private final int e() {
        return c.get(this) - d.get(this);
    }

    public final int i() {
        if (b.get(this) != null) {
            return e() + 1;
        }
        return e();
    }

    public final g k() {
        g gVar = (g) b.getAndSet(this, null);
        if (gVar == null) {
            return m();
        }
        return gVar;
    }

    private final g m() {
        g andSet;
        while (true) {
            int i = d.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.a.getAndSet(i2, null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    private final boolean o(c cVar) {
        g m = m();
        if (m == null) {
            return false;
        }
        cVar.a(m);
        return true;
    }

    private final void c(g gVar) {
        if (gVar != null) {
            boolean z = true;
            if (gVar.taskContext.b() != 1) {
                z = false;
            }
            if (z) {
                e.decrementAndGet(this);
            }
        }
    }

    public final void j(c cVar) {
        g gVar = (g) b.getAndSet(this, null);
        if (gVar != null) {
            cVar.a(gVar);
        }
        while (o(cVar)) {
        }
    }

    private final g b(g gVar) {
        if (e() == 127) {
            return gVar;
        }
        boolean z = true;
        if (gVar.taskContext.b() != 1) {
            z = false;
        }
        if (z) {
            e.incrementAndGet(this);
        }
        int i = c.get(this) & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, gVar);
        c.incrementAndGet(this);
        return null;
    }

    private final g q(int i) {
        int i2 = d.get(this);
        int i3 = c.get(this);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        while (i2 != i3) {
            if (z && e.get(this) == 0) {
                return null;
            }
            int i4 = i2 + 1;
            g r = r(i2, z);
            if (r == null) {
                i2 = i4;
            } else {
                return r;
            }
        }
        return null;
    }

    private final g p(boolean z) {
        g gVar;
        do {
            gVar = (g) b.get(this);
            if (gVar != null) {
                boolean z2 = true;
                if (gVar.taskContext.b() != 1) {
                    z2 = false;
                }
                if (z2 == z) {
                }
            }
            int i = d.get(this);
            int i2 = c.get(this);
            while (i != i2) {
                if (z && e.get(this) == 0) {
                    return null;
                }
                i2--;
                g r = r(i2, z);
                if (r != null) {
                    return r;
                }
            }
            return null;
        } while (!androidx.concurrent.futures.a.a(b, this, gVar, (Object) null));
        return gVar;
    }

    public final g a(g gVar, boolean z) {
        if (z) {
            return b(gVar);
        }
        g gVar2 = (g) b.getAndSet(this, gVar);
        if (gVar2 == null) {
            return null;
        }
        return b(gVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long s(int i, Ref$ObjectRef<g> ref$ObjectRef) {
        T t;
        if (i == 3) {
            t = m();
        } else {
            t = q(i);
        }
        if (t != 0) {
            ref$ObjectRef.element = t;
            return -1L;
        }
        return t(i, ref$ObjectRef);
    }

    private final g r(int i, boolean z) {
        int i2 = i & 127;
        g gVar = this.a.get(i2);
        if (gVar != null) {
            boolean z2 = true;
            if (gVar.taskContext.b() != 1) {
                z2 = false;
            }
            if (z2 == z && kotlinx.coroutines.channels.c.a(this.a, i2, gVar, null)) {
                if (z) {
                    e.decrementAndGet(this);
                }
                return gVar;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, kotlinx.coroutines.scheduling.g] */
    private final long t(int i, Ref$ObjectRef<g> ref$ObjectRef) {
        ?? r0;
        boolean z;
        do {
            r0 = (g) b.get(this);
            if (r0 == 0) {
                return -2L;
            }
            int i2 = 1;
            if (r0.taskContext.b() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i2 = 2;
            }
            if ((i2 & i) == 0) {
                return -2L;
            }
            long a = k.f.a() - r0.submissionTime;
            long j = k.b;
            if (a < j) {
                return j - a;
            }
        } while (!androidx.concurrent.futures.a.a(b, this, (Object) r0, (Object) null));
        ref$ObjectRef.element = r0;
        return -1L;
    }
}
