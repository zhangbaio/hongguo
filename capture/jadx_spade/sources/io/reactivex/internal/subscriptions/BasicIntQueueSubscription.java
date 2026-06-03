package io.reactivex.internal.subscriptions;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicInteger;
import nm6.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements g<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    static {
        Covode.recordClassIndex(657710);
    }

    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ boolean isEmpty();

    public abstract /* synthetic */ T poll() throws Exception;

    public abstract /* synthetic */ int requestFusion(int i);

    @Override // nm6.j
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
