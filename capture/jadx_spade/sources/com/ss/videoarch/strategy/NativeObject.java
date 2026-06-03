package com.ss.videoarch.strategy;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.utils.JNINamespace;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NativeObject {
    protected long mNativeObj = 0;

    static {
        Covode.recordClassIndex(653111);
    }

    private native void nativeRelease(long j);

    private long getNativeObj() {
        return this.mNativeObj;
    }

    protected void finalize() throws Throwable {
        if (this.mNativeObj != 0) {
            release();
        }
    }

    public synchronized void release() {
        long j = this.mNativeObj;
        if (j != 0) {
            nativeRelease(j);
            this.mNativeObj = 0L;
        }
    }

    protected void setNativeObj(long j) {
        this.mNativeObj = j;
    }
}
