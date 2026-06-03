package com.tencent.tinker.lib.signature;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SignatureNotFoundException extends Exception {
    private static final long serialVersionUID = 1;

    static {
        Covode.recordClassIndex(653808);
    }

    public SignatureNotFoundException(String str) {
        super(str);
    }

    public SignatureNotFoundException(String str, Throwable th) {
        super(str, th);
    }
}
