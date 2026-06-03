package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NativeObject {
    protected long mNativeObj = 0;
    protected boolean mRetain = false;

    static {
        Covode.recordClassIndex(652148);
    }

    private native void nativeRelease(long j);

    protected void finalize() throws Throwable {
    }

    private long getNativeObj() {
        return this.mNativeObj;
    }

    public synchronized void release() {
        if (this.mRetain) {
            long j = this.mNativeObj;
            if (j != 0) {
                nativeRelease(j);
                this.mNativeObj = 0L;
            }
        }
    }

    protected void setNativeObj(long j) {
        this.mNativeObj = j;
        this.mRetain = true;
    }

    protected void setWeakNativeObj(long j) {
        this.mNativeObj = j;
        this.mRetain = false;
    }
}
