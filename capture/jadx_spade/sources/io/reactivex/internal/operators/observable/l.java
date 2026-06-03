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
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.observable.a<T, U> {
    final ObservableSource<B> a;
    final Callable<U> b;

    static {
        Covode.recordClassIndex(657135);
    }

    static final class b<T, U extends Collection<? super T>, B> extends io.reactivex.internal.observers.j<T, U, U> implements Disposable {
        final Callable<U> g;
        final ObservableSource<B> h;
        Disposable i;
        Disposable j;
        U k;

        static {
            Covode.recordClassIndex(657137);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.d) {
                this.d = true;
                this.j.dispose();
                this.i.dispose();
                if (f()) {
                    this.c.clear();
                }
            }
        }

        void k() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.k;
                    if (u2 == null) {
                        return;
                    }
                    this.k = u;
                    h(u2, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.b.onError(th);
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
                try {
                    this.k = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.j = aVar;
                    this.b.onSubscribe(this);
                    if (!this.d) {
                        this.h.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.d = true;
                    disposable.dispose();
                    EmptyDisposable.error(th, this.b);
                }
            }
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(Observer<? super U> observer, U u) {
            this.b.onNext(u);
        }

        b(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.g = callable;
            this.h = observableSource;
        }
    }

    static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.observers.b<B> {
        final b<T, U, B> b;

        static {
            Covode.recordClassIndex(657136);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b.onComplete();
        }

        a(b<T, U, B> bVar) {
            this.b = bVar;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.b.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            this.b.k();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new b(new io.reactivex.observers.d(observer), this.b, this.a));
    }

    public l(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Callable<U> callable) {
        super(observableSource);
        this.a = observableSource2;
        this.b = callable;
    }
}
