package io.reactivex.observers;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> implements Observer<T>, Disposable {
    final Observer<? super T> a;
    final boolean b;
    Disposable c;
    boolean d;
    io.reactivex.internal.util.a<Object> e;
    volatile boolean f;

    static {
        Covode.recordClassIndex(657763);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    void a() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.e;
                if (aVar == null) {
                    this.d = false;
                    return;
                }
                this.e = null;
            }
        } while (!aVar.a(this.a));
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f) {
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.d) {
                io.reactivex.internal.util.a<Object> aVar = this.e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.e = aVar;
                }
                aVar.c(NotificationLite.complete());
                return;
            }
            this.f = true;
            this.d = true;
            this.a.onComplete();
        }
    }

    public d(Observer<? super T> observer) {
        this(observer, false);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.c, disposable)) {
            this.c = disposable;
            this.a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f) {
                if (this.d) {
                    this.f = true;
                    io.reactivex.internal.util.a<Object> aVar = this.e;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.e = aVar;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.b) {
                        aVar.c(error);
                    } else {
                        aVar.e(error);
                    }
                    return;
                }
                this.f = true;
                this.d = true;
                z = false;
            }
            if (z) {
                RxJavaPlugins.onError(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (this.f) {
            return;
        }
        if (t == null) {
            this.c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.d) {
                io.reactivex.internal.util.a<Object> aVar = this.e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.e = aVar;
                }
                aVar.c(NotificationLite.next(t));
                return;
            }
            this.d = true;
            this.a.onNext(t);
            a();
        }
    }

    public d(Observer<? super T> observer, boolean z) {
        this.a = observer;
        this.b = z;
    }
}
