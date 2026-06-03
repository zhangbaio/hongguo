package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class q<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {
    final Function<? super T, ? extends ObservableSource<U>> a;

    static {
        Covode.recordClassIndex(657174);
    }

    static final class a<T, U> implements Observer<T>, Disposable {
        final Observer<? super T> a;
        final Function<? super T, ? extends ObservableSource<U>> b;
        Disposable c;
        final AtomicReference<Disposable> d = new AtomicReference<>();
        volatile long e;
        boolean f;

        static {
            Covode.recordClassIndex(657175);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        /* renamed from: io.reactivex.internal.operators.observable.q$a$a, reason: collision with other inner class name */
        static final class C0181a<T, U> extends io.reactivex.observers.b<U> {
            final a<T, U> b;
            final long c;
            final T d;
            boolean e;
            final AtomicBoolean f = new AtomicBoolean();

            static {
                Covode.recordClassIndex(657176);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.e) {
                    return;
                }
                this.e = true;
                c();
            }

            void c() {
                if (this.f.compareAndSet(false, true)) {
                    this.b.a(this.c, this.d);
                }
            }

            @Override // io.reactivex.Observer
            public void onNext(U u) {
                if (this.e) {
                    return;
                }
                this.e = true;
                dispose();
                c();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (this.e) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.e = true;
                    this.b.onError(th);
                }
            }

            C0181a(a<T, U> aVar, long j, T t) {
                this.b = aVar;
                this.c = j;
                this.d = t;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
            DisposableHelper.dispose(this.d);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            Disposable disposable = this.d.get();
            if (disposable != DisposableHelper.DISPOSED) {
                ((C0181a) disposable).c();
                DisposableHelper.dispose(this.d);
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.d);
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            long j = this.e + 1;
            this.e = j;
            Disposable disposable = this.d.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The ObservableSource supplied is null");
                C0181a c0181a = new C0181a(this, j, t);
                if (androidx.compose.animation.core.g1.a(this.d, disposable, c0181a)) {
                    observableSource.subscribe(c0181a);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.a.onError(th);
            }
        }

        a(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.a = observer;
            this.b = function;
        }

        void a(long j, T t) {
            if (j == this.e) {
                this.a.onNext(t);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(new io.reactivex.observers.d(observer), this.a));
    }

    public q(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.a = function;
    }
}
