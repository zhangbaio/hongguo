package io.reactivex.exceptions;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ProtocolViolationException extends IllegalStateException {
    private static final long serialVersionUID = 1644750035281290266L;

    static {
        Covode.recordClassIndex(656277);
    }

    public ProtocolViolationException(String str) {
        super(str);
    }
}
