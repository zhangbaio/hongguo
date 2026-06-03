package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.i;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class e extends d {
    private h e;
    private boolean f;

    static {
        Covode.recordClassIndex(654688);
    }

    private void e() throws IOException {
        if (!this.f) {
            f();
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.d, java.io.InputStream
    public int available() throws IOException {
        e();
        h hVar = this.e;
        int i = hVar.b;
        if (i == 0) {
            if (this.d == null) {
                return 0;
            }
            hVar.f();
            throw this.d;
        }
        if (i <= 0) {
            return 0;
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.d, java.io.InputStream
    public int read() throws IOException {
        e();
        h hVar = this.e;
        if (hVar.b > 0) {
            return hVar.b() & 255;
        }
        return -1;
    }

    private void f() throws IOException {
        if (this.f) {
            return;
        }
        if (i.b()) {
            i.a("TTBuffer", "calling ensureReadFromCronetDone");
        }
        this.e = new h();
        while (true) {
            Segment c = this.e.c();
            ByteBuffer innerBuffer = c.getInnerBuffer();
            if (i.b()) {
                i.a("TTBuffer", "getMoreData");
            }
            int position = innerBuffer.position();
            this.a.F(innerBuffer);
            if (this.d == null) {
                int position2 = innerBuffer.position() - position;
                if (position2 == 0) {
                    if (position == 0) {
                        if (i.b()) {
                            i.a("TTBuffer", "no new data, release empty segment " + this.e.b);
                        }
                        c.release();
                    } else {
                        if (i.b()) {
                            i.a("TTBuffer", "no new data, save this segment " + this.e.b);
                        }
                        c.completeRead();
                    }
                    this.f = true;
                    return;
                }
                h hVar = this.e;
                int i = hVar.b + position2;
                hVar.b = i;
                if (i <= 5242880) {
                    if (c.isWritable()) {
                        if (i.b()) {
                            i.a("TTBuffer", "new data, continue read with this segment " + this.e.b + " remaining: " + innerBuffer.remaining());
                        }
                    } else {
                        if (i.b()) {
                            i.a("TTBuffer", "new data but full, will use new segment next " + this.e.b);
                        }
                        c.completeRead();
                    }
                } else {
                    hVar.f();
                    throw new IOException("Download too large " + this.e.b + " 5242880");
                }
            } else {
                this.e.f();
                throw this.d;
            }
        }
    }

    e(CronetHttpURLConnection cronetHttpURLConnection) {
        super(cronetHttpURLConnection);
        this.f = false;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.d, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        e();
        if (bArr.length == 0) {
            return 0;
        }
        h hVar = this.e;
        if (hVar.b > 0) {
            return hVar.e(bArr, i, i2);
        }
        return -1;
    }
}
