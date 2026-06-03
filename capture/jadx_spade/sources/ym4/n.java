package ym4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.i0;
import com.dragon.read.kmp.utils.k0;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final n a;

    static {
        Covode.recordClassIndex(608695);
        a = new n();
    }

    private n() {
    }

    public final Map<String, Object> b() {
        return k0.a.c();
    }

    public final String a(String str) {
        if (i0.a.g(str, 0) != 0) {
            return "audiobook";
        }
        return "novel";
    }
}
