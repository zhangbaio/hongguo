package com.tokenizer;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Tokenizer {
    private long a = nativeCreateInstance();

    private native long nativeCreateInstance();

    private native int[] nativeFindSentenceContainPositionInText(long j, String str, int i, int[] iArr);

    private native void nativeInitialze(long j, String str);

    private native ArrayList<String> nativeTokenizeSentence(long j, String str);

    static {
        Covode.recordClassIndex(654020);
        System.loadLibrary("tokenizer");
    }

    public void a(String str) {
        nativeInitialze(this.a, str);
    }

    public ArrayList<String> b(String str) {
        return nativeTokenizeSentence(this.a, str);
    }

    public int[] c(String str, int i, int[] iArr) {
        return nativeFindSentenceContainPositionInText(this.a, str, i, iArr);
    }
}
