package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v0<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final BiFunction<T, T, T> b;

    static {
        Covode.recordClassIndex(656787);
    }

    static final class a<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> a;
        final BiFunction<T, T, T> b;
        Subscription c;
        T d;
        boolean e;

        static {
            Covode.recordClassIndex(656788);
        }

        public void cancel() {
            this.c.cancel();
        }

        public void onComplete() {
            if (this.e) {
                return;
            }
            this.e = true;
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
            if (this.e) {
                RxJavaPlugins.onError(th);
            } else {
                this.e = true;
                this.a.onError(th);
            }
        }

        public void onNext(T t) {
            if (this.e) {
                return;
            }
            Subscriber<? super T> subscriber = this.a;
            T t2 = this.d;
            if (t2 == null) {
                this.d = t;
                subscriber.onNext(t);
                return;
            }
            try {
                T t3 = (T) ObjectHelper.requireNonNull(this.b.apply(t2, t), "The value returned by the accumulator is null");
                this.d = t3;
                subscriber.onNext(t3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.c.cancel();
                onError(th);
            }
        }

        a(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.a = subscriber;
            this.b = biFunction;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe((FlowableSubscriber) new a(subscriber, this.b));
    }

    public v0(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.b = biFunction;
    }
}
