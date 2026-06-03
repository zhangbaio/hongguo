package io.reactivex.internal.operators.single;

import com.bytedance.covode.number.Covode;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class s<T> extends Single<T> {
    final T a;

    static {
        Covode.recordClassIndex(657597);
    }

    public s(T t) {
        this.a = t;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(Disposables.disposed());
        singleObserver.onSuccess(this.a);
    }
}
