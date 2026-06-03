package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
abstract class a<T, R> extends Flowable<R> {
    protected final Flowable<T> a;

    static {
        Covode.recordClassIndex(656472);
    }

    a(Flowable<T> flowable) {
        this.a = (Flowable) ObjectHelper.requireNonNull(flowable, "source is null");
    }
}
