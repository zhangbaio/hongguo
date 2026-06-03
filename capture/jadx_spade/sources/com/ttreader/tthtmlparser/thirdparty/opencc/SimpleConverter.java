package com.ttreader.tthtmlparser.thirdparty.opencc;

import com.bytedance.covode.number.Covode;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SimpleConverter implements Closeable {
    private long nativePtr;

    private static native String nativeConvert(long j, String str);

    private static native long nativeCreateInstance(String str);

    private static native void nativeDestroyInstance(long j);

    static {
        Covode.recordClassIndex(654783);
        System.loadLibrary("TTHtmlParser");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            long j = this.nativePtr;
            if (j != 0) {
                nativeDestroyInstance(j);
                this.nativePtr = 0L;
            }
        }
    }

    public SimpleConverter(String str) {
        this.nativePtr = nativeCreateInstance(str);
    }

    public String convert(String str) {
        synchronized (this) {
            long j = this.nativePtr;
            if (j != 0) {
                return nativeConvert(j, str);
            }
            return null;
        }
    }
}
