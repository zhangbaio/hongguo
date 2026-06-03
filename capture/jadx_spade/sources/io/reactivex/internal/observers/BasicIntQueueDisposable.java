package io.reactivex.internal.observers;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements nm6.e<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    static {
        Covode.recordClassIndex(656365);
    }

    @Override // nm6.j
    public abstract /* synthetic */ void clear();

    @Override // nm6.j
    public abstract /* synthetic */ boolean isEmpty();

    @Override // nm6.j
    public abstract /* synthetic */ T poll() throws Exception;

    @Override // nm6.f
    public abstract /* synthetic */ int requestFusion(int i);

    @Override // nm6.j
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
