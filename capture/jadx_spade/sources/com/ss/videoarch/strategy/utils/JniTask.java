package com.ss.videoarch.strategy.utils;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.network.e;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JniTask {
    private e a = new e();

    static {
        Covode.recordClassIndex(653223);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStart(boolean z);

    private static class b {
        private static final JniTask a;

        static {
            Covode.recordClassIndex(653224);
            a = new JniTask();
        }
    }

    class a implements Runnable {
        final /* synthetic */ boolean a;

        @Override // java.lang.Runnable
        public void run() {
            JniTask.this.nativeStart(this.a);
        }

        a(boolean z) {
            this.a = z;
        }
    }

    public static JniTask c() {
        return b.a;
    }

    public void a() {
        boolean z = true;
        if (lj6.a.m().V != 1) {
            z = false;
        }
        Log.d("JniTaskQueue", "enableJniThread:" + z);
        this.a.a(new a(z));
    }
}
