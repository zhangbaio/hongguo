package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class NetworkException extends CronetException {
    static {
        Covode.recordClassIndex(654495);
    }

    public abstract int getCronetInternalErrorCode();

    public abstract int getErrorCode();

    public abstract boolean immediatelyRetryable();

    protected NetworkException(String str, Throwable th) {
        super(str, th);
    }
}
