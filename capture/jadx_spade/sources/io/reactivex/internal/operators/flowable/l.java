package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l<T, R> extends Flowable<R> {
    final Publisher<T> a;
    final Function<? super T, ? extends Publisher<? extends R>> b;
    final int c;
    final int d;
    final ErrorMode e;

    static {
        Covode.recordClassIndex(656537);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.a.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.b, this.c, this.d, this.e));
    }

    public l(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        this.a = publisher;
        this.b = function;
        this.c = i;
        this.d = i2;
        this.e = errorMode;
    }
}
