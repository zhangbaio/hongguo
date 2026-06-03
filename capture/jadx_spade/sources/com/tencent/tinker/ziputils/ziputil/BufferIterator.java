package com.tencent.tinker.ziputils.ziputil;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class BufferIterator {
    static {
        Covode.recordClassIndex(653972);
    }

    public abstract int readInt();

    public abstract short readShort();

    public abstract void seek(int i);

    public abstract void skip(int i);
}
