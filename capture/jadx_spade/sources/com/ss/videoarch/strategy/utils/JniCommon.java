package com.ss.videoarch.strategy.utils;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JniCommon {
    static {
        Covode.recordClassIndex(653222);
    }

    public static native void nativeAddRef(long j);

    public static native ByteBuffer nativeAllocateByteBuffer(int i);

    public static native void nativeFreeByteBuffer(ByteBuffer byteBuffer);

    public static native void nativeReleaseRef(long j);
}
