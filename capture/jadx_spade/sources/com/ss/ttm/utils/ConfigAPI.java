package com.ss.ttm.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
abstract class ConfigAPI {
    static {
        Covode.recordClassIndex(652229);
    }

    ConfigAPI() {
    }

    abstract int getIntValue(int i, int i2);

    abstract long nativeHandle();

    abstract void release();

    abstract void setIntValue(int i, int i2);
}
