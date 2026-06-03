package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b1<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final Publisher<? extends T> b;

    static {
        Covode.recordClassIndex(656818);
    }

    static final class a<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> a;
        final Publisher<? extends T> b;
        boolean d = true;
        final SubscriptionArbiter c = new SubscriptionArbiter(false);

        static {
            Covode.recordClassIndex(656819);
        }

        public void onComplete() {
            if (this.d) {
                this.d = false;
                this.b.subscribe(this);
            } else {
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            this.c.setSubscription(subscription);
        }

        public void onNext(T t) {
            if (this.d) {
                this.d = false;
            }
            this.a.onNext(t);
        }

        a(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.a = subscriber;
            this.b = publisher;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.b);
        subscriber.onSubscribe(aVar.c);
        this.a.subscribe((FlowableSubscriber) aVar);
    }

    public b1(Flowable<T> flowable, Publisher<? extends T> publisher) {
        super(flowable);
        this.b = publisher;
    }
}
