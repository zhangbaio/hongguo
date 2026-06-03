package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l<T> extends Completable {
    final Publisher<T> a;

    static {
        Covode.recordClassIndex(656425);
    }

    static final class a<T> implements FlowableSubscriber<T>, Disposable {
        final CompletableObserver a;
        Subscription b;

        static {
            Covode.recordClassIndex(656426);
        }

        public void onNext(T t) {
        }

        public void onComplete() {
            this.a.onComplete();
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

        a(CompletableObserver completableObserver) {
            this.a = completableObserver;
        }

        public void onError(Throwable th) {
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

    public l(Publisher<T> publisher) {
        this.a = publisher;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver));
    }
}
