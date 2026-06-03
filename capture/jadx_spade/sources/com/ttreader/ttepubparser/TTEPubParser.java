package com.ttreader.ttepubparser;

import com.bytedance.covode.number.Covode;
import com.ttreader.ttepubparser.model.EpubMetaData;
import com.ttreader.ttepubparser.model.ManifestItem;
import com.ttreader.ttepubparser.model.Navigation;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTEPubParser {
    private long a = nativeCreateInstance();

    private native boolean nativeCheckResourceExistForChapter(long j, String str, String str2);

    private native long nativeCreateInstance();

    private native void nativeDestoryInstance(long j);

    private native int nativeExtractCover(long j, String str);

    private native int nativeGetChapterCount(long j);

    private native String nativeGetChapterId(long j, int i);

    private native byte[] nativeGetContentByChapterId(long j, String str);

    private native ManifestItem nativeGetMainfestItemByChapterId(long j, String str);

    private native EpubMetaData nativeGetMetaData(long j);

    private native byte[] nativeGetNavigation(long j);

    private native String nativeGetResourceChapterId(long j, String str, String str2);

    private native int nativeOpenFile(long j, String str, boolean z);

    private native byte[] nativeReadResourceForChapter(long j, String str, String str2);

    public int c() {
        return nativeGetChapterCount(this.a);
    }

    public EpubMetaData g() {
        return nativeGetMetaData(this.a);
    }

    static {
        Covode.recordClassIndex(654698);
        System.loadLibrary("ttepubparser");
    }

    public void a() {
        long j = this.a;
        if (j == 0) {
            return;
        }
        nativeDestoryInstance(j);
        this.a = 0L;
    }

    public Navigation i() {
        byte[] nativeGetNavigation = nativeGetNavigation(this.a);
        if (nativeGetNavigation == null) {
            return new Navigation();
        }
        return Navigation.ReadStream(new DataInputStream(new ByteArrayInputStream(nativeGetNavigation)));
    }

    public int b(String str) {
        return nativeExtractCover(this.a, str);
    }

    public String d(int i) {
        return nativeGetChapterId(this.a, i);
    }

    public byte[] e(String str) {
        return nativeGetContentByChapterId(this.a, str);
    }

    public ManifestItem f(String str) {
        return nativeGetMainfestItemByChapterId(this.a, str);
    }

    public String h(String str, String str2) {
        return nativeGetResourceChapterId(this.a, str, str2);
    }

    public int j(String str, boolean z) {
        return nativeOpenFile(this.a, str, z);
    }

    public byte[] k(String str, String str2) {
        return nativeReadResourceForChapter(this.a, str, str2);
    }
}
