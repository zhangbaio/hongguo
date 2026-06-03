package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class QuicException extends NetworkException {
    static {
        Covode.recordClassIndex(654508);
    }

    public abstract int getQuicDetailedErrorCode();

    protected QuicException(String str, Throwable th) {
        super(str, th);
    }
}
