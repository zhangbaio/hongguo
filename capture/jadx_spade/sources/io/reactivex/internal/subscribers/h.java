package io.reactivex.internal.subscribers;

import com.bytedance.covode.number.Covode;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class h<T, U, V> extends l implements FlowableSubscriber<T>, io.reactivex.internal.util.j<U, V> {
    protected final Subscriber<? super V> c;
    protected final nm6.i<U> d;
    protected volatile boolean e;
    protected volatile boolean f;
    protected Throwable g;

    static {
        Covode.recordClassIndex(657699);
    }

    public boolean f(Subscriber<? super V> subscriber, U u) {
        return false;
    }

    @Override // io.reactivex.internal.util.j
    public final boolean a() {
        return this.f;
    }

    @Override // io.reactivex.internal.util.j
    public final boolean b() {
        return this.e;
    }

    @Override // io.reactivex.internal.util.j
    public final Throwable c() {
        return this.g;
    }

    @Override // io.reactivex.internal.util.j
    public final long requested() {
        return this.b.get();
    }

    public final boolean g() {
        if (this.a.getAndIncrement() == 0) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        if (this.a.get() != 0 || !this.a.compareAndSet(0, 1)) {
            return false;
        }
        return true;
    }

    @Override // io.reactivex.internal.util.j
    public final int d(int i) {
        return this.a.addAndGet(i);
    }

    @Override // io.reactivex.internal.util.j
    public final long e(long j) {
        return this.b.addAndGet(-j);
    }

    public final void k(long j) {
        if (SubscriptionHelper.validate(j)) {
            io.reactivex.internal.util.b.a(this.b, j);
        }
    }

    public h(Subscriber<? super V> subscriber, nm6.i<U> iVar) {
        this.c = subscriber;
        this.d = iVar;
    }

    protected final void i(U u, boolean z, Disposable disposable) {
        Subscriber<? super V> subscriber = this.c;
        nm6.i<U> iVar = this.d;
        if (h()) {
            long j = this.b.get();
            if (j != 0) {
                if (f(subscriber, u) && j != Long.MAX_VALUE) {
                    e(1L);
                }
                if (d(-1) == 0) {
                    return;
                }
            } else {
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            iVar.offer(u);
            if (!g()) {
                return;
            }
        }
        io.reactivex.internal.util.k.e(iVar, subscriber, z, disposable, this);
    }

    protected final void j(U u, boolean z, Disposable disposable) {
        Subscriber<? super V> subscriber = this.c;
        nm6.i<U> iVar = this.d;
        if (h()) {
            long j = this.b.get();
            if (j != 0) {
                if (iVar.isEmpty()) {
                    if (f(subscriber, u) && j != Long.MAX_VALUE) {
                        e(1L);
                    }
                    if (d(-1) == 0) {
                        return;
                    }
                } else {
                    iVar.offer(u);
                }
            } else {
                this.e = true;
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            iVar.offer(u);
            if (!g()) {
                return;
            }
        }
        io.reactivex.internal.util.k.e(iVar, subscriber, z, disposable, this);
    }
}
