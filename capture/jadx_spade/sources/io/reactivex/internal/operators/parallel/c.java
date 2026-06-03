package io.reactivex.internal.operators.parallel;

import com.bytedance.covode.number.Covode;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c<T> extends ParallelFlowable<T> {
    final ParallelFlowable<T> a;
    final Predicate<? super T> b;

    static {
        Covode.recordClassIndex(657487);
    }

    static abstract class a<T> implements nm6.a<T>, Subscription {
        final Predicate<? super T> a;
        Subscription b;
        boolean c;

        static {
            Covode.recordClassIndex(657488);
        }

        public final void cancel() {
            this.b.cancel();
        }

        a(Predicate<? super T> predicate) {
            this.a = predicate;
        }

        public final void request(long j) {
            this.b.request(j);
        }

        public final void onNext(T t) {
            if (!tryOnNext(t) && !this.c) {
                this.b.request(1L);
            }
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    static final class b<T> extends a<T> {
        final nm6.a<? super T> d;

        static {
            Covode.recordClassIndex(657489);
        }

        public void onComplete() {
            if (!this.c) {
                this.c = true;
                this.d.onComplete();
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                this.d.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.d.onError(th);
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            if (!this.c) {
                try {
                    if (this.a.test(t)) {
                        return this.d.tryOnNext(t);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }

        b(nm6.a<? super T> aVar, Predicate<? super T> predicate) {
            super(predicate);
            this.d = aVar;
        }
    }

    /* renamed from: io.reactivex.internal.operators.parallel.c$c, reason: collision with other inner class name */
    static final class C0186c<T> extends a<T> {
        final Subscriber<? super T> d;

        static {
            Covode.recordClassIndex(657490);
        }

        public void onComplete() {
            if (!this.c) {
                this.c = true;
                this.d.onComplete();
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                this.d.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.d.onError(th);
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            if (!this.c) {
                try {
                    if (this.a.test(t)) {
                        this.d.onNext(t);
                        return true;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }

        C0186c(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.d = subscriber;
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (!validate(subscriberArr)) {
            return;
        }
        int length = subscriberArr.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        for (int i = 0; i < length; i++) {
            Subscriber<? super T> subscriber = subscriberArr[i];
            if (subscriber instanceof nm6.a) {
                subscriberArr2[i] = new b((nm6.a) subscriber, this.b);
            } else {
                subscriberArr2[i] = new C0186c(subscriber, this.b);
            }
        }
        this.a.subscribe(subscriberArr2);
    }

    public c(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate) {
        this.a = parallelFlowable;
        this.b = predicate;
    }
}
