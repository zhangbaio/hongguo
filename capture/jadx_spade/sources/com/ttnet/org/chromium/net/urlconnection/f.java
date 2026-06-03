package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.e0;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
abstract class f extends OutputStream {
    private IOException a;
    private boolean b;
    private boolean c;

    static {
        Covode.recordClassIndex(654689);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b = true;
    }

    abstract void d() throws IOException;

    abstract e0 e();

    abstract void f() throws IOException;

    f() {
    }

    protected void a() throws IOException {
        IOException iOException = this.a;
        if (iOException == null) {
        } else {
            throw iOException;
        }
    }

    protected void c() throws IOException {
        if (!this.c) {
            if (!this.b) {
            } else {
                throw new IOException("Stream has been closed.");
            }
        } else {
            a();
            throw new IOException("Writing after request completed.");
        }
    }

    void g(IOException iOException) {
        this.a = iOException;
        this.c = true;
    }
}
