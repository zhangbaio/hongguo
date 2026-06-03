package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.z;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTCronetNetExpRequest extends com.ttnet.org.chromium.net.z {
    private static final String l;
    private CronetUrlRequestContext a;
    private int b;
    private List<String> c;
    private int d;
    private int e;
    private int f;
    private final z.b g;
    private Executor h;
    private long i;
    private boolean j;
    private final Object k = new Object();

    interface b {
        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void a(long j, TTCronetNetExpRequest tTCronetNetExpRequest, String str, String str2);

        long b(TTCronetNetExpRequest tTCronetNetExpRequest, long j, int i, String[] strArr, int i2, int i3, int i4);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void c(long j, TTCronetNetExpRequest tTCronetNetExpRequest);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void d(long j, TTCronetNetExpRequest tTCronetNetExpRequest);
    }

    static {
        Covode.recordClassIndex(654654);
        l = TTCronetNetExpRequest.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        if (this.j && this.i == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.i == 0) {
            return;
        }
        v.e().d(this.i, this);
        this.i = 0L;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a() {
        synchronized (this.k) {
            if (!j() && this.j) {
                i();
            }
        }
    }

    class a implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a) {
                synchronized (TTCronetNetExpRequest.this.k) {
                    if (!TTCronetNetExpRequest.this.j()) {
                        TTCronetNetExpRequest.this.i();
                    }
                }
            }
            try {
                TTCronetNetExpRequest.this.g.a(TTCronetNetExpRequest.this, this.b);
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(TTCronetNetExpRequest.l, "Exception in callback: ", e);
            }
        }

        a(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    @Override // com.ttnet.org.chromium.net.z
    public void c() {
        synchronized (this.k) {
            if (this.j) {
                return;
            }
            b e = v.e();
            long j0 = this.a.j0();
            int i = this.b;
            List<String> list = this.c;
            long b2 = e.b(this, j0, i, (String[]) list.toArray(new String[list.size()]), this.d, this.e, this.f);
            this.i = b2;
            if (b2 != 0) {
                this.j = true;
                v.e().c(this.i, this);
                return;
            }
            throw new NullPointerException("Create native net exp request adapter failed.");
        }
    }

    private void k(Runnable runnable) {
        try {
            Executor executor = this.h;
            if (executor != null) {
                executor.execute(runnable);
            } else {
                new Thread(runnable, "NetExpCallback").start();
            }
        } catch (RejectedExecutionException e) {
            com.ttnet.org.chromium.base.h.b(l, "Exception posting task to executor", e);
        }
    }

    private void onNetExpRequestComplete(String str, boolean z) {
        k(new a(z, str));
    }

    @Override // com.ttnet.org.chromium.net.z
    public void b(String str, String str2) {
        synchronized (this.k) {
            if (!j() && this.j) {
                v.e().a(this.i, this, str, str2);
            }
        }
    }

    public TTCronetNetExpRequest(CronetUrlRequestContext cronetUrlRequestContext, z.b bVar, Executor executor, int i, List<String> list, int i2, int i3, int i4) {
        this.a = cronetUrlRequestContext;
        this.g = bVar;
        this.h = executor;
        this.b = i;
        this.c = list;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }
}
