package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class CronetException extends IOException {
    static {
        Covode.recordClassIndex(654448);
    }

    protected CronetException(String str, Throwable th) {
        super(str, th);
    }
}
