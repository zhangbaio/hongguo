package io.reactivex.internal.operators.parallel;

import com.bytedance.covode.number.Covode;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f<T> extends ParallelFlowable<T> {
    final Publisher<T>[] a;

    static {
        Covode.recordClassIndex(657496);
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.length;
    }

    public f(Publisher<T>[] publisherArr) {
        this.a = publisherArr;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (!validate(subscriberArr)) {
            return;
        }
        int length = subscriberArr.length;
        for (int i = 0; i < length; i++) {
            this.a[i].subscribe(subscriberArr[i]);
        }
    }
}
