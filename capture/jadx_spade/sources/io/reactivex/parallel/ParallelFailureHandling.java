package io.reactivex.parallel;

import com.bytedance.covode.number.Covode;
import io.reactivex.functions.BiFunction;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // io.reactivex.functions.BiFunction
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }

    static {
        Covode.recordClassIndex(657766);
    }
}
