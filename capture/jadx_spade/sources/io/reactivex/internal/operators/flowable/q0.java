package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class q0 extends Flowable<Object> {
    public static final Flowable<Object> a;

    private q0() {
    }

    static {
        Covode.recordClassIndex(656701);
        a = new q0();
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Object> subscriber) {
        subscriber.onSubscribe(EmptySubscription.INSTANCE);
    }
}
