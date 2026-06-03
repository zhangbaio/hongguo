package io.reactivex.internal.subscribers;

import com.bytedance.covode.number.Covode;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class c<T> extends CountDownLatch implements FlowableSubscriber<T> {
    T a;
    Throwable b;
    Subscription c;
    volatile boolean d;

    static {
        Covode.recordClassIndex(657688);
    }

    public final void onComplete() {
        countDown();
    }

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e) {
                Subscription subscription = this.c;
                this.c = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.b;
        if (th == null) {
            return this.a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.FlowableSubscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.c, subscription)) {
            this.c = subscription;
            if (!this.d) {
                subscription.request(Long.MAX_VALUE);
                if (this.d) {
                    this.c = SubscriptionHelper.CANCELLED;
                    subscription.cancel();
                }
            }
        }
    }
}
