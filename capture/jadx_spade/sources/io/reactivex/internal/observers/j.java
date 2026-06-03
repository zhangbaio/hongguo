package io.reactivex.internal.observers;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class j<T, U, V> extends l implements Observer<T>, io.reactivex.internal.util.h<U, V> {
    protected final Observer<? super V> b;
    protected final nm6.i<U> c;
    protected volatile boolean d;
    protected volatile boolean e;
    protected Throwable f;

    static {
        Covode.recordClassIndex(656385);
    }

    @Override // io.reactivex.internal.util.h
    public void e(Observer<? super V> observer, U u) {
    }

    @Override // io.reactivex.internal.util.h
    public final boolean a() {
        return this.e;
    }

    @Override // io.reactivex.internal.util.h
    public final boolean b() {
        return this.d;
    }

    @Override // io.reactivex.internal.util.h
    public final Throwable c() {
        return this.f;
    }

    public final boolean f() {
        if (this.a.getAndIncrement() == 0) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (this.a.get() != 0 || !this.a.compareAndSet(0, 1)) {
            return false;
        }
        return true;
    }

    @Override // io.reactivex.internal.util.h
    public final int d(int i) {
        return this.a.addAndGet(i);
    }

    public j(Observer<? super V> observer, nm6.i<U> iVar) {
        this.b = observer;
        this.c = iVar;
    }

    protected final void h(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.b;
        nm6.i<U> iVar = this.c;
        if (this.a.get() == 0 && this.a.compareAndSet(0, 1)) {
            e(observer, u);
            if (d(-1) == 0) {
                return;
            }
        } else {
            iVar.offer(u);
            if (!f()) {
                return;
            }
        }
        io.reactivex.internal.util.k.d(iVar, observer, z, disposable, this);
    }

    protected final void i(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.b;
        nm6.i<U> iVar = this.c;
        if (this.a.get() == 0 && this.a.compareAndSet(0, 1)) {
            if (iVar.isEmpty()) {
                e(observer, u);
                if (d(-1) == 0) {
                    return;
                }
            } else {
                iVar.offer(u);
            }
        } else {
            iVar.offer(u);
            if (!f()) {
                return;
            }
        }
        io.reactivex.internal.util.k.d(iVar, observer, z, disposable, this);
    }
}
