package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class r<T> extends Single<Notification<T>> {
    final Completable a;

    static {
        Covode.recordClassIndex(656434);
    }

    public r(Completable completable) {
        this.a = completable;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.a.subscribe(new io.reactivex.internal.operators.mixed.a(singleObserver));
    }
}
