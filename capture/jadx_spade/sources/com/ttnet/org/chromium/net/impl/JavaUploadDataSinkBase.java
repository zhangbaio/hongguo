package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.e0;
import com.ttnet.org.chromium.net.f0;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class JavaUploadDataSinkBase extends f0 {
    private final AtomicInteger a = new AtomicInteger(3);
    private final Executor b;
    private final Executor c;
    private final e0 d;
    private ByteBuffer e;
    private long f;
    private long g;

    @Retention(RetentionPolicy.SOURCE)
    @interface SinkState {
    }

    static {
        Covode.recordClassIndex(654629);
    }

    protected abstract void o() throws IOException;

    protected abstract Runnable p(o oVar);

    protected abstract Runnable q(o oVar);

    protected abstract void r() throws IOException;

    protected abstract void s(long j);

    protected abstract int t(ByteBuffer byteBuffer) throws IOException;

    protected abstract void u(Throwable th);

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.c.execute(p(new c()));
    }

    class b implements o {
        final /* synthetic */ boolean a;

        class a implements o {
            @Override // com.ttnet.org.chromium.net.impl.o
            public void run() throws Exception {
                e0 e0Var = JavaUploadDataSinkBase.this.d;
                JavaUploadDataSinkBase javaUploadDataSinkBase = JavaUploadDataSinkBase.this;
                e0Var.c(javaUploadDataSinkBase, javaUploadDataSinkBase.e);
            }

            a() {
            }
        }

        @Override // com.ttnet.org.chromium.net.impl.o
        public void run() throws Exception {
            JavaUploadDataSinkBase.this.e.flip();
            if (JavaUploadDataSinkBase.this.f != -1 && JavaUploadDataSinkBase.this.f - JavaUploadDataSinkBase.this.g < JavaUploadDataSinkBase.this.e.remaining()) {
                JavaUploadDataSinkBase.this.u(new IllegalArgumentException(String.format(Locale.getDefault(), "Read upload data length %d exceeds expected length %d", Long.valueOf(JavaUploadDataSinkBase.this.g + JavaUploadDataSinkBase.this.e.remaining()), Long.valueOf(JavaUploadDataSinkBase.this.f))));
                return;
            }
            JavaUploadDataSinkBase.i(JavaUploadDataSinkBase.this, r0.t(r0.e));
            if (JavaUploadDataSinkBase.this.g >= JavaUploadDataSinkBase.this.f && (JavaUploadDataSinkBase.this.f != -1 || this.a)) {
                if (JavaUploadDataSinkBase.this.f == -1) {
                    JavaUploadDataSinkBase.this.o();
                    return;
                } else if (JavaUploadDataSinkBase.this.f == JavaUploadDataSinkBase.this.g) {
                    JavaUploadDataSinkBase.this.o();
                    return;
                } else {
                    JavaUploadDataSinkBase.this.u(new IllegalArgumentException(String.format(Locale.getDefault(), "Read upload data length %d exceeds expected length %d", Long.valueOf(JavaUploadDataSinkBase.this.g), Long.valueOf(JavaUploadDataSinkBase.this.f))));
                    return;
                }
            }
            JavaUploadDataSinkBase.this.e.clear();
            JavaUploadDataSinkBase.this.a.set(0);
            JavaUploadDataSinkBase.this.n(new a());
        }

        b(boolean z) {
            this.a = z;
        }
    }

    class c implements o {

        class a implements o {
            @Override // com.ttnet.org.chromium.net.impl.o
            public void run() throws Exception {
                e0 e0Var = JavaUploadDataSinkBase.this.d;
                JavaUploadDataSinkBase javaUploadDataSinkBase = JavaUploadDataSinkBase.this;
                e0Var.c(javaUploadDataSinkBase, javaUploadDataSinkBase.e);
            }

            a() {
            }
        }

        @Override // com.ttnet.org.chromium.net.impl.o
        public void run() throws Exception {
            JavaUploadDataSinkBase.this.r();
            JavaUploadDataSinkBase.this.a.set(0);
            JavaUploadDataSinkBase.this.n(new a());
        }

        c() {
        }
    }

    @Override // com.ttnet.org.chromium.net.f0
    public void c() {
        if (this.a.compareAndSet(1, 2)) {
            w();
            return;
        }
        throw new IllegalStateException("onRewindSucceeded() called when not awaiting a rewind; in state: " + this.a.get());
    }

    class d implements o {
        final /* synthetic */ boolean a;

        @Override // com.ttnet.org.chromium.net.impl.o
        public void run() throws Exception {
            JavaUploadDataSinkBase javaUploadDataSinkBase = JavaUploadDataSinkBase.this;
            javaUploadDataSinkBase.f = javaUploadDataSinkBase.d.a();
            if (JavaUploadDataSinkBase.this.f == 0) {
                JavaUploadDataSinkBase.this.o();
                return;
            }
            if (JavaUploadDataSinkBase.this.f > 0 && JavaUploadDataSinkBase.this.f < 8192) {
                JavaUploadDataSinkBase javaUploadDataSinkBase2 = JavaUploadDataSinkBase.this;
                javaUploadDataSinkBase2.e = ByteBuffer.allocateDirect(((int) javaUploadDataSinkBase2.f) + 1);
            } else {
                JavaUploadDataSinkBase.this.e = ByteBuffer.allocateDirect(8192);
            }
            JavaUploadDataSinkBase javaUploadDataSinkBase3 = JavaUploadDataSinkBase.this;
            javaUploadDataSinkBase3.s(javaUploadDataSinkBase3.f);
            if (!this.a) {
                JavaUploadDataSinkBase.this.a.set(1);
                JavaUploadDataSinkBase.this.d.d(JavaUploadDataSinkBase.this);
            } else {
                JavaUploadDataSinkBase.this.w();
            }
        }

        d(boolean z) {
            this.a = z;
        }
    }

    @Override // com.ttnet.org.chromium.net.f0
    public void b(Exception exc) {
        u(exc);
    }

    class a implements Executor {
        final /* synthetic */ Executor a;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.a.execute(runnable);
            } catch (RejectedExecutionException e) {
                JavaUploadDataSinkBase.this.u(e);
            }
        }

        a(Executor executor) {
            this.a = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(o oVar) {
        try {
            this.b.execute(q(oVar));
        } catch (RejectedExecutionException e) {
            u(e);
        }
    }

    public void v(boolean z) {
        n(new d(z));
    }

    @Override // com.ttnet.org.chromium.net.f0
    public void a(boolean z) {
        if (this.a.compareAndSet(0, 2)) {
            this.c.execute(p(new b(z)));
            return;
        }
        throw new IllegalStateException("onReadSucceeded() called when not awaiting a read result; in state: " + this.a.get());
    }

    static /* synthetic */ long i(JavaUploadDataSinkBase javaUploadDataSinkBase, long j) {
        long j2 = javaUploadDataSinkBase.g + j;
        javaUploadDataSinkBase.g = j2;
        return j2;
    }

    public JavaUploadDataSinkBase(Executor executor, Executor executor2, e0 e0Var) {
        this.b = new a(executor);
        this.c = executor2;
        this.d = e0Var;
    }
}
