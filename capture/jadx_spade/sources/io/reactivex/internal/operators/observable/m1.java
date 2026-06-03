package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m1<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final ObservableSource<? extends T> a;

    static {
        Covode.recordClassIndex(657399);
    }

    static final class a<T> implements Observer<T> {
        final Observer<? super T> a;
        final ObservableSource<? extends T> b;
        boolean d = true;
        final SequentialDisposable c = new SequentialDisposable();

        static {
            Covode.recordClassIndex(657400);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.d) {
                this.d = false;
                this.b.subscribe(this);
            } else {
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.c.update(disposable);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.d) {
                this.d = false;
            }
            this.a.onNext(t);
        }

        a(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.a = observer;
            this.b = observableSource;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer, this.a);
        observer.onSubscribe(aVar.c);
        this.source.subscribe(aVar);
    }

    public m1(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.a = observableSource2;
    }
}
