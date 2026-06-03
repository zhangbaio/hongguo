package io.reactivex.processors;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.CheckReturnValue;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<T> extends Flowable<T> implements qp6.a<T, T>, FlowableSubscriber<T> {
    static {
        Covode.recordClassIndex(657775);
    }

    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasSubscribers();

    public abstract boolean hasThrowable();

    @CheckReturnValue
    public final a<T> toSerialized() {
        if (this instanceof b) {
            return this;
        }
        return new b(this);
    }
}
