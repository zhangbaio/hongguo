package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t<T, U> extends Observable<T> {
    final ObservableSource<? extends T> a;
    final ObservableSource<U> b;

    static {
        Covode.recordClassIndex(657186);
    }

    final class a implements Observer<U> {
        final SequentialDisposable a;
        final Observer<? super T> b;
        boolean c;

        static {
            Covode.recordClassIndex(657187);
        }

        /* renamed from: io.reactivex.internal.operators.observable.t$a$a, reason: collision with other inner class name */
        final class C0183a implements Observer<T> {
            static {
                Covode.recordClassIndex(657188);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                a.this.b.onComplete();
            }

            C0183a() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                a.this.b.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(T t) {
                a.this.b.onNext(t);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                a.this.a.update(disposable);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            t.this.a.subscribe(new C0183a());
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.a.update(disposable);
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

        a(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.a = sequentialDisposable;
            this.b = observer;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.b.subscribe(new a(sequentialDisposable, observer));
    }

    public t(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.a = observableSource;
        this.b = observableSource2;
    }
}
