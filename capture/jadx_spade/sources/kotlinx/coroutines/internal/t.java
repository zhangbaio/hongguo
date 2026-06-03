package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t<E> {
    public static final a e;
    private static final /* synthetic */ AtomicReferenceFieldUpdater f;
    private static final /* synthetic */ AtomicLongFieldUpdater g;
    public static final f0 h;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    private final int a;
    private final boolean b;
    private final int c;
    private final /* synthetic */ AtomicReferenceArray d;

    private final /* synthetic */ AtomicReferenceArray f() {
        return this.d;
    }

    public final t<E> l() {
        return c(k());
    }

    private final long k() {
        long j;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j2));
        return j2;
    }

    public final int g() {
        long j = g.get(this);
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final boolean j() {
        long j = g.get(this);
        if (((int) ((1073741823 & j) >> 0)) != ((int) ((j & 1152921503533105152L) >> 30))) {
            return false;
        }
        return true;
    }

    static {
        Covode.recordClassIndex(659243);
        e = new a(null);
        f = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "_next$volatile");
        g = AtomicLongFieldUpdater.newUpdater(t.class, "_state$volatile");
        h = new f0("REMOVE_FROZEN");
    }

    public final boolean d() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j) != 0) {
                return h;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if ((i2 & i3) == (i3 & i)) {
                return null;
            }
            Object obj = f().get(this.c & i);
            if (obj == null) {
                if (this.b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i4 = (i + 1) & 1073741823;
                if (g.compareAndSet(this, j, e.b(j, i4))) {
                    f().set(this.c & i, null);
                    return obj;
                }
                if (this.b) {
                    t<E> tVar = this;
                    do {
                        tVar = tVar.n(i, i4);
                    } while (tVar != null);
                    return obj;
                }
            }
        }
    }

    public static final class b {
        public final int a;

        static {
            Covode.recordClassIndex(659245);
        }

        public b(int i) {
            this.a = i;
        }
    }

    private final t<E> c(long j) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        while (true) {
            t<E> tVar = (t) atomicReferenceFieldUpdater.get(this);
            if (tVar != null) {
                return tVar;
            }
            androidx.concurrent.futures.a.a(f, this, (Object) null, b(j));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final t<E> b(long j) {
        t<E> tVar = new t<>(this.a * 2, this.b);
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.c;
            if ((i & i3) != (i3 & i2)) {
                Object obj = f().get(this.c & i);
                if (obj == null) {
                    obj = new b(i);
                }
                tVar.f().set(tVar.c & i, obj);
                i++;
            } else {
                g.set(tVar, e.d(j, 1152921504606846976L));
                return tVar;
            }
        }
    }

    public final int a(E e2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return e.a(j);
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.b && f().get(i2 & i3) != null) {
                int i4 = this.a;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    break;
                }
            } else if (g.compareAndSet(this, j, e.c(j, (i2 + 1) & 1073741823))) {
                f().set(i2 & i3, e2);
                t<E> tVar = this;
                while ((g.get(tVar) & 1152921504606846976L) != 0 && (tVar = tVar.l().e(i2, e2)) != null) {
                }
                return 0;
            }
        }
        return 1;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(659244);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }

        public final long b(long j, int i) {
            return d(j, 1073741823L) | (i << 0);
        }

        public final long c(long j, int i) {
            return d(j, 1152921503533105152L) | (i << 30);
        }
    }

    public t(int i, boolean z) {
        boolean z2;
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 <= 1073741823) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if ((i & i2) == 0) {
                return;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final t<E> e(int i, E e2) {
        Object obj = f().get(this.c & i);
        if ((obj instanceof b) && ((b) obj).a == i) {
            f().set(i & this.c, e2);
            return this;
        }
        return null;
    }

    private final t<E> n(int i, int i2) {
        long j;
        int i3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j = atomicLongFieldUpdater.get(this);
            i3 = (int) ((1073741823 & j) >> 0);
            if ((1152921504606846976L & j) != 0) {
                return l();
            }
        } while (!g.compareAndSet(this, j, e.b(j, i2)));
        f().set(this.c & i3, null);
        return null;
    }
}
