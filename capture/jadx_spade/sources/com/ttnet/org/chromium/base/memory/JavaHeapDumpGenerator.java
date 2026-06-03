package com.ttnet.org.chromium.base.memory;

import android.os.Debug;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.h;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class JavaHeapDumpGenerator {
    static {
        Covode.recordClassIndex(654361);
    }

    private JavaHeapDumpGenerator() {
    }

    public static boolean generateHprof(String str) {
        try {
            Debug.dumpHprofData(str);
            return true;
        } catch (IOException e) {
            h.h("JavaHprofGenerator", "Error writing to file " + str + ". Error: " + e.getMessage(), new Object[0]);
            return false;
        }
    }
}
