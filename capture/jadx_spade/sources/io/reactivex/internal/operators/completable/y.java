package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class y<T> extends Flowable<T> {
    final CompletableSource a;

    static {
        Covode.recordClassIndex(656465);
    }

    public y(CompletableSource completableSource) {
        this.a = completableSource;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe(new io.reactivex.internal.observers.o(subscriber));
    }
}
