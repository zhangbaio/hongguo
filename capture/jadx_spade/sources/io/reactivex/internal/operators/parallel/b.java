package io.reactivex.internal.operators.parallel;

import com.bytedance.covode.number.Covode;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b<T> extends ParallelFlowable<T> {
    final ParallelFlowable<T> a;
    final Consumer<? super T> b;
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> c;

    static {
        Covode.recordClassIndex(657484);
    }

    /* renamed from: io.reactivex.internal.operators.parallel.b$b, reason: collision with other inner class name */
    static final class C0185b<T> implements nm6.a<T>, Subscription {
        final nm6.a<? super T> a;
        final Consumer<? super T> b;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> c;
        Subscription d;
        boolean e;

        static {
            Covode.recordClassIndex(657485);
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

        public void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
            } else {
                this.e = true;
                this.a.onError(th);
            }
        }

        public void onNext(T t) {
            if (!tryOnNext(t) && !this.e) {
                this.d.request(1L);
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            int i;
            if (this.e) {
                return false;
            }
            long j = 0;
            do {
                try {
                    this.b.accept(t);
                    return this.a.tryOnNext(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    try {
                        j++;
                        i = a.a[((ParallelFailureHandling) ObjectHelper.requireNonNull(this.c.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(new CompositeException(th, th2));
                        return false;
                    }
                }
            } while (i == 1);
            if (i != 2) {
                if (i != 3) {
                    cancel();
                    onError(th);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }

        C0185b(nm6.a<? super T> aVar, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.a = aVar;
            this.b = consumer;
            this.c = biFunction;
        }
    }

    static final class c<T> implements nm6.a<T>, Subscription {
        final Subscriber<? super T> a;
        final Consumer<? super T> b;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> c;
        Subscription d;
        boolean e;

        static {
            Covode.recordClassIndex(657486);
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

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.d.request(1L);
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
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

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            int i;
            if (this.e) {
                return false;
            }
            long j = 0;
            do {
                try {
                    this.b.accept(t);
                    this.a.onNext(t);
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    try {
                        j++;
                        i = a.a[((ParallelFailureHandling) ObjectHelper.requireNonNull(this.c.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(new CompositeException(th, th2));
                        return false;
                    }
                }
            } while (i == 1);
            if (i != 2) {
                if (i != 3) {
                    cancel();
                    onError(th);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }

        c(Subscriber<? super T> subscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.a = subscriber;
            this.b = consumer;
            this.c = biFunction;
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            a = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
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
                subscriberArr2[i] = new C0185b((nm6.a) subscriber, this.b, this.c);
            } else {
                subscriberArr2[i] = new c(subscriber, this.b, this.c);
            }
        }
        this.a.subscribe(subscriberArr2);
    }

    public b(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.a = parallelFlowable;
        this.b = consumer;
        this.c = biFunction;
    }
}
