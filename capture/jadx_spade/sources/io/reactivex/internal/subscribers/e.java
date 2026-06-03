package io.reactivex.internal.subscribers;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e<T> extends c<T> {
    static {
        Covode.recordClassIndex(657690);
    }

    public void onNext(T t) {
        this.a = t;
    }

    public void onError(Throwable th) {
        this.a = null;
        this.b = th;
        countDown();
    }
}
