package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d0 extends Observable<Object> implements nm6.h<Object> {
    public static final Observable<Object> a;

    @Override // nm6.h, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    private d0() {
    }

    static {
        Covode.recordClassIndex(657210);
        a = new d0();
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        EmptyDisposable.complete(observer);
    }
}
