package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.e0;
import com.ttnet.org.chromium.net.f0;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a extends f {
    private final int d;
    private final CronetHttpURLConnection e;
    private final e0 f = new b();
    private ByteBuffer g;
    private boolean h;

    static {
        Covode.recordClassIndex(654678);
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void d() throws IOException {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    e0 e() {
        return this.f;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void f() throws IOException {
        this.h = true;
        if (this.g.position() >= this.d) {
            this.g.flip();
            return;
        }
        throw new ProtocolException("Content received is less than Content-Length");
    }

    private class b extends e0 {
        static {
            Covode.recordClassIndex(654679);
        }

        @Override // com.ttnet.org.chromium.net.e0
        public long a() {
            int position;
            if (a.this.d == -1) {
                if (a.this.h) {
                    position = a.this.g.limit();
                } else {
                    position = a.this.g.position();
                }
                return position;
            }
            return a.this.d;
        }

        private b() {
        }

        @Override // com.ttnet.org.chromium.net.e0
        public void d(f0 f0Var) {
            a.this.g.position(0);
            f0Var.c();
        }

        @Override // com.ttnet.org.chromium.net.e0
        public void c(f0 f0Var, ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (remaining < a.this.g.remaining()) {
                byteBuffer.put(a.this.g.array(), a.this.g.position(), remaining);
                a.this.g.position(a.this.g.position() + remaining);
            } else {
                byteBuffer.put(a.this.g);
            }
            f0Var.a(false);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        c();
        m(1);
        this.g.put((byte) i);
    }

    a(CronetHttpURLConnection cronetHttpURLConnection) {
        if (cronetHttpURLConnection != null) {
            this.e = cronetHttpURLConnection;
            this.d = -1;
            this.g = ByteBuffer.allocate(16384);
            return;
        }
        throw null;
    }

    private void m(int i) throws IOException {
        if (this.d != -1 && this.g.position() + i > this.d) {
            throw new ProtocolException("exceeded content-length limit of " + this.d + " bytes");
        }
        if (!this.h) {
            if (this.d != -1 || this.g.limit() - this.g.position() > i) {
                return;
            }
            ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.g.capacity() * 2, this.g.capacity() + i));
            this.g.flip();
            allocate.put(this.g);
            this.g = allocate;
            return;
        }
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for writing after connect");
    }

    a(CronetHttpURLConnection cronetHttpURLConnection, long j) {
        if (cronetHttpURLConnection != null) {
            if (j <= 2147483647L) {
                if (j >= 0) {
                    this.e = cronetHttpURLConnection;
                    int i = (int) j;
                    this.d = i;
                    this.g = ByteBuffer.allocate(i);
                    return;
                }
                throw new IllegalArgumentException("Content length < 0.");
            }
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
        }
        throw new NullPointerException("Argument connection cannot be null.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        c();
        m(i2);
        this.g.put(bArr, i, i2);
    }
}
