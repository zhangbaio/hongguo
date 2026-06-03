package io.reactivex.internal.subscriptions;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicInteger;
import nm6.g;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements g<T> {
    private static final long serialVersionUID = -3830916580126663321L;
    final Subscriber<? super T> subscriber;
    final T value;

    static {
        Covode.recordClassIndex(657715);
    }

    @Override // nm6.f
    public int requestFusion(int i) {
        return i & 1;
    }

    public void cancel() {
        lazySet(2);
    }

    @Override // nm6.j
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        if (get() == 2) {
            return true;
        }
        return false;
    }

    @Override // nm6.j
    public boolean isEmpty() {
        if (get() != 0) {
            return true;
        }
        return false;
    }

    @Override // nm6.j
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.value;
        }
        return null;
    }

    @Override // nm6.j
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            Subscriber<? super T> subscriber = this.subscriber;
            subscriber.onNext(this.value);
            if (get() != 2) {
                subscriber.onComplete();
            }
        }
    }

    public ScalarSubscription(Subscriber<? super T> subscriber, T t) {
        this.subscriber = subscriber;
        this.value = t;
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
