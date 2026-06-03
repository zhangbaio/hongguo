package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k0<T> extends Flowable<T> implements nm6.h<T> {
    private final T a;

    static {
        Covode.recordClassIndex(656676);
    }

    @Override // nm6.h, java.util.concurrent.Callable
    public T call() {
        return this.a;
    }

    public k0(T t) {
        this.a = t;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new ScalarSubscription(subscriber, this.a));
    }
}
