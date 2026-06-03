package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class r0<T> extends Observable<T> implements nm6.h<T> {
    private final T a;

    static {
        Covode.recordClassIndex(657280);
    }

    @Override // nm6.h, java.util.concurrent.Callable
    public T call() {
        return this.a;
    }

    public r0(T t) {
        this.a = t;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.a);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
