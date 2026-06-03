package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class d extends InputStream {
    protected final CronetHttpURLConnection a;
    private boolean b;
    private ByteBuffer c;
    protected IOException d;

    static {
        Covode.recordClassIndex(654687);
    }

    private boolean c() {
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null && byteBuffer.hasRemaining()) {
            return true;
        }
        return false;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        CronetHttpURLConnection cronetHttpURLConnection = this.a;
        if (cronetHttpURLConnection != null) {
            cronetHttpURLConnection.disconnect();
        }
        super.close();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.b) {
            IOException iOException = this.d;
            if (iOException == null) {
                return 0;
            }
            throw iOException;
        }
        if (!c()) {
            return 0;
        }
        return this.c.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        a();
        if (c()) {
            return this.c.get() & 255;
        }
        return -1;
    }

    private void a() throws IOException {
        if (this.b) {
            IOException iOException = this.d;
            if (iOException == null) {
                return;
            } else {
                throw iOException;
            }
        }
        if (!c()) {
            if (this.c == null) {
                int i = this.a.v;
                if (i < 8192) {
                    i = 32768;
                }
                this.c = ByteBuffer.allocateDirect(i);
            }
            this.c.clear();
            this.a.F(this.c);
            IOException iOException2 = this.d;
            if (iOException2 == null) {
                ByteBuffer byteBuffer = this.c;
                if (byteBuffer != null) {
                    byteBuffer.flip();
                    return;
                }
                return;
            }
            throw iOException2;
        }
    }

    public d(CronetHttpURLConnection cronetHttpURLConnection) {
        this.a = cronetHttpURLConnection;
    }

    void d(IOException iOException) {
        this.d = iOException;
        this.b = true;
        this.c = null;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
            if (i2 == 0) {
                return 0;
            }
            a();
            if (c()) {
                int min = Math.min(this.c.limit() - this.c.position(), i2);
                this.c.get(bArr, i, min);
                return min;
            }
            return -1;
        }
        throw new IndexOutOfBoundsException();
    }
}
