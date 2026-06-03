package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i0<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    static {
        Covode.recordClassIndex(656649);
    }

    static final class a<T> implements FlowableSubscriber<T>, nm6.g<T> {
        final Subscriber<? super T> a;
        Subscription b;

        static {
            Covode.recordClassIndex(656650);
        }

        @Override // nm6.j
        public void clear() {
        }

        @Override // nm6.j
        public boolean isEmpty() {
            return true;
        }

        public void onNext(T t) {
        }

        @Override // nm6.j
        public T poll() {
            return null;
        }

        public void request(long j) {
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return i & 2;
        }

        public void cancel() {
            this.b.cancel();
        }

        public void onComplete() {
            this.a.onComplete();
        }

        a(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // nm6.j
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public i0(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe((FlowableSubscriber) new a(subscriber));
    }
}
