package io.reactivex.internal.operators.maybe;

import com.bytedance.covode.number.Covode;
import io.reactivex.Maybe;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c0<T> extends Single<Notification<T>> {
    final Maybe<T> a;

    static {
        Covode.recordClassIndex(656992);
    }

    public c0(Maybe<T> maybe) {
        this.a = maybe;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.a.subscribe(new io.reactivex.internal.operators.mixed.a(singleObserver));
    }
}
