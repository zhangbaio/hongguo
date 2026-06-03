package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.l0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class k0<T extends l0 & Comparable<? super T>> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b;
    private volatile /* synthetic */ int _size$volatile;
    private T[] a;

    static {
        Covode.recordClassIndex(659274);
        b = AtomicIntegerFieldUpdater.newUpdater(k0.class, "_size$volatile");
    }

    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return b.get(this);
    }

    public final boolean e() {
        if (c() == 0) {
            return true;
        }
        return false;
    }

    public final T f() {
        T b2;
        synchronized (this) {
            b2 = b();
        }
        return b2;
    }

    public final T j() {
        T t;
        synchronized (this) {
            if (c() > 0) {
                t = i(0);
            } else {
                t = null;
            }
        }
        return t;
    }

    private final T[] g() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new l0[4];
            this.a = tArr2;
            return tArr2;
        }
        if (c() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            T[] tArr3 = (T[]) ((l0[]) copyOf);
            this.a = tArr3;
            return tArr3;
        }
        return tArr;
    }

    private final void k(int i) {
        b.set(this, i);
    }

    public final void a(T t) {
        t.a(this);
        T[] g = g();
        int c = c();
        k(c + 1);
        g[c] = t;
        t.setIndex(c);
        m(c);
    }

    public final boolean h(T t) {
        boolean z;
        synchronized (this) {
            if (t.c() == null) {
                z = false;
            } else {
                i(t.getIndex());
                z = true;
            }
        }
        return z;
    }

    private final void m(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            n(i, i2);
            i = i2;
        }
    }

    private final void l(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= c()) {
                return;
            }
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i3 = i2 + 1;
            if (i3 < c()) {
                T t = tArr[i3];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i2];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            Intrinsics.checkNotNull(t3);
            T t4 = tArr[i2];
            Intrinsics.checkNotNull(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            n(i, i2);
            i = i2;
        }
    }

    public final T i(int i) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        k(c() - 1);
        if (i < c()) {
            n(i, c());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i2];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    n(i, i2);
                    m(i2);
                }
            }
            l(i);
        }
        T t3 = tArr[c()];
        Intrinsics.checkNotNull(t3);
        t3.a(null);
        t3.setIndex(-1);
        tArr[c()] = null;
        return t3;
    }

    private final void n(int i, int i2) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[i2];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics.checkNotNull(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }
}
