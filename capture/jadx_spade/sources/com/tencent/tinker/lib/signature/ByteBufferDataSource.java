package com.tencent.tinker.lib.signature;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ByteBufferDataSource implements DataSource {
    private final ByteBuffer mBuf;

    static {
        Covode.recordClassIndex(653802);
    }

    @Override // com.tencent.tinker.lib.signature.DataSource
    public long size() {
        return this.mBuf.capacity();
    }

    ByteBufferDataSource(ByteBuffer byteBuffer) {
        this.mBuf = byteBuffer.slice();
    }

    @Override // com.tencent.tinker.lib.signature.DataSource
    public void feedIntoDataDigester(DataDigester dataDigester, long j, int i) throws IOException, DigestException {
        ByteBuffer slice;
        synchronized (this.mBuf) {
            this.mBuf.position(0);
            int i2 = (int) j;
            this.mBuf.limit(i + i2);
            this.mBuf.position(i2);
            slice = this.mBuf.slice();
        }
        dataDigester.consume(slice);
    }
}
