package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowableTakeLastTimed<T> extends a<T, T> {
    final long b;
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final int f;
    final boolean g;

    static {
        Covode.recordClassIndex(656829);
    }

    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Subscription upstream;

        static {
            Covode.recordClassIndex(656830);
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void onComplete() {
            trim(this.scheduler.now(this.unit), this.queue);
            this.done = true;
            drain();
        }

        void drain() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.downstream;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            boolean z2 = this.delayError;
            int i = 1;
            do {
                if (this.done) {
                    if (checkTerminated(aVar.isEmpty(), subscriber, z2)) {
                        return;
                    }
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        if (aVar.peek() == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (checkTerminated(z, subscriber, z2)) {
                            return;
                        }
                        if (j == j2) {
                            if (j2 != 0) {
                                io.reactivex.internal.util.b.e(this.requested, j2);
                            }
                        } else {
                            aVar.poll();
                            subscriber.onNext(aVar.poll());
                            j2++;
                        }
                    }
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        public void onError(Throwable th) {
            if (this.delayError) {
                trim(this.scheduler.now(this.unit), this.queue);
            }
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            long now = this.scheduler.now(this.unit);
            aVar.l(Long.valueOf(now), t);
            trim(now, aVar);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        void trim(long j, io.reactivex.internal.queue.a<Object> aVar) {
            boolean z;
            long j2 = this.time;
            long j3 = this.count;
            if (j3 == Long.MAX_VALUE) {
                z = true;
            } else {
                z = false;
            }
            while (!aVar.isEmpty()) {
                if (((Long) aVar.peek()).longValue() < j - j2 || (!z && (aVar.n() >> 1) > j3)) {
                    aVar.poll();
                    aVar.poll();
                } else {
                    return;
                }
            }
        }

        boolean checkTerminated(boolean z, Subscriber<? super T> subscriber, boolean z2) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z2) {
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (z) {
                subscriber.onComplete();
                return true;
            }
            return false;
        }

        TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.downstream = subscriber;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.delayError = z;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe((FlowableSubscriber) new TakeLastTimedSubscriber(subscriber, this.b, this.c, this.d, this.e, this.f, this.g));
    }

    public FlowableTakeLastTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = i;
        this.g = z;
    }
}
