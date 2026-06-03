package io.reactivex.internal.operators.single;

import com.bytedance.covode.number.Covode;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class w extends Single<Object> {
    public static final Single<Object> a;

    private w() {
    }

    static {
        Covode.recordClassIndex(657602);
        a = new w();
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Object> singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
