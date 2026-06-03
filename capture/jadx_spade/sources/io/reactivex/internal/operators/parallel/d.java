package io.reactivex.internal.operators.parallel;

import com.bytedance.covode.number.Covode;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> extends ParallelFlowable<T> {
    final ParallelFlowable<T> a;
    final Predicate<? super T> b;
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> c;

    static {
        Covode.recordClassIndex(657491);
    }

    static abstract class b<T> implements nm6.a<T>, Subscription {
        final Predicate<? super T> a;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> b;
        Subscription c;
        boolean d;

        static {
            Covode.recordClassIndex(657492);
        }

        public final void cancel() {
            this.c.cancel();
        }

        public final void request(long j) {
            this.c.request(j);
        }

        public final void onNext(T t) {
            if (!tryOnNext(t) && !this.d) {
                this.c.request(1L);
            }
        }

        b(Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.a = predicate;
            this.b = biFunction;
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    static final class c<T> extends b<T> {
        final nm6.a<? super T> e;

        static {
            Covode.recordClassIndex(657493);
        }

        public void onComplete() {
            if (!this.d) {
                this.d = true;
                this.e.onComplete();
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.e.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.d = true;
                this.e.onError(th);
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            int i;
            if (!this.d) {
                long j = 0;
                do {
                    try {
                        if (!this.a.test(t) || !this.e.tryOnNext(t)) {
                            return false;
                        }
                        return true;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        try {
                            j++;
                            i = a.a[((ParallelFailureHandling) ObjectHelper.requireNonNull(this.b.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            cancel();
                            onError(new CompositeException(th, th2));
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
            return false;
        }

        c(nm6.a<? super T> aVar, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.e = aVar;
        }
    }

    /* renamed from: io.reactivex.internal.operators.parallel.d$d, reason: collision with other inner class name */
    static final class C0187d<T> extends b<T> {
        final Subscriber<? super T> e;

        static {
            Covode.recordClassIndex(657494);
        }

        public void onComplete() {
            if (!this.d) {
                this.d = true;
                this.e.onComplete();
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.e.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.d = true;
                this.e.onError(th);
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            int i;
            if (!this.d) {
                long j = 0;
                do {
                    try {
                        if (!this.a.test(t)) {
                            return false;
                        }
                        this.e.onNext(t);
                        return true;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        try {
                            j++;
                            i = a.a[((ParallelFailureHandling) ObjectHelper.requireNonNull(this.b.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            cancel();
                            onError(new CompositeException(th, th2));
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
            return false;
        }

        C0187d(Subscriber<? super T> subscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.e = subscriber;
        }
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
                subscriberArr2[i] = new c((nm6.a) subscriber, this.b, this.c);
            } else {
                subscriberArr2[i] = new C0187d(subscriber, this.b, this.c);
            }
        }
        this.a.subscribe(subscriberArr2);
    }

    public d(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.a = parallelFlowable;
        this.b = predicate;
        this.c = biFunction;
    }
}
