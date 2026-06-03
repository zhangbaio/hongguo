package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.e0;
import com.ttnet.org.chromium.net.f0;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CronetUploadDataStream extends f0 {
    private static final String o;
    private final Executor a;
    private final VersionSafeCallbacks.f b;
    private final CronetUrlRequest c;
    private long d;
    private long e;
    private long f;
    private ByteBuffer i;
    private long k;
    private boolean m;
    public Runnable n;
    private final Runnable h = new a();
    private final Object j = new Object();
    private int l = 3;
    private volatile boolean g = false;

    @Retention(RetentionPolicy.SOURCE)
    private @interface UserCallback {
    }

    interface d {
        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void a(long j);

        long b(CronetUploadDataStream cronetUploadDataStream, long j, long j2);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void c(long j, CronetUploadDataStream cronetUploadDataStream, int i, boolean z);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void d(long j, CronetUploadDataStream cronetUploadDataStream);
    }

    void onUploadDataStreamDestroyed() {
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.c.M();
    }

    static {
        Covode.recordClassIndex(654606);
        o = CronetUploadDataStream.class.getSimpleName();
    }

    void rewind() {
        u(new b());
    }

    private void r() {
        synchronized (this.j) {
            if (this.l != 0) {
                if (this.m) {
                    q();
                }
            } else {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
        }
    }

    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.j) {
                if (CronetUploadDataStream.this.k == 0) {
                    return;
                }
                CronetUploadDataStream.this.p(3);
                CronetUploadDataStream.this.l = 1;
                try {
                    CronetUploadDataStream.this.o();
                    CronetUploadDataStream.this.b.d(CronetUploadDataStream.this);
                } catch (Exception e) {
                    CronetUploadDataStream.this.t(e);
                }
            }
        }

        b() {
        }
    }

    class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetUploadDataStream.this.o();
                if (!CronetUploadDataStream.this.g) {
                    CronetUploadDataStream.this.b.close();
                }
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(CronetUploadDataStream.o, "Exception thrown when closing", e);
            }
        }

        c() {
        }
    }

    private void q() {
        synchronized (this.j) {
            if (this.l == 0) {
                this.m = true;
                return;
            }
            if (this.k == 0) {
                return;
            }
            g.e().a(this.k);
            this.k = 0L;
            Runnable runnable = this.n;
            if (runnable != null) {
                runnable.run();
            }
            u(new c());
        }
    }

    @Override // com.ttnet.org.chromium.net.f0
    public void c() {
        synchronized (this.j) {
            p(1);
            this.l = 3;
            this.e = this.d;
            if (this.k == 0) {
                return;
            }
            g.e().d(this.k, this);
        }
    }

    void s() {
        synchronized (this.j) {
            this.l = 2;
        }
        try {
            this.c.M();
            long a2 = this.b.a();
            this.d = a2;
            this.e = a2;
        } catch (Throwable th) {
            t(th);
        }
        synchronized (this.j) {
            this.l = 3;
        }
    }

    class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.j) {
                if (CronetUploadDataStream.this.k == 0) {
                    return;
                }
                CronetUploadDataStream.this.p(3);
                if (CronetUploadDataStream.this.i == null) {
                    throw new IllegalStateException("Unexpected readData call. Buffer is null");
                }
                CronetUploadDataStream.this.l = 0;
                try {
                    CronetUploadDataStream.this.o();
                    VersionSafeCallbacks.f fVar = CronetUploadDataStream.this.b;
                    CronetUploadDataStream cronetUploadDataStream = CronetUploadDataStream.this;
                    fVar.c(cronetUploadDataStream, cronetUploadDataStream.i);
                } catch (Exception e) {
                    CronetUploadDataStream.this.t(e);
                }
            }
        }

        a() {
        }
    }

    @Override // com.ttnet.org.chromium.net.f0
    public void b(Exception exc) {
        synchronized (this.j) {
            p(1);
            t(exc);
        }
    }

    void readData(ByteBuffer byteBuffer) {
        this.i = byteBuffer;
        this.f = byteBuffer.limit();
        u(this.h);
    }

    void n(long j) {
        synchronized (this.j) {
            this.k = g.e().b(this, j, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i) {
        if (this.l == i) {
            return;
        }
        throw new IllegalStateException("Expected " + i + ", but was " + this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Throwable th) {
        boolean z;
        synchronized (this.j) {
            int i = this.l;
            if (i != 3) {
                if (i == 2) {
                    z = true;
                } else {
                    z = false;
                }
                this.l = 3;
                this.i = null;
                r();
            } else {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
        }
        if (z) {
            try {
                this.b.close();
                this.g = true;
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(o, "Failure closing data provider", e);
            }
        }
        this.c.Z(th);
    }

    void u(Runnable runnable) {
        try {
            this.a.execute(runnable);
        } catch (Throwable th) {
            CronetUrlRequest cronetUrlRequest = this.c;
            if (cronetUrlRequest != null) {
                cronetUrlRequest.Z(th);
                return;
            }
            throw new IllegalStateException("Unexpected request usage, caught in CronetUploadDataStream, caused by " + th);
        }
    }

    @Override // com.ttnet.org.chromium.net.f0
    public void a(boolean z) {
        synchronized (this.j) {
            p(0);
            if (this.f == this.i.limit()) {
                if (z && this.d >= 0) {
                    throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
                }
                int position = this.i.position();
                long j = this.e - position;
                this.e = j;
                if (j < 0 && this.d >= 0) {
                    throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.d - this.e), Long.valueOf(this.d)));
                }
                this.i.position(0);
                this.i = null;
                this.l = 3;
                r();
                if (this.k == 0) {
                    return;
                }
                g.e().c(this.k, this, position, z);
                return;
            }
            throw new IllegalStateException("ByteBuffer limit changed");
        }
    }

    public CronetUploadDataStream(e0 e0Var, Executor executor, CronetUrlRequest cronetUrlRequest) {
        this.a = executor;
        this.b = new VersionSafeCallbacks.f(e0Var);
        this.c = cronetUrlRequest;
    }
}
