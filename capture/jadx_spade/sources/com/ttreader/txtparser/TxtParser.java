package com.ttreader.txtparser;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TxtParser {
    private final long mInstance;

    private native int nativeAnalyse(long j);

    private native long nativeCreateInstance(String str, String str2, int i, int i2, boolean z, int i3, int i4, String str3);

    private native void nativeDestroyInstance(long j);

    private native int nativeGetChapterAmount(long j);

    private native Chapter nativeGetChapterByIndx(long j, int i);

    private native String nativeGetContent(long j, int i, int i2);

    private native String nativeGetTxtName(long j);

    public int analyse() {
        return nativeAnalyse(this.mInstance);
    }

    public void destroy() {
        nativeDestroyInstance(this.mInstance);
    }

    public int getChapterAmount() {
        return nativeGetChapterAmount(this.mInstance);
    }

    public String getTxtName() {
        return nativeGetTxtName(this.mInstance);
    }

    static {
        Covode.recordClassIndex(654832);
        System.loadLibrary("TxtParser");
    }

    public Chapter getChapterByIndx(int i) {
        return nativeGetChapterByIndx(this.mInstance, i);
    }

    public String getContent(int i, int i2) {
        return nativeGetContent(this.mInstance, i, i2);
    }

    public TxtParser(String str, String str2, int i, int i2, boolean z, int i3, int i4, String str3) {
        this.mInstance = nativeCreateInstance(str, str2, i, i2, z, i3, i4, str3);
    }
}
