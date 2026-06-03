package io.reactivex.internal.observers;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e<T> extends c<T> {
    static {
        Covode.recordClassIndex(656370);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        this.a = t;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.a = null;
        this.b = th;
        countDown();
    }
}
