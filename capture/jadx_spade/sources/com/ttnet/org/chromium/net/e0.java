package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class e0 implements Closeable {
    static {
        Covode.recordClassIndex(654551);
    }

    public abstract long a() throws IOException;

    public abstract void c(f0 f0Var, ByteBuffer byteBuffer) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract void d(f0 f0Var) throws IOException;
}
