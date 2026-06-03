package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.utils.JNINamespace;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LSPreconnTask implements Runnable {
    private String a;
    private String b;
    private String c;
    private int d;
    private boolean e;
    private a f;

    public interface a {
        void a(String str, String str2, int i);
    }

    static {
        Covode.recordClassIndex(653180);
    }

    private native int nativeConnect(String str, String str2, int i, String str3, boolean z);

    @Override // java.lang.Runnable
    public void run() {
        int nativeConnect = nativeConnect(this.a, this.b, this.d, this.c, this.e);
        Log.d("LiveStrategyManager", "preConnect ret:" + nativeConnect + ", isQuic: " + this.e);
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(this.a, this.b, nativeConnect);
        }
    }

    LSPreconnTask(a aVar, String str, String str2, int i, String str3, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = z;
        this.f = aVar;
    }
}
