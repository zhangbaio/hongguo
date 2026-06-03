package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.e0;
import com.ttnet.org.chromium.net.f0;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b extends f {
    private final CronetHttpURLConnection d;
    private final g e;
    private final ByteBuffer f;
    private final e0 g = new C0125b();
    private boolean h;

    static {
        Covode.recordClassIndex(654680);
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void d() throws IOException {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void f() throws IOException {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    e0 e() {
        return this.g;
    }

    private void m() throws IOException {
        if (!this.f.hasRemaining()) {
            u();
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (!this.h) {
            this.h = true;
            this.f.flip();
        }
    }

    private void u() throws IOException {
        c();
        this.f.flip();
        n(this.d.getReadTimeout());
        a();
    }

    /* renamed from: com.ttnet.org.chromium.net.urlconnection.b$b, reason: collision with other inner class name */
    private class C0125b extends e0 {
        static {
            Covode.recordClassIndex(654681);
        }

        @Override // com.ttnet.org.chromium.net.e0
        public long a() {
            return -1L;
        }

        private C0125b() {
        }

        @Override // com.ttnet.org.chromium.net.e0
        public void d(f0 f0Var) {
            f0Var.b(new HttpRetryException("Cannot retry streamed Http body", -1));
        }

        @Override // com.ttnet.org.chromium.net.e0
        public void c(f0 f0Var, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= b.this.f.remaining()) {
                byteBuffer.put(b.this.f);
                b.this.f.clear();
                f0Var.a(b.this.h);
                if (!b.this.h) {
                    b.this.e.quit();
                    return;
                }
                return;
            }
            int limit = b.this.f.limit();
            b.this.f.limit(b.this.f.position() + byteBuffer.remaining());
            byteBuffer.put(b.this.f);
            b.this.f.limit(limit);
            f0Var.a(false);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        m();
        this.f.put((byte) i);
    }

    private void n(int i) throws IOException {
        try {
            this.e.a(i);
        } catch (SocketTimeoutException unused) {
            CronetHttpURLConnection cronetHttpURLConnection = this.d;
            if (cronetHttpURLConnection != null) {
                cronetHttpURLConnection.K();
                this.e.c();
                this.e.a(i / 2);
            }
        } catch (Exception e) {
            CronetHttpURLConnection cronetHttpURLConnection2 = this.d;
            if (cronetHttpURLConnection2 != null) {
                cronetHttpURLConnection2.v("Unexpected request usage, caught in CronetChunkedOutputStream", e);
                this.e.c();
                this.e.a(i / 2);
            }
        }
    }

    b(CronetHttpURLConnection cronetHttpURLConnection, int i, g gVar) {
        if (cronetHttpURLConnection != null) {
            if (i > 0) {
                this.f = ByteBuffer.allocate(i);
                this.d = cronetHttpURLConnection;
                this.e = gVar;
                return;
            }
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        throw null;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        c();
        if (bArr.length - i >= i2 && i >= 0 && i2 >= 0) {
            int i3 = i2;
            while (i3 > 0) {
                int min = Math.min(i3, this.f.remaining());
                this.f.put(bArr, (i + i2) - i3, min);
                i3 -= min;
                m();
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
