package io.reactivex.exceptions;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class MissingBackpressureException extends RuntimeException {
    private static final long serialVersionUID = 8517344746016032542L;

    static {
        Covode.recordClassIndex(656275);
    }

    public MissingBackpressureException() {
    }

    public MissingBackpressureException(String str) {
        super(str);
    }
}
