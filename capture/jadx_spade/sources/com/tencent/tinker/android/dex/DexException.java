package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DexException extends RuntimeException {
    static final long serialVersionUID = 1;

    static {
        Covode.recordClassIndex(653606);
    }

    public DexException(String str) {
        super(str);
    }

    public DexException(Throwable th) {
        super(th);
    }
}
