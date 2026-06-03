package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final boolean e;

    static {
        Covode.recordClassIndex(656565);
    }

    static final class a<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler.Worker d;
        final boolean e;
        Subscription f;

        static {
            Covode.recordClassIndex(656566);
        }

        final class c implements Runnable {
            private final T a;

            static {
                Covode.recordClassIndex(656569);
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onNext(this.a);
            }

            c(T t) {
                this.a = t;
            }
        }

        public void cancel() {
            this.f.cancel();
            this.d.dispose();
        }

        public void onComplete() {
            this.d.schedule(new RunnableC0179a(), this.b, this.c);
        }

        /* renamed from: io.reactivex.internal.operators.flowable.p$a$a, reason: collision with other inner class name */
        final class RunnableC0179a implements Runnable {
            static {
                Covode.recordClassIndex(656567);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onComplete();
                } finally {
                    a.this.d.dispose();
                }
            }

            RunnableC0179a() {
            }
        }

        final class b implements Runnable {
            private final Throwable a;

            static {
                Covode.recordClassIndex(656568);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onError(this.a);
                } finally {
                    a.this.d.dispose();
                }
            }

            b(Throwable th) {
                this.a = th;
            }
        }

        public void request(long j) {
            this.f.request(j);
        }

        public void onNext(T t) {
            this.d.schedule(new c(t), this.b, this.c);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            long j;
            Scheduler.Worker worker = this.d;
            b bVar = new b(th);
            if (this.e) {
                j = this.b;
            } else {
                j = 0;
            }
            worker.schedule(bVar, j, this.c);
        }

        a(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
            this.e = z;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Subscriber<? super T> dVar;
        if (this.e) {
            dVar = subscriber;
        } else {
            dVar = new io.reactivex.subscribers.d(subscriber);
        }
        this.a.subscribe((FlowableSubscriber) new a(dVar, this.b, this.c, this.d.createWorker(), this.e));
    }

    public p(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = z;
    }
}
