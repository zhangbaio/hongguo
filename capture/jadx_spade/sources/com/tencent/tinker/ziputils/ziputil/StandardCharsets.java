package com.tencent.tinker.ziputils.ziputil;

import com.bytedance.covode.number.Covode;
import java.nio.charset.Charset;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class StandardCharsets {
    public static final Charset UTF_8;

    private StandardCharsets() {
    }

    static {
        Covode.recordClassIndex(653976);
        UTF_8 = Charset.forName("UTF-8");
    }
}
