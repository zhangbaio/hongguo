package com.ss.vcbkit;

import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VCBaseKitLoader {
    private static volatile boolean isLibraryLoaded;

    private VCBaseKitLoader() {
    }

    static {
        Covode.recordClassIndex(652851);
        isLibraryLoaded = false;
    }

    public static synchronized boolean loadLibrary() {
        synchronized (VCBaseKitLoader.class) {
            if (isLibraryLoaded) {
                return true;
            }
            UnExpected.a();
            try {
                try {
                    System.loadLibrary("vcbasekit");
                    isLibraryLoaded = true;
                } catch (UnsatisfiedLinkError e) {
                    Log.e("vcbasekit", "Can't link vcbasekit:" + e.getMessage());
                }
            } catch (Throwable th) {
                Log.e("vcbasekit", "Can't load vcbasekit:" + th.getMessage());
            }
            return isLibraryLoaded;
        }
    }
}
