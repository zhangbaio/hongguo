package io.reactivex.internal.observers;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b<T> implements nm6.e<T> {
    static {
        Covode.recordClassIndex(656366);
    }

    @Override // nm6.j
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
