package io.reactivex.internal.queue;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import nm6.i;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a<T> implements i<T> {
    static final int i;
    private static final Object j;
    int b;
    long c;
    final int d;
    AtomicReferenceArray<Object> e;
    final int f;
    AtomicReferenceArray<Object> g;
    final AtomicLong a = new AtomicLong();
    final AtomicLong h = new AtomicLong();

    private static int b(int i2) {
        return i2;
    }

    private long d() {
        return this.h.get();
    }

    private long e() {
        return this.a.get();
    }

    private long f() {
        return this.h.get();
    }

    private long i() {
        return this.a.get();
    }

    @Override // nm6.j
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // nm6.j
    public boolean isEmpty() {
        if (i() == f()) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(657636);
        i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        j = new Object();
    }

    public int n() {
        long f = f();
        while (true) {
            long i2 = i();
            long f2 = f();
            if (f == f2) {
                return (int) (i2 - f2);
            }
            f = f2;
        }
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.g;
        long d = d();
        int i2 = this.f;
        T t = (T) g(atomicReferenceArray, c(d, i2));
        if (t == j) {
            return j(h(atomicReferenceArray, i2 + 1), d, i2);
        }
        return t;
    }

    @Override // nm6.i, nm6.j
    public T poll() {
        boolean z;
        AtomicReferenceArray<Object> atomicReferenceArray = this.g;
        long d = d();
        int i2 = this.f;
        int c = c(d, i2);
        T t = (T) g(atomicReferenceArray, c);
        if (t == j) {
            z = true;
        } else {
            z = false;
        }
        if (t != null && !z) {
            p(atomicReferenceArray, c, null);
            o(d + 1);
            return t;
        }
        if (!z) {
            return null;
        }
        return k(h(atomicReferenceArray, i2 + 1), d, i2);
    }

    private void o(long j2) {
        this.h.lazySet(j2);
    }

    private void r(long j2) {
        this.a.lazySet(j2);
    }

    private void a(int i2) {
        this.b = Math.min(i2 / 4, i);
    }

    public a(int i2) {
        int a = io.reactivex.internal.util.i.a(Math.max(8, i2));
        int i3 = a - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a + 1);
        this.e = atomicReferenceArray;
        this.d = i3;
        a(a);
        this.g = atomicReferenceArray;
        this.f = i3;
        this.c = i3 - 1;
        r(0L);
    }

    @Override // nm6.j
    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.e;
            long e = e();
            int i2 = this.d;
            int c = c(e, i2);
            if (e < this.c) {
                return s(atomicReferenceArray, t, e, c);
            }
            long j2 = this.b + e;
            if (g(atomicReferenceArray, c(j2, i2)) == null) {
                this.c = j2 - 1;
                return s(atomicReferenceArray, t, e, c);
            }
            if (g(atomicReferenceArray, c(1 + e, i2)) == null) {
                return s(atomicReferenceArray, t, e, c);
            }
            m(atomicReferenceArray, e, c, t, i2);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    private static int c(long j2, int i2) {
        return b(((int) j2) & i2);
    }

    private static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int b = b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, b);
        p(atomicReferenceArray, b, null);
        return atomicReferenceArray2;
    }

    private void q(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        p(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    public boolean l(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.e;
        long i2 = i();
        int i3 = this.d;
        long j2 = 2 + i2;
        if (g(atomicReferenceArray, c(j2, i3)) == null) {
            int c = c(i2, i3);
            p(atomicReferenceArray, c + 1, t2);
            p(atomicReferenceArray, c, t);
            r(j2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        int c2 = c(i2, i3);
        p(atomicReferenceArray2, c2 + 1, t2);
        p(atomicReferenceArray2, c2, t);
        q(atomicReferenceArray, atomicReferenceArray2);
        p(atomicReferenceArray, c2, j);
        r(j2);
        return true;
    }

    private static void p(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private T j(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.g = atomicReferenceArray;
        return (T) g(atomicReferenceArray, c(j2, i2));
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.g = atomicReferenceArray;
        int c = c(j2, i2);
        T t = (T) g(atomicReferenceArray, c);
        if (t != null) {
            p(atomicReferenceArray, c, null);
            o(j2 + 1);
        }
        return t;
    }

    private boolean s(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        p(atomicReferenceArray, i2, t);
        r(j2 + 1);
        return true;
    }

    private void m(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.c = (j3 + j2) - 1;
        p(atomicReferenceArray2, i2, t);
        q(atomicReferenceArray, atomicReferenceArray2);
        p(atomicReferenceArray, i2, j);
        r(j2 + 1);
    }
}
