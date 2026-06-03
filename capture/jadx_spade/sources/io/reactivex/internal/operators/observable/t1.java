package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t1<T, U extends Collection<? super T>> extends Single<U> implements nm6.d<U> {
    final ObservableSource<T> a;
    final Callable<U> b;

    static {
        Covode.recordClassIndex(657440);
    }

    static final class a<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final SingleObserver<? super U> a;
        U b;
        Disposable c;

        static {
            Covode.recordClassIndex(657441);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u = this.b;
            this.b = null;
            this.a.onSuccess(u);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.b.add(t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.b = null;
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }

        a(SingleObserver<? super U> singleObserver, U u) {
            this.a = singleObserver;
            this.b = u;
        }
    }

    @Override // nm6.d
    public Observable<U> b() {
        return RxJavaPlugins.onAssembly(new s1(this.a, this.b));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.a.subscribe(new a(singleObserver, (Collection) ObjectHelper.requireNonNull(this.b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }

    public t1(ObservableSource<T> observableSource, Callable<U> callable) {
        this.a = observableSource;
        this.b = callable;
    }

    public t1(ObservableSource<T> observableSource, int i) {
        this.a = observableSource;
        this.b = Functions.createArrayList(i);
    }
}
