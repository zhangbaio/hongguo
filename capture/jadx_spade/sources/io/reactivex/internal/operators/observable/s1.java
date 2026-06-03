package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class s1<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {
    final Callable<U> a;

    static {
        Covode.recordClassIndex(657438);
    }

    static final class a<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final Observer<? super U> a;
        Disposable b;
        U c;

        static {
            Covode.recordClassIndex(657439);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u = this.c;
            this.c = null;
            this.a.onNext(u);
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.c.add(t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.c = null;
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.b, disposable)) {
                this.b = disposable;
                this.a.onSubscribe(this);
            }
        }

        a(Observer<? super U> observer, U u) {
            this.a = observer;
            this.c = u;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        try {
            this.source.subscribe(new a(observer, (Collection) ObjectHelper.requireNonNull(this.a.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }

    public s1(ObservableSource<T> observableSource, Callable<U> callable) {
        super(observableSource);
        this.a = callable;
    }

    public s1(ObservableSource<T> observableSource, int i) {
        super(observableSource);
        this.a = Functions.createArrayList(i);
    }
}
