package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t {
    static {
        Covode.recordClassIndex(654646);
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
        } else {
            throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
        }
    }

    public static void b(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
        } else {
            throw new IllegalArgumentException("ByteBuffer is already full.");
        }
    }
}
