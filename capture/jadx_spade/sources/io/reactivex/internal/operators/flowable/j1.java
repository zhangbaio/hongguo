package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j1<T, U, V> extends io.reactivex.internal.operators.flowable.a<T, V> {
    final Iterable<U> b;
    final BiFunction<? super T, ? super U, ? extends V> c;

    static {
        Covode.recordClassIndex(656899);
    }

    static final class a<T, U, V> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super V> a;
        final Iterator<U> b;
        final BiFunction<? super T, ? super U, ? extends V> c;
        Subscription d;
        boolean e;

        static {
            Covode.recordClassIndex(656900);
        }

        public void cancel() {
            this.d.cancel();
        }

        public void onComplete() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.a.onComplete();
        }

        public void request(long j) {
            this.d.request(j);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        void a(Throwable th) {
            Exceptions.throwIfFatal(th);
            this.e = true;
            this.d.cancel();
            this.a.onError(th);
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
            try {
                try {
                    this.a.onNext(ObjectHelper.requireNonNull(this.c.apply(t, ObjectHelper.requireNonNull(this.b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (!this.b.hasNext()) {
                            this.e = true;
                            this.d.cancel();
                            this.a.onComplete();
                        }
                    } catch (Throwable th) {
                        a(th);
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
            } catch (Throwable th3) {
                a(th3);
            }
        }

        a(Subscriber<? super V> subscriber, Iterator<U> it2, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.a = subscriber;
            this.b = it2;
            this.c = biFunction;
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super V> subscriber) {
        try {
            Iterator it2 = (Iterator) ObjectHelper.requireNonNull(this.b.iterator(), "The iterator returned by other is null");
            try {
                if (!it2.hasNext()) {
                    EmptySubscription.complete(subscriber);
                } else {
                    this.a.subscribe((FlowableSubscriber) new a(subscriber, it2, this.c));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }

    public j1(Flowable<T> flowable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.b = iterable;
        this.c = biFunction;
    }
}
