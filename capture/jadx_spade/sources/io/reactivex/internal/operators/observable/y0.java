package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class y0 extends Observable<Object> {
    public static final Observable<Object> a;

    private y0() {
    }

    static {
        Covode.recordClassIndex(657301);
        a = new y0();
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        observer.onSubscribe(EmptyDisposable.NEVER);
    }
}
