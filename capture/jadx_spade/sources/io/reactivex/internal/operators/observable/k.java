package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.observable.a<T, U> {
    final Callable<? extends ObservableSource<B>> a;
    final Callable<U> b;

    static {
        Covode.recordClassIndex(657132);
    }

    static final class b<T, U extends Collection<? super T>, B> extends io.reactivex.internal.observers.j<T, U, U> implements Disposable {
        final Callable<U> g;
        final Callable<? extends ObservableSource<B>> h;
        Disposable i;
        final AtomicReference<Disposable> j;
        U k;

        static {
            Covode.recordClassIndex(657134);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        void k() {
            DisposableHelper.dispose(this.j);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.d) {
                this.d = true;
                this.i.dispose();
                k();
                if (f()) {
                    this.c.clear();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            synchronized (this) {
                U u = this.k;
                if (u == null) {
                    return;
                }
                this.k = null;
                this.c.offer(u);
                this.e = true;
                if (f()) {
                    io.reactivex.internal.util.k.d(this.c, this.b, false, this, this);
                }
            }
        }

        void l() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.h.call(), "The boundary ObservableSource supplied is null");
                    a aVar = new a(this);
                    if (DisposableHelper.replace(this.j, aVar)) {
                        synchronized (this) {
                            U u2 = this.k;
                            if (u2 == null) {
                                return;
                            }
                            this.k = u;
                            observableSource.subscribe(aVar);
                            h(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.d = true;
                    this.i.dispose();
                    this.b.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                dispose();
                this.b.onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dispose();
            this.b.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.k;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                Observer<? super V> observer = this.b;
                try {
                    this.k = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.h.call(), "The boundary ObservableSource supplied is null");
                        a aVar = new a(this);
                        this.j.set(aVar);
                        observer.onSubscribe(this);
                        if (!this.d) {
                            observableSource.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.d = true;
                        disposable.dispose();
                        EmptyDisposable.error(th, observer);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.d = true;
                    disposable.dispose();
                    EmptyDisposable.error(th2, observer);
                }
            }
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(Observer<? super U> observer, U u) {
            this.b.onNext(u);
        }

        b(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.j = new AtomicReference<>();
            this.g = callable;
            this.h = callable2;
        }
    }

    static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.observers.b<B> {
        final b<T, U, B> b;
        boolean c;

        static {
            Covode.recordClassIndex(657133);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.l();
        }

        a(b<T, U, B> bVar) {
            this.b = bVar;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.b.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            if (this.c) {
                return;
            }
            this.c = true;
            dispose();
            this.b.l();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new b(new io.reactivex.observers.d(observer), this.b, this.a));
    }

    public k(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.a = callable;
        this.b = callable2;
    }
}
