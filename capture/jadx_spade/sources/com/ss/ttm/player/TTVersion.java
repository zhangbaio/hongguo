package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TTVersion {
    public static final int VERSION = 1;
    public static final String VERSION_NAME = "2.10.252.810-novel";

    static {
        Covode.recordClassIndex(652200);
    }

    public static void saveVersionInfo() {
        TTPlayerConfiger.setValue(15, "2026-05-20 09:29:31");
        TTPlayerConfiger.setValue(13, 1);
        TTPlayerConfiger.setValue(14, "2.10.252.810-novel");
    }
}
