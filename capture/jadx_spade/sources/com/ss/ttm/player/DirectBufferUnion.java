package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
class DirectBufferUnion {
    ByteBuffer buffer;
    long freeTimePoint;
    int size;

    static {
        Covode.recordClassIndex(652099);
    }

    public void resetFreeTimePoint() {
        this.freeTimePoint = System.currentTimeMillis();
    }

    public DirectBufferUnion(ByteBuffer byteBuffer, int i) {
        this.buffer = byteBuffer;
        this.size = i;
    }
}
