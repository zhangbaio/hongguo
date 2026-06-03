package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k1<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {
    final ObservableSource<U> a;

    static {
        Covode.recordClassIndex(657391);
    }

    final class a implements Observer<U> {
        final ArrayCompositeDisposable a;
        final b<T> b;
        final io.reactivex.observers.d<T> c;
        Disposable d;

        static {
            Covode.recordClassIndex(657392);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b.d = true;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.dispose();
            this.c.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            this.d.dispose();
            this.b.d = true;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.setResource(1, disposable);
            }
        }

        a(ArrayCompositeDisposable arrayCompositeDisposable, b<T> bVar, io.reactivex.observers.d<T> dVar) {
            this.a = arrayCompositeDisposable;
            this.b = bVar;
            this.c = dVar;
        }
    }

    static final class b<T> implements Observer<T> {
        final Observer<? super T> a;
        final ArrayCompositeDisposable b;
        Disposable c;
        volatile boolean d;
        boolean e;

        static {
            Covode.recordClassIndex(657393);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b.dispose();
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.b.dispose();
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.e) {
                this.a.onNext(t);
            } else if (this.d) {
                this.e = true;
                this.a.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.b.setResource(0, disposable);
            }
        }

        b(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.a = observer;
            this.b = arrayCompositeDisposable;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        io.reactivex.observers.d dVar = new io.reactivex.observers.d(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        dVar.onSubscribe(arrayCompositeDisposable);
        b bVar = new b(dVar, arrayCompositeDisposable);
        this.a.subscribe(new a(arrayCompositeDisposable, bVar, dVar));
        this.source.subscribe(bVar);
    }

    public k1(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.a = observableSource2;
    }
}
