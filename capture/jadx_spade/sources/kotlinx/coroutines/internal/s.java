package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class s<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a;
    private volatile /* synthetic */ Object _cur$volatile;

    static {
        Covode.recordClassIndex(659242);
        a = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_cur$volatile");
    }

    public final int c() {
        return ((t) a.get(this)).g();
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            t tVar = (t) atomicReferenceFieldUpdater.get(this);
            if (tVar.d()) {
                return;
            } else {
                androidx.concurrent.futures.a.a(a, this, tVar, tVar.l());
            }
        }
    }

    public final E e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            t tVar = (t) atomicReferenceFieldUpdater.get(this);
            E e = (E) tVar.m();
            if (e != t.h) {
                return e;
            }
            androidx.concurrent.futures.a.a(a, this, tVar, tVar.l());
        }
    }

    public s(boolean z) {
        this._cur$volatile = new t(8, z);
    }

    public final boolean a(E e) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            t tVar = (t) atomicReferenceFieldUpdater.get(this);
            int a2 = tVar.a(e);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                if (a2 == 2) {
                    return false;
                }
            } else {
                androidx.concurrent.futures.a.a(a, this, tVar, tVar.l());
            }
        }
    }
}
