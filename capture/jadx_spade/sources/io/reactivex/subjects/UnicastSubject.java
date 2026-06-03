package io.reactivex.subjects;

import androidx.compose.animation.core.g1;
import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import nm6.j;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class UnicastSubject<T> extends Subject<T> {
    final io.reactivex.internal.queue.a<T> a;
    final AtomicReference<Observer<? super T>> b;
    final AtomicReference<Runnable> c;
    final boolean d;
    volatile boolean e;
    volatile boolean f;
    Throwable g;
    final AtomicBoolean h;
    final BasicIntQueueDisposable<T> i;
    boolean j;

    static {
        Covode.recordClassIndex(657828);
    }

    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        static {
            Covode.recordClassIndex(657829);
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, nm6.j
        public void clear() {
            UnicastSubject.this.a.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return UnicastSubject.this.e;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, nm6.j
        public boolean isEmpty() {
            return UnicastSubject.this.a.isEmpty();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, nm6.j
        public T poll() throws Exception {
            return UnicastSubject.this.a.poll();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!UnicastSubject.this.e) {
                UnicastSubject.this.e = true;
                UnicastSubject.this.e();
                UnicastSubject.this.b.lazySet(null);
                if (UnicastSubject.this.i.getAndIncrement() == 0) {
                    UnicastSubject.this.b.lazySet(null);
                    UnicastSubject.this.a.clear();
                }
            }
        }

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, nm6.f
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastSubject.this.j = true;
                return 2;
            }
            return 0;
        }
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> b() {
        return new UnicastSubject<>(Observable.bufferSize(), true);
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.f) {
            return this.g;
        }
        return null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        if (this.f && this.g == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        if (this.b.get() != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        if (this.f && this.g != null) {
            return true;
        }
        return false;
    }

    void e() {
        Runnable runnable = this.c.get();
        if (runnable != null && g1.a(this.c, runnable, (Object) null)) {
            runnable.run();
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.f && !this.e) {
            this.f = true;
            e();
            f();
        }
    }

    void f() {
        if (this.i.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.b.get();
        int i = 1;
        while (observer == null) {
            i = this.i.addAndGet(-i);
            if (i == 0) {
                return;
            } else {
                observer = this.b.get();
            }
        }
        if (this.j) {
            g(observer);
        } else {
            h(observer);
        }
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> c(int i) {
        return new UnicastSubject<>(i, true);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f || this.e) {
            disposable.dispose();
        }
    }

    void i(Observer<? super T> observer) {
        this.b.lazySet(null);
        Throwable th = this.g;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f && !this.e) {
            this.g = th;
            this.f = true;
            e();
            f();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f && !this.e) {
            this.a.offer(t);
            f();
        }
    }

    void g(Observer<? super T> observer) {
        io.reactivex.internal.queue.a<T> aVar = this.a;
        int i = 1;
        boolean z = !this.d;
        while (!this.e) {
            boolean z2 = this.f;
            if (z && z2 && j(aVar, observer)) {
                return;
            }
            observer.onNext(null);
            if (z2) {
                i(observer);
                return;
            } else {
                i = this.i.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
        this.b.lazySet(null);
        aVar.clear();
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        if (!this.h.get() && this.h.compareAndSet(false, true)) {
            observer.onSubscribe(this.i);
            this.b.lazySet(observer);
            if (this.e) {
                this.b.lazySet(null);
                return;
            } else {
                f();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
    }

    void h(Observer<? super T> observer) {
        boolean z;
        io.reactivex.internal.queue.a<T> aVar = this.a;
        boolean z2 = !this.d;
        boolean z3 = true;
        int i = 1;
        while (!this.e) {
            boolean z4 = this.f;
            T poll = this.a.poll();
            if (poll == null) {
                z = true;
            } else {
                z = false;
            }
            if (z4) {
                if (z2 && z3) {
                    if (j(aVar, observer)) {
                        return;
                    } else {
                        z3 = false;
                    }
                }
                if (z) {
                    i(observer);
                    return;
                }
            }
            if (z) {
                i = this.i.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.b.lazySet(null);
        aVar.clear();
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> d(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable, true);
    }

    boolean j(j<T> jVar, Observer<? super T> observer) {
        Throwable th = this.g;
        if (th != null) {
            this.b.lazySet(null);
            jVar.clear();
            observer.onError(th);
            return true;
        }
        return false;
    }

    UnicastSubject(int i, boolean z) {
        this.a = new io.reactivex.internal.queue.a<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.c = new AtomicReference<>();
        this.d = z;
        this.b = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable();
    }

    UnicastSubject(int i, Runnable runnable, boolean z) {
        this.a = new io.reactivex.internal.queue.a<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.c = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.d = z;
        this.b = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable();
    }
}
