package io.reactivex.internal.operators.single;

import com.bytedance.covode.number.Covode;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v<T> extends Single<Notification<T>> {
    final Single<T> a;

    static {
        Covode.recordClassIndex(657601);
    }

    public v(Single<T> single) {
        this.a = single;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.a.subscribe(new io.reactivex.internal.operators.mixed.a(singleObserver));
    }
}
