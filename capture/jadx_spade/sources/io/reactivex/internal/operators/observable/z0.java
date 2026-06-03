package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z0<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> a;
    final boolean b;

    static {
        Covode.recordClassIndex(657304);
    }

    @Override // io.reactivex.internal.operators.observable.a, io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public /* bridge */ /* synthetic */ ObservableSource source() {
        return super.source();
    }

    static final class a<T> implements Observer<T> {
        final Observer<? super T> a;
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> b;
        final boolean c;
        final SequentialDisposable d = new SequentialDisposable();
        boolean e;
        boolean f;

        static {
            Covode.recordClassIndex(657305);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.e = true;
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.d.replace(disposable);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            this.a.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.e) {
                if (this.f) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.a.onError(th);
                    return;
                }
            }
            this.e = true;
            if (this.c && !(th instanceof Exception)) {
                this.a.onError(th);
                return;
            }
            try {
                ObservableSource<? extends T> apply = this.b.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Observable is null");
                    nullPointerException.initCause(th);
                    this.a.onError(nullPointerException);
                    return;
                }
                apply.subscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        a(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = z;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer, this.a, this.b);
        observer.onSubscribe(aVar.d);
        this.source.subscribe(aVar);
    }

    public z0(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
        super(observableSource);
        this.a = function;
        this.b = z;
    }
}
