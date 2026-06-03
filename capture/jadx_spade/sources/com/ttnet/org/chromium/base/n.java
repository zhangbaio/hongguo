package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class n {
    static {
        Covode.recordClassIndex(654256);
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
