package io.reactivex.internal.subscriptions;

import com.bytedance.covode.number.Covode;
import nm6.g;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum EmptySubscription implements g<Object> {
    INSTANCE;

    public void cancel() {
    }

    @Override // nm6.j
    public void clear() {
    }

    @Override // nm6.j
    public boolean isEmpty() {
        return true;
    }

    @Override // nm6.j
    public Object poll() {
        return null;
    }

    @Override // nm6.f
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    static {
        Covode.recordClassIndex(657714);
    }

    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // nm6.j
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onComplete();
    }

    public static void error(Throwable th, Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onError(th);
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
