package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.o0;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p0<T, U> extends Flowable<U> {
    final Publisher<T> a;
    final Function<? super T, ? extends U> b;

    static {
        Covode.recordClassIndex(656689);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        this.a.subscribe(new o0.b(subscriber, this.b));
    }

    public p0(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.a = publisher;
        this.b = function;
    }
}
