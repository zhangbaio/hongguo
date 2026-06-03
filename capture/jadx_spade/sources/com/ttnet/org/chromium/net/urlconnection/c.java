package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.e0;
import com.ttnet.org.chromium.net.f0;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c extends f {
    private static int l;
    private final CronetHttpURLConnection d;
    private final g e;
    private final long f;
    private final ByteBuffer g;
    private final e0 h = new b();
    private long i;
    private boolean j;
    private boolean k;

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void f() throws IOException {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    e0 e() {
        return this.h;
    }

    private class b extends e0 {
        static {
            Covode.recordClassIndex(654683);
        }

        @Override // com.ttnet.org.chromium.net.e0
        public long a() {
            return c.this.f;
        }

        private b() {
        }

        @Override // com.ttnet.org.chromium.net.e0
        public void d(f0 f0Var) {
            if (!c.this.j) {
                f0Var.b(new HttpRetryException("Cannot retry streamed Http body", -1));
                return;
            }
            c.this.k = true;
            c.this.g.rewind();
            f0Var.c();
        }

        @Override // com.ttnet.org.chromium.net.e0
        public void c(f0 f0Var, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.g.remaining()) {
                byteBuffer.put(c.this.g);
                c.this.g.clear();
                f0Var.a(false);
                if (!c.this.k) {
                    c.this.e.quit();
                    return;
                }
                return;
            }
            int limit = c.this.g.limit();
            c.this.g.limit(c.this.g.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.g);
            c.this.g.limit(limit);
            f0Var.a(false);
        }
    }

    static {
        Covode.recordClassIndex(654682);
        l = 16384;
    }

    private void B() throws IOException {
        if (this.i == this.f) {
            A();
        }
    }

    private void x() throws IOException {
        if (!this.g.hasRemaining()) {
            this.j = false;
            A();
        }
    }

    private void A() throws IOException {
        c();
        this.g.flip();
        z(this.d.getReadTimeout());
        a();
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void d() throws IOException {
        if (this.i >= this.f) {
        } else {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        c();
        w(1);
        x();
        this.g.put((byte) i);
        this.i++;
        B();
    }

    private void w(int i) throws ProtocolException {
        if (this.i + i <= this.f) {
            return;
        }
        throw new ProtocolException("expected " + (this.f - this.i) + " bytes but received " + i);
    }

    private void z(int i) throws IOException {
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
                cronetHttpURLConnection2.v("Unexpected request usage, caught in CronetFixedModeOutputStream", e);
                this.e.c();
                this.e.a(i / 2);
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        c();
        if (bArr.length - i >= i2 && i >= 0 && i2 >= 0) {
            w(i2);
            int i3 = i2;
            while (i3 > 0) {
                x();
                int min = Math.min(i3, this.g.remaining());
                this.g.put(bArr, (i + i2) - i3, min);
                i3 -= min;
            }
            this.i += i2;
            B();
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    c(CronetHttpURLConnection cronetHttpURLConnection, long j, int i, g gVar) {
        if (cronetHttpURLConnection != null) {
            if (j >= 0) {
                this.f = j;
                this.g = ByteBuffer.allocate((int) Math.min(j, Math.max(l, i)));
                this.d = cronetHttpURLConnection;
                this.e = gVar;
                this.i = 0L;
                this.j = true;
                this.k = false;
                return;
            }
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        throw null;
    }
}
