package com.tencent.mmkv;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class NativeBuffer {
    public long pointer;
    public int size;

    static {
        Covode.recordClassIndex(653485);
    }

    public NativeBuffer(long j, int i) {
        this.pointer = j;
        this.size = i;
    }
}
