package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z<T> extends a<T, T> {
    private final Consumer<? super Disposable> a;
    private final Action b;

    static {
        Covode.recordClassIndex(657203);
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.observers.g(observer, this.a, this.b));
    }

    public z(Observable<T> observable, Consumer<? super Disposable> consumer, Action action) {
        super(observable);
        this.a = consumer;
        this.b = action;
    }
}
