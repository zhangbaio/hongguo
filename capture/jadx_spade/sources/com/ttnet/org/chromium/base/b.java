package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.concurrent.atomic.AtomicReference;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b {
    private static final AtomicReference<b> a;

    private b() {
    }

    public abstract boolean b(String str);

    static {
        Covode.recordClassIndex(654170);
        a = new AtomicReference<>();
    }

    public static b a() {
        return a.get();
    }
}
