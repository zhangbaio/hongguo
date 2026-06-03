package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n<T> extends Single<Long> implements nm6.b<Long> {
    final Flowable<T> a;

    static {
        Covode.recordClassIndex(656547);
    }

    static final class a implements FlowableSubscriber<Object>, Disposable {
        final SingleObserver<? super Long> a;
        Subscription b;
        long c;

        static {
            Covode.recordClassIndex(656548);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.b.cancel();
            this.b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.b == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        public void onComplete() {
            this.b = SubscriptionHelper.CANCELLED;
            this.a.onSuccess(Long.valueOf(this.c));
        }

        a(SingleObserver<? super Long> singleObserver) {
            this.a = singleObserver;
        }

        public void onNext(Object obj) {
            this.c++;
        }

        public void onError(Throwable th) {
            this.b = SubscriptionHelper.CANCELLED;
            this.a.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    @Override // nm6.b
    public Flowable<Long> c() {
        return RxJavaPlugins.onAssembly(new FlowableCount(this.a));
    }

    public n(Flowable<T> flowable) {
        this.a = flowable;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.a.subscribe((FlowableSubscriber) new a(singleObserver));
    }
}
