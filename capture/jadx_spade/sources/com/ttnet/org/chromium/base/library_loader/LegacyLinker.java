package com.ttnet.org.chromium.base.library_loader;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.library_loader.Linker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class LegacyLinker extends Linker {
    private static native boolean nativeAddZipArchivePath(String str);

    private static native boolean nativeCreateSharedRelro(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeUseSharedRelro(String str, Linker.LibInfo libInfo);

    LegacyLinker() {
    }

    static {
        Covode.recordClassIndex(654333);
    }
}
