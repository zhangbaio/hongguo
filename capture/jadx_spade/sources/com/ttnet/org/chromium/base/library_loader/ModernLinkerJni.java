package com.ttnet.org.chromium.base.library_loader;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.library_loader.Linker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ModernLinkerJni {
    static {
        Covode.recordClassIndex(654355);
    }

    ModernLinkerJni() {
    }

    private static native int nativeGetRelroSharingResult();

    private static native boolean nativeLoadLibrary(String str, Linker.LibInfo libInfo, boolean z);

    private static native boolean nativeUseRelros(long j, Linker.LibInfo libInfo);

    public static void reportDlopenExtTime(long j) {
        a.a(j);
    }

    public static void reportIteratePhdrTime(long j) {
        a.b(j);
    }
}
