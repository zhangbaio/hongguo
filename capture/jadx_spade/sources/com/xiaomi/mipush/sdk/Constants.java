package com.xiaomi.mipush.sdk;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Constants {
    public static final int[] ASSEMBLE_PUSH_RETRY_DELAY;
    public static final String VERSION = "version";

    protected static int a() {
        return com.xiaomi.push.w.a();
    }

    static {
        Covode.recordClassIndex(655261);
        ASSEMBLE_PUSH_RETRY_DELAY = new int[]{2000, 4000, 8000};
    }
}
