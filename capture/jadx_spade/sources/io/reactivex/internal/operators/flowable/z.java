package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z extends Flowable<Object> implements nm6.h<Object> {
    public static final Flowable<Object> a;

    @Override // nm6.h, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    private z() {
    }

    static {
        Covode.recordClassIndex(656599);
        a = new z();
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Object> subscriber) {
        EmptySubscription.complete(subscriber);
    }
}
