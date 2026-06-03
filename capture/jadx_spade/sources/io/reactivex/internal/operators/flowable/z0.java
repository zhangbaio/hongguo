package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z0<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final long b;

    static {
        Covode.recordClassIndex(656804);
    }

    static final class a<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> a;
        long b;
        Subscription c;

        static {
            Covode.recordClassIndex(656805);
        }

        public void cancel() {
            this.c.cancel();
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void request(long j) {
            this.c.request(j);
        }

        public void onNext(T t) {
            long j = this.b;
            if (j != 0) {
                this.b = j - 1;
            } else {
                this.a.onNext(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                long j = this.b;
                this.c = subscription;
                this.a.onSubscribe(this);
                subscription.request(j);
            }
        }

        a(Subscriber<? super T> subscriber, long j) {
            this.a = subscriber;
            this.b = j;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe((FlowableSubscriber) new a(subscriber, this.b));
    }

    public z0(Flowable<T> flowable, long j) {
        super(flowable);
        this.b = j;
    }
}
