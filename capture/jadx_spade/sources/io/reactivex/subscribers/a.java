package io.reactivex.subscribers;

import com.bytedance.covode.number.Covode;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.f;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<T> implements FlowableSubscriber<T> {
    Subscription a;

    static {
        Covode.recordClassIndex(657830);
    }

    protected void a() {
        b(Long.MAX_VALUE);
    }

    protected final void b(long j) {
        Subscription subscription = this.a;
        if (subscription != null) {
            subscription.request(j);
        }
    }

    @Override // io.reactivex.FlowableSubscriber
    public final void onSubscribe(Subscription subscription) {
        if (f.f(this.a, subscription, getClass())) {
            this.a = subscription;
            a();
        }
    }
}
