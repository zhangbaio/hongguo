package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g1<T> extends a<T, T> {
    static {
        Covode.recordClassIndex(657380);
    }

    public g1(Observable<T> observable) {
        super(observable);
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.observers.d(observer));
    }
}
