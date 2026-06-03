package kotlin.text;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g {
    static {
        Covode.recordClassIndex(658759);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str) {
        boolean z;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 128) < 0 && !Character.isLetter(charAt)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }
}
