package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class r<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    static {
        Covode.recordClassIndex(656575);
    }

    static final class a<T> implements FlowableSubscriber<T>, Subscription {
        Subscriber<? super T> a;
        Subscription b;

        static {
            Covode.recordClassIndex(656576);
        }

        public void cancel() {
            Subscription subscription = this.b;
            this.b = EmptyComponent.INSTANCE;
            this.a = EmptyComponent.asSubscriber();
            subscription.cancel();
        }

        public void onComplete() {
            Subscriber<? super T> subscriber = this.a;
            this.b = EmptyComponent.INSTANCE;
            this.a = EmptyComponent.asSubscriber();
            subscriber.onComplete();
        }

        a(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        public void request(long j) {
            this.b.request(j);
        }

        public void onError(Throwable th) {
            Subscriber<? super T> subscriber = this.a;
            this.b = EmptyComponent.INSTANCE;
            this.a = EmptyComponent.asSubscriber();
            subscriber.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                this.a.onSubscribe(this);
            }
        }
    }

    public r(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe((FlowableSubscriber) new a(subscriber));
    }
}
