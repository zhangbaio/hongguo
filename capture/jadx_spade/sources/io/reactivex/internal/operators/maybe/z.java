package io.reactivex.internal.operators.maybe;

import com.bytedance.covode.number.Covode;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z<T> extends Maybe<T> implements nm6.h<T> {
    final T a;

    static {
        Covode.recordClassIndex(656988);
    }

    @Override // nm6.h, java.util.concurrent.Callable
    public T call() {
        return this.a;
    }

    public z(T t) {
        this.a = t;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        maybeObserver.onSuccess(this.a);
    }
}
