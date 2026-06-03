package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m0<T> extends Observable<T> {
    final ObservableSource<T> a;

    static {
        Covode.recordClassIndex(657239);
    }

    public m0(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(observer);
    }
}
