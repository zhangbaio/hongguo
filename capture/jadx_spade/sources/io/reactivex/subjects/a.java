package io.reactivex.subjects;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a<T> extends Subject<T> implements a.InterfaceC0192a<Object> {
    final Subject<T> a;
    boolean b;
    io.reactivex.internal.util.a<Object> c;
    volatile boolean d;

    static {
        Covode.recordClassIndex(657824);
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        return this.a.getThrowable();
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.a.hasComplete();
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.a.hasObservers();
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.a.hasThrowable();
    }

    void b() {
        io.reactivex.internal.util.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.c;
                if (aVar == null) {
                    this.b = false;
                    return;
                }
                this.c = null;
            }
            aVar.d(this);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            this.d = true;
            if (this.b) {
                io.reactivex.internal.util.a<Object> aVar = this.c;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.c = aVar;
                }
                aVar.c(NotificationLite.complete());
                return;
            }
            this.b = true;
            this.a.onComplete();
        }
    }

    a(Subject<T> subject) {
        this.a = subject;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(observer);
    }

    @Override // io.reactivex.internal.util.a.InterfaceC0192a, io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.a);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.d) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.d) {
                this.d = true;
                if (this.b) {
                    io.reactivex.internal.util.a<Object> aVar = this.c;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.c = aVar;
                    }
                    aVar.e(NotificationLite.error(th));
                    return;
                }
                this.b = true;
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
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            if (this.b) {
                io.reactivex.internal.util.a<Object> aVar = this.c;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.c = aVar;
                }
                aVar.c(NotificationLite.next(t));
                return;
            }
            this.b = true;
            this.a.onNext(t);
            b();
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        boolean z = true;
        if (!this.d) {
            synchronized (this) {
                if (!this.d) {
                    if (this.b) {
                        io.reactivex.internal.util.a<Object> aVar = this.c;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.c = aVar;
                        }
                        aVar.c(NotificationLite.disposable(disposable));
                        return;
                    }
                    this.b = true;
                    z = false;
                }
            }
        }
        if (z) {
            disposable.dispose();
        } else {
            this.a.onSubscribe(disposable);
            b();
        }
    }
}
