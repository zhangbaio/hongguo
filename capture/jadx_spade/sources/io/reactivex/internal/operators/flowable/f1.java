package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f1<T> extends io.reactivex.internal.operators.flowable.a<T, Timed<T>> {
    final Scheduler b;
    final TimeUnit c;

    static {
        Covode.recordClassIndex(656843);
    }

    static final class a<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super Timed<T>> a;
        final TimeUnit b;
        final Scheduler c;
        Subscription d;
        long e;

        static {
            Covode.recordClassIndex(656844);
        }

        public void cancel() {
            this.d.cancel();
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void request(long j) {
            this.d.request(j);
        }

        public void onNext(T t) {
            long now = this.c.now(this.b);
            long j = this.e;
            this.e = now;
            this.a.onNext(new Timed(t, now - j, this.b));
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.e = this.c.now(this.b);
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        a(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = subscriber;
            this.c = scheduler;
            this.b = timeUnit;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Timed<T>> subscriber) {
        this.a.subscribe((FlowableSubscriber) new a(subscriber, this.c, this.b));
    }

    public f1(Flowable<T> flowable, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.b = scheduler;
        this.c = timeUnit;
    }
}
