package com.vivo.push.util;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VivoPushException extends Exception {
    private int mReasonCode;

    static {
        Covode.recordClassIndex(655175);
    }

    public int getCode() {
        return this.mReasonCode;
    }

    public VivoPushException(String str) {
        this(10000, str);
    }

    public VivoPushException(int i, String str) {
        super(str);
        this.mReasonCode = i;
    }
}
