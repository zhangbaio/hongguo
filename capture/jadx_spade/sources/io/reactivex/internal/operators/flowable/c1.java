package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c1<T> extends Flowable<T> {
    final Publisher<T> a;
    final long b;

    static {
        Covode.recordClassIndex(656831);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.b));
    }

    public c1(Publisher<T> publisher, long j) {
        this.a = publisher;
        this.b = j;
    }
}
