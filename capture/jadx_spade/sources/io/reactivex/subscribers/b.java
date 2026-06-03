package io.reactivex.subscribers;

import com.bytedance.covode.number.Covode;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b<T> implements FlowableSubscriber<T>, Disposable {
    final AtomicReference<Subscription> a = new AtomicReference<>();

    static {
        Covode.recordClassIndex(657831);
    }

    protected final void b() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this.a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.a.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    protected void c() {
        this.a.get().request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.FlowableSubscriber
    public final void onSubscribe(Subscription subscription) {
        if (f.d(this.a, subscription, getClass())) {
            c();
        }
    }
}
