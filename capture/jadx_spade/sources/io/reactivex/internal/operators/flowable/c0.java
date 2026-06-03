package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c0<T, U> extends Flowable<U> {
    final Publisher<T> a;
    final Function<? super T, ? extends Publisher<? extends U>> b;
    final boolean c;
    final int d;
    final int e;

    static {
        Covode.recordClassIndex(656616);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (u0.b(this.a, subscriber, this.b)) {
            return;
        }
        this.a.subscribe(FlowableFlatMap.b(subscriber, this.b, this.c, this.d, this.e));
    }

    public c0(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        this.a = publisher;
        this.b = function;
        this.c = z;
        this.d = i;
        this.e = i2;
    }
}
