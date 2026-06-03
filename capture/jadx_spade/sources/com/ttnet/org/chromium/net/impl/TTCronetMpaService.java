package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.y;
import java.util.List;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTCronetMpaService extends com.ttnet.org.chromium.net.y {
    private static final String f;
    private CronetUrlRequestContext a;
    private long b;
    private final Object c = new Object();
    private y.a d;
    private y.a e;

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeCommand(long j, String str, String str2);

    private native long nativeCreateMpaServiceAdapter(long j);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeInit(long j);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeSetAccAddress(long j, String[] strArr);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStart(long j);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStop(long j);

    static {
        Covode.recordClassIndex(654653);
        f = TTCronetMpaService.class.getSimpleName();
    }

    class a implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTCronetMpaService.this.d.onFinish(this.a, this.b);
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(TTCronetMpaService.f, "Exception in callback: ", e);
            }
        }

        a(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    class b implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTCronetMpaService.this.e.onFinish(this.a, this.b);
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(TTCronetMpaService.f, "Exception in callback: ", e);
            }
        }

        b(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    @Override // com.ttnet.org.chromium.net.y
    public void d() {
        synchronized (this.c) {
            long j = this.b;
            if (j == 0) {
                return;
            }
            nativeStart(j);
        }
    }

    @Override // com.ttnet.org.chromium.net.y
    public void e() {
        synchronized (this.c) {
            long j = this.b;
            if (j == 0) {
                return;
            }
            nativeStop(j);
        }
    }

    public TTCronetMpaService(CronetUrlRequestContext cronetUrlRequestContext) {
        this.a = cronetUrlRequestContext;
    }

    private void i(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("TTCronetMpaService_Thread");
        thread.start();
    }

    @Override // com.ttnet.org.chromium.net.y
    public void b(y.a aVar) {
        synchronized (this.c) {
            if (this.b == 0) {
                this.b = nativeCreateMpaServiceAdapter(this.a.j0());
            }
            this.d = aVar;
            nativeInit(this.b);
        }
    }

    private void onInitFinish(boolean z, String str) {
        i(new a(z, str));
    }

    private void onSetAccAddressFinish(boolean z, String str) {
        i(new b(z, str));
    }

    @Override // com.ttnet.org.chromium.net.y
    public void a(String str, String str2) {
        synchronized (this.c) {
            long j = this.b;
            if (j == 0) {
                return;
            }
            nativeCommand(j, str, str2);
        }
    }

    @Override // com.ttnet.org.chromium.net.y
    public void c(List<String> list, y.a aVar) {
        synchronized (this.c) {
            long j = this.b;
            if (j == 0) {
                return;
            }
            this.e = aVar;
            nativeSetAccAddress(j, (String[]) list.toArray(new String[list.size()]));
        }
    }
}
