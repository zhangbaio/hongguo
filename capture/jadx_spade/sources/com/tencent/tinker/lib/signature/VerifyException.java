package com.tencent.tinker.lib.signature;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VerifyException extends Exception {
    public final int error;

    static {
        Covode.recordClassIndex(653814);
    }

    public VerifyException(int i, String str) {
        super(str);
        this.error = i;
    }

    public VerifyException(int i, String str, Throwable th) {
        super(str, th);
        this.error = i;
    }
}
