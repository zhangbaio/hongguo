package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowableDoFinally<T> extends a<T, T> {
    final Action b;

    static {
        Covode.recordClassIndex(656585);
    }

    static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements nm6.a<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final nm6.a<? super T> downstream;
        final Action onFinally;
        nm6.g<T> qs;
        boolean syncFused;
        Subscription upstream;

        static {
            Covode.recordClassIndex(656586);
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public T poll() throws Exception {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            return this.downstream.tryOnNext(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof nm6.g) {
                    this.qs = (nm6.g) subscription;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.f
        public int requestFusion(int i) {
            nm6.g<T> gVar = this.qs;
            boolean z = false;
            if (gVar == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = gVar.requestFusion(i);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z = true;
                }
                this.syncFused = z;
            }
            return requestFusion;
        }

        DoFinallyConditionalSubscriber(nm6.a<? super T> aVar, Action action) {
            this.downstream = aVar;
            this.onFinally = action;
        }
    }

    static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final Subscriber<? super T> downstream;
        final Action onFinally;
        nm6.g<T> qs;
        boolean syncFused;
        Subscription upstream;

        static {
            Covode.recordClassIndex(656587);
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public T poll() throws Exception {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof nm6.g) {
                    this.qs = (nm6.g) subscription;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.f
        public int requestFusion(int i) {
            nm6.g<T> gVar = this.qs;
            boolean z = false;
            if (gVar == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = gVar.requestFusion(i);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z = true;
                }
                this.syncFused = z;
            }
            return requestFusion;
        }

        DoFinallySubscriber(Subscriber<? super T> subscriber, Action action) {
            this.downstream = subscriber;
            this.onFinally = action;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof nm6.a) {
            this.a.subscribe((FlowableSubscriber) new DoFinallyConditionalSubscriber((nm6.a) subscriber, this.b));
        } else {
            this.a.subscribe((FlowableSubscriber) new DoFinallySubscriber(subscriber, this.b));
        }
    }

    public FlowableDoFinally(Flowable<T> flowable, Action action) {
        super(flowable);
        this.b = action;
    }
}
