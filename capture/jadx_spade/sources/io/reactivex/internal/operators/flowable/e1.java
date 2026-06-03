package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e1<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final Predicate<? super T> b;

    static {
        Covode.recordClassIndex(656837);
    }

    static final class a<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> a;
        final Predicate<? super T> b;
        Subscription c;
        boolean d;

        static {
            Covode.recordClassIndex(656838);
        }

        public void cancel() {
            this.c.cancel();
        }

        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.a.onComplete();
        }

        public void request(long j) {
            this.c.request(j);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.d = true;
                this.a.onError(th);
            }
        }

        public void onNext(T t) {
            if (this.d) {
                return;
            }
            try {
                if (!this.b.test(t)) {
                    this.d = true;
                    this.c.cancel();
                    this.a.onComplete();
                    return;
                }
                this.a.onNext(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.c.cancel();
                onError(th);
            }
        }

        a(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.a = subscriber;
            this.b = predicate;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe((FlowableSubscriber) new a(subscriber, this.b));
    }

    public e1(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.b = predicate;
    }
}
