package com.ttnet.org.chromium.base.library_loader;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.library_loader.Linker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class LinkerJni {
    static {
        Covode.recordClassIndex(654351);
    }

    LinkerJni() {
    }

    private static native void nativeFindMemoryRegionAtRandomAddress(Linker.LibInfo libInfo, boolean z);

    private static native boolean nativeFindRegionReservedByWebViewZygote(Linker.LibInfo libInfo);

    private static native void nativeReserveMemoryForLibrary(Linker.LibInfo libInfo);
}
