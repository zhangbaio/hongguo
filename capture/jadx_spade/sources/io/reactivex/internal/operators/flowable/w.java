package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class w<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    private final Consumer<? super Subscription> b;
    private final lm6.a c;
    private final Action d;

    static {
        Covode.recordClassIndex(656591);
    }

    static final class a<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> a;
        final Consumer<? super Subscription> b;
        final lm6.a c;
        final Action d;
        Subscription e;

        static {
            Covode.recordClassIndex(656592);
        }

        public void onComplete() {
            if (this.e != SubscriptionHelper.CANCELLED) {
                this.a.onComplete();
            }
        }

        public void cancel() {
            Subscription subscription = this.e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.e = subscriptionHelper;
                try {
                    this.d.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
                subscription.cancel();
            }
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        public void onError(Throwable th) {
            if (this.e != SubscriptionHelper.CANCELLED) {
                this.a.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        public void request(long j) {
            try {
                this.c.accept(j);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.e.request(j);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            try {
                this.b.accept(subscription);
                if (SubscriptionHelper.validate(this.e, subscription)) {
                    this.e = subscription;
                    this.a.onSubscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                subscription.cancel();
                this.e = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th, this.a);
            }
        }

        a(Subscriber<? super T> subscriber, Consumer<? super Subscription> consumer, lm6.a aVar, Action action) {
            this.a = subscriber;
            this.b = consumer;
            this.d = action;
            this.c = aVar;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.c, this.d));
    }

    public w(Flowable<T> flowable, Consumer<? super Subscription> consumer, lm6.a aVar, Action action) {
        super(flowable);
        this.b = consumer;
        this.c = aVar;
        this.d = action;
    }
}
