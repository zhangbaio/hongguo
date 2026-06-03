package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g0<T> extends Flowable<T> {
    final Publisher<? extends T> a;

    static {
        Covode.recordClassIndex(656634);
    }

    public g0(Publisher<? extends T> publisher) {
        this.a = publisher;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe(subscriber);
    }
}
