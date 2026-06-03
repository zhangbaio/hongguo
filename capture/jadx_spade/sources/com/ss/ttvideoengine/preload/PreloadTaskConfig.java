package com.ss.ttvideoengine.preload;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloadTaskConfig {
    public int count;
    public int size;
    public int progress = 100;
    public int offset = 0;

    static {
        Covode.recordClassIndex(652635);
    }

    public PreloadTaskConfig(int i, int i2) {
        this.count = i;
        this.size = i2;
    }
}
