package com.ss.vcbkit;

import com.bytedance.covode.number.Covode;
import java.io.Closeable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ResourcePool implements Closeable {
    private long a = nativeCreate();

    public static final class PoolMetric {
        public int deltaMs;
        public int freeTime;
        public int hitCnt;
        public int totalCnt;
        public int totalTime;

        static {
            Covode.recordClassIndex(652847);
        }
    }

    public static final class PoolStatus {
        public int busyCount;
        public int capSize;
        public int freeCount;

        static {
            Covode.recordClassIndex(652848);
        }
    }

    static {
        Covode.recordClassIndex(652846);
    }

    private native long nativeCreate();

    private native void nativeDelete(long j);

    private native int nativeGetMetric(long j, PoolMetric poolMetric);

    private native int nativeGetStatus(long j, PoolStatus poolStatus);

    private native void nativeOnAcquire(long j, long j2);

    private native void nativeOnCreate(long j, long j2);

    private native void nativeOnDestroy(long j, long j2);

    private native void nativeOnRecycle(long j, long j2);

    private native void nativeSetMaxSize(long j, int i);

    public abstract long a();

    public abstract boolean c(int i, int i2, Object obj);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.a;
        if (j != 0) {
            nativeDelete(j);
            this.a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    private static long getId(ResourcePool resourcePool) {
        if (resourcePool != null) {
            return resourcePool.a();
        }
        return 0L;
    }

    private static boolean setPoolConfig(ResourcePool resourcePool, int i, int i2, Object obj) {
        if (resourcePool != null) {
            return resourcePool.c(i, i2, obj);
        }
        return false;
    }
}
