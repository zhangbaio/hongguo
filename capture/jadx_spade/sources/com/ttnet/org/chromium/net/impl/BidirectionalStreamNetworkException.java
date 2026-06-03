package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BidirectionalStreamNetworkException extends NetworkExceptionImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
        Covode.recordClassIndex(654569);
    }

    @Override // com.ttnet.org.chromium.net.impl.NetworkExceptionImpl, com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int i = this.mCronetInternalErrorCode;
        if (i != -358 && i != -352) {
            return super.immediatelyRetryable();
        }
        return true;
    }

    public BidirectionalStreamNetworkException(String str, int i, int i2) {
        super(str, i, i2);
    }
}
