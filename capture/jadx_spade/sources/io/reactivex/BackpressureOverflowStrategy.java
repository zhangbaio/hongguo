package io.reactivex;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum BackpressureOverflowStrategy {
    ERROR,
    DROP_OLDEST,
    DROP_LATEST;

    static {
        Covode.recordClassIndex(656197);
    }
}
