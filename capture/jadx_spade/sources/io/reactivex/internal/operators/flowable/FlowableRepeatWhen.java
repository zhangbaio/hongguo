package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowableRepeatWhen<T> extends a<T, T> {
    final Function<? super Flowable<Object>, ? extends Publisher<?>> b;

    static {
        Covode.recordClassIndex(656750);
    }

    static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        private static final long serialVersionUID = 2827772011130406689L;
        final Publisher<T> source;
        WhenSourceSubscriber<T, U> subscriber;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        static {
            Covode.recordClassIndex(656752);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
        }

        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.downstream.onComplete();
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        public void onError(Throwable th) {
            this.subscriber.cancel();
            this.subscriber.downstream.onError(th);
        }

        WhenReceiver(Publisher<T> publisher) {
            this.source = publisher;
        }

        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                    this.source.subscribe(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        static {
            Covode.recordClassIndex(656751);
        }

        public void onComplete() {
            again(0);
        }

        public void onError(Throwable th) {
            this.receiver.cancel();
            this.downstream.onError(th);
        }

        RepeatWhenSubscriber(Subscriber<? super T> subscriber, io.reactivex.processors.a<Object> aVar, Subscription subscription) {
            super(subscriber, aVar, subscription);
        }
    }

    static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final Subscriber<? super T> downstream;
        protected final io.reactivex.processors.a<U> processor;
        private long produced;
        protected final Subscription receiver;

        static {
            Covode.recordClassIndex(656753);
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber
        public final void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }

        public final void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        protected final void again(U u) {
            setSubscription(EmptySubscription.INSTANCE);
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                produced(j);
            }
            this.receiver.request(1L);
            this.processor.onNext(u);
        }

        WhenSourceSubscriber(Subscriber<? super T> subscriber, io.reactivex.processors.a<U> aVar, Subscription subscription) {
            super(false);
            this.downstream = subscriber;
            this.processor = aVar;
            this.receiver = subscription;
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        io.reactivex.subscribers.d dVar = new io.reactivex.subscribers.d(subscriber);
        io.reactivex.processors.a<T> serialized = UnicastProcessor.d(8).toSerialized();
        try {
            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(serialized), "handler returned a null Publisher");
            WhenReceiver whenReceiver = new WhenReceiver(this.a);
            RepeatWhenSubscriber repeatWhenSubscriber = new RepeatWhenSubscriber(dVar, serialized, whenReceiver);
            whenReceiver.subscriber = repeatWhenSubscriber;
            subscriber.onSubscribe(repeatWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    public FlowableRepeatWhen(Flowable<T> flowable, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        super(flowable);
        this.b = function;
    }
}
