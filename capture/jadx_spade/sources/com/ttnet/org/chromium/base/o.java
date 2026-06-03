package com.ttnet.org.chromium.base;

import android.os.StrictMode;
import com.bytedance.covode.number.Covode;
import java.io.Closeable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o implements Closeable {
    private final StrictMode.ThreadPolicy a;
    private final StrictMode.VmPolicy b;

    static {
        Covode.recordClassIndex(654257);
    }

    public static o a() {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new o(vmPolicy);
    }

    public static o c() {
        return new o(StrictMode.allowThreadDiskReads());
    }

    public static o d() {
        return new o(StrictMode.allowThreadDiskWrites());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        StrictMode.ThreadPolicy threadPolicy = this.a;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        StrictMode.VmPolicy vmPolicy = this.b;
        if (vmPolicy != null) {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    private o(StrictMode.ThreadPolicy threadPolicy) {
        this(threadPolicy, null);
    }

    private o(StrictMode.VmPolicy vmPolicy) {
        this(null, vmPolicy);
    }

    private o(StrictMode.ThreadPolicy threadPolicy, StrictMode.VmPolicy vmPolicy) {
        this.a = threadPolicy;
        this.b = vmPolicy;
    }
}
