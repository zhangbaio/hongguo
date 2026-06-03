package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m<T, R> extends Flowable<R> {
    final Publisher<T> a;
    final Function<? super T, ? extends Publisher<? extends R>> b;
    final int c;
    final ErrorMode d;

    static {
        Covode.recordClassIndex(656538);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        if (u0.b(this.a, subscriber, this.b)) {
            return;
        }
        this.a.subscribe(FlowableConcatMap.b(subscriber, this.b, this.c, this.d));
    }

    public m(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.a = publisher;
        this.b = function;
        this.c = i;
        this.d = errorMode;
    }
}
