package io.reactivex.internal.operators.parallel;

import com.bytedance.covode.number.Covode;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a<T, R> extends ParallelFlowable<R> {
    final ParallelFlowable<T> a;
    final Function<? super T, ? extends Publisher<? extends R>> b;
    final int c;
    final ErrorMode d;

    static {
        Covode.recordClassIndex(657483);
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (!validate(subscriberArr)) {
            return;
        }
        int length = subscriberArr.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        for (int i = 0; i < length; i++) {
            subscriberArr2[i] = FlowableConcatMap.b(subscriberArr[i], this.b, this.c, this.d);
        }
        this.a.subscribe(subscriberArr2);
    }

    public a(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.a = parallelFlowable;
        this.b = (Function) ObjectHelper.requireNonNull(function, "mapper");
        this.c = i;
        this.d = (ErrorMode) ObjectHelper.requireNonNull(errorMode, "errorMode");
    }
}
