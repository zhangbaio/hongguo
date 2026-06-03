package com.ttreader.tttext;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ttreader.tttext.TTTextDefinition;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTTextLayout {
    long a = CreateInstance();

    private static native void nativeInitialCache();

    native long CreateInstance();

    native long CreateRegion(long j, float f, float f2);

    native void DestroyInstance(long j);

    native int[] Layout(long j, long j2, long j3, int i, int i2);

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.a;
        if (j != 0) {
            DestroyInstance(j);
        }
    }

    static {
        Covode.recordClassIndex(654822);
        try {
            System.loadLibrary("tttext");
            nativeInitialCache();
        } catch (UnsatisfiedLinkError e) {
            Log.d("soload", e.toString());
        }
    }

    public TTTextPage a(float f, float f2) {
        return new TTTextPage(CreateRegion(this.a, f, f2), f, f2);
    }

    public TTTextDefinition.LayoutResult b(TTTextPage tTTextPage, TTTextParagraph tTTextParagraph, TTTextDefinition.b bVar) {
        TTTextDefinition.LayoutResult d;
        int[] Layout = Layout(this.a, tTTextPage.a, tTTextParagraph.c(), bVar.a, bVar.b);
        int i = Layout[0];
        if (i == -1) {
            d = TTTextDefinition.LayoutResult.kParagraphEnd;
        } else {
            d = TTTextDefinition.d(i);
        }
        bVar.a = Layout[1];
        bVar.b = Layout[2];
        return d;
    }
}
