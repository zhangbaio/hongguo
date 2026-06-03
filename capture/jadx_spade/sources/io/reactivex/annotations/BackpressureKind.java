package io.reactivex.annotations;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum BackpressureKind {
    PASS_THROUGH,
    FULL,
    SPECIAL,
    UNBOUNDED_IN,
    ERROR,
    NONE;

    static {
        Covode.recordClassIndex(656252);
    }
}
