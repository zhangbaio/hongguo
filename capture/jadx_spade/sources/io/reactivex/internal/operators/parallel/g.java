package io.reactivex.internal.operators.parallel;

import com.bytedance.covode.number.Covode;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g<T, R> extends ParallelFlowable<R> {
    final ParallelFlowable<T> a;
    final Function<? super T, ? extends R> b;

    static {
        Covode.recordClassIndex(657505);
    }

    static final class a<T, R> implements nm6.a<T>, Subscription {
        final nm6.a<? super R> a;
        final Function<? super T, ? extends R> b;
        Subscription c;
        boolean d;

        static {
            Covode.recordClassIndex(657506);
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
                this.a.onNext(ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            if (this.d) {
                return false;
            }
            try {
                return this.a.tryOnNext(ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
                return false;
            }
        }

        a(nm6.a<? super R> aVar, Function<? super T, ? extends R> function) {
            this.a = aVar;
            this.b = function;
        }
    }

    static final class b<T, R> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super R> a;
        final Function<? super T, ? extends R> b;
        Subscription c;
        boolean d;

        static {
            Covode.recordClassIndex(657507);
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
                this.a.onNext(ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
            }
        }

        b(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function) {
            this.a = subscriber;
            this.b = function;
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (!validate(subscriberArr)) {
            return;
        }
        int length = subscriberArr.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        for (int i = 0; i < length; i++) {
            Subscriber<? super R> subscriber = subscriberArr[i];
            if (subscriber instanceof nm6.a) {
                subscriberArr2[i] = new a((nm6.a) subscriber, this.b);
            } else {
                subscriberArr2[i] = new b(subscriber, this.b);
            }
        }
        this.a.subscribe(subscriberArr2);
    }

    public g(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function) {
        this.a = parallelFlowable;
        this.b = function;
    }
}
