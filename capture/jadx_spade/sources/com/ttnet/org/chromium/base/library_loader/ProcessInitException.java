package com.ttnet.org.chromium.base.library_loader;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ProcessInitException extends RuntimeException {
    static {
        Covode.recordClassIndex(654357);
    }

    public ProcessInitException(int i) {
        super("errorCode=" + i);
    }

    public ProcessInitException(int i, Throwable th) {
        super("errorCode=" + i, th);
    }
}
