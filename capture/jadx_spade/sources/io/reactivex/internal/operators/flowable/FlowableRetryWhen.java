package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowableRetryWhen<T> extends a<T, T> {
    final Function<? super Flowable<Throwable>, ? extends Publisher<?>> b;

    static {
        Covode.recordClassIndex(656774);
    }

    static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        static {
            Covode.recordClassIndex(656775);
        }

        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            again(th);
        }

        RetryWhenSubscriber(Subscriber<? super T> subscriber, io.reactivex.processors.a<Throwable> aVar, Subscription subscription) {
            super(subscriber, aVar, subscription);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        io.reactivex.subscribers.d dVar = new io.reactivex.subscribers.d(subscriber);
        io.reactivex.processors.a<T> serialized = UnicastProcessor.d(8).toSerialized();
        try {
            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(serialized), "handler returned a null Publisher");
            FlowableRepeatWhen.WhenReceiver whenReceiver = new FlowableRepeatWhen.WhenReceiver(this.a);
            RetryWhenSubscriber retryWhenSubscriber = new RetryWhenSubscriber(dVar, serialized, whenReceiver);
            whenReceiver.subscriber = retryWhenSubscriber;
            subscriber.onSubscribe(retryWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    public FlowableRetryWhen(Flowable<T> flowable, Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        super(flowable);
        this.b = function;
    }
}
